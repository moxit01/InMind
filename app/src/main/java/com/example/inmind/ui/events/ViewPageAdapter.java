package com.example.inmind.ui.events;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class ViewPageAdapter extends FragmentStateAdapter {

    ArrayList<String> texts;
    Context c;


//    public ViewPageAdapter(FragmentManager fm) {
//        super(fm);
//        this.texts = texts;
//        this.c = c;
//    }
    public ViewPageAdapter(FragmentManager fm, Context c, ArrayList<String> texts, Lifecycle lifecycle) {
        super(fm,lifecycle);
        this.texts = texts;
        this.c = c;
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        MyViewPagerFrag myFragment=new MyViewPagerFrag();
        Bundle b= new Bundle();
        b.putString("Event_Name",texts.get(position));
        myFragment.setArguments(b);
        return myFragment;

    }

    @Override
    public int getItemCount() {
        return texts.size();
    }
}
