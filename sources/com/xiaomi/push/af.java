package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class af {

    /* renamed from: a  reason: collision with root package name */
    private static volatile af f51356a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f2497a;

    /* renamed from: a  reason: collision with other field name */
    private Object f2498a = new Object();

    /* renamed from: a  reason: collision with other field name */
    private Map<String, ScheduledFuture> f2499a = new HashMap();

    /* renamed from: a  reason: collision with other field name */
    private ScheduledThreadPoolExecutor f2500a = new ScheduledThreadPoolExecutor(1);

    public static abstract class a implements Runnable {
        public abstract String a();
    }

    public static class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public a f51359a;

        public b(a aVar) {
            this.f51359a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        public void run() {
            a();
            this.f51359a.run();
            b();
        }
    }

    private af(Context context) {
        this.f2497a = context.getSharedPreferences("mipush_extra", 0);
    }

    public boolean b(a aVar, int i11) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.f2500a.schedule(new b(aVar) {
            public void b() {
                synchronized (af.a(af.this)) {
                    af.a(af.this).remove(this.f51359a.a());
                }
            }
        }, (long) i11, TimeUnit.SECONDS);
        synchronized (this.f2498a) {
            this.f2499a.put(aVar.a(), schedule);
        }
        return true;
    }

    public static af a(Context context) {
        if (f51356a == null) {
            synchronized (af.class) {
                if (f51356a == null) {
                    f51356a = new af(context);
                }
            }
        }
        return f51356a;
    }

    public boolean a(a aVar, int i11) {
        return a(aVar, i11, 0);
    }

    public boolean a(a aVar, int i11, int i12) {
        return a(aVar, i11, i12, false);
    }

    public boolean a(a aVar, int i11, int i12, final boolean z11) {
        if (aVar == null || a(aVar) != null) {
            return false;
        }
        final String a11 = a(aVar.a());
        AnonymousClass1 r22 = new b(aVar) {
            public void a() {
                super.a();
            }

            public void b() {
                if (!z11) {
                    af.a(af.this).edit().putLong(a11, System.currentTimeMillis()).commit();
                }
            }
        };
        if (!z11) {
            long abs = Math.abs(System.currentTimeMillis() - this.f2497a.getLong(a11, 0)) / 1000;
            if (abs < ((long) (i11 - i12))) {
                i12 = (int) (((long) i11) - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.f2500a.scheduleAtFixedRate(r22, (long) i12, (long) i11, TimeUnit.SECONDS);
            synchronized (this.f2498a) {
                this.f2499a.put(aVar.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e11) {
            com.xiaomi.channel.commonutils.logger.b.a((Throwable) e11);
            return true;
        }
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i11) {
        this.f2500a.schedule(runnable, (long) i11, TimeUnit.SECONDS);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2384a(a aVar) {
        return b(aVar, 0);
    }

    private ScheduledFuture a(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f2498a) {
            scheduledFuture = this.f2499a.get(aVar.a());
        }
        return scheduledFuture;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m2385a(String str) {
        synchronized (this.f2498a) {
            ScheduledFuture scheduledFuture = this.f2499a.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f2499a.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    private static String a(String str) {
        return "last_job_time" + str;
    }
}
