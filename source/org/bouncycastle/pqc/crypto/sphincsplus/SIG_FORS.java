package org.bouncycastle.pqc.crypto.sphincsplus;

class SIG_FORS {
    public final byte[][] authPath;

    /* renamed from: sk  reason: collision with root package name */
    public final byte[] f59609sk;

    public SIG_FORS(byte[] bArr, byte[][] bArr2) {
        this.authPath = bArr2;
        this.f59609sk = bArr;
    }

    public byte[][] getAuthPath() {
        return this.authPath;
    }

    public byte[] getSK() {
        return this.f59609sk;
    }
}
