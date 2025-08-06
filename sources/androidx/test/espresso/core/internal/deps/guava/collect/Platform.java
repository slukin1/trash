package androidx.test.espresso.core.internal.deps.guava.collect;

import java.lang.reflect.Array;
import java.util.Arrays;

final class Platform {
    public static <T> T[] a(Object[] objArr, int i11, int i12, T[] tArr) {
        return Arrays.copyOfRange(objArr, i11, i12, tArr.getClass());
    }

    public static <T> T[] b(T[] tArr, int i11) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
    }
}
