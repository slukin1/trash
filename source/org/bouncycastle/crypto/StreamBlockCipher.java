package org.bouncycastle.crypto;

public abstract class StreamBlockCipher implements BlockCipher, StreamCipher {
    private final BlockCipher cipher;

    public StreamBlockCipher(BlockCipher blockCipher) {
        this.cipher = blockCipher;
    }

    public abstract byte calculateByte(byte b11);

    public BlockCipher getUnderlyingCipher() {
        return this.cipher;
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
        int i14 = i11 + i12;
        if (i14 > bArr.length) {
            throw new DataLengthException("input buffer too small");
        } else if (i13 + i12 <= bArr2.length) {
            while (i11 < i14) {
                bArr2[i13] = calculateByte(bArr[i11]);
                i13++;
                i11++;
            }
            return i12;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public final byte returnByte(byte b11) {
        return calculateByte(b11);
    }
}
