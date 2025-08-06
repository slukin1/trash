package kotlinx.serialization.internal;

import java.util.Arrays;

public final class k0 extends PrimitiveArrayBuilder<int[]> {

    /* renamed from: a  reason: collision with root package name */
    public int[] f57736a;

    /* renamed from: b  reason: collision with root package name */
    public int f57737b;

    public k0(int[] iArr) {
        this.f57736a = iArr;
        this.f57737b = iArr.length;
        b(10);
    }

    public void b(int i11) {
        int[] iArr = this.f57736a;
        if (iArr.length < i11) {
            this.f57736a = Arrays.copyOf(iArr, RangesKt___RangesKt.d(i11, iArr.length * 2));
        }
    }

    public int d() {
        return this.f57737b;
    }

    public final void e(int i11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        int[] iArr = this.f57736a;
        int d11 = d();
        this.f57737b = d11 + 1;
        iArr[d11] = i11;
    }

    /* renamed from: f */
    public int[] a() {
        return Arrays.copyOf(this.f57736a, d());
    }
}
