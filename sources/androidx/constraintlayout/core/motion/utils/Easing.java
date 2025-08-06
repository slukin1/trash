package androidx.constraintlayout.core.motion.utils;

import com.engagelab.privates.common.BuildConfig;
import java.io.PrintStream;
import java.util.Arrays;

public class Easing {

    /* renamed from: b  reason: collision with root package name */
    public static Easing f6846b = new Easing();

    /* renamed from: c  reason: collision with root package name */
    public static String[] f6847c = {BuildConfig.BUILD_TYPE, "accelerate", "decelerate", "linear"};

    /* renamed from: a  reason: collision with root package name */
    public String f6848a = "identity";

    public static class a extends Easing {

        /* renamed from: h  reason: collision with root package name */
        public static double f6849h = 0.01d;

        /* renamed from: i  reason: collision with root package name */
        public static double f6850i = 1.0E-4d;

        /* renamed from: d  reason: collision with root package name */
        public double f6851d;

        /* renamed from: e  reason: collision with root package name */
        public double f6852e;

        /* renamed from: f  reason: collision with root package name */
        public double f6853f;

        /* renamed from: g  reason: collision with root package name */
        public double f6854g;

        public a(String str) {
            this.f6848a = str;
            int indexOf = str.indexOf(40);
            int indexOf2 = str.indexOf(44, indexOf);
            this.f6851d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
            int i11 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i11);
            this.f6852e = Double.parseDouble(str.substring(i11, indexOf3).trim());
            int i12 = indexOf3 + 1;
            int indexOf4 = str.indexOf(44, i12);
            this.f6853f = Double.parseDouble(str.substring(i12, indexOf4).trim());
            int i13 = indexOf4 + 1;
            this.f6854g = Double.parseDouble(str.substring(i13, str.indexOf(41, i13)).trim());
        }

        public double a(double d11) {
            if (d11 <= 0.0d) {
                return 0.0d;
            }
            if (d11 >= 1.0d) {
                return 1.0d;
            }
            double d12 = 0.5d;
            double d13 = 0.5d;
            while (d12 > f6849h) {
                d12 *= 0.5d;
                d13 = d(d13) < d11 ? d13 + d12 : d13 - d12;
            }
            double d14 = d13 - d12;
            double d15 = d(d14);
            double d16 = d13 + d12;
            double d17 = d(d16);
            double e11 = e(d14);
            return (((e(d16) - e11) * (d11 - d15)) / (d17 - d15)) + e11;
        }

        public double b(double d11) {
            double d12 = 0.5d;
            double d13 = 0.5d;
            while (d12 > f6850i) {
                d12 *= 0.5d;
                d13 = d(d13) < d11 ? d13 + d12 : d13 - d12;
            }
            double d14 = d13 - d12;
            double d15 = d13 + d12;
            return (e(d15) - e(d14)) / (d(d15) - d(d14));
        }

        public final double d(double d11) {
            double d12 = 1.0d - d11;
            double d13 = 3.0d * d12;
            return (this.f6851d * d12 * d13 * d11) + (this.f6853f * d13 * d11 * d11) + (d11 * d11 * d11);
        }

        public final double e(double d11) {
            double d12 = 1.0d - d11;
            double d13 = 3.0d * d12;
            return (this.f6852e * d12 * d13 * d11) + (this.f6854g * d13 * d11 * d11) + (d11 * d11 * d11);
        }
    }

    public static Easing c(String str) {
        if (str == null) {
            return null;
        }
        if (str.startsWith("cubic")) {
            return new a(str);
        }
        if (str.startsWith("spline")) {
            return new f(str);
        }
        if (str.startsWith("Schlick")) {
            return new e(str);
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case -1354466595:
                if (str.equals("accelerate")) {
                    c11 = 0;
                    break;
                }
                break;
            case -1263948740:
                if (str.equals("decelerate")) {
                    c11 = 1;
                    break;
                }
                break;
            case -1102672091:
                if (str.equals("linear")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1312628413:
                if (str.equals(BuildConfig.BUILD_TYPE)) {
                    c11 = 3;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return new a("cubic(0.4, 0.05, 0.8, 0.7)");
            case 1:
                return new a("cubic(0.0, 0.0, 0.2, 0.95)");
            case 2:
                return new a("cubic(1, 1, 0, 0)");
            case 3:
                return new a("cubic(0.4, 0.0, 0.2, 1)");
            default:
                PrintStream printStream = System.err;
                printStream.println("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or " + Arrays.toString(f6847c));
                return f6846b;
        }
    }

    public double a(double d11) {
        return d11;
    }

    public double b(double d11) {
        return 1.0d;
    }

    public String toString() {
        return this.f6848a;
    }
}
