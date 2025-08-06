package com.tencent.wxop.stat.a;

import com.xiaomi.mipush.sdk.Constants;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public String f50931a;

    /* renamed from: bl  reason: collision with root package name */
    public JSONArray f50932bl;

    /* renamed from: bm  reason: collision with root package name */
    public JSONObject f50933bm = null;

    public b() {
    }

    public b(String str) {
        this.f50931a = str;
        this.f50933bm = new JSONObject();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            return toString().equals(((b) obj).toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder(32);
        sb2.append(this.f50931a);
        sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        JSONArray jSONArray = this.f50932bl;
        if (jSONArray != null) {
            sb2.append(jSONArray.toString());
        }
        JSONObject jSONObject = this.f50933bm;
        if (jSONObject != null) {
            sb2.append(jSONObject.toString());
        }
        return sb2.toString();
    }
}
