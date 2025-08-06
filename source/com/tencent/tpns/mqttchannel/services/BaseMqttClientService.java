package com.tencent.tpns.mqttchannel.services;

import android.content.Intent;
import android.os.IBinder;
import com.tencent.tpns.mqttchannel.core.common.inf.a;

public abstract class BaseMqttClientService {

    /* renamed from: a  reason: collision with root package name */
    private a.C0637a f50056a = new com.tencent.tpns.mqttchannel.core.a.a(this);

    public IBinder onBind(Intent intent) {
        return this.f50056a;
    }

    public abstract void onConnectComplete(boolean z11);

    public abstract void onConnectionLost();

    public abstract void onHeartBeat();

    public abstract void onMessageArrived(String str, String str2);
}
