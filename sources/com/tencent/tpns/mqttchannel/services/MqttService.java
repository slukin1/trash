package com.tencent.tpns.mqttchannel.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.core.common.a.a;
import com.tencent.tpns.mqttchannel.core.services.MqttServiceImpl;

public class MqttService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private MqttServiceImpl f50057a;

    public IBinder onBind(Intent intent) {
        a.b("MqttService", "onBind: ");
        return this.f50057a.getIMqttService();
    }

    public void onCreate() {
        super.onCreate();
        try {
            if (!XGApiConfig.isEnableService(this)) {
                a.b("MqttService", "MqttService onCreate  ");
                stopSelf();
                Util.killPushProcess(this);
                return;
            }
        } catch (Throwable unused) {
            a.b("MqttService", "unexpected for MqttService");
        }
        boolean checkTpnsSecurityLibSo = Security.checkTpnsSecurityLibSo(this);
        a.b("MqttService", "MqttService onCreate load lib: " + checkTpnsSecurityLibSo);
        this.f50057a = new MqttServiceImpl(this);
    }

    public void onDestroy() {
        a.b("MqttService", "onDestroy: ");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        super.onStartCommand(intent, i11, i12);
        return 2;
    }
}
