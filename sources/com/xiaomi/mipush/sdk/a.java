package com.xiaomi.mipush.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.coupon.bean.CouponReturn;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.gg;
import com.xiaomi.push.gq;
import com.xiaomi.push.gt;
import com.xiaomi.push.hf;
import com.xiaomi.push.j;
import com.xiaomi.push.service.an;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@TargetApi(14)
public class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f51295a = new HashSet();

    /* renamed from: a  reason: collision with other field name */
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, String>> f2445a = new ConcurrentHashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private final ScheduledExecutorService f2446a = Executors.newScheduledThreadPool(0);

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityPostResumed(Activity activity) {
        a(activity, "32");
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        a(activity, CouponReturn.TYPE_EXPERIENCE);
    }

    public void onActivityResumed(Activity activity) {
        try {
            Intent intent = activity.getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra("messageId");
                int intExtra = intent.getIntExtra("eventMessageType", -1);
                if (!TextUtils.isEmpty(stringExtra) && intExtra > 0 && !this.f51295a.contains(stringExtra)) {
                    this.f51295a.add(stringExtra);
                    if (intExtra == 3000) {
                        du.a(activity.getApplicationContext()).a(activity.getPackageName(), dt.a(intExtra), stringExtra, MTPushConstants.PlatformNode.CODE_GET_TOKEN_SUCCESS, (String) null);
                    } else if (intExtra == 1000) {
                        du.a(activity.getApplicationContext()).a(activity.getPackageName(), dt.a(intExtra), stringExtra, 1008, (String) null);
                    }
                }
            }
        } catch (Throwable th2) {
            b.d("An error occurred in onActivityResumed method: " + th2);
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public static void a(Context context) {
        a((Application) context.getApplicationContext());
    }

    private static void a(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }

    private void a(Activity activity, String str) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (activity == null || TextUtils.isEmpty(str)) {
            b.a("activity|type is null when record lifecycle");
            return;
        }
        final Context applicationContext = activity.getApplicationContext();
        final Intent intent = activity.getIntent();
        final ComponentName componentName = activity.getComponentName();
        if (applicationContext == null || intent == null || componentName == null) {
            b.a("ctx|intent|componentName is null when record lifecycle");
            return;
        }
        final String str2 = str;
        this.f2446a.submit(new Runnable() {
            public void run() {
                try {
                    if (a.this.a(applicationContext)) {
                        final String stringExtra = intent.getStringExtra("messageId");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            int i11 = 0;
                            if (intent.getBooleanExtra("mipush_notified", false)) {
                                boolean booleanExtra = intent.getBooleanExtra("pushTargetComponent", false);
                                ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) a.a(a.this).get(stringExtra);
                                if (concurrentHashMap == null) {
                                    concurrentHashMap = new ConcurrentHashMap();
                                    a.a(a.this).put(stringExtra, concurrentHashMap);
                                }
                                String a11 = a.this.a(componentName, str2);
                                if (TextUtils.isEmpty(a11)) {
                                    b.a("component Key is null when record lifecycle");
                                    return;
                                }
                                concurrentHashMap.put(a11, String.valueOf(currentTimeMillis));
                                boolean equals = TextUtils.equals(CouponReturn.TYPE_EXPERIENCE, str2);
                                int i12 = 5;
                                if (booleanExtra) {
                                    if (equals) {
                                        i11 = 3;
                                    }
                                    i12 = i11;
                                }
                                a.a(a.this).schedule(new Runnable() {
                                    public void run() {
                                        AnonymousClass1 r02 = AnonymousClass1.this;
                                        a.this.a(applicationContext, stringExtra);
                                    }
                                }, (long) i12, TimeUnit.SECONDS);
                            }
                        }
                    }
                } catch (Throwable th2) {
                    b.d("an error occurred in lifecycle event: " + th2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public String a(ComponentName componentName, String str) {
        if (componentName == null || TextUtils.isEmpty(str)) {
            b.a("component｜type is null when create component key");
            return null;
        }
        return componentName.hashCode() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + str;
    }

    /* access modifiers changed from: private */
    public void a(Context context, String str) {
        if (context == null) {
            try {
                b.a("ctx is null when report activity lifecycle");
            } catch (Throwable th2) {
                b.d("an error occurred in send lifecycle event : " + th2);
            }
        } else if (TextUtils.isEmpty(str)) {
            b.a("msgId is null when report activity lifecycle");
        } else {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                b.a("pkg is null when report activity lifecycle");
                return;
            }
            Map remove = this.f2445a.remove(str);
            if (remove == null) {
                return;
            }
            if (!remove.isEmpty()) {
                String a11 = b.a(context).a();
                hf hfVar = new hf(str, false);
                hfVar.c(gq.SDK_START_ACTIVITY_LIFECYCLE.f2942a);
                hfVar.b(a11);
                hfVar.d(packageName);
                HashMap hashMap = new HashMap();
                hfVar.f3081a = hashMap;
                hashMap.putAll(remove);
                u.a(context).a(hfVar, gg.Notification, false, false, (gt) null, true, packageName, a11, true, false, an.f52499p);
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    private boolean m2334a(Context context) {
        return !j.a(context) && j.a();
    }
}
