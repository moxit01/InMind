package com.example.inmind.ui.events;

import androidx.lifecycle.ViewModel;

public class EventsViewModel extends ViewModel {

//    private final MutableLiveData<String> mText;
    String event;

    public EventsViewModel(String event) {
//        mText = new MutableLiveData<>();
//        mText.setValue("events");
        this.event = event;
    }



//    public LiveData<String> getText() {
//        return mText;
//    }




    public String getEvent(){
        return event;
    }


}