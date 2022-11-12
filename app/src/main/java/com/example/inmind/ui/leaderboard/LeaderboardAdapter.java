package com.example.inmind.ui.leaderboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inmind.R;

import java.util.List;

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.ViewHolder> {

    Context c;
    List<LeaderboardViewModel> leaderboardViewModelList;


    public LeaderboardAdapter(Context c, List<LeaderboardViewModel> leaderboardViewModelList){
        this.c = c;
        this.leaderboardViewModelList = leaderboardViewModelList;
    }

    @NonNull
    @Override
    public LeaderboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(c).inflate(R.layout.leaderboard_item,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull LeaderboardAdapter.ViewHolder holder, int position) {


        if (leaderboardViewModelList !=null && leaderboardViewModelList.size()>0){
            LeaderboardViewModel model = leaderboardViewModelList.get(position);
            holder.Employee_tv.setText(model.getEmployee());
            holder.Score_tv.setText(model.getScore());
        }
        else{
            return;
        }


    }

    @Override
    public int getItemCount() {
        return leaderboardViewModelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView Employee_tv, Score_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Employee_tv = itemView.findViewById(R.id.Employee_tv);
            Score_tv = itemView.findViewById(R.id.Score_tv);
        }

    }



}
