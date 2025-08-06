package org.opencv.core;

import a.a;
import java.util.Arrays;
import java.util.List;

public class MatOfFloat extends Mat {
    private static final int _channels = 1;
    private static final int _depth = 5;

    public MatOfFloat() {
    }

    public static MatOfFloat fromNativeAddr(long j11) {
        return new MatOfFloat(j11);
    }

    public void alloc(int i11) {
        if (i11 > 0) {
            super.create(i11, 1, CvType.makeType(5, 1));
        }
    }

    public void fromArray(float... fArr) {
        if (fArr != null && fArr.length != 0) {
            alloc(fArr.length / 1);
            put(0, 0, fArr);
        }
    }

    public void fromList(List<Float> list) {
        if (list != null && list.size() != 0) {
            Float[] fArr = (Float[]) list.toArray(new Float[0]);
            float[] fArr2 = new float[fArr.length];
            for (int i11 = 0; i11 < fArr.length; i11++) {
                fArr2[i11] = fArr[i11].floatValue();
            }
            fromArray(fArr2);
        }
    }

    public float[] toArray() {
        int checkVector = checkVector(1, 5);
        if (checkVector >= 0) {
            float[] fArr = new float[(checkVector * 1)];
            if (checkVector == 0) {
                return fArr;
            }
            get(0, 0, fArr);
            return fArr;
        }
        StringBuilder c11 = a.c("Native Mat has unexpected type or size: ");
        c11.append(toString());
        throw new RuntimeException(c11.toString());
    }

    public List<Float> toList() {
        float[] array = toArray();
        Float[] fArr = new Float[array.length];
        for (int i11 = 0; i11 < array.length; i11++) {
            fArr[i11] = Float.valueOf(array[i11]);
        }
        return Arrays.asList(fArr);
    }

    public MatOfFloat(long j11) {
        super(j11);
        if (!empty() && checkVector(1, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfFloat(Mat mat) {
        super(mat, Range.all());
        if (!empty() && checkVector(1, 5) < 0) {
            throw new IllegalArgumentException("Incompatible Mat");
        }
    }

    public MatOfFloat(float... fArr) {
        fromArray(fArr);
    }
}
