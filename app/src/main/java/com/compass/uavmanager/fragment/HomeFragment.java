package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;
import com.compass.uavmanager.R;
import com.compass.uavmanager.adapter.HomeProjectAdapter;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.databinding.FragmentHomeBinding;
import com.compass.uavmanager.tools.RecyclerViewHelper;
import com.dji.mapkit.core.maps.DJIMap;
import com.dji.mapkit.core.models.DJILatLng;
import dji.ux.widget.MapWidget;

/**
 * 首页
 */
public class HomeFragment extends BaseFragment {

    FragmentHomeBinding mBinding;

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentHomeBinding.inflate(layoutInflater, container, false);
        mBinding.mapWidget.initAMap(new MapWidget.OnMapReadyListener() {
            @Override
            public void onMapReady(@NonNull DJIMap map) {
                map.setOnMapClickListener(new DJIMap.OnMapClickListener() {
                    @Override
                    public void onMapClick(DJILatLng latLng) {
//                        onViewClick(mapWidget);
                    }
                });
                map.getUiSettings().setZoomControlsEnabled(false);
            }
        });
        mBinding.mapWidget.onCreate(savedInstanceState);
        initView();
        return mBinding;
    }

    private void initView() {
        mBinding.layoutProject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBinding.rvProject.getVisibility() == View.VISIBLE) {
                    mBinding.rvProject.setVisibility(View.GONE);
                    mBinding.ivPoint.setBackgroundDrawable(getActivity().getDrawable(R.mipmap.ic_home_project_up));
                } else {
                    mBinding.rvProject.setVisibility(View.VISIBLE);
                    mBinding.ivPoint.setBackgroundDrawable(getActivity().getDrawable(R.mipmap.ic_home_project_down));
                }
            }
        });
    }

    @Override
    protected void initDatas() {
        mBinding.mapWidget.onResume();
        HomeProjectAdapter adapter = new HomeProjectAdapter();
        RecyclerViewHelper.initRecyclerViewG(getActivity(), mBinding.rvProject, adapter, 2);
    }

    @Override
    public void onPause() {
        super.onPause();
        mBinding.mapWidget.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mBinding.mapWidget.onDestroy();
    }
}
