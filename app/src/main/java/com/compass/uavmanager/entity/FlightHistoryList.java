package com.compass.uavmanager.entity;

import java.util.List;

public class FlightHistoryList {
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
    private List<ResultsDTO> results;
    /**
     * msg
     */
    private String msg;
    /**
     * total
     */
    private Integer total;

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

    public List<ResultsDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultsDTO> results) {
        this.results = results;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public static class ResultsDTO {
        /**
         * id
         */
        private Integer id;
        /**
         * uavType
         */
        private String uavType;
        /**
         * uavName
         */
        private String uavName;
        /**
         * uavCode
         */
        private String uavCode;
        /**
         * operator
         */
        private String operator;
        /**
         * flightTime
         */
        private String flightTime;
        /**
         * landingTime
         */
        private Object landingTime;
        /**
         * address
         */
        private String address;
        /**
         * flyingTime
         */
        private String flyingTime;
        /**
         * flightModel
         */
        private String flightModel;
        /**
         * longitude
         */
        private String longitude;
        /**
         * latitude
         */
        private String latitude;
        /**
         * fileVos
         */
        private Object fileVos;
        /**
         * videoId
         */
        private Object videoId;
        /**
         * videoPath
         */
        private Object videoPath;
        /**
         * source
         */
        private Integer source;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUavType() {
            return uavType;
        }

        public void setUavType(String uavType) {
            this.uavType = uavType;
        }

        public String getUavName() {
            return uavName;
        }

        public void setUavName(String uavName) {
            this.uavName = uavName;
        }

        public String getUavCode() {
            return uavCode;
        }

        public void setUavCode(String uavCode) {
            this.uavCode = uavCode;
        }

        public String getOperator() {
            return operator;
        }

        public void setOperator(String operator) {
            this.operator = operator;
        }

        public String getFlightTime() {
            return flightTime;
        }

        public void setFlightTime(String flightTime) {
            this.flightTime = flightTime;
        }

        public Object getLandingTime() {
            return landingTime;
        }

        public void setLandingTime(Object landingTime) {
            this.landingTime = landingTime;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getFlyingTime() {
            return flyingTime;
        }

        public void setFlyingTime(String flyingTime) {
            this.flyingTime = flyingTime;
        }

        public String getFlightModel() {
            return flightModel;
        }

        public void setFlightModel(String flightModel) {
            this.flightModel = flightModel;
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

        public Object getFileVos() {
            return fileVos;
        }

        public void setFileVos(Object fileVos) {
            this.fileVos = fileVos;
        }

        public Object getVideoId() {
            return videoId;
        }

        public void setVideoId(Object videoId) {
            this.videoId = videoId;
        }

        public Object getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(Object videoPath) {
            this.videoPath = videoPath;
        }

        public Integer getSource() {
            return source;
        }

        public void setSource(Integer source) {
            this.source = source;
        }
    }
}
