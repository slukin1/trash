package com.qihoo.stat;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONObject;

public class p {

    /* renamed from: g  reason: collision with root package name */
    public static String f28829g = "UseBean";

    /* renamed from: a  reason: collision with root package name */
    public String f28830a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f28831b = "";

    /* renamed from: c  reason: collision with root package name */
    public int f28832c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f28833d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f28834e = 0;

    /* renamed from: f  reason: collision with root package name */
    public String f28835f = "";

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f28830a)) {
                jSONObject.put("name", this.f28830a);
            }
            if (!TextUtils.isEmpty(this.f28831b)) {
                jSONObject.put("type", this.f28831b);
            }
            int i11 = this.f28832c;
            if (i11 >= 0) {
                jSONObject.put("number", i11);
            }
            int i12 = this.f28833d;
            if (i12 >= 0) {
                jSONObject.put("coin", i12);
            }
            long j11 = this.f28834e;
            if (j11 >= 0) {
                jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, j11);
            }
            if (!TextUtils.isEmpty(this.f28835f)) {
                jSONObject.put(FirebaseAnalytics.Param.LEVEL, this.f28835f);
            }
        } catch (Exception e11) {
            g0.b(f28829g, e11);
        } catch (Error e12) {
            g0.a(f28829g, e12);
        }
        return jSONObject;
    }
}
