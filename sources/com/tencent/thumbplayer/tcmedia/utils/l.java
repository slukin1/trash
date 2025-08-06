package com.tencent.thumbplayer.tcmedia.utils;

import android.text.TextUtils;
import com.tencent.thumbplayer.tcmedia.common.a.a;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

public class l implements a {

    /* renamed from: a  reason: collision with root package name */
    public final Properties f49718a;

    public l() {
        this((Properties) null);
    }

    public l(Properties properties) {
        this.f49718a = new Properties();
        if (properties != null) {
            for (Map.Entry entry : properties.entrySet()) {
                a((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public Properties a() {
        return this.f49718a;
    }

    public void a(String str, float f11) {
        if (str != null) {
            this.f49718a.put(str, String.valueOf(f11));
        }
    }

    public void a(String str, int i11) {
        if (str != null) {
            this.f49718a.put(str, String.valueOf(i11));
        }
    }

    public void a(String str, long j11) {
        if (str != null) {
            this.f49718a.put(str, String.valueOf(j11));
        }
    }

    public void a(String str, String str2) {
        if (str == null) {
            return;
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f49718a.put(str, str2);
        } else {
            this.f49718a.put(str, "");
        }
    }

    public void a(Map<String, String> map) {
        if (map != null) {
            for (Map.Entry entry : this.f49718a.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null) {
                    map.put(key.toString(), "");
                } else {
                    map.put(key.toString(), value.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("map must not be null!");
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject(this.f49718a);
        if (jSONObject.has("data")) {
            try {
                String string = jSONObject.getString("data");
                jSONObject.remove("data");
                jSONObject.put("data", new JSONObject(string));
            } catch (JSONException e11) {
                TPLogUtil.e("TPProperties", (Throwable) e11);
            }
        }
        return jSONObject.toString();
    }
}
