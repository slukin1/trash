package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfPoint3 extends Mat {
    private static final int _channels = 3;
    private static final int _depth = 4;

    public MatOfPoint3() {
    }

    public static MatOfPoint3 fromNativeAddr(long j11) {
        return new MatOfPoint3(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(4, 3));
        }
    }

    public void fromArray(Point3... point3Arr) {
        if (point3Arr != null && point3Arr.length != 0) {
            int length = point3Arr.length;
            alloc(length);
            int[] iArr = new int[(length * 3)];
            for (int i11 = 0; i11 < length; i11++) {
                Point3 point3 = point3Arr[i11];
                int i12 = i11 * 3;
                iArr[i12 + 0] = (int) point3.f25589x;
                iArr[i12 + 1] = (int) point3.f25590y;
                iArr[i12 + 2] = (int) point3.f25591z;
            }
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Point3> list) {
        fromArray((Point3[]) list.toArray(new Point3[0]));
    }

    public Point3[] toArray() {
        int i11 = (int) total();
        Point3[] point3Arr = new Point3[i11];
        if (i11 == 0) {
            return point3Arr;
        }
        int[] iArr = new int[(i11 * 3)];
        get(0, 0, iArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 3;
            point3Arr[i12] = new Point3((double) iArr[i13], (double) iArr[i13 + 1], (double) iArr[i13 + 2]);
        }
        return point3Arr;
    }

    public List<Point3> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint3(long j11) {
        super(j11);
        if (!empty() && checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(3, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3(Point3... point3Arr) {
        fromArray(point3Arr);
    }
}
