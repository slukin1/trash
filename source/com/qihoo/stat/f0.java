package com.qihoo.stat;

import android.content.Context;
import android.text.TextUtils;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huobi.vulcan.model.VulcanInfo;
import com.sumsub.sentry.q;
import com.sumsub.sns.internal.core.common.n0;
import org.json.JSONObject;

public class f0 {
    public static String H = "QHeader";
    public int A = 0;
    public String B = "";
    public String C = "";
    public String D = "";
    public String E = "";
    public String F = "";
    public String G = "";

    /* renamed from: a  reason: collision with root package name */
    public String f28730a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f28731b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f28732c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f28733d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f28734e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f28735f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f28736g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f28737h = "";

    /* renamed from: i  reason: collision with root package name */
    public String f28738i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f28739j = "";

    /* renamed from: k  reason: collision with root package name */
    public String f28740k = "";

    /* renamed from: l  reason: collision with root package name */
    public String f28741l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f28742m = "";

    /* renamed from: n  reason: collision with root package name */
    public String f28743n = "";

    /* renamed from: o  reason: collision with root package name */
    public String f28744o = "";

    /* renamed from: p  reason: collision with root package name */
    public String f28745p = "";

    /* renamed from: q  reason: collision with root package name */
    public String f28746q = "";

    /* renamed from: r  reason: collision with root package name */
    public String f28747r = "";

    /* renamed from: s  reason: collision with root package name */
    public String f28748s = "";

    /* renamed from: t  reason: collision with root package name */
    public String f28749t = "";

    /* renamed from: u  reason: collision with root package name */
    public String f28750u = "";

    /* renamed from: v  reason: collision with root package name */
    public long f28751v = 0;

    /* renamed from: w  reason: collision with root package name */
    public long f28752w = 0;

    /* renamed from: x  reason: collision with root package name */
    public String f28753x = "";

    /* renamed from: y  reason: collision with root package name */
    public String f28754y = "";

    /* renamed from: z  reason: collision with root package name */
    public long f28755z = 0;

    public f0(Context context, int i11) {
        this.f28730a = u.p(context);
        this.f28731b = u.e(context, "QHOPENSDK_APPKEY");
        this.f28732c = u.e(context, "QHOPENSDK_APPID");
        this.f28733d = u.e(context, "QHOPENSDK_CHANNEL");
        this.f28734e = u.v(context);
        this.f28735f = u.z(context);
        this.f28736g = u.B(context);
        this.f28738i = u.F(context);
        this.f28740k = u.c();
        this.f28741l = u.i();
        this.f28742m = u.l();
        this.f28745p = u.H(context);
        this.f28746q = u.J(context);
        this.f28747r = u.L(context);
        this.f28748s = u.u();
        this.f28749t = u.w();
        this.f28750u = u.y();
        this.f28737h = c0.g(context, "lastVersion", "");
        this.f28753x = u.O(context);
        this.f28754y = u.G();
        this.f28755z = u.a(context, this.f28753x, this.f28733d, this.f28734e);
        if (d.f28720l) {
            this.f28743n = u.o();
            this.f28744o = u.r();
            this.f28739j = u.x(context);
            this.f28751v = c0.e(context, "totalSession", 0);
            this.f28752w = c0.e(context, "todaySession", 0);
            this.A = i11;
        }
        this.B = "360pay";
        this.C = d.f28713e;
        this.D = u.Y(context);
        this.E = u.Z(context);
        this.F = d.f28711c;
        this.G = u.W(context);
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appName", this.f28730a);
            jSONObject.put("appKey", this.f28731b);
            jSONObject.put("appId", this.f28732c);
            jSONObject.put(AppsFlyerProperties.CHANNEL, this.f28733d);
            jSONObject.put("packname", this.f28734e);
            jSONObject.put("versionName", this.f28735f);
            jSONObject.put("versionCode", this.f28736g);
            if (!TextUtils.isEmpty(this.f28737h)) {
                jSONObject.put("lastVersion", this.f28737h);
            }
            jSONObject.put("netType", this.f28738i);
            jSONObject.put("language", this.f28740k);
            jSONObject.put(UserDataStore.COUNTRY, this.f28741l);
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, this.f28742m);
            jSONObject.put(VulcanInfo.IMEI, this.f28745p);
            jSONObject.put("operator", this.f28746q);
            jSONObject.put("screen", this.f28747r);
            jSONObject.put("manufacturer", this.f28748s);
            jSONObject.put("osVersion", this.f28749t);
            jSONObject.put("sdkVersion", "1.1.3.140801");
            jSONObject.put("payVersion", d.f28712d);
            jSONObject.put(q.f30469g, n0.f32119g);
            jSONObject.put("cpu", this.f28750u);
            jSONObject.put("rid", this.f28753x);
            jSONObject.put("tid", this.f28754y);
            jSONObject.put("ttimes", this.f28755z);
            if (d.f28720l) {
                if (!TextUtils.isEmpty(this.f28739j)) {
                    jSONObject.put("mac", this.f28739j);
                }
                jSONObject.put(VulcanInfo.BOARD, this.f28743n);
                jSONObject.put("brand", this.f28744o);
                jSONObject.put("totalSession", this.f28751v);
                jSONObject.put("todaySession", this.f28752w);
                jSONObject.put("sessionNum", this.A);
            }
            jSONObject.put("mTag", this.B);
            jSONObject.put("sTag", this.C);
            jSONObject.put("m1", this.D);
            jSONObject.put("m2", this.E);
            if (!TextUtils.isEmpty(this.F)) {
                jSONObject.put("qid", this.F);
            }
            jSONObject.put("ctime", this.G);
        } catch (Exception e11) {
            g0.b(H, e11);
        } catch (Error e12) {
            g0.a(H, e12);
        }
        return jSONObject;
    }
}
