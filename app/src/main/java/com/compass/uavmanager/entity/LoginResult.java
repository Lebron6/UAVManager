package com.compass.uavmanager.entity;

public class LoginResult {

    /**
     * code
     */
    private Integer code;
    /**
     * data
     */
    private DataDTO data;
    /**
     * message
     */
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataDTO {
        /**
         * access_token
         */
        private String access_token;
        /**
         * mqtt_addr
         */
        private String mqtt_addr;
        /**
         * mqtt_password
         */
        private String mqtt_password;
        /**
         * mqtt_username
         */
        private String mqtt_username;
        /**
         * user_id
         */
        private String user_id;
        /**
         * user_type
         */
        private Integer user_type;
        /**
         * username
         */
        private String username;
        /**
         * workspace_id
         */
        private String workspace_id;

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

        public String getMqtt_addr() {
            return mqtt_addr;
        }

        public void setMqtt_addr(String mqtt_addr) {
            this.mqtt_addr = mqtt_addr;
        }

        public String getMqtt_password() {
            return mqtt_password;
        }

        public void setMqtt_password(String mqtt_password) {
            this.mqtt_password = mqtt_password;
        }

        public String getMqtt_username() {
            return mqtt_username;
        }

        public void setMqtt_username(String mqtt_username) {
            this.mqtt_username = mqtt_username;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public Integer getUser_type() {
            return user_type;
        }

        public void setUser_type(Integer user_type) {
            this.user_type = user_type;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getWorkspace_id() {
            return workspace_id;
        }

        public void setWorkspace_id(String workspace_id) {
            this.workspace_id = workspace_id;
        }
    }
}
