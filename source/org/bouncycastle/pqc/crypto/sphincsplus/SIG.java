package org.bouncycastle.pqc.crypto.sphincsplus;

class SIG {

    /* renamed from: r  reason: collision with root package name */
    private final byte[] f59608r;
    private final SIG_FORS[] sig_fors;
    private final SIG_XMSS[] sig_ht;

    public SIG(int i11, int i12, int i13, int i14, int i15, int i16, byte[] bArr) {
        byte[] bArr2 = new byte[i11];
        this.f59608r = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, i11);
        this.sig_fors = new SIG_FORS[i12];
        int i17 = i11;
        for (int i18 = 0; i18 != i12; i18++) {
            byte[] bArr3 = new byte[i11];
            System.arraycopy(bArr, i17, bArr3, 0, i11);
            i17 += i11;
            byte[][] bArr4 = new byte[i13][];
            for (int i19 = 0; i19 != i13; i19++) {
                bArr4[i19] = new byte[i11];
                System.arraycopy(bArr, i17, bArr4[i19], 0, i11);
                i17 += i11;
            }
            this.sig_fors[i18] = new SIG_FORS(bArr3, bArr4);
        }
        this.sig_ht = new SIG_XMSS[i14];
        for (int i21 = 0; i21 != i14; i21++) {
            int i22 = i16 * i11;
            byte[] bArr5 = new byte[i22];
            System.arraycopy(bArr, i17, bArr5, 0, i22);
            int i23 = i17 + i22;
            byte[][] bArr6 = new byte[i15][];
            for (int i24 = 0; i24 != i15; i24++) {
                bArr6[i24] = new byte[i11];
                System.arraycopy(bArr, i17, bArr6[i24], 0, i11);
                i23 = i17 + i11;
            }
            this.sig_ht[i21] = new SIG_XMSS(bArr5, bArr6);
        }
        if (i17 != bArr.length) {
            throw new IllegalArgumentException("signature wrong length");
        }
    }

    public byte[] getR() {
        return this.f59608r;
    }

    public SIG_FORS[] getSIG_FORS() {
        return this.sig_fors;
    }

    public SIG_XMSS[] getSIG_HT() {
        return this.sig_ht;
    }
}
