package com.example.finalproject.ui.home_second;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.finalproject.R;

public class HomeSecondFragment extends Fragment {

    private HomeSecondViewModel homeSecondViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeSecondViewModel =
                ViewModelProviders.of(this).get(HomeSecondViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home_second, container, false);

        return root;
    }
}
