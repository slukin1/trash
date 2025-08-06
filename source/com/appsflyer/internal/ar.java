package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import org.json.JSONObject;

public final class ar {
    public static JSONObject AFKeystoreWrapper(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            try {
                boolean z11 = AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DPM, false);
                if (!jSONObject2.optBoolean("monitor", false) || z11) {
                    aj.valueOf().AFKeystoreWrapper();
                    aj.valueOf().AFInAppEventParameterName();
                } else {
                    aj.valueOf().values();
                }
                if (!jSONObject2.has("ol_id")) {
                    return jSONObject2;
                }
                String optString = jSONObject2.optString("ol_scheme", (String) null);
                String optString2 = jSONObject2.optString("ol_domain", (String) null);
                String optString3 = jSONObject2.optString("ol_ver", (String) null);
                if (optString != null) {
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_SCHEME, optString);
                }
                if (optString2 != null) {
                    AppsFlyerProperties.getInstance().set(AppsFlyerProperties.ONELINK_DOMAIN, optString2);
                }
                if (optString3 == null) {
                    return jSONObject2;
                }
                AppsFlyerProperties.getInstance().set("onelinkVersion", optString3);
                return jSONObject2;
            } catch (Throwable th2) {
                th = th2;
                jSONObject = jSONObject2;
                AFLogger.AFInAppEventType(th.getMessage(), th);
                aj.valueOf().AFKeystoreWrapper();
                aj.valueOf().AFInAppEventParameterName();
                return jSONObject;
            }
        } catch (Throwable th3) {
            th = th3;
            AFLogger.AFInAppEventType(th.getMessage(), th);
            aj.valueOf().AFKeystoreWrapper();
            aj.valueOf().AFInAppEventParameterName();
            return jSONObject;
        }
    }
}
