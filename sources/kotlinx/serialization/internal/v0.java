package kotlinx.serialization.internal;

import java.util.Arrays;

public final class v0 extends PrimitiveArrayBuilder<long[]> {

    /* renamed from: a  reason: collision with root package name */
    public long[] f57777a;

    /* renamed from: b  reason: collision with root package name */
    public int f57778b;

    public v0(long[] jArr) {
        this.f57777a = jArr;
        this.f57778b = jArr.length;
        b(10);
    }

    public void b(int i11) {
        long[] jArr = this.f57777a;
        if (jArr.length < i11) {
            this.f57777a = Arrays.copyOf(jArr, RangesKt___RangesKt.d(i11, jArr.length * 2));
        }
    }

    public int d() {
        return this.f57778b;
    }

    public final void e(long j11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        long[] jArr = this.f57777a;
        int d11 = d();
        this.f57778b = d11 + 1;
        jArr[d11] = j11;
    }

    /* renamed from: f */
    public long[] a() {
        return Arrays.copyOf(this.f57777a, d());
    }
}
