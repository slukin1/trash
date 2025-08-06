package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.l;
import kotlinx.serialization.encoding.b;

public final class g extends l1<Boolean, boolean[], f> {

    /* renamed from: c  reason: collision with root package name */
    public static final g f57716c = new g();

    public g() {
        super(a.A(l.f56785a));
    }

    /* renamed from: v */
    public int e(boolean[] zArr) {
        return zArr.length;
    }

    /* renamed from: w */
    public boolean[] r() {
        return new boolean[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, f fVar, boolean z11) {
        fVar.e(aVar.C(getDescriptor(), i11));
    }

    /* renamed from: y */
    public f k(boolean[] zArr) {
        return new f(zArr);
    }

    /* renamed from: z */
    public void u(b bVar, boolean[] zArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.o(getDescriptor(), i12, zArr[i12]);
        }
    }
}
