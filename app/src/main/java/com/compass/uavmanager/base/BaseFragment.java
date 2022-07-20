package com.compass.uavmanager.base;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;


/**
 * Created by James on 2022/6/22.
 */

public abstract class BaseFragment<T extends ViewBinding> extends Fragment {

    private T mBinding;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = getViewBinding(inflater, container,savedInstanceState);
        return mBinding.getRoot();
    }


    @Override
    public void onResume() {
        super.onResume();
        initDatas();
    }

    public abstract T getViewBinding(LayoutInflater layoutInflater, ViewGroup container,Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding=null;
    }



    /**
     * 获取数据
     */
    protected abstract void initDatas();


}
