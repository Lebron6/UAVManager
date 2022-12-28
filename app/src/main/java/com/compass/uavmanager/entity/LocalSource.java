package com.compass.uavmanager.entity;


public class LocalSource {

    private static class MovementHolder {
        private static final LocalSource INSTANCE = new LocalSource();
    }

    private LocalSource() {
    }

    public static final LocalSource getInstance() {
        return MovementHolder.INSTANCE;
    }
    //云台模式
    private int gimbalMode;
    //RTK开关
    private int rtkSwitch;
    //RTK状态保持
    private int rtkMaintainPositioningAccuracy;
    //ISO
    private int ISO;
    //曝光补偿
    private int exposureCompensation;
    //曝光模式
    private int exposureMode;
    //Shutter
    private Float shutter;
    //相机模式
    private int cameraMode;
    //变焦焦距
    private int hybridZoom;
    //变焦焦距(H20T)
    private int opticalZoom;

    public int getOpticalZoom() {
        return opticalZoom;
    }

    public void setOpticalZoom(int opticalZoom) {
        this.opticalZoom = opticalZoom;
    }

    //获取当前是哪个镜头
    private String currentLens;
    //获取对焦模式
    private String focusMode;
    //获取是否曝光锁定
    private String lockExposure;
    //获取红外的焦距
    private String thermalDigitalZoom;

    //获取四个灯光
    private String beacons;
    private String front;
    private String rear;
    private String statusIndicator;
    //红外分屏
    private String hyDisplayMode;
    //当前流是不是fpv
    private String currentVideoSource;
    //低电量
    private String lowBatteryWarning;
    //严重低电量
    private String seriousLowBatteryWarning;
    //智能返航
    private boolean smartReturnToHomeEnabled;
    //视觉定位
    private boolean visionAssistedPosition;
    //精准着陆
    private boolean precisionLand;
    //障碍物检测
    private boolean collisionAvoidance;
    //上避障
    private boolean upwardsAvoidance;

    //下避障
    private boolean landingProtection;
    //    上避障安全距离范围为[1.0，10]
    private String avoidanceDistanceUpward;
    //    下避障安全距离范围为[0.1，3]
    private String avoidanceDistanceDownward;
    //水平避障安全距离范围为[1.0，5]
    private String avoidanceDistanceHorizontal;
    //上避障感知距离5m〜45m
    private String maxPerceptionDistanceUpward;
    //下避障感知距离5m〜45m
    private String maxPerceptionDistanceDownward;
    //水平障感知距离5m〜45m
    private String maxPerceptionDistanceHorizontal;
    //避障刹车功能
    private boolean activeObstacleAvoidance;
    //云台俯仰速度1——100
    private String gimbal_pitch_speed;
    //云台偏航速度1——100
    private String gimbal_yaw_speed;
    //带宽
    private String channelBandwidth;
    //工作频段 2.4g 5.8g 双频
    private String frequencyBand;
    //图传码率
    private String transcodingDataRate;
    //干扰功率范围为[-60，-100] dBm。较小的负值表示干扰较小，通信质量较好。所有中文自己根据值写一下
    private String interferencePower;

    //云台俯仰限位扩展
    private boolean pitchRangeExtension;

    //返航高度
    private String goHomeHeightInMeters = "";
    //限高
    private String maxFlightHeight = "";
    //限远
    private String maxFlightRadius = "";
    //限远开关
    private boolean maxFlightRadiusLimitationEnabled;

    public String getGoHomeHeightInMeters() {
        return goHomeHeightInMeters;
    }

    public void setGoHomeHeightInMeters(String goHomeHeightInMeters) {
        this.goHomeHeightInMeters = goHomeHeightInMeters;
    }

    public String getMaxFlightHeight() {
        return maxFlightHeight;
    }

    public void setMaxFlightHeight(String maxFlightHeight) {
        this.maxFlightHeight = maxFlightHeight;
    }

    public String getMaxFlightRadius() {
        return maxFlightRadius;
    }

    public void setMaxFlightRadius(String maxFlightRadius) {
        this.maxFlightRadius = maxFlightRadius;
    }
    public int getGimbalMode() {
        return gimbalMode;
    }

