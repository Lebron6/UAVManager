package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.viewbinding.ViewBinding;

import com.compass.uavmanager.R;
import com.compass.uavmanager.adapter.EquipmentTypeAdapter;
import com.compass.uavmanager.adapter.GalleryAdapter;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentEquipmentBinding;
import com.compass.uavmanager.databinding.FragmentGalleryBinding;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.compass.uavmanager.view.datescroller.DateScrollerDialog;
import com.compass.uavmanager.view.datescroller.data.Type;
import com.compass.uavmanager.view.datescroller.listener.OnDateSetListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 相册库
 */
public class GalleryFragment extends BaseFragment {

    FragmentGalleryBinding mBinding;
    private static final long HUNDRED_YEARS = 100L * 365 * 1000 * 60 * 60 * 24L;
    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
    private long mLastTime = System.currentTimeMillis();
    private long mLastFinishTime = System.currentTimeMillis();


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
        }
    };

    public String getDateToString(long time) {
        Date d = new Date(time);
        return sf.format(d);
    }

    @Override
    protected void initDatas() {
        GalleryAdapter adapter = new GalleryAdapter();
        RecyclerViewHelper.initRecyclerViewG(getActivity(), mBinding.rvPic, adapter, 2);
    }
}
