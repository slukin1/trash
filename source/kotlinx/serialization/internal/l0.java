package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.w;
import kotlinx.serialization.encoding.b;

public final class l0 extends l1<Integer, int[], k0> {

    /* renamed from: c  reason: collision with root package name */
    public static final l0 f57740c = new l0();

    public l0() {
        super(a.F(w.f56798a));
    }

    /* renamed from: v */
    public int e(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: w */
    public int[] r() {
        return new int[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, k0 k0Var, boolean z11) {
        k0Var.e(aVar.f(getDescriptor(), i11));
    }

    /* renamed from: y */
    public k0 k(int[] iArr) {
        return new k0(iArr);
    }

    /* renamed from: z */
    public void u(b bVar, int[] iArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.n(getDescriptor(), i12, iArr[i12]);
        }
    }
}
