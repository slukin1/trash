package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfRect2d extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 6;

    public MatOfRect2d() {
    }

    public static MatOfRect2d fromNativeAddr(long j11) {
        return new MatOfRect2d(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(6, 4));
        }
    }

    public void fromArray(Rect2d... rect2dArr) {
        if (rect2dArr != null && rect2dArr.length != 0) {
            int length = rect2dArr.length;
            alloc(length);
            double[] dArr = new double[(length * 4)];
            for (int i11 = 0; i11 < length; i11++) {
                Rect2d rect2d = rect2dArr[i11];
                int i12 = i11 * 4;
                dArr[i12 + 0] = rect2d.f25594x;
                dArr[i12 + 1] = rect2d.f25595y;
                dArr[i12 + 2] = rect2d.width;
                dArr[i12 + 3] = rect2d.height;
            }
            put(0, 0, dArr);
        }
    }

    public void fromList(List<Rect2d> list) {
        fromArray((Rect2d[]) list.toArray(new Rect2d[0]));
    }

    public Rect2d[] toArray() {
        int i11 = (int) total();
        Rect2d[] rect2dArr = new Rect2d[i11];
        if (i11 == 0) {
            return rect2dArr;
        }
        double[] dArr = new double[(i11 * 4)];
        get(0, 0, dArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 4;
            rect2dArr[i12] = new Rect2d(dArr[i13], dArr[i13 + 1], dArr[i13 + 2], dArr[i13 + 3]);
        }
        return rect2dArr;
    }

    public List<Rect2d> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRect2d(long j11) {
        super(j11);
        if (!empty() && checkVector(4, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect2d(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 6) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect2d(Rect2d... rect2dArr) {
        fromArray(rect2dArr);
    }
}
