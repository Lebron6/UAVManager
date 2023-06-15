package com.compass.uavmanager.entity;

import java.util.List;

public class ICloudSocketInfo {
    /**
     * version
     */
    private String version;
    /**
     * timestamp
     */
    private Long timestamp;
    /**
     * data
     */
    private DataDTO data;
    /**
     * uavCode
     */
    private String uavCode;
    /**
     * uavName
     */
    private String uavName;
    /**
     * sn
     */
    private Object sn;
    /**
     * gateway
     */
    private Object gateway;
    /**
     * biz_code
     */
    private String biz_code;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public String getUavCode() {
        return uavCode;
    }

    public void setUavCode(String uavCode) {
        this.uavCode = uavCode;
    }

    public String getUavName() {
        return uavName;
    }

    public void setUavName(String uavName) {
        this.uavName = uavName;
    }

    public Object getSn() {
        return sn;
    }

    public void setSn(Object sn) {
        this.sn = sn;
    }

    public Object getGateway() {
        return gateway;
    }

    public void setGateway(Object gateway) {
        this.gateway = gateway;
    }

    public String getBiz_code() {
        return biz_code;
    }

    public void setBiz_code(String biz_code) {
        this.biz_code = biz_code;
    }

    public static class DataDTO {
        /**
         * host
         */
        private HostDTO host;
        /**
         * sn
         */
        private String sn;

        public HostDTO getHost() {
            return host;
        }

        public void setHost(HostDTO host) {
            this.host = host;
        }

        public String getSn() {
            return sn;
        }

        public void setSn(String sn) {
            this.sn = sn;
        }

        public static class HostDTO {
            /**
             * attitude_head
             */
            private Double attitude_head;
            /**
             * attitude_pitch
             */
            private Double attitude_pitch;
            /**
             * attitude_roll
             */
            private Double attitude_roll;
            /**
             * elevation
             */
            private Double elevation;
            /**
             * battery
             */
            private BatteryDTO battery;
            /**
             * firmware_version
             */
            private String firmware_version;
            /**
             * gear
             */
            private Integer gear;
            /**
             * height
             */
            private Double height;
            /**
             * home_distance
             */
            private Double home_distance;
            /**
             * horizontal_speed
             */
            private Double horizontal_speed;
            /**
             * latitude
             */
            private Double latitude;
            /**
             * longitude
             */
            private Double longitude;
            /**
             * mode_code
             */
            private Integer mode_code;
            /**
             * total_flight_distance
             */
            private Double total_flight_distance;
            /**
             * total_flight_time
             */
            private Double total_flight_time;
            /**
             * vertical_speed
             */
            private Double vertical_speed;
            /**
             * wind_direction
             */
            private Double wind_direction;
            /**
             * wind_speed
             */
            private Double wind_speed;
            /**
             * position_state
             */
            private PositionStateDTO position_state;
            /**
             * payloads
             */
            private List<PayloadsDTO> payloads;
            /**
             * storage
             */
            private StorageDTO storage;

            public Double getAttitude_head() {
                return attitude_head;
            }

            public void setAttitude_head(Double attitude_head) {
                this.attitude_head = attitude_head;
            }

            public Double getAttitude_pitch() {
                return attitude_pitch;
            }

            public void setAttitude_pitch(Double attitude_pitch) {
                this.attitude_pitch = attitude_pitch;
            }

            public Double getAttitude_roll() {
                return attitude_roll;
            }

            public void setAttitude_roll(Double attitude_roll) {
                this.attitude_roll = attitude_roll;
            }

            public Double getElevation() {
                return elevation;
            }

            public void setElevation(Double elevation) {
                this.elevation = elevation;
            }

            public BatteryDTO getBattery() {
                return battery;
            }

            public void setBattery(BatteryDTO battery) {
                this.battery = battery;
            }

            public String getFirmware_version() {
                return firmware_version;
            }

            public void setFirmware_version(String firmware_version) {
                this.firmware_version = firmware_version;
            }

            public Integer getGear() {
                return gear;
            }

            public void setGear(Integer gear) {
                this.gear = gear;
            }

            public Double getHeight() {
                return height;
            }

            public void setHeight(Double height) {
                this.height = height;
            }

            public Double getHome_distance() {
                return home_distance;
            }

            public void setHome_distance(Double home_distance) {
                this.home_distance = home_distance;
            }

            public Double getHorizontal_speed() {
                return horizontal_speed;
            }

            public void setHorizontal_speed(Double horizontal_speed) {
                this.horizontal_speed = horizontal_speed;
            }

            public Double getLatitude() {
                return latitude;
            }

            public void setLatitude(Double latitude) {
                this.latitude = latitude;
            }

            public Double getLongitude() {
                return longitude;
            }

