package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.viewbinding.ViewBinding;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.compass.uavmanager.activity.UpdataPasswordActivity;
import com.compass.uavmanager.api.BaseUrl;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentPersonalBinding;
import com.compass.uavmanager.entity.UserInfo;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 个人中心
 */
public class PersonalFragment extends BaseFragment {

    FragmentPersonalBinding mBinding;

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentPersonalBinding.inflate(layoutInflater, container, false);
        return mBinding;
    }



    @Override
    protected void initDatas() {
        getUserInfo();
//        mBinding.layoutMessage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MessageActivity.actionStart(getActivity());
//            }
//        });
        mBinding.layoutPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdataPasswordActivity.actionStart(getActivity());
            }
        });
    }

    private void getUserInfo() {

        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().getUserInfo(PreferenceUtils.getInstance().getUserToken()).enqueue(new Callback<UserInfo>() {
            @Override
            public void onResponse(Call<UserInfo> call, Response<UserInfo> response) {
                if (response.body() != null) {
                    switch (response.body().getCode()) {
                        case "200":
                            RequestOptions requestOptions = RequestOptions.circleCropTransform();
                            Glide.with(PersonalFragment.this).applyDefaultRequestOptions(requestOptions).
                                    load(BaseUrl.ipAddress2+"/oauth/image"+response.body().getResults().getUserImagePath())
                                    .into(mBinding.ivUserPhoto);
                            mBinding.tvUserName.setText(response.body().getResults().getUsername());
                            mBinding.tvDep.setText(response.body().getResults().getDepartmentName());
                            mBinding.tvUserRole.setText(response.body().getResults().getRoleName());
                            mBinding.tvPhoneNum.setText(response.body().getResults().getPhone());
                            mBinding.tvFlyTime.setText("累计飞行时长:"+response.body().getResults().getTotalFlightTime());
                            break;
                        default:
                            ToastUtil.showToast("获取用户信息失败:" + response.body().getMsg());
                            break;
                    }
                } else {
                    Toast.makeText(getActivity(), "网络异常:获取用户信息失败", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UserInfo> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取用户信息失败");
                Log.e("网络异常:获取用户信息失败", t.toString());
            }
        });

    }
}
