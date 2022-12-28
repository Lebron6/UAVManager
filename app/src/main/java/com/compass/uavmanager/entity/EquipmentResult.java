package com.compass.uavmanager.entity;

import java.util.List;

public class EquipmentResult {

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
         * uavVo
         */
        private UavVoDTO uavVo;
        /**
         * uavInsuranceVo
         */
        private UavInsuranceVoDTO uavInsuranceVo;
        /**
         * uavMountVo
         */
        private List<?> uavMountVo;
        /**
         * uavFlightInfoSumVo
         */
        private UavFlightInfoSumVoDTO uavFlightInfoSumVo;

        public UavVoDTO getUavVo() {
            return uavVo;
        }

        public void setUavVo(UavVoDTO uavVo) {
            this.uavVo = uavVo;
        }

        public UavInsuranceVoDTO getUavInsuranceVo() {
            return uavInsuranceVo;
        }

        public void setUavInsuranceVo(UavInsuranceVoDTO uavInsuranceVo) {
            this.uavInsuranceVo = uavInsuranceVo;
        }

        public List<?> getUavMountVo() {
            return uavMountVo;
        }

        public void setUavMountVo(List<?> uavMountVo) {
            this.uavMountVo = uavMountVo;
        }

        public UavFlightInfoSumVoDTO getUavFlightInfoSumVo() {
            return uavFlightInfoSumVo;
        }

        public void setUavFlightInfoSumVo(UavFlightInfoSumVoDTO uavFlightInfoSumVo) {
            this.uavFlightInfoSumVo = uavFlightInfoSumVo;
        }

        public static class UavVoDTO {
            /**
             * id
             */
            private Integer id;
            /**
             * uavName
             */
            private String uavName;
            /**
             * name
             */
            private String name;
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
             * status
             */
            private String status;
            /**
             * ownerDept
             */
            private List<String> ownerDept;
            /**
             * createTime
             */
            private String createTime;
            /**
             * picUrl
             */
            private String picUrl;
            /**
             * insuranceId
             */
            private Integer insuranceId;
            /**
             * isUavNeedMaintain
             */
            private Boolean isUavNeedMaintain;
            /**
             * healthState
             */
            private Integer healthState;
            /**
             * bindId
             */
            private Integer bindId;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getUavName() {
                return uavName;
            }

            public void setUavName(String uavName) {
                this.uavName = uavName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public List<String> getOwnerDept() {
                return ownerDept;
            }

            public void setOwnerDept(List<String> ownerDept) {
                this.ownerDept = ownerDept;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
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

            public Boolean getIsUavNeedMaintain() {
                return isUavNeedMaintain;
            }

            public void setIsUavNeedMaintain(Boolean isUavNeedMaintain) {
                this.isUavNeedMaintain = isUavNeedMaintain;
            }

            public Integer getHealthState() {
                return healthState;
            }

            public void setHealthState(Integer healthState) {
                this.healthState = healthState;
            }

            public Integer getBindId() {
                return bindId;
            }

            public void setBindId(Integer bindId) {
                this.bindId = bindId;
            }
        }

        public static class UavInsuranceVoDTO {
            /**
             * id
             */
            private Integer id;
            /**
             * insuranceType
             */
            private String insuranceType;
            /**
             * company
             */
            private String company;
            /**
             * warrantState
             */
            private Integer warrantState;
            /**
             * charge
             */
            private String charge;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getInsuranceType() {
                return insuranceType;
            }

            public void setInsuranceType(String insuranceType) {
                this.insuranceType = insuranceType;
            }

            public String getCompany() {
                return company;
            }

            public void setCompany(String company) {
                this.company = company;
            }

            public Integer getWarrantState() {
                return warrantState;
            }

            public void setWarrantState(Integer warrantState) {
                this.warrantState = warrantState;
            }

            public String getCharge() {
                return charge;
            }

            public void setCharge(String charge) {
                this.charge = charge;
            }
        }

        public static class UavFlightInfoSumVoDTO {
            /**
             * totalDistance
             */
            private Double totalDistance;
            /**
             * totalFlyTime
             */
            private Integer totalFlyTime;
            /**
             * flyCount
             */
            private Integer flyCount;

            public Double getTotalDistance() {
                return totalDistance;
            }

            public void setTotalDistance(Double totalDistance) {
                this.totalDistance = totalDistance;
            }

            public Integer getTotalFlyTime() {
                return totalFlyTime;
            }

            public void setTotalFlyTime(Integer totalFlyTime) {
                this.totalFlyTime = totalFlyTime;
            }

            public Integer getFlyCount() {
                return flyCount;
            }

            public void setFlyCount(Integer flyCount) {
                this.flyCount = flyCount;
            }
        }
    }
}
