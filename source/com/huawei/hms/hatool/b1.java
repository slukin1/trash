package com.huawei.hms.hatool;

import android.text.TextUtils;
import org.json.JSONObject;

public class b1 implements o1 {

    /* renamed from: a  reason: collision with root package name */
    private String f38129a;

    /* renamed from: b  reason: collision with root package name */
    private String f38130b;

    /* renamed from: c  reason: collision with root package name */
    private String f38131c;

    /* renamed from: d  reason: collision with root package name */
    private String f38132d;

    /* renamed from: e  reason: collision with root package name */
    private String f38133e;

    /* renamed from: f  reason: collision with root package name */
    private String f38134f;

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("type", this.f38129a);
        jSONObject.put("eventtime", this.f38132d);
        jSONObject.put("event", this.f38130b);
        jSONObject.put("event_session_name", this.f38133e);
        jSONObject.put("first_session_event", this.f38134f);
        if (TextUtils.isEmpty(this.f38131c)) {
            return null;
        }
        jSONObject.put("properties", new JSONObject(this.f38131c));
        return jSONObject;
    }

    public void a(String str) {
        this.f38131c = str;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.f38130b = jSONObject.optString("event");
            this.f38131c = n.a(jSONObject.optString("properties"), o0.d().a());
            this.f38129a = jSONObject.optString("type");
            this.f38132d = jSONObject.optString("eventtime");
            this.f38133e = jSONObject.optString("event_session_name");
            this.f38134f = jSONObject.optString("first_session_event");
        }
    }

    public String b() {
        return this.f38132d;
    }

    public void b(String str) {
        this.f38130b = str;
    }

    public String c() {
        return this.f38129a;
    }

    public void c(String str) {
        this.f38132d = str;
    }

    public JSONObject d() {
        JSONObject a11 = a();
        a11.put("properties", n.b(this.f38131c, o0.d().a()));
        return a11;
    }

    public void d(String str) {
        this.f38129a = str;
    }

    public void e(String str) {
        this.f38134f = str;
    }

    public void f(String str) {
        this.f38133e = str;
    }
}
