package com.tencent.tpns.mqttchannel.core.services;

import android.content.Context;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttService;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;

public class MqttServiceImpl {

    /* renamed from: a  reason: collision with root package name */
    private IMqttService.Stub f50047a;

    public MqttServiceImpl(Context context, BaseMqttClientService baseMqttClientService) {
        this.f50047a = new IMqttServiceImpl(context, baseMqttClientService);
    }

    public IMqttService.Stub getIMqttService() {
        return this.f50047a;
    }

    public MqttServiceImpl(Context context) {
        this.f50047a = new IMqttServiceImpl(context);
    }
}
