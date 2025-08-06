package com.facebook.appevents.ml;

final class Operator {
    public static float[] add(float[] fArr, float[] fArr2, int i11, int i12, int i13) {
        for (int i14 = 0; i14 < i11 * i12; i14++) {
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = (i14 * i13) + i15;
                fArr[i16] = fArr[i16] + fArr2[i15];
            }
        }
        return fArr;
    }

    public static float[] concatenate(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[(fArr.length + fArr2.length)];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        return fArr3;
    }

    public static float[] conv1D(float[] fArr, float[] fArr2, int i11, int i12, int i13, int i14, int i15) {
        int i16 = i11;
        int i17 = i13;
        int i18 = i14;
        int i19 = i15;
        int i21 = (i12 - i18) + 1;
        float[] fArr3 = new float[(i16 * i21 * i19)];
        for (int i22 = 0; i22 < i16; i22++) {
            for (int i23 = 0; i23 < i19; i23++) {
                for (int i24 = 0; i24 < i21; i24++) {
                    float f11 = 0.0f;
                    for (int i25 = 0; i25 < i18; i25++) {
                        for (int i26 = 0; i26 < i17; i26++) {
                            f11 += fArr[(i12 * i17 * i22) + ((i25 + i24) * i17) + i26] * fArr2[(((i25 * i17) + i26) * i19) + i23];
                        }
                    }
                    fArr3[(i19 * i21 * i22) + (i24 * i19) + i23] = f11;
                }
            }
        }
        return fArr3;
    }

    public static float[] dense(float[] fArr, float[] fArr2, float[] fArr3, int i11, int i12, int i13) {
        float[] mul = mul(fArr, fArr2, i11, i12, i13);
        for (int i14 = 0; i14 < i11; i14++) {
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = (i14 * i13) + i15;
                mul[i16] = mul[i16] + fArr3[i15];
            }
        }
        return mul;
    }

    public static float[] embedding(int[] iArr, float[] fArr, int i11, int i12, int i13) {
        float[] fArr2 = new float[(i11 * i12 * i13)];
        for (int i14 = 0; i14 < i11; i14++) {
            for (int i15 = 0; i15 < i12; i15++) {
                int i16 = iArr[(i14 * i12) + i15];
                for (int i17 = 0; i17 < i13; i17++) {
                    fArr2[(i13 * i12 * i14) + (i13 * i15) + i17] = fArr[(i16 * i13) + i17];
                }
            }
        }
        return fArr2;
    }

    public static float[] maxPool1D(float[] fArr, int i11, int i12, int i13) {
        int i14 = (i11 - i13) + 1;
        float[] fArr2 = new float[(i14 * i12)];
        for (int i15 = 0; i15 < i12; i15++) {
            for (int i16 = 0; i16 < i14; i16++) {
                for (int i17 = i16; i17 < i16 + i13; i17++) {
                    int i18 = (i16 * i12) + i15;
                    fArr2[i18] = Math.max(fArr2[i18], fArr[(i17 * i12) + i15]);
                }
            }
        }
        return fArr2;
    }

    public static float[] mul(float[] fArr, float[] fArr2, int i11, int i12, int i13) {
        float[] fArr3 = new float[(i11 * i13)];
        for (int i14 = 0; i14 < i11; i14++) {
            for (int i15 = 0; i15 < i13; i15++) {
                int i16 = (i14 * i13) + i15;
                fArr3[i16] = 0.0f;
                for (int i17 = 0; i17 < i12; i17++) {
                    fArr3[i16] = fArr3[i16] + (fArr[(i14 * i12) + i17] * fArr2[(i17 * i13) + i15]);
                }
            }
        }
        return fArr3;
    }

    public static void relu(float[] fArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            if (fArr[i12] < 0.0f) {
                fArr[i12] = 0.0f;
            }
        }
    }

    public static void softmax(float[] fArr, int i11) {
        float f11 = Float.MIN_VALUE;
        for (int i12 = 0; i12 < i11; i12++) {
            if (fArr[i12] > f11) {
                f11 = fArr[i12];
            }
        }
        for (int i13 = 0; i13 < i11; i13++) {
            fArr[i13] = (float) Math.exp((double) (fArr[i13] - f11));
        }
        float f12 = 0.0f;
        for (int i14 = 0; i14 < i11; i14++) {
            f12 += fArr[i14];
        }
        for (int i15 = 0; i15 < i11; i15++) {
            fArr[i15] = fArr[i15] / f12;
        }
    }

    public static float[] transpose2D(float[] fArr, int i11, int i12) {
        float[] fArr2 = new float[(i11 * i12)];
        for (int i13 = 0; i13 < i11; i13++) {
            for (int i14 = 0; i14 < i12; i14++) {
                fArr2[(i14 * i11) + i13] = fArr[(i13 * i12) + i14];
            }
        }
        return fArr2;
    }

    public static float[] transpose3D(float[] fArr, int i11, int i12, int i13) {
        float[] fArr2 = new float[(i11 * i12 * i13)];
        for (int i14 = 0; i14 < i11; i14++) {
            for (int i15 = 0; i15 < i12; i15++) {
                for (int i16 = 0; i16 < i13; i16++) {
                    fArr2[(i16 * i11 * i12) + (i15 * i11) + i14] = fArr[(i14 * i12 * i13) + (i15 * i13) + i16];
                }
            }
        }
        return fArr2;
    }
}
