package com.bbc876219.lib.localsocket;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import java.util.ArrayList;
import java.util.List;

public class ControllerService extends Service {

    /* renamed from: f  reason: collision with root package name */
    public static String f63179f = ControllerService.class.getSimpleName();

    /* renamed from: g  reason: collision with root package name */
    public static boolean f63180g = true;

    /* renamed from: h  reason: collision with root package name */
    public static int f63181h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static volatile boolean f63182i = false;

    /* renamed from: b  reason: collision with root package name */
    public LocalSocketServer f63183b;

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f63184c = new a();

    /* renamed from: d  reason: collision with root package name */
    public List<b> f63185d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public String f63186e = "";

    public class a extends Binder {
        static {
            Class<ControllerService> cls = ControllerService.class;
        }

        public a() {
        }
    }

    public interface b {
        void a();
    }

    public void a(String str) {
        Log.e(f63179f, str);
        if (this.f63186e.length() > 0) {
            this.f63186e += "\n";
        }
        this.f63186e += str;
        c();
    }

    public final void b() {
        LocalSocketServer localSocketServer = this.f63183b;
        if (localSocketServer != null) {
            localSocketServer.c();
        }
    }

    public final void c() {
        synchronized (this.f63185d) {
            for (b a11 : this.f63185d) {
                a11.a();
            }
        }
    }

    public final void d() {
        try {
            b();
            LocalSocketServer localSocketServer = new LocalSocketServer();
            this.f63183b = localSocketServer;
            localSocketServer.b();
            this.f63183b.g(new h3.a("Channel"));
        } catch (Exception e11) {
            a("Connection failed: " + e11.toString());
        }
    }

    public final void e() {
        b();
    }

    public final void f() {
    }

    public final void g() {
        this.f63186e = "";
        c();
    }

    public final void h() {
    }

    public IBinder onBind(Intent intent) {
        if (f63180g) {
            Log.d(f63179f, "Service onBind");
        }
        return this.f63184c;
    }

    public void onCreate() {
        super.onCreate();
        if (f63180g) {
            Log.d(f63179f, "Service onCreate");
        }
        f63182i = true;
        h();
        d();
    }

    public void onDestroy() {
        if (f63180g) {
            Log.d(f63179f, "Service onDestroy");
        }
        f63182i = false;
        f();
        g();
        e();
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i11, int i12) {
        PushAutoTrackHelper.onServiceStartCommand(this, intent, i11, i12);
        if (!f63180g) {
            return 1;
        }
        Log.d(f63179f, "Service onStartCommand");
        return 1;
    }
}
