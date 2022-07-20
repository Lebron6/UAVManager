package com.compass.uavmanager.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemEquipmentTypeBinding;

/**
 * 设备状态
 */

public class EquipmentTypeAdapter extends BaseAdapter<String, ItemEquipmentTypeBinding> {


    @Override
    protected void onBindingData(BaseHolder<ItemEquipmentTypeBinding> holder, String s, int position) {
//        holder.getViewBinding().tvTest.setText("111111");
    }

    @Override
    protected ItemEquipmentTypeBinding onBindingView(ViewGroup viewGroup) {
        ItemEquipmentTypeBinding itemEquipmentTypeBinding = ItemEquipmentTypeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemEquipmentTypeBinding;
    }
}