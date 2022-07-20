package com.compass.uavmanager.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemEquipmentTypeBinding;
import com.compass.uavmanager.databinding.ItemGalleryBinding;

/**
 * 相册
 */

public class GalleryAdapter extends BaseAdapter<String, ItemGalleryBinding> {


    @Override
    protected void onBindingData(BaseHolder<ItemGalleryBinding> holder, String s, int position) {
//        holder.getViewBinding().tvTest.setText("111111");
    }

    @Override
    protected ItemGalleryBinding onBindingView(ViewGroup viewGroup) {
        ItemGalleryBinding itemGalleryBinding = ItemGalleryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemGalleryBinding;
    }
}