package kotlinx.serialization.internal;

import java.util.Arrays;
import kotlin.jvm.internal.r;
import kotlin.p;

public final class a2 extends PrimitiveArrayBuilder<p> {

    /* renamed from: a  reason: collision with root package name */
    public int[] f57692a;

    /* renamed from: b  reason: collision with root package name */
    public int f57693b;

    public a2(int[] iArr) {
        this.f57692a = iArr;
        this.f57693b = p.l(iArr);
        b(10);
    }

    public /* synthetic */ a2(int[] iArr, r rVar) {
        this(iArr);
    }

    public /* bridge */ /* synthetic */ Object a() {
        return p.a(f());
    }

    public void b(int i11) {
        if (p.l(this.f57692a) < i11) {
            int[] iArr = this.f57692a;
            this.f57692a = p.c(Arrays.copyOf(iArr, RangesKt___RangesKt.d(i11, p.l(iArr) * 2)));
        }
    }

    public int d() {
        return this.f57693b;
    }

    public final void e(int i11) {
        PrimitiveArrayBuilder.c(this, 0, 1, (Object) null);
        int[] iArr = this.f57692a;
        int d11 = d();
        this.f57693b = d11 + 1;
        p.p(iArr, d11, i11);
    }

    public int[] f() {
        return p.c(Arrays.copyOf(this.f57692a, d()));
    }
}
