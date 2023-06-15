package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.R;
import com.compass.uavmanager.adapter.EquipmentTypeAdapter;
import com.compass.uavmanager.adapter.GalleryAdapter;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentEquipmentBinding;
import com.compass.uavmanager.databinding.FragmentGalleryBinding;
import com.compass.uavmanager.entity.GetMediaData;
import com.compass.uavmanager.entity.GetMediaData;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.compass.uavmanager.tools.ToastUtil;
import com.compass.uavmanager.view.SimpleFooter;
import com.compass.uavmanager.view.SimpleHeader;
import com.compass.uavmanager.view.SpringView;
import com.compass.uavmanager.view.datescroller.DateScrollerDialog;
import com.compass.uavmanager.view.datescroller.data.Type;
import com.compass.uavmanager.view.datescroller.listener.OnDateSetListener;
import com.orhanobut.logger.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 相册库
 */
public class GalleryFragment extends BaseFragment {

    FragmentGalleryBinding mBinding;
    private static final long HUNDRED_YEARS = 100L * 365 * 1000 * 60 * 60 * 24L;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private long mLastTime = System.currentTimeMillis();
    private long mLastFinishTime = System.currentTimeMillis();
    private int page = 1;
    private String startTime = "2010-1-1", endTime = "2030-1-1";
    GalleryAdapter adapter;
    List<GetMediaData.ResultsDTO> datas = new ArrayList<>();

    
    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentGalleryBinding.inflate(layoutInflater, container, false);
        mBinding.layoutTimeSelect.setOnClickListener(onClickListener);
        return mBinding;
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            showDateScroller();
        }
    };

    private void showDateScroller() {

        DateScrollerDialog dialog = new DateScrollerDialog.Builder()
                .setType(Type.YEAR_MONTH_DAY)
                .setTitleStringId("选择日期")
                .setMinMilliseconds(System.currentTimeMillis() - HUNDRED_YEARS)
                .setMaxMilliseconds(System.currentTimeMillis() + HUNDRED_YEARS)
                .setCurMilliseconds(mLastTime, mLastFinishTime)
                .setCallback(mOnDateSetListener)
                .build();
        if (dialog != null) {
            if (!dialog.isAdded()) {
                dialog.show(getActivity().getSupportFragmentManager(), "year_month_day");
            }
        }

    }

    private OnDateSetListener mOnDateSetListener = new OnDateSetListener() {
        @Override
        public void onDateSet(DateScrollerDialog timePickerView, long milliseconds, long milliFinishseconds) {
            mLastTime = milliseconds;
            mLastFinishTime = milliFinishseconds;
            String text = getDateToString(milliseconds);
            String text2 = getDateToString(milliFinishseconds);
            mBinding.tvTime.setText(text + "-" + text2);
            page = 1;
            startTime =text;
            endTime = text2;
            getHistoryList();
        }
    };

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    @Override
    protected void initDatas() {
         adapter = new GalleryAdapter(getActivity());
        RecyclerViewHelper.initRecyclerViewG(getActivity(), mBinding.rvPic, adapter, 2);
        initSpringViewStyle();
        mBinding.layoutTimeSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateScroller();
            }
        });
        getHistoryList();
    }

    private void initSpringViewStyle() {
        mBinding.svGally.setType(SpringView.Type.FOLLOW);
        mBinding.svGally.setListener(onFreshListener);
        mBinding.svGally.setHeader(new SimpleHeader(getActivity()));
        mBinding.svGally.setFooter(new SimpleFooter(getActivity()));
    }

    SpringView.OnFreshListener onFreshListener = new SpringView.OnFreshListener() {
        @Override
        public void onRefresh() {
            page = 1;
            mBinding.tvTime.setText("");
            startTime = "2010-1-1";
            endTime = "2030-1-1";
            getHistoryList();
        }

        @Override
        public void onLoadmore() {
            onLoadmoreList();
        }
    };

    public void getHistoryList() {
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().getMediaList(PreferenceUtils.getInstance().getUserToken(),page+"",10+"",
                startTime, endTime, "0").enqueue(new Callback<GetMediaData>() {
            @Override
            public void onResponse(Call<GetMediaData> call, Response<GetMediaData> response) {
                if (response.body()!=null&&response.body().getCode().equals("200")) {
                    datas = response.body().getResults();
                    adapter.setData(datas);
                }
                mBinding.svGally.onFinishFreshAndLoad();
            }

            @Override
            public void onFailure(Call<GetMediaData> call, Throwable t) {
                mBinding.svGally.onFinishFreshAndLoad();
                Logger.e("异常信息"+t.toString());
                ToastUtil.showToast("网络异常：获取图片失败");
            }
        });
    }

    private void onLoadmoreList() {
        page = ++page;
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().getMediaList(PreferenceUtils.getInstance().getUserToken(),page+"",10+"",
                startTime, endTime, "0").enqueue(new Callback<GetMediaData>() {
            @Override
            public void onResponse(Call<GetMediaData> call, Response<GetMediaData> response) {
                if (response.body()!=null&&response.body().getCode().equals("200")){
                    datas.addAll(response.body().getResults());
                    adapter.setData(datas);
                }
                mBinding.svGally.onFinishFreshAndLoad();
            }

            @Override
            public void onFailure(Call<GetMediaData> call, Throwable t) {
                mBinding.svGally.onFinishFreshAndLoad();
                ToastUtil.showToast("网络异常：获取图片失败");

            }
        });
    }
}
