package kotlinx.serialization.internal;

import h10.a;
import kotlin.q;
import kotlin.r;
import kotlinx.serialization.encoding.b;

public final class e2 extends l1<q, r, d2> {

    /* renamed from: c  reason: collision with root package name */
    public static final e2 f57710c = new e2();

    public e2() {
        super(a.x(q.f56813c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((r) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((r) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return r.a(w());
    }

    public /* bridge */ /* synthetic */ void u(b bVar, Object obj, int i11) {
        z(bVar, ((r) obj).r(), i11);
    }

    public int v(long[] jArr) {
        return r.l(jArr);
    }

    public long[] w() {
        return r.b(0);
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, d2 d2Var, boolean z11) {
        d2Var.e(q.b(aVar.l(getDescriptor(), i11).h()));
    }

    public d2 y(long[] jArr) {
        return new d2(jArr, (kotlin.jvm.internal.r) null);
    }

    public void z(b bVar, long[] jArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.w(getDescriptor(), i12).A(r.j(jArr, i12));
        }
    }
}
