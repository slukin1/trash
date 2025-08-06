package org.bouncycastle.pqc.crypto.sphincsplus;

class PK {
    public final byte[] root;
    public final byte[] seed;

    public PK(byte[] bArr, byte[] bArr2) {
        this.seed = bArr;
        this.root = bArr2;
    }
}
