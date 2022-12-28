package com.compass.uavmanager.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.tools.AppManager;
import com.gyf.immersionbar.ImmersionBar;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;

public abstract class BaseActivity<T extends ViewBinding>  extends AppCompatActivity {
    /**
     * activity堆栈管理
     */
    protected AppManager appManager = AppManager.getAppManager();
    protected String TAG;
    private T mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = getViewBinding();
        setContentView(mBinding.getRoot());
        loggerSimpleName();
        appManager.addActivity(this);
        initImmersionBar();
        initView();
        initData();
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
    }

    public abstract T getViewBinding();

    //初始化数据
    public abstract void initData();//初始化数据
    public abstract void initView();

    public void initImmersionBar() {
        //在BaseActivity里初始化
        ImmersionBar mImmersionBar = ImmersionBar.with(this);
        mImmersionBar.transparentBar().fullScreen(true).statusBarDarkFont(true).init();
    }


    public abstract boolean useEventBus();

    public void loggerSimpleName() {
        TAG = getClass().getSimpleName();
        Logger.e("当前界面 ：" + TAG);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 从栈中移除activity
        appManager.finishActivity(this);
        if (useEventBus == true) {
            EventBus.getDefault().unregister(this);
        }
    }
    protected boolean useEventBus = false;

}
