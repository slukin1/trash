package androidx.test.espresso.core.internal.deps.guava.base;

import java.util.Arrays;

public final class Objects extends ExtraObjectsMethodsForWeb {
    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int b(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
