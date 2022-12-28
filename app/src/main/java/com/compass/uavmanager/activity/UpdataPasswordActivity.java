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
import com.compass.uavmanager.databinding.ActivityUpdataPasswordBinding;
import com.compass.uavmanager.entity.UpdataPasswordResult;
import com.compass.uavmanager.tools.AppManager;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class UpdataPasswordActivity extends BaseActivity {

    private ActivityUpdataPasswordBinding mBinding;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, UpdataPasswordActivity.class);
        context.startActivity(intent);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityUpdataPasswordBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    @Override
    public void initView() {
        mBinding.layoutFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBinding.tvCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                commit();
            }
        });
    }

    @Override
    public void initData() {

    }

    private void commit() {
        if (TextUtils.isEmpty(mBinding.etOldPassword.getText())) {
            ToastUtil.showToast("请输入旧密码");
            return;
        }
        if (TextUtils.isEmpty(mBinding.etNewPassword.getText())) {
            ToastUtil.showToast("请输入新密码");
            return;
        }
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().updataPassword(PreferenceUtils.getInstance().getUserToken(), mBinding.etOldPassword.getText().toString(), mBinding.etNewPassword.getText().toString()).enqueue(new Callback<UpdataPasswordResult>() {
            @Override
            public void onResponse(Call<UpdataPasswordResult> call, Response<UpdataPasswordResult> response) {
                if (response.body() != null) {
                    switch (response.body().getCode()) {
                        case "200":
                            PreferenceUtils.getInstance().loginOut();
                            AppManager.getAppManager().finishAllActivity();
                            startActivity(new Intent(UpdataPasswordActivity.this, LoginActivity.class));
                            break;
                        default:
                            ToastUtil.showToast("修改失败:" + response.body().getMsg());
                            break;
                    }
                } else {
                    Toast.makeText(UpdataPasswordActivity.this, "网络异常:修改失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UpdataPasswordResult> call, Throwable t) {
                Toast.makeText(UpdataPasswordActivity.this, "网络异常:修改失败", Toast.LENGTH_SHORT).show();
                Log.e("网络异常:修改失败", t.toString());
            }
        });
    }

}
