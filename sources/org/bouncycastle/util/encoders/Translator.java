package org.bouncycastle.util.encoders;

public interface Translator {
    int decode(byte[] bArr, int i11, int i12, byte[] bArr2, int i13);

    int encode(byte[] bArr, int i11, int i12, byte[] bArr2, int i13);

    int getDecodedBlockSize();

    int getEncodedBlockSize();
}
