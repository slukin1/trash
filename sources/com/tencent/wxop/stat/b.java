package com.tencent.wxop.stat;

import com.facebook.appevents.UserDataStore;
import com.twitter.sdk.android.core.identity.AuthHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private long K = 0;
    private int L = 0;
    private String M = "";

    /* renamed from: c  reason: collision with root package name */
    private String f50986c = "";

    /* renamed from: g  reason: collision with root package name */
    private int f50987g = 0;

    public final void a(long j11) {
        this.K = j11;
    }

    public final JSONObject i() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.K);
            jSONObject.put(UserDataStore.STATE, this.f50987g);
            String str = this.f50986c;
            if (str != null) {
                jSONObject.put("dm", str);
            }
            jSONObject.put("pt", this.L);
            String str2 = this.M;
            if (str2 != null) {
                jSONObject.put("rip", str2);
            }
            jSONObject.put(AuthHandler.EXTRA_TOKEN_SECRET, System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final void k(String str) {
        this.M = str;
    }

    public final void setDomain(String str) {
        this.f50986c = str;
    }

    public final void setPort(int i11) {
        this.L = i11;
    }

    public final void setStatusCode(int i11) {
        this.f50987g = i11;
    }
}
