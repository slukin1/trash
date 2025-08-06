package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.digests.CSHAKEDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

class HashUtils {
    public static final int SECURE_HASH_ALGORITHM_KECCAK_128_RATE = 168;
    public static final int SECURE_HASH_ALGORITHM_KECCAK_256_RATE = 136;

    public static void customizableSecureHashAlgorithmKECCAK128Simple(byte[] bArr, int i11, int i12, short s11, byte[] bArr2, int i13, int i14) {
        CSHAKEDigest cSHAKEDigest = new CSHAKEDigest(128, (byte[]) null, new byte[]{(byte) s11, (byte) (s11 >> 8)});
        cSHAKEDigest.update(bArr2, i13, i14);
        cSHAKEDigest.doFinal(bArr, i11, i12);
    }

    public static void customizableSecureHashAlgorithmKECCAK256Simple(byte[] bArr, int i11, int i12, short s11, byte[] bArr2, int i13, int i14) {
        CSHAKEDigest cSHAKEDigest = new CSHAKEDigest(256, (byte[]) null, new byte[]{(byte) s11, (byte) (s11 >> 8)});
        cSHAKEDigest.update(bArr2, i13, i14);
        cSHAKEDigest.doFinal(bArr, i11, i12);
    }

    public static void secureHashAlgorithmKECCAK128(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(128);
        sHAKEDigest.update(bArr2, i13, i14);
        sHAKEDigest.doFinal(bArr, i11, i12);
    }

    public static void secureHashAlgorithmKECCAK256(byte[] bArr, int i11, int i12, byte[] bArr2, int i13, int i14) {
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        sHAKEDigest.update(bArr2, i13, i14);
        sHAKEDigest.doFinal(bArr, i11, i12);
    }
}
