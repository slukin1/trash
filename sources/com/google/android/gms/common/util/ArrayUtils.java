package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@KeepForSdk
public final class ArrayUtils {
    private ArrayUtils() {
    }

    @KeepForSdk
    public static <T> T[] concat(T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i11 = 0;
        for (T[] length : tArr) {
            i11 += length.length;
        }
        T[] copyOf = Arrays.copyOf(tArr[0], i11);
        int length2 = tArr[0].length;
        for (int i12 = 1; i12 < tArr.length; i12++) {
            T[] tArr2 = tArr[i12];
            int length3 = tArr2.length;
            System.arraycopy(tArr2, 0, copyOf, length2, length3);
            length2 += length3;
        }
        return copyOf;
    }

    @KeepForSdk
    public static byte[] concatByteArrays(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i11 = 0;
        for (byte[] length : bArr) {
            i11 += length.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i11);
        int length2 = bArr[0].length;
        for (int i12 = 1; i12 < bArr.length; i12++) {
            byte[] bArr2 = bArr[i12];
            int length3 = bArr2.length;
            System.arraycopy(bArr2, 0, copyOf, length2, length3);
            length2 += length3;
        }
        return copyOf;
    }

    @KeepForSdk
    public static boolean contains(int[] iArr, int i11) {
        if (iArr != null) {
            for (int i12 : iArr) {
                if (i12 == i11) {
                    return true;
                }
            }
        }
        return false;
    }

    @KeepForSdk
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    @KeepForSdk
    public static <T> T[] removeAll(T[] tArr, T... tArr2) {
        int length;
        int i11;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || (length = tArr2.length) == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        T[] tArr3 = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), r3);
        if (length == 1) {
            i11 = 0;
            for (T t11 : tArr) {
                if (!Objects.equal(tArr2[0], t11)) {
                    tArr3[i11] = t11;
                    i11++;
                }
            }
        } else {
            int i12 = 0;
            for (T t12 : tArr) {
                if (!contains(tArr2, t12)) {
                    tArr3[i12] = t12;
                    i12++;
                }
            }
            i11 = i12;
        }
        if (tArr3 == null) {
            return null;
        }
        if (i11 == tArr3.length) {
            return tArr3;
        }
        return Arrays.copyOf(tArr3, i11);
    }

    @KeepForSdk
    public static <T> ArrayList<T> toArrayList(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(r0);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    @KeepForSdk
    public static int[] toPrimitiveArray(Collection<Integer> collection) {
        int i11 = 0;
        if (collection == null || collection.isEmpty()) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        for (Integer intValue : collection) {
            iArr[i11] = intValue.intValue();
            i11++;
        }
        return iArr;
    }

    @KeepForSdk
    public static Integer[] toWrapperArray(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i11 = 0; i11 < length; i11++) {
            numArr[i11] = Integer.valueOf(iArr[i11]);
        }
        return numArr;
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb2, double[] dArr) {
        int length = dArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append(dArr[i11]);
        }
    }

    @KeepForSdk
    public static void writeStringArray(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append("\"");
            sb2.append(strArr[i11]);
            sb2.append("\"");
        }
    }

    @KeepForSdk
    public static <T> boolean contains(T[] tArr, T t11) {
        int length = tArr != null ? tArr.length : 0;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            } else if (!Objects.equal(tArr[i11], t11)) {
                i11++;
            } else if (i11 >= 0) {
                return true;
            }
        }
        return false;
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb2, float[] fArr) {
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append(fArr[i11]);
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb2, int[] iArr) {
        int length = iArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append(iArr[i11]);
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb2, long[] jArr) {
        int length = jArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append(jArr[i11]);
        }
    }

    @KeepForSdk
    public static <T> void writeArray(StringBuilder sb2, T[] tArr) {
        int length = tArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append(tArr[i11]);
        }
    }

    @KeepForSdk
    public static void writeArray(StringBuilder sb2, boolean[] zArr) {
        int length = zArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (i11 != 0) {
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb2.append(zArr[i11]);
        }
    }
}
