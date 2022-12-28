package com.compass.uavmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.compass.uavmanager.R;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemHomeProjectBinding;
import com.compass.uavmanager.entity.HomeProject;

import java.util.List;

/**
 * 首页项目
 */

public class HomeProjectAdapter extends BaseAdapter<String, ItemHomeProjectBinding> {
    Context context;
    public HomeProjectAdapter(Context context) {
        this.context = context;
    }

    @Override
    protected void onBindingData(BaseHolder<ItemHomeProjectBinding> holder, String s, int position) {
        holder.getViewBinding().tvName.setText(results.get(position).getUpdateBy()+"");
        holder.getViewBinding().tvProjectName.setText(results.get(position).getProjectName()+"");
        if (results.get(position).getProjectState().equals("0")){
            holder.getViewBinding().tvStatus.setText("进行中");
            holder.getViewBinding().tvStatus.setTextColor(context.getResources().getColor(R.color.teal_200));
        }else{
            holder.getViewBinding().tvStatus.setText("已归档");
            holder.getViewBinding().tvStatus.setTextColor(context.getResources().getColor(R.color.grey));

        }
    }

    @Override
    protected ItemHomeProjectBinding onBindingView(ViewGroup viewGroup) {
        ItemHomeProjectBinding itemHomeProjectBinding = ItemHomeProjectBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemHomeProjectBinding;
    }

    @Override
    public int getItemCount() {
        if (results==null||results.size()==0){
            return 0;
        }else{
            return results.size();
        }
    }
    List<HomeProject.ResultsDTO> results;
    public void setData(List<HomeProject.ResultsDTO> results) {
        this.results=results;
        notifyDataSetChanged();
    }
}