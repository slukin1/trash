package kotlinx.serialization.internal;

import h10.a;
import kotlin.jvm.internal.m;
import kotlinx.serialization.encoding.b;

public final class j extends l1<Byte, byte[], i> {

    /* renamed from: c  reason: collision with root package name */
    public static final j f57729c = new j();

    public j() {
        super(a.B(m.f56786a));
    }

    /* renamed from: v */
    public int e(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: w */
    public byte[] r() {
        return new byte[0];
    }

    /* renamed from: x */
    public void h(kotlinx.serialization.encoding.a aVar, int i11, i iVar, boolean z11) {
        iVar.e(aVar.B(getDescriptor(), i11));
    }

    /* renamed from: y */
    public i k(byte[] bArr) {
        return new i(bArr);
    }

    /* renamed from: z */
    public void u(b bVar, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            bVar.j(getDescriptor(), i12, bArr[i12]);
        }
    }
}
