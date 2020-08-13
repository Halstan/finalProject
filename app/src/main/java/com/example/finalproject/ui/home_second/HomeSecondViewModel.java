package com.example.finalproject.ui.home_second;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeSecondViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeSecondViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home second fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}