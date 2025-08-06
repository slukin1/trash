package com.tencent.tpns.mqttchannel.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Process;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import com.tencent.tpns.mqttchannel.api.IMqttChannel;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.common.data.Request;
import com.tencent.tpns.mqttchannel.core.common.inf.IMqttService;
import com.tencent.tpns.mqttchannel.services.MqttService;
import org.json.JSONObject;

public class c implements IMqttChannel {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f49930a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Intent f49931b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f49932c = Boolean.FALSE;

    /* renamed from: d  reason: collision with root package name */
    private volatile long f49933d = a();

    /* renamed from: e  reason: collision with root package name */
    private ServiceConnection f49934e = null;

    public interface a {
        void a(IMqttService iMqttService);
    }

    public c(Context context) {
        this.f49930a = context.getApplicationContext();
        this.f49931b = new Intent(this.f49930a, MqttService.class);
    }

    public void bindAccount(String str, OnMqttCallback onMqttCallback) {
    }

    public void getConnectState(final OnMqttCallback onMqttCallback) {
        a(new a() {
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.getConnectState(onMqttCallback);
                }
            }
        }, "getConnectState", onMqttCallback);
    }

    public void ping(final OnMqttCallback onMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "action - ping");
        try {
            this.f49930a.startService(this.f49931b);
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + th2);
            Util.stopWakeCpu();
        }
        if (!this.f49932c.booleanValue()) {
            try {
                AnonymousClass6 r12 = new ServiceConnection() {
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
                this.f49934e = r12;
                this.f49932c = Boolean.valueOf(this.f49930a.bindService(this.f49931b, r12, 1));
            } catch (Throwable th3) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + th3);
                Util.stopWakeCpu();
            }
        }
        a(new a() {
            public void a(IMqttService iMqttService) {
                com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "ping doConnect action");
                if (iMqttService != null) {
                    iMqttService.ping(onMqttCallback);
                } else {
                    Util.stopWakeCpu();
                }
            }
        }, "ping", onMqttCallback);
    }

    public void sendPublishData(String str, String str2, final OnMqttCallback onMqttCallback) {
        if (str2 != null) {
            long j11 = this.f49933d + 1;
            this.f49933d = j11;
            final Request request = new Request(j11, str, str2);
            request.type = 5;
            a(new a() {
                public void a(IMqttService iMqttService) {
                    if (iMqttService != null) {
                        iMqttService.sendPublishData(request, onMqttCallback);
                    }
                }
            }, "sendPublishData", onMqttCallback);
        } else if (onMqttCallback != null) {
            onMqttCallback.handleCallback(ErrCode.INNER_ERROR_JSON, "sendPublishData content not alow to null");
        }
    }

    public void sendRequest(String str, JSONObject jSONObject, final OnMqttCallback onMqttCallback) {
        if (jSONObject != null) {
            long j11 = this.f49933d + 1;
            this.f49933d = j11;
            onMqttCallback.requestId = j11;
            final Request request = new Request(j11, str, jSONObject.toString());
            request.type = 6;
            a(new a() {
                public void a(IMqttService iMqttService) {
                    if (iMqttService != null) {
                        iMqttService.sendRequest(request, onMqttCallback);
                    }
                }
            }, "sendRequest", onMqttCallback);
        } else if (onMqttCallback != null) {
            onMqttCallback.handleCallback(ErrCode.INNER_ERROR_JSON, "sendRequest jsonParm not alow to null");
        }
    }

    public void startConnect(final OnMqttCallback onMqttCallback) {
        try {
            com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "action - startConnect, start MqttService");
            this.f49930a.startService(this.f49931b);
        } catch (Throwable th2) {
            com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel startService failed, ex:" + th2);
        }
        if (!this.f49932c.booleanValue()) {
            try {
                AnonymousClass4 r12 = new ServiceConnection() {
                    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    }

                    public void onServiceDisconnected(ComponentName componentName) {
                    }
                };
                this.f49934e = r12;
                this.f49932c = Boolean.valueOf(this.f49930a.bindService(this.f49931b, r12, 1));
            } catch (Throwable th3) {
                com.tencent.tpns.mqttchannel.core.common.a.a.e("MqttChannelImpl", "MqttChannel bindService failed, ex:" + th3);
            }
        }
        a(new a() {
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "doConnect action on startConnect");
                    iMqttService.startConnect(onMqttCallback);
                }
            }
        }, "startConnect", onMqttCallback);
    }

    public void stopConnect(final OnMqttCallback onMqttCallback) {
        a(new a() {
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.stopConnect(onMqttCallback);
                }
            }
        }, "stopConnect", onMqttCallback);
    }

    public void subscrbie(String str, final OnMqttCallback onMqttCallback) {
        long j11 = this.f49933d + 1;
        this.f49933d = j11;
        final Request request = new Request(j11, str, (String) null);
        request.type = 1;
        a(new a() {
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.subscrbie(request, onMqttCallback);
                }
            }
        }, "subscrbie", onMqttCallback);
    }

    public void unBindAccount(OnMqttCallback onMqttCallback) {
    }

    public void unSubscrbie(String str, final OnMqttCallback onMqttCallback) {
        long j11 = this.f49933d + 1;
        this.f49933d = j11;
        final Request request = new Request(j11, str, (String) null);
        request.type = 3;
        a(new a() {
            public void a(IMqttService iMqttService) {
                if (iMqttService != null) {
                    iMqttService.unSubscrbie(request, onMqttCallback);
                }
            }
        }, "unSubscrbie", onMqttCallback);
    }

    private long a() {
        return (((System.currentTimeMillis() % 100000000000L) * 1000) + ((long) (Process.myPid() % 1000))) * 1000;
    }

    private void a(final a aVar, final String str, final OnMqttCallback onMqttCallback) {
        com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "action - doConnect, actionName:" + str);
        CommonWorkingThread.getInstance().execute(new TTask() {

            /* renamed from: a  reason: collision with root package name */
            public IMqttService f49935a = null;
            /* access modifiers changed from: private */

            /* renamed from: f  reason: collision with root package name */
            public ServiceConnection f49940f = new ServiceConnection() {
                /* JADX WARNING: Unknown top exception splitter block from list: {B:5:0x0021=Splitter:B:5:0x0021, B:13:0x0068=Splitter:B:13:0x0068} */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onServiceConnected(android.content.ComponentName r4, android.os.IBinder r5) {
                    /*
                        r3 = this;
                        java.lang.String r4 = "MqttChannelImpl"
                        java.lang.String r0 = "doConnect - onServiceConnected"
                        com.tencent.tpns.mqttchannel.core.common.a.a.a(r4, r0)
                        com.tencent.tpns.mqttchannel.core.a.c$1 r0 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this
                        com.tencent.tpns.mqttchannel.core.common.inf.IMqttService r5 = com.tencent.tpns.mqttchannel.core.common.inf.IMqttService.Stub.a(r5)
                        r0.f49935a = r5
                        com.tencent.tpns.mqttchannel.core.a.c$1 r5 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this     // Catch:{ all -> 0x002d }
                        com.tencent.tpns.mqttchannel.core.common.inf.IMqttService r5 = r5.f49935a     // Catch:{ all -> 0x002d }
                        if (r5 == 0) goto L_0x0021
                        com.tencent.tpns.baseapi.base.util.CommonWorkingThread r5 = com.tencent.tpns.baseapi.base.util.CommonWorkingThread.getInstance()     // Catch:{ all -> 0x002d }
                        com.tencent.tpns.mqttchannel.core.a.c$1$1$1 r0 = new com.tencent.tpns.mqttchannel.core.a.c$1$1$1     // Catch:{ all -> 0x002d }
                        r0.<init>()     // Catch:{ all -> 0x002d }
                        r5.execute(r0)     // Catch:{ all -> 0x002d }
                    L_0x0021:
                        com.tencent.tpns.mqttchannel.core.a.c$1 r4 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this     // Catch:{ all -> 0x006d }
                        com.tencent.tpns.mqttchannel.core.a.c r4 = com.tencent.tpns.mqttchannel.core.a.c.this     // Catch:{ all -> 0x006d }
                    L_0x0025:
                        android.content.Context r4 = r4.f49930a     // Catch:{ all -> 0x006d }
                        r4.unbindService(r3)     // Catch:{ all -> 0x006d }
                        goto L_0x006d
                    L_0x002d:
                        r5 = move-exception
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
                        r0.<init>()     // Catch:{ all -> 0x006e }
                        com.tencent.tpns.mqttchannel.core.a.c$1 r1 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this     // Catch:{ all -> 0x006e }
                        java.lang.String r1 = r4     // Catch:{ all -> 0x006e }
                        r0.append(r1)     // Catch:{ all -> 0x006e }
                        java.lang.String r1 = " error:"
                        r0.append(r1)     // Catch:{ all -> 0x006e }
                        java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006e }
                        com.tencent.tpns.mqttchannel.core.common.a.a.a(r4, r0, r5)     // Catch:{ all -> 0x006e }
                        com.tencent.tpns.mqttchannel.core.a.c$1 r4 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this     // Catch:{ all -> 0x006e }
                        com.tencent.tpns.mqttchannel.api.OnMqttCallback r4 = r5     // Catch:{ all -> 0x006e }
                        if (r4 == 0) goto L_0x0068
                        r0 = -1
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x006e }
                        r1.<init>()     // Catch:{ all -> 0x006e }
                        com.tencent.tpns.mqttchannel.core.a.c$1 r2 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this     // Catch:{ all -> 0x006e }
                        java.lang.String r2 = r4     // Catch:{ all -> 0x006e }
                        r1.append(r2)     // Catch:{ all -> 0x006e }
                        java.lang.String r2 = "onServiceConnected Error: "
                        r1.append(r2)     // Catch:{ all -> 0x006e }
                        r1.append(r5)     // Catch:{ all -> 0x006e }
                        java.lang.String r5 = r1.toString()     // Catch:{ all -> 0x006e }
                        r4.handleCallback(r0, r5)     // Catch:{ all -> 0x006e }
                    L_0x0068:
                        com.tencent.tpns.mqttchannel.core.a.c$1 r4 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this     // Catch:{ all -> 0x006d }
                        com.tencent.tpns.mqttchannel.core.a.c r4 = com.tencent.tpns.mqttchannel.core.a.c.this     // Catch:{ all -> 0x006d }
                        goto L_0x0025
                    L_0x006d:
                        return
                    L_0x006e:
                        r4 = move-exception
                        com.tencent.tpns.mqttchannel.core.a.c$1 r5 = com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.this     // Catch:{ all -> 0x007a }
                        com.tencent.tpns.mqttchannel.core.a.c r5 = com.tencent.tpns.mqttchannel.core.a.c.this     // Catch:{ all -> 0x007a }
                        android.content.Context r5 = r5.f49930a     // Catch:{ all -> 0x007a }
                        r5.unbindService(r3)     // Catch:{ all -> 0x007a }
                    L_0x007a:
                        throw r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.tencent.tpns.mqttchannel.core.a.c.AnonymousClass1.AnonymousClass1.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    AnonymousClass1 r22 = AnonymousClass1.this;
                    r22.f49935a = null;
                    ServiceConnection unused = r22.f49940f = null;
                }
            };

            public void TRun() {
                try {
                    boolean bindService = c.this.f49930a.bindService(c.this.f49931b, this.f49940f, 1);
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", "actionName:" + str + " bind MqttService:" + bindService);
                } catch (Throwable th2) {
                    com.tencent.tpns.mqttchannel.core.common.a.a.a("MqttChannelImpl", str + " -> bindService", th2);
                    OnMqttCallback onMqttCallback = onMqttCallback;
                    if (onMqttCallback != null) {
                        onMqttCallback.handleCallback(-1, str + " error: bindService Error: " + th2);
                    }
                }
            }
        });
    }
}
