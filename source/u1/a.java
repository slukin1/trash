package u1;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static long f16601a;

    /* renamed from: b  reason: collision with root package name */
    public static Method f16602b;

    /* renamed from: c  reason: collision with root package name */
    public static Method f16603c;

    /* renamed from: d  reason: collision with root package name */
    public static Method f16604d;

    @SuppressLint({"NewApi"})
    public static void a(String str, int i11) {
        try {
            if (f16603c == null) {
                c.a(str, i11);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        b(str, i11);
    }

    public static void b(String str, int i11) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f16603c == null) {
                    f16603c = Trace.class.getMethod("asyncTraceBegin", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                f16603c.invoke((Object) null, new Object[]{Long.valueOf(f16601a), str, Integer.valueOf(i11)});
            } catch (Exception e11) {
                g("asyncTraceBegin", e11);
            }
        }
    }

    public static void c(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            b.a(str);
        }
    }

    @SuppressLint({"NewApi"})
    public static void d(String str, int i11) {
        try {
            if (f16604d == null) {
                c.b(str, i11);
                return;
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        e(str, i11);
    }

    public static void e(String str, int i11) {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f16604d == null) {
                    f16604d = Trace.class.getMethod("asyncTraceEnd", new Class[]{Long.TYPE, String.class, Integer.TYPE});
                }
                f16604d.invoke((Object) null, new Object[]{Long.valueOf(f16601a), str, Integer.valueOf(i11)});
            } catch (Exception e11) {
                g("asyncTraceEnd", e11);
            }
        }
    }

    public static void f() {
        if (Build.VERSION.SDK_INT >= 18) {
            b.b();
        }
    }

    public static void g(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    @SuppressLint({"NewApi"})
    public static boolean h() {
        try {
            if (f16602b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return i();
    }

    public static boolean i() {
        if (Build.VERSION.SDK_INT >= 18) {
            try {
                if (f16602b == null) {
                    f16601a = Trace.class.getField("TRACE_TAG_APP").getLong((Object) null);
                    f16602b = Trace.class.getMethod("isTagEnabled", new Class[]{Long.TYPE});
                }
                return ((Boolean) f16602b.invoke((Object) null, new Object[]{Long.valueOf(f16601a)})).booleanValue();
            } catch (Exception e11) {
                g("isTagEnabled", e11);
            }
        }
        return false;
    }
}
