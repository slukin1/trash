package kotlinx.serialization.internal;

import java.util.Arrays;

public final class v extends PrimitiveArrayBuilder<double[]> {

    /* renamed from: a  reason: collision with root package name */
    public double[] f57775a;

    /* renamed from: b  reason: collision with root package name */
    public int f57776b;

    public v(double[] dArr) {
        this.f57775a = dArr;
        this.f57776b = dArr.length;
        b(10);
    }

    public void b(int i11) {
        double[] dArr = this.f57775a;
        if (dArr.length < i11) {
            this.f57775a = Arrays.copyOf(dArr, RangesKt___RangesKt.d(i11, dArr.length * 2));
        }
    }

    public int d() {
        return this.f57776b;
    }

    public final void e(double d11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        double[] dArr = this.f57775a;
        int d12 = d();
        this.f57776b = d12 + 1;
        dArr[d12] = d11;
    }

    /* renamed from: f */
    public double[] a() {
        return Arrays.copyOf(this.f57775a, d());
    }
}
