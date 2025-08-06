package kotlinx.serialization.internal;

import java.util.Arrays;

public final class i extends PrimitiveArrayBuilder<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f57724a;

    /* renamed from: b  reason: collision with root package name */
    public int f57725b;

    public i(byte[] bArr) {
        this.f57724a = bArr;
        this.f57725b = bArr.length;
        b(10);
    }

    public void b(int i11) {
        byte[] bArr = this.f57724a;
        if (bArr.length < i11) {
            this.f57724a = Arrays.copyOf(bArr, RangesKt___RangesKt.d(i11, bArr.length * 2));
        }
    }

    public int d() {
        return this.f57725b;
    }

    public final void e(byte b11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        byte[] bArr = this.f57724a;
        int d11 = d();
        this.f57725b = d11 + 1;
        bArr[d11] = b11;
    }

    /* renamed from: f */
    public byte[] a() {
        return Arrays.copyOf(this.f57724a, d());
    }
}
