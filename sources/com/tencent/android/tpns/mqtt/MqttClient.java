package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.persist.MqttDefaultFilePersistence;
import com.tencent.android.tpns.mqtt.util.Debug;
import java.util.concurrent.ScheduledExecutorService;

public class MqttClient implements IMqttClient {
    public MqttAsyncClient aClient;
    public long timeToWait;

    public MqttClient(String str, String str2) throws MqttException {
        this(str, str2, new MqttDefaultFilePersistence());
    }

    public static String generateClientId() {
        return MqttAsyncClient.generateClientId();
    }

    public void close() throws MqttException {
        this.aClient.close(false);
    }

    public void connect() throws MqttSecurityException, MqttException {
        connect(new MqttConnectOptions());
    }

    public IMqttToken connectWithResult(MqttConnectOptions mqttConnectOptions) throws MqttSecurityException, MqttException {
        IMqttToken connect = this.aClient.connect(mqttConnectOptions, (Object) null, (IMqttActionListener) null);
        connect.waitForCompletion(getTimeToWait());
        return connect;
    }

    public void disconnect() throws MqttException {
        this.aClient.disconnect().waitForCompletion();
    }

    public void disconnectForcibly() throws MqttException {
        this.aClient.disconnectForcibly();
    }

    public String getClientId() {
        return this.aClient.getClientId();
    }

    public String getCurrentServerURI() {
        return this.aClient.getCurrentServerURI();
    }

    public Debug getDebug() {
        return this.aClient.getDebug();
    }

    public IMqttDeliveryToken[] getPendingDeliveryTokens() {
        return this.aClient.getPendingDeliveryTokens();
    }

    public String getServerURI() {
        return this.aClient.getServerURI();
    }

    public long getTimeToWait() {
        return this.timeToWait;
    }

    public MqttTopic getTopic(String str) {
        return this.aClient.getTopic(str);
    }

    public boolean isConnected() {
        return this.aClient.isConnected();
    }

    public void messageArrivedComplete(int i11, int i12) throws MqttException {
        this.aClient.messageArrivedComplete(i11, i12);
    }

