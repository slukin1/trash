package com.engagelab.privates.common.business.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;

@TargetApi(14)
public class MTLifecycleListener implements Application.ActivityLifecycleCallbacks {
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString("activity", activity.getComponentName().getClassName());
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), 1011, bundle2);
    }

    public void onActivityDestroyed(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), 1016, bundle);
    }

    public void onActivityPaused(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), 1014, bundle);
    }

    public void onActivityResumed(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), 1013, bundle);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        bundle.putBoolean("state", true);
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), 1008, bundle);
    }

    public void onActivityStopped(Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("activity", activity.getComponentName().getClassName());
        bundle.putBoolean("state", false);
        MTCommonPrivatesApi.sendMessageToMainProcess(activity.getApplicationContext(), 1008, bundle);
    }
}
