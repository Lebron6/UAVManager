package com.compass.uavmanager.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;

import com.compass.uavmanager.R;
import com.compass.uavmanager.adapter.MyPagerAdapter;
import com.compass.uavmanager.base.BaseFragment;
import com.compass.uavmanager.callback.CustomTabEntity;
import com.compass.uavmanager.callback.OnTabSelectListener;
import com.compass.uavmanager.databinding.FragmentEquipmentBinding;
import com.compass.uavmanager.entity.TabEntity;
import com.compass.uavmanager.fragment.equipment.EquipmentType;

import java.util.ArrayList;

/**
 * 设备管理
 */
public class EquipmentFragment extends BaseFragment {
    FragmentEquipmentBinding mBinding;

    private ArrayList<Fragment> mFragments=new ArrayList<>() ;
    private String[] mTitles=new String[]{"全部", "在线设备", "离线设备"} ;
    private ArrayList<CustomTabEntity> mTabEntities=new ArrayList<>() ;

    @Override
    public ViewBinding getViewBinding(LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = FragmentEquipmentBinding.inflate(layoutInflater, container, false);
        initView();
        return mBinding;
    }

    private void initView() {

        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], R.drawable.bg_nav_equipment_pre, R.drawable.bg_nav_equipment_nor));
            mFragments.add(new EquipmentType(i));
        }
        mBinding.tabEquipment.setTabData(mTabEntities);
//        MyPagerAdapter myPagerAdapter =new MyPagerAdapter(getActivity().getSupportFragmentManager(),mFragments,mTitles);
        MyPagerAdapter myPagerAdapter =new MyPagerAdapter(getChildFragmentManager(),mFragments,mTitles);
        mBinding.vpEquipment.setAdapter(myPagerAdapter);
        mBinding.tabEquipment.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mBinding.vpEquipment.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
//                if (position == 0) {
//                    mTabLayout_2.showMsg(0, mRandom.nextInt(100) + 1);
////                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), mRandom.nextInt(100) + 1);
//                }
            }
        });
        mBinding.vpEquipment.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBinding.tabEquipment.setCurrentTab(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mBinding.vpEquipment.setCurrentItem(0);
    }

    @Override
    protected void initDatas() {

    }
}
