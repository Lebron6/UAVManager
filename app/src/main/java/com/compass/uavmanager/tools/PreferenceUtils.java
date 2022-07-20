package com.compass.uavmanager.tools;

import android.content.Context;
import com.compass.uavmanager.app.UAVApp;


/**
 * 具体实现sp Created by James on 2016/10/30.
 */
public class PreferenceUtils extends BasePreference {

    private static PreferenceUtils preferenceUtils;

    /**
     * 需要增加key就在这里新建
     */
    //用户名的key  
    private String USER_NAME = "user_name";

    private String USER_PASSWORD = "user_password";


    public void loginOut() {
        userLoginOut();
    }

    public void setUserName(String name) {
        setString(USER_NAME, name);
    }

    public String getUserName() {
        return getString(USER_NAME);
    }

    public void setUserPassword(String password) {
        setString(USER_PASSWORD, password);
    }

    public String getUserPassword() {
        return getString(USER_PASSWORD);
    }


    private PreferenceUtils(Context context) {
        super(context);
    }

    /**
     * 这里我通过自定义的Application来获取Context对象，所以在获取preferenceUtils时不需要传入Context。
     * @return
     */
    public synchronized static PreferenceUtils getInstance() {
        if (null == preferenceUtils) {
            preferenceUtils = new PreferenceUtils(UAVApp.getApplication());
        }
        return preferenceUtils;
    }
}