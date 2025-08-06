package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.z;
import kotlinx.serialization.encoding.b;

public final class w0 extends l1<Long, long[], v0> {

    /* renamed from: c  reason: collision with root package name */
    public static final w0 f57782c = new w0();

    public w0() {
        super(a.G(z.f56799a));
    }

    /* renamed from: v */
    public int e(long[] jArr) {
        return jArr.length;
    }

    /* renamed from: w */
    public long[] r() {
        return new long[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, v0 v0Var, boolean z11) {
        v0Var.e(aVar.e(getDescriptor(), i11));
    }

    /* renamed from: y */
    public v0 k(long[] jArr) {
        return new v0(jArr);
    }

    /* renamed from: z */
    public void u(b bVar, long[] jArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.u(getDescriptor(), i12, jArr[i12]);
        }
    }
}
