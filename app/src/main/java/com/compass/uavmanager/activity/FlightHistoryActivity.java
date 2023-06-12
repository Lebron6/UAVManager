package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;

import androidx.viewbinding.ViewBinding;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.amap.api.maps.utils.overlay.SmoothMoveMarker;
import com.compass.uavmanager.R;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityFlightHistoryBinding;
import com.compass.uavmanager.entity.FlightHistoryDetails;
import com.compass.uavmanager.entity.FlightPoints;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlightHistoryActivity extends BaseActivity {

    AMap aMap;
    private ActivityFlightHistoryBinding mBinding;
    private static String ID = "id";

    public static void actionStart(Context context, String id) {
        Intent intent = new Intent(context, FlightHistoryActivity.class);
        intent.putExtra(ID, id);
        context.startActivity(intent);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.mapView.onCreate(savedInstanceState);
        aMap = mBinding.mapView.getMap();
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityFlightHistoryBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        mBinding.layoutFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBinding.jzVideo.SAVE_PROGRESS = false;
        getEquipmentData();
        getFlightPoints();
    }


    private int time = 0;

    private void getFlightPoints() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().flightPoints(PreferenceUtils.getInstance().getUserToken(),
                getIntent().getStringExtra(ID)).enqueue(new Callback<FlightPoints>() {
            @Override
            public void onResponse(Call<FlightPoints> call, Response<FlightPoints> response) {
                if (response.body() != null && response.body().getCode().equals("200")) {
                    setDataToTextView(response.body().getResults().getFlightPointInfoVos());
                    List<LatLng> points = new ArrayList<>();
                    for (int i = 0; i < response.body().getResults().getPoints().size(); i++) {
                        LatLng latLng = new LatLng(
                                Double.parseDouble(response.body().getResults().getPoints().get(i).get(1)),
                                Double.parseDouble(response.body().getResults().getPoints().get(i).get(0)));
                        points.add(latLng);
                    }
                    aMap.addPolyline(new PolylineOptions().
                            addAll(points).width(5).color(getResources().getColor(R.color.blue)));
//                    LatLngBounds bounds = new LatLngBounds(points.get(0), points.get(points.size() - 2));
//                    aMap.animateCamera(CameraUpdateFactory.newLatLngBounds(bounds, 12));
                    aMap.moveCamera(CameraUpdateFactory.newCameraPosition(
                            CameraPosition.fromLatLngZoom(
                                    new LatLng(
                                            Double.valueOf(points.get(0).latitude),
                                            Double.valueOf(points.get(0).longitude)),
                                    16)));
                    SmoothMoveMarker smoothMarker = new SmoothMoveMarker(aMap);
                    // 设置滑动的图标
                    smoothMarker.setDescriptor(BitmapDescriptorFactory.fromResource(R.mipmap.ic_map_air));
                    LatLng drivePoint = points.get(0);
                    Pair<Integer, LatLng> pair = SpatialRelationUtil.calShortestDistancePoint(points, drivePoint);
                    points.set(pair.first, drivePoint);
                    List<LatLng> subList = points.subList(pair.first, points.size());
                    // 设置滑动的轨迹左边点
                    smoothMarker.setPoints(subList);
                    // 设置滑动的总时间
                    smoothMarker.setTotalDuration(response.body().getResults().getPoints().size());
                    // 开始滑动
                    smoothMarker.startSmoothMove();
                }
            }

            @Override
            public void onFailure(Call<FlightPoints> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取飞行历史点位信息失败");
            }
        });
    }

    Timer timer;

    private void setDataToTextView(List<FlightPoints.ResultsDTO.FlightPointInfoVosDTO> flightPointInfoVos) {
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                time = time + 1;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (TextUtils.isEmpty(flightPointInfoVos.get(time).getPersentOne())) {
                            mBinding.tvBattery.setText("");
                        } else {
                            mBinding.tvBattery.setText(flightPointInfoVos.get(time).getPersentOne() + "%   "
                                    + flightPointInfoVos.get(time).getVoltageOne() + "v");
                        }
                        mBinding.tvGpsLevel.setText(flightPointInfoVos.get(time).getSatelliteCount() + "级");
                        mBinding.tvDistance.setText(flightPointInfoVos.get(time).getOriginDistance() + "米");
                        mBinding.tvWind.setText(flightPointInfoVos.get(time).getWindSpeed() + "dm/s");
                        mBinding.tvVSpeed.setText(flightPointInfoVos.get(time).getVerticalSpeed() + "m/s");
                        mBinding.tvHSpeed.setText(flightPointInfoVos.get(time).getHorizontalSpeed() + "m/s");
                        if (time == flightPointInfoVos.size() - 1) {
                            timer.cancel();//  调用cancel关闭倒计时
                        }
                    }
                });

            }
        }, 0, 1000);
    }

    public void getEquipmentData() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().historyDetail(PreferenceUtils.getInstance().getUserToken(),
                getIntent().getStringExtra(ID)).enqueue(new Callback<FlightHistoryDetails>() {
            @Override
            public void onResponse(Call<FlightHistoryDetails> call, Response<FlightHistoryDetails> response) {
                if (response.body() != null && response.body().getCode().equals("200")) {
                    if (!TextUtils.isEmpty(response.body().getResults().getVideoPath())) {
                        StringBuilder stringBuilder = new StringBuilder(response.body().getResults().getVideoPath());
                        String s = stringBuilder.substring(43, response.body().getResults().getVideoPath().length());
                        mBinding.jzVideo.setUp("http://36.154.125.57" + s, "");
                        mBinding.jzVideo.startButton.performClick();

                    }
                    mBinding.tvPlayer.setText(response.body().getResults().getOperator());
                    mBinding.tvFlyMode.setText(response.body().getResults().getFlightModel());
                    mBinding.tvFlyTime.setText(response.body().getResults().getFlightTime());
                    mBinding.tvFlyDuration.setText(response.body().getResults().getFlyingTime());
//                    mBinding.tvFlyAddr.setText(response.body().getResults().getAddress());

                }
            }

            @Override
            public void onFailure(Call<FlightHistoryDetails> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取飞行历史详情信息失败");
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (mBinding.jzVideo.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，销毁地图
        mBinding.mapView.onDestroy();
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBinding.jzVideo.releaseAllVideos();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mBinding.mapView.onPause();

    }
}