            public void setLongitude(Double longitude) {
                this.longitude = longitude;
            }

            public Integer getMode_code() {
                return mode_code;
            }

            public void setMode_code(Integer mode_code) {
                this.mode_code = mode_code;
            }

            public Double getTotal_flight_distance() {
                return total_flight_distance;
            }

            public void setTotal_flight_distance(Double total_flight_distance) {
                this.total_flight_distance = total_flight_distance;
            }

            public Double getTotal_flight_time() {
                return total_flight_time;
            }

            public void setTotal_flight_time(Double total_flight_time) {
                this.total_flight_time = total_flight_time;
            }

            public Double getVertical_speed() {
                return vertical_speed;
            }

            public void setVertical_speed(Double vertical_speed) {
                this.vertical_speed = vertical_speed;
            }

            public Double getWind_direction() {
                return wind_direction;
            }

            public void setWind_direction(Double wind_direction) {
                this.wind_direction = wind_direction;
            }

            public Double getWind_speed() {
                return wind_speed;
            }

            public void setWind_speed(Double wind_speed) {
                this.wind_speed = wind_speed;
            }

            public PositionStateDTO getPosition_state() {
                return position_state;
            }

            public void setPosition_state(PositionStateDTO position_state) {
                this.position_state = position_state;
            }

            public List<PayloadsDTO> getPayloads() {
                return payloads;
            }

            public void setPayloads(List<PayloadsDTO> payloads) {
                this.payloads = payloads;
            }

            public StorageDTO getStorage() {
                return storage;
            }

            public void setStorage(StorageDTO storage) {
                this.storage = storage;
            }

            public static class BatteryDTO {
                /**
                 * batteries
                 */
                private List<BatteriesDTO> batteries;
                /**
                 * capacity_percent
                 */
                private Integer capacity_percent;
                /**
                 * landing_power
                 */
                private Integer landing_power;
                /**
                 * remain_flight_time
                 */
                private Integer remain_flight_time;
                /**
                 * return_home_power
                 */
                private Integer return_home_power;

                public List<BatteriesDTO> getBatteries() {
                    return batteries;
                }

                public void setBatteries(List<BatteriesDTO> batteries) {
                    this.batteries = batteries;
                }

                public Integer getCapacity_percent() {
                    return capacity_percent;
                }

                public void setCapacity_percent(Integer capacity_percent) {
                    this.capacity_percent = capacity_percent;
                }

                public Integer getLanding_power() {
                    return landing_power;
                }

                public void setLanding_power(Integer landing_power) {
                    this.landing_power = landing_power;
                }

                public Integer getRemain_flight_time() {
                    return remain_flight_time;
                }

                public void setRemain_flight_time(Integer remain_flight_time) {
                    this.remain_flight_time = remain_flight_time;
                }

                public Integer getReturn_home_power() {
                    return return_home_power;
                }

                public void setReturn_home_power(Integer return_home_power) {
                    this.return_home_power = return_home_power;
                }

                public static class BatteriesDTO {
                    /**
                     * firmware_version
                     */
                    private String firmware_version;
                    /**
                     * index
                     */
                    private Integer index;
                    /**
                     * loop_times
                     */
                    private Integer loop_times;
                    /**
                     * capacity_percent
                     */
                    private Integer capacity_percent;
                    /**
                     * sn
                     */
                    private String sn;
                    /**
                     * sub_type
                     */
                    private Integer sub_type;
                    /**
                     * temperature
                     */
                    private Double temperature;
                    /**
                     * type
                     */
                    private Integer type;
                    /**
                     * voltage
                     */
                    private Integer voltage;

                    public String getFirmware_version() {
                        return firmware_version;
                    }

                    public void setFirmware_version(String firmware_version) {
                        this.firmware_version = firmware_version;
                    }

                    public Integer getIndex() {
                        return index;
                    }

                    public void setIndex(Integer index) {
                        this.index = index;
                    }

                    public Integer getLoop_times() {
                        return loop_times;
                    }

                    public void setLoop_times(Integer loop_times) {
                        this.loop_times = loop_times;
                    }

                    public Integer getCapacity_percent() {
                        return capacity_percent;
                    }

                    public void setCapacity_percent(Integer capacity_percent) {
                        this.capacity_percent = capacity_percent;
                    }

                    public String getSn() {
                        return sn;
                    }

                    public void setSn(String sn) {
                        this.sn = sn;
                    }

                    public Integer getSub_type() {
                        return sub_type;
                    }

                    public void setSub_type(Integer sub_type) {
                        this.sub_type = sub_type;
                    }

                    public Double getTemperature() {
                        return temperature;
                    }

                    public void setTemperature(Double temperature) {
                        this.temperature = temperature;
                    }

