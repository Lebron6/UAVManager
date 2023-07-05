package com.compass.uavmanager.entity;

import java.util.List;

public class EquipmentDetailsData {

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
         * uavVo
         */
        private UavVoDTO uavVo;
        /**
         * uavFlightInfoSumVo
         */
        private UavFlightInfoSumVoDTO uavFlightInfoSumVo;
        /**
         * uavInsuranceVo
         */
        private UavInsuranceVoDTO uavInsuranceVo;
        /**
         * uavMountVo
         */
        private List<?> uavMountVo;

        public UavVoDTO getUavVo() {
            return uavVo;
        }

        public void setUavVo(UavVoDTO uavVo) {
            this.uavVo = uavVo;
        }

        public UavFlightInfoSumVoDTO getUavFlightInfoSumVo() {
            return uavFlightInfoSumVo;
        }

        public void setUavFlightInfoSumVo(UavFlightInfoSumVoDTO uavFlightInfoSumVo) {
            this.uavFlightInfoSumVo = uavFlightInfoSumVo;
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
             * picUrlName
             */
            private String picUrlName;
            /**
             * name
             */
            private String name;
            /**
             * apronCode
             */
            private String apronCode;
            /**
             * apronName
             */
            private String apronName;
            /**
             * apronChineseName
             */
            private String apronChineseName;
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
             * chargerName
             */
            private String chargerName;
            /**
             * status
             */
            private String status;
            /**
             * ownerDept
             */
            private List<String> ownerDept;
            /**
             * lastOfflineTime
             */
            private String lastOfflineTime;
            /**
             * createTime
             */
            private String createTime;
            /**
             * charger
             */
            private String charger;
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
            private String isUavNeedMaintain;
            /**
             * flightTimeDuringMaintainPeriod
             */
            private Double flightTimeDuringMaintainPeriod;
            /**
             * healthState
             */
            private Integer healthState;
            /**
             * livegbsChannel
             */
            private String livegbsChannel;
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

            public String getPicUrlName() {
                return picUrlName;
            }

            public void setPicUrlName(String picUrlName) {
                this.picUrlName = picUrlName;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getApronCode() {
                return apronCode;
            }

            public void setApronCode(String apronCode) {
                this.apronCode = apronCode;
            }

            public String getApronName() {
                return apronName;
            }

            public void setApronName(String apronName) {
                this.apronName = apronName;
            }

            public String getApronChineseName() {
                return apronChineseName;
            }

            public void setApronChineseName(String apronChineseName) {
                this.apronChineseName = apronChineseName;
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

            public String getChargerName() {
                return chargerName;
            }

            public void setChargerName(String chargerName) {
                this.chargerName = chargerName;
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

            public String getLastOfflineTime() {
                return lastOfflineTime;
            }

            public void setLastOfflineTime(String lastOfflineTime) {
                this.lastOfflineTime = lastOfflineTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getCharger() {
                return charger;
            }

            public void setCharger(String charger) {
                this.charger = charger;
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

            public String getIsUavNeedMaintain() {
                return isUavNeedMaintain;
            }

            public void setIsUavNeedMaintain(String isUavNeedMaintain) {
                this.isUavNeedMaintain = isUavNeedMaintain;
            }

            public Double getFlightTimeDuringMaintainPeriod() {
                return flightTimeDuringMaintainPeriod;
            }

            public void setFlightTimeDuringMaintainPeriod(Double flightTimeDuringMaintainPeriod) {
                this.flightTimeDuringMaintainPeriod = flightTimeDuringMaintainPeriod;
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

            public Integer getBindId() {
                return bindId;
            }

            public void setBindId(Integer bindId) {
                this.bindId = bindId;
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

        public static class UavInsuranceVoDTO {
            /**
             * id
             */
            private Integer id;
            /**
             * insuranceNo
             */
            private String insuranceNo;
            /**
             * buyDate
             */
            private String buyDate;
            /**
             * startDate
             */
            private String startDate;
            /**
             * endDate
             */
            private String endDate;
            /**
             * insuranceType
             */
            private String insuranceType;
            /**
             * company
             */
            private String company;
            /**
             * companyPhone
             */
            private String companyPhone;
            /**
             * lastMaintenanceDate
             */
            private String lastMaintenanceDate;
            /**
             * warrantState
             */
            private String warrantState;
            /**
             * charge
             */
            private String charge;
            /**
             * chargePhone
             */
            private String chargePhone;

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getInsuranceNo() {
                return insuranceNo;
            }

            public void setInsuranceNo(String insuranceNo) {
                this.insuranceNo = insuranceNo;
            }

            public String getBuyDate() {
                return buyDate;
            }

            public void setBuyDate(String buyDate) {
                this.buyDate = buyDate;
            }

            public String getStartDate() {
                return startDate;
            }

            public void setStartDate(String startDate) {
                this.startDate = startDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
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

            public String getCompanyPhone() {
                return companyPhone;
            }

            public void setCompanyPhone(String companyPhone) {
                this.companyPhone = companyPhone;
            }

            public String getLastMaintenanceDate() {
                return lastMaintenanceDate;
            }

            public void setLastMaintenanceDate(String lastMaintenanceDate) {
                this.lastMaintenanceDate = lastMaintenanceDate;
            }

            public String getWarrantState() {
                return warrantState;
            }

            public void setWarrantState(String warrantState) {
                this.warrantState = warrantState;
            }

            public String getCharge() {
                return charge;
            }

            public void setCharge(String charge) {
                this.charge = charge;
            }

            public String getChargePhone() {
                return chargePhone;
            }

            public void setChargePhone(String chargePhone) {
                this.chargePhone = chargePhone;
            }
        }
    }
}
