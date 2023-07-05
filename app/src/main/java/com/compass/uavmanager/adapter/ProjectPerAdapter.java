package com.compass.uavmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.compass.uavmanager.R;
import com.compass.uavmanager.api.BaseUrl;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemProjectPerBinding;
import com.compass.uavmanager.databinding.ItemProjectPerBinding;
import com.compass.uavmanager.entity.HomeProject;
import com.compass.uavmanager.fragment.PersonalFragment;
import com.compass.uavmanager.tools.ToastUtil;

import java.util.List;


/**
 * 设备状态
 */

public class ProjectPerAdapter extends BaseAdapter<String, ItemProjectPerBinding> {
    Context context;

    public ProjectPerAdapter(Context context) {
        this.context = context;
    }

    List<HomeProject.ResultsDTO.UserDosDTO> results;

    @Override
    protected void onBindingData(BaseHolder<ItemProjectPerBinding> holder, String s, int position) {
        holder.getViewBinding().layoutAir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                EquipmentDetailsActivity.actionStart(context,results.get(position).getUavVo().getName()+"");
            }
        });
        RequestOptions requestOptions = RequestOptions.circleCropTransform();
        Glide.with(context).applyDefaultRequestOptions(requestOptions).
                load(BaseUrl.ipAddress2 + "/oauth/image" + results.get(position).getUserImagePath())
                .into(holder.getViewBinding().ivPer);
        holder.getViewBinding().tvName.setText(results.get(position).getUsername());
        if (results.get(position).getOnlineStatus().equals("1")){
            holder.getViewBinding().tvStatus.setTextColor(context.getResources().getColor(R.color.grey));
            holder.getViewBinding().tvStatus.setText("离线");
        }else{
            holder.getViewBinding().tvStatus.setTextColor(context.getResources().getColor(R.color.blue));
            holder.getViewBinding().tvStatus.setText("在线");
        }
    }

    @Override
    protected ItemProjectPerBinding onBindingView(ViewGroup viewGroup) {
        ItemProjectPerBinding itemEquipmentTypeBinding = ItemProjectPerBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemEquipmentTypeBinding;
    }

    public void setDatas(List<HomeProject.ResultsDTO.UserDosDTO> results
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