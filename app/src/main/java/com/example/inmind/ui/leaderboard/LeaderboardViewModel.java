package com.example.inmind.ui.leaderboard;

import androidx.lifecycle.ViewModel;

public class LeaderboardViewModel extends ViewModel {

//    private final MutableLiveData<String> mText;
    String Employee;
    String Score;

//    public LeaderboardViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("Leaderboard ");
//
//    }
    //    public LiveData<String> getText() {
//        return mText;
//    }


    public LeaderboardViewModel(String Employee, String Score){
        this.Employee = Employee;
        this.Score = Score;
    }

    public String getEmployee(){
        return Employee;
    }

    public String getScore(){
        return Score;
    }






}