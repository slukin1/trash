package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Strings;

class HashFunctions {
    private static final byte[] hashc = Strings.toByteArray("expand 32-byte to 64-byte state!");
    private final Digest dig256;
    private final Digest dig512;
    private final Permute perm;

    public HashFunctions(Digest digest) {
        this(digest, (Digest) null);
    }

    public HashFunctions(Digest digest, Digest digest2) {
        this.perm = new Permute();
        this.dig256 = digest;
        this.dig512 = digest2;
    }

    public Digest getMessageHash() {
        return this.dig512;
    }

    public int hash_2n_n(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = new byte[64];
        for (int i13 = 0; i13 < 32; i13++) {
            bArr3[i13] = bArr2[i12 + i13];
            bArr3[i13 + 32] = hashc[i13];
        }
        this.perm.chacha_permute(bArr3, bArr3);
        for (int i14 = 0; i14 < 32; i14++) {
            bArr3[i14] = (byte) (bArr3[i14] ^ bArr2[(i12 + i14) + 32]);
        }
        this.perm.chacha_permute(bArr3, bArr3);
        for (int i15 = 0; i15 < 32; i15++) {
            bArr[i11 + i15] = bArr3[i15];
        }
        return 0;
    }

    public int hash_2n_n_mask(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, int i13) {
        byte[] bArr4 = new byte[64];
        for (int i14 = 0; i14 < 64; i14++) {
            bArr4[i14] = (byte) (bArr2[i12 + i14] ^ bArr3[i13 + i14]);
        }
        return hash_2n_n(bArr, i11, bArr4, 0);
    }

    public int hash_n_n(byte[] bArr, int i11, byte[] bArr2, int i12) {
        byte[] bArr3 = new byte[64];
        for (int i13 = 0; i13 < 32; i13++) {
            bArr3[i13] = bArr2[i12 + i13];
            bArr3[i13 + 32] = hashc[i13];
        }
        this.perm.chacha_permute(bArr3, bArr3);
        for (int i14 = 0; i14 < 32; i14++) {
            bArr[i11 + i14] = bArr3[i14];
        }
        return 0;
    }

    public int hash_n_n_mask(byte[] bArr, int i11, byte[] bArr2, int i12, byte[] bArr3, int i13) {
        byte[] bArr4 = new byte[32];
        for (int i14 = 0; i14 < 32; i14++) {
            bArr4[i14] = (byte) (bArr2[i12 + i14] ^ bArr3[i13 + i14]);
        }
        return hash_n_n(bArr, i11, bArr4, 0);
    }

    public int varlen_hash(byte[] bArr, int i11, byte[] bArr2, int i12) {
        this.dig256.update(bArr2, 0, i12);
        this.dig256.doFinal(bArr, i11);
        return 0;
    }
}