    public void setGimbalMode(int gimbalMode) {
        this.gimbalMode = gimbalMode;
    }

    public boolean isMaxFlightRadiusLimitationEnabled() {
        return maxFlightRadiusLimitationEnabled;
    }

    public void setMaxFlightRadiusLimitationEnabled(boolean maxFlightRadiusLimitationEnabled) {
        this.maxFlightRadiusLimitationEnabled = maxFlightRadiusLimitationEnabled;
    }


    public boolean isPitchRangeExtension() {
        return pitchRangeExtension;
    }

    public void setPitchRangeExtension(boolean pitchRangeExtension) {
        this.pitchRangeExtension = pitchRangeExtension;
    }

    public String getChannelBandwidth() {
        return channelBandwidth;
    }

    public void setChannelBandwidth(String channelBandwidth) {
        this.channelBandwidth = channelBandwidth;
    }

    public String getFrequencyBand() {
        return frequencyBand;
    }

    public void setFrequencyBand(String frequencyBand) {
        this.frequencyBand = frequencyBand;
    }


    public String getGimbal_pitch_speed() {
        return gimbal_pitch_speed;
    }

    public void setGimbal_pitch_speed(String gimbal_pitch_speed) {
        this.gimbal_pitch_speed = gimbal_pitch_speed;
    }

    public String getGimbal_yaw_speed() {
        return gimbal_yaw_speed;
    }

    public void setGimbal_yaw_speed(String gimbal_yaw_speed) {
        this.gimbal_yaw_speed = gimbal_yaw_speed;
    }

    public String getAvoidanceDistanceHorizontal() {
        return avoidanceDistanceHorizontal;
    }

    public void setAvoidanceDistanceHorizontal(String avoidanceDistanceHorizontal) {
        this.avoidanceDistanceHorizontal = avoidanceDistanceHorizontal;
    }

    public String getMaxPerceptionDistanceHorizontal() {
        return maxPerceptionDistanceHorizontal;
    }

    public void setMaxPerceptionDistanceHorizontal(String maxPerceptionDistanceHorizontal) {
        this.maxPerceptionDistanceHorizontal = maxPerceptionDistanceHorizontal;
    }

    public boolean isActiveObstacleAvoidance() {
        return activeObstacleAvoidance;
    }

    public void setActiveObstacleAvoidance(boolean activeObstacleAvoidance) {
        this.activeObstacleAvoidance = activeObstacleAvoidance;
    }

    public String getLowBatteryWarning() {
        return lowBatteryWarning;
    }

    public void setLowBatteryWarning(String lowBatteryWarning) {
        this.lowBatteryWarning = lowBatteryWarning;
    }

    public String getSeriousLowBatteryWarning() {
        return seriousLowBatteryWarning;
    }

    public void setSeriousLowBatteryWarning(String seriousLowBatteryWarning) {
        this.seriousLowBatteryWarning = seriousLowBatteryWarning;
    }

    public boolean isSmartReturnToHomeEnabled() {
        return smartReturnToHomeEnabled;
    }

    public void setSmartReturnToHomeEnabled(boolean smartReturnToHomeEnabled) {
        this.smartReturnToHomeEnabled = smartReturnToHomeEnabled;
    }

    public boolean isVisionAssistedPosition() {
        return visionAssistedPosition;
    }

    public void setVisionAssistedPosition(boolean visionAssistedPosition) {
        this.visionAssistedPosition = visionAssistedPosition;
    }

    public boolean isPrecisionLand() {
        return precisionLand;
    }

    public void setPrecisionLand(boolean precisionLand) {
        this.precisionLand = precisionLand;
    }

    public boolean isUpwardsAvoidance() {
        return upwardsAvoidance;
    }

    public void setUpwardsAvoidance(boolean upwardsAvoidance) {
        this.upwardsAvoidance = upwardsAvoidance;
    }

    public String getAvoidanceDistanceUpward() {
        return avoidanceDistanceUpward;
    }

    public void setAvoidanceDistanceUpward(String avoidanceDistanceUpward) {
        this.avoidanceDistanceUpward = avoidanceDistanceUpward;
    }

    public String getAvoidanceDistanceDownward() {
        return avoidanceDistanceDownward;
    }

