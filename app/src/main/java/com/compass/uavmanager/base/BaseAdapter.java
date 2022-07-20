package com.compass.uavmanager.base;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import java.util.List;

public abstract class BaseAdapter<T,V extends ViewBinding> extends RecyclerView.Adapter<BaseHolder> {
    private List<T> data;

    public void setData(List<T> data){
        this.data = data;
    }
    @NonNull
    @Override
    public BaseHolder<V> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BaseHolder(onBindingView(viewGroup));
    }
 
    @Override
    public void onBindViewHolder(@NonNull BaseHolder holder, int position) {
//        onBindingData(holder,data.get(position),position);
        onBindingData(holder,null,position);
    }
 
    protected abstract void onBindingData(BaseHolder<V> holder, T t, int position);
    protected abstract V onBindingView(ViewGroup viewGroup);
 
    @Override
    public int getItemCount() {
//        return data==null?0:data.size();
        return 8;
    }
}
