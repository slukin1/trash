package org.bouncycastle.pqc.crypto.sphincsplus;

class SK {
    public final byte[] prf;
    public final byte[] seed;

    public SK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.prf = bArr2;
    }
}
