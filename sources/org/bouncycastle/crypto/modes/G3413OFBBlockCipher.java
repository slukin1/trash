package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class G3413OFBBlockCipher extends StreamBlockCipher {
    private byte[] R;
    private byte[] R_init;
    private byte[] Y;
    private int blockSize;
    private int byteCount;
    private BlockCipher cipher;
    private boolean initialized = false;

    /* renamed from: m  reason: collision with root package name */
    private int f59242m;

    public G3413OFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        int blockSize2 = blockCipher.getBlockSize();
        this.blockSize = blockSize2;
        this.cipher = blockCipher;
        this.Y = new byte[blockSize2];
    }

    private void generateR() {
        byte[] LSB = GOST3413CipherUtil.LSB(this.R, this.f59242m - this.blockSize);
        System.arraycopy(LSB, 0, this.R, 0, LSB.length);
        System.arraycopy(this.Y, 0, this.R, LSB.length, this.f59242m - LSB.length);
    }

    private void generateY() {
        this.cipher.processBlock(GOST3413CipherUtil.MSB(this.R, this.blockSize), 0, this.Y, 0);
    }

    private void initArrays() {
        int i11 = this.f59242m;
        this.R = new byte[i11];
        this.R_init = new byte[i11];
    }

    private void setupDefaultParams() {
        this.f59242m = this.blockSize * 2;
    }

    public byte calculateByte(byte b11) {
        if (this.byteCount == 0) {
            generateY();
        }
        byte[] bArr = this.Y;
        int i11 = this.byteCount;
        byte b12 = (byte) (b11 ^ bArr[i11]);
        int i12 = i11 + 1;
        this.byteCount = i12;
        if (i12 == getBlockSize()) {
            this.byteCount = 0;
            generateR();
        }
        return b12;
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/OFB";
    }

    public int getBlockSize() {
        return this.blockSize;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            if (iv2.length >= this.blockSize) {
                this.f59242m = iv2.length;
                initArrays();
                byte[] clone = Arrays.clone(iv2);
                this.R_init = clone;
                System.arraycopy(clone, 0, this.R, 0, clone.length);
                if (parametersWithIV.getParameters() != null) {
                    blockCipher = this.cipher;
                    cipherParameters = parametersWithIV.getParameters();
                }
                this.initialized = true;
            }
            throw new IllegalArgumentException("Parameter m must blockSize <= m");
        }
        setupDefaultParams();
        initArrays();
        byte[] bArr = this.R_init;
        System.arraycopy(bArr, 0, this.R, 0, bArr.length);
        if (cipherParameters != null) {
            blockCipher = this.cipher;
        }
        this.initialized = true;
        blockCipher.init(true, cipherParameters);
        this.initialized = true;
    }

    public int processBlock(byte[] bArr, int i11, byte[] bArr2, int i12) throws DataLengthException, IllegalStateException {
        processBytes(bArr, i11, this.blockSize, bArr2, i12);
        return this.blockSize;
    }

    public void reset() {
        if (this.initialized) {
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.R, 0, bArr.length);
            Arrays.clear(this.Y);
            this.byteCount = 0;
            this.cipher.reset();
        }
    }
}
