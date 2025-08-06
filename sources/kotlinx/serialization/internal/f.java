package kotlinx.serialization.internal;

import java.util.Arrays;

public final class f extends PrimitiveArrayBuilder<boolean[]> {

    /* renamed from: a  reason: collision with root package name */
    public boolean[] f57711a;

    /* renamed from: b  reason: collision with root package name */
    public int f57712b;

    public f(boolean[] zArr) {
        this.f57711a = zArr;
        this.f57712b = zArr.length;
        b(10);
    }

    public void b(int i11) {
        boolean[] zArr = this.f57711a;
        if (zArr.length < i11) {
            this.f57711a = Arrays.copyOf(zArr, RangesKt___RangesKt.d(i11, zArr.length * 2));
        }
    }

    public int d() {
        return this.f57712b;
    }

    public final void e(boolean z11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        boolean[] zArr = this.f57711a;
        int d11 = d();
        this.f57712b = d11 + 1;
        zArr[d11] = z11;
    }

    /* renamed from: f */
    public boolean[] a() {
        return Arrays.copyOf(this.f57711a, d());
    }
}