    public void publish(String str, byte[] bArr, int i11, boolean z11) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i11);
        mqttMessage.setRetained(z11);
        publish(str, mqttMessage);
    }

    public void reconnect() throws MqttException {
        this.aClient.reconnect();
    }

    public void setCallback(MqttCallback mqttCallback) {
        this.aClient.setCallback(mqttCallback);
    }

    public void setManualAcks(boolean z11) {
        this.aClient.setManualAcks(z11);
    }

    public void setTimeToWait(long j11) throws IllegalArgumentException {
        if (j11 >= -1) {
            this.timeToWait = j11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public void subscribe(String str) throws MqttException {
        subscribe(new String[]{str}, new int[]{1});
    }

    public IMqttToken subscribeWithResponse(String str) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{1});
    }

    public void unsubscribe(String str) throws MqttException {
        unsubscribe(new String[]{str});
    }

    public MqttClient(String str, String str2, MqttClientPersistence mqttClientPersistence) throws MqttException {
        this.aClient = null;
        this.timeToWait = -1;
        this.aClient = new MqttAsyncClient(str, str2, mqttClientPersistence);
    }

    public void close(boolean z11) throws MqttException {
        this.aClient.close(z11);
    }

    public void connect(MqttConnectOptions mqttConnectOptions) throws MqttSecurityException, MqttException {
        this.aClient.connect(mqttConnectOptions, (Object) null, (IMqttActionListener) null).waitForCompletion(getTimeToWait());
    }

    public void disconnect(long j11) throws MqttException {
        this.aClient.disconnect(j11, (Object) null, (IMqttActionListener) null).waitForCompletion();
    }

    public void disconnectForcibly(long j11) throws MqttException {
        this.aClient.disconnectForcibly(j11);
    }

    public void subscribe(String[] strArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = 1;
        }
        subscribe(strArr, iArr);
    }

    public IMqttToken subscribeWithResponse(String str, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{1}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public void unsubscribe(String[] strArr) throws MqttException {
        this.aClient.unsubscribe(strArr, (Object) null, (IMqttActionListener) null).waitForCompletion(getTimeToWait());
    }

    public void disconnectForcibly(long j11, long j12) throws MqttException {
        this.aClient.disconnectForcibly(j11, j12);
    }

    public IMqttToken subscribeWithResponse(String str, int i11) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{i11});
    }

    public void disconnectForcibly(long j11, long j12, boolean z11) throws MqttException {
        this.aClient.disconnectForcibly(j11, j12, z11);
    }

    public IMqttToken subscribeWithResponse(String str, int i11, IMqttMessageListener iMqttMessageListener) throws MqttException {
        return subscribeWithResponse(new String[]{str}, new int[]{i11}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public void publish(String str, MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        this.aClient.publish(str, mqttMessage, (Object) null, (IMqttActionListener) null).waitForCompletion(getTimeToWait());
    }

    public void subscribe(String str, int i11) throws MqttException {
        subscribe(new String[]{str}, new int[]{i11});
    }

    public IMqttToken subscribeWithResponse(String[] strArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = 1;
        }
        return subscribeWithResponse(strArr, iArr);
    }

    public MqttClient(String str, String str2, MqttClientPersistence mqttClientPersistence, ScheduledExecutorService scheduledExecutorService) throws MqttException {
        this.aClient = null;
        this.timeToWait = -1;
        this.aClient = new MqttAsyncClient(str, str2, mqttClientPersistence, new ScheduledExecutorPingSender(scheduledExecutorService), scheduledExecutorService);
    }

    public void subscribe(String[] strArr, int[] iArr) throws MqttException {
        IMqttToken subscribe = this.aClient.subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
        subscribe.waitForCompletion(getTimeToWait());
        int[] grantedQos = subscribe.getGrantedQos();
        for (int i11 = 0; i11 < grantedQos.length; i11++) {
            iArr[i11] = grantedQos[i11];
        }
        if (grantedQos.length == 1 && iArr[0] == 128) {
            throw new MqttException(128);
        }
    }

    public IMqttToken subscribeWithResponse(String[] strArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = 1;
        }
        return subscribeWithResponse(strArr, iArr, iMqttMessageListenerArr);
    }

    public IMqttToken subscribeWithResponse(String[] strArr, int[] iArr) throws MqttException {
        IMqttToken subscribe = this.aClient.subscribe(strArr, iArr, (Object) null, (IMqttActionListener) null);
        subscribe.waitForCompletion(getTimeToWait());
        return subscribe;
    }

    public void subscribe(String str, IMqttMessageListener iMqttMessageListener) throws MqttException {
        subscribe(new String[]{str}, new int[]{1}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public IMqttToken subscribeWithResponse(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        IMqttToken subscribeWithResponse = subscribeWithResponse(strArr, iArr);
        for (int i11 = 0; i11 < strArr.length; i11++) {
            this.aClient.comms.setMessageListener(strArr[i11], iMqttMessageListenerArr[i11]);
        }
        return subscribeWithResponse;
    }

    public void subscribe(String[] strArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        int length = strArr.length;
        int[] iArr = new int[length];
        for (int i11 = 0; i11 < length; i11++) {
            iArr[i11] = 1;
        }
        subscribe(strArr, iArr, iMqttMessageListenerArr);
    }

    public void subscribe(String str, int i11, IMqttMessageListener iMqttMessageListener) throws MqttException {
        subscribe(new String[]{str}, new int[]{i11}, new IMqttMessageListener[]{iMqttMessageListener});
    }

    public void subscribe(String[] strArr, int[] iArr, IMqttMessageListener[] iMqttMessageListenerArr) throws MqttException {
        subscribe(strArr, iArr);
        for (int i11 = 0; i11 < strArr.length; i11++) {
            this.aClient.comms.setMessageListener(strArr[i11], iMqttMessageListenerArr[i11]);
        }
    }
}
