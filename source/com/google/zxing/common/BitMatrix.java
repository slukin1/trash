package com.google.zxing.common;

import java.util.Arrays;

public final class BitMatrix implements Cloneable {
    private final int[] bits;
    private final int height;
    private final int rowSize;
    private final int width;

    public BitMatrix(int i11) {
        this(i11, i11);
    }

    private String buildToString(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.height * (this.width + 1));
        for (int i11 = 0; i11 < this.height; i11++) {
            for (int i12 = 0; i12 < this.width; i12++) {
                sb2.append(get(i12, i11) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public static BitMatrix parse(boolean[][] zArr) {
        int length = zArr.length;
        int length2 = zArr[0].length;
        BitMatrix bitMatrix = new BitMatrix(length2, length);
        for (int i11 = 0; i11 < length; i11++) {
            boolean[] zArr2 = zArr[i11];
            for (int i12 = 0; i12 < length2; i12++) {
                if (zArr2[i12]) {
                    bitMatrix.set(i12, i11);
                }
            }
        }
        return bitMatrix;
    }

    public void clear() {
        int length = this.bits.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.bits[i11] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BitMatrix)) {
            return false;
        }
        BitMatrix bitMatrix = (BitMatrix) obj;
        if (this.width == bitMatrix.width && this.height == bitMatrix.height && this.rowSize == bitMatrix.rowSize && Arrays.equals(this.bits, bitMatrix.bits)) {
            return true;
        }
        return false;
    }

    public void flip(int i11, int i12) {
        int i13 = (i12 * this.rowSize) + (i11 / 32);
        int[] iArr = this.bits;
        iArr[i13] = (1 << (i11 & 31)) ^ iArr[i13];
    }

    public boolean get(int i11, int i12) {
        return ((this.bits[(i12 * this.rowSize) + (i11 / 32)] >>> (i11 & 31)) & 1) != 0;
    }

    public int[] getBottomRightOnBit() {
        int length = this.bits.length - 1;
        while (length >= 0 && this.bits[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i11 = this.rowSize;
        int i12 = length / i11;
        int i13 = (length % i11) << 5;
        int i14 = 31;
        while ((this.bits[length] >>> i14) == 0) {
            i14--;
        }
        return new int[]{i13 + i14, i12};
    }

    public int[] getEnclosingRectangle() {
        int i11 = this.width;
        int i12 = this.height;
        int i13 = -1;
        int i14 = -1;
        for (int i15 = 0; i15 < this.height; i15++) {
            int i16 = 0;
            while (true) {
                int i17 = this.rowSize;
                if (i16 >= i17) {
                    break;
                }
                int i18 = this.bits[(i17 * i15) + i16];
                if (i18 != 0) {
                    if (i15 < i12) {
                        i12 = i15;
                    }
                    if (i15 > i14) {
                        i14 = i15;
                    }
                    int i19 = i16 << 5;
                    if (i19 < i11) {
                        int i21 = 0;
                        while ((i18 << (31 - i21)) == 0) {
                            i21++;
                        }
                        int i22 = i21 + i19;
                        if (i22 < i11) {
                            i11 = i22;
                        }
                    }
                    if (i19 + 31 > i13) {
                        int i23 = 31;
                        while ((i18 >>> i23) == 0) {
                            i23--;
                        }
                        int i24 = i19 + i23;
                        if (i24 > i13) {
                            i13 = i24;
                        }
                    }
                }
                i16++;
            }
        }
        if (i13 < i11 || i14 < i12) {
            return null;
        }
        return new int[]{i11, i12, (i13 - i11) + 1, (i14 - i12) + 1};
    }

    public int getHeight() {
        return this.height;
    }

    public BitArray getRow(int i11, BitArray bitArray) {
        if (bitArray == null || bitArray.getSize() < this.width) {
            bitArray = new BitArray(this.width);
        } else {
            bitArray.clear();
        }
        int i12 = i11 * this.rowSize;
        for (int i13 = 0; i13 < this.rowSize; i13++) {
            bitArray.setBulk(i13 << 5, this.bits[i12 + i13]);
        }
        return bitArray;
    }

    public int getRowSize() {
        return this.rowSize;
    }

    public int[] getTopLeftOnBit() {
        int[] iArr;
        int i11 = 0;
        while (true) {
            iArr = this.bits;
            if (i11 < iArr.length && iArr[i11] == 0) {
                i11++;
            }
        }
        if (i11 == iArr.length) {
            return null;
        }
        int i12 = this.rowSize;
        int i13 = i11 / i12;
        int i14 = (i11 % i12) << 5;
        int i15 = iArr[i11];
        int i16 = 0;
        while ((i15 << (31 - i16)) == 0) {
            i16++;
        }
        return new int[]{i14 + i16, i13};
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        int i11 = this.width;
        return (((((((i11 * 31) + i11) * 31) + this.height) * 31) + this.rowSize) * 31) + Arrays.hashCode(this.bits);
    }

    public void rotate180() {
        int width2 = getWidth();
        int height2 = getHeight();
        BitArray bitArray = new BitArray(width2);
        BitArray bitArray2 = new BitArray(width2);
        for (int i11 = 0; i11 < (height2 + 1) / 2; i11++) {
            bitArray = getRow(i11, bitArray);
            int i12 = (height2 - 1) - i11;
            bitArray2 = getRow(i12, bitArray2);
            bitArray.reverse();
            bitArray2.reverse();
            setRow(i11, bitArray2);
            setRow(i12, bitArray);
        }
    }

    public void set(int i11, int i12) {
        int i13 = (i12 * this.rowSize) + (i11 / 32);
        int[] iArr = this.bits;
        iArr[i13] = (1 << (i11 & 31)) | iArr[i13];
    }

    public void setRegion(int i11, int i12, int i13, int i14) {
        if (i12 < 0 || i11 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        } else if (i14 <= 0 || i13 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        } else {
            int i15 = i13 + i11;
            int i16 = i14 + i12;
            if (i16 > this.height || i15 > this.width) {
                throw new IllegalArgumentException("The region must fit inside the matrix");
            }
            while (i12 < i16) {
                int i17 = this.rowSize * i12;
                for (int i18 = i11; i18 < i15; i18++) {
                    int[] iArr = this.bits;
                    int i19 = (i18 / 32) + i17;
                    iArr[i19] = iArr[i19] | (1 << (i18 & 31));
                }
                i12++;
            }
        }
    }

    public void setRow(int i11, BitArray bitArray) {
        int[] bitArray2 = bitArray.getBitArray();
        int[] iArr = this.bits;
        int i12 = this.rowSize;
        System.arraycopy(bitArray2, 0, iArr, i11 * i12, i12);
    }

    public String toString() {
        return toString("X ", "  ");
    }

    public void unset(int i11, int i12) {
        int i13 = (i12 * this.rowSize) + (i11 / 32);
        int[] iArr = this.bits;
        iArr[i13] = (~(1 << (i11 & 31))) & iArr[i13];
    }

    public void xor(BitMatrix bitMatrix) {
        if (this.width == bitMatrix.getWidth() && this.height == bitMatrix.getHeight() && this.rowSize == bitMatrix.getRowSize()) {
            BitArray bitArray = new BitArray(this.width);
            for (int i11 = 0; i11 < this.height; i11++) {
                int i12 = this.rowSize * i11;
                int[] bitArray2 = bitMatrix.getRow(i11, bitArray).getBitArray();
                for (int i13 = 0; i13 < this.rowSize; i13++) {
                    int[] iArr = this.bits;
                    int i14 = i12 + i13;
                    iArr[i14] = iArr[i14] ^ bitArray2[i13];
                }
            }
            return;
        }
        throw new IllegalArgumentException("input matrix dimensions do not match");
    }

    public BitMatrix(int i11, int i12) {
        if (i11 <= 0 || i12 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.width = i11;
        this.height = i12;
        int i13 = (i11 + 31) / 32;
        this.rowSize = i13;
        this.bits = new int[(i13 * i12)];
    }

    public BitMatrix clone() {
        return new BitMatrix(this.width, this.height, this.rowSize, (int[]) this.bits.clone());
    }

    public String toString(String str, String str2) {
        return buildToString(str, str2, "\n");
    }

    @Deprecated
    public String toString(String str, String str2, String str3) {
        return buildToString(str, str2, str3);
    }

    public static BitMatrix parse(String str, String str2, String str3) {
        if (str != null) {
            boolean[] zArr = new boolean[str.length()];
            int i11 = -1;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            while (i12 < str.length()) {
                if (str.charAt(i12) == 10 || str.charAt(i12) == 13) {
                    if (i13 > i14) {
                        if (i11 == -1) {
                            i11 = i13 - i14;
                        } else if (i13 - i14 != i11) {
                            throw new IllegalArgumentException("row lengths do not match");
                        }
                        i15++;
                        i14 = i13;
                    }
                    i12++;
                } else {
                    if (str.substring(i12, str2.length() + i12).equals(str2)) {
                        i12 += str2.length();
                        zArr[i13] = true;
                    } else if (str.substring(i12, str3.length() + i12).equals(str3)) {
                        i12 += str3.length();
                        zArr[i13] = false;
                    } else {
                        throw new IllegalArgumentException("illegal character encountered: " + str.substring(i12));
                    }
                    i13++;
                }
            }
            if (i13 > i14) {
                if (i11 == -1) {
                    i11 = i13 - i14;
                } else if (i13 - i14 != i11) {
                    throw new IllegalArgumentException("row lengths do not match");
                }
                i15++;
            }
            BitMatrix bitMatrix = new BitMatrix(i11, i15);
            for (int i16 = 0; i16 < i13; i16++) {
                if (zArr[i16]) {
                    bitMatrix.set(i16 % i11, i16 / i11);
                }
            }
            return bitMatrix;
        }
        throw new IllegalArgumentException();
    }

    private BitMatrix(int i11, int i12, int i13, int[] iArr) {
        this.width = i11;
        this.height = i12;
        this.rowSize = i13;
        this.bits = iArr;
    }
}
