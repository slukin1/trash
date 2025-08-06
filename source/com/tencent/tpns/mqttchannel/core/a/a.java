package com.tencent.tpns.mqttchannel.core.a;

import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.a;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;

public class a extends a.C0637a {

    /* renamed from: a  reason: collision with root package name */
    private BaseMqttClientService f49926a;

    public a(BaseMqttClientService baseMqttClientService) {
        this.f49926a = baseMqttClientService;
    }

    public void a(boolean z11) {
        this.f49926a.onConnectComplete(z11);
    }

    public void b() {
        this.f49926a.onHeartBeat();
    }

    public void a() {
        this.f49926a.onConnectionLost();
    }

    public void a(Request request) {
        this.f49926a.onMessageArrived(request.getTopic(), request.getContent());
    }
}
