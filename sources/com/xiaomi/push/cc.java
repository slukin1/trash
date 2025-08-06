package com.xiaomi.push;

import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONObject;

public class cc {

    /* renamed from: a  reason: collision with root package name */
    private int f51478a;

    /* renamed from: a  reason: collision with other field name */
    private long f2591a;

    /* renamed from: a  reason: collision with other field name */
    private String f2592a;

    /* renamed from: b  reason: collision with root package name */
    private long f51479b;

    /* renamed from: c  reason: collision with root package name */
    private long f51480c;

    public cc() {
        this(0, 0, 0, (Exception) null);
    }

    public int a() {
        return this.f51478a;
    }

    public cc(int i11, long j11, long j12, Exception exc) {
        this.f51478a = i11;
        this.f2591a = j11;
        this.f51480c = j12;
        this.f51479b = System.currentTimeMillis();
        if (exc != null) {
            this.f2592a = exc.getClass().getSimpleName();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public JSONObject m2472a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("cost", this.f2591a);
        jSONObject.put("size", this.f51480c);
        jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, this.f51479b);
        jSONObject.put("wt", this.f51478a);
        jSONObject.put("expt", this.f2592a);
        return jSONObject;
    }

    public cc a(JSONObject jSONObject) {
        this.f2591a = jSONObject.getLong("cost");
        this.f51480c = jSONObject.getLong("size");
        this.f51479b = jSONObject.getLong(AuthHandler.EXTRA_TOKEN_SECRET);
        this.f51478a = jSONObject.getInt("wt");
        this.f2592a = jSONObject.optString("expt");
        return this;
    }
}
