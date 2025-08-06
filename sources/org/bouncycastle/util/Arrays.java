package org.bouncycastle.util;

import java.math.BigInteger;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class Arrays {

    public static class Iterator<T> implements java.util.Iterator<T> {
        private final T[] dataArray;
        private int position = 0;

        public Iterator(T[] tArr) {
            this.dataArray = tArr;
        }

        public boolean hasNext() {
            return this.position < this.dataArray.length;
        }

        public T next() {
            int i11 = this.position;
            T[] tArr = this.dataArray;
            if (i11 != tArr.length) {
                this.position = i11 + 1;
                return tArr[i11];
            }
            throw new NoSuchElementException("Out of elements: " + this.position);
        }

        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    private Arrays() {
    }

    public static byte[] append(byte[] bArr, byte b11) {
        if (bArr == null) {
            return new byte[]{b11};
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        bArr2[length] = b11;
        return bArr2;
    }

    public static int[] append(int[] iArr, int i11) {
        if (iArr == null) {
            return new int[]{i11};
        }
        int length = iArr.length;
        int[] iArr2 = new int[(length + 1)];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        iArr2[length] = i11;
        return iArr2;
    }

    public static String[] append(String[] strArr, String str) {
        if (strArr == null) {
            return new String[]{str};
        }
        int length = strArr.length;
        String[] strArr2 = new String[(length + 1)];
        System.arraycopy(strArr, 0, strArr2, 0, length);
        strArr2[length] = str;
        return strArr2;
    }

    public static short[] append(short[] sArr, short s11) {
        if (sArr == null) {
            return new short[]{s11};
        }
        int length = sArr.length;
        short[] sArr2 = new short[(length + 1)];
        System.arraycopy(sArr, 0, sArr2, 0, length);
        sArr2[length] = s11;
        return sArr2;
    }

    public static boolean areAllZeroes(byte[] bArr, int i11, int i12) {
        byte b11 = 0;
        for (int i13 = 0; i13 < i12; i13++) {
            b11 |= bArr[i11 + i13];
        }
        return b11 == 0;
    }

    public static boolean areEqual(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        int i15 = i12 - i11;
        if (i15 != i14 - i13) {
            return false;
        }
        for (int i16 = 0; i16 < i15; i16++) {
            if (bArr[i11 + i16] != bArr2[i13 + i16]) {
                return false;
            }
        }
        return true;
    }

    public static boolean areEqual(byte[] bArr, byte[] bArr2) {
        return java.util.Arrays.equals(bArr, bArr2);
    }

    public static boolean areEqual(char[] cArr, char[] cArr2) {
        return java.util.Arrays.equals(cArr, cArr2);
    }

    public static boolean areEqual(int[] iArr, int[] iArr2) {
        return java.util.Arrays.equals(iArr, iArr2);
    }

    public static boolean areEqual(long[] jArr, long[] jArr2) {
        return java.util.Arrays.equals(jArr, jArr2);
    }

    public static boolean areEqual(Object[] objArr, Object[] objArr2) {
        return java.util.Arrays.equals(objArr, objArr2);
    }

    public static boolean areEqual(short[] sArr, short[] sArr2) {
        return java.util.Arrays.equals(sArr, sArr2);
    }

    public static boolean areEqual(boolean[] zArr, boolean[] zArr2) {
        return java.util.Arrays.equals(zArr, zArr2);
    }

    public static void clear(byte[] bArr) {
        if (bArr != null) {
            java.util.Arrays.fill(bArr, (byte) 0);
        }
    }

    public static void clear(int[] iArr) {
        if (iArr != null) {
            java.util.Arrays.fill(iArr, 0);
        }
    }

    public static byte[] clone(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    public static byte[] clone(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return null;
        }
        if (bArr2 == null || bArr2.length != bArr.length) {
            return clone(bArr);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public static char[] clone(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return (char[]) cArr.clone();
    }

    public static int[] clone(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    public static long[] clone(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    public static long[] clone(long[] jArr, long[] jArr2) {
        if (jArr == null) {
            return null;
        }
        if (jArr2 == null || jArr2.length != jArr.length) {
            return clone(jArr);
        }
        System.arraycopy(jArr, 0, jArr2, 0, jArr2.length);
        return jArr2;
    }

    public static BigInteger[] clone(BigInteger[] bigIntegerArr) {
        if (bigIntegerArr == null) {
            return null;
        }
        return (BigInteger[]) bigIntegerArr.clone();
    }

    public static short[] clone(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    public static boolean[] clone(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        return (boolean[]) zArr.clone();
    }

    public static byte[][] clone(byte[][] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[][] bArr2 = new byte[length][];
        for (int i11 = 0; i11 != length; i11++) {
            bArr2[i11] = clone(bArr[i11]);
        }
        return bArr2;
    }

    public static byte[][][] clone(byte[][][] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        byte[][][] bArr2 = new byte[length][][];
        for (int i11 = 0; i11 != length; i11++) {
            bArr2[i11] = clone(bArr[i11]);
        }
        return bArr2;
    }

    public static int compareUnsigned(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return 0;
        }
        if (bArr == null) {
            return -1;
        }
        if (bArr2 == null) {
            return 1;
        }
        int min = Math.min(bArr.length, bArr2.length);
        for (int i11 = 0; i11 < min; i11++) {
            byte b11 = bArr[i11] & 255;
            byte b12 = bArr2[i11] & 255;
            if (b11 < b12) {
                return -1;
            }
            if (b11 > b12) {
                return 1;
            }
        }
        if (bArr.length < bArr2.length) {
            return -1;
        }
        return bArr.length > bArr2.length ? 1 : 0;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return clone(bArr2);
        }
        if (bArr2 == null) {
            return clone(bArr);
        }
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr == null) {
            return concatenate(bArr2, bArr3);
        }
        if (bArr2 == null) {
            return concatenate(bArr, bArr3);
        }
        if (bArr3 == null) {
            return concatenate(bArr, bArr2);
        }
        byte[] bArr4 = new byte[(bArr.length + bArr2.length + bArr3.length)];
        System.arraycopy(bArr, 0, bArr4, 0, bArr.length);
        int length = bArr.length + 0;
        System.arraycopy(bArr2, 0, bArr4, length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr4, length + bArr2.length, bArr3.length);
        return bArr4;
    }

    public static byte[] concatenate(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        if (bArr == null) {
            return concatenate(bArr2, bArr3, bArr4);
        }
        if (bArr2 == null) {
            return concatenate(bArr, bArr3, bArr4);
        }
        if (bArr3 == null) {
            return concatenate(bArr, bArr2, bArr4);
        }
        if (bArr4 == null) {
            return concatenate(bArr, bArr2, bArr3);
        }
        byte[] bArr5 = new byte[(bArr.length + bArr2.length + bArr3.length + bArr4.length)];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        int length = bArr.length + 0;
        System.arraycopy(bArr2, 0, bArr5, length, bArr2.length);
        int length2 = length + bArr2.length;
        System.arraycopy(bArr3, 0, bArr5, length2, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, length2 + bArr3.length, bArr4.length);
        return bArr5;
    }

    public static byte[] concatenate(byte[][] bArr) {
        int i11 = 0;
        for (int i12 = 0; i12 != bArr.length; i12++) {
            i11 += bArr[i12].length;
        }
        byte[] bArr2 = new byte[i11];
        int i13 = 0;
        for (int i14 = 0; i14 != bArr.length; i14++) {
            System.arraycopy(bArr[i14], 0, bArr2, i13, bArr[i14].length);
            i13 += bArr[i14].length;
        }
        return bArr2;
    }

    public static int[] concatenate(int[] iArr, int[] iArr2) {
        if (iArr == null) {
            return clone(iArr2);
        }
        if (iArr2 == null) {
            return clone(iArr);
        }
        int[] iArr3 = new int[(iArr.length + iArr2.length)];
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
        return iArr3;
    }

    public static short[] concatenate(short[] sArr, short[] sArr2) {
        if (sArr == null) {
            return clone(sArr2);
        }
        if (sArr2 == null) {
            return clone(sArr);
        }
        short[] sArr3 = new short[(sArr.length + sArr2.length)];
        System.arraycopy(sArr, 0, sArr3, 0, sArr.length);
        System.arraycopy(sArr2, 0, sArr3, sArr.length, sArr2.length);
        return sArr3;
    }

    public static boolean constantTimeAreEqual(int i11, byte[] bArr, int i12, byte[] bArr2, int i13) {
        Objects.requireNonNull(bArr, "'a' cannot be null");
        Objects.requireNonNull(bArr2, "'b' cannot be null");
        if (i11 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        } else if (i12 > bArr.length - i11) {
            throw new IndexOutOfBoundsException("'aOff' value invalid for specified length");
        } else if (i13 <= bArr2.length - i11) {
            byte b11 = 0;
            for (int i14 = 0; i14 < i11; i14++) {
                b11 |= bArr[i12 + i14] ^ bArr2[i13 + i14];
            }
            return b11 == 0;
        } else {
            throw new IndexOutOfBoundsException("'bOff' value invalid for specified length");
        }
    }

    public static boolean constantTimeAreEqual(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return false;
        }
        if (bArr == bArr2) {
            return true;
        }
        int length = bArr.length < bArr2.length ? bArr.length : bArr2.length;
        byte length2 = bArr.length ^ bArr2.length;
        for (int i11 = 0; i11 != length; i11++) {
            length2 |= bArr[i11] ^ bArr2[i11];
        }
        while (length < bArr2.length) {
            length2 |= bArr2[length] ^ (~bArr2[length]);
            length++;
        }
        return length2 == 0;
    }

    public static boolean contains(byte[] bArr, byte b11) {
        for (byte b12 : bArr) {
            if (b12 == b11) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(char[] cArr, char c11) {
        for (char c12 : cArr) {
            if (c12 == c11) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] iArr, int i11) {
        for (int i12 : iArr) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(long[] jArr, long j11) {
        for (long j12 : jArr) {
            if (j12 == j11) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(short[] sArr, short s11) {
        for (short s12 : sArr) {
            if (s12 == s11) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(boolean[] zArr, boolean z11) {
        for (boolean z12 : zArr) {
            if (z12 == z11) {
                return true;
            }
        }
        return false;
    }

    public static byte[] copyOf(byte[] bArr, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i11));
        return bArr2;
    }

    public static char[] copyOf(char[] cArr, int i11) {
        char[] cArr2 = new char[i11];
        System.arraycopy(cArr, 0, cArr2, 0, Math.min(cArr.length, i11));
        return cArr2;
    }

    public static int[] copyOf(int[] iArr, int i11) {
        int[] iArr2 = new int[i11];
        System.arraycopy(iArr, 0, iArr2, 0, Math.min(iArr.length, i11));
        return iArr2;
    }

    public static long[] copyOf(long[] jArr, int i11) {
        long[] jArr2 = new long[i11];
        System.arraycopy(jArr, 0, jArr2, 0, Math.min(jArr.length, i11));
        return jArr2;
    }

    public static BigInteger[] copyOf(BigInteger[] bigIntegerArr, int i11) {
        BigInteger[] bigIntegerArr2 = new BigInteger[i11];
        System.arraycopy(bigIntegerArr, 0, bigIntegerArr2, 0, Math.min(bigIntegerArr.length, i11));
        return bigIntegerArr2;
    }

    public static short[] copyOf(short[] sArr, int i11) {
        short[] sArr2 = new short[i11];
        System.arraycopy(sArr, 0, sArr2, 0, Math.min(sArr.length, i11));
        return sArr2;
    }

    public static boolean[] copyOf(boolean[] zArr, int i11) {
        boolean[] zArr2 = new boolean[i11];
        System.arraycopy(zArr, 0, zArr2, 0, Math.min(zArr.length, i11));
        return zArr2;
    }

    public static byte[] copyOfRange(byte[] bArr, int i11, int i12) {
        int length = getLength(i11, i12);
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i11, bArr2, 0, Math.min(bArr.length - i11, length));
        return bArr2;
    }

    public static char[] copyOfRange(char[] cArr, int i11, int i12) {
        int length = getLength(i11, i12);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, i11, cArr2, 0, Math.min(cArr.length - i11, length));
        return cArr2;
    }

    public static int[] copyOfRange(int[] iArr, int i11, int i12) {
        int length = getLength(i11, i12);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, i11, iArr2, 0, Math.min(iArr.length - i11, length));
        return iArr2;
    }

    public static long[] copyOfRange(long[] jArr, int i11, int i12) {
        int length = getLength(i11, i12);
        long[] jArr2 = new long[length];
        System.arraycopy(jArr, i11, jArr2, 0, Math.min(jArr.length - i11, length));
        return jArr2;
    }

    public static BigInteger[] copyOfRange(BigInteger[] bigIntegerArr, int i11, int i12) {
        int length = getLength(i11, i12);
        BigInteger[] bigIntegerArr2 = new BigInteger[length];
        System.arraycopy(bigIntegerArr, i11, bigIntegerArr2, 0, Math.min(bigIntegerArr.length - i11, length));
        return bigIntegerArr2;
    }

    public static short[] copyOfRange(short[] sArr, int i11, int i12) {
        int length = getLength(i11, i12);
        short[] sArr2 = new short[length];
        System.arraycopy(sArr, i11, sArr2, 0, Math.min(sArr.length - i11, length));
        return sArr2;
    }

    public static boolean[] copyOfRange(boolean[] zArr, int i11, int i12) {
        int length = getLength(i11, i12);
        boolean[] zArr2 = new boolean[length];
        System.arraycopy(zArr, i11, zArr2, 0, Math.min(zArr.length - i11, length));
        return zArr2;
    }

    public static void fill(byte[] bArr, byte b11) {
        java.util.Arrays.fill(bArr, b11);
    }

    public static void fill(byte[] bArr, int i11, int i12, byte b11) {
        java.util.Arrays.fill(bArr, i11, i12, b11);
    }

    public static void fill(char[] cArr, char c11) {
        java.util.Arrays.fill(cArr, c11);
    }

    public static void fill(char[] cArr, int i11, int i12, char c11) {
        java.util.Arrays.fill(cArr, i11, i12, c11);
    }

    public static void fill(int[] iArr, int i11) {
        java.util.Arrays.fill(iArr, i11);
    }

    public static void fill(int[] iArr, int i11, int i12, int i13) {
        java.util.Arrays.fill(iArr, i11, i12, i13);
    }

    public static void fill(long[] jArr, int i11, int i12, long j11) {
        java.util.Arrays.fill(jArr, i11, i12, j11);
    }

    public static void fill(long[] jArr, long j11) {
        java.util.Arrays.fill(jArr, j11);
    }

    public static void fill(Object[] objArr, int i11, int i12, Object obj) {
        java.util.Arrays.fill(objArr, i11, i12, obj);
    }

    public static void fill(Object[] objArr, Object obj) {
        java.util.Arrays.fill(objArr, obj);
    }

    public static void fill(short[] sArr, int i11, int i12, short s11) {
        java.util.Arrays.fill(sArr, i11, i12, s11);
    }

    public static void fill(short[] sArr, short s11) {
        java.util.Arrays.fill(sArr, s11);
    }

    public static void fill(boolean[] zArr, int i11, int i12, boolean z11) {
        java.util.Arrays.fill(zArr, i11, i12, z11);
    }

    public static void fill(boolean[] zArr, boolean z11) {
        java.util.Arrays.fill(zArr, z11);
    }

    private static int getLength(int i11, int i12) {
        int i13 = i12 - i11;
        if (i13 >= 0) {
            return i13;
        }
        StringBuffer stringBuffer = new StringBuffer(i11);
        stringBuffer.append(" > ");
        stringBuffer.append(i12);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public static int hashCode(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i11 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            i11 = (i11 * 257) ^ bArr[length];
        }
    }

    public static int hashCode(byte[] bArr, int i11, int i12) {
        if (bArr == null) {
            return 0;
        }
        int i13 = i12 + 1;
        while (true) {
            i12--;
            if (i12 < 0) {
                return i13;
            }
            i13 = (i13 * 257) ^ bArr[i11 + i12];
        }
    }

    public static int hashCode(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i11 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            i11 = (i11 * 257) ^ cArr[length];
        }
    }

    public static int hashCode(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i11 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            i11 = (i11 * 257) ^ iArr[length];
        }
    }

    public static int hashCode(int[] iArr, int i11, int i12) {
        if (iArr == null) {
            return 0;
        }
        int i13 = i12 + 1;
        while (true) {
            i12--;
            if (i12 < 0) {
                return i13;
            }
            i13 = (i13 * 257) ^ iArr[i11 + i12];
        }
    }

    public static int hashCode(long[] jArr) {
        if (jArr == null) {
            return 0;
        }
        int length = jArr.length;
        int i11 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            long j11 = jArr[length];
            i11 = (((i11 * 257) ^ ((int) j11)) * 257) ^ ((int) (j11 >>> 32));
        }
    }

    public static int hashCode(long[] jArr, int i11, int i12) {
        if (jArr == null) {
            return 0;
        }
        int i13 = i12 + 1;
        while (true) {
            i12--;
            if (i12 < 0) {
                return i13;
            }
            long j11 = jArr[i11 + i12];
            i13 = (((i13 * 257) ^ ((int) j11)) * 257) ^ ((int) (j11 >>> 32));
        }
    }

    public static int hashCode(Object[] objArr) {
        if (objArr == null) {
            return 0;
        }
        int length = objArr.length;
        int i11 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            i11 = (i11 * 257) ^ Objects.hashCode(objArr[length]);
        }
    }

    public static int hashCode(short[] sArr) {
        if (sArr == null) {
            return 0;
        }
        int length = sArr.length;
        int i11 = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i11;
            }
            i11 = (i11 * 257) ^ (sArr[length] & 255);
        }
    }

    public static int hashCode(int[][] iArr) {
        int i11 = 0;
        for (int i12 = 0; i12 != iArr.length; i12++) {
            i11 = (i11 * 257) + hashCode(iArr[i12]);
        }
        return i11;
    }

    public static int hashCode(short[][] sArr) {
        int i11 = 0;
        for (int i12 = 0; i12 != sArr.length; i12++) {
            i11 = (i11 * 257) + hashCode(sArr[i12]);
        }
        return i11;
    }

    public static int hashCode(short[][][] sArr) {
        int i11 = 0;
        for (int i12 = 0; i12 != sArr.length; i12++) {
            i11 = (i11 * 257) + hashCode(sArr[i12]);
        }
        return i11;
    }

    public static boolean isNullOrContainsNull(Object[] objArr) {
        if (objArr == null) {
            return true;
        }
        for (Object obj : objArr) {
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNullOrEmpty(byte[] bArr) {
        return bArr == null || bArr.length < 1;
    }

    public static boolean isNullOrEmpty(int[] iArr) {
        return iArr == null || iArr.length < 1;
    }

    public static boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length < 1;
    }

    public static byte[] prepend(byte[] bArr, byte b11) {
        if (bArr == null) {
            return new byte[]{b11};
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[(length + 1)];
        System.arraycopy(bArr, 0, bArr2, 1, length);
        bArr2[0] = b11;
        return bArr2;
    }

    public static int[] prepend(int[] iArr, int i11) {
        if (iArr == null) {
            return new int[]{i11};
        }
        int length = iArr.length;
        int[] iArr2 = new int[(length + 1)];
        System.arraycopy(iArr, 0, iArr2, 1, length);
        iArr2[0] = i11;
        return iArr2;
    }

    public static short[] prepend(short[] sArr, short s11) {
        if (sArr == null) {
            return new short[]{s11};
        }
        int length = sArr.length;
        short[] sArr2 = new short[(length + 1)];
        System.arraycopy(sArr, 0, sArr2, 1, length);
        sArr2[0] = s11;
        return sArr2;
    }

    public static byte[] reverse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int i11 = 0;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        while (true) {
            length--;
            if (length < 0) {
                return bArr2;
            }
            bArr2[length] = bArr[i11];
            i11++;
        }
    }

    public static int[] reverse(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int i11 = 0;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        while (true) {
            length--;
            if (length < 0) {
                return iArr2;
            }
            iArr2[length] = iArr[i11];
            i11++;
        }
    }

    public static byte[] reverseInPlace(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length - 1;
        for (int i11 = 0; i11 < length; i11++) {
            byte b11 = bArr[i11];
            bArr[i11] = bArr[length];
            bArr[length] = b11;
            length--;
        }
        return bArr;
    }

    public static int[] reverseInPlace(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length - 1;
        for (int i11 = 0; i11 < length; i11++) {
            int i12 = iArr[i11];
            iArr[i11] = iArr[length];
            iArr[length] = i12;
            length--;
        }
        return iArr;
    }
}
