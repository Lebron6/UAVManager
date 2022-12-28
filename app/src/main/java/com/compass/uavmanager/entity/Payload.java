package com.compass.uavmanager.entity;

import java.io.Serializable;
import java.util.Map;

public class Payload implements Serializable {

  /**
   * 请求标识
   */
  private String requestId;

  /**
   * 设备编号
   */
  private String equipmentId;

  /**
   * 方法名
   */
  private String method;

  /**
   * 请求参数
   */
  private Map<String, String> para;

  /**
   * 返回状态
   */
  private int code;

  /**
   * 返回值
   */
  private String result;

  /**
   * 请求时间
   */
  private String requestTime;

  /**
   * 响应时间
   */
  private String responseTime;


  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getEquipmentId() {
    return equipmentId;
  }

  public void setEquipmentId(String equipmentId) {
    this.equipmentId = equipmentId;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public Map<String, String> getPara() {
    return para;
  }

  public void setPara(Map<String, String> para) {
    this.para = para;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getRequestTime() {
    return requestTime;
  }

  public void setRequestTime(String requestTime) {
    this.requestTime = requestTime;
  }

  public String getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(String responseTime) {
    this.responseTime = responseTime;
  }

  @Override
  public String toString() {
    return "Communication{" +
            "requestId='" + requestId + '\'' +
            ", equipmentId='" + equipmentId + '\'' +
            ", method='" + method + '\'' +
            ", para=" + para +
            ", code=" + code +
            ", result='" + result + '\'' +
            ", requestTime='" + requestTime + '\'' +
            ", responseTime='" + responseTime + '\'' +
            '}';
  }
}
