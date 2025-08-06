package androidx.test.internal.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.TestCase;

public class AndroidRunnerBuilderUtil {
    public static boolean a(Class<?> cls) {
        for (Method d11 : cls.getMethods()) {
            if (d(d11)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Class<?> cls) {
        try {
            cls.getMethod("suite", new Class[0]);
            return true;
        } catch (NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean c(Class<?> cls) {
        return TestCase.class.isAssignableFrom(cls);
    }

    public static boolean d(Method method) {
        return e(method) && Modifier.isPublic(method.getModifiers());
    }

    public static boolean e(Method method) {
        return method.getParameterTypes().length == 0 && method.getName().startsWith("test") && method.getReturnType().equals(Void.TYPE);
    }
}
