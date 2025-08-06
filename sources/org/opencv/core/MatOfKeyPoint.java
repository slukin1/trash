package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfKeyPoint extends Mat {
    private static final int _channels = 7;
    private static final int _depth = 5;

    public MatOfKeyPoint() {
    }

    public static MatOfKeyPoint fromNativeAddr(long j11) {
        return new MatOfKeyPoint(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(5, 7));
        }
    }

    public void fromArray(KeyPoint... keyPointArr) {
        if (keyPointArr != null && keyPointArr.length != 0) {
            int length = keyPointArr.length;
            alloc(length);
            float[] fArr = new float[(length * 7)];
            for (int i11 = 0; i11 < length; i11++) {
                KeyPoint keyPoint = keyPointArr[i11];
                int i12 = i11 * 7;
                Point point = keyPoint.f25586pt;
                fArr[i12 + 0] = (float) point.f25587x;
                fArr[i12 + 1] = (float) point.f25588y;
                fArr[i12 + 2] = keyPoint.size;
                fArr[i12 + 3] = keyPoint.angle;
                fArr[i12 + 4] = keyPoint.response;
                fArr[i12 + 5] = (float) keyPoint.octave;
                fArr[i12 + 6] = (float) keyPoint.class_id;
            }
            put(0, 0, fArr);
        }
    }

    public void fromList(List<KeyPoint> list) {
        fromArray((KeyPoint[]) list.toArray(new KeyPoint[0]));
    }

    public KeyPoint[] toArray() {
        int i11 = (int) total();
        KeyPoint[] keyPointArr = new KeyPoint[i11];
        if (i11 == 0) {
            return keyPointArr;
        }
        float[] fArr = new float[(i11 * 7)];
        get(0, 0, fArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 7;
            keyPointArr[i12] = new KeyPoint(fArr[i13 + 0], fArr[i13 + 1], fArr[i13 + 2], fArr[i13 + 3], fArr[i13 + 4], (int) fArr[i13 + 5], (int) fArr[i13 + 6]);
        }
        return keyPointArr;
    }

    public List<KeyPoint> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfKeyPoint(long j11) {
        super(j11);
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfKeyPoint(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(7, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfKeyPoint(KeyPoint... keyPointArr) {
        fromArray(keyPointArr);
    }
}
