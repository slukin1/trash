package com.engagelab.privates.common;

import android.content.Context;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.component.MTCommonReceiver;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.core.api.MTProtocol;
import com.engagelab.privates.core.constants.MTCoreConstants;
import com.engagelab.privates.core.global.MTCoreGlobal;
import java.nio.ByteBuffer;

public class c {

    /* renamed from: d  reason: collision with root package name */
    public static volatile c f64948d;

    /* renamed from: a  reason: collision with root package name */
    public final e f64949a = new e();

    /* renamed from: b  reason: collision with root package name */
    public final d f64950b = new d();

    /* renamed from: c  reason: collision with root package name */
    public int f64951c = 0;

    public static c a() {
        if (f64948d == null) {
            synchronized (c.class) {
                f64948d = new c();
            }
        }
        return f64948d;
    }

    public void b(Context context, Bundle bundle) {
        this.f64950b.a(context, bundle);
    }

    public void c(Context context) {
        MTCommonReceiver commonReceiver = MTGlobal.getCommonReceiver(context);
        if (commonReceiver != null) {
            commonReceiver.onConnectStatus(context, false);
        }
    }

    public void d(Context context) {
        if (!g.a(context)) {
            MTCommonLog.w("MTConnectBusiness", "connect state is false, can't startConnect");
            return;
        }
        MTCommonLog.d("MTConnectBusiness", "startConnect");
        this.f64949a.c(context);
        this.f64950b.g(context);
    }

    public void e(Context context) {
        MTCommonLog.d("MTConnectBusiness", "startHeartbeat");
        MTCommonPrivatesApi.sendMessageDelayed(context, "ENGAGELAB-PRIVATES-CORE", MTCoreConstants.RemoteWhat.START_HEARTBEAT, (Bundle) null, MTCoreGlobal.getHeartbeatInterval());
        MTProtocol threadName = new MTProtocol().setCommand(2).setVersion(4).setBody(h.c(context)).setThreadName("ENGAGELAB-PRIVATES-CORE");
        Bundle bundle = new Bundle();
        bundle.putParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL, threadName);
        b(context, bundle);
    }

    public void f(Context context) {
        MTCommonLog.d("MTConnectBusiness", "stopConnect");
        this.f64949a.d(context);
        this.f64950b.h(context);
    }

    public void g(Context context) {
        MTCommonLog.d("MTConnectBusiness", "stopHeartbeat");
        MTCommonPrivatesApi.removeMessages(context, "ENGAGELAB-PRIVATES-CORE", MTCoreConstants.RemoteWhat.START_HEARTBEAT);
    }

    public void h(Context context) {
        MTCommonLog.d("MTConnectBusiness", "turnOffConnect");
        g.a(context, false);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.STOP_CONNECT, (Bundle) null);
    }

    public void i(Context context) {
        MTCommonLog.d("MTConnectBusiness", "turnOnConnect");
        g.a(context, true);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, (Bundle) null);
    }

    public void b(Context context) {
        MTCommonReceiver commonReceiver = MTGlobal.getCommonReceiver(context);
        if (commonReceiver != null) {
            commonReceiver.onConnectStatus(context, true);
        }
    }

    public boolean b() {
        return this.f64950b.a();
    }

    public void a(Context context, Bundle bundle) {
        ByteBuffer wrap = ByteBuffer.wrap(((MTProtocol) bundle.getParcelable(MTCoreConstants.Protocol.KEY_PROTOCOL)).getBody());
        byte b11 = wrap.get();
        byte b12 = wrap.get();
        byte b13 = wrap.get();
        long j11 = wrap.getLong();
        MTCommonLog.d("MTConnectBusiness", "onAckSuccess command:" + b11 + ", result:" + b12 + ", code:" + b13 + ", serverTime:" + j11);
        if (b11 == 2) {
            MTCommonLog.i("MTConnectBusiness", "onHeartbeatSuccess");
            this.f64951c = 0;
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, 2003, (Bundle) null);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.ON_HEARTBEAT, (Bundle) null);
            MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.REPORT, (Bundle) null);
        }
    }

    public void a(Context context) {
        this.f64951c++;
        MTCommonLog.d("MTConnectBusiness", "onAckFailed :" + this.f64951c);
        if (this.f64951c < 5) {
            g(context);
            e(context);
            return;
        }
        this.f64951c = 0;
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.STOP_CONNECT, (Bundle) null);
        MTCommonPrivatesApi.sendMessageToRemoteProcess(context, MTCoreConstants.RemoteWhat.START_CONNECT, (Bundle) null);
    }
}
