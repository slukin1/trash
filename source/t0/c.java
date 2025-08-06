package t0;

import android.graphics.Color;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<double[]> f16510a = new ThreadLocal<>();

    public static void a(int i11, int i12, int i13, double[] dArr) {
        double d11;
        double d12;
        double d13;
        double[] dArr2 = dArr;
        if (dArr2.length == 3) {
            double d14 = ((double) i11) / 255.0d;
            if (d14 < 0.04045d) {
                d11 = d14 / 12.92d;
            } else {
                d11 = Math.pow((d14 + 0.055d) / 1.055d, 2.4d);
            }
            double d15 = ((double) i12) / 255.0d;
            if (d15 < 0.04045d) {
                d12 = d15 / 12.92d;
            } else {
                d12 = Math.pow((d15 + 0.055d) / 1.055d, 2.4d);
            }
            double d16 = ((double) i13) / 255.0d;
            if (d16 < 0.04045d) {
                d13 = d16 / 12.92d;
            } else {
                d13 = Math.pow((d16 + 0.055d) / 1.055d, 2.4d);
            }
            dArr2[0] = ((0.4124d * d11) + (0.3576d * d12) + (0.1805d * d13)) * 100.0d;
            dArr2[1] = ((0.2126d * d11) + (0.7152d * d12) + (0.0722d * d13)) * 100.0d;
            dArr2[2] = ((d11 * 0.0193d) + (d12 * 0.1192d) + (d13 * 0.9505d)) * 100.0d;
            return;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }

    public static int b(double d11, double d12, double d13) {
        double d14 = (((3.2406d * d11) + (-1.5372d * d12)) + (-0.4986d * d13)) / 100.0d;
        double d15 = (((-0.9689d * d11) + (1.8758d * d12)) + (0.0415d * d13)) / 100.0d;
        double d16 = (((0.0557d * d11) + (-0.204d * d12)) + (1.057d * d13)) / 100.0d;
        return Color.rgb(h((int) Math.round((d14 > 0.0031308d ? (Math.pow(d14, 0.4166666666666667d) * 1.055d) - 0.055d : d14 * 12.92d) * 255.0d), 0, 255), h((int) Math.round((d15 > 0.0031308d ? (Math.pow(d15, 0.4166666666666667d) * 1.055d) - 0.055d : d15 * 12.92d) * 255.0d), 0, 255), h((int) Math.round((d16 > 0.0031308d ? (Math.pow(d16, 0.4166666666666667d) * 1.055d) - 0.055d : d16 * 12.92d) * 255.0d), 0, 255));
    }

    public static double c(int i11) {
        double[] i12 = i();
        d(i11, i12);
        return i12[1] / 100.0d;
    }

    public static void d(int i11, double[] dArr) {
        a(Color.red(i11), Color.green(i11), Color.blue(i11), dArr);
    }

    public static int e(int i11, int i12) {
        return 255 - (((255 - i12) * (255 - i11)) / 255);
    }

    public static int f(int i11, int i12) {
        int alpha = Color.alpha(i12);
        int alpha2 = Color.alpha(i11);
        int e11 = e(alpha2, alpha);
        return Color.argb(e11, g(Color.red(i11), alpha2, Color.red(i12), alpha, e11), g(Color.green(i11), alpha2, Color.green(i12), alpha, e11), g(Color.blue(i11), alpha2, Color.blue(i12), alpha, e11));
    }

    public static int g(int i11, int i12, int i13, int i14, int i15) {
        if (i15 == 0) {
            return 0;
        }
        return (((i11 * 255) * i12) + ((i13 * i14) * (255 - i12))) / (i15 * 255);
    }

    public static int h(int i11, int i12, int i13) {
        return i11 < i12 ? i12 : Math.min(i11, i13);
    }

    public static double[] i() {
        ThreadLocal<double[]> threadLocal = f16510a;
        double[] dArr = threadLocal.get();
        if (dArr != null) {
            return dArr;
        }
        double[] dArr2 = new double[3];
        threadLocal.set(dArr2);
        return dArr2;
    }

    public static int j(int i11, int i12) {
        if (i12 >= 0 && i12 <= 255) {
            return (i11 & FlexItem.MAX_SIZE) | (i12 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
