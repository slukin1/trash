package com.zopim.android.sdk.api;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import com.zopim.android.sdk.api.ZopimChatApi;

class AppLifeCycleHandler implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {
    private String accountKey;
    private Context appContext;
    private boolean appInForeground = true;
    private String machineId;

    public AppLifeCycleHandler(Context context) {
        this.appContext = context;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
        if (!this.appInForeground) {
            this.appInForeground = true;
            ChatService.startService(this.appContext, ChatSession.ACTION_CHAT_APP_FOREGROUND, this.accountKey, this.machineId, (ZopimChatApi.SessionApiConfig) null);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onConfigurationChanged(Configuration configuration) {
    }

    public void onLowMemory() {
    }

    public void onTrimMemory(int i11) {
        if (i11 == 20) {
            this.appInForeground = false;
            ChatService.startService(this.appContext, ChatSession.ACTION_CHAT_APP_BACKGROUND, this.accountKey, this.machineId, (ZopimChatApi.SessionApiConfig) null);
        }
    }

    public void setup(String str, String str2) {
        this.accountKey = str;
        this.machineId = str2;
    }
}
