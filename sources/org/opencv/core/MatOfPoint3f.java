package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfPoint3f extends Mat {
    private static final int _channels = 3;
    private static final int _depth = 5;

    public MatOfPoint3f() {
    }

    public static MatOfPoint3f fromNativeAddr(long j11) {
        return new MatOfPoint3f(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(5, 3));
        }
    }

    public void fromArray(Point3... point3Arr) {
        if (point3Arr != null && point3Arr.length != 0) {
            int length = point3Arr.length;
            alloc(length);
            float[] fArr = new float[(length * 3)];
            for (int i11 = 0; i11 < length; i11++) {
                Point3 point3 = point3Arr[i11];
                int i12 = i11 * 3;
                fArr[i12 + 0] = (float) point3.f25589x;
                fArr[i12 + 1] = (float) point3.f25590y;
                fArr[i12 + 2] = (float) point3.f25591z;
            }
            put(0, 0, fArr);
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
        float[] fArr = new float[(i11 * 3)];
        get(0, 0, fArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 3;
            point3Arr[i12] = new Point3((double) fArr[i13], (double) fArr[i13 + 1], (double) fArr[i13 + 2]);
        }
        return point3Arr;
    }

    public List<Point3> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint3f(long j11) {
        super(j11);
        if (!empty() && checkVector(3, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3f(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(3, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint3f(Point3... point3Arr) {
        fromArray(point3Arr);
    }
}
