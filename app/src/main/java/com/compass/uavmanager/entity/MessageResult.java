package com.compass.uavmanager.entity;

import java.util.List;

public class MessageResult {

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
         * annunciateTheme
         */
        private String annunciateTheme;
        /**
         * annunciateInfo
         */
        private String annunciateInfo;
        /**
         * annunciateAccessory
         */
        private String annunciateAccessory;
        /**
         * organizationId
         */
        private String organizationId;
        /**
         * createby
         */
        private String createby;
        /**
         * createtime
         */
        private String createtime;
        /**
         * state
         */
        private Integer state;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAnnunciateTheme() {
            return annunciateTheme;
        }

        public void setAnnunciateTheme(String annunciateTheme) {
            this.annunciateTheme = annunciateTheme;
        }

        public String getAnnunciateInfo() {
            return annunciateInfo;
        }

        public void setAnnunciateInfo(String annunciateInfo) {
            this.annunciateInfo = annunciateInfo;
        }

        public String getAnnunciateAccessory() {
            return annunciateAccessory;
        }

        public void setAnnunciateAccessory(String annunciateAccessory) {
            this.annunciateAccessory = annunciateAccessory;
        }

        public String getOrganizationId() {
            return organizationId;
        }

        public void setOrganizationId(String organizationId) {
            this.organizationId = organizationId;
        }

        public String getCreateby() {
            return createby;
        }

        public void setCreateby(String createby) {
            this.createby = createby;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }
    }
}
