package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.r;
import kotlin.u;

public final class g2 extends PrimitiveArrayBuilder<u> {

    /* renamed from: a  reason: collision with root package name */
    public short[] f57718a;

    /* renamed from: b  reason: collision with root package name */
    public int f57719b;

    public g2(short[] sArr) {
        this.f57718a = sArr;
        this.f57719b = u.l(sArr);
        b(10);
    }

    public /* synthetic */ g2(short[] sArr, r rVar) {
        this(sArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return u.a(f());
    }

    public void b(int i11) {
        if (u.l(this.f57718a) < i11) {
            short[] sArr = this.f57718a;
            this.f57718a = u.c(Arrays.copyOf(sArr, RangesKt___RangesKt.d(i11, u.l(sArr) * 2)));
        }
    }

    public int d() {
        return this.f57719b;
    }

    public final void e(short s11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        short[] sArr = this.f57718a;
        int d11 = d();
        this.f57719b = d11 + 1;
        u.p(sArr, d11, s11);
    }

    public short[] f() {
        return u.c(Arrays.copyOf(this.f57718a, d()));
    }
}
