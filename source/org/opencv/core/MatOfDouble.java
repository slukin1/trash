package org.opencv.core;

import a.a;
import java.util.Arrays;
import java.util.List;

public class MatOfDouble extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 6;

    public MatOfDouble() {
    }

    public static MatOfDouble fromNativeAddr(long j11) {
        return new MatOfDouble(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(6, 1));
        }
    }

    public void fromArray(double... dArr) {
        if (dArr != null && dArr.length != 0) {
            alloc(dArr.length / 1);
            put(0, 0, dArr);
        }
    }

    public void fromList(List<Double> list) {
        if (list != null && list.size() != 0) {
            Double[] dArr = (Double[]) list.toArray(new Double[0]);
            double[] dArr2 = new double[dArr.length];
            for (int i11 = 0; i11 < dArr.length; i11++) {
                dArr2[i11] = dArr[i11].doubleValue();
            }
            fromArray(dArr2);
        }
    }

    public double[] toArray() {
        int checkVector = checkVector(1, 6);
        if (checkVector >= 0) {
            double[] dArr = new double[(checkVector * 1)];
            if (checkVector == 0) {
                return dArr;
            }
            get(0, 0, dArr);
            return dArr;
        }
        StringBuilder c11 = a.c("Native Mat has unexpected type or size: ");
        c11.append(toString());
        throw new RuntimeException(c11.toString());
    }

    public List<Double> toList() {
        double[] array = toArray();
        Double[] dArr = new Double[array.length];
        for (int i11 = 0; i11 < array.length; i11++) {
            dArr[i11] = Double.valueOf(array[i11]);
        }
        return Arrays.asList(dArr);
    }

    public MatOfDouble(long j11) {
        super(j11);
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfDouble(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfDouble(double... dArr) {
        fromArray(dArr);
    }
}
