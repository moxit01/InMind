package com.example.inmind.ui.events;

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
import com.example.inmind.databinding.FragmentEventsBinding;

import java.util.ArrayList;
import java.util.List;

public class EventsFragment extends Fragment {

    private FragmentEventsBinding binding;
    TableLayout leadtable;
    RecyclerView recyclerView;
    EventsAdapter ea;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        com.example.inmind.ui.events.EventsViewModel eventsViewModel =
//                new ViewModelProvider(this).get(com.example.inmind.ui.events.EventsViewModel.class);

        binding = FragmentEventsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textEvents;
//        eventsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = (RecyclerView) view.findViewById(R.id.eventrecyclerview);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        ea = new EventsAdapter(view.getContext(), getList());
        recyclerView.setAdapter(ea);


    }


    public List<EventsViewModel> getList(){
        List<EventsViewModel> list = new ArrayList<>();
        list.add(new EventsViewModel("TechFest"));
        list.add(new EventsViewModel("Business Innovation"));
        list.add(new EventsViewModel("New year Eve"));
        return  list;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}