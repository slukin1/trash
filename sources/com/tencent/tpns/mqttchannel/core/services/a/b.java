package com.tencent.tpns.mqttchannel.core.services.a;

import android.os.SystemClock;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttCallback;
import com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl;

public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private volatile a f50051a;

    /* renamed from: b  reason: collision with root package name */
    private IMqttServiceImpl f50052b;

    /* renamed from: c  reason: collision with root package name */
    private Object f50053c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private Object f50054d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private Object f50055e = new Object();

    public b(IMqttServiceImpl iMqttServiceImpl) {
        setName("TMQTT_INIT");
        this.f50052b = iMqttServiceImpl;
    }

    private void c() {
        try {
            synchronized (this.f50053c) {
                this.f50053c.notifyAll();
            }
        } catch (Throwable th2) {
            Logger.e("MqttConnectTrigger", "runConnection connectLock.notifyAll failed:" + th2);
        }
    }

    private a d() {
        if (this.f50051a != null) {
            return this.f50051a;
        }
        return null;
    }

    public void a(IMqttCallback iMqttCallback) {
        try {
            a aVar = new a();
            aVar.f50050c = iMqttCallback;
            aVar.f50048a = 1;
            aVar.f50049b = SystemClock.elapsedRealtimeNanos();
            a(aVar);
            c();
        } catch (Throwable th2) {
            Logger.d("MqttConnectTrigger", "action - triggerConnect failed:" + th2);
        }
    }

    public void b(IMqttCallback iMqttCallback) {
        try {
            a aVar = new a();
            aVar.f50048a = 2;
            aVar.f50049b = SystemClock.elapsedRealtimeNanos();
            a(aVar);
            c();
        } catch (Throwable th2) {
            Logger.d("MqttConnectTrigger", "action - triggerDisConnect failed:" + th2);
        }
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0073 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            super.run()
        L_0x0003:
            com.tencent.tpns.mqttchannel.core.services.a.a r0 = r5.d()     // Catch:{ all -> 0x0078 }
        L_0x0007:
            if (r0 == 0) goto L_0x008f
            java.lang.String r1 = "MqttConnectTrigger"
            java.lang.String r2 = "run mqtt action node..."
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r2)     // Catch:{ all -> 0x0078 }
            int r1 = r0.f50048a     // Catch:{ all -> 0x0078 }
            r2 = 1
            if (r1 != r2) goto L_0x001c
            com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl r1 = r5.f50052b     // Catch:{ all -> 0x0078 }
            boolean r1 = r1.a((com.tencent.tpns.mqttchannel.core.services.a.a) r0)     // Catch:{ all -> 0x0078 }
            goto L_0x0022
        L_0x001c:
            com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl r1 = r5.f50052b     // Catch:{ all -> 0x0078 }
            boolean r1 = r1.b((com.tencent.tpns.mqttchannel.core.services.a.a) r0)     // Catch:{ all -> 0x0078 }
        L_0x0022:
            if (r1 == 0) goto L_0x005d
            int r1 = r0.f50048a     // Catch:{ all -> 0x0078 }
            if (r1 != r2) goto L_0x0030
            java.lang.String r1 = "MqttConnectTrigger"
            java.lang.String r3 = "waiting execute connect complete..."
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r3)     // Catch:{ all -> 0x0078 }
            goto L_0x0037
        L_0x0030:
            java.lang.String r1 = "MqttConnectTrigger"
            java.lang.String r3 = "waiting execute disconnect complete..."
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r3)     // Catch:{ all -> 0x0078 }
        L_0x0037:
            r3 = -1
            r5.b((long) r3)     // Catch:{ all -> 0x0078 }
            int r1 = r0.f50048a     // Catch:{ all -> 0x0078 }
            if (r1 != r2) goto L_0x0064
            com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl r1 = r5.f50052b     // Catch:{ all -> 0x0078 }
            boolean r1 = r1.c()     // Catch:{ all -> 0x0078 }
            if (r1 == 0) goto L_0x0064
            java.lang.String r1 = "MqttConnectTrigger"
            java.lang.String r2 = ""
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r2)     // Catch:{ all -> 0x0078 }
            com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl r1 = r5.f50052b     // Catch:{ all -> 0x0078 }
            r2 = 0
            r1.a((boolean) r2)     // Catch:{ all -> 0x0078 }
            com.tencent.tpns.mqttchannel.core.services.IMqttServiceImpl r1 = r5.f50052b     // Catch:{ all -> 0x0078 }
            com.tencent.tpns.mqttchannel.api.MqttConnectState r2 = com.tencent.tpns.mqttchannel.api.MqttConnectState.UNKOWN     // Catch:{ all -> 0x0078 }
            r1.a((com.tencent.tpns.mqttchannel.api.MqttConnectState) r2)     // Catch:{ all -> 0x0078 }
            goto L_0x0064
        L_0x005d:
            java.lang.String r1 = "MqttConnectTrigger"
            java.lang.String r2 = "execute complete,do not wait"
            com.tencent.tpns.baseapi.base.util.Logger.d(r1, r2)     // Catch:{ all -> 0x0078 }
        L_0x0064:
            r5.b((com.tencent.tpns.mqttchannel.core.services.a.a) r0)     // Catch:{ all -> 0x0078 }
            java.lang.String r0 = "MqttConnectTrigger"
            java.lang.String r1 = "run mqtt action node end..."
            com.tencent.tpns.baseapi.base.util.Logger.d(r0, r1)     // Catch:{ all -> 0x0078 }
            r0 = 200(0xc8, double:9.9E-322)
            java.lang.Thread.sleep(r0)     // Catch:{ all -> 0x0073 }
        L_0x0073:
            com.tencent.tpns.mqttchannel.core.services.a.a r0 = r5.d()     // Catch:{ all -> 0x0078 }
            goto L_0x0007
        L_0x0078:
            r0 = move-exception
            java.lang.String r1 = "MqttConnectTrigger"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "conect failed:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.tencent.tpns.baseapi.base.util.Logger.w(r1, r0)
        L_0x008f:
            java.lang.String r0 = "MqttConnectTrigger"
            java.lang.String r1 = "connectLock wait..."
            com.tencent.tpns.baseapi.base.util.Logger.d(r0, r1)     // Catch:{ all -> 0x00a4 }
            java.lang.Object r0 = r5.f50053c     // Catch:{ all -> 0x00a4 }
            monitor-enter(r0)     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r5.f50053c     // Catch:{ all -> 0x00a1 }
            r1.wait()     // Catch:{ all -> 0x00a1 }
            monitor-exit(r0)     // Catch:{ all -> 0x00a1 }
            goto L_0x0003
        L_0x00a1:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00a1 }
            throw r1     // Catch:{ all -> 0x00a4 }
        L_0x00a4:
            r0 = move-exception
            java.lang.String r1 = "MqttConnectTrigger"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "connectLock.wait() failed:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.tencent.tpns.baseapi.base.util.Logger.e(r1, r0)
            goto L_0x0003
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.mqttchannel.core.services.a.b.run():void");
    }

    private void b(a aVar) {
        if (aVar == null) {
            Logger.d("MqttConnectTrigger", "action - updatelastMqttActionNode , mqttActionNode was null");
        }
        if (this.f50051a != null && aVar != null && this.f50051a.f50049b == aVar.f50049b) {
            this.f50051a = null;
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            Logger.d("MqttConnectTrigger", "action - updatelastMqttActionNode , mqttActionNode was null");
        }
        if (this.f50051a == null) {
            Logger.d("MqttConnectTrigger", "updatelastMqttActionNode nextMqttActionNode was null");
            this.f50051a = aVar;
        } else if (this.f50051a.f50049b < aVar.f50049b) {
            this.f50051a = aVar;
        }
    }

    private void b(long j11) {
        if (j11 <= 0) {
            j11 = SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
        }
        try {
            synchronized (this.f50054d) {
                this.f50054d.wait(j11);
            }
        } catch (Throwable th2) {
            Logger.e("MqttConnectTrigger", "waitExecuteActionComplete executeLock.wait failed:" + th2);
        }
    }

    public void a() {
        try {
            synchronized (this.f50054d) {
                this.f50054d.notifyAll();
            }
        } catch (Throwable th2) {
            Logger.e("MqttConnectTrigger", "notifyExecuteActionComplete executeLock.notifyAll failed:" + th2);
        }
    }

    public void b() {
        try {
            synchronized (this.f50055e) {
                this.f50055e.notifyAll();
            }
        } catch (Throwable th2) {
            Logger.e("MqttConnectTrigger", "notifyExecuteActionComplete executeLock.notifyAll failed:" + th2);
        }
    }

    public void a(long j11) {
        if (j11 <= 0) {
            j11 = 10000;
        }
        try {
            synchronized (this.f50054d) {
                this.f50054d.wait(j11);
            }
        } catch (Throwable th2) {
            Logger.e("MqttConnectTrigger", "waitExecuteActionComplete executeLock.wait failed:" + th2);
        }
    }
}
