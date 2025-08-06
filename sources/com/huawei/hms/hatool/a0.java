package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class a0 implements g {

    /* renamed from: a  reason: collision with root package name */
    private Context f38108a = q0.i();

    /* renamed from: b  reason: collision with root package name */
    private String f38109b;

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f38110c;

    /* renamed from: d  reason: collision with root package name */
    private String f38111d;

    /* renamed from: e  reason: collision with root package name */
    private String f38112e;

    /* renamed from: f  reason: collision with root package name */
    private String f38113f;

    /* renamed from: g  reason: collision with root package name */
    private String f38114g;

    /* renamed from: h  reason: collision with root package name */
    private Boolean f38115h;

    public a0(String str, JSONObject jSONObject, String str2, String str3, long j11) {
        this.f38109b = str;
        this.f38110c = jSONObject;
        this.f38111d = str2;
        this.f38112e = str3;
        this.f38113f = String.valueOf(j11);
        if (z.i(str2, "oper")) {
            p0 a11 = y.a().a(str2, j11);
            this.f38114g = a11.a();
            this.f38115h = Boolean.valueOf(a11.b());
        }
    }

    public void run() {
        JSONArray jSONArray;
        v.c("hmsSdk", "Begin to run EventRecordTask...");
        int h11 = q0.h();
        int k11 = a1.k(this.f38111d, this.f38112e);
        if (c0.a(this.f38108a, "stat_v2_1", h11 * 1048576)) {
            v.c("hmsSdk", "stat sp file reach max limited size, discard new event");
            e.a().a("", "alltype");
            return;
        }
        b1 b1Var = new b1();
        b1Var.b(this.f38109b);
        b1Var.a(this.f38110c.toString());
        b1Var.d(this.f38112e);
        b1Var.c(this.f38113f);
        b1Var.f(this.f38114g);
        Boolean bool = this.f38115h;
        b1Var.e(bool == null ? null : String.valueOf(bool));
        try {
            JSONObject d11 = b1Var.d();
            String a11 = n1.a(this.f38111d, this.f38112e);
            String a12 = d.a(this.f38108a, "stat_v2_1", a11, "");
            try {
                jSONArray = !TextUtils.isEmpty(a12) ? new JSONArray(a12) : new JSONArray();
            } catch (JSONException unused) {
                v.d("hmsSdk", "Cached data corrupted: stat_v2_1");
                jSONArray = new JSONArray();
            }
            jSONArray.put(d11);
            d.b(this.f38108a, "stat_v2_1", a11, jSONArray.toString());
            if (jSONArray.toString().length() > k11 * 1024) {
                e.a().a(this.f38111d, this.f38112e);
            }
        } catch (JSONException unused2) {
            v.e("hmsSdk", "eventRecord toJson error! The record failed.");
        }
    }
}
