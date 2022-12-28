package com.compass.uavmanager.entity;

public class DataCache {

    private static class DataCacheHolder {
        private static final DataCache INSTANCE = new DataCache();
    }

    private DataCache(){}

    public static final DataCache getInstance() {
        return DataCacheHolder.INSTANCE;
    }

    //rtmp地址
    private String rtmp_address;

    private int missionWaypointSize;

    private int targetWaypointIndex;

    private int missionExecuteState;

    //航线执行错误
    private String missionExecuteError="";

    public String getMissionExecuteError() {
        return missionExecuteError;
    }

    public void setMissionExecuteError(String missionExecuteError) {
        this.missionExecuteError = missionExecuteError;
    }

    //图传信号
    private int downlinkQuality;
    //SN
    private String sn;

    //RTKStatus
    private String rtkStatus;
    //录像状态
    private int recordStatus=0;
    private String recordTime="";
    //带宽
    private String channelBandwidth="";
    //图传码率
    private String transcodingDataRate="";
    //干扰功率范围为[-60，-100] dBm。较小的负值表示干扰较小，通信质量较好。所有中文自己根据值写一下
    private String interferencePower="";

    public String getChannelBandwidth() {
        return channelBandwidth;
    }

    public void setChannelBandwidth(String channelBandwidth) {
        this.channelBandwidth = channelBandwidth;
    }

    public String getTranscodingDataRate() {
        return transcodingDataRate;
    }

    public void setTranscodingDataRate(String transcodingDataRate) {
        this.transcodingDataRate = transcodingDataRate;
    }

    public String getInterferencePower() {
        return interferencePower;
    }

    public void setInterferencePower(String interferencePower) {
        this.interferencePower = interferencePower;
    }

    public int getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(int recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public String getRtkStatus() {
        return rtkStatus;
    }

    public void setRtkStatus(String rtkStatus) {
        this.rtkStatus = rtkStatus;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public int getDownlinkQuality() {
        return downlinkQuality;
    }

    public void setDownlinkQuality(int downlinkQuality) {
        this.downlinkQuality = downlinkQuality;
    }

    public int getUplinkQuality() {
        return uplinkQuality;
    }

    public void setUplinkQuality(int uplinkQuality) {
        this.uplinkQuality = uplinkQuality;
    }

    //遥控信号
    private int uplinkQuality;

    public int getTargetWaypointIndex() {
        return targetWaypointIndex;
    }

    public void setTargetWaypointIndex(int targetWaypointIndex) {
        this.targetWaypointIndex = targetWaypointIndex;
    }

    public int getMissionExecuteState() {
        return missionExecuteState;
    }

    public void setMissionExecuteState(int missionExecuteState) {
        this.missionExecuteState = missionExecuteState;
    }

    public int getMissionWaypointSize() {
        return missionWaypointSize;
    }

    public void setMissionWaypointSize(int missionWaypointSize) {
        this.missionWaypointSize = missionWaypointSize;
    }

    public String getRtmp_address() {
        return rtmp_address;
    }

    public void setRtmp_address(String rtmp_address) {
        this.rtmp_address = rtmp_address;
    }

}
