package kotlin.collections;

import java.lang.reflect.Array;

class ArraysKt__ArraysJVMKt {
    public static final <T> T[] a(T[] tArr, int i11) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
    }

    public static final void b(int i11, int i12) {
        if (i11 > i12) {
            throw new IndexOutOfBoundsException("toIndex (" + i11 + ") is greater than size (" + i12 + ").");
        }
    }
}
