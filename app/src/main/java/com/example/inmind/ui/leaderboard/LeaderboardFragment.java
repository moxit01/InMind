package com.example.inmind.ui.leaderboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inmind.R;
import com.example.inmind.databinding.FragmentLeaderboardBinding;

import java.util.ArrayList;
import java.util.List;


public class LeaderboardFragment extends Fragment {

    private FragmentLeaderboardBinding binding;
    TableLayout leadtable;
    RecyclerView recyclerView;
    LeaderboardAdapter la;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        LeaderboardViewModel LeaderboardViewModel =
//                new ViewModelProvider(this).get(LeaderboardViewModel.class);

        binding = FragmentLeaderboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textLeaderboard;
//        LeaderboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        la = new LeaderboardAdapter(view.getContext(), getList());
        recyclerView.setAdapter(la);


    }


    public List<LeaderboardViewModel> getList(){
        List<LeaderboardViewModel> list = new ArrayList<>();
        list.add(new LeaderboardViewModel("Moxit", "300"));
        list.add(new LeaderboardViewModel("Giselle", "200"));
        list.add(new LeaderboardViewModel("John", "100"));
        return  list;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}