                    public Integer getType() {
                        return type;
                    }

                    public void setType(Integer type) {
                        this.type = type;
                    }

                    public Integer getVoltage() {
                        return voltage;
                    }

                    public void setVoltage(Integer voltage) {
                        this.voltage = voltage;
                    }
                }
            }

            public static class PositionStateDTO {
                /**
                 * is_calibration
                 */
                private Object is_calibration;
                /**
                 * gps_number
                 */
                private Integer gps_number;
                /**
                 * is_fixed
                 */
                private Integer is_fixed;
                /**
                 * quality
                 */
                private Integer quality;
                /**
                 * rtk_number
                 */
                private Integer rtk_number;

                public Object getIs_calibration() {
                    return is_calibration;
                }

                public void setIs_calibration(Object is_calibration) {
                    this.is_calibration = is_calibration;
                }

                public Integer getGps_number() {
                    return gps_number;
                }

                public void setGps_number(Integer gps_number) {
                    this.gps_number = gps_number;
                }

                public Integer getIs_fixed() {
                    return is_fixed;
                }

                public void setIs_fixed(Integer is_fixed) {
                    this.is_fixed = is_fixed;
                }

                public Integer getQuality() {
                    return quality;
                }

                public void setQuality(Integer quality) {
                    this.quality = quality;
                }

                public Integer getRtk_number() {
                    return rtk_number;
                }

                public void setRtk_number(Integer rtk_number) {
                    this.rtk_number = rtk_number;
                }
            }

            public static class StorageDTO {
                /**
                 * total
                 */
                private Integer total;
                /**
                 * used
                 */
                private Integer used;

                public Integer getTotal() {
                    return total;
                }

                public void setTotal(Integer total) {
                    this.total = total;
                }

                public Integer getUsed() {
                    return used;
                }

                public void setUsed(Integer used) {
                    this.used = used;
                }
            }

            public static class PayloadsDTO {
                /**
                 * payload_index
                 */
                private String payload_index;
                /**
                 * gimbal_pitch
                 */
                private Double gimbal_pitch;
                /**
                 * gimbal_roll
                 */
                private Double gimbal_roll;
                /**
                 * gimbal_yaw
                 */
                private Double gimbal_yaw;
                /**
                 * measure_target_altitude
                 */
                private Double measure_target_altitude;
                /**
                 * measure_target_distance
                 */
                private Double measure_target_distance;
                /**
                 * measure_target_latitude
                 */
                private Double measure_target_latitude;
                /**
                 * measure_target_longitude
                 */
                private Double measure_target_longitude;
                /**
                 * measure_target_error_state
                 */
                private Integer measure_target_error_state;
                /**
                 * version
                 */
                private Object version;

                public String getPayload_index() {
                    return payload_index;
                }

                public void setPayload_index(String payload_index) {
                    this.payload_index = payload_index;
                }

                public Double getGimbal_pitch() {
                    return gimbal_pitch;
                }

                public void setGimbal_pitch(Double gimbal_pitch) {
                    this.gimbal_pitch = gimbal_pitch;
                }

                public Double getGimbal_roll() {
                    return gimbal_roll;
                }

                public void setGimbal_roll(Double gimbal_roll) {
                    this.gimbal_roll = gimbal_roll;
                }

                public Double getGimbal_yaw() {
                    return gimbal_yaw;
                }

                public void setGimbal_yaw(Double gimbal_yaw) {
                    this.gimbal_yaw = gimbal_yaw;
                }

                public Double getMeasure_target_altitude() {
                    return measure_target_altitude;
                }

                public void setMeasure_target_altitude(Double measure_target_altitude) {
                    this.measure_target_altitude = measure_target_altitude;
                }

                public Double getMeasure_target_distance() {
                    return measure_target_distance;
                }

                public void setMeasure_target_distance(Double measure_target_distance) {
                    this.measure_target_distance = measure_target_distance;
                }

                public Double getMeasure_target_latitude() {
                    return measure_target_latitude;
                }

                public void setMeasure_target_latitude(Double measure_target_latitude) {
                    this.measure_target_latitude = measure_target_latitude;
                }

                public Double getMeasure_target_longitude() {
                    return measure_target_longitude;
                }

                public void setMeasure_target_longitude(Double measure_target_longitude) {
                    this.measure_target_longitude = measure_target_longitude;
                }

                public Integer getMeasure_target_error_state() {
                    return measure_target_error_state;
                }

                public void setMeasure_target_error_state(Integer measure_target_error_state) {
                    this.measure_target_error_state = measure_target_error_state;
                }

                public Object getVersion() {
                    return version;
                }

                public void setVersion(Object version) {
                    this.version = version;
                }
            }
        }
    }
}
