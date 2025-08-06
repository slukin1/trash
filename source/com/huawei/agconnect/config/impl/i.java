package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.huawei.agconnect.config.ConfigReader;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class i implements ConfigReader {

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f37514a;

    public i(InputStream inputStream, String str) {
        this.f37514a = a(inputStream);
        a(str);
    }

    private JSONObject a(InputStream inputStream) {
        String str;
        if (inputStream != null) {
            try {
                return new JSONObject(Utils.toString(inputStream, "UTF-8"));
            } catch (IOException unused) {
                str = "IOException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            } catch (JSONException unused2) {
                str = "JSONException when reading the 'Config' from InputStream.";
                Log.e("InputStreamReader", str);
                return new JSONObject();
            }
        }
        return new JSONObject();
    }

    private void a(String str) {
        try {
            JSONObject b11 = b(str);
            if (b11 != null) {
                String string = getString("/configuration_version", "");
                BigDecimal bigDecimal = new BigDecimal(IdManager.DEFAULT_VERSION_NAME);
                try {
                    bigDecimal = BigDecimal.valueOf(Double.parseDouble(string));
                } catch (NumberFormatException unused) {
                    Log.d("InputStreamReader", "configuration_version to double error");
                }
                if (bigDecimal.compareTo(new BigDecimal("2.0")) == 0) {
                    this.f37514a.getJSONObject("client").put("app_id", b11.getString("app_id"));
                } else if (bigDecimal.compareTo(new BigDecimal("3.0")) >= 0) {
                    Iterator<String> keys = b11.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!Constants.PACKAGE_NAME.equals(next)) {
                            a(next, b11.get(next), this.f37514a);
                        }
                    }
                }
            }
        } catch (JSONException unused2) {
            Log.d("InputStreamReader", "JSONException when reading the 'appInfos' from InputStream.");
        }
    }

    private void a(String str, Object obj, JSONObject jSONObject) throws JSONException {
        if (str != null && obj != null && jSONObject != null) {
            if (obj instanceof JSONObject) {
                JSONObject jSONObject2 = (JSONObject) obj;
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    a(next, jSONObject2.get(next), jSONObject.getJSONObject(str));
                }
                return;
            }
            jSONObject.put(str, obj);
        }
    }

    private JSONObject b(String str) throws JSONException {
        JSONArray jSONArray = this.f37514a.getJSONArray("appInfos");
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i11);
            if (jSONObject.getString(Constants.PACKAGE_NAME).equals(str)) {
                return jSONObject;
            }
        }
        return null;
    }

    public String getString(String str, String str2) {
        if (str.endsWith("/")) {
            return str2;
        }
        String[] split = str.split("/");
        try {
            JSONObject jSONObject = this.f37514a;
            for (int i11 = 1; i11 < split.length; i11++) {
                if (i11 == split.length - 1) {
                    return jSONObject.get(split[i11]).toString();
                }
                jSONObject = jSONObject.getJSONObject(split[i11]);
            }
        } catch (JSONException unused) {
            Log.w("InputStreamReader", "JSONException when reading 'path': " + str);
        }
        return str2;
    }

    public String toString() {
        return "InputStreamReader{config=" + this.f37514a.toString().hashCode() + '}';
    }
}
