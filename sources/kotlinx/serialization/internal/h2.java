package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.r;
import kotlin.t;
import kotlin.u;
import kotlinx.serialization.encoding.b;

public final class h2 extends l1<t, u, g2> {

    /* renamed from: c  reason: collision with root package name */
    public static final h2 f57723c = new h2();

    public h2() {
        super(a.y(t.f56897c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((u) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((u) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return u.a(w());
    }

    public /* bridge */ /* synthetic */ void u(b bVar, Object obj, int i11) {
        z(bVar, ((u) obj).r(), i11);
    }

    public int v(short[] sArr) {
        return u.l(sArr);
    }

    public short[] w() {
        return u.b(0);
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, g2 g2Var, boolean z11) {
        g2Var.e(t.b(aVar.l(getDescriptor(), i11).m()));
    }

    public g2 y(short[] sArr) {
        return new g2(sArr, (r) null);
    }

    public void z(b bVar, short[] sArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.w(getDescriptor(), i12).k(u.j(sArr, i12));
        }
    }
}
