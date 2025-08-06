package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f38144b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<String, Long> f38145c = new HashMap();

    /* renamed from: a  reason: collision with root package name */
    private Context f38146a;

    public static e a() {
        return b();
    }

    private static synchronized e b() {
        e eVar;
        synchronized (e.class) {
            if (f38144b == null) {
                f38144b = new e();
            }
            eVar = f38144b;
        }
        return eVar;
    }

    private void b(Context context) {
        String str;
        String d11 = o.d(context);
        q0.a(d11);
        if (q1.b().a()) {
            String a11 = d.a(context, "global_v2", "app_ver", "");
            d.b(context, "global_v2", "app_ver", d11);
            q0.b(a11);
            if (TextUtils.isEmpty(a11)) {
                str = "app ver is first save!";
            } else if (!a11.equals(d11)) {
                v.c("hmsSdk", "the appVers are different!");
                a().a("", "alltype", a11);
                return;
            } else {
                return;
            }
        } else {
            str = "userManager.isUserUnlocked() == false";
        }
        v.c("hmsSdk", str);
    }

    public void a(Context context) {
        this.f38146a = context;
        b(context);
        s.c().b().h(o.a());
    }

    public void a(String str, int i11) {
        if (this.f38146a == null) {
            v.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        v.c("hmsSdk", "onReport: Before calling runtaskhandler()");
        a(str, n1.a(i11), q0.g());
    }

    public void a(String str, int i11, String str2, JSONObject jSONObject) {
        long currentTimeMillis = System.currentTimeMillis();
        if (2 == i11) {
            currentTimeMillis = n1.a("yyyy-MM-dd", currentTimeMillis);
        }
        String str3 = str2;
        JSONObject jSONObject2 = jSONObject;
        String str4 = str;
        b0.c().a(new a0(str3, jSONObject2, str4, n1.a(i11), currentTimeMillis));
    }

    public void a(String str, int i11, String str2, JSONObject jSONObject, long j11) {
        new i1(str, n1.a(i11), str2, jSONObject.toString(), j11).a();
    }

    public void a(String str, String str2) {
        if (a1.a(str, str2)) {
            long j11 = a1.j(str, str2);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - j11 > 30000) {
                v.a("hmsSdk", "begin to call onReport!");
                a1.a(str, str2, currentTimeMillis);
                a(str, str2, q0.g());
                return;
            }
            v.f("hmsSdk", "autoReport timeout. interval < 30s ");
            return;
        }
        v.c("hmsSdk", "auto report is closed tag:" + str);
    }

    public void a(String str, String str2, String str3) {
        Context context = this.f38146a;
        if (context == null) {
            v.e("hmsSdk", "onReport() null context or SDK was not init.");
            return;
        }
        String b11 = r0.b(context);
        if (a1.e(str, str2) && !"WIFI".equals(b11)) {
            v.c("hmsSdk", "strNetworkType is :" + b11);
        } else if ("unknown".equals(b11) || "none".equals(b11) || "2G".equals(b11)) {
            v.e("hmsSdk", "The network is bad.");
        } else {
            b0.c().a(new v0(str, str2, str3));
        }
    }
}
