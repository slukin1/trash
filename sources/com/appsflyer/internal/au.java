package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public final class au {
    public final Application AFKeystoreWrapper;
    public final SharedPreferences valueOf;

    public au(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.AFKeystoreWrapper = application;
        this.valueOf = ae.values((Context) application);
    }

    public final boolean AFInAppEventType() {
        ae.values();
        if (ae.valueOf(this.valueOf, "appsFlyerCount", false) == 0) {
            return true;
        }
        return false;
    }
}
