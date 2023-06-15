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

    //用户token的key
    private String USER_TOKEN = "user_token";

    //用户上云token的key
    private String USER_CLOUD_TOKEN = "user_cloud_token";

    //用户ID的key
    private String USER_ID = "user_id";

    //是否登录的key
    private String LOGIN_STATUS = "login_status";

    //角色类型
    private String USER_ROLE = "user_role";

    //DJISDK注册
    private String REGISTER_STATUS;

    private String SOCKET_HOST="socket_host"; //SOCKET IP 地址
    private String SOCKET_PORT="socket_port"; //SOCKET 端口
    private String HTTP_IP="http_ip"; //HTTP IP 地址
    private String FLY_NUMBER = "fly_number";//飞行器编号


    public void loginOut() {
        userLoginOut();
    }

    public void setFlyNumber(String fly_number) {
        setString(FLY_NUMBER, fly_number);
    }

    public String getFlyNumber() {
        return getString(FLY_NUMBER);
    }


    public void setHttpIp(String http_ip) {
        setString(HTTP_IP, http_ip);
    }

    public String getHttpIp() {
        return getString(HTTP_IP);
    }


    public void setSocketPort(int socket_port) {
        setInt(SOCKET_PORT, socket_port);
    }

    public int getSocketPort() {
        return getInt(SOCKET_PORT);
    }

    public void setSocketHost(String socket_host) {
        setString(SOCKET_HOST, socket_host);
    }

    public String getSocketHost() {
        return getString(SOCKET_HOST);
    }

    public void setRegisterStatus(Boolean registerStatus) {
        setBoolean(REGISTER_STATUS, registerStatus);
    }

    public Boolean getRegisterStatus() {
        return getBoolean(REGISTER_STATUS);
    }

    public void setLoginStatus(boolean isFirst) {
        setBoolean(LOGIN_STATUS, isFirst);
    }

    public boolean getLoginStatus() {
        return getBoolean(LOGIN_STATUS);
    }

    public void setUserID(String id) {
        setString(USER_ID, id);
    }

    public String getUserId() {
        return getString(USER_ID);
    }

    public void setUserRole(String role) {
        setString(USER_ROLE, role);
    }

    public String getUserRole() {
        return getString(USER_ROLE);
    }

    public String getUserToken() {
        return getString(USER_TOKEN);

    }

    public void setUserToken(String token) {
        setString(USER_TOKEN, token);
    }

    public String getUserCloudToken() {
        return getString(USER_CLOUD_TOKEN);

    }

    public void setUserCloudToken(String token) {
        setString(USER_CLOUD_TOKEN, token);
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
     *
     * @return
     */
    public synchronized static PreferenceUtils getInstance() {
        if (null == preferenceUtils) {
            preferenceUtils = new PreferenceUtils(UAVApp.getApplication());
        }
        return preferenceUtils;
    }
}