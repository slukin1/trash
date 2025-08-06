package kotlinx.serialization.internal;

import java.util.Arrays;

public final class s1 extends PrimitiveArrayBuilder<short[]> {

    /* renamed from: a  reason: collision with root package name */
    public short[] f57763a;

    /* renamed from: b  reason: collision with root package name */
    public int f57764b;

    public s1(short[] sArr) {
        this.f57763a = sArr;
        this.f57764b = sArr.length;
        b(10);
    }

    public void b(int i11) {
        short[] sArr = this.f57763a;
        if (sArr.length < i11) {
            this.f57763a = Arrays.copyOf(sArr, RangesKt___RangesKt.d(i11, sArr.length * 2));
        }
    }

    public int d() {
        return this.f57764b;
    }

    public final void e(short s11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        short[] sArr = this.f57763a;
        int d11 = d();
        this.f57764b = d11 + 1;
        sArr[d11] = s11;
    }

    /* renamed from: f */
    public short[] a() {
        return Arrays.copyOf(this.f57763a, d());
    }
}
