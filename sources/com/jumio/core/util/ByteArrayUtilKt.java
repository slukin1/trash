package com.jumio.core.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public final class ByteArrayUtilKt {
    public static final byte[] byteArrayOfInts(int... iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 < length; i11++) {
            bArr[i11] = (byte) iArr[i11];
        }
        return bArr;
    }

    public static final int findSequence(byte[] bArr, byte[] bArr2, int i11) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException("non-empty byte sequence is required");
        } else if (i11 >= 0) {
            int i12 = i11;
            int i13 = 0;
            while (i11 < bArr.length) {
                if (bArr[i11] == bArr2[i13]) {
                    int i14 = i13 + 1;
                    if (i13 == 0) {
                        i12 = i11;
                    }
                    if (i14 == bArr2.length) {
                        return i12;
                    }
                    i13 = i14;
                } else {
                    i13 = 0;
                }
                i11++;
            }
            return -1;
        } else {
            throw new IllegalArgumentException("startFrom must be non-negative");
        }
    }

    public static /* synthetic */ int findSequence$default(byte[] bArr, byte[] bArr2, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        return findSequence(bArr, bArr2, i11);
    }

    public static final boolean startsWith(byte[] bArr, byte[] bArr2) {
        if (bArr2.length == 0) {
            throw new IllegalArgumentException("non-empty byte sequence is required");
        } else if (bArr.length >= bArr2.length) {
            int length = bArr2.length;
            boolean z11 = true;
            for (int i11 = 0; i11 < length; i11++) {
                z11 = z11 && bArr[i11] == bArr2[i11];
            }
            return z11;
        } else {
            throw new IllegalArgumentException("sequence exceeds array length");
        }
    }

    public static final boolean startsWithAny(byte[] bArr, List<byte[]> list) {
        T t11;
        Iterator<T> it2 = list.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (startsWith(bArr, (byte[]) t11)) {
                break;
            }
        }
        return t11 != null;
    }

    public static final byte[] trim(byte[] bArr, int i11) {
        return Arrays.copyOfRange(bArr, 0, i11);
    }
}
