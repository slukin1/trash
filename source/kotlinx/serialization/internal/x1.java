package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.r;
import kotlin.n;

public final class x1 extends PrimitiveArrayBuilder<n> {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f57788a;

    /* renamed from: b  reason: collision with root package name */
    public int f57789b;

    public x1(byte[] bArr) {
        this.f57788a = bArr;
        this.f57789b = n.l(bArr);
        b(10);
    }

    public /* synthetic */ x1(byte[] bArr, r rVar) {
        this(bArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return n.a(f());
    }

    public void b(int i11) {
        if (n.l(this.f57788a) < i11) {
            byte[] bArr = this.f57788a;
            this.f57788a = n.c(Arrays.copyOf(bArr, RangesKt___RangesKt.d(i11, n.l(bArr) * 2)));
        }
    }

    public int d() {
        return this.f57789b;
    }

    public final void e(byte b11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        byte[] bArr = this.f57788a;
        int d11 = d();
        this.f57789b = d11 + 1;
        n.p(bArr, d11, b11);
    }

    public byte[] f() {
        return n.c(Arrays.copyOf(this.f57788a, d()));
    }
}
