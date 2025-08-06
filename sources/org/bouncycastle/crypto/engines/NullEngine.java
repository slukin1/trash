package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

public class NullEngine implements BlockCipher {
    public static final int DEFAULT_BLOCK_SIZE = 1;
    private final int blockSize;
    private boolean initialised;

    public NullEngine() {
        this(1);
    }

    public NullEngine(int i11) {
        this.blockSize = i11;
    }

    public String getAlgorithmName() {
        return "Null";
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.initialised = true;
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (this.initialised) {
            int i13 = this.blockSize;
            if (i11 + i13 > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if (i13 + i12 <= bArr2.length) {
                int i14 = 0;
                while (true) {
                    int i15 = this.blockSize;
                    if (i14 >= i15) {
                        return i15;
                    }
                    bArr2[i12 + i14] = bArr[i11 + i14];
                    i14++;
                }
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Null engine not initialised");
        }
    }

    public void reset() {
    }
}
