package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.util.SparseArray;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class d {

    public static class a {
        public static IBinder a(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        public static void b(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }

    public static class b {
        public static <T> T a(Bundle bundle, String str, Class<T> cls) {
            return bundle.getParcelable(str, cls);
        }

        public static <T> T[] b(Bundle bundle, String str, Class<T> cls) {
            return bundle.getParcelableArray(str, cls);
        }

        public static <T> ArrayList<T> c(Bundle bundle, String str, Class<? extends T> cls) {
            return bundle.getParcelableArrayList(str, cls);
        }

        public static <T> SparseArray<T> d(Bundle bundle, String str, Class<? extends T> cls) {
            return bundle.getSparseParcelableArray(str, cls);
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static Method f8401a;

        /* renamed from: b  reason: collision with root package name */
        public static boolean f8402b;

        /* renamed from: c  reason: collision with root package name */
        public static Method f8403c;

        /* renamed from: d  reason: collision with root package name */
        public static boolean f8404d;

        public static IBinder a(Bundle bundle, String str) {
            if (!f8402b) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                    f8401a = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e11) {
                    Log.i("BundleCompat", "Failed to retrieve getIBinder method", e11);
                }
                f8402b = true;
            }
            Method method2 = f8401a;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, new Object[]{str});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e12) {
                    Log.i("BundleCompat", "Failed to invoke getIBinder via reflection", e12);
                    f8401a = null;
                }
            }
            return null;
        }

        public static void b(Bundle bundle, String str, IBinder iBinder) {
            if (!f8404d) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                    f8403c = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e11) {
                    Log.i("BundleCompat", "Failed to retrieve putIBinder method", e11);
                }
                f8404d = true;
            }
            Method method2 = f8403c;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, new Object[]{str, iBinder});
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e12) {
                    Log.i("BundleCompat", "Failed to invoke putIBinder via reflection", e12);
                    f8403c = null;
                }
            }
        }
    }

    public static IBinder a(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            return a.a(bundle, str);
        }
        return c.a(bundle, str);
    }

    public static <T> T b(Bundle bundle, String str, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 34) {
            return b.a(bundle, str, cls);
        }
        T parcelable = bundle.getParcelable(str);
        if (cls.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static void c(Bundle bundle, String str, IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 18) {
            a.b(bundle, str, iBinder);
        } else {
            c.b(bundle, str, iBinder);
        }
    }
}
