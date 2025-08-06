package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.a.b;
import com.tencent.wxop.stat.a.d;
import com.tencent.wxop.stat.a.i;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.q;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.Thread;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private static volatile boolean S = true;
    public static volatile int aI = 0;
    private static f aK;
    private static volatile Map<b, Long> aL = new ConcurrentHashMap();
    private static volatile Map<String, Properties> aM = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static volatile Map<Integer, Integer> aN = new ConcurrentHashMap(10);
    /* access modifiers changed from: private */
    public static volatile long aO = 0;
    private static volatile long aP = 0;
    private static volatile int aQ = 0;
    /* access modifiers changed from: private */
    public static volatile String aR = "";
    /* access modifiers changed from: private */
    public static volatile String aS = "";
    /* access modifiers changed from: private */
    public static Map<String, Long> aT = new ConcurrentHashMap();
    private static Map<String, Long> aU = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public static com.tencent.wxop.stat.b.b aV = l.av();
    /* access modifiers changed from: private */
    public static Thread.UncaughtExceptionHandler aW = null;
    public static volatile long aX = 0;
    /* access modifiers changed from: private */
    public static Context aY = null;
    public static volatile long aZ = 0;

    /* renamed from: af  reason: collision with root package name */
    private static volatile long f51062af = 0;

    /* renamed from: al  reason: collision with root package name */
    private static String f51063al = "";

    private static JSONObject G() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i11 = c.P.L;
            if (i11 != 0) {
                jSONObject2.put(com.sumsub.sns.internal.fingerprint.signalproviders.f.f34662a, i11);
            }
            jSONObject.put(Integer.toString(c.P.aI), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            int i12 = c.O.L;
            if (i12 != 0) {
                jSONObject3.put(com.sumsub.sns.internal.fingerprint.signalproviders.f.f34662a, i12);
            }
            jSONObject.put(Integer.toString(c.O.aI), jSONObject3);
        } catch (JSONException e11) {
            aV.b((Throwable) e11);
        }
        return jSONObject;
    }

    public static void H() {
        aI = 0;
        aX = 0;
    }

    public static void I() {
        aI++;
        aX = System.currentTimeMillis();
        p(aY);
    }

    public static int a(Context context, boolean z11, f fVar) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z12 = true;
        boolean z13 = z11 && currentTimeMillis - f51062af >= ((long) c.m());
        f51062af = currentTimeMillis;
        if (aP == 0) {
            aP = l.ad();
        }
        if (currentTimeMillis >= aP) {
            aP = l.ad();
            if (t.s(context).t(context).as() != 1) {
                t.s(context).t(context).z();
            }
            c.C();
            aI = 0;
            f51063al = l.aw();
            z13 = true;
        }
        String str = f51063al;
        if (l.a(fVar)) {
            str = fVar.S() + f51063al;
        }
        if (aU.containsKey(str)) {
            z12 = z13;
        }
        if (z12) {
            if (l.a(fVar)) {
                a(context, fVar);
            } else if (c.D() < c.A()) {
                l.O(context);
                a(context, (f) null);
            } else {
                aV.d("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            aU.put(str, 1L);
        }
        if (S) {
            if (c.l()) {
                Context i11 = i(context);
                if (i11 == null) {
                    aV.error("The Context of StatService.testSpeed() can not be null!");
                } else if (k(i11) != null) {
                    aK.a(new i(i11));
                }
            }
            S = false;
        }
        return aQ;
    }

    private static void a(Context context, f fVar) {
        if (k(context) != null) {
            if (c.k()) {
                aV.e("start new session.");
            }
            if (fVar == null || aQ == 0) {
                aQ = l.r();
            }
            c.z();
            c.B();
            new p(new i(context, aQ, G(), fVar)).ah();
        }
    }

    public static void a(Context context, String str, f fVar) {
        if (c.l()) {
            Context i11 = i(context);
            if (i11 == null || str == null || str.length() == 0) {
                aV.error("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (k(i11) != null) {
                aK.a(new as(str2, i11, fVar));
            }
        }
    }

    public static void a(Context context, Throwable th2) {
        if (c.l()) {
            Context i11 = i(context);
            if (i11 == null) {
                aV.error("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (k(i11) != null) {
                aK.a(new ap(i11, th2));
            }
        }
    }

    public static boolean a() {
        if (aI < 2) {
            return false;
        }
        aX = System.currentTimeMillis();
        return true;
    }

    public static boolean a(Context context, String str, String str2) {
        try {
            if (!c.l()) {
                aV.error("MTA StatService is disable.");
                return false;
            }
            if (c.k()) {
                aV.e("MTA SDK version, current: " + "2.0.3" + " ,required: " + str2);
            }
            if (context != null) {
                if (str2 != null) {
                    if (l.u("2.0.3") < l.u(str2)) {
                        aV.error(("MTA SDK version conflicted, current: " + "2.0.3" + ",required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                        c.a(false);
                        return false;
                    }
                    String e11 = c.e(context);
                    if (e11 == null || e11.length() == 0) {
                        c.n(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                    }
                    if (str != null) {
                        c.b(context, str);
                    }
                    if (k(context) == null) {
                        return true;
                    }
                    aK.a(new m(context));
                    return true;
                }
            }
            aV.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            c.a(false);
            return false;
        } catch (Throwable th2) {
            aV.b(th2);
            return false;
        }
    }

    public static void b(Context context, String str, f fVar) {
        if (c.l()) {
            Context i11 = i(context);
            if (i11 == null || str == null || str.length() == 0) {
                aV.error("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (k(i11) != null) {
                aK.a(new k(i11, str2, fVar));
            }
        }
    }

    public static void d(Context context, String str) {
        com.tencent.wxop.stat.b.b bVar;
        String str2;
        if (c.l()) {
            Context i11 = i(context);
            if (i11 == null) {
                bVar = aV;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else {
                if (str == null || str.length() == 0) {
                    bVar = aV;
                    str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
                } else {
                    b bVar2 = new b(str);
                    if (k(i11) != null) {
                        aK.a(new ar(i11, bVar2));
                        return;
                    }
                    return;
                }
            }
            bVar.error(str2);
        }
    }

    private static Context i(Context context) {
        return context != null ? context : aY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0096, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void j(android.content.Context r9) {
        /*
            java.lang.Class<com.tencent.wxop.stat.e> r0 = com.tencent.wxop.stat.e.class
            monitor-enter(r0)
            if (r9 != 0) goto L_0x0007
            monitor-exit(r0)
            return
        L_0x0007:
            com.tencent.wxop.stat.b.f r1 = aK     // Catch:{ all -> 0x0097 }
            if (r1 != 0) goto L_0x0095
            java.lang.String r1 = com.tencent.wxop.stat.c.f51057c     // Catch:{ all -> 0x0097 }
            long r1 = com.tencent.wxop.stat.b.q.f(r9, r1)     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = "2.0.3"
            long r3 = com.tencent.wxop.stat.b.l.u(r3)     // Catch:{ all -> 0x0097 }
            r5 = 1
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r7 = 0
            if (r6 > 0) goto L_0x0039
            com.tencent.wxop.stat.b.b r5 = aV     // Catch:{ all -> 0x0097 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            java.lang.String r8 = "MTA is disable for current version:"
            r6.<init>(r8)     // Catch:{ all -> 0x0097 }
            r6.append(r3)     // Catch:{ all -> 0x0097 }
            java.lang.String r3 = ",wakeup version:"
            r6.append(r3)     // Catch:{ all -> 0x0097 }
            r6.append(r1)     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = r6.toString()     // Catch:{ all -> 0x0097 }
            r5.error(r1)     // Catch:{ all -> 0x0097 }
            r5 = r7
        L_0x0039:
            java.lang.String r1 = com.tencent.wxop.stat.c.W     // Catch:{ all -> 0x0097 }
            long r1 = com.tencent.wxop.stat.b.q.f(r9, r1)     // Catch:{ all -> 0x0097 }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0097 }
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0067
            com.tencent.wxop.stat.b.b r3 = aV     // Catch:{ all -> 0x0097 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = "MTA is disable for current time:"
            r4.<init>(r5)     // Catch:{ all -> 0x0097 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0097 }
            r4.append(r5)     // Catch:{ all -> 0x0097 }
            java.lang.String r5 = ",wakeup time:"
            r4.append(r5)     // Catch:{ all -> 0x0097 }
            r4.append(r1)     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0097 }
            r3.error(r1)     // Catch:{ all -> 0x0097 }
            goto L_0x0068
        L_0x0067:
            r7 = r5
        L_0x0068:
            com.tencent.wxop.stat.c.a((boolean) r7)     // Catch:{ all -> 0x0097 }
            if (r7 != 0) goto L_0x006f
            monitor-exit(r0)
            return
        L_0x006f:
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x0097 }
            aY = r9     // Catch:{ all -> 0x0097 }
            com.tencent.wxop.stat.b.f r1 = new com.tencent.wxop.stat.b.f     // Catch:{ all -> 0x0097 }
            r1.<init>()     // Catch:{ all -> 0x0097 }
            aK = r1     // Catch:{ all -> 0x0097 }
            java.lang.String r1 = com.tencent.wxop.stat.b.l.aw()     // Catch:{ all -> 0x0097 }
            f51063al = r1     // Catch:{ all -> 0x0097 }
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0097 }
            long r3 = com.tencent.wxop.stat.c.f51036af     // Catch:{ all -> 0x0097 }
            long r1 = r1 + r3
            aO = r1     // Catch:{ all -> 0x0097 }
            com.tencent.wxop.stat.b.f r1 = aK     // Catch:{ all -> 0x0097 }
            com.tencent.wxop.stat.an r2 = new com.tencent.wxop.stat.an     // Catch:{ all -> 0x0097 }
            r2.<init>(r9)     // Catch:{ all -> 0x0097 }
            r1.a(r2)     // Catch:{ all -> 0x0097 }
        L_0x0095:
            monitor-exit(r0)
            return
        L_0x0097:
            r9 = move-exception
            monitor-exit(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.e.j(android.content.Context):void");
    }

    private static f k(Context context) {
        if (aK == null) {
            synchronized (e.class) {
                if (aK == null) {
                    try {
                        j(context);
                    } catch (Throwable th2) {
                        aV.a(th2);
                        c.a(false);
                    }
                }
            }
        }
        return aK;
    }

    public static void l(Context context) {
        if (c.l() && k(context) != null) {
            aK.a(new l(context));
        }
    }

    public static void m(Context context) {
        if (c.l() && k(context) != null) {
            aK.a(new ao(context));
        }
    }

    public static void n(Context context) {
        if (c.l()) {
            Context i11 = i(context);
            if (i11 == null) {
                aV.error("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                ak.Z(i11).a((d) new com.tencent.wxop.stat.a.f(i11), (aj) new aq());
            } catch (Throwable th2) {
                aV.b(th2);
            }
        }
    }

    public static void o(Context context) {
        if (c.l()) {
            if (c.k()) {
                aV.b((Object) "commitEvents, maxNumber=-1");
            }
            Context i11 = i(context);
            if (i11 == null) {
                aV.error("The Context of StatService.commitEvents() can not be null!");
            } else if (g.r(aY).X() && k(i11) != null) {
                aK.a(new h(i11));
            }
        }
    }

    public static Properties p(String str) {
        return aM.get(str);
    }

    public static void p(Context context) {
        if (c.l() && c.f51055ay > 0) {
            Context i11 = i(context);
            if (i11 == null) {
                aV.error("The Context of StatService.testSpeed() can not be null!");
            } else {
                t.s(i11).H();
            }
        }
    }

    public static void q(Context context) {
        aZ = System.currentTimeMillis() + ((long) (c.u() * 60000));
        q.a(context, "last_period_ts", aZ);
        o(context);
    }
}
