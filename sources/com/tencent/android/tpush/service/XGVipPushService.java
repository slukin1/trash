package com.tencent.android.tpush.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.sumsub.sns.internal.core.data.source.dynamic.c;
import com.tencent.android.tpush.a;
import com.tencent.android.tpush.common.j;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.service.util.b;
import com.tencent.android.tpush.service.util.g;
import com.tencent.tpns.baseapi.XGApiConfig;
import com.tencent.tpns.baseapi.base.security.Security;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import org.json.JSONArray;

@JgClassChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.SERVICESCHECK})
public class XGVipPushService extends Service {

    /* renamed from: b  reason: collision with root package name */
    private static volatile String f69494b = null;

    /* renamed from: c  reason: collision with root package name */
    private static long f69495c = 0;

    /* renamed from: d  reason: collision with root package name */
    private static JSONArray f69496d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static long f69497e = 270000;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static Service f69498f;

    /* renamed from: a  reason: collision with root package name */
    public TTask f69499a = new TTask() {
        public void TRun() {
            CommonWorkingThread.getInstance().execute(new TTask() {
                public void TRun() {
                    TLogger.d("XGVipPushService", "--CheckMessage--interval time:" + XGVipPushService.f69497e);
                    a.c(XGVipPushService.this);
                    if (MqttConfigImpl.getKeepAliveInterval(XGVipPushService.this.getApplicationContext()) >= 285) {
                        if (DeviceInfos.isScreenOn(XGVipPushService.this.getApplicationContext())) {
                            long unused = XGVipPushService.f69497e = c.f33305t;
                        } else {
                            long unused2 = XGVipPushService.f69497e = 270000;
                        }
                        if (XGVipPushService.this.f69500g != null) {
                            XGVipPushService xGVipPushService = XGVipPushService.this;
                            if (xGVipPushService.f69499a != null) {
                                xGVipPushService.f69500g.postDelayed(XGVipPushService.this.f69499a, XGVipPushService.f69497e);
                            }
                        }
                    }
                }
            });
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public Handler f69500g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f69501h = false;

    private void d() {
        TLogger.d("XGVipPushService", "action - initCheckMessageHandler, on 60s later");
        Handler handler = new Handler();
        this.f69500g = handler;
        handler.postDelayed(this.f69499a, 60000);
    }

    public IBinder onBind(Intent intent) {
        TLogger.ii("XGVipPushService", "Service onBind()");
        if (!this.f69501h) {
            a(intent, "onBind");
            this.f69501h = true;
        }
        return com.tencent.android.tpush.c.a.a().f68880a.onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        Security.checkTpnsSecurityLibSo(this);
        f69495c = System.currentTimeMillis();
        f69498f = this;
        b.a(getApplicationContext(), true);
        d();
    }

    public void onDestroy() {
        TLogger.i("XGVipPushService", "onDestroy");
        CommonWorkingThread.getInstance().execute(new TTask() {
            public void TRun() {
                TLogger.flush();
                if (!XGApiConfig.isEnableService(XGVipPushService.f69498f)) {
                    b.b().c();
                }
            }
        });
        super.onDestroy();
    }

    public void onStart(Intent intent, int i11) {
        PushAutoTrackHelper.onServiceStart(this, intent, i11);
        TLogger.i("XGVipPushService", "Service onStart() : " + getPackageName());
        super.onStart(intent, i11);
    }

    @SuppressLint({"WrongConstant"})
    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        TLogger.ii("XGVipPushService", "Service onStartCommand() : " + getPackageName());
        super.onStartCommand(intent, i11, i12);
        a(intent, "onStartCommand");
        return 2;
    }

    public static Service a() {
        return f69498f;
    }

    private synchronized void a(Intent intent, String str) {
        JSONArray jSONArray;
        TLogger.d("XGVipPushService", "initServiceHandler with method : " + str);
        try {
            if (j.a(getApplicationContext()) > 0) {
                TLogger.ee("XGVipPushService", "initGlobal error");
                g.e(getApplicationContext());
                return;
            }
            if (intent != null) {
                if (f69496d == null) {
                    f69496d = new JSONArray();
                }
                String action = intent.getAction();
                if (!j.b(action) && (jSONArray = f69496d) != null && jSONArray.length() < 10) {
                    action = action.replace("com.tencent.android.tpush.action", "");
                    f69496d.put(action);
                }
            }
            b.a(getApplicationContext());
            b.b().a(intent);
        } catch (Throwable th2) {
            TLogger.e("XGVipPushService", "initServiceHandler", th2);
        }
        return;
    }
}
