package com.example.maps.ui.traffic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrafficViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TrafficViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Traffic fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
