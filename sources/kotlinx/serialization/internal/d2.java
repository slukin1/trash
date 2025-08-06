package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.r;

public final class d2 extends PrimitiveArrayBuilder<r> {

    /* renamed from: a  reason: collision with root package name */
    public long[] f57707a;

    /* renamed from: b  reason: collision with root package name */
    public int f57708b;

    public d2(long[] jArr) {
        this.f57707a = jArr;
        this.f57708b = r.l(jArr);
        b(10);
    }

    public /* synthetic */ d2(long[] jArr, kotlin.jvm.internal.r rVar) {
        this(jArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return r.a(f());
    }

    public void b(int i11) {
        if (r.l(this.f57707a) < i11) {
            long[] jArr = this.f57707a;
            this.f57707a = r.c(Arrays.copyOf(jArr, RangesKt___RangesKt.d(i11, r.l(jArr) * 2)));
        }
    }

    public int d() {
        return this.f57708b;
    }

    public final void e(long j11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        long[] jArr = this.f57707a;
        int d11 = d();
        this.f57708b = d11 + 1;
        r.p(jArr, d11, j11);
    }

    public long[] f() {
        return r.c(Arrays.copyOf(this.f57707a, d()));
    }
}
