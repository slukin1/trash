package androidx.constraintlayout.core.motion.utils;

public class e extends Easing {

    /* renamed from: d  reason: collision with root package name */
    public double f6994d;

    /* renamed from: e  reason: collision with root package name */
    public double f6995e;

    public e(String str) {
        this.f6848a = str;
        int indexOf = str.indexOf(40);
        int indexOf2 = str.indexOf(44, indexOf);
        this.f6994d = Double.parseDouble(str.substring(indexOf + 1, indexOf2).trim());
        int i11 = indexOf2 + 1;
        this.f6995e = Double.parseDouble(str.substring(i11, str.indexOf(44, i11)).trim());
    }

    public double a(double d11) {
        return e(d11);
    }

    public double b(double d11) {
        return d(d11);
    }

    public final double d(double d11) {
        double d12 = this.f6995e;
        if (d11 < d12) {
            double d13 = this.f6994d;
            return ((d13 * d12) * d12) / ((((d12 - d11) * d13) + d11) * ((d13 * (d12 - d11)) + d11));
        }
        double d14 = this.f6994d;
        return (((d12 - 1.0d) * d14) * (d12 - 1.0d)) / (((((-d14) * (d12 - d11)) - d11) + 1.0d) * ((((-d14) * (d12 - d11)) - d11) + 1.0d));
    }

    public final double e(double d11) {
        double d12 = this.f6995e;
        if (d11 < d12) {
            return (d12 * d11) / (d11 + (this.f6994d * (d12 - d11)));
        }
        return ((1.0d - d12) * (d11 - 1.0d)) / ((1.0d - d11) - (this.f6994d * (d12 - d11)));
    }
}
