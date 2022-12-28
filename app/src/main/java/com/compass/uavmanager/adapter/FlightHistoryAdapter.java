package com.compass.uavmanager.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.compass.uavmanager.activity.FlightHistoryActivity;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemFlightHistoryBinding;
import com.compass.uavmanager.entity.FlightHistoryList;

import java.util.List;


/**
 * 设备状态
 */

public class FlightHistoryAdapter extends BaseAdapter<String, ItemFlightHistoryBinding> {
    Context context;
    public FlightHistoryAdapter(Context context) {
        this.context=context;
    }
    List<FlightHistoryList.ResultsDTO> datas;
    @Override
    protected void onBindingData(BaseHolder<ItemFlightHistoryBinding> holder, String s, int position) {
        holder.getViewBinding().layoutTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FlightHistoryActivity.actionStart(context,datas.get(position).getId()+"");
            }
        });
        holder.getViewBinding().tvTitle.setText(datas.get(position).getUavName());
        if (!TextUtils.isEmpty(datas.get(position).getOperator())){
            holder.getViewBinding().tvName.setText(datas.get(position).getOperator()+"   ");
        }
        holder.getViewBinding().tvDepart.setText("飞行地点："+datas.get(position).getAddress());
        holder.getViewBinding().tvDis.setText("飞行方式："+datas.get(position).getFlightModel());
        holder.getViewBinding().tvLong.setText("飞行时长："+datas.get(position).getFlyingTime());
        holder.getViewBinding().tvTime.setText(datas.get(position).getFlightTime());

    }

    @Override
    protected ItemFlightHistoryBinding onBindingView(ViewGroup viewGroup) {
        ItemFlightHistoryBinding itemFlightHistoryBinding = ItemFlightHistoryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemFlightHistoryBinding;
    }

    public void setData(List<FlightHistoryList.ResultsDTO> datas){
        this.datas=datas;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        if (datas==null||datas.size()==0){
            return 0;
        }else{
            return datas.size();
        }
    }
}