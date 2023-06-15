package com.compass.uavmanager.entity;

public class UavSocketInfo {

    /**
     * content
     */
    private ContentDTO content;
    /**
     * equipmentId
     */
    private String equipmentId;
    /**
     * type
     */
    private String type;

    public ContentDTO getContent() {
        return content;
    }

    public void setContent(ContentDTO content) {
        this.content = content;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static class ContentDTO {
        /**
         * gPSsignalLevel
         */
        private String gPSsignalLevel;
        /**
         * altitude
         */
        private Double altitude;
        /**
         * batteryThresholdBehaviorValue
         */
        private Integer batteryThresholdBehaviorValue;
        /**
         * isLowerThanBatteryWarningThreshold
         */
        private Boolean isLowerThanBatteryWarningThreshold;
        /**
         * flightModeStringBytes
         */
        private FlightModeStringBytesDTO flightModeStringBytes;
        /**
         * latitude
         */
        private Double latitude;
        /**
         * roll
         */
        private Double roll;
        /**
         * windDirectionValue
         */
        private Integer windDirectionValue;
        /**
         * velocityX
         */
        private Double velocityX;
        /**
         * homeLocationLongitude
         */
        private Double homeLocationLongitude;
        /**
         * ultrasonicHeightInMeters
         */
        private Double ultrasonicHeightInMeters;
        /**
         * velocityZ
         */
        private Double velocityZ;
        /**
         * gPSsignalLevelValue
         */
        private Integer gPSsignalLevelValue;
        /**
         * velocityY
         */
        private Double velocityY;
        /**
         * parserForType
         */
        private ParserForTypeDTO parserForType;
        /**
         * compassHeading
         */
        private Double compassHeading;
        /**
         * satelliteCount
         */
        private Integer satelliteCount;
        /**
         * defaultInstanceForType
         */
        private DefaultInstanceForTypeDTO defaultInstanceForType;
        /**
         * flightModeString
         */
        private String flightModeString;
        /**
         * initialized
         */
        private Boolean initialized;
        /**
         * flightCount
         */
        private Integer flightCount;
        /**
         * isIMUPreheating
         */
        private Boolean isIMUPreheating;
        /**
         * orientationMode
         */
        private String orientationMode;
        /**
         * pitch
         */
        private Double pitch;
        /**
         * windDirection
         */
        private String windDirection;
        /**
         * windSpeed
         */
        private Integer windSpeed;
        /**
         * takeoffLocationAltitude
         */
        private Double takeoffLocationAltitude;
        /**
         * longitude
         */
        private Double longitude;
        /**
         * serializedSize
         */
        private Integer serializedSize;
        /**
         * isVisionPositioningSensorBeingUsed
         */
        private Boolean isVisionPositioningSensorBeingUsed;
        /**
         * goHomeHeight
         */
        private Integer goHomeHeight;
        /**
         * batteryThresholdBehavior
         */
        private String batteryThresholdBehavior;
        /**
         * homeLocationLatitude
         */
        private Double homeLocationLatitude;
        /**
         * yaw
         */
        private Double yaw;
        /**
         * systemStatusBytes
         */
        private SystemStatusBytesDTO systemStatusBytes;
        /**
         * flightTimeInSeconds
         */
        private Integer flightTimeInSeconds;
        /**
         * goHomeExecutionState
         */
        private String goHomeExecutionState;
        /**
         * flightWindWarningValue
         */
        private Integer flightWindWarningValue;
        /**
         * goHomeLength
         */
        private Double goHomeLength;
        /**
         * systemStatus
         */
        private String systemStatus;
        /**
         * orientationModeValue
         */
        private Integer orientationModeValue;
        /**
         * isUltrasonicBeingUsed
         */
        private Boolean isUltrasonicBeingUsed;
        /**
         * flightWindWarning
         */
        private String flightWindWarning;
        /**
         * goHomeExecutionStateValue
         */
        private Integer goHomeExecutionStateValue;
        /**
         * isLowerThanSeriousBatteryWarningThreshold
         */
        private Boolean isLowerThanSeriousBatteryWarningThreshold;
        /**
         * areMotorsOn
         */
        private Boolean areMotorsOn;
        /**
         * isFlying
         */
        private Boolean isFlying;

        public String getGPSsignalLevel() {
            return gPSsignalLevel;
        }

        public void setGPSsignalLevel(String gPSsignalLevel) {
            this.gPSsignalLevel = gPSsignalLevel;
        }

        public Double getAltitude() {
            return altitude;
        }

        public void setAltitude(Double altitude) {
            this.altitude = altitude;
        }

        public Integer getBatteryThresholdBehaviorValue() {
            return batteryThresholdBehaviorValue;
        }

        public void setBatteryThresholdBehaviorValue(Integer batteryThresholdBehaviorValue) {
            this.batteryThresholdBehaviorValue = batteryThresholdBehaviorValue;
        }

        public Boolean getIsLowerThanBatteryWarningThreshold() {
            return isLowerThanBatteryWarningThreshold;
        }

        public void setIsLowerThanBatteryWarningThreshold(Boolean isLowerThanBatteryWarningThreshold) {
            this.isLowerThanBatteryWarningThreshold = isLowerThanBatteryWarningThreshold;
        }

        public FlightModeStringBytesDTO getFlightModeStringBytes() {
            return flightModeStringBytes;
        }

        public void setFlightModeStringBytes(FlightModeStringBytesDTO flightModeStringBytes) {
            this.flightModeStringBytes = flightModeStringBytes;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getRoll() {
            return roll;
        }

        public void setRoll(Double roll) {
            this.roll = roll;
        }

        public Integer getWindDirectionValue() {
            return windDirectionValue;
        }

        public void setWindDirectionValue(Integer windDirectionValue) {
            this.windDirectionValue = windDirectionValue;
        }

        public Double getVelocityX() {
            return velocityX;
        }

        public void setVelocityX(Double velocityX) {
            this.velocityX = velocityX;
        }

        public Double getHomeLocationLongitude() {
            return homeLocationLongitude;
        }

        public void setHomeLocationLongitude(Double homeLocationLongitude) {
            this.homeLocationLongitude = homeLocationLongitude;
        }

        public Double getUltrasonicHeightInMeters() {
            return ultrasonicHeightInMeters;
        }

        public void setUltrasonicHeightInMeters(Double ultrasonicHeightInMeters) {
            this.ultrasonicHeightInMeters = ultrasonicHeightInMeters;
        }

        public Double getVelocityZ() {
            return velocityZ;
        }

        public void setVelocityZ(Double velocityZ) {
            this.velocityZ = velocityZ;
        }

        public Integer getGPSsignalLevelValue() {
            return gPSsignalLevelValue;
        }

        public void setGPSsignalLevelValue(Integer gPSsignalLevelValue) {
            this.gPSsignalLevelValue = gPSsignalLevelValue;
        }

        public Double getVelocityY() {
            return velocityY;
        }

        public void setVelocityY(Double velocityY) {
            this.velocityY = velocityY;
        }

        public ParserForTypeDTO getParserForType() {
            return parserForType;
        }

        public void setParserForType(ParserForTypeDTO parserForType) {
            this.parserForType = parserForType;
        }

        public Double getCompassHeading() {
            return compassHeading;
        }

        public void setCompassHeading(Double compassHeading) {
            this.compassHeading = compassHeading;
        }

        public Integer getSatelliteCount() {
            return satelliteCount;
        }

        public void setSatelliteCount(Integer satelliteCount) {
            this.satelliteCount = satelliteCount;
        }

        public DefaultInstanceForTypeDTO getDefaultInstanceForType() {
            return defaultInstanceForType;
        }

        public void setDefaultInstanceForType(DefaultInstanceForTypeDTO defaultInstanceForType) {
            this.defaultInstanceForType = defaultInstanceForType;
        }

        public String getFlightModeString() {
            return flightModeString;
        }

        public void setFlightModeString(String flightModeString) {
            this.flightModeString = flightModeString;
        }

        public Boolean getInitialized() {
            return initialized;
        }

        public void setInitialized(Boolean initialized) {
            this.initialized = initialized;
        }

        public Integer getFlightCount() {
            return flightCount;
        }

        public void setFlightCount(Integer flightCount) {
            this.flightCount = flightCount;
        }

        public Boolean getIsIMUPreheating() {
            return isIMUPreheating;
        }

        public void setIsIMUPreheating(Boolean isIMUPreheating) {
            this.isIMUPreheating = isIMUPreheating;
        }

        public String getOrientationMode() {
            return orientationMode;
        }

        public void setOrientationMode(String orientationMode) {
            this.orientationMode = orientationMode;
        }

        public Double getPitch() {
            return pitch;
        }

        public void setPitch(Double pitch) {
            this.pitch = pitch;
        }

        public String getWindDirection() {
            return windDirection;
        }

        public void setWindDirection(String windDirection) {
            this.windDirection = windDirection;
        }

        public Integer getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(Integer windSpeed) {
            this.windSpeed = windSpeed;
        }

        public Double getTakeoffLocationAltitude() {
            return takeoffLocationAltitude;
        }

        public void setTakeoffLocationAltitude(Double takeoffLocationAltitude) {
            this.takeoffLocationAltitude = takeoffLocationAltitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Integer getSerializedSize() {
            return serializedSize;
        }

        public void setSerializedSize(Integer serializedSize) {
            this.serializedSize = serializedSize;
        }

        public Boolean getIsVisionPositioningSensorBeingUsed() {
            return isVisionPositioningSensorBeingUsed;
        }

        public void setIsVisionPositioningSensorBeingUsed(Boolean isVisionPositioningSensorBeingUsed) {
            this.isVisionPositioningSensorBeingUsed = isVisionPositioningSensorBeingUsed;
        }

        public Integer getGoHomeHeight() {
            return goHomeHeight;
        }

        public void setGoHomeHeight(Integer goHomeHeight) {
            this.goHomeHeight = goHomeHeight;
        }

        public String getBatteryThresholdBehavior() {
            return batteryThresholdBehavior;
        }

        public void setBatteryThresholdBehavior(String batteryThresholdBehavior) {
            this.batteryThresholdBehavior = batteryThresholdBehavior;
        }

        public Double getHomeLocationLatitude() {
            return homeLocationLatitude;
        }

        public void setHomeLocationLatitude(Double homeLocationLatitude) {
            this.homeLocationLatitude = homeLocationLatitude;
        }

        public Double getYaw() {
            return yaw;
        }

        public void setYaw(Double yaw) {
            this.yaw = yaw;
        }

        public SystemStatusBytesDTO getSystemStatusBytes() {
            return systemStatusBytes;
        }

        public void setSystemStatusBytes(SystemStatusBytesDTO systemStatusBytes) {
            this.systemStatusBytes = systemStatusBytes;
        }

        public Integer getFlightTimeInSeconds() {
            return flightTimeInSeconds;
        }

        public void setFlightTimeInSeconds(Integer flightTimeInSeconds) {
            this.flightTimeInSeconds = flightTimeInSeconds;
        }

        public String getGoHomeExecutionState() {
            return goHomeExecutionState;
        }

        public void setGoHomeExecutionState(String goHomeExecutionState) {
            this.goHomeExecutionState = goHomeExecutionState;
        }

        public Integer getFlightWindWarningValue() {
            return flightWindWarningValue;
        }

        public void setFlightWindWarningValue(Integer flightWindWarningValue) {
            this.flightWindWarningValue = flightWindWarningValue;
        }

        public Double getGoHomeLength() {
            return goHomeLength;
        }

        public void setGoHomeLength(Double goHomeLength) {
            this.goHomeLength = goHomeLength;
        }

        public String getSystemStatus() {
            return systemStatus;
        }

        public void setSystemStatus(String systemStatus) {
            this.systemStatus = systemStatus;
        }

        public Integer getOrientationModeValue() {
            return orientationModeValue;
        }

        public void setOrientationModeValue(Integer orientationModeValue) {
            this.orientationModeValue = orientationModeValue;
        }

        public Boolean getIsUltrasonicBeingUsed() {
            return isUltrasonicBeingUsed;
        }

        public void setIsUltrasonicBeingUsed(Boolean isUltrasonicBeingUsed) {
            this.isUltrasonicBeingUsed = isUltrasonicBeingUsed;
        }

        public String getFlightWindWarning() {
            return flightWindWarning;
        }

        public void setFlightWindWarning(String flightWindWarning) {
            this.flightWindWarning = flightWindWarning;
        }

        public Integer getGoHomeExecutionStateValue() {
            return goHomeExecutionStateValue;
        }

        public void setGoHomeExecutionStateValue(Integer goHomeExecutionStateValue) {
            this.goHomeExecutionStateValue = goHomeExecutionStateValue;
        }

        public Boolean getIsLowerThanSeriousBatteryWarningThreshold() {
            return isLowerThanSeriousBatteryWarningThreshold;
        }

        public void setIsLowerThanSeriousBatteryWarningThreshold(Boolean isLowerThanSeriousBatteryWarningThreshold) {
            this.isLowerThanSeriousBatteryWarningThreshold = isLowerThanSeriousBatteryWarningThreshold;
        }

        public Boolean getAreMotorsOn() {
            return areMotorsOn;
        }

        public void setAreMotorsOn(Boolean areMotorsOn) {
            this.areMotorsOn = areMotorsOn;
        }

        public Boolean getIsFlying() {
            return isFlying;
        }

        public void setIsFlying(Boolean isFlying) {
            this.isFlying = isFlying;
        }

        public static class FlightModeStringBytesDTO {
        }

        public static class ParserForTypeDTO {
        }

        public static class DefaultInstanceForTypeDTO {
            /**
             * gPSsignalLevel
             */
            private String gPSsignalLevel;
            /**
             * altitude
             */
            private Double altitude;
            /**
             * batteryThresholdBehaviorValue
             */
            private Integer batteryThresholdBehaviorValue;
            /**
             * isLowerThanBatteryWarningThreshold
             */
            private Boolean isLowerThanBatteryWarningThreshold;
            /**
             * flightModeStringBytes
             */
            private FlightModeStringBytesDTO flightModeStringBytes;
            /**
             * latitude
             */
            private Double latitude;
            /**
             * roll
             */
            private Double roll;
            /**
             * windDirectionValue
             */
            private Integer windDirectionValue;
            /**
             * velocityX
             */
            private Double velocityX;
            /**
             * homeLocationLongitude
             */
            private Double homeLocationLongitude;
            /**
             * ultrasonicHeightInMeters
             */
            private Double ultrasonicHeightInMeters;
            /**
             * velocityZ
             */
            private Double velocityZ;
            /**
             * gPSsignalLevelValue
             */
            private Integer gPSsignalLevelValue;
            /**
             * velocityY
             */
            private Double velocityY;
            /**
             * parserForType
             */
            private ParserForTypeDTO parserForType;
            /**
             * compassHeading
             */
            private Double compassHeading;
            /**
             * satelliteCount
             */
            private Integer satelliteCount;
            /**
             * defaultInstanceForType
             */
            private DefaultInstanceForTypeDTO defaultInstanceForType;
            /**
             * flightModeString
             */
            private String flightModeString;
            /**
             * initialized
             */
            private Boolean initialized;
            /**
             * flightCount
             */
            private Integer flightCount;
            /**
             * isIMUPreheating
             */
            private Boolean isIMUPreheating;
            /**
             * orientationMode
             */
            private String orientationMode;
            /**
             * pitch
             */
            private Double pitch;
            /**
             * windDirection
             */
            private String windDirection;
            /**
             * windSpeed
             */
            private Integer windSpeed;
            /**
             * takeoffLocationAltitude
             */
            private Double takeoffLocationAltitude;
            /**
             * longitude
             */
            private Double longitude;
            /**
             * serializedSize
             */
            private Integer serializedSize;
            /**
             * isVisionPositioningSensorBeingUsed
             */
            private Boolean isVisionPositioningSensorBeingUsed;
            /**
             * goHomeHeight
             */
            private Integer goHomeHeight;
            /**
             * batteryThresholdBehavior
             */
            private String batteryThresholdBehavior;
            /**
             * homeLocationLatitude
             */
            private Double homeLocationLatitude;
            /**
             * yaw
             */
            private Double yaw;
            /**
             * systemStatusBytes
             */
            private SystemStatusBytesDTO systemStatusBytes;
            /**
             * flightTimeInSeconds
             */
            private Integer flightTimeInSeconds;
            /**
             * goHomeExecutionState
             */
            private String goHomeExecutionState;
            /**
             * flightWindWarningValue
             */
            private Integer flightWindWarningValue;
            /**
             * goHomeLength
             */
            private Double goHomeLength;
            /**
             * systemStatus
             */
            private String systemStatus;
            /**
             * orientationModeValue
             */
            private Integer orientationModeValue;
            /**
             * isUltrasonicBeingUsed
             */
            private Boolean isUltrasonicBeingUsed;
            /**
             * flightWindWarning
             */
            private String flightWindWarning;
            /**
             * goHomeExecutionStateValue
             */
            private Integer goHomeExecutionStateValue;
            /**
             * isLowerThanSeriousBatteryWarningThreshold
             */
            private Boolean isLowerThanSeriousBatteryWarningThreshold;
            /**
             * areMotorsOn
             */
            private Boolean areMotorsOn;
            /**
             * isFlying
             */
            private Boolean isFlying;

            public String getGPSsignalLevel() {
                return gPSsignalLevel;
            }

            public void setGPSsignalLevel(String gPSsignalLevel) {
                this.gPSsignalLevel = gPSsignalLevel;
            }

            public Double getAltitude() {
                return altitude;
            }

            public void setAltitude(Double altitude) {
                this.altitude = altitude;
            }

            public Integer getBatteryThresholdBehaviorValue() {
                return batteryThresholdBehaviorValue;
            }

            public void setBatteryThresholdBehaviorValue(Integer batteryThresholdBehaviorValue) {
                this.batteryThresholdBehaviorValue = batteryThresholdBehaviorValue;
            }

            public Boolean getIsLowerThanBatteryWarningThreshold() {
                return isLowerThanBatteryWarningThreshold;
            }

            public void setIsLowerThanBatteryWarningThreshold(Boolean isLowerThanBatteryWarningThreshold) {
                this.isLowerThanBatteryWarningThreshold = isLowerThanBatteryWarningThreshold;
            }

            public FlightModeStringBytesDTO getFlightModeStringBytes() {
                return flightModeStringBytes;
            }

            public void setFlightModeStringBytes(FlightModeStringBytesDTO flightModeStringBytes) {
                this.flightModeStringBytes = flightModeStringBytes;
            }

            public Double getLatitude() {
                return latitude;
            }

            public void setLatitude(Double latitude) {
                this.latitude = latitude;
            }

            public Double getRoll() {
                return roll;
            }

            public void setRoll(Double roll) {
                this.roll = roll;
            }

            public Integer getWindDirectionValue() {
                return windDirectionValue;
            }

            public void setWindDirectionValue(Integer windDirectionValue) {
                this.windDirectionValue = windDirectionValue;
            }

            public Double getVelocityX() {
                return velocityX;
            }

            public void setVelocityX(Double velocityX) {
                this.velocityX = velocityX;
            }

            public Double getHomeLocationLongitude() {
                return homeLocationLongitude;
            }

            public void setHomeLocationLongitude(Double homeLocationLongitude) {
                this.homeLocationLongitude = homeLocationLongitude;
            }

            public Double getUltrasonicHeightInMeters() {
                return ultrasonicHeightInMeters;
            }

            public void setUltrasonicHeightInMeters(Double ultrasonicHeightInMeters) {
                this.ultrasonicHeightInMeters = ultrasonicHeightInMeters;
            }

            public Double getVelocityZ() {
                return velocityZ;
            }

            public void setVelocityZ(Double velocityZ) {
                this.velocityZ = velocityZ;
            }

            public Integer getGPSsignalLevelValue() {
                return gPSsignalLevelValue;
            }

            public void setGPSsignalLevelValue(Integer gPSsignalLevelValue) {
                this.gPSsignalLevelValue = gPSsignalLevelValue;
            }

            public Double getVelocityY() {
                return velocityY;
            }

            public void setVelocityY(Double velocityY) {
                this.velocityY = velocityY;
            }

            public ParserForTypeDTO getParserForType() {
                return parserForType;
            }

            public void setParserForType(ParserForTypeDTO parserForType) {
                this.parserForType = parserForType;
            }

            public Double getCompassHeading() {
                return compassHeading;
            }

            public void setCompassHeading(Double compassHeading) {
                this.compassHeading = compassHeading;
            }

            public Integer getSatelliteCount() {
                return satelliteCount;
            }

            public void setSatelliteCount(Integer satelliteCount) {
                this.satelliteCount = satelliteCount;
            }

            public DefaultInstanceForTypeDTO getDefaultInstanceForType() {
                return defaultInstanceForType;
            }

            public void setDefaultInstanceForType(DefaultInstanceForTypeDTO defaultInstanceForType) {
                this.defaultInstanceForType = defaultInstanceForType;
            }

            public String getFlightModeString() {
                return flightModeString;
            }

            public void setFlightModeString(String flightModeString) {
                this.flightModeString = flightModeString;
            }

            public Boolean getInitialized() {
                return initialized;
            }

            public void setInitialized(Boolean initialized) {
                this.initialized = initialized;
            }

            public Integer getFlightCount() {
                return flightCount;
            }

            public void setFlightCount(Integer flightCount) {
                this.flightCount = flightCount;
            }

            public Boolean getIsIMUPreheating() {
                return isIMUPreheating;
            }

            public void setIsIMUPreheating(Boolean isIMUPreheating) {
                this.isIMUPreheating = isIMUPreheating;
            }

            public String getOrientationMode() {
                return orientationMode;
            }

            public void setOrientationMode(String orientationMode) {
                this.orientationMode = orientationMode;
            }

            public Double getPitch() {
                return pitch;
            }

            public void setPitch(Double pitch) {
                this.pitch = pitch;
            }

            public String getWindDirection() {
                return windDirection;
            }

            public void setWindDirection(String windDirection) {
                this.windDirection = windDirection;
            }

            public Integer getWindSpeed() {
                return windSpeed;
            }

            public void setWindSpeed(Integer windSpeed) {
                this.windSpeed = windSpeed;
            }

            public Double getTakeoffLocationAltitude() {
                return takeoffLocationAltitude;
            }

            public void setTakeoffLocationAltitude(Double takeoffLocationAltitude) {
                this.takeoffLocationAltitude = takeoffLocationAltitude;
            }

            public Double getLongitude() {
                return longitude;
            }

            public void setLongitude(Double longitude) {
                this.longitude = longitude;
            }

            public Integer getSerializedSize() {
                return serializedSize;
            }

            public void setSerializedSize(Integer serializedSize) {
                this.serializedSize = serializedSize;
            }

            public Boolean getIsVisionPositioningSensorBeingUsed() {
                return isVisionPositioningSensorBeingUsed;
            }

            public void setIsVisionPositioningSensorBeingUsed(Boolean isVisionPositioningSensorBeingUsed) {
                this.isVisionPositioningSensorBeingUsed = isVisionPositioningSensorBeingUsed;
            }

            public Integer getGoHomeHeight() {
                return goHomeHeight;
            }

            public void setGoHomeHeight(Integer goHomeHeight) {
                this.goHomeHeight = goHomeHeight;
            }

            public String getBatteryThresholdBehavior() {
                return batteryThresholdBehavior;
            }

            public void setBatteryThresholdBehavior(String batteryThresholdBehavior) {
                this.batteryThresholdBehavior = batteryThresholdBehavior;
            }

            public Double getHomeLocationLatitude() {
                return homeLocationLatitude;
            }

            public void setHomeLocationLatitude(Double homeLocationLatitude) {
                this.homeLocationLatitude = homeLocationLatitude;
            }

            public Double getYaw() {
                return yaw;
            }

            public void setYaw(Double yaw) {
                this.yaw = yaw;
            }

            public SystemStatusBytesDTO getSystemStatusBytes() {
                return systemStatusBytes;
            }

            public void setSystemStatusBytes(SystemStatusBytesDTO systemStatusBytes) {
                this.systemStatusBytes = systemStatusBytes;
            }

            public Integer getFlightTimeInSeconds() {
                return flightTimeInSeconds;
            }

            public void setFlightTimeInSeconds(Integer flightTimeInSeconds) {
                this.flightTimeInSeconds = flightTimeInSeconds;
            }

            public String getGoHomeExecutionState() {
                return goHomeExecutionState;
            }

            public void setGoHomeExecutionState(String goHomeExecutionState) {
                this.goHomeExecutionState = goHomeExecutionState;
            }

            public Integer getFlightWindWarningValue() {
                return flightWindWarningValue;
            }

            public void setFlightWindWarningValue(Integer flightWindWarningValue) {
                this.flightWindWarningValue = flightWindWarningValue;
            }

            public Double getGoHomeLength() {
                return goHomeLength;
            }

            public void setGoHomeLength(Double goHomeLength) {
                this.goHomeLength = goHomeLength;
            }

            public String getSystemStatus() {
                return systemStatus;
            }

            public void setSystemStatus(String systemStatus) {
                this.systemStatus = systemStatus;
            }

            public Integer getOrientationModeValue() {
                return orientationModeValue;
            }

            public void setOrientationModeValue(Integer orientationModeValue) {
                this.orientationModeValue = orientationModeValue;
            }

            public Boolean getIsUltrasonicBeingUsed() {
                return isUltrasonicBeingUsed;
            }

            public void setIsUltrasonicBeingUsed(Boolean isUltrasonicBeingUsed) {
                this.isUltrasonicBeingUsed = isUltrasonicBeingUsed;
            }

            public String getFlightWindWarning() {
                return flightWindWarning;
            }

            public void setFlightWindWarning(String flightWindWarning) {
                this.flightWindWarning = flightWindWarning;
            }

            public Integer getGoHomeExecutionStateValue() {
                return goHomeExecutionStateValue;
            }

            public void setGoHomeExecutionStateValue(Integer goHomeExecutionStateValue) {
                this.goHomeExecutionStateValue = goHomeExecutionStateValue;
            }

            public Boolean getIsLowerThanSeriousBatteryWarningThreshold() {
                return isLowerThanSeriousBatteryWarningThreshold;
            }

            public void setIsLowerThanSeriousBatteryWarningThreshold(Boolean isLowerThanSeriousBatteryWarningThreshold) {
                this.isLowerThanSeriousBatteryWarningThreshold = isLowerThanSeriousBatteryWarningThreshold;
            }

            public Boolean getAreMotorsOn() {
                return areMotorsOn;
            }

            public void setAreMotorsOn(Boolean areMotorsOn) {
                this.areMotorsOn = areMotorsOn;
            }

            public Boolean getIsFlying() {
                return isFlying;
            }

            public void setIsFlying(Boolean isFlying) {
                this.isFlying = isFlying;
            }

            public static class FlightModeStringBytesDTO {
                /**
                 * validUtf8
                 */
                private Boolean validUtf8;
                /**
                 * empty
                 */
                private Boolean empty;

                public Boolean getValidUtf8() {
                    return validUtf8;
                }

                public void setValidUtf8(Boolean validUtf8) {
                    this.validUtf8 = validUtf8;
                }

                public Boolean getEmpty() {
                    return empty;
                }

                public void setEmpty(Boolean empty) {
                    this.empty = empty;
                }
            }

            public static class ParserForTypeDTO {
                /**
                 * $ref
                 */
                private String $ref;

                public String get$ref() {
                    return $ref;
                }

                public void set$ref(String $ref) {
                    this.$ref = $ref;
                }
            }


            public static class SystemStatusBytesDTO {
                /**
                 * validUtf8
                 */
                private Boolean validUtf8;
                /**
                 * empty
                 */
                private Boolean empty;

                public Boolean getValidUtf8() {
                    return validUtf8;
                }

                public void setValidUtf8(Boolean validUtf8) {
                    this.validUtf8 = validUtf8;
                }

                public Boolean getEmpty() {
                    return empty;
                }

                public void setEmpty(Boolean empty) {
                    this.empty = empty;
                }
            }
        }

        public static class SystemStatusBytesDTO {
            /**
             * validUtf8
             */
            private Boolean validUtf8;
            /**
             * empty
             */
            private Boolean empty;

            public Boolean getValidUtf8() {
                return validUtf8;
            }

            public void setValidUtf8(Boolean validUtf8) {
                this.validUtf8 = validUtf8;
            }

            public Boolean getEmpty() {
                return empty;
            }

            public void setEmpty(Boolean empty) {
                this.empty = empty;
            }
        }
    }
}
