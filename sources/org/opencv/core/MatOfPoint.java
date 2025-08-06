package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfPoint extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 4;

    public MatOfPoint() {
    }

    public static MatOfPoint fromNativeAddr(long j11) {
        return new MatOfPoint(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(4, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr != null && pointArr.length != 0) {
            int length = pointArr.length;
            alloc(length);
            int[] iArr = new int[(length * 2)];
            for (int i11 = 0; i11 < length; i11++) {
                Point point = pointArr[i11];
                int i12 = i11 * 2;
                iArr[i12 + 0] = (int) point.f25587x;
                iArr[i12 + 1] = (int) point.f25588y;
            }
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Point> list) {
        fromArray((Point[]) list.toArray(new Point[0]));
    }

    public Point[] toArray() {
        int i11 = (int) total();
        Point[] pointArr = new Point[i11];
        if (i11 == 0) {
            return pointArr;
        }
        int[] iArr = new int[(i11 * 2)];
        get(0, 0, iArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 2;
            pointArr[i12] = new Point((double) iArr[i13], (double) iArr[i13 + 1]);
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint(long j11) {
        super(j11);
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint(Point... pointArr) {
        fromArray(pointArr);
    }
}
