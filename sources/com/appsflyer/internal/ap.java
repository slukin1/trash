package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;

public final class ap {
    public static void AFInAppEventParameterName(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (j.AFInAppEventType().AFInAppEventParameterName != null) {
            try {
                DeepLink valueOf = DeepLink.valueOf(map);
                valueOf.AFInAppEventParameterName.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(valueOf, (DeepLinkResult.Error) null);
            } catch (JSONException e11) {
                AFLogger.AFInAppEventParameterName("[DDL] Error occurred", (Throwable) e11);
                deepLinkResult = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.UNEXPECTED);
            } catch (Throwable th2) {
                AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null));
                throw th2;
            }
            AFInAppEventParameterName(deepLinkResult);
            return;
        }
        AFInAppEventType(map);
    }

    private static void AFInAppEventType(Map<String, String> map) {
        if (ae.valueOf != null) {
            try {
                StringBuilder sb2 = new StringBuilder("Calling onAppOpenAttribution with:\n");
                sb2.append(map.toString());
                AFLogger.values(sb2.toString());
                ae.valueOf.onAppOpenAttribution(map);
            } catch (Throwable th2) {
                AFLogger.AFInAppEventType(th2.getLocalizedMessage(), th2);
            }
        }
    }

    public static void valueOf(String str, DeepLinkResult.Error error) {
        if (j.AFInAppEventType().AFInAppEventParameterName != null) {
            AFLogger.values("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, error));
            return;
        }
        AFInAppEventType(str);
    }

    private static void AFInAppEventType(String str) {
        if (ae.valueOf != null) {
            try {
                AFLogger.values("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                ae.valueOf.onAttributionFailure(str);
            } catch (Throwable th2) {
                AFLogger.AFInAppEventType(th2.getLocalizedMessage(), th2);
            }
        }
    }

    public static void AFInAppEventParameterName(DeepLinkResult deepLinkResult) {
        if (j.AFInAppEventType().AFInAppEventParameterName != null) {
            StringBuilder sb2 = new StringBuilder("[DDL] Calling onDeepLinking with:\n");
            sb2.append(deepLinkResult.toString());
            AFLogger.values(sb2.toString());
            try {
                j.AFInAppEventType().AFInAppEventParameterName.onDeepLinking(deepLinkResult);
            } catch (Throwable th2) {
                AFLogger.AFInAppEventType(th2.getLocalizedMessage(), th2);
            }
        } else {
            AFLogger.values("[DDL] skipping, no callback registered");
        }
    }
}
