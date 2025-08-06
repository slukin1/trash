package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import java.util.HashMap;
import java.util.Map;

public abstract class g {
    public String AFInAppEventParameterName;
    public final Map<String, Object> AFInAppEventType;
    public AppsFlyerRequestListener AFKeystoreWrapper;
    public String AFLogger$LogLevel;
    public String AFVersionDeclaration;
    public byte[] AppsFlyer2dXConversionCallback;
    public String getLevel;
    public String init;
    public String onAppOpenAttributionNative;
    public boolean onAttributionFailureNative;
    private final boolean onDeepLinkingNative;
    public int onInstallConversionFailureNative;
    public Application valueOf;
    public Map<String, Object> values;

    public g() {
        this((String) null, (String) null, (Boolean) null, (Context) null);
    }

    public g AFInAppEventParameterName(String str) {
        this.onAppOpenAttributionNative = str;
        return this;
    }

    public final Map<String, Object> AFInAppEventType() {
        return this.AFInAppEventType;
    }

    public final boolean AFKeystoreWrapper() {
        return this.onAttributionFailureNative;
    }

    public final g valueOf(Map<String, ?> map) {
        this.AFInAppEventType.putAll(map);
        return this;
    }

    public final boolean values() {
        return this.onDeepLinkingNative;
    }

    public g(String str, String str2, Boolean bool, Context context) {
        this.AFInAppEventType = new HashMap();
        this.AFLogger$LogLevel = str;
        this.onAppOpenAttributionNative = str2;
        this.onDeepLinkingNative = bool != null ? bool.booleanValue() : true;
        if (context != null) {
            this.valueOf = (Application) context.getApplicationContext();
        }
    }

    public final byte[] AFInAppEventParameterName() {
        return this.AppsFlyer2dXConversionCallback;
    }

    public final String AFKeystoreWrapper(String str) {
        String valueOf2 = ae.values().valueOf((Context) this.valueOf);
        return valueOf2 != null ? Uri.parse(str).buildUpon().appendQueryParameter(AppsFlyerProperties.CHANNEL, valueOf2).build().toString() : str;
    }
}
