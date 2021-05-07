package com.kirshi.simple.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kirshi.framework.base.BaseFragment;
import com.kirshi.simple.R;
import com.kirshi.simple.databinding.FragmentHomeBinding;


public class HomeFragment extends BaseFragment<FragmentHomeBinding> {

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void inCreateView() {

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        v.tvHome.setText(R.string.do_not_stop_believing);
    }

}