package com.compass.uavmanager.entity;

public class LoginSimpleResult {
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
         * roleType
         */
        private String roleType;
        /**
         * userId
         */
        private String userId;
        /**
         * departmentLevel
         */
        private String departmentLevel;

        public String getRoleType() {
            return roleType;
        }

        public void setRoleType(String roleType) {
            this.roleType = roleType;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getDepartmentLevel() {
            return departmentLevel;
        }

        public void setDepartmentLevel(String departmentLevel) {
            this.departmentLevel = departmentLevel;
        }
    }
}
