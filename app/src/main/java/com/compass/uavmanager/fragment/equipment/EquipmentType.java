package com.compass.uavmanager.fragment.equipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.adapter.EquipmentTypeAdapter;
import com.compass.uavmanager.adapter.HomeProjectAdapter;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentEquipmentTypeBinding;
import com.compass.uavmanager.databinding.FragmentGalleryBinding;
import com.compass.uavmanager.tools.RecyclerViewHelper;

/**
 * 设备状态
 */
public class EquipmentType extends BaseFragment {

    private int type;

    public EquipmentType(int type) {
        this.type=type;
    }

    FragmentEquipmentTypeBinding mBinding;

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentEquipmentTypeBinding.inflate(layoutInflater, container, false);
        return mBinding;
    }

    @Override
    protected void initDatas() {
        EquipmentTypeAdapter adapter = new EquipmentTypeAdapter();
        RecyclerViewHelper.initRecyclerViewV(getActivity(), mBinding.rvEquipmentType, false, adapter);
    }
}
