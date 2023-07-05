package com.compass.uavmanager.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.compass.uavmanager.R;
import com.compass.uavmanager.activity.EquipmentDetailsActivity;
import com.compass.uavmanager.activity.LiveShowActivity;
import com.compass.uavmanager.api.BaseUrl;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemEquipmentTypeBinding;
import com.compass.uavmanager.databinding.ItemProjectAirBinding;
import com.compass.uavmanager.entity.EquipmentResult;
import com.compass.uavmanager.entity.HomeProject;
import com.compass.uavmanager.tools.ToastUtil;

import java.util.List;


/**
 * 设备状态
 */

public class ProjectAirAdapter extends BaseAdapter<String, ItemProjectAirBinding> {
    Context context;

    public ProjectAirAdapter(Context context) {
        this.context = context;
    }

    List<HomeProject.ResultsDTO.UavDataVosDTO> results;

    @Override
    protected void onBindingData(BaseHolder<ItemProjectAirBinding> holder, String s, int position) {
        holder.getViewBinding().layoutAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(results.get(position).getUavCode())){
                    ToastUtil.showToast("无人机编码获取失败");
                }else{
                    LiveShowActivity.actionStart(context,results.get(position).getUavCode());
                }
            }
        });
        Glide.with(context).
                load(BaseUrl.ipAddress2 + "/oauth/image" + results.get(position).getPicUrl())
                .into(holder.getViewBinding().ivAir);
        holder.getViewBinding().tvAirName.setText(results.get(position).getUavName());
        holder.getViewBinding().tvAirDepart.setText(results.get(position).getDepartmentName());
        if (results.get(position).getUavIsOnLine()==1){
            holder.getViewBinding().tvAirStatus.setTextColor(context.getResources().getColor(R.color.grey));
            holder.getViewBinding().tvAirStatus.setText("离线");
//            holder.getViewBinding().layoutAir.setClickable(false);
        }else{
            holder.getViewBinding().tvAirStatus.setTextColor(context.getResources().getColor(R.color.blue));
            holder.getViewBinding().tvAirStatus.setText("在线");
//            holder.getViewBinding().layoutAir.setClickable(true);

        }
    }

    @Override
    protected ItemProjectAirBinding onBindingView(ViewGroup viewGroup) {
        ItemProjectAirBinding itemEquipmentTypeBinding = ItemProjectAirBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemEquipmentTypeBinding;
    }

    public void setDatas(List<HomeProject.ResultsDTO.UavDataVosDTO> results
    ) {
        this.results = results;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (results == null || results.size() == 0) {
            return 0;
        } else {
            return results.size();
        }
    }
}