package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;

import com.amap.api.maps.AMap;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityLiveShowBinding;
import com.compass.uavmanager.entity.EventMessage;
import com.compass.uavmanager.entity.LiveUrlResult;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.ToastUtil;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.ijk.media.player.IMediaPlayer;


public class LiveShowActivity extends BaseActivity {

    private ActivityLiveShowBinding mBinding;
    public static String SNCODE = "sn";
    AMap aMap;

    public static void actionStart(Context context, String sn) {
        Intent intent = new Intent(context, LiveShowActivity.class);
        intent.putExtra(SNCODE, sn);
        context.startActivity(intent);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding.mapView.onCreate(savedInstanceState);
        aMap = mBinding.mapView.getMap();
        aMap.getUiSettings().setZoomControlsEnabled(false);
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityLiveShowBinding.inflate(getLayoutInflater());
        return mBinding;

    }

    @Override
    public void initView() {
//        initPlayer();
    }

    @Override
    public void initData() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().pushUrl(PreferenceUtils.getInstance().getUserToken(),
                getIntent().getStringExtra(SNCODE)).enqueue(new Callback<LiveUrlResult>() {
            @Override
            public void onResponse(Call<LiveUrlResult> call, Response<LiveUrlResult> response) {
                if (response.body()!=null&&response.body().getCode().equals("0")) {
                    String liveUrl = response.body().getData();
                    if (!TextUtils.isEmpty(liveUrl)&&liveUrl.length()>7){
                        mBinding.player.setVideoPath(liveUrl.substring(0,liveUrl.length()-7)+getIntent().getStringExtra(SNCODE));
                        mBinding.player.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() {
                            @Override
                            public void onPrepared(IMediaPlayer mp) {
                                mBinding.player.start();
                            }
                        });
                    }else{
                        ToastUtil.showToast("拉流地址有误");
                    }
                }
            }

            @Override
            public void onFailure(Call<LiveUrlResult> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取拉流播放地址失败");
            }
        });

    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventMessage message) {
        if (message.getType().equals("app")){
//            updateDroneLocation(message.getMessage());
        }else{
//            updateDroneLocation2(message.getMessage());
        }

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
