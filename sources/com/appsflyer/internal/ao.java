package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.sumsub.sentry.a;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

final class ao extends ak {
    private String AFLogger$LogLevel;
    private String AFVersionDeclaration;
    public boolean valueOf = false;
    public b values;

    public interface b {
        void AFInAppEventParameterName(String str);

        void AFInAppEventParameterName(Map<String, String> map);
    }

    public ao(Uri uri, ae aeVar, Context context) {
        super(aeVar, context, "GET");
        if (!TextUtils.isEmpty(uri.getHost()) && !TextUtils.isEmpty(uri.getPath())) {
            String[] strArr = {"onelink.me", "onelnk.com", "app.aflink.com"};
            boolean z11 = false;
            for (int i11 = 0; i11 < 3; i11++) {
                if (uri.getHost().contains(strArr[i11])) {
                    z11 = true;
                }
            }
            if (j.AppsFlyer2dXConversionCallback != null) {
                StringBuilder sb2 = new StringBuilder("Validate if link ");
                sb2.append(uri);
                sb2.append(" belongs to custom domains: ");
                sb2.append(Arrays.asList(j.AppsFlyer2dXConversionCallback));
                AFLogger.AFInAppEventParameterName(sb2.toString());
                for (String str : j.AppsFlyer2dXConversionCallback) {
                    if (uri.getHost().contains(str) && !TextUtils.isEmpty(str)) {
                        AFLogger.values("Link matches custom domain: ".concat(String.valueOf(str)));
                        this.valueOf = true;
                        z11 = true;
                    }
                }
            }
            String[] split = uri.getPath().split("/");
            if (z11 && split.length == 3) {
                this.AFKeystoreWrapper = split[1];
                this.AFVersionDeclaration = split[2];
                this.AFLogger$LogLevel = uri.toString();
            }
        }
    }

    public final void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) {
        httpsURLConnection.setRequestProperty("Af-UUID", this.AppsFlyer2dXConversionCallback);
        String valueOf2 = String.valueOf(this.getLevel.get("build_number"));
        httpsURLConnection.setRequestProperty("Af-Meta-Sdk-Ver", valueOf2);
        httpsURLConnection.setRequestProperty("Af-Meta-Counter", String.valueOf(this.getLevel.get("counter")));
        httpsURLConnection.setRequestProperty("Af-Meta-Model", String.valueOf(this.getLevel.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)));
        httpsURLConnection.setRequestProperty("Af-Meta-Platform", String.valueOf(this.getLevel.get("platformextension")));
        httpsURLConnection.setRequestProperty("Af-Meta-System-Version", String.valueOf(this.getLevel.get(ServerProtocol.DIALOG_PARAM_SDK_VERSION)));
        values(httpsURLConnection, this.AFInAppEventType, this.AppsFlyer2dXConversionCallback, this.AFKeystoreWrapper, this.AFVersionDeclaration, valueOf2);
    }

    public final void AFInAppEventType() {
        String str = this.AFLogger$LogLevel;
        if (str == null) {
            str = "Can't get OneLink data";
        }
        this.values.AFInAppEventParameterName(str);
    }

    public final boolean AFKeystoreWrapper() {
        return !TextUtils.isEmpty(this.AFKeystoreWrapper) && !TextUtils.isEmpty(this.AFVersionDeclaration) && !this.AFKeystoreWrapper.equals(a.f30241h);
    }

    public final void AFKeystoreWrapper(String str) {
        try {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.optString(next));
            }
            this.values.AFInAppEventParameterName((Map<String, String>) hashMap);
        } catch (JSONException e11) {
            this.values.AFInAppEventParameterName("Can't parse OneLink data");
            AFLogger.AFInAppEventType("Error while parsing to json ".concat(String.valueOf(str)), (Throwable) e11);
        }
    }

    public final String AFInAppEventParameterName() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format(ak.AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()}));
        sb2.append("/");
        sb2.append(this.AFKeystoreWrapper);
        sb2.append("?id=");
        sb2.append(this.AFVersionDeclaration);
        return sb2.toString();
    }
}
