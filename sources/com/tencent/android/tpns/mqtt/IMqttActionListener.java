package com.tencent.android.tpns.mqtt;

public interface IMqttActionListener {
    void onFailure(IMqttToken iMqttToken, Throwable th2);

    void onSuccess(IMqttToken iMqttToken);
}
