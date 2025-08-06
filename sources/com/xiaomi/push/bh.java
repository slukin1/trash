package com.xiaomi.push;

import android.text.TextUtils;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import org.json.JSONObject;

public class bh extends JSONObject implements bf {

    /* renamed from: a  reason: collision with root package name */
    private static final int f51439a = 2;

    /* renamed from: b  reason: collision with root package name */
    private static final int f51440b = 3;

    /* renamed from: a  reason: collision with other field name */
    private final LinkedHashMap<String, Integer> f2553a = new LinkedHashMap<>();

    public int a() {
        int i11 = f51439a;
        for (Integer intValue : this.f2553a.values()) {
            i11 += intValue.intValue();
        }
        return i11 + (length() - 1);
    }

    public JSONObject put(String str, int i11) {
        if (!TextUtils.isEmpty(str)) {
            this.f2553a.put(str, Integer.valueOf(str.length() + String.valueOf(i11).length() + f51440b));
        }
        return super.put(str, i11);
    }

    public Object remove(String str) {
        this.f2553a.remove(str);
        return super.remove(str);
    }

    public JSONObject put(String str, long j11) {
        if (!TextUtils.isEmpty(str)) {
            this.f2553a.put(str, Integer.valueOf(str.length() + String.valueOf(j11).length() + f51440b));
        }
        return super.put(str, j11);
    }

    public JSONObject put(String str, double d11) {
        if (!TextUtils.isEmpty(str)) {
            this.f2553a.put(str, Integer.valueOf(str.length() + String.valueOf(d11).length() + f51440b));
        }
        return super.put(str, d11);
    }

    public JSONObject put(String str, Object obj) {
        JSONObject put = super.put(str, obj);
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (obj instanceof bf) {
                this.f2553a.put(str, Integer.valueOf(str.length() + ((bf) obj).a() + f51440b));
            } else {
                this.f2553a.put(str, Integer.valueOf(str.length() + String.valueOf(obj).getBytes(StandardCharsets.UTF_8).length + f51440b + f51439a));
            }
        }
        return put;
    }

    public JSONObject put(String str, boolean z11) {
        if (!TextUtils.isEmpty(str)) {
            this.f2553a.put(str, Integer.valueOf(str.length() + String.valueOf(z11).length() + f51440b));
        }
        return super.put(str, z11);
    }
}
