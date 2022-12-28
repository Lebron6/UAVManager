package com.compass.uavmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bumptech.glide.Glide;
import com.compass.uavmanager.base.BaseAdapter;
import com.compass.uavmanager.base.BaseHolder;
import com.compass.uavmanager.databinding.ItemGalleryBinding;
import com.compass.uavmanager.entity.GetMediaData;

import java.util.List;

/**
 * 相册
 */

public class GalleryAdapter extends BaseAdapter<String, ItemGalleryBinding> {
    public GalleryAdapter(Context context) {
        this.context = context;
    }

    Context context;
    List<GetMediaData.ResultsDTO> datas;

    @Override
    protected void onBindingData(BaseHolder<ItemGalleryBinding> holder, String s, int position) {
        Glide.with(context).
                load(datas.get(position).getThumPath())
                .into(holder.getViewBinding().ivGallery);
        holder.getViewBinding().tvTime.setText(datas.get(position).getCreateTime());
        holder.getViewBinding().tvName.setText(datas.get(position).getFileName());
    }

    @Override
    protected ItemGalleryBinding onBindingView(ViewGroup viewGroup) {
        ItemGalleryBinding itemGalleryBinding = ItemGalleryBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return itemGalleryBinding;
    }

    public void setData(List<GetMediaData.ResultsDTO> datas) {
        this.datas = datas;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (datas == null || datas.size() == 0) {
            return 0;
        } else {
            return datas.size();
        }
    }
}