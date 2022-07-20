package com.compass.uavmanager.base;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

public class BaseHolder<V extends ViewBinding> extends RecyclerView.ViewHolder {
    private V viewBinding;
 
    public BaseHolder(V viewBinding) {
        super(viewBinding.getRoot());
        this.viewBinding = viewBinding;
    }
 
    public V getViewBinding() {
        return viewBinding;
    }
}
