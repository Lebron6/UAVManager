package com.compass.uavmanager.entity;

import java.util.List;

public class UserInfo {
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
         * username
         */
        private String username;
        /**
         * nameCn
         */
        private String nameCn;
        /**
         * roleName
         */
        private String roleName;
        /**
         * roleId
         */
        private Integer roleId;
        /**
         * departmentName
         */
        private String departmentName;
        /**
         * departmentId
         */
        private Integer departmentId;
        /**
         * departmentLevel
         */
        private Integer departmentLevel;
        /**
         * phone
         */
        private String phone;
        /**
         * totalFlightDistance
         */
        private Double totalFlightDistance;
        /**
         * totalFlightTime
         */
        private String totalFlightTime;
        /**
         * maxFlightDistance
         */
        private Double maxFlightDistance;
        /**
         * maxFlightSpeed
         */
        private Double maxFlightSpeed;
        /**
         * flightCount
         */
        private Integer flightCount;
        /**
         * menuCode
         */
        private List<?> menuCode;
        /**
         * userImagePath
         */
        private String userImagePath;
        /**
         * userBase64
         */
        private Object userBase64;
        /**
         * logoPath
         */
        private String logoPath;

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

        public String getNameCn() {
            return nameCn;
        }

        public void setNameCn(String nameCn) {
            this.nameCn = nameCn;
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

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public Integer getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(Integer departmentId) {
            this.departmentId = departmentId;
        }

        public Integer getDepartmentLevel() {
            return departmentLevel;
        }

        public void setDepartmentLevel(Integer departmentLevel) {
            this.departmentLevel = departmentLevel;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public Double getTotalFlightDistance() {
            return totalFlightDistance;
        }

        public void setTotalFlightDistance(Double totalFlightDistance) {
            this.totalFlightDistance = totalFlightDistance;
        }

        public String getTotalFlightTime() {
            return totalFlightTime;
        }

        public void setTotalFlightTime(String totalFlightTime) {
            this.totalFlightTime = totalFlightTime;
        }

        public Double getMaxFlightDistance() {
            return maxFlightDistance;
        }

        public void setMaxFlightDistance(Double maxFlightDistance) {
            this.maxFlightDistance = maxFlightDistance;
        }

        public Double getMaxFlightSpeed() {
            return maxFlightSpeed;
        }

        public void setMaxFlightSpeed(Double maxFlightSpeed) {
            this.maxFlightSpeed = maxFlightSpeed;
        }

        public Integer getFlightCount() {
            return flightCount;
        }

        public void setFlightCount(Integer flightCount) {
            this.flightCount = flightCount;
        }

        public List<?> getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(List<?> menuCode) {
            this.menuCode = menuCode;
        }

        public String getUserImagePath() {
            return userImagePath;
        }

        public void setUserImagePath(String userImagePath) {
            this.userImagePath = userImagePath;
        }

        public Object getUserBase64() {
            return userBase64;
        }

        public void setUserBase64(Object userBase64) {
            this.userBase64 = userBase64;
        }

        public String getLogoPath() {
            return logoPath;
        }

        public void setLogoPath(String logoPath) {
            this.logoPath = logoPath;
        }
    }
}
