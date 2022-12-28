package com.compass.uavmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.compass.uavmanager.R;
import com.compass.uavmanager.activity.EquipmentDetailsActivity;
import com.compass.uavmanager.api.BaseUrl;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemEquipmentTypeBinding;
import com.compass.uavmanager.entity.EquipmentResult;

import java.util.List;


/**
 * 设备状态
 */

public class EquipmentTypeAdapter extends BaseAdapter<String, ItemEquipmentTypeBinding> {
    Context context;

    public EquipmentTypeAdapter(Context context) {
        this.context = context;
    }

    List<EquipmentResult.ResultsDTO> datas;

    @Override
    protected void onBindingData(BaseHolder<ItemEquipmentTypeBinding> holder, String s, int position) {
        holder.getViewBinding().layoutTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EquipmentDetailsActivity.actionStart(context,datas.get(position).getUavVo().getName()+"");
            }
        });
        Glide.with(context).
                load(BaseUrl.ipAddress2 + "/oauth/image" + datas.get(position).getUavVo().getPicUrl())
                .into(holder.getViewBinding().ivEq);
        holder.getViewBinding().tvEqNum.setText(datas.get(position).getUavVo().getUavName());
        holder.getViewBinding().tvBrand.setText("品牌：" + datas.get(position).getUavVo().getUavBrand() + " - " + datas.get(position).getUavVo().getUavType());
        holder.getViewBinding().tvSn.setText(datas.get(position).getUavVo().getUavSn());
        holder.getViewBinding().tvStartTime.setText("创建时间：" + datas.get(position).getUavVo().getCreateTime());
        if (datas.get(position).getUavVo().getStatus().equals("离线")) {
            holder.getViewBinding().tvEquStatus.setTextColor(context.getResources().getColor(R.color.grey));
        } else {
            holder.getViewBinding().tvEquStatus.setTextColor(context.getResources().getColor(R.color.text_blue));
        }
        holder.getViewBinding().tvEquStatus.setText(datas.get(position).getUavVo().getStatus());

    }

    @Override
    protected ItemEquipmentTypeBinding onBindingView(ViewGroup viewGroup) {
        ItemEquipmentTypeBinding itemEquipmentTypeBinding = ItemEquipmentTypeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemEquipmentTypeBinding;
    }

    public void setData(List<EquipmentResult.ResultsDTO> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    ;

    @Override
    public int getItemCount() {
        if (datas == null || datas.size() == 0) {
            return 0;
        } else {
            return datas.size();
        }
    }
}