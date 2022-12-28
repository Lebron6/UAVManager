package com.compass.uavmanager.entity;

import java.util.List;

public class GetMediaData {

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
    private String total;

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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public static class ResultsDTO {
        /**
         * id
         */
        private String id;
        /**
         * uavCode
         */
        private String uavCode;
        /**
         * uavName
         */
        private String uavName;
        /**
         * fileName
         */
        private String fileName;
        /**
         * fileSource
         */
        private String fileSource;
        /**
         * type
         */
        private String type;
        /**
         * path
         */
        private String path;
        /**
         * objectKey
         */
        private String objectKey;
        /**
         * downloadPath
         */
        private String downloadPath;
        /**
         * thumPath
         */
        private String thumPath;
        /**
         * size
         */
        private String size;
        /**
         * duration
         */
        private String duration;
        /**
         * createTime
         */
        private String createTime;
        /**
         * shootTime
         */
        private String shootTime;
        /**
         * lng
         */
        private String lng;
        /**
         * lat
         */
        private String lat;
        /**
         * payload
         */
        private String payload;
        /**
         * taskId
         */
        private String taskId;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileSource() {
            return fileSource;
        }

        public void setFileSource(String fileSource) {
            this.fileSource = fileSource;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPath() {
            return path;
        }

        public void setPath(String path) {
            this.path = path;
        }

        public String getObjectKey() {
            return objectKey;
        }

        public void setObjectKey(String objectKey) {
            this.objectKey = objectKey;
        }

        public String getDownloadPath() {
            return downloadPath;
        }

        public void setDownloadPath(String downloadPath) {
            this.downloadPath = downloadPath;
        }

        public String getThumPath() {
            return thumPath;
        }

        public void setThumPath(String thumPath) {
            this.thumPath = thumPath;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getShootTime() {
            return shootTime;
        }

        public void setShootTime(String shootTime) {
            this.shootTime = shootTime;
        }

        public String getLng() {
            return lng;
        }

        public void setLng(String lng) {
            this.lng = lng;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getPayload() {
            return payload;
        }

        public void setPayload(String payload) {
            this.payload = payload;
        }

        public String getTaskId() {
            return taskId;
        }

        public void setTaskId(String taskId) {
            this.taskId = taskId;
        }
    }
}
