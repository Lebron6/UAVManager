package com.compass.uavmanager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.compass.uavmanager.R;

/**
 *自定义地图弹框adapter
 * @author hk
 */
public class MapProjectAdapter implements AMap.InfoWindowAdapter, View.OnClickListener {
    private Context mContext;
    private LatLng latLng;
    private TextView mTvName,mTvStatus;
    private ImageView mIvLogo;
    private String mSnippet,mTitle;
    @Override
    public View getInfoWindow(Marker marker) {
        initData(marker);
        View view = initView();
        return view;
    }

    @Override
    public View getInfoContents(Marker marker) {
        return null; //因为是自定义的布局，返回null
    }

    public MapProjectAdapter(Context context) {
        mContext = context;
    }

    private void initData(Marker marker) {
        //当前点位经纬度
        latLng = marker.getPosition();
        //当前点位带的消息信息  也可通过这个传输数据把数据转成json
        mSnippet = marker.getSnippet();
        //当前点位带的标题信息
        mTitle = marker.getTitle();
    }

    @NonNull
    private View initView() {
        //获取自定义的布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.view_info_window, null);
        mTvName = (TextView) view.findViewById(R.id.tv_name);
        mTvStatus= (TextView) view.findViewById(R.id.tv_status);
        mIvLogo= (ImageView) view.findViewById(R.id.iv_logo);
        mTvName.setText(mTitle);
        mTvStatus.setText(mSnippet);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.iv_left:
//                Toast.makeText(mContext,"我是左边按钮点击事件",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.iv_right:
//                Toast.makeText(mContext,"我是右边按钮点击事件",Toast.LENGTH_SHORT).show();
//                break;
        }
 
    }
}