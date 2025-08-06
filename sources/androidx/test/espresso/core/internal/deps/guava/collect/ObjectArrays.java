package androidx.test.espresso.core.internal.deps.guava.collect;

public final class ObjectArrays {
    public static Object a(Object obj, int i11) {
        if (obj != null) {
            return obj;
        }
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append("at index ");
        sb2.append(i11);
        throw new NullPointerException(sb2.toString());
    }

    public static Object[] b(Object... objArr) {
        return c(objArr, objArr.length);
    }

    public static Object[] c(Object[] objArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            a(objArr[i12], i12);
        }
        return objArr;
    }

    public static <T> T[] d(T[] tArr, int i11) {
        return Platform.b(tArr, i11);
    }
}
