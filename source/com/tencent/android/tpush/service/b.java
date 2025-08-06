package com.tencent.android.tpush.service;

import android.content.Context;
import android.content.ServiceConnection;
import android.net.LocalServerSocket;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.common.AppInfos;
import com.tencent.android.tpush.common.Constants;
import com.tencent.android.tpush.common.f;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.g;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TGlobalHelper;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.mqttchannel.api.OnMqttCallback;

public class b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static Context f69594a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f69595b = "";

    /* renamed from: c  reason: collision with root package name */
    private static LocalServerSocket f69596c = null;

    /* renamed from: d  reason: collision with root package name */
    private static LocalServerSocket f69597d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static volatile boolean f69598e = false;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f69599f = false;

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f69600g = false;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static boolean f69601h = false;

    /* renamed from: i  reason: collision with root package name */
    private static ServiceConnection f69602i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f69603j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final b f69606a = new b();
    }

    public static Context e() {
        Context context = f69594a;
        if (context != null) {
            return context;
        }
        return XGPushManager.getContext();
    }

    public static ServiceConnection f() {
        return f69602i;
    }

    public static void g() {
        f69602i = null;
    }

    public static String h() {
        return f69595b;
    }

    private void k() {
        this.f69603j = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message != null) {
                    TLogger.d("PushServiceManager", "initHandler, cmd:" + message.what);
                    int i11 = message.what;
                    if (i11 == 1) {
                        TLogger.dd("PushServiceManager", "Service's running at " + b.f69594a.getPackageName() + ",version : " + "1.4.4.2");
                        if (!f.a()) {
                            TLogger.e("PushServiceManager", "permission check failed, kill service!");
                            b.this.d();
                            g.e(b.e());
                        }
                        a.a().a(b.e());
                        com.tencent.android.tpush.c.a.a().f68881b.a((OnMqttCallback) null);
                        if (!b.f69598e) {
                            TLogger.d("PushServiceManager", "pull up xg services on 8s later");
                            CommonWorkingThread.getInstance().execute(new TTask() {
                                public void TRun() {
                                    TLogger.d("PushServiceManager", "8s time's over, now pull up xg services");
                                    g.d(b.e());
                                }
                            }, 8000);
                            boolean unused = b.f69598e = true;
                        }
                    } else if (i11 == 2) {
                        com.tencent.android.tpush.c.a.a().f68881b.a((OnMqttCallback) null);
                    } else if (i11 == 3) {
                        com.tencent.android.tpush.c.a.a().f68881b.c((OnMqttCallback) null);
                    } else if (i11 != 4) {
                        TLogger.e("PushServiceManager", "unknown handler msg = " + message.what);
                    }
                }
            }
        };
    }

    public void c() {
        try {
            TLogger.d("PushServiceManager", "@@ serviceExit()");
            j.a();
            Handler handler = this.f69603j;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                this.f69603j = null;
            }
            if (CommonWorkingThread.getInstance().getHandler() != null) {
                CommonWorkingThread.getInstance().getHandler().removeCallbacksAndMessages((Object) null);
            }
            a.a().c(f69594a);
            com.tencent.android.tpush.c.a.a().f68881b.c((OnMqttCallback) null);
            d();
            g.e(e());
        } catch (Throwable th2) {
            TLogger.w("PushServiceManager", "unexpected for serviceExit:" + th2.getMessage());
        }
    }

    public void d() {
        synchronized (this) {
            LocalServerSocket localServerSocket = f69596c;
            if (localServerSocket != null) {
                try {
                    localServerSocket.close();
                    f69596c = null;
                } catch (Throwable th2) {
                    TLogger.e("PushServiceManager", ">> Destroy local socket exception", th2);
                }
            }
            f69598e = false;
        }
    }

    private b() {
        this.f69603j = null;
        f69595b = AppInfos.getCurrentPackageName(e());
    }

    public static boolean a() {
        return f69601h;
    }

    public static b b() {
        return a.f69606a;
    }

    public static void b(Context context) {
        if (context != null) {
            f69594a = context;
            TGlobalHelper.setContext(context);
            f69595b = context.getPackageName();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0090, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.content.Intent r10) {
        /*
            r9 = this;
            android.os.Handler r0 = r9.f69603j
            if (r0 != 0) goto L_0x0007
            r9.k()
        L_0x0007:
            monitor-enter(r9)
            boolean r0 = f69598e     // Catch:{ all -> 0x00aa }
            r1 = 100
            r3 = 1
            if (r0 == 0) goto L_0x0091
            if (r10 == 0) goto L_0x0078
            java.lang.String r0 = r10.getAction()     // Catch:{ all -> 0x00aa }
            java.lang.String r3 = "PushServiceManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00aa }
            r4.<init>()     // Catch:{ all -> 0x00aa }
            java.lang.String r5 = "Start Service with action "
            r4.append(r5)     // Catch:{ all -> 0x00aa }
            r4.append(r0)     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x00aa }
            com.tencent.android.tpush.logging.TLogger.v(r3, r4)     // Catch:{ all -> 0x00aa }
            if (r0 == 0) goto L_0x008f
            java.lang.String r3 = "com.tencent.android.xg.vip.action.keepalive"
            boolean r3 = r3.equals(r0)     // Catch:{ all -> 0x00aa }
            if (r3 == 0) goto L_0x005e
            android.os.Handler r0 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r3 = 2
            android.os.Message r0 = r0.obtainMessage(r3)     // Catch:{ all -> 0x00aa }
            java.lang.String r4 = "delay_time"
            r5 = 0
            long r7 = r10.getLongExtra(r4, r5)     // Catch:{ all -> 0x00aa }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 != 0) goto L_0x0053
            android.os.Handler r10 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r10.removeMessages(r3)     // Catch:{ all -> 0x00aa }
            android.os.Handler r10 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r10.sendMessageDelayed(r0, r1)     // Catch:{ all -> 0x00aa }
            goto L_0x008f
        L_0x0053:
            android.os.Handler r10 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r10.removeMessages(r3)     // Catch:{ all -> 0x00aa }
            android.os.Handler r10 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r10.sendMessageDelayed(r0, r7)     // Catch:{ all -> 0x00aa }
            goto L_0x008f
        L_0x005e:
            java.lang.String r10 = "com.tencent.android.xg.vip.action.stop_connect"
            boolean r10 = r10.equals(r0)     // Catch:{ all -> 0x00aa }
            if (r10 == 0) goto L_0x008f
            android.os.Handler r10 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r0 = 3
            android.os.Message r10 = r10.obtainMessage(r0)     // Catch:{ all -> 0x00aa }
            android.os.Handler r3 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r3.removeMessages(r0)     // Catch:{ all -> 0x00aa }
            android.os.Handler r0 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r0.sendMessageDelayed(r10, r1)     // Catch:{ all -> 0x00aa }
            goto L_0x008f
        L_0x0078:
            java.lang.String r10 = "PushServiceManager"
            java.lang.String r0 = "Start Service with null action  but intent is not null"
            com.tencent.android.tpush.logging.TLogger.v(r10, r0)     // Catch:{ all -> 0x00aa }
            android.os.Handler r10 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r10.removeMessages(r3)     // Catch:{ all -> 0x00aa }
            android.os.Handler r10 = r9.f69603j     // Catch:{ all -> 0x00aa }
            android.os.Message r10 = r10.obtainMessage(r3)     // Catch:{ all -> 0x00aa }
            android.os.Handler r0 = r9.f69603j     // Catch:{ all -> 0x00aa }
            r0.sendMessageDelayed(r10, r1)     // Catch:{ all -> 0x00aa }
        L_0x008f:
            monitor-exit(r9)     // Catch:{ all -> 0x00aa }
            return
        L_0x0091:
            monitor-exit(r9)     // Catch:{ all -> 0x00aa }
            java.lang.String r10 = "PushServiceManager"
            java.lang.String r0 = "send WHAT_SERVICE_START msg at 100ms later on serviceStartHandler"
            com.tencent.android.tpush.logging.TLogger.d(r10, r0)
            android.os.Handler r10 = r9.f69603j
            r10.removeMessages(r3)
            android.os.Handler r10 = r9.f69603j
            android.os.Message r10 = r10.obtainMessage(r3)
            android.os.Handler r0 = r9.f69603j
            r0.sendMessageDelayed(r10, r1)
            return
        L_0x00aa:
            r10 = move-exception
            monitor-exit(r9)     // Catch:{ all -> 0x00aa }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.b.a(android.content.Intent):void");
    }

    public static void a(Context context) {
        a(context, Constants.ACTION_KEEPALIVE, 0);
    }

    public static void a(Context context, long j11) {
        a(context, Constants.ACTION_KEEPALIVE, j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00bc A[Catch:{ all -> 0x00c7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c0 A[Catch:{ all -> 0x00c7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r6, java.lang.String r7, long r8) {
        /*
            java.lang.String r0 = "startService failed, libxgVipSecurity.so not found."
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "startService, action:"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = ", delay:"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "PushServiceManager"
            com.tencent.android.tpush.logging.TLogger.d(r2, r1)
            java.lang.String r1 = "start_service_by_user"
            r3 = 0
            boolean r1 = com.tencent.tpns.baseapi.base.PushPreferences.getBoolean(r6, r1, r3)
            if (r1 != 0) goto L_0x002f
            java.lang.String r6 = "startService abolish, registerPush never called by user"
            com.tencent.android.tpush.logging.TLogger.ii(r2, r6)
            return
        L_0x002f:
            boolean r1 = com.tencent.android.tpush.XGPushConfig.isUsedTpnsChannel(r6)
            if (r1 != 0) goto L_0x003b
            java.lang.String r6 = "startService abolish, not use Tpns channel service"
            com.tencent.android.tpush.logging.TLogger.ii(r2, r6)
            return
        L_0x003b:
            r1 = 0
            if (r6 == 0) goto L_0x00e5
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x008f }
            r3.<init>()     // Catch:{ all -> 0x008f }
            java.lang.Class<com.tencent.android.tpush.service.XGVipPushService> r1 = com.tencent.android.tpush.service.XGVipPushService.class
            r3.setClass(r6, r1)     // Catch:{ all -> 0x008c }
            r3.setAction(r7)     // Catch:{ all -> 0x008c }
            r4 = 0
            int r7 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r7 == 0) goto L_0x0056
            java.lang.String r7 = "delay_time"
            r3.putExtra(r7, r8)     // Catch:{ all -> 0x008c }
        L_0x0056:
            int r7 = com.tencent.android.tpush.common.j.a((android.content.Context) r6)     // Catch:{ all -> 0x008c }
            if (r7 > 0) goto L_0x0085
            r6.startService(r3)     // Catch:{ all -> 0x008c }
            boolean r7 = f69601h     // Catch:{ all -> 0x008c }
            if (r7 != 0) goto L_0x00e5
            com.tencent.android.tpush.service.b$1 r7 = new com.tencent.android.tpush.service.b$1     // Catch:{ all -> 0x008c }
            r7.<init>()     // Catch:{ all -> 0x008c }
            f69602i = r7     // Catch:{ all -> 0x008c }
            r8 = 1
            r6.bindService(r3, r7, r8)     // Catch:{ all -> 0x008c }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r7.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r8 = "bindService ret:"
            r7.append(r8)     // Catch:{ all -> 0x008c }
            boolean r8 = f69601h     // Catch:{ all -> 0x008c }
            r7.append(r8)     // Catch:{ all -> 0x008c }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008c }
            com.tencent.android.tpush.logging.TLogger.d(r2, r7)     // Catch:{ all -> 0x008c }
            goto L_0x00e5
        L_0x0085:
            com.tencent.android.tpush.logging.TLogger.e(r2, r0)     // Catch:{ all -> 0x008c }
            r6.stopService(r3)     // Catch:{ all -> 0x008c }
            goto L_0x00e5
        L_0x008c:
            r7 = move-exception
            r1 = r3
            goto L_0x0090
        L_0x008f:
            r7 = move-exception
        L_0x0090:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "startService failed, intent:"
            r8.append(r9)
            r8.append(r1)
            java.lang.String r9 = ", ex:"
            r8.append(r9)
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            com.tencent.android.tpush.logging.TLogger.e(r2, r7)
            android.content.Intent r7 = new android.content.Intent     // Catch:{ all -> 0x00ca }
            r7.<init>()     // Catch:{ all -> 0x00ca }
            java.lang.Class<com.tencent.android.tpush.service.XGVipPushService> r8 = com.tencent.android.tpush.service.XGVipPushService.class
            r7.setClass(r6, r8)     // Catch:{ all -> 0x00c7 }
            int r8 = com.tencent.android.tpush.common.j.a((android.content.Context) r6)     // Catch:{ all -> 0x00c7 }
            if (r8 > 0) goto L_0x00c0
            r6.startService(r7)     // Catch:{ all -> 0x00c7 }
            goto L_0x00e5
        L_0x00c0:
            com.tencent.android.tpush.logging.TLogger.e(r2, r0)     // Catch:{ all -> 0x00c7 }
            r6.stopService(r7)     // Catch:{ all -> 0x00c7 }
            goto L_0x00e5
        L_0x00c7:
            r6 = move-exception
            r1 = r7
            goto L_0x00cb
        L_0x00ca:
            r6 = move-exception
        L_0x00cb:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "222 startService failed, intent:"
            r7.append(r8)
            r7.append(r1)
            r7.append(r9)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.tencent.android.tpush.logging.TLogger.e(r2, r6)
        L_0x00e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.android.tpush.service.b.a(android.content.Context, java.lang.String, long):void");
    }
}
