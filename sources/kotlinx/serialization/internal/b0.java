package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.t;
import kotlinx.serialization.encoding.b;

public final class b0 extends l1<Float, float[], a0> {

    /* renamed from: c  reason: collision with root package name */
    public static final b0 f57694c = new b0();

    public b0() {
        super(a.E(t.f56797a));
    }

    /* renamed from: v */
    public int e(float[] fArr) {
        return fArr.length;
    }

    /* renamed from: w */
    public float[] r() {
        return new float[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, a0 a0Var, boolean z11) {
        a0Var.e(aVar.z(getDescriptor(), i11));
    }

    /* renamed from: y */
    public a0 k(float[] fArr) {
        return new a0(fArr);
    }

    /* renamed from: z */
    public void u(b bVar, float[] fArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.C(getDescriptor(), i12, fArr[i12]);
        }
    }
}
