package com.qihoo.stat;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONObject;

public class l {

    /* renamed from: j  reason: collision with root package name */
    public static String f28794j = "PayBean";

    /* renamed from: a  reason: collision with root package name */
    public int f28795a = -1;

    /* renamed from: b  reason: collision with root package name */
    public String f28796b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f28797c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f28798d = "";

    /* renamed from: e  reason: collision with root package name */
    public int f28799e = -1;

    /* renamed from: f  reason: collision with root package name */
    public int f28800f = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f28801g = "";

    /* renamed from: h  reason: collision with root package name */
    public String f28802h = "";

    /* renamed from: i  reason: collision with root package name */
    public long f28803i = -1;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            int i11 = this.f28795a;
            if (i11 >= 0) {
                jSONObject.put("cash", i11);
            }
            if (!TextUtils.isEmpty(this.f28796b)) {
                jSONObject.put("cashType", this.f28796b);
            }
            int i12 = this.f28797c;
            if (i12 >= 0) {
                jSONObject.put("coin", i12);
            }
            if (!TextUtils.isEmpty(this.f28798d)) {
                jSONObject.put("props", this.f28798d);
            }
            int i13 = this.f28799e;
            if (i13 >= 0) {
                jSONObject.put("number", i13);
            }
            int i14 = this.f28800f;
            if (i14 >= 0) {
                jSONObject.put("source", i14);
            }
            if (!TextUtils.isEmpty(this.f28801g)) {
                jSONObject.put(FirebaseAnalytics.Param.LEVEL, this.f28801g);
            }
            if (!TextUtils.isEmpty(this.f28802h)) {
                jSONObject.put("rank", this.f28802h);
            }
            long j11 = this.f28803i;
            if (j11 >= 0) {
                jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, j11);
            }
        } catch (Exception e11) {
            g0.b(f28794j, e11);
        } catch (Error e12) {
            g0.a(f28794j, e12);
        }
        return jSONObject;
    }
}
