package com.compass.uavmanager.api;


import com.compass.uavmanager.entity.AirName;
import com.compass.uavmanager.entity.BindUav;
import com.compass.uavmanager.entity.BindUavResult;
import com.compass.uavmanager.entity.CallBackResult;
import com.compass.uavmanager.entity.EquipmentDetailsData;
import com.compass.uavmanager.entity.EquipmentResult;
import com.compass.uavmanager.entity.FlightHistoryDetails;
import com.compass.uavmanager.entity.FlightHistoryList;
import com.compass.uavmanager.entity.FlightPoints;
import com.compass.uavmanager.entity.GetMediaData;
import com.compass.uavmanager.entity.HomeProject;
import com.compass.uavmanager.entity.LiveUrlResult;
import com.compass.uavmanager.entity.LoginResult;
import com.compass.uavmanager.entity.LoginSimpleResult;
import com.compass.uavmanager.entity.LoginValues;
import com.compass.uavmanager.entity.MessageResult;
import com.compass.uavmanager.entity.OverView;
import com.compass.uavmanager.entity.ReplyValues;
import com.compass.uavmanager.entity.TaskReportResult;
import com.compass.uavmanager.entity.TaskReportValues;
import com.compass.uavmanager.entity.UpdataPasswordResult;
import com.compass.uavmanager.entity.UserInfo;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;


/**
 * Created by James on 2022/6/21.
 */

public interface UavApi {
    /**
     * 登录
     */
    @Headers("Content-Type:application/json")
    @POST("login")
    Call<LoginResult> userLogin(@Body LoginValues loginValues);

    /**
     * 登录2
     */
    @Headers("Content-Type:application/json")
    @POST("/login")
    Call<LoginSimpleResult> userLogin2(@Body LoginValues loginValues);

    /**
     * 修改密码
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/system/password")
    Call<UpdataPasswordResult> updataPassword(@Header("authorization") String token,
                                              @Query("oldPassword") String oldPassword, @Query("newPassword") String newPassword);

    /**
     * 获取用户信息
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/system/user-info")
    Call<UserInfo> getUserInfo(@Header("authorization") String token);

    /**
     * 通过SN获取设备名称
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/uav-data/uavName")
    Call<AirName> getName(@Header("authorization") String token, @Query("uavCode") String uavCode);

    /**
     * 绑定无人机(首页websocket需要)
     */
    @Headers("Content-Type:application/json")
    @POST("/uav/uavBind/batch")
    Call<BindUavResult> uavBindBatch(@Header("authorization") String token, @Body BindUav bindUav);

    /**
     * 设备管理
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/uav-data/daping/list/uav")
    Call<EquipmentResult> equipmentList(@Header("authorization") String token,
                                        @Query("pageNum") int pageNum,
                                        @Query("pageSize") int pageSize,
                                        @Query("status") String status
    );

    /**
     * 设备详情
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/uav-data/info/detail")
    Call<EquipmentDetailsData> equipmentDetail(@Header("authorization") String token,
                                               @Query("uavCode") String uavCode

    );

    /**
     * 飞行历史
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/data-statistics/flight-history")
    Call<FlightHistoryList> flightHistory(@Header("authorization") String token,
                                          @Query("startTime") String startTime,
                                          @Query("endTime") String endTime,
                                          @Query("pageSize") int pageSize,
                                          @Query("pageNum") int pageNum
    );


    /**
     * 飞行历史详情
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/data-statistics/flight/detail")
    Call<FlightHistoryDetails> historyDetail(@Header("authorization") String token,
                                             @Query("sortieId") String id

    );

    /**
     * 飞行历史点位
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/data-statistics/flight/points")
    Call<FlightPoints> flightPoints(@Header("authorization") String token,
                                    @Query("sortieId") String id

    );

    /**
     * 任务报备
     */
    @Headers("Content-Type:application/json")
    @POST("/taskReportEntity/api/add")
    Call<TaskReportResult> taskReport(@Header("authorization") String token, @Body TaskReportValues taskReportValues);

    /**
     * 消息
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/annunciateEntity/api/listAnnunciate")
    Call<MessageResult> messageList(@Header("authorization") String token,
                                    @Query("pageNum") int pageNum,
                                    @Query("pageSize") int pageSize

    );

    /**
     * 获取回复信息
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/replyEntity/api/get")
    Call<CallBackResult> callBackList(@Header("authorization") String token,
                                      @Query("taskid") String taskid
    );


    /**
     * 回复
     */
    @Headers("Content-Type:application/json")
    @POST("/replyEntity/api/add")
    Call<TaskReportResult> reply(@Header("authorization") String token, @Body ReplyValues replyValues);

    /**
     * 获取媒体文件
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/oauth/photo/query")
    Call<GetMediaData> getMediaList(@Header("authorization") String token,
                                    @Query("pageNum") String pageNum,
                                    @Query("pageSize") String pageSize,
                                    @Query("startTime") String startTime,
                                    @Query("endTime") String endTime,
                                    @Query("fileType") String fileType
    );


    /**
     * 首页项目
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/manageProjectEntity/currentUser/list")
    Call<HomeProject> manageProject(@Header("authorization") String token
    );

    /**
     * 首页飞机
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/live/overview")
    Call<OverView> liveOverview(@Header("authorization") String token
    );

    /**
     * 获取推流地址
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/manage/api/v1/live/push/url/{uavSn}")
    Call<LiveUrlResult> pushUrl(@Header("authorization") String token,
                                @Query("uavSn") String uavSn
    );

    /**
     * 获取推流地址（国标）
     */
    @Headers("Content-Type:application/x-www-form-urlencoded")
    @GET("/manage/api/v1/live/pull/gbUrlFlv/{sn}")
    Call<LiveUrlResult> pushUrlGB(@Header("authorization") String token,
                                @Query("uavSn") String uavSn
    );

}