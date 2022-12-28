package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;


import com.compass.uavmanager.adapter.FlightHistoryAdapter;
import com.compass.uavmanager.api.HttpUtil;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentFlightHistoryBinding;
import com.compass.uavmanager.entity.FlightHistoryList;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.compass.uavmanager.tools.ToastUtil;
import com.compass.uavmanager.view.SimpleFooter;
import com.compass.uavmanager.view.SimpleHeader;
import com.compass.uavmanager.view.SpringView;
import com.compass.uavmanager.view.datescroller.DateScrollerDialog;
import com.compass.uavmanager.view.datescroller.data.Type;
import com.compass.uavmanager.view.datescroller.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 飞行历史
 */
public class FlightHistoryFragment extends BaseFragment {

    private static final long HUNDRED_YEARS = 100L * 365 * 1000 * 60 * 60 * 24L;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private long mLastTime = System.currentTimeMillis();
    private long mLastFinishTime = System.currentTimeMillis();
    FragmentFlightHistoryBinding mBinding;
    private int page = 1;
    private String startTime = "2010-1-1", endTime = "2030-1-1";
    List<FlightHistoryList.ResultsDTO> datas = new ArrayList<>();
    FlightHistoryAdapter adapter;

    @Override
    public boolean useEventBus() {
        return false;
    }

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentFlightHistoryBinding.inflate(layoutInflater, container, false);
        return mBinding;
    }

    @Override
    protected void initDatas() {
        adapter = new FlightHistoryAdapter(getActivity());
        RecyclerViewHelper.initRecyclerViewV(getActivity(), mBinding.rvFlightHistory, false, adapter);
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
        mBinding.svFlightHistory.setType(SpringView.Type.FOLLOW);
        mBinding.svFlightHistory.setListener(onFreshListener);
        mBinding.svFlightHistory.setHeader(new SimpleHeader(getActivity()));
        mBinding.svFlightHistory.setFooter(new SimpleFooter(getActivity()));
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
        httpUtil.createRequest2().flightHistory(PreferenceUtils.getInstance().getUserToken(),
                startTime, endTime, 10, page).enqueue(new Callback<FlightHistoryList>() {
            @Override
            public void onResponse(Call<FlightHistoryList> call, Response<FlightHistoryList> response) {
                if (response.body()!=null&&response.body().getCode().equals("200")) {
                    datas = response.body().getResults();
                    adapter.setData(datas);
                }
                mBinding.svFlightHistory.onFinishFreshAndLoad();
            }

            @Override
            public void onFailure(Call<FlightHistoryList> call, Throwable t) {
                mBinding.svFlightHistory.onFinishFreshAndLoad();
                ToastUtil.showToast("网络异常：获取飞行历史列表失败");
            }
        });
    }

    private void onLoadmoreList() {
        page = ++page;
        HttpUtil httpUtil = new HttpUtil();
        httpUtil.createRequest2().flightHistory(PreferenceUtils.getInstance().getUserToken(),
                startTime, endTime, 10, page).enqueue(new Callback<FlightHistoryList>() {
            @Override
            public void onResponse(Call<FlightHistoryList> call, Response<FlightHistoryList> response) {
              if (response.body()!=null&&response.body().getCode().equals("200")){
                  datas.addAll(response.body().getResults());
                  adapter.setData(datas);
              }
                mBinding.svFlightHistory.onFinishFreshAndLoad();
            }

            @Override
            public void onFailure(Call<FlightHistoryList> call, Throwable t) {
                mBinding.svFlightHistory.onFinishFreshAndLoad();
            }
        });
    }

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
            startTime = getDateToString(milliseconds);
            endTime = getDateToString(milliFinishseconds);
            mBinding.tvTime.setText(startTime + "-" + endTime);
            getHistoryList();
        }
    };

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

}
