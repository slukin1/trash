package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.r;
import kotlin.o;
import kotlin.p;
import kotlinx.serialization.encoding.b;

public final class b2 extends l1<o, p, a2> {

    /* renamed from: c  reason: collision with root package name */
    public static final b2 f57698c = new b2();

    public b2() {
        super(a.w(o.f56805c));
    }

    public /* bridge */ /* synthetic */ int e(Object obj) {
        return v(((p) obj).r());
    }

    public /* bridge */ /* synthetic */ Object k(Object obj) {
        return y(((p) obj).r());
    }

    public /* bridge */ /* synthetic */ Object r() {
        return p.a(w());
    }

    public /* bridge */ /* synthetic */ void u(b bVar, Object obj, int i11) {
        z(bVar, ((p) obj).r(), i11);
    }

    public int v(int[] iArr) {
        return p.l(iArr);
    }

    public int[] w() {
        return p.b(0);
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, a2 a2Var, boolean z11) {
        a2Var.e(o.b(aVar.l(getDescriptor(), i11).u()));
    }

    public a2 y(int[] iArr) {
        return new a2(iArr, (r) null);
    }

    public void z(b bVar, int[] iArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.w(getDescriptor(), i12).s(p.j(iArr, i12));
        }
    }
}
