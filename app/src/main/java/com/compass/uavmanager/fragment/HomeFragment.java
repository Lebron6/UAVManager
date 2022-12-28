package com.compass.uavmanager.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewbinding.ViewBinding;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.compass.uavmanager.R;
import com.compass.uavmanager.activity.LiveShowActivity;
import com.compass.uavmanager.adapter.HomeProjectAdapter;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentHomeBinding;
import com.compass.uavmanager.entity.HomeProject;
import com.compass.uavmanager.entity.OverView;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.compass.uavmanager.tools.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {

    FragmentHomeBinding mBinding;
    AMap aMap;

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(layoutInflater, container, false);
        mBinding.mapView.onCreate(savedInstanceState);
        aMap = mBinding.mapView.getMap();
        initView();
        return mBinding;
    }

    private void initView() {

        mBinding.layoutProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBinding.rvProject.getVisibility() == View.VISIBLE) {
                    mBinding.rvProject.setVisibility(View.GONE);
                    mBinding.ivPoint.setBackgroundDrawable(getActivity().getDrawable(R.mipmap.ic_home_project_up));
                } else {
                    mBinding.rvProject.setVisibility(View.VISIBLE);
                    mBinding.ivPoint.setBackgroundDrawable(getActivity().getDrawable(R.mipmap.ic_home_project_down));
                }
            }
        });
        aMap.setOnMarkerClickListener(new AMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (!TextUtils.isEmpty(marker.getSnippet())){
                    LiveShowActivity.actionStart(getActivity(),marker.getSnippet());
                }else{
                    ToastUtil.showToast("获取设备SN失败");
                }
                return true;
            }
        });
    }

    HomeProjectAdapter adapter;

    @Override
    protected void initDatas() {
        adapter = new HomeProjectAdapter(getActivity());
        RecyclerViewHelper.initRecyclerViewG(getActivity(), mBinding.rvProject, adapter, 2);
        getHomeProjectData();
        getOverViewData();
    }

    private void getHomeProjectData() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().manageProject(PreferenceUtils.getInstance().getUserToken()).enqueue(new Callback<HomeProject>() {
            @Override
            public void onResponse(Call<HomeProject> call, Response<HomeProject> response) {
                if (response.body() != null && response.body().getCode().equals("200")) {
                    adapter.setData(response.body().getResults());
                    aMap.moveCamera(CameraUpdateFactory.newCameraPosition(
                            CameraPosition.fromLatLngZoom(
                                    new LatLng(
                                            Double.valueOf(response.body().getResults().get(0).getLatitude()),
                                            Double.valueOf(response.body().getResults().get(0).getLongitude())),
                                    12)));
                    for (int i = 0; i < response.body().getResults().size(); i++) {
                        LatLng latLng = new LatLng(Double.valueOf(response.body().getResults().get(i).getLatitude()),
                                Double.valueOf(response.body().getResults().get(i).getLongitude()));
                        addMarkersToMap(latLng, response.body().getResults().get(i));
                    }
                    //重要 创建自定义适配器
//                    MapProjectAdapter adapter = new MapProjectAdapter(getActivity());
//                    aMap.setInfoWindowAdapter(adapter);//设置自定义窗口adapter

                }
            }

            @Override
            public void onFailure(Call<HomeProject> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取设备列表失败");
            }
        });
    }

    private void getOverViewData() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().liveOverview(PreferenceUtils.getInstance().getUserToken()).enqueue(new Callback<OverView>() {
            @Override
            public void onResponse(Call<OverView> call, Response<OverView> response) {
                if (response.body() != null && response.body().getCode().equals("200")) {
                    for (int i = 0; i < response.body().getResults().getBoundedUavs().size(); i++) {
                        OverView.ResultsDTO.BoundedUavsDTO boundedUavsDTO = response.body().getResults().getBoundedUavs().get(i);
                        if (!TextUtils.isEmpty(boundedUavsDTO.getLatitude()) && !TextUtils.isEmpty(boundedUavsDTO.getLongitude())) {
                            LatLng latLng = new LatLng(Double.valueOf(boundedUavsDTO.getLatitude().substring(1, boundedUavsDTO.getLatitude().length())),
                                    Double.valueOf(boundedUavsDTO.getLongitude().substring(1, boundedUavsDTO.getLongitude().length())));
                            aMap.addMarker(new MarkerOptions().position(latLng)
                                            .snippet(boundedUavsDTO.getUavCode())
                                    .icon(BitmapDescriptorFactory.fromBitmap(convertViewToBitmap(boundedUavsDTO))).draggable(false));
                        }
                    }

                    for (int i = 0; i < response.body().getResults().getUavDataVos().size(); i++) {
                        OverView.ResultsDTO.UavDataVosDTO uavDataVosDTO = response.body().getResults().getUavDataVos().get(i);
                        if (!TextUtils.isEmpty(uavDataVosDTO.getLatitude()) && !TextUtils.isEmpty(uavDataVosDTO.getLongitude())) {
                            LatLng latLng = new LatLng(Double.valueOf(uavDataVosDTO.getLatitude()),
                                    Double.valueOf(uavDataVosDTO.getLongitude()));
                            aMap.addMarker(new MarkerOptions().position(latLng)
                                    .snippet(uavDataVosDTO.getUavSn())
                                    .icon(BitmapDescriptorFactory.fromBitmap(convertViewToBitmap(uavDataVosDTO))).draggable(false));
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<OverView> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取设备列表失败");
            }
        });
    }

    /**
     * 往地图上添加marker/第二个参数表示如果是导入航线，为需要上传的航线数据赋值(航点的信息)
     * @param djiLatLng
     * @param projectName
     */
    public void addMarkersToMap(LatLng djiLatLng, HomeProject.ResultsDTO projectName) {
        aMap.addMarker(new MarkerOptions().position(djiLatLng)
                .icon(BitmapDescriptorFactory.fromBitmap(convertViewToBitmap(projectName))).draggable(false));
//                .icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_map_air))).draggable(true));

    }

    /**
     * 自定义Marker样式转为Bitmap
     *
     * @param projectName
     * @return
     */
    public Bitmap convertViewToBitmap(HomeProject.ResultsDTO projectName) {
        View view = View.inflate(getActivity(), R.layout.view_marker_project, null);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvStatus = (TextView) view.findViewById(R.id.tv_status);
        ImageView ivAir = (ImageView) view.findViewById(R.id.iv_logo);
        tvName.setText(projectName.getProjectName());
        tvStatus.setText(projectName.getProjectState() == 0 ? "进行中" : "已归档");
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    /**
     * 自定义Marker样式转为Bitmap
     */
    public Bitmap convertViewToBitmap(OverView.ResultsDTO.BoundedUavsDTO boundedUavsDTO) {
        View view = View.inflate(getActivity(), R.layout.view_marker_apron, null);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvStatus = (TextView) view.findViewById(R.id.tv_status);
        tvName.setText(boundedUavsDTO.getApronName());
        tvStatus.setText(boundedUavsDTO.getIsFlying().equals("1") ? "飞行中" : "未飞行");
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    /**
     * 自定义Marker样式转为Bitmap
     */
    public Bitmap convertViewToBitmap(OverView.ResultsDTO.UavDataVosDTO uavDataVosDTO) {
        View view = View.inflate(getActivity(), R.layout.view_marker_uav, null);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvStatus = (TextView) view.findViewById(R.id.tv_status);
        tvName.setText(uavDataVosDTO.getUavName());
        tvStatus.setText(uavDataVosDTO.getIsFlying().equals("1") ? "飞行中" : "未飞行");
        view.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.buildDrawingCache();
        Bitmap bitmap = view.getDrawingCache();
        return bitmap;
    }

    @Override
    public void onPause() {
        super.onPause();
        mBinding.mapView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mBinding.mapView.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding.mapView.onDestroy();
    }
}
