package com.compass.uavmanager.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
import com.compass.uavmanager.api.BaseUrl;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.callback.OnAreaSelectListener;
import com.compass.uavmanager.databinding.FragmentHomeBinding;
import com.compass.uavmanager.entity.BindUav;
import com.compass.uavmanager.entity.EventMessage;
import com.compass.uavmanager.entity.HomeProject;
import com.compass.uavmanager.entity.ICloudSocketInfo;
import com.compass.uavmanager.entity.OverView;
import com.compass.uavmanager.entity.BindUavResult;
import com.compass.uavmanager.entity.UavSocketInfo;
import com.compass.uavmanager.entity.WebSocketRegister;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.compass.uavmanager.tools.ToastUtil;
import com.compass.uavmanager.view.TimeSelectWindow;
import com.compass.uavmanager.websocket.JWebSocketClient;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {

    FragmentHomeBinding mBinding;
    AMap aMap;
    private List<String> times;
    private List<LatLng> areas;
    private ArrayAdapter arrayAdapter;

    @Override
    public boolean useEventBus() {
        return true;
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

        mBinding.layotArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeSelectWindow timeSelectWindow = new TimeSelectWindow(getActivity());
                timeSelectWindow.showView(mBinding.layotArea, arrayAdapter, listener);
            }
        });
        mBinding.tvPosition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aMap.moveCamera(CameraUpdateFactory.newCameraPosition(
                        CameraPosition.fromLatLngZoom(
                                new LatLng(
                                        31.335505, 120.618026),
                                10)));
            }
        });
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
                if (!TextUtils.isEmpty(marker.getSnippet())) {
                    LiveShowActivity.actionStart(getActivity(), marker.getSnippet());
                } else {
                    ToastUtil.showToast("获取设备SN失败");
                }
                return true;
            }
        });
    }

    OnAreaSelectListener listener = new OnAreaSelectListener() {
        @Override
        public void select(int postion) {
            mBinding.tvArea.setText(times.get(postion));
            aMap.moveCamera(CameraUpdateFactory.newCameraPosition(
                    CameraPosition.fromLatLngZoom(
                            areas.get(postion),
                            11)));
        }
    };
    HomeProjectAdapter adapter;

    @Override
    protected void initDatas() {
        times = new ArrayList<>();
        times.add("姑苏区");
        times.add("工业园区");
        times.add("吴中区");
        times.add("吴江区");
        times.add("相城区");
        times.add("虎丘区");
        times.add("张家港市");
        times.add("昆山市");
        times.add("常熟市");
        times.add("太仓市");
        arrayAdapter = new ArrayAdapter(getActivity(), R.layout.item_question, R.id.tv_popqusetion, times);
        areas = new ArrayList<>();
        areas.add(new LatLng(31.337919, 120.61805));//姑苏
        areas.add(new LatLng(31.326817, 120.737009));//园区
        areas.add(new LatLng(31.282828, 120.644253));//吴中
        areas.add(new LatLng(31.11027, 120.64438));//吴江
        areas.add(new LatLng(31.371976, 120.637642));//相城
        areas.add(new LatLng(31.365069, 120.590499));//虎丘
        areas.add(new LatLng(31.88016, 120.560028));//张家港
        areas.add(new LatLng(31.367536, 120.983166));//昆山
        areas.add(new LatLng(31.659865, 120.758949));//常熟
        areas.add(new LatLng(31.463685, 121.139543));//太仓

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
                    if (response.body().getResults() != null && response.body().getResults().size() > 0) {
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

    List<String> uavList = new ArrayList<>();
    BindUav bindUav = new BindUav();
    List<OverView.ResultsDTO.UavDataVosDTO> uavDataVos;

    private void getOverViewData() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().liveOverview(PreferenceUtils.getInstance().getUserToken()).enqueue(new Callback<OverView>() {
            @Override
            public void onResponse(Call<OverView> call, Response<OverView> response) {
                if (response.body() != null && response.body().getCode().equals("200")) {
                    uavList.clear();

                    for (int i = 0; i < response.body().getResults().getBoundedUavs().size(); i++) {
                        Logger.e("获取在线机场设备" + new Gson().toJson(response.body().getResults().getBoundedUavs()));
                        OverView.ResultsDTO.BoundedUavsDTO boundedUavsDTO = response.body().getResults().getBoundedUavs().get(i);
                        if (!TextUtils.isEmpty(boundedUavsDTO.getLatitude()) && !TextUtils.isEmpty(boundedUavsDTO.getLongitude())) {
                            LatLng latLng = new LatLng(Double.valueOf(boundedUavsDTO.getLatitude().substring(1, boundedUavsDTO.getLatitude().length())),
                                    Double.valueOf(boundedUavsDTO.getLongitude().substring(1, boundedUavsDTO.getLongitude().length())));
                            aMap.addMarker(new MarkerOptions().position(latLng)
                                    .snippet(boundedUavsDTO.getUavCode())
                                    .icon(BitmapDescriptorFactory.fromBitmap(convertViewToBitmap(boundedUavsDTO))).draggable(false));
                        }
//                            uavList.add(boundedUavsDTO.getUavCode());
                    }
                    uavDataVos = response.body().getResults().getUavDataVos();
                    Logger.e("获取设备列表" + new Gson().toJson(uavDataVos));

                    for (int i = 0; i < uavDataVos.size(); i++) {
                        OverView.ResultsDTO.UavDataVosDTO uavDataVosDTO = uavDataVos.get(i);
//                        if (!TextUtils.isEmpty(uavDataVosDTO.getLatitude()) && !TextUtils.isEmpty(uavDataVosDTO.getLongitude())) {
//                            LatLng latLng = new LatLng(Double.valueOf(uavDataVosDTO.getLatitude()),
//                                    Double.valueOf(uavDataVosDTO.getLongitude()));
//                            aMap.addMarker(new MarkerOptions().position(latLng)
//                                    .snippet(uavDataVosDTO.getUavSn())
//                                    .icon(BitmapDescriptorFactory.fromBitmap(convertViewToBitmap(uavDataVosDTO))).draggable(false));
//                        }
                        if (!TextUtils.isEmpty(uavDataVosDTO.getUavCode())) {
                            uavList.add(uavDataVosDTO.getUavCode());
                        }
                    }
                    bindUav.setUavId(uavList);
                    bindUav.setUserName(PreferenceUtils.getInstance().getUserName());
                    toBindOnlineUav();
                }
            }

            @Override
            public void onFailure(Call<OverView> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取设备列表失败");
            }
        });
    }

    //绑定在线无人机
    private void toBindOnlineUav() {
        HttpUtil httpUtil = new HttpUtil();
        Logger.e("请求绑定列表" + new Gson().toJson(bindUav));
        httpUtil.createRequest2().uavBindBatch(PreferenceUtils.getInstance().getUserToken(), bindUav).enqueue(new Callback<BindUavResult>() {
            @Override
            public void onResponse(Call<BindUavResult> call, Response<BindUavResult> response) {
                Logger.e("绑定在线无人机：" + response.body().toString());
            }

            @Override
            public void onFailure(Call<BindUavResult> call, Throwable t) {
                Logger.e("绑定在线无人机" + "：失败");

            }
        });
    }

    /**
     * 往地图上添加marker/第二个参数表示如果是导入航线，为需要上传的航线数据赋值(航点的信息)
     *
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
    public Bitmap convertViewToBitmap(OverView.ResultsDTO.UavDataVosDTO dataVosDTO) {
        View view = View.inflate(getActivity(), R.layout.view_marker_uav, null);
        TextView tvName = (TextView) view.findViewById(R.id.tv_name);
        TextView tvStatus = (TextView) view.findViewById(R.id.tv_status);
        tvName.setText(dataVosDTO.getUavName());
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


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMessage message) {
        Logger.e("收到event消息" + message);
        if (message.getType().equals("app")){
            updateDroneLocation(message.getMessage());
        }else{
            updateDroneLocation2(message.getMessage());
        }

    }



    LatLng pos;
    LatLng pos2;

    private List<UavSocketInfo> uavSocketInfos = new ArrayList<>();
    private List<ICloudSocketInfo> iCloudSocketInfos = new ArrayList<>();

    private void updateDroneLocation(String message) {

        UavSocketInfo uavSocketInfo = new Gson().fromJson(message, UavSocketInfo.class);
        if (uavSocketInfos.size()==0){
            uavSocketInfos.add(uavSocketInfo);
        }
        for (int i = 0; i < uavSocketInfos.size(); i++) {
            if (!uavSocketInfos.get(i).getEquipmentId().equals(uavSocketInfo.getEquipmentId())) {
                uavSocketInfos.add(uavSocketInfo);
            }
        }
        for (int i = 0; i < uavSocketInfos.size(); i++) {
            if (uavSocketInfos.get(i).getContent().getLatitude()==0|| uavSocketInfos.get(i).getContent().getLongitude() == 0) {
                pos = new LatLng(31.28897, 120.644406);
            } else {
                pos = new LatLng(uavSocketInfos.get(i).getContent().getLatitude(),  uavSocketInfos.get(i).getContent().getLongitude());
            }

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Marker droneMarker = null;
                    if (droneMarker != null) {
                        droneMarker.remove();
                    }
                    if (uavDataVos != null && uavDataVos.size() > 0) {
                        for (int i = 0; i < uavDataVos.size(); i++) {
                            for (int j = 0; j <uavSocketInfos.size() ; j++) {
                                if (uavDataVos.get(i).getUavCode().equals(uavSocketInfos.get(j).getEquipmentId())) {

                                    droneMarker = aMap.addMarker(new MarkerOptions().position(pos)
                                            .snippet(uavDataVos.get(i).getUavCode())
                                            .icon(BitmapDescriptorFactory.fromBitmap(convertViewToBitmap(uavDataVos.get(i)))).draggable(false));
                                    return;
                                }
                            }

                        }
                    }
                }
            });
        }

    }

    private void updateDroneLocation2(String message) {
        ICloudSocketInfo iCloudSocketInfo = new Gson().fromJson(message, ICloudSocketInfo.class);
        if (iCloudSocketInfos.size()==0){
            iCloudSocketInfos.add(iCloudSocketInfo);
        }
        for (int i = 0; i < iCloudSocketInfos.size(); i++) {
            if (!iCloudSocketInfos.get(i).getUavCode().equals(iCloudSocketInfo.getUavCode())) {
                iCloudSocketInfos.add(iCloudSocketInfo);
            }
        }
        for (int i = 0; i < iCloudSocketInfos.size(); i++) {
            if (iCloudSocketInfos.get(i).getData().getHost().getLatitude()==0|| iCloudSocketInfos.get(i).getData().getHost().getLongitude()== 0) {
                pos2 = new LatLng(31.288627, 120.646094);
            } else {
                pos2 = new LatLng(iCloudSocketInfos.get(i).getData().getHost().getLatitude(),  iCloudSocketInfos.get(i).getData().getHost().getLongitude());
            }

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Marker droneMarker = null;
                    if (droneMarker != null) {
                        droneMarker.remove();
                    }
                    if (uavDataVos != null && uavDataVos.size() > 0) {
                        for (int i = 0; i < uavDataVos.size(); i++) {
                            for (int j = 0; j <iCloudSocketInfos.size() ; j++) {
                                if (uavDataVos.get(i).getUavCode().equals(iCloudSocketInfos.get(j).getUavCode())) {
                                    Logger.e("获取到上鱼"+uavDataVos.get(i).getUavCode());

                                    droneMarker = aMap.addMarker(new MarkerOptions().position(pos2)
                                            .snippet(uavDataVos.get(i).getUavCode())
                                            .icon(BitmapDescriptorFactory.fromBitmap(convertViewToBitmap(uavDataVos.get(i)))).draggable(false));
                                    return;
                                }
                            }

                        }
                    }
                }
            });
        }

    }
}
