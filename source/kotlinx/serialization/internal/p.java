package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.n;
import kotlinx.serialization.encoding.b;

public final class p extends l1<Character, char[], o> {

    /* renamed from: c  reason: collision with root package name */
    public static final p f57753c = new p();

    public p() {
        super(a.C(n.f56787a));
    }

    /* renamed from: v */
    public int e(char[] cArr) {
        return cArr.length;
    }

    /* renamed from: w */
    public char[] r() {
        return new char[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, o oVar, boolean z11) {
        oVar.e(aVar.r(getDescriptor(), i11));
    }

    /* renamed from: y */
    public o k(char[] cArr) {
        return new o(cArr);
    }

    /* renamed from: z */
    public void u(b bVar, char[] cArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.i(getDescriptor(), i12, cArr[i12]);
        }
    }
}
