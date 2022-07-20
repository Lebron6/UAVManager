package com.compass.uavmanager.activity;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityLoginBinding;
import com.gyf.immersionbar.ImmersionBar;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;

    @Override
    public void initImmersionBar() {
        ImmersionBar mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.transparentBar().fullScreen(true).init();
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    @Override
    public void initView() {
        mBinding.tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.actionStart(LoginActivity.this);
            }
        });
    }

    @Override
    public void initData() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);

int width = wm.getDefaultDisplay().getWidth();

int height = wm.getDefaultDisplay().getHeight();
        Log.e("分辨率","width"+width+"height:"+height);
//        java -jar autolayout.jar 375 812 320,480_1920,1080_1440,2560_720,1280_1200,1920_1200,1824
    }
}
