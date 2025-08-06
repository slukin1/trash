package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.en;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Hashtable;

public class eq {

    /* renamed from: a  reason: collision with root package name */
    private static final int f51746a = ej.PING_RTT.a();

    /* renamed from: a  reason: collision with other field name */
    private static long f2805a = 0;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static Hashtable<Integer, Long> f51747a = new Hashtable<>();
    }

    public static void a(String str, Exception exc) {
        try {
            en.a b11 = en.b(exc);
            ek a11 = ep.a().a();
            a11.a(b11.f51736a.a());
            a11.c(b11.f2794a);
            a11.b(str);
            if (!(ep.a() == null || ep.a().f2797a == null)) {
                a11.c(av.b(ep.a().f2797a) ? 1 : 0);
            }
            ep.a().a(a11);
        } catch (NullPointerException unused) {
        }
    }

    public static void b(String str, Exception exc) {
        try {
            en.a d11 = en.d(exc);
            ek a11 = ep.a().a();
            a11.a(d11.f51736a.a());
            a11.c(d11.f2794a);
            a11.b(str);
            if (!(ep.a() == null || ep.a().f2797a == null)) {
                a11.c(av.b(ep.a().f2797a) ? 1 : 0);
            }
            ep.a().a(a11);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, int i11, Exception exc) {
        ek a11 = ep.a().a();
        if (!(ep.a() == null || ep.a().f2797a == null)) {
            a11.c(av.b(ep.a().f2797a) ? 1 : 0);
        }
        if (i11 > 0) {
            a11.a(ej.GSLB_REQUEST_SUCCESS.a());
            a11.b(str);
            a11.b(i11);
            ep.a().a(a11);
            return;
        }
        try {
            en.a a12 = en.a(exc);
            a11.a(a12.f51736a.a());
            a11.c(a12.f2794a);
            a11.b(str);
            ep.a().a(a11);
        } catch (NullPointerException unused) {
        }
    }

    public static void b() {
        a(0, f51746a, (String) null, -1);
    }

    public static void a(XMPushService xMPushService, am.b bVar) {
        new em(xMPushService, bVar).a();
    }

    public static synchronized void a(int i11, int i12) {
        synchronized (eq.class) {
            if (i12 < 16777215) {
                a.f51747a.put(Integer.valueOf((i11 << 24) | i12), Long.valueOf(System.currentTimeMillis()));
            } else {
                b.d("stats key should less than 16777215");
            }
        }
    }

    public static synchronized void a(int i11, int i12, String str, int i13) {
        synchronized (eq.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i14 = (i11 << 24) | i12;
            if (a.f51747a.containsKey(Integer.valueOf(i14))) {
                ek a11 = ep.a().a();
                a11.a(i12);
                a11.b((int) (currentTimeMillis - a.f51747a.get(Integer.valueOf(i14)).longValue()));
                a11.b(str);
                if (i13 > -1) {
                    a11.c(i13);
                }
                ep.a().a(a11);
                a.f51747a.remove(Integer.valueOf(i12));
            } else {
                b.d("stats key not found");
            }
        }
    }

    public static void a() {
        if (f2805a == 0 || SystemClock.elapsedRealtime() - f2805a > 7200000) {
            f2805a = SystemClock.elapsedRealtime();
            a(0, f51746a);
        }
    }

    public static void a(int i11, int i12, int i13, String str, int i14) {
        ek a11 = ep.a().a();
        a11.a((byte) i11);
        a11.a(i12);
        a11.b(i13);
        a11.b(str);
        a11.c(i14);
        ep.a().a(a11);
    }

    public static void a(int i11) {
        ek a11 = ep.a().a();
        a11.a(ej.CHANNEL_STATS_COUNTER.a());
        a11.c(i11);
        ep.a().a(a11);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static byte[] m2649a() {
        el a11 = ep.a().a();
        if (a11 != null) {
            return hq.a(a11);
        }
        return null;
    }
}
