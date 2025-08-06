package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.af;
import com.xiaomi.push.service.ah;

public class dl {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dl f51590a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2673a;

    /* renamed from: a  reason: collision with other field name */
    private a f2674a;

    public interface a {
        void a();
    }

    private dl(Context context) {
        this.f2673a = context;
    }

    /* access modifiers changed from: private */
    public void b() {
        a aVar;
        af a11 = af.a(this.f2673a);
        ah a12 = ah.a(this.f2673a);
        SharedPreferences sharedPreferences = this.f2673a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j11 == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j11) >= 172800000) {
            a(a12, a11, false);
            if (a12.a(gl.StorageCollectionSwitch.a(), true)) {
                int a13 = a(a12.a(gl.StorageCollectionFrequency.a(), 86400));
                a11.a(new dn(this.f2673a, a13), a13, 0);
            }
            if (j.a(this.f2673a) && (aVar = this.f2674a) != null) {
                aVar.a();
            }
            if (a12.a(gl.ActivityTSSwitch.a(), false)) {
                a();
            }
            a(a12, a11, true);
        }
    }

    public static dl a(Context context) {
        if (f51590a == null) {
            synchronized (dl.class) {
                if (f51590a == null) {
                    f51590a = new dl(context);
                }
            }
        }
        return f51590a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m2521a() {
        af.a(this.f2673a).a((Runnable) new Runnable() {
            public void run() {
                dl.this.b();
            }
        });
    }

    private void a(ah ahVar, af afVar, boolean z11) {
        if (ahVar.a(gl.UploadSwitch.a(), true)) {
            Cdo doVar = new Cdo(this.f2673a);
            if (z11) {
                afVar.a((af.a) doVar, a(ahVar.a(gl.UploadFrequency.a(), 86400)));
            } else {
                afVar.a((af.a) doVar);
            }
        }
    }

    public static int a(int i11) {
        return Math.max(60, i11);
    }

    private boolean a() {
        Application application;
        try {
            Context context = this.f2673a;
            if (context instanceof Application) {
                application = (Application) context;
            } else {
                application = (Application) context.getApplicationContext();
            }
            application.registerActivityLifecycleCallbacks(new df(this.f2673a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e11) {
            b.a((Throwable) e11);
            return false;
        }
    }
}
