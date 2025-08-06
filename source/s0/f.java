package s0;

import java.lang.reflect.Array;

public final class f {
    public static int[] a(int[] iArr, int i11, int i12) {
        if (i11 + 1 > iArr.length) {
            int[] iArr2 = new int[c(i11)];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            iArr = iArr2;
        }
        iArr[i11] = i12;
        return iArr;
    }

    public static <T> T[] b(T[] tArr, int i11, T t11) {
        if (i11 + 1 > tArr.length) {
            T[] tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), c(i11));
            System.arraycopy(tArr, 0, tArr2, 0, i11);
            tArr = tArr2;
        }
        tArr[i11] = t11;
        return tArr;
    }

    public static int c(int i11) {
        if (i11 <= 4) {
            return 8;
        }
        return i11 * 2;
    }
}
