package com.compass.uavmanager.fragment.equipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.compass.uavmanager.adapter.EquipmentTypeAdapter;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentEquipmentTypeBinding;
import com.compass.uavmanager.entity.EquipmentResult;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.compass.uavmanager.tools.ToastUtil;
import com.compass.uavmanager.view.SimpleFooter;
import com.compass.uavmanager.view.SimpleHeader;
import com.compass.uavmanager.view.SpringView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * 设备状态
 */
public class EquipmentTypeFragment extends BaseFragment {

    private String type;

    List<EquipmentResult.ResultsDTO> datas=new ArrayList<>();

    public EquipmentTypeFragment(String type) {
        this.type = type;
    }
    public EquipmentTypeFragment() {
    }
    FragmentEquipmentTypeBinding mBinding;
    private int page = 1;
    EquipmentTypeAdapter adapter;

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentEquipmentTypeBinding.inflate(layoutInflater, container, false);
        return mBinding;
    }

    @Override
    protected void initDatas() {
        adapter = new EquipmentTypeAdapter(getActivity());
        RecyclerViewHelper.initRecyclerViewV(getActivity(), mBinding.rvEquipmentType, false, adapter);
        initSpringViewStyle();
        getEquipmentList();

    }

    private void initSpringViewStyle() {
        mBinding.svEq.setType(SpringView.Type.FOLLOW);
        mBinding.svEq.setListener(onFreshListener);
        mBinding.svEq.setHeader(new SimpleHeader(getActivity()));
        mBinding.svEq.setFooter(new SimpleFooter(getActivity()));
    }

    SpringView.OnFreshListener onFreshListener = new SpringView.OnFreshListener() {
        @Override
        public void onRefresh() {
            page = 1;
            getEquipmentList();
        }

        @Override
        public void onLoadmore() {
            onLoadmoreList();
        }
    };

    public void getEquipmentList() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().equipmentList(PreferenceUtils.getInstance().getUserToken(),
                page, 10, type).enqueue(new Callback<EquipmentResult>() {
            @Override
            public void onResponse(Call<EquipmentResult> call, Response<EquipmentResult> response) {
                if (response.body()!=null&&response.body()!=null&&response.body().getCode().equals("200")) {
                    datas=response.body().getResults();
                    adapter.setData(datas);
                }
                mBinding.svEq.onFinishFreshAndLoad();
            }

            @Override
            public void onFailure(Call<EquipmentResult> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取设备列表失败");
                mBinding.svEq.onFinishFreshAndLoad();

            }
        });
    }

    private void onLoadmoreList() {
        page = ++page;
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().equipmentList(PreferenceUtils.getInstance().getUserToken(),
                page, 10, type).enqueue(new Callback<EquipmentResult>() {
            @Override
            public void onResponse(Call<EquipmentResult> call, Response<EquipmentResult> response) {
                if (response.body()!=null&&response.body().getCode().equals("200")) {
                    datas.addAll(response.body().getResults());
                    adapter.setData(datas);
                }
                mBinding.svEq.onFinishFreshAndLoad();
            }

            @Override
            public void onFailure(Call<EquipmentResult> call, Throwable t) {
                ToastUtil.showToast("网络异常:获取设备列表失败");
                mBinding.svEq.onFinishFreshAndLoad();

            }
        });
    }
}
