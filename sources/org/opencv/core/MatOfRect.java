package org.opencv.core;

import java.util.Arrays;
import java.util.List;

public class MatOfRect extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 4;

    public MatOfRect() {
    }

    public static MatOfRect fromNativeAddr(long j11) {
        return new MatOfRect(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(4, 4));
        }
    }

    public void fromArray(Rect... rectArr) {
        if (rectArr != null && rectArr.length != 0) {
            int length = rectArr.length;
            alloc(length);
            int[] iArr = new int[(length * 4)];
            for (int i11 = 0; i11 < length; i11++) {
                Rect rect = rectArr[i11];
                int i12 = i11 * 4;
                iArr[i12 + 0] = rect.f25592x;
                iArr[i12 + 1] = rect.f25593y;
                iArr[i12 + 2] = rect.width;
                iArr[i12 + 3] = rect.height;
            }
            put(0, 0, iArr);
        }
    }

    public void fromList(List<Rect> list) {
        fromArray((Rect[]) list.toArray(new Rect[0]));
    }

    public Rect[] toArray() {
        int i11 = (int) total();
        Rect[] rectArr = new Rect[i11];
        if (i11 == 0) {
            return rectArr;
        }
        int[] iArr = new int[(i11 * 4)];
        get(0, 0, iArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 4;
            rectArr[i12] = new Rect(iArr[i13], iArr[i13 + 1], iArr[i13 + 2], iArr[i13 + 3]);
        }
        return rectArr;
    }

    public List<Rect> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfRect(long j11) {
        super(j11);
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 4) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfRect(Rect... rectArr) {
        fromArray(rectArr);
    }
}
