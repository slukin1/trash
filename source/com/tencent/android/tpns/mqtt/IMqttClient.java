package com.tencent.android.tpns.mqtt;

public interface IMqttClient {
    void close() throws MqttException;

    void connect() throws MqttSecurityException, MqttException;

    void connect(MqttConnectOptions mqttConnectOptions) throws MqttSecurityException, MqttException;

    IMqttToken connectWithResult(MqttConnectOptions mqttConnectOptions) throws MqttSecurityException, MqttException;

    void disconnect() throws MqttException;

    void disconnect(long j11) throws MqttException;

    void disconnectForcibly() throws MqttException;

    void disconnectForcibly(long j11) throws MqttException;

    void disconnectForcibly(long j11, long j12) throws MqttException;

    String getClientId();

    IMqttDeliveryToken[] getPendingDeliveryTokens();

    String getServerURI();

    MqttTopic getTopic(String str);

    boolean isConnected();

    void messageArrivedComplete(int i11, int i12) throws MqttException;

    void publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException;

    void publish(String str, byte[] bArr, int i11, boolean z11) throws MqttException, MqttPersistenceException;

    void setCallback(MqttCallback mqttCallback);

    void setManualAcks(boolean z11);

    void subscribe(String str) throws MqttException, MqttSecurityException;

    void subscribe(String str, int i11) throws MqttException;

    void subscribe(String str, int i11, IMqttMessageListener iMqttMessageListener) throws MqttException;

    void subscribe(String str, IMqttMessageListener iMqttMessageListener) throws MqttException, MqttSecurityException;

    void subscribe(String[] strArr) throws MqttException;

    void subscribe(String[] strArr, int[] iArr) throws MqttException;

    void subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException;

    void subscribe(String[] strArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException;

    IMqttToken subscribeWithResponse(String str) throws MqttException;

    IMqttToken subscribeWithResponse(String str, int i11) throws MqttException;

    IMqttToken subscribeWithResponse(String str, int i11, IMqttMessageListener iMqttMessageListener) throws MqttException;

    IMqttToken subscribeWithResponse(String str, IMqttMessageListener iMqttMessageListener) throws MqttException;

    IMqttToken subscribeWithResponse(String[] strArr) throws MqttException;

    IMqttToken subscribeWithResponse(String[] strArr, int[] iArr) throws MqttException;

    IMqttToken subscribeWithResponse(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException;

    IMqttToken subscribeWithResponse(String[] strArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException;

    void unsubscribe(String str) throws MqttException;

    void unsubscribe(String[] strArr) throws MqttException;
}
