package com.compass.uavmanager.entity;

public class TaskReportResult {
    /**
     * success
     */
    private Boolean success;
    /**
     * code
     */
    private String code;
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
}
