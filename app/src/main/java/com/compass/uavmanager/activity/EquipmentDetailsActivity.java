package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.viewbinding.ViewBinding;

import com.bumptech.glide.Glide;
import com.compass.uavmanager.api.BaseUrl;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityEquipmentDetailsBinding;
import com.compass.uavmanager.entity.EquipmentDetailsData;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EquipmentDetailsActivity extends BaseActivity {
    private ActivityEquipmentDetailsBinding mBinding;
    private static String UAV_ID = "uav_id";

    public static void actionStart(Context context, String uav_id) {
        Intent intent = new Intent(context, EquipmentDetailsActivity.class);
        intent.putExtra(UAV_ID, uav_id);
        context.startActivity(intent);
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityEquipmentDetailsBinding.inflate(getLayoutInflater());
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
        getEquipmentData();
    }

    public void getEquipmentData() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().equipmentDetail(PreferenceUtils.getInstance().getUserToken(),
                getIntent().getStringExtra(UAV_ID)).enqueue(new Callback<EquipmentDetailsData>() {
            @Override
            public void onResponse(Call<EquipmentDetailsData> call, Response<EquipmentDetailsData> response) {
                if (response.body() != null && response.body().getCode().equals("200")) {
                    if (response.body().getResults().getUavVo() != null) {
                        Glide.with(EquipmentDetailsActivity.this).load(BaseUrl.ipAddress2 + "/oauth/image" + response.body().getResults().getUavVo().getPicUrl())
                                .into(mBinding.ivEq);
                        mBinding.tvEqName.setText(response.body().getResults().getUavVo().getUavName());
                        mBinding.tvStatus.setText(response.body().getResults().getUavVo().getStatus());
                        mBinding.tvSn.setText(response.body().getResults().getUavVo().getUavSn());
                        mBinding.xh.setText(response.body().getResults().getUavVo().getUavType());
                        mBinding.pp.setText(response.body().getResults().getUavVo().getUavBrand());
                        mBinding.bdjk.setText(response.body().getResults().getUavVo().getApronChineseName());
                        mBinding.tvLxsj.setText(response.body().getResults().getUavVo().getLastOfflineTime());
                    }
                    if (response.body().getResults().getUavInsuranceVo() != null) {
                        mBinding.bdbh.setText(response.body().getResults().getUavInsuranceVo().getInsuranceNo());
                        mBinding.bxlx.setText(response.body().getResults().getUavInsuranceVo().getInsuranceType());
                        mBinding.gmrq.setText(response.body().getResults().getUavInsuranceVo().getBuyDate());
                        mBinding.kssj.setText(response.body().getResults().getUavInsuranceVo().getStartDate());
                        mBinding.jssj.setText(response.body().getResults().getUavInsuranceVo().getEndDate());
                        mBinding.bxgs.setText(response.body().getResults().getUavInsuranceVo().getCompany());
                        mBinding.bxgsdh.setText(response.body().getResults().getUavInsuranceVo().getCompanyPhone());
                        mBinding.zrr.setText(response.body().getResults().getUavInsuranceVo().getCharge());
                        mBinding.zrdh.setText(response.body().getResults().getUavInsuranceVo().getChargePhone());
                    }
                }
            }

            @Override
            public void onFailure(Call<EquipmentDetailsData> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取设备详情信息失败");
            }
        });
    }

}
