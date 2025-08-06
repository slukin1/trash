package com.appsflyer;

import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class AppsFlyer2dXConversionCallback implements AppsFlyerConversionListener, DeepLinkListener {
    private void AFInAppEventType(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", LoginLogger.EVENT_EXTRAS_FAILURE);
            jSONObject.put("data", str2);
            char c11 = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1390007222) {
                if (hashCode == 1050716216) {
                    if (str.equals("onInstallConversionFailure")) {
                        c11 = 0;
                    }
                }
            } else if (str.equals("onAttributionFailure")) {
                c11 = 1;
            }
            if (c11 == 0) {
                onInstallConversionFailureNative(jSONObject);
            } else if (c11 == 1) {
                onAttributionFailureNative(jSONObject);
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public void onAppOpenAttribution(Map<String, String> map) {
        onAppOpenAttributionNative(map);
    }

    public native void onAppOpenAttributionNative(Object obj);

    public void onAttributionFailure(String str) {
        AFInAppEventType("onInstallConversionFailure", str);
    }

    public native void onAttributionFailureNative(Object obj);

    public void onConversionDataFail(String str) {
        AFInAppEventType("onAttributionFailure", str);
    }

    public void onConversionDataSuccess(Map<String, Object> map) {
        onInstallConversionDataLoadedNative(map);
    }

    public void onDeepLinking(DeepLinkResult deepLinkResult) {
        onDeepLinkingNative(deepLinkResult);
    }

    public native void onDeepLinkingNative(DeepLinkResult deepLinkResult);

    public native void onInstallConversionDataLoadedNative(Object obj);

    public native void onInstallConversionFailureNative(Object obj);
}
