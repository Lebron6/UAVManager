package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityLiveShowBinding;
import com.compass.uavmanager.databinding.ActivityUpdataPasswordBinding;
import com.compass.uavmanager.entity.FlightHistoryDetails;
import com.compass.uavmanager.entity.LiveUrlResult;
import com.compass.uavmanager.entity.UpdataPasswordResult;
import com.compass.uavmanager.tools.AppManager;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.ToastUtil;
import com.orhanobut.logger.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tv.danmaku.ijk.media.player.IMediaPlayer;


public class LiveShowActivity extends BaseActivity {

    private ActivityLiveShowBinding mBinding;
    public static String SNCODE = "sn";

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

    private void initPlayer() {
        mBinding.player.setVideoPath("rtmp://mobliestream.c3tv.com:554/live/goodtv.sdp");

    }

}
