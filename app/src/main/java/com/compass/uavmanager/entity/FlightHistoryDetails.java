package com.compass.uavmanager.entity;

public class FlightHistoryDetails {

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
        private String landingTime;
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
         * videoId
         */
        private Integer videoId;
        /**
         * videoPath
         */
        private String videoPath;
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

        public String getLandingTime() {
            return landingTime;
        }

        public void setLandingTime(String landingTime) {
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

        public Integer getVideoId() {
            return videoId;
        }

        public void setVideoId(Integer videoId) {
            this.videoId = videoId;
        }

        public String getVideoPath() {
            return videoPath;
        }

        public void setVideoPath(String videoPath) {
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
