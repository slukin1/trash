package com.xiaomi.push;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

public class df implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private Context f51585a;

    /* renamed from: a  reason: collision with other field name */
    private String f2670a = "";

    /* renamed from: b  reason: collision with root package name */
    private String f51586b;

    public df(Context context, String str) {
        this.f51585a = context;
        this.f2670a = str;
    }

    private void a(String str) {
        go goVar = new go();
        goVar.a(str);
        goVar.a(System.currentTimeMillis());
        goVar.a(gi.ActivityActiveTimeStamp);
        dm.a(this.f51585a, goVar);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (!TextUtils.isEmpty(this.f2670a) && !TextUtils.isEmpty(localClassName)) {
            this.f51586b = "";
            if (TextUtils.isEmpty("") || TextUtils.equals(this.f51586b, localClassName)) {
                a(this.f51585a.getPackageName() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + localClassName + ":" + this.f2670a + Constants.ACCEPT_TIME_SEPARATOR_SP + String.valueOf(System.currentTimeMillis() / 1000));
                this.f2670a = "";
                this.f51586b = "";
                return;
            }
            this.f2670a = "";
        }
    }

    public void onActivityResumed(Activity activity) {
        if (TextUtils.isEmpty(this.f51586b)) {
            this.f51586b = activity.getLocalClassName();
        }
        this.f2670a = String.valueOf(System.currentTimeMillis() / 1000);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }
}
