package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfRotatedRect extends Mat {
    private static final int _channels = 5;
    private static final int _depth = 5;

    public MatOfRotatedRect() {
    }

    public static MatOfRotatedRect fromNativeAddr(long j11) {
        return new MatOfRotatedRect(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(5, 5));
        }
    }

    public void fromArray(RotatedRect... rotatedRectArr) {
        if (rotatedRectArr != null && rotatedRectArr.length != 0) {
            int length = rotatedRectArr.length;
            alloc(length);
            float[] fArr = new float[(length * 5)];
            for (int i11 = 0; i11 < length; i11++) {
                RotatedRect rotatedRect = rotatedRectArr[i11];
                int i12 = i11 * 5;
                Point point = rotatedRect.center;
                fArr[i12 + 0] = (float) point.f25587x;
                fArr[i12 + 1] = (float) point.f25588y;
                Size size = rotatedRect.size;
                fArr[i12 + 2] = (float) size.width;
                fArr[i12 + 3] = (float) size.height;
                fArr[i12 + 4] = (float) rotatedRect.angle;
            }
            put(0, 0, fArr);
        }
    }

    public void fromList(List<RotatedRect> list) {
        fromArray((RotatedRect[]) list.toArray(new RotatedRect[0]));
    }

    public RotatedRect[] toArray() {
        int i11 = (int) total();
        RotatedRect[] rotatedRectArr = new RotatedRect[i11];
        if (i11 == 0) {
            return rotatedRectArr;
        }
        float[] fArr = new float[5];
        for (int i12 = 0; i12 < i11; i12++) {
            get(i12, 0, fArr);
            rotatedRectArr[i12] = new RotatedRect(new Point((double) fArr[0], (double) fArr[1]), new Size((double) fArr[2], (double) fArr[3]), (double) fArr[4]);
        }
        return rotatedRectArr;
    }

    public List<RotatedRect> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRotatedRect(long j11) {
        super(j11);
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRotatedRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(5, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRotatedRect(RotatedRect... rotatedRectArr) {
        fromArray(rotatedRectArr);
    }
}
