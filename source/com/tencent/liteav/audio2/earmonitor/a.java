package com.tencent.liteav.audio2.earmonitor;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.liteav.audio2.earmonitor.b.a.c;
import com.tencent.liteav.audio2.earmonitor.b.a.d;
import com.tencent.liteav.audio2.earmonitor.b.a.e;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.g;
import com.tencent.liteav.base.util.w;
import java.util.concurrent.TimeUnit;

public final class a extends SystemEarMonitoring implements e, w.a {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21333a = ((int) TimeUnit.SECONDS.toMillis(1));

    /* renamed from: b  reason: collision with root package name */
    private final Context f21334b;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f21335c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private d f21336d;

    /* renamed from: e  reason: collision with root package name */
    private c f21337e;

    /* renamed from: f  reason: collision with root package name */
    private w f21338f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f21339g = false;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21340h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21341i = false;

    public a(long j11, Context context) {
        super(j11);
        this.f21334b = context.getApplicationContext();
    }

    public static /* synthetic */ void b(a aVar, int i11) {
        if (aVar.f21337e != null) {
            if (aVar.f21337e.a(c.a.CMD_SET_VOCAL_VOLUME_BASE, g.a(i11, 0, 100)) != 0) {
                aVar.notifySystemEarMonitoringError(aVar);
            }
        }
    }

    public static /* synthetic */ void c(a aVar) {
        c cVar = aVar.f21337e;
        if (cVar != null) {
            cVar.a();
            aVar.f21337e = null;
        }
        d dVar = aVar.f21336d;
        if (dVar != null) {
            dVar.b();
            aVar.f21336d = null;
        }
        aVar.f21339g = false;
    }

    public static /* synthetic */ void d(a aVar) {
        if (aVar.f21336d == null) {
            aVar.f21339g = true;
            d dVar = new d(aVar.f21334b, aVar);
            aVar.f21336d = dVar;
            dVar.a();
        }
    }

    public final void a(int i11) {
        a(g.a(this, i11));
    }

    public final void initialize() {
        a(b.a(this));
    }

    public final void onTimeout() {
        boolean z11 = true;
        if (LiteavSystemInfo.getAppBackgroundState() != 1) {
            z11 = false;
        }
        if (this.f21341i && this.f21340h && !z11) {
            LiteavLog.i("HwSystemEarMonitoring", "app return to foreground.");
            b();
            a();
        } else if (z11 && !this.f21340h) {
            LiteavLog.i("HwSystemEarMonitoring", "app has gone to background.");
        }
        this.f21340h = z11;
    }

    public final void setEarMonitoringVolume(int i11) {
        a(f.a(this, i11));
    }

    public final void startEarMonitoring() {
        a(d.a(this));
    }

    public final void stopEarMonitoring() {
        a(e.a(this));
    }

    public final void terminate() {
        a(c.a(this));
    }

    private void a() {
        c cVar = this.f21337e;
        if (cVar != null) {
            int a11 = cVar.a(true);
            if (a11 == 0 || a11 == 1805) {
                this.f21341i = true;
            } else {
                notifySystemEarMonitoringError(this);
            }
        }
    }

    private void b() {
        c cVar = this.f21337e;
        if (cVar != null) {
            cVar.a(false);
            this.f21341i = false;
        }
    }

    private void a(Runnable runnable) {
        if (Looper.myLooper() == this.f21335c.getLooper()) {
            runnable.run();
        } else {
            this.f21335c.post(runnable);
        }
    }

    public static /* synthetic */ void b(a aVar) {
        if (aVar.f21338f == null) {
            w wVar = new w(Looper.getMainLooper(), aVar);
            aVar.f21338f = wVar;
            wVar.a(f21333a);
        }
        aVar.a();
    }

    public static /* synthetic */ void a(a aVar, int i11) {
        LiteavLog.i("HwSystemEarMonitoring", "on audio kit callback: %d", Integer.valueOf(i11));
        if (i11 != 0) {
            if (!(i11 == 2 || i11 == 4 || i11 == 5 || i11 == 6 || i11 == 7)) {
                switch (i11) {
                    case 1000:
                        aVar.notifySystemEarMonitoringInitialized(aVar, true);
                        return;
                    case 1001:
                    case 1002:
                    case 1003:
                        break;
                    default:
                        return;
                }
            }
            if (aVar.f21339g) {
                aVar.f21339g = false;
                aVar.notifySystemEarMonitoringInitialized(aVar, false);
                return;
            }
            aVar.notifySystemEarMonitoringError(aVar);
            return;
        }
        aVar.f21339g = false;
        d dVar = aVar.f21336d;
        if (dVar != null) {
            d.a aVar2 = d.a.f21374a;
            if (dVar.a(aVar2)) {
                aVar.f21337e = (c) aVar.f21336d.b(aVar2);
                return;
            }
        }
        aVar.notifySystemEarMonitoringInitialized(aVar, false);
    }

    public static /* synthetic */ void a(a aVar) {
        w wVar = aVar.f21338f;
        if (wVar != null) {
            wVar.a();
            aVar.f21338f = null;
        }
        aVar.b();
    }
}
