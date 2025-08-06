package com.qihoo.stat;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONObject;

public class h {

    /* renamed from: i  reason: collision with root package name */
    public static String f28760i = "BuyBean";

    /* renamed from: a  reason: collision with root package name */
    public String f28761a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f28762b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f28763c = -1;

    /* renamed from: d  reason: collision with root package name */
    public String f28764d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f28765e = "";

    /* renamed from: f  reason: collision with root package name */
    public int f28766f = -1;

    /* renamed from: g  reason: collision with root package name */
    public long f28767g = 0;

    /* renamed from: h  reason: collision with root package name */
    public String f28768h = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28761a)) {
                jSONObject.put("name", this.f28761a);
            }
            if (!TextUtils.isEmpty(this.f28762b)) {
                jSONObject.put("type", this.f28762b);
            }
            int i11 = this.f28763c;
            if (i11 >= 0) {
                jSONObject.put("number", i11);
            }
            if (!TextUtils.isEmpty(this.f28764d)) {
                jSONObject.put("method", this.f28764d);
            }
            if (!TextUtils.isEmpty(this.f28765e)) {
                jSONObject.put("coinType", this.f28765e);
            }
            int i12 = this.f28766f;
            if (i12 >= 0) {
                jSONObject.put("coin", i12);
            }
            long j11 = this.f28767g;
            if (j11 >= 0) {
                jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, j11);
            }
            if (!TextUtils.isEmpty(this.f28768h)) {
                jSONObject.put(FirebaseAnalytics.Param.LEVEL, this.f28768h);
            }
        } catch (Exception e11) {
            g0.b(f28760i, e11);
        } catch (Error e12) {
            g0.a(f28760i, e12);
        }
        return jSONObject;
    }
}
