package com.tencent.android.tpush.stat;

import android.content.Context;
import com.jumio.core.cdn.CDNDownload;
import com.sumsub.sns.internal.fingerprint.signalproviders.f;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.android.tpush.service.XGVipPushService;
import com.tencent.android.tpush.stat.b.b;
import com.tencent.android.tpush.stat.b.c;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public static a f69978a = new a(2);

    /* renamed from: b  reason: collision with root package name */
    public static a f69979b = new a(1);

    /* renamed from: c  reason: collision with root package name */
    public static String f69980c = "__HIBERNATE__";

    /* renamed from: d  reason: collision with root package name */
    private static c f69981d = b.b();

    /* renamed from: e  reason: collision with root package name */
    private static StatReportStrategy f69982e = StatReportStrategy.APP_LAUNCH;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f69983f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f69984g = true;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f69985h = false;

    /* renamed from: i  reason: collision with root package name */
    private static short f69986i = 6;

    /* renamed from: j  reason: collision with root package name */
    private static int f69987j = 1024;

    /* renamed from: k  reason: collision with root package name */
    private static int f69988k = CDNDownload.DEFAULT_TIMEOUT;

    /* renamed from: l  reason: collision with root package name */
    private static int f69989l = 0;

    /* renamed from: m  reason: collision with root package name */
    private static int f69990m = 20;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f69991a;

        /* renamed from: b  reason: collision with root package name */
        public JSONObject f69992b = new JSONObject();

        /* renamed from: c  reason: collision with root package name */
        public String f69993c = "";

        /* renamed from: d  reason: collision with root package name */
        public int f69994d = 0;

        public a(int i11) {
            this.f69991a = i11;
        }
    }

    public static StatReportStrategy a() {
        return f69982e;
    }

    public static boolean b() {
        return f69983f;
    }

    public static boolean c() {
        Context context = XGPushManager.getContext();
        if (context == null) {
            if (XGVipPushService.a() == null) {
                return false;
            }
            context = XGVipPushService.a().getApplicationContext();
        }
        if (context == null) {
            return f69984g;
        }
        if (!f69984g || com.tencent.android.tpush.service.a.a.a(context.getApplicationContext()).B != 1) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        return f69985h;
    }

    public static short e() {
        return f69986i;
    }

    public static int f() {
        return f69987j;
    }

    public static void a(StatReportStrategy statReportStrategy) {
        f69982e = statReportStrategy;
        if (b()) {
            c cVar = f69981d;
            cVar.h("Change to statSendStrategy: " + statReportStrategy);
        }
    }

    public static void b(boolean z11) {
        f69984g = z11;
        if (!z11) {
            f69981d.c("!!!!!!MTA StatService has been disabled!!!!!!");
        }
    }

    public static void b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            try {
                String string = jSONObject.getString(f69980c);
                if (b()) {
                    c cVar = f69981d;
                    cVar.h("hibernateVer:" + string + ", current version:" + "2.0.6");
                }
                long b11 = b.b(string);
                if (b.b("2.0.6") <= b11) {
                    a(b11);
                }
            } catch (JSONException unused) {
                f69981d.h("__HIBERNATE__ not found.");
            }
        }
    }

    public static void a(boolean z11) {
        f69983f = z11;
        b.b().a(z11);
    }

    public static void a(Context context, JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(f69979b.f69991a))) {
                    a(context, f69979b, jSONObject.getJSONObject(next));
                } else if (next.equalsIgnoreCase(Integer.toString(f69978a.f69991a))) {
                    a(context, f69978a, jSONObject.getJSONObject(next));
                }
            }
        } catch (JSONException e11) {
            f69981d.b((Throwable) e11);
        }
    }

    public static void c(boolean z11) {
        f69985h = z11;
    }

    public static void a(Context context, a aVar, JSONObject jSONObject) {
        boolean z11 = false;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(f.f34662a)) {
                    int i11 = jSONObject.getInt(next);
                    if (aVar.f69994d != i11) {
                        z11 = true;
                    }
                    aVar.f69994d = i11;
                } else if (next.equalsIgnoreCase("c")) {
                    String string = jSONObject.getString("c");
                    if (string.length() > 0) {
                        aVar.f69992b = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase("m")) {
                    aVar.f69993c = jSONObject.getString("m");
                }
            }
            if (z11 && aVar.f69991a == f69979b.f69991a) {
                a(aVar.f69992b);
                b(aVar.f69992b);
            }
            a(context, aVar);
        } catch (JSONException e11) {
            f69981d.b((Throwable) e11);
        } catch (Throwable th2) {
            f69981d.b(th2);
        }
    }

    public static void a(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                a(statReportStrategy);
            }
        } catch (JSONException unused) {
            if (b()) {
                f69981d.b((Object) "rs not found.");
            }
        }
    }

    public static void a(Context context, a aVar) {
        int i11 = aVar.f69991a;
        if (i11 == f69979b.f69991a) {
            f69979b = aVar;
            a(aVar.f69992b);
        } else if (i11 == f69978a.f69991a) {
            f69978a = aVar;
        }
    }

    public static void a(long j11) {
        com.tencent.android.tpush.stat.b.d.b(f.a(), f69980c, j11);
        b(false);
        f69981d.c("MTA is disable for current SDK version");
    }
}
