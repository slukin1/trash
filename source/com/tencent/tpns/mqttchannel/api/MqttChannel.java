package com.tencent.tpns.mqttchannel.api;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.a.c;
import org.json.JSONObject;

public class MqttChannel implements IMqttChannel {

    /* renamed from: a  reason: collision with root package name */
    private static MqttChannel f49922a;

    /* renamed from: b  reason: collision with root package name */
    private c f49923b;

    private MqttChannel(Context context) {
        this.f49923b = new c(context);
    }

    public static synchronized MqttChannel getInstance(Context context) {
        MqttChannel mqttChannel;
        synchronized (MqttChannel.class) {
            if (f49922a == null) {
                f49922a = new MqttChannel(context);
            }
            mqttChannel = f49922a;
        }
        return mqttChannel;
    }

    public void bindAccount(String str, OnMqttCallback onMqttCallback) {
    }

    public void getConnectState(OnMqttCallback onMqttCallback) {
        this.f49923b.getConnectState(onMqttCallback);
    }

    public void ping(OnMqttCallback onMqttCallback) {
        this.f49923b.ping(onMqttCallback);
    }

    public void sendPublishData(String str, String str2, OnMqttCallback onMqttCallback) {
        this.f49923b.sendPublishData(str, str2, onMqttCallback);
    }

    public void sendRequest(String str, JSONObject jSONObject, OnMqttCallback onMqttCallback) {
        this.f49923b.sendRequest(str, jSONObject, onMqttCallback);
    }

    public void startConnect(OnMqttCallback onMqttCallback) {
        this.f49923b.startConnect(onMqttCallback);
    }

    public void stopConnect(OnMqttCallback onMqttCallback) {
        this.f49923b.stopConnect(onMqttCallback);
    }

    public void subscrbie(String str, OnMqttCallback onMqttCallback) {
        this.f49923b.subscrbie(str, onMqttCallback);
    }

    public void unBindAccount(OnMqttCallback onMqttCallback) {
    }

    public void unSubscrbie(String str, OnMqttCallback onMqttCallback) {
        this.f49923b.unSubscrbie(str, onMqttCallback);
    }
}
