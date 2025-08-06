package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class KCTRBlockCipher extends StreamBlockCipher {
    private int byteCount;
    private BlockCipher engine;
    private boolean initialised;

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59244iv;
    private byte[] ofbOutV;
    private byte[] ofbV;

    public KCTRBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.engine = blockCipher;
        this.f59244iv = new byte[blockCipher.getBlockSize()];
        this.ofbV = new byte[blockCipher.getBlockSize()];
        this.ofbOutV = new byte[blockCipher.getBlockSize()];
    }

    private void checkCounter() {
    }

    private void incrementCounterAt(int i11) {
        while (true) {
            byte[] bArr = this.ofbV;
            if (i11 < bArr.length) {
                int i12 = i11 + 1;
                byte b11 = (byte) (bArr[i11] + 1);
                bArr[i11] = b11;
                if (b11 == 0) {
                    i11 = i12;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public byte calculateByte(byte b11) {
        int i11 = this.byteCount;
        if (i11 == 0) {
            incrementCounterAt(0);
            checkCounter();
            this.engine.processBlock(this.ofbV, 0, this.ofbOutV, 0);
            byte[] bArr = this.ofbOutV;
            int i12 = this.byteCount;
            this.byteCount = i12 + 1;
            return (byte) (b11 ^ bArr[i12]);
        }
        byte[] bArr2 = this.ofbOutV;
        int i13 = i11 + 1;
        this.byteCount = i13;
        byte b12 = (byte) (b11 ^ bArr2[i11]);
        if (i13 == this.ofbV.length) {
            this.byteCount = 0;
        }
        return b12;
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KCTR";
    }

    public int getBlockSize() {
        return this.engine.getBlockSize();
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        this.initialised = true;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            byte[] bArr = this.f59244iv;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(iv2, 0, this.f59244iv, bArr.length - iv2.length, iv2.length);
            CipherParameters parameters = parametersWithIV.getParameters();
            if (parameters != null) {
                this.engine.init(true, parameters);
            }
            reset();
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed");
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        if (bArr.length - i11 < getBlockSize()) {
            throw new DataLengthException("input buffer too short");
        } else if (bArr2.length - i12 >= getBlockSize()) {
            processBytes(bArr, i11, getBlockSize(), bArr2, i12);
            return getBlockSize();
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        if (this.initialised) {
            this.engine.processBlock(this.f59244iv, 0, this.ofbV, 0);
        }
        this.engine.reset();
        this.byteCount = 0;
    }
}
