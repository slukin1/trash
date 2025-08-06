package org.bouncycastle.pqc.crypto.gmss.util;

import org.bouncycastle.crypto.Digest;

public class GMSSRandom {
    private Digest messDigestTree;

    public GMSSRandom(Digest digest) {
        this.messDigestTree = digest;
    }

    private void addByteArrays(byte[] bArr, byte[] bArr2) {
        byte b11 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int i12 = (bArr[i11] & 255) + (bArr2[i11] & 255) + b11;
            bArr[i11] = (byte) i12;
            b11 = (byte) (i12 >> 8);
        }
    }

    private void addOne(byte[] bArr) {
        byte b11 = 1;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int i12 = (bArr[i11] & 255) + b11;
            bArr[i11] = (byte) i12;
            b11 = (byte) (i12 >> 8);
        }
    }

    public byte[] nextSeed(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        this.messDigestTree.update(bArr, 0, bArr.length);
        byte[] bArr3 = new byte[this.messDigestTree.getDigestSize()];
        this.messDigestTree.doFinal(bArr3, 0);
        addByteArrays(bArr, bArr3);
        addOne(bArr);
        return bArr3;
    }
}
