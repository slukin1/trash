package p0;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Class<?> f16287a;

    /* renamed from: b  reason: collision with root package name */
    public static final Field f16288b = b();

    /* renamed from: c  reason: collision with root package name */
    public static final Field f16289c = f();

    /* renamed from: d  reason: collision with root package name */
    public static final Method f16290d;

    /* renamed from: e  reason: collision with root package name */
    public static final Method f16291e;

    /* renamed from: f  reason: collision with root package name */
    public static final Method f16292f;

    /* renamed from: g  reason: collision with root package name */
    public static final Handler f16293g = new Handler(Looper.getMainLooper());

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ C0094d f16294b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f16295c;

        public a(C0094d dVar, Object obj) {
            this.f16294b = dVar;
            this.f16295c = obj;
        }

        public void run() {
            this.f16294b.f16300b = this.f16295c;
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Application f16296b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ C0094d f16297c;

        public b(Application application, C0094d dVar) {
            this.f16296b = application;
            this.f16297c = dVar;
        }

        public void run() {
            this.f16296b.unregisterActivityLifecycleCallbacks(this.f16297c);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f16298b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f16299c;

        public c(Object obj, Object obj2) {
            this.f16298b = obj;
            this.f16299c = obj2;
        }

        public void run() {
            try {
                Method method = d.f16290d;
                if (method != null) {
                    method.invoke(this.f16298b, new Object[]{this.f16299c, Boolean.FALSE, "AppCompat recreation"});
                    return;
                }
                d.f16291e.invoke(this.f16298b, new Object[]{this.f16299c, Boolean.FALSE});
            } catch (RuntimeException e11) {
                if (e11.getClass() == RuntimeException.class && e11.getMessage() != null && e11.getMessage().startsWith("Unable to stop")) {
                    throw e11;
                }
            } catch (Throwable th2) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th2);
            }
        }
    }

    /* renamed from: p0.d$d  reason: collision with other inner class name */
    public static final class C0094d implements Application.ActivityLifecycleCallbacks {

        /* renamed from: b  reason: collision with root package name */
        public Object f16300b;

        /* renamed from: c  reason: collision with root package name */
        public Activity f16301c;

        /* renamed from: d  reason: collision with root package name */
        public final int f16302d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f16303e = false;

        /* renamed from: f  reason: collision with root package name */
        public boolean f16304f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f16305g = false;

        public C0094d(Activity activity) {
            this.f16301c = activity;
            this.f16302d = activity.hashCode();
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (this.f16301c == activity) {
                this.f16301c = null;
                this.f16304f = true;
            }
        }

        public void onActivityPaused(Activity activity) {
            if (this.f16304f && !this.f16305g && !this.f16303e && d.h(this.f16300b, this.f16302d, activity)) {
                this.f16305g = true;
                this.f16300b = null;
            }
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            if (this.f16301c == activity) {
                this.f16303e = true;
            }
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a11 = a();
        f16287a = a11;
        f16290d = d(a11);
        f16291e = c(a11);
        f16292f = e(a11);
    }

    public static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", new Class[]{IBinder.class, Boolean.TYPE, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", new Class[]{IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2});
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean g() {
        int i11 = Build.VERSION.SDK_INT;
        return i11 == 26 || i11 == 27;
    }

    public static boolean h(Object obj, int i11, Activity activity) {
        try {
            Object obj2 = f16289c.get(activity);
            if (obj2 == obj) {
                if (activity.hashCode() == i11) {
                    f16293g.postAtFrontOfQueue(new c(f16288b.get(activity), obj2));
                    return true;
                }
            }
            return false;
        } catch (Throwable th2) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th2);
            return false;
        }
    }

    public static boolean i(Activity activity) {
        Object obj;
        Application application;
        C0094d dVar;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f16292f == null) {
            return false;
        } else {
            if (f16291e == null && f16290d == null) {
                return false;
            }
            try {
                Object obj2 = f16289c.get(activity);
                if (obj2 == null || (obj = f16288b.get(activity)) == null) {
                    return false;
                }
                application = activity.getApplication();
                dVar = new C0094d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f16293g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f16292f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, new Object[]{obj2, null, null, 0, bool, null, null, bool, bool});
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}
