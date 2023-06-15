package com.compass.uavmanager.activity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBinding;


import com.compass.uavmanager.R;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityLoginBinding;
import com.compass.uavmanager.databinding.ActivityMainBinding;
import com.compass.uavmanager.entity.LoginResult;
import com.compass.uavmanager.entity.LoginSimpleResult;
import com.compass.uavmanager.entity.LoginValues;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.ToastUtil;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;
import com.yanzhenjie.permission.AndPermission;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends BaseActivity {
    private EditText etAccount;
    private EditText etPassword;
    //    private EditText etSn;
    private TextView tvLogin;
    ActivityLoginBinding mBinding;
    private static final String[] REQUIRED_PERMISSION_LIST = new String[]{
            Manifest.permission.VIBRATE,
            Manifest.permission.INTERNET,
            Manifest.permission.ACCESS_WIFI_STATE,
            Manifest.permission.WAKE_LOCK,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_NETWORK_STATE,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CHANGE_WIFI_STATE,
            Manifest.permission.CHANGE_NETWORK_STATE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.BLUETOOTH,
            Manifest.permission.BLUETOOTH_ADMIN,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO
    };

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkAndRequestPermissions();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        etAccount = findViewById(R.id.et_account);
        etPassword = findViewById(R.id.et_password);
//        etSn = findViewById(R.id.et_sn);
        tvLogin = findViewById(R.id.tv_login);
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                MainActivity.actionStart(LoginActivity.this);
                toLogin();
            }
        });
        if (!TextUtils.isEmpty(PreferenceUtils.getInstance().getUserName())) {
            etAccount.setText(PreferenceUtils.getInstance().getUserName());
            etPassword.setText(PreferenceUtils.getInstance().getUserPassword());
        }
    }


    private void toLogin() {
        if (TextUtils.isEmpty(etAccount.getText().toString())) {
            ToastUtil.showToast("请输入账号");
            return;
        }
        if (TextUtils.isEmpty(etPassword.getText().toString())) {
            ToastUtil.showToast("请输入密码");
            return;
        }
        LoginValues loginValues = new LoginValues();
        loginValues.setUsername(etAccount.getText().toString());
        loginValues.setPassword(etPassword.getText().toString());
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().userLogin2(loginValues).enqueue(new Callback<LoginSimpleResult>() {
            @Override
            public void onResponse(Call<LoginSimpleResult> call, Response<LoginSimpleResult> response) {
                if (response.body() != null) {
                    switch (response.body().getCode()) {
                        case "200":
                            PreferenceUtils.getInstance().setUserID(response.body().getResults().getUserId() + "");
                            PreferenceUtils.getInstance().setUserName(loginValues.getUsername());
                            PreferenceUtils.getInstance().setUserPassword(loginValues.getPassword());
                            PreferenceUtils.getInstance().setUserToken(response.headers().get("authorization"));
                            Logger.e("获取的TOKEN:" + response.headers().get("authorization"));
                            toLogin2();
                            break;
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "网络异常:登陆失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginSimpleResult> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "网络异常:登陆失败", Toast.LENGTH_SHORT).show();
                Log.e("网络异常:登陆失败", t.toString());
            }
        });
    }

    //需要登录上云获取token，拼接token和websocketUri，连接websocket
    private void toLogin2() {
        LoginValues loginValues = new LoginValues();
        loginValues.setUsername(etAccount.getText().toString());
        loginValues.setPassword(etPassword.getText().toString());
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest().userLogin(loginValues).enqueue(new Callback<LoginResult>() {
            @Override
            public void onResponse(Call<LoginResult> call, Response<LoginResult> response) {
                if (response.body() != null) {
                    switch (response.body().getCode()) {
                        case 0:
                            PreferenceUtils.getInstance().setUserCloudToken(response.body().getData().getAccess_token());
                            MainActivity.actionStart(LoginActivity.this);
                            finish();
                            break;
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "网络异常:登陆失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResult> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "网络异常:登陆失败", Toast.LENGTH_SHORT).show();
                Log.e("网络异常:登陆失败", t.toString());
            }
        });
    }

    /**
     * Checks if there is any missing permissions, and requests runtime permission if needed.
     */
    private void checkAndRequestPermissions() {
        AndPermission.with(this)
                .runtime()
                .permission(REQUIRED_PERMISSION_LIST)
                .onGranted(permissions -> {
                    // If there is enough permission, we will start the registration
                })
                .onDenied(permissions -> {
                    // Storage permission are not allowed.
                    ToastUtil.showToast("Missing permissions!!!");
                    finish();
                })
                .start();

    }
}
