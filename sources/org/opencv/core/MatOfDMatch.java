package org.opencv.core;

import a.a;
import java.util.Arrays;
import java.util.List;

public class MatOfDMatch extends Mat {
    private static final int _channels = 4;
    private static final int _depth = 5;

    public MatOfDMatch() {
    }

    public static MatOfDMatch fromNativeAddr(long j11) {
        return new MatOfDMatch(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(5, 4));
        }
    }

    public void fromArray(DMatch... dMatchArr) {
        if (dMatchArr != null && dMatchArr.length != 0) {
            int length = dMatchArr.length;
            alloc(length);
            float[] fArr = new float[(length * 4)];
            for (int i11 = 0; i11 < length; i11++) {
                DMatch dMatch = dMatchArr[i11];
                int i12 = i11 * 4;
                fArr[i12 + 0] = (float) dMatch.queryIdx;
                fArr[i12 + 1] = (float) dMatch.trainIdx;
                fArr[i12 + 2] = (float) dMatch.imgIdx;
                fArr[i12 + 3] = dMatch.distance;
            }
            put(0, 0, fArr);
        }
    }

    public void fromList(List<DMatch> list) {
        fromArray((DMatch[]) list.toArray(new DMatch[0]));
    }

    public DMatch[] toArray() {
        int i11 = (int) total();
        DMatch[] dMatchArr = new DMatch[i11];
        if (i11 == 0) {
            return dMatchArr;
        }
        float[] fArr = new float[(i11 * 4)];
        get(0, 0, fArr);
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = i12 * 4;
            dMatchArr[i12] = new DMatch((int) fArr[i13 + 0], (int) fArr[i13 + 1], (int) fArr[i13 + 2], fArr[i13 + 3]);
        }
        return dMatchArr;
    }

    public List<DMatch> toList() {
        return Arrays.asList(toArray());
    }

    public MatOfDMatch(long j11) {
        super(j11);
        if (!empty() && checkVector(4, 5) < 0) {
            StringBuilder c11 = a.c("Incompatible Mat: ");
            c11.append(toString());
            throw new IllegalArgumentException(c11.toString());
        }
    }

    public MatOfDMatch(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(4, 5) < 0) {
            StringBuilder c11 = a.c("Incompatible Mat: ");
            c11.append(toString());
            throw new IllegalArgumentException(c11.toString());
        }
    }

    public MatOfDMatch(DMatch... dMatchArr) {
        fromArray(dMatchArr);
    }
}
