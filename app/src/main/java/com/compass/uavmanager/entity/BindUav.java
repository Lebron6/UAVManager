package com.compass.uavmanager.entity;

import java.util.List;

public class BindUav {
    /**
     * uavId
     */
    private List<String> uavId;
    /**
     * userName
     */
    private String userName;

    public List<String> getUavId() {
        return uavId;
    }

    public void setUavId(List<String> uavId) {
        this.uavId = uavId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
