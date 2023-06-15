package com.compass.uavmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.compass.uavmanager.activity.MessageDetatisActivity;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemMessageBinding;
import com.compass.uavmanager.entity.MessageResult;

import java.util.List;


/**
 * 消息
 */

public class MessageAdapter extends BaseAdapter<String, ItemMessageBinding> {

    Context context;

    public MessageAdapter(Context context) {
        this.context = context;
    }

    List<MessageResult.ResultsDTO> datas;

    @Override
    protected void onBindingData(BaseHolder<ItemMessageBinding> holder, String s, int position) {
//        CallBackAdapter adapter = new CallBackAdapter();
//        RecyclerViewHelper.initRecyclerViewV(context, holder.getViewBinding().rvCallback, false, adapter);
        holder.getViewBinding().tvTitle.setText(datas.get(position).getAnnunciateTheme() + "");
        holder.getViewBinding().tvTime.setText(datas.get(position).getCreatetime() + "");
        holder.getViewBinding().tvTaskInfo.setText(datas.get(position).getAnnunciateInfo() + "");
        holder.getViewBinding().tvName.setText(datas.get(position).getCreateby() + "");
        holder.getViewBinding().layoutCallback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MessageDetatisActivity.actionStart(context,
                        datas.get(position).getId()+"",datas.get(position).getAnnunciateTheme()
                ,datas.get(position).getCreateby(),datas.get(position).getAnnunciateInfo()
                ,datas.get(position).getCreatetime());
            }
        });
    }

    @Override
    protected ItemMessageBinding onBindingView(ViewGroup viewGroup) {
        ItemMessageBinding itemMessageBinding = ItemMessageBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemMessageBinding;
    }

    public void setData(List<MessageResult.ResultsDTO> datas) {
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