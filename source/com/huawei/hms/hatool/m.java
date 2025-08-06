package com.huawei.hms.hatool;

import android.content.Context;

public final class m {

    /* renamed from: b  reason: collision with root package name */
    private static m f38225b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38226c = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f38227a;

    private m() {
    }

    public static m a() {
        if (f38225b == null) {
            b();
        }
        return f38225b;
    }

    private static synchronized void b() {
        synchronized (m.class) {
            if (f38225b == null) {
                f38225b = new m();
            }
        }
    }

    public void a(Context context) {
        synchronized (f38226c) {
            if (this.f38227a != null) {
                v.f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f38227a = context;
            s.c().b().a(this.f38227a);
            s.c().b().j(context.getPackageName());
            j.a().a(context);
        }
    }

    public void a(String str) {
        v.c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f38227a;
        if (context == null) {
            v.e("hmsSdk", "sdk is not init");
            return;
        }
        s.c().b().i(e1.a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
    }
}
