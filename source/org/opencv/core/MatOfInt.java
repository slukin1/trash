package org.opencv.core;

import a.a;
import java.util.Arrays;
import java.util.List;

public class MatOfInt extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 4;

    public MatOfInt() {
    }

    public static MatOfInt fromNativeAddr(long j11) {
        return new MatOfInt(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(4, 1));
        }
    }

    public void fromArray(int... iArr) {
        if (iArr != null && iArr.length != 0) {
            alloc(iArr.length / 1);
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Integer> list) {
        if (list != null && list.size() != 0) {
            Integer[] numArr = (Integer[]) list.toArray(new Integer[0]);
            int[] iArr = new int[numArr.length];
            for (int i11 = 0; i11 < numArr.length; i11++) {
                iArr[i11] = numArr[i11].intValue();
            }
            fromArray(iArr);
        }
    }

    public int[] toArray() {
        int checkVector = checkVector(1, 4);
        if (checkVector >= 0) {
            int[] iArr = new int[(checkVector * 1)];
            if (checkVector == 0) {
                return iArr;
            }
            get(0, 0, iArr);
            return iArr;
        }
        StringBuilder c11 = a.c("Native Mat has unexpected type or size: ");
        c11.append(toString());
        throw new RuntimeException(c11.toString());
    }

    public List<Integer> toList() {
        int[] array = toArray();
        Integer[] numArr = new Integer[array.length];
        for (int i11 = 0; i11 < array.length; i11++) {
            numArr[i11] = Integer.valueOf(array[i11]);
        }
        return Arrays.asList(numArr);
    }

    public MatOfInt(long j11) {
        super(j11);
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfInt(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfInt(int... iArr) {
        fromArray(iArr);
    }
}
