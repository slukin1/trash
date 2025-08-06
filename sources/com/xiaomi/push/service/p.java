package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.g;
import com.xiaomi.push.j;
import com.xiaomi.push.r;
import com.xiaomi.push.s;
import com.xiaomi.push.service.am;
import com.xiaomi.push.t;
import java.util.Locale;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f52578a;

    /* renamed from: a  reason: collision with other field name */
    public final String f3412a;

    /* renamed from: b  reason: collision with root package name */
    public final String f52579b;

    /* renamed from: c  reason: collision with root package name */
    public final String f52580c;

    /* renamed from: d  reason: collision with root package name */
    public final String f52581d;

    /* renamed from: e  reason: collision with root package name */
    public final String f52582e;

    /* renamed from: f  reason: collision with root package name */
    public final String f52583f;

    public p(String str, String str2, String str3, String str4, String str5, String str6, int i11) {
        this.f3412a = str;
        this.f52579b = str2;
        this.f52580c = str3;
        this.f52581d = str4;
        this.f52582e = str5;
        this.f52583f = str6;
        this.f52578a = i11;
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public am.b a(XMPushService xMPushService) {
        am.b bVar = new am.b(xMPushService);
        a(bVar, xMPushService, xMPushService.b(), "c");
        return bVar;
    }

    public am.b a(am.b bVar, Context context, h hVar, String str) {
        bVar.f3343a = context.getPackageName();
        bVar.f3346b = this.f3412a;
        bVar.f52471h = this.f52580c;
        bVar.f52466c = this.f52579b;
        bVar.f52470g = BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC;
        bVar.f52467d = "XMPUSH-PASS";
        bVar.f3345a = false;
        t.a aVar = new t.a();
        aVar.a(HiAnalyticsConstant.BI_KEY_SDK_VER, 48).a("cpvn", "6_0_1-C").a("cpvc", 60001).a("country_code", b.a(context).b()).a(TtmlNode.TAG_REGION, b.a(context).a()).a("miui_vn", j.f()).a("miui_vc", Integer.valueOf(j.a(context))).a("xmsf_vc", Integer.valueOf(g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(af.a(context))).a("systemui_vc", Integer.valueOf(r.a(context)));
        if (j.e()) {
            aVar.a("os_vm", j.c());
            aVar.a("os_vc", Integer.valueOf(j.b()));
        }
        String a11 = a(context);
        if (!TextUtils.isEmpty(a11)) {
            aVar.a("latest_country_code", a11);
        }
        String g11 = j.g();
        if (!TextUtils.isEmpty(g11)) {
            aVar.a("device_ch", g11);
        }
        String h11 = j.h();
        if (!TextUtils.isEmpty(h11)) {
            aVar.a("device_mfr", h11);
        }
        bVar.f52468e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.f52581d;
        t.a aVar2 = new t.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f52469f = aVar2.toString();
        bVar.f3342a = hVar;
        return bVar;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static boolean m3037a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean a() {
        try {
            return s.a((Context) null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean((Object) null);
        } catch (Exception unused) {
            return false;
        }
    }

    private static String a(Context context) {
        if (!"com.xiaomi.xmsf".equals(context)) {
            return j.b();
        }
        if (!TextUtils.isEmpty((CharSequence) null)) {
            return null;
        }
        String a11 = j.a("ro.miui.region");
        if (TextUtils.isEmpty(a11)) {
            return j.a("ro.product.locale.region");
        }
        return a11;
    }
}
