package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public final class ba {
    public static Map<String, Object> valueOf(String str) {
        HashMap hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (!next.equals("is_cache")) {
                    hashMap.put(next, jSONObject.isNull(next) ? null : jSONObject.get(next));
                }
            }
            return hashMap;
        } catch (JSONException e11) {
            AFLogger.AFInAppEventType(e11.getMessage(), (Throwable) e11);
            return null;
        }
    }

    public static void values(ae aeVar, g gVar, String str, Context context, SharedPreferences sharedPreferences, Integer num, Throwable th2) {
        ae aeVar2 = aeVar;
        Context context2 = context;
        SharedPreferences sharedPreferences2 = sharedPreferences;
        if (gVar.AFKeystoreWrapper()) {
            if (ae.valueOf == null) {
                AFLogger.values("[GCD-E01] AppsFlyerConversionListener is null - skip gcd");
                return;
            }
            StringBuilder sb2 = new StringBuilder("[GCD-A01] Loading conversion data. Counter: ");
            sb2.append(gVar.onInstallConversionFailureNative);
            AFLogger.values(sb2.toString());
            long j11 = sharedPreferences2.getLong("appsflyerConversionDataCacheExpiration", 0);
            if (j11 != 0 && System.currentTimeMillis() - j11 > 5184000000L) {
                AFLogger.values("[GCD-E02] Cached conversion data expired");
                ae.valueOf(context2, "sixtyDayConversionData");
                ae.AFKeystoreWrapper(context2, "attributionId", (String) null);
                aeVar.valueOf(context2, "appsflyerConversionDataCacheExpiration", 0);
            }
            if (sharedPreferences2.getString("attributionId", (String) null) != null) {
                if (ae.valueOf(sharedPreferences2, "appsFlyerCount", false) > 1) {
                    try {
                        Map<String, Object> values = values(context);
                        if (values != null) {
                            try {
                                if (!values.containsKey("is_first_launch")) {
                                    values.put("is_first_launch", Boolean.FALSE);
                                }
                                ay.AFInAppEventType(values);
                            } catch (Throwable th3) {
                                AFLogger.AFInAppEventType(th3.getLocalizedMessage(), th3);
                            }
                        }
                    } catch (az e11) {
                        AFLogger.AFInAppEventType(e11.getMessage(), (Throwable) e11);
                    }
                }
            } else if (th2 != null) {
                StringBuilder sb3 = new StringBuilder("Launch exception: ");
                sb3.append(th2.getMessage());
                ay.AFInAppEventParameterName(sb3.toString());
            } else if (num.intValue() != 200) {
                ay.AFInAppEventParameterName("Launch status code: ".concat(String.valueOf(num)));
            } else {
                ay ayVar = new ay(aeVar, (Application) context.getApplicationContext(), str);
                ae.AFInAppEventType(ayVar.AFInAppEventType, ayVar, 10, TimeUnit.MILLISECONDS);
            }
        }
    }

    public static Map<String, Object> values(Context context) throws az {
        String string = ae.values(context).getString("attributionId", (String) null);
        if (string != null && string.length() > 0) {
            return valueOf(string);
        }
        throw new az();
    }
}
