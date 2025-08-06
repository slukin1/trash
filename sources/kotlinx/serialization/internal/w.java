package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.s;
import kotlinx.serialization.encoding.b;

public final class w extends l1<Double, double[], v> {

    /* renamed from: c  reason: collision with root package name */
    public static final w f57781c = new w();

    public w() {
        super(a.D(s.f56796a));
    }

    /* renamed from: v */
    public int e(double[] dArr) {
        return dArr.length;
    }

    /* renamed from: w */
    public double[] r() {
        return new double[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, v vVar, boolean z11) {
        vVar.e(aVar.F(getDescriptor(), i11));
    }

    /* renamed from: y */
    public v k(double[] dArr) {
        return new v(dArr);
    }

    /* renamed from: z */
    public void u(b bVar, double[] dArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.G(getDescriptor(), i12, dArr[i12]);
        }
    }
}
