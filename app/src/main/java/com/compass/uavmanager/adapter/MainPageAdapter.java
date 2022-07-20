package com.compass.uavmanager.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.compass.uavmanager.fragment.EquipmentFragment;
import com.compass.uavmanager.fragment.FlightHistoryFragment;
import com.compass.uavmanager.fragment.GalleryFragment;
import com.compass.uavmanager.fragment.HomeFragment;
import com.compass.uavmanager.fragment.PersonalFragment;

public class MainPageAdapter extends FragmentPagerAdapter {

    private HomeFragment homeFragment;
    private EquipmentFragment equipmentFragment;
//    private FlightHistoryFragment flightHistoryFragment;
    private GalleryFragment galleryFragment;
    private PersonalFragment personalFragment;

    public MainPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            if(homeFragment==null){
                homeFragment = new HomeFragment();
                return homeFragment;
            }else{
                return homeFragment;
            }
        }else if (position==1){
            if(equipmentFragment ==null){
                equipmentFragment = new EquipmentFragment();
                return equipmentFragment;
            }else{
                return equipmentFragment;
            }
        }else if(position==2){
            if(galleryFragment==null){
                galleryFragment = new GalleryFragment();
                return galleryFragment;
            }else{
                return galleryFragment;
            }
        }else if(position==3){
            if(personalFragment==null){
                personalFragment = new PersonalFragment();
                return personalFragment;
            }else{
                return personalFragment;
            }
        }else{
            return null;
        }
    }

    @Override
    public int getCount() {
        return 4;
    }


}
