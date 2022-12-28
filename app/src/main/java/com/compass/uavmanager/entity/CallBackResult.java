package com.compass.uavmanager.entity;

import java.util.List;

public class CallBackResult {

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
         * annunciateId
         */
        private Integer annunciateId;
        /**
         * taskId
         */
        private Integer taskId;
        /**
         * name
         */
        private String name;
        /**
         * replyTime
         */
        private String replyTime;
        /**
         * replyinfo
         */
        private String replyinfo;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getAnnunciateId() {
            return annunciateId;
        }

        public void setAnnunciateId(Integer annunciateId) {
            this.annunciateId = annunciateId;
        }

        public Integer getTaskId() {
            return taskId;
        }

        public void setTaskId(Integer taskId) {
            this.taskId = taskId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getReplyTime() {
            return replyTime;
        }

        public void setReplyTime(String replyTime) {
            this.replyTime = replyTime;
        }

        public String getReplyinfo() {
            return replyinfo;
        }

        public void setReplyinfo(String replyinfo) {
            this.replyinfo = replyinfo;
        }
    }
}
