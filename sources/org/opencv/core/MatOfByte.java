package org.opencv.core;

import a.a;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MatOfByte extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 0;

    public MatOfByte() {
    }

    public static MatOfByte fromNativeAddr(long j11) {
        return new MatOfByte(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(0, 1));
        }
    }

    public void fromArray(byte... bArr) {
        if (bArr != null && bArr.length != 0) {
            alloc(bArr.length / 1);
            put(0, 0, bArr);
        }
    }

    public void fromList(List<Byte> list) {
        if (list != null && list.size() != 0) {
            Byte[] bArr = (Byte[]) list.toArray(new Byte[0]);
            byte[] bArr2 = new byte[bArr.length];
            for (int i11 = 0; i11 < bArr.length; i11++) {
                bArr2[i11] = bArr[i11].byteValue();
            }
            fromArray(bArr2);
        }
    }

    public byte[] toArray() {
        int checkVector = checkVector(1, 0);
        if (checkVector >= 0) {
            byte[] bArr = new byte[(checkVector * 1)];
            if (checkVector == 0) {
                return bArr;
            }
            get(0, 0, bArr);
            return bArr;
        }
        StringBuilder c11 = a.c("Native Mat has unexpected type or size: ");
        c11.append(toString());
        throw new RuntimeException(c11.toString());
    }

    public List<Byte> toList() {
        byte[] array = toArray();
        Byte[] bArr = new Byte[array.length];
        for (int i11 = 0; i11 < array.length; i11++) {
            bArr[i11] = Byte.valueOf(array[i11]);
        }
        return Arrays.asList(bArr);
    }

    public MatOfByte(long j11) {
        super(j11);
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfByte(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 0) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public void fromArray(int i11, int i12, byte... bArr) {
        if (i11 >= 0) {
            Objects.requireNonNull(bArr);
            if (i12 < 0 || i12 + i11 > bArr.length) {
                StringBuilder c11 = a.c("invalid 'length' parameter: ");
                c11.append(Integer.toString(i12));
                throw new IllegalArgumentException(c11.toString());
            } else if (bArr.length != 0) {
                alloc(i12 / 1);
                put(0, 0, bArr, i11, i12);
            }
        } else {
            throw new IllegalArgumentException("offset < 0");
        }
    }

    public MatOfByte(byte... bArr) {
        fromArray(bArr);
    }

    public MatOfByte(int i11, int i12, byte... bArr) {
        fromArray(i11, i12, bArr);
    }
}
