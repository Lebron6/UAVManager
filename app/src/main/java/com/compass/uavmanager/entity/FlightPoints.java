package com.compass.uavmanager.entity;

import java.util.List;

public class FlightPoints {
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
         * flightPointInfoVos
         */
        private List<FlightPointInfoVosDTO> flightPointInfoVos;
        /**
         * points
         */
        private List<List<String>> points;

        public List<FlightPointInfoVosDTO> getFlightPointInfoVos() {
            return flightPointInfoVos;
        }

        public void setFlightPointInfoVos(List<FlightPointInfoVosDTO> flightPointInfoVos) {
            this.flightPointInfoVos = flightPointInfoVos;
        }

        public List<List<String>> getPoints() {
            return points;
        }

        public void setPoints(List<List<String>> points) {
            this.points = points;
        }

        public static class FlightPointInfoVosDTO {
            /**
             * verticalSpeed
             */
            private String verticalSpeed;
            /**
             * horizontalSpeed
             */
            private String horizontalSpeed;
            /**
             * horizontalHeight
             */
            private String horizontalHeight;
            /**
             * windSpeed
             */
            private String windSpeed;
            /**
             * originDistance
             */
            private String originDistance;
            /**
             * persentOne
             */
            private String persentOne;
            /**
             * persentTwo
             */
            private String persentTwo;
            /**
             * voltageOne
             */
            private String voltageOne;
            /**
             * voltageTwo
             */
            private String voltageTwo;
            /**
             * satelliteCount
             */
            private Integer satelliteCount;
            /**
             * time
             */
            private Long time;

            public String getVerticalSpeed() {
                return verticalSpeed;
            }

            public void setVerticalSpeed(String verticalSpeed) {
                this.verticalSpeed = verticalSpeed;
            }

            public String getHorizontalSpeed() {
                return horizontalSpeed;
            }

            public void setHorizontalSpeed(String horizontalSpeed) {
                this.horizontalSpeed = horizontalSpeed;
            }

            public String getHorizontalHeight() {
                return horizontalHeight;
            }

            public void setHorizontalHeight(String horizontalHeight) {
                this.horizontalHeight = horizontalHeight;
            }

            public String getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(String windSpeed) {
                this.windSpeed = windSpeed;
            }

            public String getOriginDistance() {
                return originDistance;
            }

            public void setOriginDistance(String originDistance) {
                this.originDistance = originDistance;
            }

            public String getPersentOne() {
                return persentOne;
            }

            public void setPersentOne(String persentOne) {
                this.persentOne = persentOne;
            }

            public String getPersentTwo() {
                return persentTwo;
            }

            public void setPersentTwo(String persentTwo) {
                this.persentTwo = persentTwo;
            }

            public String getVoltageOne() {
                return voltageOne;
            }

            public void setVoltageOne(String voltageOne) {
                this.voltageOne = voltageOne;
            }

            public String getVoltageTwo() {
                return voltageTwo;
            }

            public void setVoltageTwo(String voltageTwo) {
                this.voltageTwo = voltageTwo;
            }

            public Integer getSatelliteCount() {
                return satelliteCount;
            }

            public void setSatelliteCount(Integer satelliteCount) {
                this.satelliteCount = satelliteCount;
            }

            public Long getTime() {
                return time;
            }

            public void setTime(Long time) {
                this.time = time;
            }
        }
    }
}
