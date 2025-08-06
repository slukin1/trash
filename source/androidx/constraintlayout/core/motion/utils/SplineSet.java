package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.Arrays;

public abstract class SplineSet {

    /* renamed from: a  reason: collision with root package name */
    public CurveFit f6902a;

    /* renamed from: b  reason: collision with root package name */
    public int[] f6903b = new int[10];

    /* renamed from: c  reason: collision with root package name */
    public float[] f6904c = new float[10];

    /* renamed from: d  reason: collision with root package name */
    public int f6905d;

    /* renamed from: e  reason: collision with root package name */
    public String f6906e;

    public static class a {
        public static void a(int[] iArr, float[] fArr, int i11, int i12) {
            int[] iArr2 = new int[(iArr.length + 10)];
            iArr2[0] = i12;
            iArr2[1] = i11;
            int i13 = 2;
            while (i13 > 0) {
                int i14 = i13 - 1;
                int i15 = iArr2[i14];
                i13 = i14 - 1;
                int i16 = iArr2[i13];
                if (i15 < i16) {
                    int b11 = b(iArr, fArr, i15, i16);
                    int i17 = i13 + 1;
                    iArr2[i13] = b11 - 1;
                    int i18 = i17 + 1;
                    iArr2[i17] = i15;
                    int i19 = i18 + 1;
                    iArr2[i18] = i16;
                    i13 = i19 + 1;
                    iArr2[i19] = b11 + 1;
                }
            }
        }

        public static int b(int[] iArr, float[] fArr, int i11, int i12) {
            int i13 = iArr[i12];
            int i14 = i11;
            while (i11 < i12) {
                if (iArr[i11] <= i13) {
                    c(iArr, fArr, i14, i11);
                    i14++;
                }
                i11++;
            }
            c(iArr, fArr, i14, i12);
            return i14;
        }

        public static void c(int[] iArr, float[] fArr, int i11, int i12) {
            int i13 = iArr[i11];
            iArr[i11] = iArr[i12];
            iArr[i12] = i13;
            float f11 = fArr[i11];
            fArr[i11] = fArr[i12];
            fArr[i12] = f11;
        }
    }

    public float a(float f11) {
        return (float) this.f6902a.c((double) f11, 0);
    }

    public float b(float f11) {
        return (float) this.f6902a.f((double) f11, 0);
    }

    public void c(int i11, float f11) {
        int[] iArr = this.f6903b;
        if (iArr.length < this.f6905d + 1) {
            this.f6903b = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.f6904c;
            this.f6904c = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.f6903b;
        int i12 = this.f6905d;
        iArr2[i12] = i11;
        this.f6904c[i12] = f11;
        this.f6905d = i12 + 1;
    }

    public void d(String str) {
        this.f6906e = str;
    }

    public void e(int i11) {
        int i12 = this.f6905d;
        if (i12 != 0) {
            a.a(this.f6903b, this.f6904c, 0, i12 - 1);
            int i13 = 1;
            for (int i14 = 1; i14 < this.f6905d; i14++) {
                int[] iArr = this.f6903b;
                if (iArr[i14 - 1] != iArr[i14]) {
                    i13++;
                }
            }
            double[] dArr = new double[i13];
            int[] iArr2 = new int[2];
            iArr2[1] = 1;
            iArr2[0] = i13;
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, iArr2);
            int i15 = 0;
            for (int i16 = 0; i16 < this.f6905d; i16++) {
                if (i16 > 0) {
                    int[] iArr3 = this.f6903b;
                    if (iArr3[i16] == iArr3[i16 - 1]) {
                    }
                }
                dArr[i15] = ((double) this.f6903b[i16]) * 0.01d;
                dArr2[i15][0] = (double) this.f6904c[i16];
                i15++;
            }
            this.f6902a = CurveFit.a(i11, dArr, dArr2);
        }
    }

    public String toString() {
        String str = this.f6906e;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i11 = 0; i11 < this.f6905d; i11++) {
            str = str + "[" + this.f6903b[i11] + " , " + decimalFormat.format((double) this.f6904c[i11]) + "] ";
        }
        return str;
    }
}
