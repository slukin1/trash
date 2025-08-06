package org.bouncycastle.crypto;

public interface Xof extends ExtendedDigest {
    int doFinal(byte[] bArr, int i11, int i12);

    int doOutput(byte[] bArr, int i11, int i12);
}
