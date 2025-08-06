package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.hbg.lib.network.pro.core.util.Period;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ac;
import com.xiaomi.push.af;
import com.xiaomi.push.av;
import com.xiaomi.push.p;
import java.util.concurrent.ConcurrentHashMap;

public final class ay implements aa {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ay f52532a;

    /* renamed from: a  reason: collision with other field name */
    private long f3365a;

    /* renamed from: a  reason: collision with other field name */
    public Context f3366a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f3367a;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f3368a = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f3369a = false;

    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public long f52534a;

        /* renamed from: a  reason: collision with other field name */
        public String f3370a;

        public a(String str, long j11) {
            this.f3370a = str;
            this.f52534a = j11;
        }

        public abstract void a(ay ayVar);

        public void run() {
            if (ay.a() != null) {
                Context context = ay.a().f3366a;
                if (av.c(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences a11 = ay.a(ay.a());
                    if (currentTimeMillis - a11.getLong(":ts-" + this.f3370a, 0) > this.f52534a || ac.a(context)) {
                        SharedPreferences.Editor edit = ay.a(ay.a()).edit();
                        p.a(edit.putLong(":ts-" + this.f3370a, System.currentTimeMillis()));
                        a(ay.a());
                    }
                }
            }
        }
    }

    private ay(Context context) {
        this.f3366a = context.getApplicationContext();
        this.f3367a = context.getSharedPreferences("sync", 0);
    }

    public static ay a(Context context) {
        if (f52532a == null) {
            synchronized (ay.class) {
                if (f52532a == null) {
                    f52532a = new ay(context);
                }
            }
        }
        return f52532a;
    }

    public void a() {
        if (!this.f3369a) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f3365a >= Period.MIN60_MILLS) {
                this.f3365a = currentTimeMillis;
                this.f3369a = true;
                af.a(this.f3366a).a((Runnable) new Runnable() {
                    public void run() {
                        try {
                            for (a run : ay.a(ay.this).values()) {
                                run.run();
                            }
                        } catch (Exception e11) {
                            b.a("Sync job exception :" + e11.getMessage());
                        }
                        boolean unused = ay.this.f3369a = false;
                    }
                }, (int) (Math.random() * 10.0d));
            }
        }
    }

    public String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f3367a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    public void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f52532a.f3367a.edit();
        p.a(edit.putString(str + ":" + str2, str3));
    }

    public void a(a aVar) {
        if (this.f3368a.putIfAbsent(aVar.f3370a, aVar) == null) {
            af.a(this.f3366a).a((Runnable) aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }
}
