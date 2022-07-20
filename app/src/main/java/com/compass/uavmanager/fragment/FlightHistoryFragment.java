package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.R;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentFlightBinding;

/**
 * 飞行历史
 */
public class FlightHistoryFragment extends BaseFragment {

FragmentFlightBinding mBinding;
    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding=FragmentFlightBinding.inflate(layoutInflater,container,false);
        return mBinding;
    }

    @Override
    protected void initDatas() {

    }
}
