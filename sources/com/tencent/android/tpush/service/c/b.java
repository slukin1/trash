package com.tencent.android.tpush.service.c;

import android.content.Context;
import android.os.Process;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.d;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.mqttchannel.api.MqttConnectState;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import org.json.JSONObject;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f69628a = true;

    /* renamed from: b  reason: collision with root package name */
    private static volatile boolean f69629b = true;

    /* renamed from: c  reason: collision with root package name */
    private long f69630c;

    public static class a extends OnMqttCallback {

        /* renamed from: a  reason: collision with root package name */
        private a f69642a;

        /* renamed from: b  reason: collision with root package name */
        private d f69643b;

        /* renamed from: c  reason: collision with root package name */
        private Context f69644c;

        public a(Context context, a aVar, d dVar) {
            this.f69644c = context.getApplicationContext();
            this.f69642a = aVar;
            this.f69643b = dVar;
        }

        public void callback(int i11, String str) {
            if (i11 >= 0) {
                this.f69642a.a(i11, str, this.f69643b);
            } else {
                this.f69642a.b(i11, str, this.f69643b);
            }
            b.b(this.f69644c, i11, str, this.requestId, this.f69643b);
        }
    }

    /* renamed from: com.tencent.android.tpush.service.c.b$b  reason: collision with other inner class name */
    public interface C0754b {
        void a();

        void a(int i11, String str);
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static b f69645a = new b();
    }

    public static /* synthetic */ long a(b bVar) {
        long j11 = bVar.f69630c;
        bVar.f69630c = 1 + j11;
        return j11;
    }

    private long b() {
        return (((System.currentTimeMillis() % 100000000000L) * 1000) + ((long) (Process.myPid() % 1000))) * 1000;
    }

    private b() {
        this.f69630c = b();
    }

    public static b a() {
        return c.f69645a;
    }

    public void b(final Context context, final d dVar, final a aVar) {
        a(context, new C0754b() {
            public void a() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", b.a(b.this));
                    jSONObject.put(Constants.MQTT_STATISTISC_MSGTYPE_KEY, dVar.a().getStr());
                    jSONObject.put("params", dVar.a(context));
                    try {
                        com.tencent.android.tpush.c.a.a().f68881b.a(Constants.MQTT_STATISTISC_TOPIC, jSONObject.toString(), (OnMqttCallback) new a(context, aVar, dVar));
                    } catch (Throwable th2) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.b(ErrCode.MQTT_SEND_PUB_ERROR, "sendMessage error: " + th2.getMessage(), dVar);
                        }
                    }
                } catch (Throwable th3) {
                    TLogger.ee("XGMqttChannel", "sendStatMsg throwable: ", th3);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(ErrCode.INNER_ERROR_JSON, "sendStatMsg request error", dVar);
                    }
                }
            }

            public void a(int i11, String str) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.b(i11, str, dVar);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static void b(Context context, int i11, String str, long j11, d dVar) {
        if (i11 == 0) {
            f69628a = true;
        } else if (i11 == -1103) {
            try {
                if (f69628a) {
                    f69628a = false;
                    ServiceStat.reportErrCode(context, i11, str, j11, dVar.a().getStr());
                }
            } catch (Throwable th2) {
                TLogger.e("XGMqttChannel", "handleErrCodeReport error: " + th2.getMessage());
            }
        } else {
            if (i11 != -3) {
                if (i11 != -4) {
                    if (i11 <= 1010000 || i11 >= 1011000) {
                        ServiceStat.reportErrCode(context, i11, str, j11, dVar.a().getStr());
                        return;
                    }
                    return;
                }
            }
            if (f69629b) {
                f69629b = false;
                ServiceStat.reportErrCode(context, i11, str, j11, dVar.a().getStr());
            }
        }
    }

    public void a(final Context context, final d dVar, final a aVar) {
        a(context, new C0754b() {
            public void a() {
                try {
                    try {
                        com.tencent.android.tpush.c.a.a().f68881b.a(dVar.a().getStr(), dVar.a(context), (OnMqttCallback) new a(context, aVar, dVar));
                    } catch (Throwable th2) {
                        a aVar = aVar;
                        if (aVar != null) {
                            aVar.b(ErrCode.MQTT_SEND_PUB_ERROR, "sendMessage error: " + th2.getMessage(), dVar);
                        }
                    }
                } catch (Throwable th3) {
                    TLogger.ee("XGMqttChannel", "sendMessage throwable: ", th3);
                    ServiceStat.reportErrCode(context, ErrCode.INNER_ERROR_JSON, "sendMessage request error", 0, dVar.a().getStr());
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b(ErrCode.INNER_ERROR_JSON, "sendMessage request error", dVar);
                    }
                }
            }

            public void a(int i11, String str) {
                a aVar = aVar;
                if (aVar != null) {
                    aVar.b(i11, str, dVar);
                }
                b.b(context, i11, str, 0, dVar);
            }
        });
    }

    private void a(Context context, final C0754b bVar) {
        TLogger.d("XGMqttChannel", "doActionWhenConnected");
        try {
            com.tencent.android.tpush.c.a.a().f68881b.e(new OnMqttCallback() {
                public void callback(int i11, String str) {
                    TLogger.d("XGMqttChannel", "isValidClientId code:" + i11 + ", message:" + str);
                    if (i11 == 0) {
                        bVar.a();
                    } else {
                        com.tencent.android.tpush.c.a.a().f68881b.d(new OnMqttCallback() {
                            public void callback(int i11, String str) {
                                if (!(i11 == 0 && (MqttConnectState.valueOf(str) == MqttConnectState.CONNECTED || MqttConnectState.valueOf(str) == MqttConnectState.SUBTOPICS))) {
                                    com.tencent.android.tpush.c.a.a().f68881b.a((OnMqttCallback) null);
                                }
                                bVar.a();
                            }
                        });
                    }
                }
            });
        } catch (Throwable th2) {
            bVar.a(ErrCode.MQTT_SEND_PUB_ERROR, "invoke isValidClientId error: " + th2.getMessage());
        }
    }
}
