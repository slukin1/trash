package org.bouncycastle.pqc.math.linearalgebra;

public final class IntUtils {
    private IntUtils() {
    }

    public static int[] clone(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    public static boolean equals(int[] iArr, int[] iArr2) {
        if (iArr.length != iArr2.length) {
            return false;
        }
        boolean z11 = true;
        for (int length = iArr.length - 1; length >= 0; length--) {
            z11 &= iArr[length] == iArr2[length];
        }
        return z11;
    }

    public static void fill(int[] iArr, int i11) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr[length] = i11;
        }
    }

    private static int partition(int[] iArr, int i11, int i12, int i13) {
        int i14 = iArr[i13];
        iArr[i13] = iArr[i12];
        iArr[i12] = i14;
        int i15 = i11;
        while (i11 < i12) {
            if (iArr[i11] <= i14) {
                int i16 = iArr[i15];
                iArr[i15] = iArr[i11];
                iArr[i11] = i16;
                i15++;
            }
            i11++;
        }
        int i17 = iArr[i15];
        iArr[i15] = iArr[i12];
        iArr[i12] = i17;
        return i15;
    }

    public static void quicksort(int[] iArr) {
        quicksort(iArr, 0, iArr.length - 1);
    }

    public static void quicksort(int[] iArr, int i11, int i12) {
        if (i12 > i11) {
            int partition = partition(iArr, i11, i12, i12);
            quicksort(iArr, i11, partition - 1);
            quicksort(iArr, partition + 1, i12);
        }
    }

    public static int[] subArray(int[] iArr, int i11, int i12) {
        int i13 = i12 - i11;
        int[] iArr2 = new int[i13];
        System.arraycopy(iArr, i11, iArr2, 0, i13);
        return iArr2;
    }

    public static String toHexString(int[] iArr) {
        return ByteUtils.toHexString(BigEndianConversions.toByteArray(iArr));
    }

    public static String toString(int[] iArr) {
        String str = "";
        for (int i11 = 0; i11 < iArr.length; i11++) {
            str = str + iArr[i11] + " ";
        }
        return str;
    }
}
