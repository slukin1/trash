package com.tencent.liteav.base.util;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.Log;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class i implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private static final s<Boolean> f21536a = new s<>(j.a());

    /* renamed from: b  reason: collision with root package name */
    private volatile WeakReference<Activity> f21537b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f21538c;

    /* renamed from: d  reason: collision with root package name */
    private volatile a f21539d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<Integer> f21540e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Integer> f21541f;

    public interface a {
        void a(boolean z11);
    }

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final i f21542a = new i((byte) 0);
    }

    public /* synthetic */ i(byte b11) {
        this();
    }

    public static void a(boolean z11) {
        f21536a.a(Boolean.valueOf(z11));
    }

    public final synchronized boolean b() {
        return this.f21538c;
    }

    public final Activity c() {
        WeakReference<Activity> weakReference = this.f21537b;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public final synchronized void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final synchronized void onActivityDestroyed(Activity activity) {
        Log.i("ProcessLifecycleOwner", "onActivityDestroyed, activity=".concat(String.valueOf(activity)), new Object[0]);
    }

    public final synchronized void onActivityPaused(Activity activity) {
        this.f21541f.add(Integer.valueOf(activity.hashCode()));
    }

    public final synchronized void onActivityResumed(Activity activity) {
        b(activity);
    }

    public final synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final synchronized void onActivityStarted(Activity activity) {
        b(activity);
    }

    public final synchronized void onActivityStopped(Activity activity) {
        int hashCode = activity.hashCode();
        boolean z11 = true;
        if (this.f21540e.contains(Integer.valueOf(hashCode))) {
            this.f21540e.remove(Integer.valueOf(hashCode));
            if (this.f21540e.size() != 0) {
                z11 = false;
            }
            b(z11);
        } else if (this.f21540e.size() != 0) {
            b(false);
        } else if (this.f21541f.contains(Integer.valueOf(hashCode))) {
            b(true);
        }
        this.f21541f.remove(Integer.valueOf(hashCode));
    }

    private i() {
        this.f21537b = null;
        this.f21540e = new HashSet();
        this.f21541f = new HashSet();
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            Log.e("ProcessLifecycleOwner", "ProcessStateOwner init failed. Context is null", new Object[0]);
            return;
        }
        ((Application) applicationContext.getApplicationContext()).registerActivityLifecycleCallbacks(this);
        this.f21538c = f21536a.a().booleanValue();
    }

    public static i a() {
        return b.f21542a;
    }

    private synchronized void b(boolean z11) {
        if (this.f21538c != z11) {
            this.f21538c = z11;
            if (this.f21539d != null) {
                this.f21539d.a(this.f21538c);
            }
        }
    }

    public final synchronized void a(Activity activity) {
        if (activity != null) {
            if (c() != null) {
                Log.i("ProcessLifecycleOwner", "activity is exists, don't need activity from user", new Object[0]);
                return;
            }
            this.f21537b = new WeakReference<>(activity);
            Log.i("ProcessLifecycleOwner", "update activity to " + activity + " from user", new Object[0]);
        }
    }

    private void b(Activity activity) {
        this.f21540e.add(Integer.valueOf(activity.hashCode()));
        this.f21537b = new WeakReference<>(activity);
        b(false);
        Log.i("ProcessLifecycleOwner", "update activity to ".concat(String.valueOf(activity)), new Object[0]);
    }

    public final synchronized void a(a aVar) {
        this.f21539d = aVar;
    }

    private static boolean a(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                Log.e("ProcessLifecycleOwner", "activityManager is null.", new Object[0]);
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                Log.e("ProcessLifecycleOwner", "processInfoList is null.", new Object[0]);
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.importance == 100 && context.getPackageName().equals(next.processName)) {
                    return false;
                }
            }
            return true;
        } catch (Exception e11) {
            Log.e("ProcessLifecycleOwner", "Get App background state failed. ".concat(String.valueOf(e11)), new Object[0]);
            return false;
        }
    }
}
