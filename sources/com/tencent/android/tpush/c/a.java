package com.tencent.android.tpush.c;

import android.content.Context;
import android.os.RemoteException;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.protocol.k;
import com.tencent.android.tpush.service.util.g;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.ErrCode;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;
import com.tencent.tpns.mqttchannel.core.services.MqttServiceImpl;
import com.tencent.tpns.mqttchannel.services.BaseMqttClientService;
import org.json.JSONException;

public class a {
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static Context f68879c;

    /* renamed from: a  reason: collision with root package name */
    public c f68880a;

    /* renamed from: b  reason: collision with root package name */
    public C0740a f68881b;

    /* renamed from: com.tencent.android.tpush.c.a$a  reason: collision with other inner class name */
    public static class C0740a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public MqttServiceImpl f68882a;

        /* renamed from: b  reason: collision with root package name */
        private volatile long f68883b;

        public C0740a(BaseMqttClientService baseMqttClientService) {
            if (baseMqttClientService != null) {
                if (a.f68879c == null) {
                    Context unused = a.f68879c = AppInfos.getAppContext();
                }
                this.f68882a = new MqttServiceImpl(a.f68879c, baseMqttClientService);
                return;
            }
            TLogger.w("IMqttClientManager - OperatorImpl", "#unexception, baseMqttClientService was null");
            throw new Exception("#unexception, baseMqttClientService was null");
        }

        public void b(OnMqttCallback onMqttCallback) {
            try {
                this.f68882a.getIMqttService().ping(onMqttCallback);
            } catch (RemoteException e11) {
                TLogger.e("IMqttClientManager", "", e11);
            }
        }

        public void c(final OnMqttCallback onMqttCallback) {
            try {
                CommonWorkingThread.getInstance().execute(new TTask() {
                    public void TRun() {
                        try {
                            C0740a.this.f68882a.getIMqttService().stopConnect(onMqttCallback);
                        } catch (Throwable th2) {
                            TLogger.e("IMqttClientManager", "", th2);
                        }
                    }
                });
            } catch (Throwable th2) {
                TLogger.e("IMqttClientManager", "", th2);
            }
        }

        public void d(OnMqttCallback onMqttCallback) {
            try {
                this.f68882a.getIMqttService().getConnectState(onMqttCallback);
            } catch (RemoteException e11) {
                TLogger.e("IMqttClientManager", "", e11);
            }
        }

        public void e(OnMqttCallback onMqttCallback) {
            try {
                this.f68882a.getIMqttService().isValidClientId(onMqttCallback);
            } catch (RemoteException e11) {
                TLogger.e("IMqttClientManager", "", e11);
                onMqttCallback.callback(-1, "" + e11.getMessage());
            }
        }

