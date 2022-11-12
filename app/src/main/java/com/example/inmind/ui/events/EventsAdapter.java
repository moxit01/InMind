package com.example.inmind.ui.events;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inmind.R;

import java.util.List;

    public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.ViewHolder> {

        Context c;
        List<EventsViewModel> eventsViewModelList;


        public EventsAdapter(Context c, List<EventsViewModel> eventsViewModelList) {
            this.c = c;
            this.eventsViewModelList = eventsViewModelList;
        }

        @NonNull
        @Override
        public EventsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(c).inflate(R.layout.events_item, parent, false);
            return new EventsAdapter.ViewHolder(view);

        }

        @Override
        public void onBindViewHolder(@NonNull EventsAdapter.ViewHolder holder, int position) {


            if (eventsViewModelList != null &&  eventsViewModelList.size() > 0) {
                EventsViewModel model = eventsViewModelList.get(position);
                holder.event_tv.setText(model.getEvent());
            } else {
                return;
            }


        }

        @Override
        public int getItemCount() {
            return eventsViewModelList.size();
        }


        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView event_tv;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                event_tv = itemView.findViewById(R.id.Employee_tv);

            }

        }


    }




