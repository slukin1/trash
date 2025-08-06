package g3;

import android.app.ActivityManager;
import android.app.Instrumentation;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import com.bbc876219.lib.hook.AppInstrumentation;
import com.bbc876219.lib.utils.reflection.ReflectionUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static Class<?> f15826a = ReflectionUtils.a("android.app.ActivityThread");

    /* renamed from: b  reason: collision with root package name */
    public static Object f15827b = a();

    /* renamed from: c  reason: collision with root package name */
    public static volatile boolean f15828c;

    public static Object a() {
        try {
            Method method = (Method) ReflectionUtils.f63249b.invoke(f15826a, new Object[]{"currentActivityThread", null});
            method.setAccessible(true);
            return method.invoke((Object) null, new Object[0]);
        } catch (Throwable th2) {
            Log.e("ActivityThreadHook", "getCurrentActivityThread", th2);
            return null;
        }
    }

    public static void b() {
        Object obj;
        Object obj2;
        Log.d("ActivityThreadHook", "hookActivityManagerService() called");
        try {
            Field field = (Field) ReflectionUtils.c(ReflectionUtils.b("android.util.Singleton"), "mInstance");
            field.setAccessible(true);
            if (Build.VERSION.SDK_INT > 25) {
                Field field2 = (Field) ReflectionUtils.c(ActivityManager.class, "IActivityManagerSingleton");
                field2.setAccessible(true);
                obj2 = field2.get((Object) null);
                obj = field.get(obj2);
            } else {
                Field field3 = (Field) ReflectionUtils.c(ReflectionUtils.b("android.app.ActivityManagerNative"), "gDefault");
                Object obj3 = field3.get((Object) null);
                Object obj4 = obj3;
                obj = field3.get(obj3);
                obj2 = obj4;
            }
            field.set(obj2, Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{ReflectionUtils.a("android.app.IActivityManager")}, new a(obj)));
        } catch (Throwable th2) {
            Log.e("ActivityThreadHook", "hookActivityManagerService: ", th2);
        }
    }

    public static void c() {
        Log.d("ActivityThreadHook", "hookActivityThreadHandlerCallBack() called");
        try {
            Field field = (Field) ReflectionUtils.c(f15826a, "mH");
            field.setAccessible(true);
            Field field2 = (Field) ReflectionUtils.c(Handler.class, "mCallback");
            field2.setAccessible(true);
            Handler handler = (Handler) field.get(f15827b);
            field2.set(handler, new c(handler));
        } catch (Throwable th2) {
            Log.e("ActivityThreadHook", "hookActivityThreadHandlerCallBack: ", th2);
        }
    }

    public static void d() {
        Log.d("ActivityThreadHook", "hookActivityThreadInstrumentation() called");
        if (!f15828c) {
            try {
                Field field = (Field) ReflectionUtils.c(f15826a, "mInstrumentation");
                field.setAccessible(true);
                field.set(f15827b, new AppInstrumentation((Instrumentation) field.get(f15827b)));
                f15828c = true;
            } catch (Throwable th2) {
                Log.e("ActivityThreadHook", "hookActivityThreadInstrumentation: ", th2);
            }
        }
    }

    public static void e(Context context) {
        Log.d("ActivityThreadHook", "hookAll() called with: context = [" + context + "]");
        b();
        c();
        d();
        f(context);
    }

    public static void f(Context context) {
        Log.d("ActivityThreadHook", "hookPackageManagerService() called with: context = [" + context + "]");
        try {
            Field declaredField = f15826a.getDeclaredField("sPackageManager");
            declaredField.setAccessible(true);
            Object newProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{ReflectionUtils.a("android.content.pm.IPackageManager")}, new d(declaredField.get(f15827b)));
            declaredField.set(f15827b, newProxyInstance);
            PackageManager packageManager = context.getPackageManager();
            Field field = (Field) ReflectionUtils.c(packageManager.getClass(), "mPM");
            field.setAccessible(true);
            field.set(packageManager, newProxyInstance);
        } catch (Throwable th2) {
            Log.e("ActivityThreadHook", "hookPackageManagerService: ", th2);
        }
    }
}
