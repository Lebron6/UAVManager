package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.R;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentHomeBinding;
import com.compass.uavmanager.databinding.FragmentPersonalBinding;

/**
 * 个人中心
 */
public class PersonalFragment extends BaseFragment {

    FragmentPersonalBinding mBinding;
    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentPersonalBinding.inflate(layoutInflater, container, false);
        return mBinding;
    }

    @Override
    protected void initDatas() {

    }
}
