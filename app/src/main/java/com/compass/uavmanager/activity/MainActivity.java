package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RadioGroup;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;
import com.compass.uavmanager.R;
import com.compass.uavmanager.adapter.MainPageAdapter;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityMainBinding;
import com.compass.uavmanager.tools.SH1Utils;

/**
 * 主页
 */
public class MainActivity extends BaseActivity {

    private MainPageAdapter pageAdapter;
    private ActivityMainBinding mBinding;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }
@Override
    public void initView() {
        pageAdapter = new MainPageAdapter(getSupportFragmentManager());
        mBinding.vpContent.setAdapter(pageAdapter);
        mBinding.vpContent.setOffscreenPageLimit(4);
        mBinding.vpContent.setOnPageChangeListener(onPagerChangerListener);
        mBinding.rgMain.setOnCheckedChangeListener(onCheckedChangeListener);
        mBinding.rbHome.setChecked(true);
    }

    @Override
    public void initData() {
        Log.e("sh1:", SH1Utils.getSHA1(this));
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    ViewPager.OnPageChangeListener onPagerChangerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mBinding.rbHome.setChecked(true);
                    break;
                case 1:
                    mBinding.rbEquipment.setChecked(true);
                    break;
                case 2:
                    mBinding.rbFlightHistory.setChecked(true);
                    break;
                case 3:
                    mBinding.rbGallery.setChecked(true);
                    break;
                case 4:
                    mBinding.rbPersonal.setChecked(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            setTabSelection(checkedId);
        }
    };

    private void setTabSelection(int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                mBinding.vpContent.setCurrentItem(0, false);
                break;
            case R.id.rb_equipment:
                mBinding.vpContent.setCurrentItem(1, false);
                break;
            case R.id.rb_flight_history:
                mBinding.vpContent.setCurrentItem(2, false);
                break;
            case R.id.rb_gallery:
                mBinding.vpContent.setCurrentItem(3, false);
                break;
            case R.id.rb_personal:
                mBinding.vpContent.setCurrentItem(4, false);
                break;


        }
    }


    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return mBinding;
    }
}