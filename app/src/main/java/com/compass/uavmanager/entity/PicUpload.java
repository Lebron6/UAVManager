package com.compass.uavmanager.entity;

import java.util.List;

public class PicUpload {
    private int picCount;
    private List<Thum> thums;

    public int getPicCount() {
        return picCount;
    }

    public void setPicCount(int picCount) {
        this.picCount = picCount;
    }

    public List<Thum> getThums() {
        return thums;
    }

    public void setThums(List<Thum> thums) {
        this.thums = thums;
    }
}
