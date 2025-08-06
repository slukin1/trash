package androidx.core.util;

import android.os.Build;
import java.util.Arrays;
import java.util.Objects;

public class b {

    public static class a {
        public static boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }

        public static int b(Object... objArr) {
            return Objects.hash(objArr);
        }
    }

    public static boolean a(Object obj, Object obj2) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.a(obj, obj2);
        }
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.b(objArr);
        }
        return Arrays.hashCode(objArr);
    }

    public static <T> T c(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    public static <T> T d(T t11, String str) {
        Objects.requireNonNull(t11, str);
        return t11;
    }

    public static String e(Object obj, String str) {
        return obj != null ? obj.toString() : str;
    }
}
