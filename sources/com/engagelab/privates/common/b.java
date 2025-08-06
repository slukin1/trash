package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;

public class b {

    /* renamed from: c  reason: collision with root package name */
    public static volatile b f64945c;

    /* renamed from: a  reason: collision with root package name */
    public long f64946a = 0;

    /* renamed from: b  reason: collision with root package name */
    public long f64947b = 0;

    public static b a() {
        if (f64945c == null) {
            synchronized (b.class) {
                f64945c = new b();
            }
        }
        return f64945c;
    }

    public void b(Context context) {
        if (g.a(context) && this.f64947b != 0) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f64946a = currentTimeMillis;
            if (currentTimeMillis - this.f64947b >= MTCoreGlobal.getHeartbeatInterval() / 2) {
                if (!c.a().b()) {
                    MTCommonLog.d("MTActiveBusiness", "re connect");
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.STOP_CONNECT, (Bundle) null);
                    MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, (Bundle) null);
                    return;
                }
                MTCommonLog.d("MTActiveBusiness", "re heartbeat");
                c.a().g(context);
                c.a().e(context);
            }
        }
    }

    public void a(Context context) {
        if (g.a(context)) {
            this.f64947b = System.currentTimeMillis();
        }
    }
}
