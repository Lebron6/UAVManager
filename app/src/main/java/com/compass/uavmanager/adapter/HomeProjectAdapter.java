package com.compass.uavmanager.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemHomeProjectBinding;

import java.util.List;

/**
 * 首页项目
 */

public class HomeProjectAdapter extends BaseAdapter<String, ItemHomeProjectBinding> {


    @Override
    protected void onBindingData(BaseHolder<ItemHomeProjectBinding> holder, String s, int position) {
//        holder.getViewBinding().tvTest.setText("111111");
    }

    @Override
    protected ItemHomeProjectBinding onBindingView(ViewGroup viewGroup) {
        ItemHomeProjectBinding itemHomeProjectBinding = ItemHomeProjectBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemHomeProjectBinding;
    }
}