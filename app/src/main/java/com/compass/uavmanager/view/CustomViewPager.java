package com.compass.uavmanager.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.viewpager.widget.ViewPager;

public class CustomViewPager extends ViewPager {

    private boolean result = false;
    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);  
    }  
  
    public CustomViewPager(Context context) {
        super(context);  
    }  
      
    //去除页面切换时的滑动翻页效果  
        @Override
        public void setCurrentItem(int item, boolean smoothScroll) {  
            // TODO Auto-generated method stub  
            super.setCurrentItem(item, smoothScroll);  
        }  
  
        @Override
        public void setCurrentItem(int item) {  
            // TODO Auto-generated method stub  
            super.setCurrentItem(item, false);  
        }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        if (result)
            return super.onInterceptTouchEvent(arg0);
        else
            return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        if (result)
            return super.onTouchEvent(arg0);
        else
            return false;
    }
}  