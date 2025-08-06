package com.blankj.utilcode.util;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.Utils;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class z implements Application.ActivityLifecycleCallbacks {

    /* renamed from: h  reason: collision with root package name */
    public static final z f63546h = new z();

    /* renamed from: i  reason: collision with root package name */
    public static final Activity f63547i = new Activity();

    /* renamed from: b  reason: collision with root package name */
    public final LinkedList<Activity> f63548b = new LinkedList<>();

    /* renamed from: c  reason: collision with root package name */
    public final List<Utils.b> f63549c = new CopyOnWriteArrayList();

    /* renamed from: d  reason: collision with root package name */
    public final Map<Activity, List<Utils.ActivityLifecycleCallbacks>> f63550d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public int f63551e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f63552f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f63553g = false;

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f63554b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Utils.ActivityLifecycleCallbacks f63555c;

        public a(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            this.f63554b = activity;
            this.f63555c = activityLifecycleCallbacks;
        }

        public void run() {
            z.this.e(this.f63554b, this.f63555c);
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f63557b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Utils.ActivityLifecycleCallbacks f63558c;

        public b(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            this.f63557b = activity;
            this.f63558c = activityLifecycleCallbacks;
        }

        public void run() {
            z.this.u(this.f63557b, this.f63558c);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Activity f63560b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f63561c;

        public c(Activity activity, Object obj) {
            this.f63560b = activity;
            this.f63561c = obj;
        }

        public void run() {
            try {
                Window window = this.f63560b.getWindow();
                if (window != null) {
                    window.setSoftInputMode(((Integer) this.f63561c).intValue());
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void v() {
        if (Build.VERSION.SDK_INT < 26 || !ValueAnimator.areAnimatorsEnabled()) {
            try {
                Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
                declaredField.setAccessible(true);
                if (((Float) declaredField.get((Object) null)).floatValue() == 0.0f) {
                    declaredField.set((Object) null, Float.valueOf(1.0f));
                    Log.i("UtilsActivityLifecycle", "setAnimatorsEnabled: Animators are enabled now!");
                }
            } catch (NoSuchFieldException e11) {
                e11.printStackTrace();
            } catch (IllegalAccessException e12) {
                e12.printStackTrace();
            }
        }
    }

    public void c(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activity != null && activityLifecycleCallbacks != null) {
            a0.I(new a(activity, activityLifecycleCallbacks));
        }
    }

    public void d(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        c(f63547i, activityLifecycleCallbacks);
    }

    public final void e(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        List list = this.f63550d.get(activity);
        if (list == null) {
            list = new CopyOnWriteArrayList();
            this.f63550d.put(activity, list);
        } else if (list.contains(activityLifecycleCallbacks)) {
            return;
        }
        list.add(activityLifecycleCallbacks);
    }

    public final void f(Activity activity, Lifecycle.Event event) {
        g(activity, event, this.f63550d.get(activity));
        g(activity, event, this.f63550d.get(f63547i));
    }

    public final void g(Activity activity, Lifecycle.Event event, List<Utils.ActivityLifecycleCallbacks> list) {
        if (list != null) {
            for (Utils.ActivityLifecycleCallbacks next : list) {
                next.g(activity, event);
                if (event.equals(Lifecycle.Event.ON_CREATE)) {
                    next.a(activity);
                } else if (event.equals(Lifecycle.Event.ON_START)) {
                    next.e(activity);
                } else if (event.equals(Lifecycle.Event.ON_RESUME)) {
                    next.d(activity);
                } else if (event.equals(Lifecycle.Event.ON_PAUSE)) {
                    next.c(activity);
                } else if (event.equals(Lifecycle.Event.ON_STOP)) {
                    next.f(activity);
                } else if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                    next.b(activity);
                }
            }
            if (event.equals(Lifecycle.Event.ON_DESTROY)) {
                this.f63550d.remove(activity);
            }
        }
    }

    public final List<Activity> h() {
        LinkedList linkedList = new LinkedList();
        Activity activity = null;
        try {
            Object j11 = j();
            Field declaredField = j11.getClass().getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(j11);
            if (!(obj instanceof Map)) {
                return linkedList;
            }
            for (Object next : ((Map) obj).values()) {
                Class<?> cls = next.getClass();
                Field declaredField2 = cls.getDeclaredField("activity");
                declaredField2.setAccessible(true);
                Activity activity2 = (Activity) declaredField2.get(next);
                if (activity == null) {
                    Field declaredField3 = cls.getDeclaredField("paused");
                    declaredField3.setAccessible(true);
                    if (!declaredField3.getBoolean(next)) {
                        activity = activity2;
                    } else {
                        linkedList.add(activity2);
                    }
                } else {
                    linkedList.add(activity2);
                }
            }
            if (activity != null) {
                linkedList.addFirst(activity);
            }
            return linkedList;
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivitiesByReflect: " + e11.getMessage());
        }
    }

    public List<Activity> i() {
        if (!this.f63548b.isEmpty()) {
            return new LinkedList(this.f63548b);
        }
        this.f63548b.addAll(h());
        return new LinkedList(this.f63548b);
    }

    public final Object j() {
        Object k11 = k();
        if (k11 != null) {
            return k11;
        }
        return l();
    }

    public final Object k() {
        try {
            Field declaredField = Class.forName("android.app.ActivityThread").getDeclaredField("sCurrentActivityThread");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticField: " + e11.getMessage());
            return null;
        }
    }

    public final Object l() {
        try {
            return Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception e11) {
            Log.e("UtilsActivityLifecycle", "getActivityThreadInActivityThreadStaticMethod: " + e11.getMessage());
            return null;
        }
    }

    public Application m() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", new Class[0]).invoke(j(), new Object[0]);
            if (invoke == null) {
                return null;
            }
            return (Application) invoke;
        } catch (InvocationTargetException e11) {
            e11.printStackTrace();
            return null;
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            return null;
        } catch (IllegalAccessException e13) {
            e13.printStackTrace();
            return null;
        } catch (ClassNotFoundException e14) {
            e14.printStackTrace();
            return null;
        }
    }

    public Activity n() {
        for (Activity next : i()) {
            if (a0.v(next)) {
                return next;
            }
        }
        return null;
    }

    public void o(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (this.f63548b.size() == 0) {
            q(activity, true);
        }
        p.a(activity);
        v();
        w(activity);
        f(activity, Lifecycle.Event.ON_CREATE);
    }

    public void onActivityDestroyed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        this.f63548b.remove(activity);
        a0.e(activity);
        f(activity, Lifecycle.Event.ON_DESTROY);
    }

    public void onActivityPaused(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        f(activity, Lifecycle.Event.ON_PAUSE);
    }

    public void onActivityPostCreated(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPostDestroyed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPostPaused(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPostResumed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPostSaveInstanceState(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPostStarted(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPostStopped(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPreDestroyed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPrePaused(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPreResumed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPreSaveInstanceState(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPreStarted(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityPreStopped(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityResumed(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        w(activity);
        if (this.f63553g) {
            this.f63553g = false;
            q(activity, true);
        }
        r(activity, false);
        f(activity, Lifecycle.Event.ON_RESUME);
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        Objects.requireNonNull(bundle, "Argument 'outState' of type Bundle (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public void onActivityStarted(Activity activity) {
        Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        if (!this.f63553g) {
            w(activity);
        }
        int i11 = this.f63552f;
        if (i11 < 0) {
            this.f63552f = i11 + 1;
        } else {
            this.f63551e++;
        }
        f(activity, Lifecycle.Event.ON_START);
    }

    public void onActivityStopped(Activity activity) {
        if (activity.isChangingConfigurations()) {
            this.f63552f--;
        } else {
            int i11 = this.f63551e - 1;
            this.f63551e = i11;
            if (i11 <= 0) {
                this.f63553g = true;
                q(activity, false);
            }
        }
        r(activity, true);
        f(activity, Lifecycle.Event.ON_STOP);
    }

    public boolean p() {
        return !this.f63553g;
    }

    public final void q(Activity activity, boolean z11) {
        if (!this.f63549c.isEmpty()) {
            for (Utils.b next : this.f63549c) {
                if (z11) {
                    next.a(activity);
                } else {
                    next.b(activity);
                }
            }
        }
    }

    public final void r(Activity activity, boolean z11) {
        if (z11) {
            try {
                Window window = activity.getWindow();
                window.getDecorView().setTag(-123, Integer.valueOf(window.getAttributes().softInputMode));
                window.setSoftInputMode(3);
            } catch (Exception unused) {
            }
        } else {
            Object tag = activity.getWindow().getDecorView().getTag(-123);
            if (tag instanceof Integer) {
                a0.J(new c(activity, tag), 100);
            }
        }
    }

    public void s(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activity != null && activityLifecycleCallbacks != null) {
            a0.I(new b(activity, activityLifecycleCallbacks));
        }
    }

    public void t(Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        s(f63547i, activityLifecycleCallbacks);
    }

    public final void u(Activity activity, Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        List list = this.f63550d.get(activity);
        if (list != null && !list.isEmpty()) {
            list.remove(activityLifecycleCallbacks);
        }
    }

    public final void w(Activity activity) {
        if (!this.f63548b.contains(activity)) {
            this.f63548b.addFirst(activity);
        } else if (!this.f63548b.getFirst().equals(activity)) {
            this.f63548b.remove(activity);
            this.f63548b.addFirst(activity);
        }
    }

    public void x(Application application) {
        this.f63548b.clear();
        application.unregisterActivityLifecycleCallbacks(this);
    }
}
