package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class G3413CFBBlockCipher extends StreamBlockCipher {
    private byte[] R;
    private byte[] R_init;
    private int blockSize;
    private int byteCount;
    private BlockCipher cipher;
    private boolean forEncryption;
    private byte[] gamma;
    private byte[] inBuf;
    private boolean initialized;

    /* renamed from: m  reason: collision with root package name */
    private int f59239m;

    /* renamed from: s  reason: collision with root package name */
    private final int f59240s;

    public G3413CFBBlockCipher(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8);
    }

    public G3413CFBBlockCipher(BlockCipher blockCipher, int i11) {
        super(blockCipher);
        this.initialized = false;
        if (i11 < 0 || i11 > blockCipher.getBlockSize() * 8) {
            throw new IllegalArgumentException("Parameter bitBlockSize must be in range 0 < bitBlockSize <= " + (blockCipher.getBlockSize() * 8));
        }
        this.blockSize = blockCipher.getBlockSize();
        this.cipher = blockCipher;
        this.f59240s = i11 / 8;
        this.inBuf = new byte[getBlockSize()];
    }

    private void initArrays() {
        int i11 = this.f59239m;
        this.R = new byte[i11];
        this.R_init = new byte[i11];
    }

    private void setupDefaultParams() {
        this.f59239m = this.blockSize * 2;
    }

    public byte calculateByte(byte b11) {
        if (this.byteCount == 0) {
            this.gamma = createGamma();
        }
        byte[] bArr = this.gamma;
        int i11 = this.byteCount;
        byte b12 = (byte) (bArr[i11] ^ b11);
        byte[] bArr2 = this.inBuf;
        int i12 = i11 + 1;
        this.byteCount = i12;
        if (this.forEncryption) {
            b11 = b12;
        }
        bArr2[i11] = b11;
        if (i12 == getBlockSize()) {
            this.byteCount = 0;
            generateR(this.inBuf);
        }
        return b12;
    }

    public byte[] createGamma() {
        byte[] MSB = GOST3413CipherUtil.MSB(this.R, this.blockSize);
        byte[] bArr = new byte[MSB.length];
        this.cipher.processBlock(MSB, 0, bArr, 0);
        return GOST3413CipherUtil.MSB(bArr, this.f59240s);
    }

    public void generateR(byte[] bArr) {
        byte[] LSB = GOST3413CipherUtil.LSB(this.R, this.f59239m - this.f59240s);
        System.arraycopy(LSB, 0, this.R, 0, LSB.length);
        System.arraycopy(bArr, 0, this.R, LSB.length, this.f59239m - LSB.length);
    }

    public String getAlgorithmName() {
        return this.cipher.getAlgorithmName() + "/CFB" + (this.blockSize * 8);
    }

    public int getBlockSize() {
        return this.f59240s;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        BlockCipher blockCipher;
        this.forEncryption = z11;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            if (iv2.length >= this.blockSize) {
                this.f59239m = iv2.length;
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
        processBytes(bArr, i11, getBlockSize(), bArr2, i12);
        return getBlockSize();
    }

    public void reset() {
        this.byteCount = 0;
        Arrays.clear(this.inBuf);
        Arrays.clear(this.gamma);
        if (this.initialized) {
            byte[] bArr = this.R_init;
            System.arraycopy(bArr, 0, this.R, 0, bArr.length);
            this.cipher.reset();
        }
    }
}
