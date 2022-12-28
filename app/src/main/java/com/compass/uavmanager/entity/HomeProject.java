package com.compass.uavmanager.entity;

import java.util.List;

public class HomeProject {

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
         * createTime
         */
        private String createTime;
        /**
         * createBy
         */
        private String createBy;
        /**
         * updateTime
         */
        private String updateTime;
        /**
         * updateBy
         */
        private String updateBy;
        /**
         * state
         */
        private Integer state;
        /**
         * id
         */
        private String id;
        /**
         * projectName
         */
        private String projectName;
        /**
         * projectNo
         */
        private String projectNo;
        /**
         * departmentId
         */
        private Integer departmentId;
        /**
         * workspaceId
         */
        private String workspaceId;
        /**
         * groupId
         */
        private String groupId;
        /**
         * projectDescription
         */
        private String projectDescription;
        /**
         * applicationCodeState
         */
        private Integer applicationCodeState;
        /**
         * applicationCode
         */
        private String applicationCode;
        /**
         * applicationDeadline
         */
        private String applicationDeadline;
        /**
         * longitude
         */
        private String longitude;
        /**
         * latitude
         */
        private String latitude;
        /**
         * projectState
         */
        private Integer projectState;
        /**
         * address
         */
        private String address;
        /**
         * taskType
         */
        private String taskType;
        /**
         * uavDos
         */
        private List<UavDosDTO> uavDos;
        /**
         * userDos
         */
        private List<UserDosDTO> userDos;
        /**
         * uservos
         */
        private List<UservosDTO> uservos;
        /**
         * uavDataVos
         */
        private List<UavDataVosDTO> uavDataVos;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(String updateBy) {
            this.updateBy = updateBy;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProjectName() {
            return projectName;
        }

        public void setProjectName(String projectName) {
            this.projectName = projectName;
        }

        public String getProjectNo() {
            return projectNo;
        }

        public void setProjectNo(String projectNo) {
            this.projectNo = projectNo;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public String getWorkspaceId() {
            return workspaceId;
        }

        public void setWorkspaceId(String workspaceId) {
            this.workspaceId = workspaceId;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public String getProjectDescription() {
            return projectDescription;
        }

        public void setProjectDescription(String projectDescription) {
            this.projectDescription = projectDescription;
        }

        public Integer getApplicationCodeState() {
            return applicationCodeState;
        }

        public void setApplicationCodeState(Integer applicationCodeState) {
            this.applicationCodeState = applicationCodeState;
        }

        public String getApplicationCode() {
            return applicationCode;
        }

        public void setApplicationCode(String applicationCode) {
            this.applicationCode = applicationCode;
        }

        public String getApplicationDeadline() {
            return applicationDeadline;
        }

        public void setApplicationDeadline(String applicationDeadline) {
            this.applicationDeadline = applicationDeadline;
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

        public Integer getProjectState() {
            return projectState;
        }

        public void setProjectState(Integer projectState) {
            this.projectState = projectState;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTaskType() {
            return taskType;
        }

        public void setTaskType(String taskType) {
            this.taskType = taskType;
        }

        public List<UavDosDTO> getUavDos() {
            return uavDos;
        }

        public void setUavDos(List<UavDosDTO> uavDos) {
            this.uavDos = uavDos;
        }

        public List<UserDosDTO> getUserDos() {
            return userDos;
        }

        public void setUserDos(List<UserDosDTO> userDos) {
            this.userDos = userDos;
        }

        public List<UservosDTO> getUservos() {
            return uservos;
        }

        public void setUservos(List<UservosDTO> uservos) {
            this.uservos = uservos;
        }

        public List<UavDataVosDTO> getUavDataVos() {
            return uavDataVos;
        }

        public void setUavDataVos(List<UavDataVosDTO> uavDataVos) {
            this.uavDataVos = uavDataVos;
        }

        public static class UavDosDTO {
            /**
             * createTime
             */
            private String createTime;
            /**
             * createBy
             */
            private String createBy;
            /**
             * updateTime
             */
            private String updateTime;
            /**
             * updateBy
             */
            private String updateBy;
            /**
             * state
             */
            private Integer state;
            /**
             * id
             */
            private Integer id;
            /**
             * name
             */
            private String name;
            /**
             * bindId
             */
            private Integer bindId;
            /**
             * uavSn
             */
            private String uavSn;
            /**
             * uavType
             */
            private String uavType;
            /**
             * uavBrand
             */
            private String uavBrand;
            /**
             * charger
             */
            private String charger;
            /**
             * uavName
             */
            private String uavName;
            /**
             * pushSn
             */
            private String pushSn;
            /**
             * picUrl
             */
            private String picUrl;
            /**
             * insuranceId
             */
            private Integer insuranceId;
            /**
             * flightTimeDuringMaintainPeriod
             */
            private Double flightTimeDuringMaintainPeriod;
            /**
             * workspaceId
             */
            private String workspaceId;
            /**
             * deviceType
             */
            private Integer deviceType;
            /**
             * version
             */
            private Integer version;
            /**
             * deviceIndex
             */
            private String deviceIndex;
            /**
             * childSn
             */
            private String childSn;
            /**
             * urlNormal
             */
            private String urlNormal;
            /**
             * urlSelect
             */
            private String urlSelect;
            /**
             * subType
             */
            private Integer subType;
            /**
             * domain
             */
            private Integer domain;
            /**
             * deviceDesc
             */
            private String deviceDesc;
            /**
             * healthState
             */
            private Integer healthState;
            /**
             * livegbsChannel
             */
            private String livegbsChannel;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public Integer getState() {
                return state;
            }

            public void setState(Integer state) {
                this.state = state;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getBindId() {
                return bindId;
            }

            public void setBindId(Integer bindId) {
                this.bindId = bindId;
            }

            public String getUavSn() {
                return uavSn;
            }

            public void setUavSn(String uavSn) {
                this.uavSn = uavSn;
            }

            public String getUavType() {
                return uavType;
            }

            public void setUavType(String uavType) {
                this.uavType = uavType;
            }

            public String getUavBrand() {
                return uavBrand;
            }

            public void setUavBrand(String uavBrand) {
                this.uavBrand = uavBrand;
            }

            public String getCharger() {
                return charger;
            }

            public void setCharger(String charger) {
                this.charger = charger;
            }

            public String getUavName() {
                return uavName;
            }

            public void setUavName(String uavName) {
                this.uavName = uavName;
            }

            public String getPushSn() {
                return pushSn;
            }

            public void setPushSn(String pushSn) {
                this.pushSn = pushSn;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public Integer getInsuranceId() {
                return insuranceId;
            }

            public void setInsuranceId(Integer insuranceId) {
                this.insuranceId = insuranceId;
            }

            public Double getFlightTimeDuringMaintainPeriod() {
                return flightTimeDuringMaintainPeriod;
            }

            public void setFlightTimeDuringMaintainPeriod(Double flightTimeDuringMaintainPeriod) {
                this.flightTimeDuringMaintainPeriod = flightTimeDuringMaintainPeriod;
            }

            public String getWorkspaceId() {
                return workspaceId;
            }

            public void setWorkspaceId(String workspaceId) {
                this.workspaceId = workspaceId;
            }

            public Integer getDeviceType() {
                return deviceType;
            }

            public void setDeviceType(Integer deviceType) {
                this.deviceType = deviceType;
            }

            public Integer getVersion() {
                return version;
            }

            public void setVersion(Integer version) {
                this.version = version;
            }

            public String getDeviceIndex() {
                return deviceIndex;
            }

            public void setDeviceIndex(String deviceIndex) {
                this.deviceIndex = deviceIndex;
            }

            public String getChildSn() {
                return childSn;
            }

            public void setChildSn(String childSn) {
                this.childSn = childSn;
            }

            public String getUrlNormal() {
                return urlNormal;
            }

            public void setUrlNormal(String urlNormal) {
                this.urlNormal = urlNormal;
            }

            public String getUrlSelect() {
                return urlSelect;
            }

            public void setUrlSelect(String urlSelect) {
                this.urlSelect = urlSelect;
            }

            public Integer getSubType() {
                return subType;
            }

            public void setSubType(Integer subType) {
                this.subType = subType;
            }

            public Integer getDomain() {
                return domain;
            }

            public void setDomain(Integer domain) {
                this.domain = domain;
            }

            public String getDeviceDesc() {
                return deviceDesc;
            }

            public void setDeviceDesc(String deviceDesc) {
                this.deviceDesc = deviceDesc;
            }

            public Integer getHealthState() {
                return healthState;
            }

            public void setHealthState(Integer healthState) {
                this.healthState = healthState;
            }

            public String getLivegbsChannel() {
                return livegbsChannel;
            }

            public void setLivegbsChannel(String livegbsChannel) {
                this.livegbsChannel = livegbsChannel;
            }
        }

        public static class UserDosDTO {
            /**
             * id
             */
            private Integer id;
            /**
             * username
             */
            private String username;
            /**
             * password
             */
            private String password;
            /**
             * nameCn
             */
            private String nameCn;
            /**
             * age
             */
            private Integer age;
            /**
             * sex
             */
            private Integer sex;
            /**
             * phone
             */
            private String phone;
            /**
             * departmentId
             */
            private Integer departmentId;
            /**
             * roleId
             */
            private Integer roleId;
            /**
             * status
             */
            private Integer status;
            /**
             * onlineStatus
             */
            private String onlineStatus;
            /**
             * state
             */
            private Integer state;
            /**
             * registerTime
             */
            private String registerTime;
            /**
             * registerIp
             */
            private String registerIp;
            /**
             * loginTime
             */
            private String loginTime;
            /**
             * loginIp
             */
            private String loginIp;
            /**
             * createTime
             */
            private String createTime;
            /**
             * createBy
             */
            private String createBy;
            /**
             * updateTime
             */
            private String updateTime;
            /**
             * updateBy
             */
            private String updateBy;
            /**
             * totalFlightDistance
             */
            private Double totalFlightDistance;
            /**
             * maxFlightDistance
             */
            private Double maxFlightDistance;
            /**
             * maxSpeed
             */
            private Double maxSpeed;
            /**
             * userImagePath
             */
            private String userImagePath;
            /**
             * workspaceId
             */
            private String workspaceId;
            /**
             * userType
             */
            private Integer userType;
            /**
             * mqttUsername
             */
            private String mqttUsername;
            /**
             * mqttPassword
             */
            private String mqttPassword;
            /**
             * userId
             */
            private String userId;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getNameCn() {
                return nameCn;
            }

            public void setNameCn(String nameCn) {
                this.nameCn = nameCn;
            }

            public Integer getAge() {
                return age;
            }

            public void setAge(Integer age) {
                this.age = age;
            }

            public Integer getSex() {
                return sex;
            }

            public void setSex(Integer sex) {
                this.sex = sex;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Integer getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(Integer departmentId) {
                this.departmentId = departmentId;
            }

            public Integer getRoleId() {
                return roleId;
            }

            public void setRoleId(Integer roleId) {
                this.roleId = roleId;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getOnlineStatus() {
                return onlineStatus;
            }

            public void setOnlineStatus(String onlineStatus) {
                this.onlineStatus = onlineStatus;
            }

            public Integer getState() {
                return state;
            }

            public void setState(Integer state) {
                this.state = state;
            }

            public String getRegisterTime() {
                return registerTime;
            }

            public void setRegisterTime(String registerTime) {
                this.registerTime = registerTime;
            }

            public String getRegisterIp() {
                return registerIp;
            }

            public void setRegisterIp(String registerIp) {
                this.registerIp = registerIp;
            }

            public String getLoginTime() {
                return loginTime;
            }

            public void setLoginTime(String loginTime) {
                this.loginTime = loginTime;
            }

            public String getLoginIp() {
                return loginIp;
            }

            public void setLoginIp(String loginIp) {
                this.loginIp = loginIp;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public Double getTotalFlightDistance() {
                return totalFlightDistance;
            }

            public void setTotalFlightDistance(Double totalFlightDistance) {
                this.totalFlightDistance = totalFlightDistance;
            }

            public Double getMaxFlightDistance() {
                return maxFlightDistance;
            }

            public void setMaxFlightDistance(Double maxFlightDistance) {
                this.maxFlightDistance = maxFlightDistance;
            }

            public Double getMaxSpeed() {
                return maxSpeed;
            }

            public void setMaxSpeed(Double maxSpeed) {
                this.maxSpeed = maxSpeed;
            }

            public String getUserImagePath() {
                return userImagePath;
            }

            public void setUserImagePath(String userImagePath) {
                this.userImagePath = userImagePath;
            }

            public String getWorkspaceId() {
                return workspaceId;
            }

            public void setWorkspaceId(String workspaceId) {
                this.workspaceId = workspaceId;
            }

            public Integer getUserType() {
                return userType;
            }

            public void setUserType(Integer userType) {
                this.userType = userType;
            }

            public String getMqttUsername() {
                return mqttUsername;
            }

            public void setMqttUsername(String mqttUsername) {
                this.mqttUsername = mqttUsername;
            }

            public String getMqttPassword() {
                return mqttPassword;
            }

            public void setMqttPassword(String mqttPassword) {
                this.mqttPassword = mqttPassword;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }
        }

        public static class UservosDTO {
            /**
             * id
             */
            private Integer id;
            /**
             * nameCn
             */
            private String nameCn;
            /**
             * username
             */
            private String username;
            /**
             * phone
             */
            private String phone;
            /**
             * departmentId
             */
            private Integer departmentId;
            /**
             * departmentName
             */
            private String departmentName;
            /**
             * roleName
             */
            private String roleName;
            /**
             * roleId
             */
            private Integer roleId;
            /**
             * password
             */
            private String password;
            /**
             * createBy
             */
            private String createBy;
            /**
             * updateBy
             */
            private String updateBy;
            /**
             * onlineStatus
             */
            private String onlineStatus;
            /**
             * workspaceId
             */
            private String workspaceId;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getNameCn() {
                return nameCn;
            }

            public void setNameCn(String nameCn) {
                this.nameCn = nameCn;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public Integer getDepartmentId() {
                return departmentId;
            }

            public void setDepartmentId(Integer departmentId) {
                this.departmentId = departmentId;
            }

            public String getDepartmentName() {
                return departmentName;
            }

            public void setDepartmentName(String departmentName) {
                this.departmentName = departmentName;
            }

            public String getRoleName() {
                return roleName;
            }

            public void setRoleName(String roleName) {
                this.roleName = roleName;
            }

            public Integer getRoleId() {
                return roleId;
            }

            public void setRoleId(Integer roleId) {
                this.roleId = roleId;
            }

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getCreateBy() {
                return createBy;
            }

            public void setCreateBy(String createBy) {
                this.createBy = createBy;
            }

            public String getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(String updateBy) {
                this.updateBy = updateBy;
            }

            public String getOnlineStatus() {
                return onlineStatus;
            }

            public void setOnlineStatus(String onlineStatus) {
                this.onlineStatus = onlineStatus;
            }

            public String getWorkspaceId() {
                return workspaceId;
            }

            public void setWorkspaceId(String workspaceId) {
                this.workspaceId = workspaceId;
            }
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
            private Integer uavIsOnLine;
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

            public Integer getUavIsOnLine() {
                return uavIsOnLine;
            }

            public void setUavIsOnLine(Integer uavIsOnLine) {
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
