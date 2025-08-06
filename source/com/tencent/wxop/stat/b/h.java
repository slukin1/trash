package com.tencent.wxop.stat.b;

public class h {
    public static final /* synthetic */ boolean cH = true;

    private h() {
    }

    public static byte[] d(byte[] bArr) {
        int length = bArr.length;
        j jVar = new j(new byte[((length * 3) / 4)]);
        if (jVar.a(bArr, length)) {
            int i11 = jVar.f51012g;
            byte[] bArr2 = jVar.cI;
            if (i11 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i11];
            System.arraycopy(bArr2, 0, bArr3, 0, i11);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }

    public static byte[] e(byte[] bArr) {
        int length = bArr.length;
        k kVar = new k();
        int i11 = (length / 3) * 4;
        int i12 = 2;
        if (!kVar.f51016ba) {
            int i13 = length % 3;
            if (i13 == 1) {
                i11 += 2;
            } else if (i13 == 2) {
                i11 += 3;
            }
        } else if (length % 3 > 0) {
            i11 += 4;
        }
        if (kVar.f51017bb && length > 0) {
            int i14 = ((length - 1) / 57) + 1;
            if (!kVar.cP) {
                i12 = 1;
            }
            i11 += i14 * i12;
        }
        kVar.cI = new byte[i11];
        kVar.a(bArr, length);
        if (cH || kVar.f51012g == i11) {
            return kVar.cI;
        }
        throw new AssertionError();
    }
}
