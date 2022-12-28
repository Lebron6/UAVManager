package com.compass.uavmanager.entity;

import java.util.List;

public class OverView {
    /**
     * success
     */
    private Boolean success;
    /**
     * code
     */
    private String code;
    /**
     * results
     */
    private ResultsDTO results;
    /**
     * msg
     */
    private String msg;
    /**
     * total
     */
    private String total;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResultsDTO getResults() {
        return results;
    }

    public void setResults(ResultsDTO results) {
        this.results = results;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public static class ResultsDTO {
        /**
         * uavDataVos
         */
        private List<UavDataVosDTO> uavDataVos;
        /**
         * boundedUavs
         */
        private List<BoundedUavsDTO> boundedUavs;

        public List<UavDataVosDTO> getUavDataVos() {
            return uavDataVos;
        }

        public void setUavDataVos(List<UavDataVosDTO> uavDataVos) {
            this.uavDataVos = uavDataVos;
        }

        public List<BoundedUavsDTO> getBoundedUavs() {
            return boundedUavs;
        }

        public void setBoundedUavs(List<BoundedUavsDTO> boundedUavs) {
            this.boundedUavs = boundedUavs;
        }

        public static class UavDataVosDTO {
            /**
             * uavId
             */
            private String uavId;
            /**
             * uavSn
             */
            private String uavSn;
            /**
             * apronId
             */
            private String apronId;
            /**
             * taskId
             */
            private String taskId;
            /**
             * uavType
             */
            private String uavType;
            /**
             * apronName
             */
            private String apronName;
            /**
             * uavName
             */
            private String uavName;
            /**
             * userName
             */
            private String userName;
            /**
             * uavCode
             */
            private String uavCode;
            /**
             * apronCode
             */
            private String apronCode;
            /**
             * apronAddress
             */
            private String apronAddress;
            /**
             * longitude
             */
            private String longitude;
            /**
             * latitude
             */
            private String latitude;
            /**
             * uavIsOnLine
             */
            private String uavIsOnLine;
            /**
             * apronIsOnLine
             */
            private String apronIsOnLine;
            /**
             * departmentName
             */
            private String departmentName;
            /**
             * indoorTemperature
             */
            private String indoorTemperature;
            /**
             * outdoorTemperature
             */
            private String outdoorTemperature;
            /**
             * windDirection
             */
            private String windDirection;
            /**
             * windSpeed
             */
            private String windSpeed;
            /**
             * windPower
             */
            private String windPower;
            /**
             * isFlying
             */
            private String isFlying;
            /**
             * humidity
             */
            private String humidity;
            /**
             * picUrl
             */
            private String picUrl;

            public String getUavId() {
                return uavId;
            }

            public void setUavId(String uavId) {
                this.uavId = uavId;
            }

            public String getUavSn() {
                return uavSn;
            }

            public void setUavSn(String uavSn) {
                this.uavSn = uavSn;
            }

            public String getApronId() {
                return apronId;
            }

            public void setApronId(String apronId) {
                this.apronId = apronId;
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public String getUavType() {
                return uavType;
            }

            public void setUavType(String uavType) {
                this.uavType = uavType;
            }

            public String getApronName() {
                return apronName;
            }

            public void setApronName(String apronName) {
                this.apronName = apronName;
            }

            public String getUavName() {
                return uavName;
            }

            public void setUavName(String uavName) {
                this.uavName = uavName;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUavCode() {
                return uavCode;
            }

            public void setUavCode(String uavCode) {
                this.uavCode = uavCode;
            }

            public String getApronCode() {
                return apronCode;
            }

            public void setApronCode(String apronCode) {
                this.apronCode = apronCode;
            }

            public String getApronAddress() {
                return apronAddress;
            }

            public void setApronAddress(String apronAddress) {
                this.apronAddress = apronAddress;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getUavIsOnLine() {
                return uavIsOnLine;
            }

            public void setUavIsOnLine(String uavIsOnLine) {
                this.uavIsOnLine = uavIsOnLine;
            }

            public String getApronIsOnLine() {
                return apronIsOnLine;
            }

            public void setApronIsOnLine(String apronIsOnLine) {
                this.apronIsOnLine = apronIsOnLine;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public String getIndoorTemperature() {
                return indoorTemperature;
            }

            public void setIndoorTemperature(String indoorTemperature) {
                this.indoorTemperature = indoorTemperature;
            }

            public String getOutdoorTemperature() {
                return outdoorTemperature;
            }

            public void setOutdoorTemperature(String outdoorTemperature) {
                this.outdoorTemperature = outdoorTemperature;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(String windSpeed) {
                this.windSpeed = windSpeed;
            }

            public String getWindPower() {
                return windPower;
            }

            public void setWindPower(String windPower) {
                this.windPower = windPower;
            }

            public String getIsFlying() {
                return isFlying;
            }

            public void setIsFlying(String isFlying) {
                this.isFlying = isFlying;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }
        }

        public static class BoundedUavsDTO {
            /**
             * uavId
             */
            private String uavId;
            /**
             * uavSn
             */
            private String uavSn;
            /**
             * apronId
             */
            private String apronId;
            /**
             * taskId
             */
            private String taskId;
            /**
             * uavType
             */
            private String uavType;
            /**
             * apronName
             */
            private String apronName;
            /**
             * uavName
             */
            private String uavName;
            /**
             * userName
             */
            private String userName;
            /**
             * uavCode
             */
            private String uavCode;
            /**
             * apronCode
             */
            private String apronCode;
            /**
             * apronAddress
             */
            private String apronAddress;
            /**
             * longitude
             */
            private String longitude;
            /**
             * latitude
             */
            private String latitude;
            /**
             * uavIsOnLine
             */
            private String uavIsOnLine;
            /**
             * apronIsOnLine
             */
            private String apronIsOnLine;
            /**
             * departmentName
             */
            private String departmentName;
            /**
             * indoorTemperature
             */
            private String indoorTemperature;
            /**
             * outdoorTemperature
             */
            private String outdoorTemperature;
            /**
             * windDirection
             */
            private String windDirection;
            /**
             * windSpeed
             */
            private String windSpeed;
            /**
             * windPower
             */
            private String windPower;
            /**
             * isFlying
             */
            private String isFlying;
            /**
             * humidity
             */
            private String humidity;
            /**
             * picUrl
             */
            private String picUrl;

            public String getUavId() {
                return uavId;
            }

            public void setUavId(String uavId) {
                this.uavId = uavId;
            }

            public String getUavSn() {
                return uavSn;
            }

            public void setUavSn(String uavSn) {
                this.uavSn = uavSn;
            }

            public String getApronId() {
                return apronId;
            }

            public void setApronId(String apronId) {
                this.apronId = apronId;
            }

            public String getTaskId() {
                return taskId;
            }

            public void setTaskId(String taskId) {
                this.taskId = taskId;
            }

            public String getUavType() {
                return uavType;
            }

            public void setUavType(String uavType) {
                this.uavType = uavType;
            }

            public String getApronName() {
                return apronName;
            }

            public void setApronName(String apronName) {
                this.apronName = apronName;
            }

            public String getUavName() {
                return uavName;
            }

            public void setUavName(String uavName) {
                this.uavName = uavName;
            }

            public String getUserName() {
                return userName;
            }

            public void setUserName(String userName) {
                this.userName = userName;
            }

            public String getUavCode() {
                return uavCode;
            }

            public void setUavCode(String uavCode) {
                this.uavCode = uavCode;
            }

            public String getApronCode() {
                return apronCode;
            }

            public void setApronCode(String apronCode) {
                this.apronCode = apronCode;
            }

            public String getApronAddress() {
                return apronAddress;
            }

            public void setApronAddress(String apronAddress) {
                this.apronAddress = apronAddress;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getUavIsOnLine() {
                return uavIsOnLine;
            }

            public void setUavIsOnLine(String uavIsOnLine) {
                this.uavIsOnLine = uavIsOnLine;
            }

            public String getApronIsOnLine() {
                return apronIsOnLine;
            }

            public void setApronIsOnLine(String apronIsOnLine) {
                this.apronIsOnLine = apronIsOnLine;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public String getIndoorTemperature() {
                return indoorTemperature;
            }

            public void setIndoorTemperature(String indoorTemperature) {
                this.indoorTemperature = indoorTemperature;
            }

            public String getOutdoorTemperature() {
                return outdoorTemperature;
            }

            public void setOutdoorTemperature(String outdoorTemperature) {
                this.outdoorTemperature = outdoorTemperature;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public String getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(String windSpeed) {
                this.windSpeed = windSpeed;
            }

            public String getWindPower() {
                return windPower;
            }

            public void setWindPower(String windPower) {
                this.windPower = windPower;
            }

            public String getIsFlying() {
                return isFlying;
            }

            public void setIsFlying(String isFlying) {
                this.isFlying = isFlying;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }
        }
    }
}
