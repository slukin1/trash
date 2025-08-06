package com.tencent.android.tpns.mqtt.internal;

import com.tencent.android.tpns.mqtt.IMqttActionListener;
import com.tencent.android.tpns.mqtt.IMqttToken;
import com.tencent.android.tpns.mqtt.MqttAsyncClient;
import com.tencent.android.tpns.mqtt.MqttCallbackExtended;
import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttConnectOptions;
import com.tencent.android.tpns.mqtt.MqttException;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import com.tencent.android.tpns.mqtt.MqttToken;
import com.tencent.android.tpns.mqtt.internal.wire.MqttWireMessage;

public class ConnectActionListener implements IMqttActionListener {
    private MqttAsyncClient client;
    private ClientComms comms;
    private MqttCallbackExtended mqttCallbackExtended;
    private MqttConnectOptions options;
    private int originalMqttVersion;
    private MqttClientPersistence persistence;
    private boolean reconnect;
    private IMqttActionListener userCallback;
    private Object userContext;
    private MqttToken userToken;

    public ConnectActionListener(MqttAsyncClient mqttAsyncClient, MqttClientPersistence mqttClientPersistence, ClientComms clientComms, MqttConnectOptions mqttConnectOptions, MqttToken mqttToken, Object obj, IMqttActionListener iMqttActionListener, boolean z11) {
        this.persistence = mqttClientPersistence;
        this.client = mqttAsyncClient;
        this.comms = clientComms;
        this.options = mqttConnectOptions;
        this.userToken = mqttToken;
        this.userContext = obj;
        this.userCallback = iMqttActionListener;
        this.originalMqttVersion = mqttConnectOptions.getMqttVersion();
        this.reconnect = z11;
    }

    public void connect() throws MqttPersistenceException {
        MqttToken mqttToken = new MqttToken(this.client.getClientId());
        mqttToken.setActionCallback(this);
        mqttToken.setUserContext(this);
        this.persistence.open(this.client.getClientId(), this.client.getServerURI());
        if (this.options.isCleanSession()) {
            this.persistence.clear();
        }
        if (this.options.getMqttVersion() == 0) {
            this.options.setMqttVersion(4);
        }
        try {
            this.comms.connect(this.options, mqttToken);
        } catch (Throwable th2) {
            onFailure(mqttToken, th2);
        }
    }

    public void onFailure(IMqttToken iMqttToken, Throwable th2) {
        MqttException mqttException;
        int length = this.comms.getNetworkModules().length;
        int networkModuleIndex = this.comms.getNetworkModuleIndex() + 1;
        if (networkModuleIndex < length || (this.originalMqttVersion == 0 && this.options.getMqttVersion() == 4)) {
            if (this.originalMqttVersion != 0) {
                this.comms.setNetworkModuleIndex(networkModuleIndex);
            } else if (this.options.getMqttVersion() == 4) {
                this.options.setMqttVersion(3);
            } else {
                this.options.setMqttVersion(4);
                this.comms.setNetworkModuleIndex(networkModuleIndex);
            }
            try {
                connect();
            } catch (MqttPersistenceException e11) {
                onFailure(iMqttToken, e11);
            }
        } else {
            if (this.originalMqttVersion == 0) {
                this.options.setMqttVersion(0);
            }
            if (th2 instanceof MqttException) {
                mqttException = (MqttException) th2;
            } else {
                mqttException = new MqttException(th2);
            }
            this.userToken.internalTok.markComplete((MqttWireMessage) null, mqttException);
            this.userToken.internalTok.notifyComplete();
            this.userToken.internalTok.setClient(this.client);
            if (this.userCallback != null) {
                this.userToken.setUserContext(this.userContext);
                this.userCallback.onFailure(this.userToken, th2);
            }
        }
    }

    public void onSuccess(IMqttToken iMqttToken) {
        if (this.originalMqttVersion == 0) {
            this.options.setMqttVersion(0);
        }
        this.userToken.internalTok.markComplete(iMqttToken.getResponse(), (MqttException) null);
        this.userToken.internalTok.notifyComplete();
        this.userToken.internalTok.setClient(this.client);
        this.comms.notifyConnect();
        if (this.userCallback != null) {
            this.userToken.setUserContext(this.userContext);
            this.userCallback.onSuccess(this.userToken);
        }
        if (this.mqttCallbackExtended != null) {
            this.mqttCallbackExtended.connectComplete(this.reconnect, this.comms.getNetworkModules()[this.comms.getNetworkModuleIndex()].getServerURI());
        }
    }

    public void setMqttCallbackExtended(MqttCallbackExtended mqttCallbackExtended2) {
        this.mqttCallbackExtended = mqttCallbackExtended2;
    }
}