    public void setAvoidanceDistanceDownward(String avoidanceDistanceDownward) {
        this.avoidanceDistanceDownward = avoidanceDistanceDownward;
    }

    public String getMaxPerceptionDistanceUpward() {
        return maxPerceptionDistanceUpward;
    }

    public void setMaxPerceptionDistanceUpward(String maxPerceptionDistanceUpward) {
        this.maxPerceptionDistanceUpward = maxPerceptionDistanceUpward;
    }

    public String getMaxPerceptionDistanceDownward() {
        return maxPerceptionDistanceDownward;
    }

    public void setMaxPerceptionDistanceDownward(String maxPerceptionDistanceDownward) {
        this.maxPerceptionDistanceDownward = maxPerceptionDistanceDownward;
    }


    public boolean isCollisionAvoidance() {
        return collisionAvoidance;
    }

    public void setCollisionAvoidance(boolean collisionAvoidance) {
        this.collisionAvoidance = collisionAvoidance;
    }

    public boolean isLandingProtection() {
        return landingProtection;
    }

    public void setLandingProtection(boolean landingProtection) {
        this.landingProtection = landingProtection;
    }


    public int getISO() {
        return ISO;
    }

    public void setISO(int ISO) {
        this.ISO = ISO;
    }

    public int getExposureCompensation() {
        return exposureCompensation;
    }

    public void setExposureCompensation(int exposureCompensation) {
        this.exposureCompensation = exposureCompensation;
    }

    public int getExposureMode() {
        return exposureMode;
    }

    public void setExposureMode(int exposureMode) {
        this.exposureMode = exposureMode;
    }

    public Float getShutter() {
        return shutter;
    }

    public void setShutter(Float shutter) {
        this.shutter = shutter;
    }

    public int getCameraMode() {
        return cameraMode;
    }

    public void setCameraMode(int cameraMode) {
        this.cameraMode = cameraMode;
    }


    public int getHybridZoom() {
        return hybridZoom;
    }

    public void setHybridZoom(int hybridZoom) {
        this.hybridZoom = hybridZoom;
    }

    public String getCurrentLens() {
        return currentLens;
    }

    public void setCurrentLens(String currentLens) {
        this.currentLens = currentLens;
    }

    public String getFocusMode() {
        return focusMode;
    }

    public void setFocusMode(String focusMode) {
        this.focusMode = focusMode;
    }

    public String getLockExposure() {
        return lockExposure;
    }

    public void setLockExposure(String lockExposure) {
        this.lockExposure = lockExposure;
    }

    public String getThermalDigitalZoom() {
        return thermalDigitalZoom;
    }

    public void setThermalDigitalZoom(String thermalDigitalZoom) {
        this.thermalDigitalZoom = thermalDigitalZoom;
    }

    public String getBeacons() {
        return beacons;
    }

    public void setBeacons(String beacons) {
        this.beacons = beacons;
    }

    public String getFront() {
        return front;
    }

    public void setFront(String front) {
        this.front = front;
    }

    public String getRear() {
        return rear;
    }

    public void setRear(String rear) {
        this.rear = rear;
    }

    public String getStatusIndicator() {
        return statusIndicator;
    }

    public void setStatusIndicator(String statusIndicator) {
        this.statusIndicator = statusIndicator;
    }

    public String getHyDisplayMode() {
        return hyDisplayMode;
    }

    public void setHyDisplayMode(String hyDisplayMode) {
        this.hyDisplayMode = hyDisplayMode;
    }

    public String getCurrentVideoSource() {
        return currentVideoSource;
    }

    public void setCurrentVideoSource(String currentVideoSource) {
        this.currentVideoSource = currentVideoSource;
    }


    public int getRtkSwitch() {
        return rtkSwitch;
    }

    public void setRtkSwitch(int rtkSwitch) {
        this.rtkSwitch = rtkSwitch;
    }

    public int getRtkMaintainPositioningAccuracy() {
        return rtkMaintainPositioningAccuracy;
    }

    public void setRtkMaintainPositioningAccuracy(int rtkMaintainPositioningAccuracy) {
        this.rtkMaintainPositioningAccuracy = rtkMaintainPositioningAccuracy;
    }


}
