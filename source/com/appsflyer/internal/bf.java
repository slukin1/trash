package com.appsflyer.internal;

import android.content.Context;
import java.util.Map;

public abstract class bf extends g {
    public boolean onConversionDataFail;
    private final boolean onDeepLinkingNative;
    private final boolean onInstallConversionDataLoadedNative;

    public bf() {
        this((String) null, (String) null, (Boolean) null, (Boolean) null, (Boolean) null, (Context) null);
    }

    public String AFLogger$LogLevel() {
        return m.AFInAppEventType((Map<String, ?>) AFInAppEventType()).toString();
    }

    public final boolean AppsFlyer2dXConversionCallback() {
        return this.onConversionDataFail;
    }

    public final boolean getLevel() {
        return this.onInstallConversionDataLoadedNative;
    }

    public final boolean init() {
        return this.onDeepLinkingNative;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bf(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3, Context context) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false), context);
        boolean z11 = true;
        this.onDeepLinkingNative = bool != null ? bool.booleanValue() : true;
        this.onInstallConversionDataLoadedNative = bool2 != null ? bool2.booleanValue() : z11;
    }
}
