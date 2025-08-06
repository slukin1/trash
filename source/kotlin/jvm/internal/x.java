package kotlin.jvm.internal;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;

public class x {

    public static class a {
    }

    public static boolean a(Float f11, float f12) {
        return f11 != null && f11.floatValue() == f12;
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static int c(int i11, int i12) {
        if (i11 < i12) {
            return -1;
        }
        return i11 == i12 ? 0 : 1;
    }

    public static int d(long j11, long j12) {
        int i11 = (j11 > j12 ? 1 : (j11 == j12 ? 0 : -1));
        if (i11 < 0) {
            return -1;
        }
        return i11 == 0 ? 0 : 1;
    }

    public static void e() {
        k();
    }

    public static void f(int i11, String str) {
        k();
    }

    public static <T extends Throwable> T g(T t11) {
        return h(t11, x.class.getName());
    }

    public static <T extends Throwable> T h(T t11, String str) {
        StackTraceElement[] stackTrace = t11.getStackTrace();
        int length = stackTrace.length;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            if (str.equals(stackTrace[i12].getClassName())) {
                i11 = i12;
            }
        }
        t11.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i11 + 1, length));
        return t11;
    }

    public static String i(String str, Object obj) {
        return str + obj;
    }

    public static void j() {
        throw ((KotlinNullPointerException) g(new KotlinNullPointerException()));
    }

    public static void k() {
        l("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void l(String str) {
        throw new UnsupportedOperationException(str);
    }
}
