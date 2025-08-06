package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfPoint2f extends Mat {
    private static final int _channels = 2;
    private static final int _depth = 5;

    public MatOfPoint2f() {
    }

    public static MatOfPoint2f fromNativeAddr(long j11) {
        return new MatOfPoint2f(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(5, 2));
        }
    }

    public void fromArray(Point... pointArr) {
        if (pointArr != null && pointArr.length != 0) {
            int length = pointArr.length;
            alloc(length);
            float[] fArr = new float[(length * 2)];
            for (int i11 = 0; i11 < length; i11++) {
                Point point = pointArr[i11];
                int i12 = i11 * 2;
                fArr[i12 + 0] = (float) point.f25587x;
                fArr[i12 + 1] = (float) point.f25588y;
            }
            put(0, 0, fArr);
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
        float[] fArr = new float[(i11 * 2)];
        get(0, 0, fArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 2;
            pointArr[i12] = new Point((double) fArr[i13], (double) fArr[i13 + 1]);
        }
        return pointArr;
    }

    public List<Point> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfPoint2f(long j11) {
        super(j11);
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint2f(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(2, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfPoint2f(Point... pointArr) {
        fromArray(pointArr);
    }
}
