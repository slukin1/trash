package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class g0 {

    /* renamed from: c  reason: collision with root package name */
    private static g0 f38154c;

    /* renamed from: a  reason: collision with root package name */
    private Context f38155a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f38156b = new Object();

    private g0() {
    }

    public static g0 a() {
        if (f38154c == null) {
            b();
        }
        return f38154c;
    }

    private JSONObject a(Map<String, String> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    jSONObject.put((String) next.getKey(), next.getValue());
                }
            } catch (JSONException unused) {
                v.b("hmsSdk", "Exception occured when transferring bundle to json");
            }
        }
        return jSONObject;
    }

    private static synchronized void b() {
        synchronized (g0.class) {
            if (f38154c == null) {
                f38154c = new g0();
            }
        }
    }

    public void a(Context context) {
        synchronized (this.f38156b) {
            if (this.f38155a == null) {
                this.f38155a = context;
                e.a().a(context);
            }
        }
    }

    public void a(String str, int i11) {
        e.a().a(str, i11);
    }

    public void a(String str, int i11, String str2, LinkedHashMap<String, String> linkedHashMap) {
        e.a().a(str, i11, str2, a((Map<String, String>) linkedHashMap));
    }

    public void a(String str, Context context, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("_constants", str3);
            e.a().a(str, 0, str2, jSONObject);
        } catch (JSONException unused) {
            v.f("hmsSdk", "onEvent():JSON structure Exception!");
        }
    }

    public void b(String str, int i11, String str2, LinkedHashMap<String, String> linkedHashMap) {
        String str3 = str;
        int i12 = i11;
        String str4 = str2;
        e.a().a(str3, i12, str4, a((Map<String, String>) linkedHashMap), System.currentTimeMillis());
    }
}
