package com.sensorsdata.analytics.android.advert.monitor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.sensorsdata.analytics.android.advert.deeplink.DeepLinkManager;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsDataActivityLifecycleCallbacks;

public class SensorsDataAdvertActivityLifeCallback implements SensorsDataActivityLifecycleCallbacks.SAActivityLifecycleCallbacks {
    private SAConfigOptions mOptions;

    public SensorsDataAdvertActivityLifeCallback(SAConfigOptions sAConfigOptions) {
        this.mOptions = sAConfigOptions;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        DeepLinkManager.parseDeepLink(activity, this.mOptions.isSaveDeepLinkInfo());
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onNewIntent(Intent intent) {
    }
}
