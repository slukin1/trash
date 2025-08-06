package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.b0;
import kotlinx.serialization.encoding.b;

public final class t1 extends l1<Short, short[], s1> {

    /* renamed from: c  reason: collision with root package name */
    public static final t1 f57768c = new t1();

    public t1() {
        super(a.H(b0.f56768a));
    }

    /* renamed from: v */
    public int e(short[] sArr) {
        return sArr.length;
    }

    /* renamed from: w */
    public short[] r() {
        return new short[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, s1 s1Var, boolean z11) {
        s1Var.e(aVar.E(getDescriptor(), i11));
    }

    /* renamed from: y */
    public s1 k(short[] sArr) {
        return new s1(sArr);
    }

    /* renamed from: z */
    public void u(b bVar, short[] sArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.t(getDescriptor(), i12, sArr[i12]);
        }
    }
}
