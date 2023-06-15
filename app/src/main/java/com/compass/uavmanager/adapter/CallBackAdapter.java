package com.compass.uavmanager.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemCallbackBinding;
import com.compass.uavmanager.entity.CallBackResult;


/**
 * 回复
 */

public class CallBackAdapter extends BaseAdapter<String, ItemCallbackBinding> {

    CallBackResult callBackResult;
    @Override
    protected void onBindingData(BaseHolder<ItemCallbackBinding> holder, String s, int position) {
        holder.getViewBinding().tvCallbackName.setText(callBackResult.getResults().get(position).getName()+"：");
        holder.getViewBinding().tvCallInfo.setText(callBackResult.getResults().get(position).getReplyinfo());

    }

    @Override
    protected ItemCallbackBinding onBindingView(ViewGroup viewGroup) {
        ItemCallbackBinding itemCallbackBinding = ItemCallbackBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemCallbackBinding;
    }

    public void setData(CallBackResult callBackResult) {
this.callBackResult=callBackResult;
    }

    @Override
    public int getItemCount() {
        if (callBackResult!=null&&callBackResult.getResults()!=null){
            return callBackResult.getResults().size();
        }else{
            return 0;
        }
    }
}