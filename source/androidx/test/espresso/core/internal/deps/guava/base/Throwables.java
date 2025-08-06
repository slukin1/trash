package androidx.test.espresso.core.internal.deps.guava.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class Throwables {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f11167a;

    /* renamed from: b  reason: collision with root package name */
    public static final Method f11168b;

    /* renamed from: c  reason: collision with root package name */
    public static final Method f11169c;

    static {
        Method method;
        Object b11 = b();
        f11167a = b11;
        Method method2 = null;
        if (b11 == null) {
            method = null;
        } else {
            method = a();
        }
        f11168b = method;
        if (b11 != null) {
            method2 = d();
        }
        f11169c = method2;
    }

    public static Method a() {
        return c("getStackTraceElement", Throwable.class, Integer.TYPE);
    }

    public static Object b() {
        try {
            return Class.forName(com.google.common.base.Throwables.SHARED_SECRETS_CLASSNAME, false, (ClassLoader) null).getMethod("getJavaLangAccess", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method c(String str, Class<?>... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, (ClassLoader) null).getMethod(str, clsArr);
        } catch (ThreadDeath e11) {
            throw e11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Method d() {
        try {
            Method c11 = c("getStackTraceDepth", Throwable.class);
            if (c11 == null) {
                return null;
            }
            c11.invoke(b(), new Object[]{new Throwable()});
            return c11;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    public static void e(Throwable th2) {
        Preconditions.i(th2);
        if (th2 instanceof RuntimeException) {
            throw ((RuntimeException) th2);
        } else if (th2 instanceof Error) {
            throw ((Error) th2);
        }
    }
}
