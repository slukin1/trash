package androidx.constraintlayout.core.motion.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

public class f extends Easing {

    /* renamed from: d  reason: collision with root package name */
    public d f6996d;

    public f(String str) {
        this.f6848a = str;
        double[] dArr = new double[(str.length() / 2)];
        int indexOf = str.indexOf(40) + 1;
        int indexOf2 = str.indexOf(44, indexOf);
        int i11 = 0;
        while (indexOf2 != -1) {
            dArr[i11] = Double.parseDouble(str.substring(indexOf, indexOf2).trim());
            indexOf = indexOf2 + 1;
            indexOf2 = str.indexOf(44, indexOf);
            i11++;
        }
        dArr[i11] = Double.parseDouble(str.substring(indexOf, str.indexOf(41, indexOf)).trim());
        this.f6996d = d(Arrays.copyOf(dArr, i11 + 1));
    }

    public static d d(double[] dArr) {
        double[] dArr2 = dArr;
        int length = (dArr2.length * 3) - 2;
        int length2 = dArr2.length - 1;
        double d11 = 1.0d / ((double) length2);
        int[] iArr = new int[2];
        iArr[1] = 1;
        iArr[0] = length;
        double[][] dArr3 = (double[][]) Array.newInstance(double.class, iArr);
        double[] dArr4 = new double[length];
        for (int i11 = 0; i11 < dArr2.length; i11++) {
            double d12 = dArr2[i11];
            int i12 = i11 + length2;
            dArr3[i12][0] = d12;
            double d13 = ((double) i11) * d11;
            dArr4[i12] = d13;
            if (i11 > 0) {
                int i13 = (length2 * 2) + i11;
                dArr3[i13][0] = d12 + 1.0d;
                dArr4[i13] = d13 + 1.0d;
                int i14 = i11 - 1;
                dArr3[i14][0] = (d12 - 1.0d) - d11;
                dArr4[i14] = (d13 - 4.0d) - d11;
            }
        }
        d dVar = new d(dArr4, dArr3);
        System.out.println(" 0 " + dVar.c(0.0d, 0));
        System.out.println(" 1 " + dVar.c(1.0d, 0));
        return dVar;
    }

    public double a(double d11) {
        return this.f6996d.c(d11, 0);
    }

    public double b(double d11) {
        return this.f6996d.f(d11, 0);
    }
}
