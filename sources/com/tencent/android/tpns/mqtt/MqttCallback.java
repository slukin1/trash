package com.tencent.android.tpns.mqtt;

public interface MqttCallback {
    void connectionLost(Throwable th2);

    void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken);

    void messageArrived(String str, MqttMessage mqttMessage) throws Exception;
}
