package com.compass.uavmanager.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import org.greenrobot.eventbus.EventBus;


/**
 * Created by James on 2022/6/22.
 */

public abstract class BaseFragment<T extends ViewBinding> extends Fragment {

    private T mBinding;
    protected boolean useEventBus = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = getViewBinding(inflater, container,savedInstanceState);
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        initDatas();
        return mBinding.getRoot();
    }

    public abstract boolean useEventBus();


    @Override
    public void onResume() {
        super.onResume();
    }

    public abstract T getViewBinding(LayoutInflater layoutInflater, ViewGroup container,Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBinding=null;
        if (useEventBus == true) {
            EventBus.getDefault().unregister(this);
        }
    }



    /**
     * 获取数据
     */
    protected abstract void initDatas();


}
