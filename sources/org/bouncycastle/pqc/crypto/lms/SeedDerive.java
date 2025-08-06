package org.bouncycastle.pqc.crypto.lms;

import org.bouncycastle.crypto.Digest;

class SeedDerive {
    private final byte[] I;
    private final Digest digest;

    /* renamed from: j  reason: collision with root package name */
    private int f59549j;
    private final byte[] masterSeed;

    /* renamed from: q  reason: collision with root package name */
    private int f59550q;

    public SeedDerive(byte[] bArr, byte[] bArr2, Digest digest2) {
        this.I = bArr;
        this.masterSeed = bArr2;
        this.digest = digest2;
    }

    public void deriveSeed(byte[] bArr, boolean z11) {
        deriveSeed(bArr, z11, 0);
    }

    public void deriveSeed(byte[] bArr, boolean z11, int i11) {
        deriveSeed(bArr, i11);
        if (z11) {
            this.f59549j++;
        }
    }

    public byte[] deriveSeed(byte[] bArr, int i11) {
        if (bArr.length >= this.digest.getDigestSize()) {
            Digest digest2 = this.digest;
            byte[] bArr2 = this.I;
            digest2.update(bArr2, 0, bArr2.length);
            this.digest.update((byte) (this.f59550q >>> 24));
            this.digest.update((byte) (this.f59550q >>> 16));
            this.digest.update((byte) (this.f59550q >>> 8));
            this.digest.update((byte) this.f59550q);
            this.digest.update((byte) (this.f59549j >>> 8));
            this.digest.update((byte) this.f59549j);
            this.digest.update((byte) -1);
            Digest digest3 = this.digest;
            byte[] bArr3 = this.masterSeed;
            digest3.update(bArr3, 0, bArr3.length);
            this.digest.doFinal(bArr, i11);
            return bArr;
        }
        throw new IllegalArgumentException("target length is less than digest size.");
    }

    public byte[] getI() {
        return this.I;
    }

    public int getJ() {
        return this.f59549j;
    }

    public byte[] getMasterSeed() {
        return this.masterSeed;
    }

    public int getQ() {
        return this.f59550q;
    }

    public void setJ(int i11) {
        this.f59549j = i11;
    }

    public void setQ(int i11) {
        this.f59550q = i11;
    }
}