        public void a(OnMqttCallback onMqttCallback) {
            try {
                this.f68882a.getIMqttService().startConnect(onMqttCallback);
            } catch (RemoteException e11) {
                TLogger.e("IMqttClientManager", "", e11);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            com.tencent.android.tpush.logging.TLogger.e("IMqttClientManager", "", r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0035, code lost:
            com.tencent.android.tpush.logging.TLogger.e("IMqttClientManager", "", r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x002f, code lost:
            r7 = move-exception;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x000c, B:7:0x0025] */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.String r7, org.json.JSONObject r8, com.tencent.tpns.mqttchannel.api.OnMqttCallback r9) {
            /*
                r6 = this;
                java.lang.String r0 = ""
                java.lang.String r1 = "IMqttClientManager"
                if (r8 != 0) goto L_0x0010
                if (r9 == 0) goto L_0x000f
                r7 = -101(0xffffffffffffff9b, float:NaN)
                java.lang.String r8 = "sendRequest jsonParm not alow to null"
                r9.handleCallback(r7, r8)     // Catch:{ all -> 0x0034 }
            L_0x000f:
                return
            L_0x0010:
                long r2 = r6.f68883b     // Catch:{ all -> 0x0034 }
                r4 = 1
                long r2 = r2 + r4
                r6.f68883b = r2     // Catch:{ all -> 0x0034 }
                r9.requestId = r2     // Catch:{ all -> 0x0034 }
                com.tencent.tpns.mqttchannel.core.common.data.Request r4 = new com.tencent.tpns.mqttchannel.core.common.data.Request     // Catch:{ all -> 0x0034 }
                java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0034 }
                r4.<init>(r2, r7, r8)     // Catch:{ all -> 0x0034 }
                r7 = 6
                r4.type = r7     // Catch:{ all -> 0x0034 }
                com.tencent.tpns.mqttchannel.core.services.MqttServiceImpl r7 = r6.f68882a     // Catch:{ RemoteException -> 0x002f }
                com.tencent.tpns.mqttchannel.core.common.inf.IMqttService$Stub r7 = r7.getIMqttService()     // Catch:{ RemoteException -> 0x002f }
                r7.sendRequest(r4, r9)     // Catch:{ RemoteException -> 0x002f }
                goto L_0x0038
            L_0x002f:
                r7 = move-exception
                com.tencent.android.tpush.logging.TLogger.e(r1, r0, r7)     // Catch:{ all -> 0x0034 }
                goto L_0x0038
            L_0x0034:
                r7 = move-exception
                com.tencent.android.tpush.logging.TLogger.e(r1, r0, r7)
            L_0x0038:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.c.a.C0740a.a(java.lang.String, org.json.JSONObject, com.tencent.tpns.mqttchannel.api.OnMqttCallback):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            com.tencent.android.tpush.logging.TLogger.e("IMqttClientManager", "", r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
            com.tencent.android.tpush.logging.TLogger.e("IMqttClientManager", "", r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [B:4:0x000c, B:7:0x001f] */
        /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(java.lang.String r8, java.lang.String r9, com.tencent.tpns.mqttchannel.api.OnMqttCallback r10) {
            /*
                r7 = this;
                java.lang.String r0 = ""
                java.lang.String r1 = "IMqttClientManager"
                if (r9 != 0) goto L_0x0010
                if (r10 == 0) goto L_0x000f
                r8 = -101(0xffffffffffffff9b, float:NaN)
                java.lang.String r9 = "sendPublishData content not alow to null"
                r10.handleCallback(r8, r9)     // Catch:{ all -> 0x002e }
            L_0x000f:
                return
            L_0x0010:
                com.tencent.tpns.mqttchannel.core.common.data.Request r2 = new com.tencent.tpns.mqttchannel.core.common.data.Request     // Catch:{ all -> 0x002e }
                long r3 = r7.f68883b     // Catch:{ all -> 0x002e }
                r5 = 1
                long r3 = r3 + r5
                r7.f68883b = r3     // Catch:{ all -> 0x002e }
                r2.<init>(r3, r8, r9)     // Catch:{ all -> 0x002e }
                r8 = 5
                r2.type = r8     // Catch:{ all -> 0x002e }
                com.tencent.tpns.mqttchannel.core.services.MqttServiceImpl r8 = r7.f68882a     // Catch:{ RemoteException -> 0x0029 }
                com.tencent.tpns.mqttchannel.core.common.inf.IMqttService$Stub r8 = r8.getIMqttService()     // Catch:{ RemoteException -> 0x0029 }
                r8.sendPublishData(r2, r10)     // Catch:{ RemoteException -> 0x0029 }
                goto L_0x0032
            L_0x0029:
                r8 = move-exception
                com.tencent.android.tpush.logging.TLogger.e(r1, r0, r8)     // Catch:{ all -> 0x002e }
                goto L_0x0032
            L_0x002e:
                r8 = move-exception
                com.tencent.android.tpush.logging.TLogger.e(r1, r0, r8)
            L_0x0032:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.c.a.C0740a.a(java.lang.String, java.lang.String, com.tencent.tpns.mqttchannel.api.OnMqttCallback):void");
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f68886a = new a();
    }

    public static class c extends BaseMqttClientService {

        /* renamed from: a  reason: collision with root package name */
        private com.tencent.android.tpush.service.channel.a f68887a;

        public void onConnectComplete(boolean z11) {
            TLogger.ii("IMqttClientManager - StateImpl", "onConnectComplete isReconnect:" + z11);
        }

        public void onConnectionLost() {
            TLogger.ii("IMqttClientManager - StateImpl", "onConnectionLost");
        }

        public void onHeartBeat() {
            TLogger.ii("IMqttClientManager - StateImpl", "heartBeat");
            if (a.f68879c == null) {
                Context unused = a.f68879c = AppInfos.getAppContext();
            }
            com.tencent.android.tpush.a.b(a.f68879c);
            g.d(a.f68879c);
        }

        public void onMessageArrived(String str, String str2) {
            TLogger.ii("IMqttClientManager - StateImpl", "onMessageArrived: topic:" + str + ", message:" + str2);
            if (a.f68879c == null) {
                Context unused = a.f68879c = AppInfos.getAppContext();
            }
            if (j.b(a.f68879c, str)) {
                try {
                    k kVar = new k();
                    kVar.a(str2);
                    com.tencent.android.tpush.service.b.a.a().a(kVar.f69767b, kVar.f69766a, this.f68887a);
                } catch (JSONException e11) {
                    TLogger.ee("IMqttClientManager - StateImpl", "decode push msg fail", e11);
                    Context b11 = a.f68879c;
                    ServiceStat.reportErrCode(b11, ErrCode.INNER_ERROR_JSON, "onMessageArrived:" + str2, 0, ErrCode.ERROR_INNER_TYPE);
                }
            }
        }

        private c() {
            this.f68887a = new com.tencent.android.tpush.service.channel.a();
        }
    }

    private a() {
        try {
            f68879c = AppInfos.getAppContext();
            c cVar = new c();
            this.f68880a = cVar;
            this.f68881b = new C0740a(cVar);
        } catch (Throwable th2) {
            TLogger.w("IMqttClientManager", "init IMqttClientManager failed， reason:" + th2);
        }
    }

    public static a a() {
        return b.f68886a;
    }
}
