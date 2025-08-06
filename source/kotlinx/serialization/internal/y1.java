package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.r;
import kotlin.m;
import kotlin.n;
import kotlinx.serialization.encoding.b;

public final class y1 extends l1<m, n, x1> {

    /* renamed from: c  reason: collision with root package name */
    public static final y1 f57796c = new y1();

    public y1() {
        super(a.v(m.f56800c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((n) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((n) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return n.a(w());
    }

    public /* bridge */ /* synthetic */ void u(b bVar, Object obj, int i11) {
        z(bVar, ((n) obj).r(), i11);
    }

    public int v(byte[] bArr) {
        return n.l(bArr);
    }

    public byte[] w() {
        return n.b(0);
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, x1 x1Var, boolean z11) {
        x1Var.e(m.b(aVar.l(getDescriptor(), i11).H()));
    }

    public x1 y(byte[] bArr) {
        return new x1(bArr, (r) null);
    }

    public void z(b bVar, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.w(getDescriptor(), i12).f(n.j(bArr, i12));
        }
    }
}
