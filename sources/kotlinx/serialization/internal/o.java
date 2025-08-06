package kotlinx.serialization.internal;

import java.util.Arrays;

public final class o extends PrimitiveArrayBuilder<char[]> {

    /* renamed from: a  reason: collision with root package name */
    public char[] f57748a;

    /* renamed from: b  reason: collision with root package name */
    public int f57749b;

    public o(char[] cArr) {
        this.f57748a = cArr;
        this.f57749b = cArr.length;
        b(10);
    }

    public void b(int i11) {
        char[] cArr = this.f57748a;
        if (cArr.length < i11) {
            this.f57748a = Arrays.copyOf(cArr, RangesKt___RangesKt.d(i11, cArr.length * 2));
        }
    }

    public int d() {
        return this.f57749b;
    }

    public final void e(char c11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        char[] cArr = this.f57748a;
        int d11 = d();
        this.f57749b = d11 + 1;
        cArr[d11] = c11;
    }

    /* renamed from: f */
    public char[] a() {
        return Arrays.copyOf(this.f57748a, d());
    }
}
