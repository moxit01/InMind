package com.example.inmind.ui.home;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.inmind.R;
import com.example.inmind.databinding.FragmentHomeBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;

;

public class HomeFragment extends Fragment {

    public int counter = 290;
    Button startbtn, stopbtn;
    TextView timerview, score_tv;
    NotificationManagerCompat nmc ;
    Notification notify;



    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        startbtn =(Button) view.findViewById(R.id.startbtn);
        stopbtn = (Button) view.findViewById(R.id.stopbtn);
        timerview = (TextView) view.findViewById(R.id.timerview);
        score_tv = (TextView) view.findViewById(R.id.Score_tv);




        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CountDownTimer time = new CountDownTimer(1500000, 1000) {
                    public void onTick(long millisUntilFinished) {
//                        timerview.setText(String.valueOf(counter));
//                        counter++;

                        NumberFormat f = new DecimalFormat("00");
                        long hour = (millisUntilFinished / 3600000) % 24;
                        long min = (millisUntilFinished / 60000) % 60;
                        long sec = (millisUntilFinished / 1000) % 60;

                        timerview.setText(f.format(hour) + ":" + f.format(min) + ":" + f.format(sec));


                    }

                    public void onFinish() {



                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                            NotificationChannel channel = new NotificationChannel("ch", "Inmind", NotificationManager.IMPORTANCE_DEFAULT);
                            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
                            manager.createNotificationChannel(channel);

                        }

                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(), "ch")
                                .setSmallIcon(android.R.drawable.stat_notify_sync)
                                .setContentTitle("Water Reminder")
                                .setContentText("This is a water reminder! Time to take a rest for 5 minutes");

                        notify = builder.build();
                        nmc = NotificationManagerCompat.from(getActivity());



//                        String message="Hello";
//                        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity(),"My Notification");
//                        builder.setContentTitle("Notification");
//                        builder.setContentText(message);
//                        builder.setSmallIcon(R.drawable.ic_notifications_black_24dp);
//                        builder.setAutoCancel(true);
//                        builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
//                        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(getActivity());
//                        managerCompat.notify(1,builder.build());
                        timerview.setText("00:00:00");


                    }
                }.start();

                stopbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        time.cancel();
                        timerview.setText("00:00:00");
                    }
                });


            }
        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}