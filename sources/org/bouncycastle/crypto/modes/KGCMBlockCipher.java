package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.kgcm.KGCMMultiplier;
import org.bouncycastle.crypto.modes.kgcm.Tables16kKGCMMultiplier_512;
import org.bouncycastle.crypto.modes.kgcm.Tables4kKGCMMultiplier_128;
import org.bouncycastle.crypto.modes.kgcm.Tables8kKGCMMultiplier_256;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class KGCMBlockCipher implements AEADBlockCipher {
    private static final int MIN_MAC_BITS = 64;
    private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();

    /* renamed from: b  reason: collision with root package name */
    private long[] f59245b;
    private final int blockSize;
    private BufferedBlockCipher ctrEngine;
    private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();
    private BlockCipher engine;
    private boolean forEncryption;
    private byte[] initialAssociatedText;

    /* renamed from: iv  reason: collision with root package name */
    private byte[] f59246iv;
    private byte[] macBlock;
    private int macSize;
    private KGCMMultiplier multiplier;

    public class ExposedByteArrayOutputStream extends ByteArrayOutputStream {
        public ExposedByteArrayOutputStream() {
        }

        public byte[] getBuffer() {
            return this.buf;
        }
    }

    public KGCMBlockCipher(BlockCipher blockCipher) {
        this.engine = blockCipher;
        this.ctrEngine = new BufferedBlockCipher(new KCTRBlockCipher(blockCipher));
        this.macSize = -1;
        int blockSize2 = this.engine.getBlockSize();
        this.blockSize = blockSize2;
        this.initialAssociatedText = new byte[blockSize2];
        this.f59246iv = new byte[blockSize2];
        this.multiplier = createDefaultMultiplier(blockSize2);
        this.f59245b = new long[(blockSize2 >>> 3)];
        this.macBlock = null;
    }

    private void calculateMac(byte[] bArr, int i11, int i12, int i13) {
        int i14 = i11 + i12;
        while (i11 < i14) {
            xorWithInput(this.f59245b, bArr, i11);
            this.multiplier.multiplyH(this.f59245b);
            i11 += this.blockSize;
        }
        long[] jArr = this.f59245b;
        jArr[0] = ((((long) i13) & 4294967295L) << 3) ^ jArr[0];
        int i15 = this.blockSize >>> 4;
        jArr[i15] = jArr[i15] ^ ((4294967295L & ((long) i12)) << 3);
        byte[] longToLittleEndian = Pack.longToLittleEndian(jArr);
        this.macBlock = longToLittleEndian;
        this.engine.processBlock(longToLittleEndian, 0, longToLittleEndian, 0);
    }

    private static KGCMMultiplier createDefaultMultiplier(int i11) {
        if (i11 == 16) {
            return new Tables4kKGCMMultiplier_128();
        }
        if (i11 == 32) {
            return new Tables8kKGCMMultiplier_256();
        }
        if (i11 == 64) {
            return new Tables16kKGCMMultiplier_512();
        }
        throw new IllegalArgumentException("Only 128, 256, and 512 -bit block sizes supported");
    }

    private void processAAD(byte[] bArr, int i11, int i12) {
        int i13 = i12 + i11;
        while (i11 < i13) {
            xorWithInput(this.f59245b, bArr, i11);
            this.multiplier.multiplyH(this.f59245b);
            i11 += this.blockSize;
        }
    }

    private static void xorWithInput(long[] jArr, byte[] bArr, int i11) {
        for (int i12 = 0; i12 < jArr.length; i12++) {
            jArr[i12] = jArr[i12] ^ Pack.littleEndianToLong(bArr, i11);
            i11 += 8;
        }
    }

    public int doFinal(byte[] bArr, int i11) throws IllegalStateException, InvalidCipherTextException {
        int i12;
        int size = this.data.size();
        if (this.forEncryption || size >= this.macSize) {
            byte[] bArr2 = new byte[this.blockSize];
            this.engine.processBlock(bArr2, 0, bArr2, 0);
            long[] jArr = new long[(this.blockSize >>> 3)];
            Pack.littleEndianToLong(bArr2, 0, jArr);
            this.multiplier.init(jArr);
            Arrays.fill(bArr2, (byte) 0);
            Arrays.fill(jArr, 0);
            int size2 = this.associatedText.size();
            if (size2 > 0) {
                processAAD(this.associatedText.getBuffer(), 0, size2);
            }
            if (!this.forEncryption) {
                int i13 = size - this.macSize;
                if (bArr.length - i11 >= i13) {
                    calculateMac(this.data.getBuffer(), 0, i13, size2);
                    int processBytes = this.ctrEngine.processBytes(this.data.getBuffer(), 0, i13, bArr, i11);
                    i12 = processBytes + this.ctrEngine.doFinal(bArr, i11 + processBytes);
                } else {
                    throw new OutputLengthException("Output buffer too short");
                }
            } else if ((bArr.length - i11) - this.macSize >= size) {
                int processBytes2 = this.ctrEngine.processBytes(this.data.getBuffer(), 0, size, bArr, i11);
                i12 = processBytes2 + this.ctrEngine.doFinal(bArr, i11 + processBytes2);
                calculateMac(bArr, i11, size, size2);
            } else {
                throw new OutputLengthException("Output buffer too short");
            }
            byte[] bArr3 = this.macBlock;
            if (bArr3 == null) {
                throw new IllegalStateException("mac is not calculated");
            } else if (this.forEncryption) {
                System.arraycopy(bArr3, 0, bArr, i11 + i12, this.macSize);
                reset();
                return i12 + this.macSize;
            } else {
                byte[] bArr4 = new byte[this.macSize];
                byte[] buffer = this.data.getBuffer();
                int i14 = this.macSize;
                System.arraycopy(buffer, size - i14, bArr4, 0, i14);
                int i15 = this.macSize;
                byte[] bArr5 = new byte[i15];
                System.arraycopy(this.macBlock, 0, bArr5, 0, i15);
                if (Arrays.constantTimeAreEqual(bArr4, bArr5)) {
                    reset();
                    return i12;
                }
                throw new InvalidCipherTextException("mac verification failed");
            }
        } else {
            throw new InvalidCipherTextException("data too short");
        }
    }

    public String getAlgorithmName() {
        return this.engine.getAlgorithmName() + "/KGCM";
    }

    public byte[] getMac() {
        int i11 = this.macSize;
        byte[] bArr = new byte[i11];
        System.arraycopy(this.macBlock, 0, bArr, 0, i11);
        return bArr;
    }

    public int getOutputSize(int i11) {
        int size = i11 + this.data.size();
        if (this.forEncryption) {
            return size + this.macSize;
        }
        int i12 = this.macSize;
        if (size < i12) {
            return 0;
        }
        return size - i12;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.engine;
    }

    public int getUpdateOutputSize(int i11) {
        return 0;
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        KeyParameter keyParameter;
        this.forEncryption = z11;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            byte[] nonce = aEADParameters.getNonce();
            byte[] bArr = this.f59246iv;
            Arrays.fill(bArr, (byte) 0);
            System.arraycopy(nonce, 0, this.f59246iv, bArr.length - nonce.length, nonce.length);
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            int macSize2 = aEADParameters.getMacSize();
            if (macSize2 < 64 || macSize2 > (this.blockSize << 3) || (macSize2 & 7) != 0) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize2);
            }
            this.macSize = macSize2 >>> 3;
            keyParameter = aEADParameters.getKey();
            byte[] bArr2 = this.initialAssociatedText;
            if (bArr2 != null) {
                processAADBytes(bArr2, 0, bArr2.length);
            }
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            byte[] bArr3 = this.f59246iv;
            Arrays.fill(bArr3, (byte) 0);
            System.arraycopy(iv2, 0, this.f59246iv, bArr3.length - iv2.length, iv2.length);
            this.initialAssociatedText = null;
            this.macSize = this.blockSize;
            keyParameter = (KeyParameter) parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("Invalid parameter passed");
        }
        this.macBlock = new byte[this.blockSize];
        this.ctrEngine.init(true, new ParametersWithIV(keyParameter, this.f59246iv));
        this.engine.init(true, keyParameter);
    }

    public void processAADByte(byte b11) {
        this.associatedText.write(b11);
    }

    public void processAADBytes(byte[] bArr, int i11, int i12) {
        this.associatedText.write(bArr, i11, i12);
    }

    public int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException, IllegalStateException {
        this.data.write(b11);
        return 0;
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException, IllegalStateException {
        if (bArr.length >= i11 + i12) {
            this.data.write(bArr, i11, i12);
            return 0;
        }
        throw new DataLengthException("input buffer too short");
    }

    public void reset() {
        Arrays.fill(this.f59245b, 0);
        this.engine.reset();
        this.data.reset();
        this.associatedText.reset();
        byte[] bArr = this.initialAssociatedText;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
