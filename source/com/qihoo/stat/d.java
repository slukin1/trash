package com.qihoo.stat;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.Toast;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.huobi.vulcan.model.VulcanInfo;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.io.File;
import java.util.Iterator;
import java.util.Vector;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static String f28709a = "QSession";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f28710b = false;

    /* renamed from: c  reason: collision with root package name */
    public static String f28711c = "";

    /* renamed from: d  reason: collision with root package name */
    public static String f28712d = "";

    /* renamed from: e  reason: collision with root package name */
    public static String f28713e = "";

    /* renamed from: f  reason: collision with root package name */
    public static n f28714f = new n();

    /* renamed from: g  reason: collision with root package name */
    public static Pair f28715g = null;

    /* renamed from: h  reason: collision with root package name */
    public static long f28716h = 0;

    /* renamed from: i  reason: collision with root package name */
    public static String f28717i = "";

    /* renamed from: j  reason: collision with root package name */
    public static String f28718j = "";

    /* renamed from: k  reason: collision with root package name */
    public static Context f28719k = null;

    /* renamed from: l  reason: collision with root package name */
    public static boolean f28720l = true;

    public static void a(Context context) {
        try {
            if (f28719k == null) {
                b(context, 1);
                u.s(context);
                f28719k = context.getApplicationContext();
                Thread.setDefaultUncaughtExceptionHandler(new e0(f28719k));
                new e().start();
            }
        } catch (Exception e11) {
            g0.b(f28709a, e11);
        } catch (Error e12) {
            g0.a(f28709a, e12);
        }
    }

    public static void b(Context context, int i11) {
        if (f28710b) {
            Toast.makeText(context, "您使用的是Debug版的360移动统计SDK v1.1.3.140801", i11).show();
        }
    }

    public static void c(Context context, long j11) {
        try {
            if ("true".equals(c0.g(f28719k, "exLogEnable", "true"))) {
                g(context, false, j11);
            }
        } catch (Exception e11) {
            g0.b(f28709a, e11);
        }
    }

    public static void g(Context context, boolean z11, long j11) {
        if (context != null) {
            try {
                Pair b11 = u.b(context);
                if (f28715g != null) {
                    f28714f.f28819e = ((Long) b11.first).longValue() - ((Long) f28715g.first).longValue();
                    f28714f.f28820f = ((Long) b11.second).longValue() - ((Long) f28715g.second).longValue();
                }
                f28715g = b11;
                if (u.M() - f28716h > 2) {
                    f28716h = u.M();
                    f28714f.f28817c = u.M();
                    f28714f.d(u.j(context));
                    f28714f.d(f28717i);
                    f28714f.d(f28718j);
                    c0.d(context, true);
                    if (!z11) {
                        new r(z11, j11, context).start();
                        String str = f28709a;
                        g0.c(str, "delay: " + j11);
                        if (j11 > 0) {
                            Thread.sleep(j11);
                            return;
                        }
                        return;
                    }
                    n(context);
                    return;
                }
                g0.c(f28709a, "The update timeslot is too small");
            } catch (Exception e11) {
                g0.b(f28709a, e11);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0041, code lost:
        if ((com.qihoo.stat.u.M() - f28714f.f28816b) > 30) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void l(android.content.Context r8) {
        /*
            com.qihoo.stat.n r0 = f28714f
            java.lang.String r0 = r0.f28815a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 1
            java.lang.String r2 = "createTime"
            java.lang.String r3 = "session"
            if (r0 == 0) goto L_0x0044
            com.qihoo.stat.n r0 = f28714f
            java.lang.String r4 = ""
            java.lang.String r4 = com.qihoo.stat.c0.g(r8, r3, r4)
            r0.f28815a = r4
            com.qihoo.stat.n r0 = f28714f
            java.lang.String r0 = r0.f28815a
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L_0x002a
        L_0x0023:
            com.qihoo.stat.n r0 = com.qihoo.stat.u.N(r8)
            f28714f = r0
            goto L_0x0045
        L_0x002a:
            com.qihoo.stat.n r0 = f28714f
            r4 = 0
            long r4 = com.qihoo.stat.c0.e(r8, r2, r4)
            r0.f28816b = r4
            long r4 = com.qihoo.stat.u.M()
            com.qihoo.stat.n r0 = f28714f
            long r6 = r0.f28816b
            long r4 = r4 - r6
            r6 = 30
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 <= 0) goto L_0x0044
            goto L_0x0023
        L_0x0044:
            r1 = 0
        L_0x0045:
            if (r1 == 0) goto L_0x005b
            com.qihoo.stat.n r0 = f28714f
            java.lang.String r0 = r0.f28815a
            com.qihoo.stat.c0.c(r8, r3, r0)
            com.qihoo.stat.n r0 = f28714f
            long r0 = r0.f28816b
            com.qihoo.stat.c0.b(r8, r2, r0)
            com.qihoo.stat.c0.a(r8)
            com.qihoo.stat.c0.h(r8)
        L_0x005b:
            android.util.Pair r0 = f28715g
            if (r0 != 0) goto L_0x0065
            android.util.Pair r8 = com.qihoo.stat.u.b(r8)
            f28715g = r8
        L_0x0065:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo.stat.d.l(android.content.Context):void");
    }

    public static void n(Context context) {
        try {
            if (u.D(context)) {
                String k11 = u.k(u.S(context));
                if (!TextUtils.isEmpty(k11)) {
                    String str = f28709a;
                    g0.c(str, "logData: " + u.q(k11));
                    String g11 = c0.g(context, "logUrl", "http://gs.dev.360.cn/sendstat");
                    String a11 = z.a(context, g11, k11);
                    String str2 = f28709a;
                    g0.c(str2, "enResponse: " + a11);
                    String q11 = u.q(a11);
                    String str3 = f28709a;
                    g0.c(str3, "logUrl: " + g11 + ", response: " + q11);
                    if (!TextUtils.isEmpty(q11) && q11.endsWith("}")) {
                        JSONObject jSONObject = new JSONObject(q11);
                        if (!jSONObject.isNull("res") && jSONObject.getString("res").toLowerCase().equals(BaseHbgResponse.STATUS_OK)) {
                            new File(u.S(context)).delete();
                            new File(u.U(context)).delete();
                            u.Q(context);
                            c.c(context);
                        }
                        if (!jSONObject.isNull(TUIConstants.TUIPlugin.PLUGIN_EXTENSION_CONFIG)) {
                            JSONObject jSONObject2 = jSONObject.getJSONObject(TUIConstants.TUIPlugin.PLUGIN_EXTENSION_CONFIG);
                            Iterator<String> keys = jSONObject2.keys();
                            Vector vector = new Vector();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                vector.add(new Pair(next, jSONObject2.getString(next)));
                            }
                            i0.a(context, vector);
                        }
                        if (!jSONObject.isNull(VulcanInfo.SYS)) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject(VulcanInfo.SYS);
                            if (!jSONObject3.isNull("logUrl")) {
                                String string = jSONObject3.getString("logUrl");
                                if (!TextUtils.isEmpty(string)) {
                                    c0.c(context, "logUrl", string);
                                }
                            }
                            if (!jSONObject3.isNull("killLogEnable")) {
                                String string2 = jSONObject3.getString("killLogEnable");
                                if (!TextUtils.isEmpty(string2)) {
                                    c0.c(context, "killLogEnable", string2);
                                }
                            }
                            if (!jSONObject3.isNull("exLogEnable")) {
                                String string3 = jSONObject3.getString("exLogEnable");
                                if (!TextUtils.isEmpty(string3)) {
                                    c0.c(context, "exLogEnable", string3);
                                }
                            }
                            if (!jSONObject3.isNull("enableMode")) {
                                String string4 = jSONObject3.getString("enableMode");
                                if (!TextUtils.isEmpty(string4)) {
                                    c0.c(context, "enableMode", string4);
                                }
                            }
                            if (!jSONObject3.isNull("mode")) {
                                String string5 = jSONObject3.getString("mode");
                                if (!TextUtils.isEmpty(string5)) {
                                    if ("true".equals(string5)) {
                                        c0.j(context);
                                    } else if (com.sumsub.sns.internal.core.analytics.d.f31895b.equals(string5)) {
                                        c0.i(context);
                                    }
                                }
                            }
                            if (!jSONObject3.isNull("startUp")) {
                                String string6 = jSONObject3.getString("startUp");
                                if (!TextUtils.isEmpty(string6)) {
                                    c0.c(context, "startUp", string6);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            g0.b(f28709a, e11);
        } catch (Error e12) {
            g0.a(f28709a, e12);
        }
    }
}
