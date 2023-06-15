package com.compass.uavmanager.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.RadioGroup;

import androidx.viewbinding.ViewBinding;
import androidx.viewpager.widget.ViewPager;

import com.compass.uavmanager.R;
import com.compass.uavmanager.adapter.MainPageAdapter;
import com.compass.uavmanager.api.BaseUrl;
import com.compass.uavmanager.base.BaseActivity;
import com.compass.uavmanager.databinding.ActivityMainBinding;
import com.compass.uavmanager.entity.EventMessage;
import com.compass.uavmanager.entity.UavSocketInfo;
import com.compass.uavmanager.entity.WebSocketRegister;
import com.compass.uavmanager.tools.PreferenceUtils;
import com.compass.uavmanager.tools.SH1Utils;
import com.compass.uavmanager.websocket.JWebSocketClient;
import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import org.greenrobot.eventbus.EventBus;
import org.java_websocket.handshake.ServerHandshake;
import org.json.JSONObject;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 主页
 */
public class MainActivity extends BaseActivity {

    private MainPageAdapter pageAdapter;
    private ActivityMainBinding mBinding;
    JWebSocketClient client;
    JWebSocketClient client2;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        pageAdapter = new MainPageAdapter(getSupportFragmentManager());
        mBinding.vpContent.setAdapter(pageAdapter);
        mBinding.vpContent.setOffscreenPageLimit(4);
        mBinding.vpContent.setOnPageChangeListener(onPagerChangerListener);
        mBinding.rgMain.setOnCheckedChangeListener(onCheckedChangeListener);
        mBinding.rbHome.setChecked(true);
        initWebSocket();
        initWebSocket2();
    }

    @Override
    public void initData() {
        Log.e("sh1:", SH1Utils.getSHA1(this));
    }

    @Override
    public boolean useEventBus() {
        return false;
    }

    ViewPager.OnPageChangeListener onPagerChangerListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            switch (position) {
                case 0:
                    mBinding.rbHome.setChecked(true);
                    break;
                case 1:
                    mBinding.rbEquipment.setChecked(true);
                    break;
                case 2:
                    mBinding.rbFlightHistory.setChecked(true);
                    break;
                case 3:
                    mBinding.rbGallery.setChecked(true);
                    break;
                case 4:
                    mBinding.rbPersonal.setChecked(true);
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

    };

    RadioGroup.OnCheckedChangeListener onCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            setTabSelection(checkedId);
        }
    };

    private void setTabSelection(int checkedId) {
        switch (checkedId) {
            case R.id.rb_home:
                mBinding.vpContent.setCurrentItem(0, false);
                break;
            case R.id.rb_equipment:
                mBinding.vpContent.setCurrentItem(1, false);
                break;
            case R.id.rb_flight_history:
                mBinding.vpContent.setCurrentItem(2, false);
                break;
            case R.id.rb_gallery:
                mBinding.vpContent.setCurrentItem(3, false);
                break;
            case R.id.rb_personal:
                mBinding.vpContent.setCurrentItem(4, false);
                break;


        }
    }


    @Override
    public ViewBinding getViewBinding() {
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        return mBinding;
    }


    /**
     * 初始化websocket
     */
    public void initWebSocket() {
        //TODO 创建websocket
        URI uri;
        uri = URI.create(BaseUrl.ws);
//        uri = URI.create(BaseUrl.ws+PreferenceUtils.getInstance().getUserCloudToken());
        Logger.e("websocket连接地址：" + uri.toString());
        client = new JWebSocketClient(uri) {
            @Override
            public void onMessage(String message) {
                super.onMessage(message);
                try {
                    JSONObject jsonObject=new JSONObject(message);
                    String type = jsonObject.getString("type");
                    if (type.equals("flightController")){
                        Logger.e("websocket收到消息:" + message);
                        EventMessage eventMessage=new EventMessage();
                        eventMessage.setType("app");
                        eventMessage.setMessage(message);
                        EventBus.getDefault().post(eventMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onOpen(ServerHandshake handshakedata) {
                super.onOpen(handshakedata);
                Logger.e("websocket连接成功" + "-----");
                WebSocketRegister webSocketRegister = new WebSocketRegister();
                webSocketRegister.setCode(0);
                webSocketRegister.setEquipmentId(PreferenceUtils.getInstance().getUserName());
                webSocketRegister.setMethod("register");
                webSocketRegister.setRequestTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
                sendMsg(new Gson().toJson(webSocketRegister));
            }

            @Override
            public void onError(Exception ex) {
                super.onError(ex);
                Logger.e("websocket连接错误" + ex);
            }
            @Override
            public void onClose(int code, String reason, boolean remote) {
                super.onClose(code, reason, remote);
                if (code != 1000) {
                    reconnectWs();//意外断开马上重连
                }
                Logger.e("websocket连接断开" + "---");
            }
        };
        //TODO 设置超时时间
        client.setConnectionLostTimeout(110 * 1000);
        //TODO 连接websocket
        new Thread() {
            @Override
            public void run() {
                try {
                    //connectBlocking多出一个等待操作，会先连接再发送，否则未连接发送会报错
                    client.connectBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 发送消息
     *
     * @param msg
     */
    public void sendMsg(String msg) {
        if (null != client) {
            if (client.isOpen()) {
                Logger.e("Websocket发送消息：" + msg);
                client.send(msg);
            }

        }
    }

    /**
     * 开启重连
     */
    private void reconnectWs() {
        mHandler.removeCallbacks(heartBeatRunnable);
        new Thread() {
            @Override
            public void run() {
                try {
                    Log.e("开启重连", "");
                    client.reconnectBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 断开连接
     */
    private void closeConnect() {
        try {
            //关闭websocket
            if (null != client) {
                client.close();
            }
            //停止心跳
            if (mHandler != null) {
                mHandler.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client = null;
        }
    }

    //    -------------------------------------websocket心跳检测------------------------------------------------
    private static final long HEART_BEAT_RATE = 10 * 1000;//每隔10秒进行一次对长连接的心跳检测
    private Handler mHandler = new Handler();
    private Runnable heartBeatRunnable = new Runnable() {
        @Override
        public void run() {
            if (client != null) {
                if (client.isClosed()) {
                    reconnectWs();//心跳机制发现断开开启重连
                } else {
                    sendMsg("Heartbeat");
                }
            } else {
                Log.e("心跳包检测websocket连接状态重新连接", "");
                //如果client已为空，重新初始化连接
                client = null;
                initWebSocket();
            }
            //每隔一定的时间，对长连接进行一次心跳检测
            mHandler.postDelayed(this, HEART_BEAT_RATE);
        }
    };

    /************************************************************************************8/
     *
     */

    /**
     * 初始化websocket
     */
    public void initWebSocket2() {
        //TODO 创建websocket
        URI uri;
        uri = URI.create(BaseUrl.ws2+PreferenceUtils.getInstance().getUserCloudToken());
        Logger.e("websocket2连接地址：" + uri.toString());
        client2 = new JWebSocketClient(uri) {
            @Override
            public void onMessage(String message) {
                super.onMessage(message);
                Logger.e("websocket2收到消息:" + message);

                try {
                    JSONObject jsonObject=new JSONObject(message);
                    String type = jsonObject.getString("biz_code");
                    if (type.equals("device_osd")){
                            Logger.e("websocket2收到消息:" + message);
                            EventMessage eventMessage=new EventMessage();
                            eventMessage.setType("icould");
                            eventMessage.setMessage(message);
                            EventBus.getDefault().post(eventMessage);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onOpen(ServerHandshake handshakedata) {
                super.onOpen(handshakedata);
                Logger.e("websocket2连接成功" + "-----");
            }

            @Override
            public void onError(Exception ex) {
                super.onError(ex);
                Logger.e("websocket2连接错误" + ex);
            }
            @Override
            public void onClose(int code, String reason, boolean remote) {
                super.onClose(code, reason, remote);
                if (code != 1000) {
                    reconnectWs2();//意外断开马上重连
                }
                Logger.e("websocket2连接断开" + "---");
            }
        };
        //TODO 设置超时时间
        client2.setConnectionLostTimeout(110 * 1000);
        //TODO 连接websocket
        new Thread() {
            @Override
            public void run() {
                try {
                    //connectBlocking多出一个等待操作，会先连接再发送，否则未连接发送会报错
                    client2.connectBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 发送消息
     *
     * @param msg
     */
    public void sendMsg2(String msg) {
        if (null != client2) {
            if (client2.isOpen()) {
                Logger.e("Websocket2发送消息：" + msg);
                client2.send(msg);
            }

        }
    }

    /**
     * 开启重连
     */
    private void reconnectWs2() {
        mHandler2.removeCallbacks(heartBeatRunnable2);
        new Thread() {
            @Override
            public void run() {
                try {
                    Log.e("开启重连2", "");
                    client2.reconnectBlocking();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    /**
     * 断开连接
     */
    private void closeConnect2() {
        try {
            //关闭websocket
            if (null != client2) {
                client2.close();
            }
            //停止心跳
            if (mHandler2 != null) {
                mHandler2.removeCallbacksAndMessages(null);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client2 = null;
        }
    }

    //    -------------------------------------websocket心跳检测------------------------------------------------
    private static final long HEART_BEAT_RATE_2 = 10 * 1000;//每隔10秒进行一次对长连接的心跳检测
    private Handler mHandler2 = new Handler();
    private Runnable heartBeatRunnable2 = new Runnable() {
        @Override
        public void run() {
            if (client2 != null) {
                if (client2.isClosed()) {
                    reconnectWs2();//心跳机制发现断开开启重连
                } else {
                    sendMsg2("Heartbeat");
                }
            } else {
                Log.e("心跳包检测websocket2连接状态重新连接", "");
                //如果client已为空，重新初始化连接
                client2 = null;
                initWebSocket2();
            }
            //每隔一定的时间，对长连接进行一次心跳检测
            mHandler2.postDelayed(this, HEART_BEAT_RATE_2);
        }
    };


}