package com.tencent.android.tpush.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.android.tpush.stat.b.c;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.dataacquisition.DeviceInfos;
import org.apache.http.HttpHost;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private static volatile b f69935a;

    /* renamed from: b  reason: collision with root package name */
    private volatile int f69936b = 2;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f69937c = "";

    /* renamed from: d  reason: collision with root package name */
    private volatile HttpHost f69938d = null;

    /* renamed from: e  reason: collision with root package name */
    private Context f69939e = null;

    /* renamed from: f  reason: collision with root package name */
    private c f69940f = null;

    private b(Context context) {
        this.f69939e = context.getApplicationContext();
        f.a(context);
        this.f69940f = com.tencent.android.tpush.stat.b.b.b();
        f();
        d();
    }

    private void f() {
        this.f69936b = 0;
        this.f69938d = null;
        this.f69937c = null;
    }

    public String a() {
        return this.f69937c;
    }

    public boolean b() {
        return this.f69936b == 1;
    }

    public boolean c() {
        return this.f69936b != 0;
    }

    public void d() {
        if (DeviceInfos.isNetworkAvailable(this.f69939e)) {
            this.f69937c = DeviceInfos.getLinkedWay(this.f69939e);
            if (d.b()) {
                c cVar = this.f69940f;
                cVar.b((Object) "NETWORK name:" + this.f69937c);
            }
            if (com.tencent.android.tpush.stat.b.b.c(this.f69937c)) {
                if ("WIFI".equalsIgnoreCase(this.f69937c)) {
                    this.f69936b = 1;
                } else {
                    this.f69936b = 2;
                }
                this.f69938d = com.tencent.android.tpush.stat.b.b.b(this.f69939e);
                return;
            }
            return;
        }
        if (d.b()) {
            this.f69940f.b((Object) "NETWORK TYPE: network is close.");
        }
        f();
    }

    @JgMethodChecked(author = 1, fComment = "确认已进行安全校验", lastDate = "20150316", reviewer = 3, vComment = {EType.RECEIVERCHECK})
    public void e() {
        try {
            AnonymousClass1 r02 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    PushAutoTrackHelper.onBroadcastReceiver(this, context, intent);
                    CommonWorkingThread.getInstance().execute(new TTask() {
                        public void TRun() {
                            b.this.d();
                        }
                    });
                }
            };
            if (Build.VERSION.SDK_INT >= 33) {
                this.f69939e.getApplicationContext().registerReceiver(r02, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"), 4);
            } else {
                this.f69939e.getApplicationContext().registerReceiver(r02, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            }
        } catch (Throwable th2) {
            TLogger.e("registerBroadcast", "", th2);
        }
    }

    public static b a(Context context) {
        if (f69935a == null) {
            synchronized (b.class) {
                if (f69935a == null) {
                    f69935a = new b(context);
                }
            }
        }
        return f69935a;
    }
}
