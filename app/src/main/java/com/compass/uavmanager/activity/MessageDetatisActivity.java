package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.adapter.CallBackAdapter;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityMessageBinding;
import com.compass.uavmanager.databinding.ActivityMessageDetatisBinding;
import com.compass.uavmanager.entity.CallBackResult;
import com.compass.uavmanager.entity.ReplyValues;
import com.compass.uavmanager.entity.TaskReportResult;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.compass.uavmanager.tools.ToastUtil;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MessageDetatisActivity extends BaseActivity {

    private ActivityMessageDetatisBinding mBinding;
    private static String ID = "id";
    private static String TITLE = "title";
    private static String TIME = "time";
    private static String NAME = "name";
    private static String INFO = "info";

    public static void actionStart(Context context, String id, String title, String name, String info, String time) {
        Intent intent = new Intent(context, MessageDetatisActivity.class);
        intent.putExtra(ID, id);
        intent.putExtra(TITLE, title);
        intent.putExtra(TIME, time);
        intent.putExtra(NAME, name);
        intent.putExtra(INFO, info);
        context.startActivity(intent);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mBinding.getRoot());
        initView();
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityMessageDetatisBinding.inflate(getLayoutInflater());
        return mBinding;
    }

    @Override
    public void initData() {

    }

    public void initView() {
        mBinding.tvName.setText(getIntent().getStringExtra(NAME));
        mBinding.tvTitle.setText(getIntent().getStringExtra(TITLE));
        mBinding.tvTaskInfo.setText(getIntent().getStringExtra(INFO));
        mBinding.tvTime.setText(getIntent().getStringExtra(TIME));

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
        getEquipmentData();
    }

    private void commit() {
        if (TextUtils.isEmpty(mBinding.etCallback.getText())) {
            ToastUtil.showToast("请输入回复信息");
            return;
        }
        ReplyValues values=new ReplyValues();
        values.setTaskId(getIntent().getStringExtra(ID));
        values.setReplyinfo(mBinding.etCallback.getText().toString());
        values.setName(PreferenceUtils.getInstance().getUserName());
        values.setId("0");
        values.setAnnunciateId("0");

        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().reply(PreferenceUtils.getInstance().getUserToken(), values).enqueue(new Callback<TaskReportResult>() {
            @Override
            public void onResponse(Call<TaskReportResult> call, Response<TaskReportResult> response) {
                if (response.body() != null) {
                    switch (response.body().getCode()) {
                        case "200":
                            getEquipmentData();
                            break;
                    }
                } else {
                    Toast.makeText(MessageDetatisActivity.this, "网络异常:提交失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<TaskReportResult> call, Throwable t) {
                Toast.makeText(MessageDetatisActivity.this, "网络异常:提交失败", Toast.LENGTH_SHORT).show();
                Log.e("网络异常:提交失败", t.toString());
            }
        });
    }

    public void getEquipmentData() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().callBackList(PreferenceUtils.getInstance().getUserToken(),
                getIntent().getStringExtra(ID)).enqueue(new Callback<CallBackResult>() {
            @Override
            public void onResponse(Call<CallBackResult> call, Response<CallBackResult> response) {
                if (response.body()!=null&&response.body().getCode().equals("200")) {
                    CallBackAdapter adapter = new CallBackAdapter();
                    RecyclerViewHelper.initRecyclerViewV(MessageDetatisActivity.this, mBinding.rvCallback, false, adapter);
                    adapter.setData(response.body());
                }
            }

            @Override
            public void onFailure(Call<CallBackResult> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取设备详情信息失败");
            }
        });
    }
}
