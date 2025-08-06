package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class EAXBlockCipher implements AEADBlockCipher {
    private static final byte cTAG = 2;
    private static final byte hTAG = 1;
    private static final byte nTAG = 0;
    private byte[] associatedTextMac;
    private int blockSize;
    private byte[] bufBlock;
    private int bufOff;
    private SICBlockCipher cipher;
    private boolean cipherInitialized;
    private boolean forEncryption;
    private byte[] initialAssociatedText;
    private Mac mac;
    private byte[] macBlock = new byte[this.blockSize];
    private int macSize;
    private byte[] nonceMac;

    public EAXBlockCipher(BlockCipher blockCipher) {
        this.blockSize = blockCipher.getBlockSize();
        CMac cMac = new CMac(blockCipher);
        this.mac = cMac;
        this.associatedTextMac = new byte[cMac.getMacSize()];
        this.nonceMac = new byte[this.mac.getMacSize()];
        this.cipher = new SICBlockCipher(blockCipher);
    }

    private void calculateMac() {
        byte[] bArr = new byte[this.blockSize];
        int i11 = 0;
        this.mac.doFinal(bArr, 0);
        while (true) {
            byte[] bArr2 = this.macBlock;
            if (i11 < bArr2.length) {
                bArr2[i11] = (byte) ((this.nonceMac[i11] ^ this.associatedTextMac[i11]) ^ bArr[i11]);
                i11++;
            } else {
                return;
            }
        }
    }

    private void initCipher() {
        if (!this.cipherInitialized) {
            this.cipherInitialized = true;
            this.mac.doFinal(this.associatedTextMac, 0);
            int i11 = this.blockSize;
            byte[] bArr = new byte[i11];
            bArr[i11 - 1] = 2;
            this.mac.update(bArr, 0, i11);
        }
    }

    private int process(byte b11, byte[] bArr, int i11) {
        int i12;
        byte[] bArr2 = this.bufBlock;
        int i13 = this.bufOff;
        int i14 = i13 + 1;
        this.bufOff = i14;
        bArr2[i13] = b11;
        if (i14 != bArr2.length) {
            return 0;
        }
        int length = bArr.length;
        int i15 = this.blockSize;
        if (length >= i11 + i15) {
            if (this.forEncryption) {
                i12 = this.cipher.processBlock(bArr2, 0, bArr, i11);
                this.mac.update(bArr, i11, this.blockSize);
            } else {
                this.mac.update(bArr2, 0, i15);
                i12 = this.cipher.processBlock(this.bufBlock, 0, bArr, i11);
            }
            this.bufOff = 0;
            if (!this.forEncryption) {
                byte[] bArr3 = this.bufBlock;
                System.arraycopy(bArr3, this.blockSize, bArr3, 0, this.macSize);
                this.bufOff = this.macSize;
            }
            return i12;
        }
        throw new OutputLengthException("Output buffer is too short");
    }

    private void reset(boolean z11) {
        this.cipher.reset();
        this.mac.reset();
        this.bufOff = 0;
        Arrays.fill(this.bufBlock, (byte) 0);
        if (z11) {
            Arrays.fill(this.macBlock, (byte) 0);
        }
        int i11 = this.blockSize;
        byte[] bArr = new byte[i11];
        bArr[i11 - 1] = 1;
        this.mac.update(bArr, 0, i11);
        this.cipherInitialized = false;
        byte[] bArr2 = this.initialAssociatedText;
        if (bArr2 != null) {
            processAADBytes(bArr2, 0, bArr2.length);
        }
    }

    private boolean verifyMac(byte[] bArr, int i11) {
        byte b11 = 0;
        for (int i12 = 0; i12 < this.macSize; i12++) {
            b11 |= this.macBlock[i12] ^ bArr[i11 + i12];
        }
        return b11 == 0;
    }

    public int doFinal(byte[] bArr, int i11) throws IllegalStateException, InvalidCipherTextException {
        initCipher();
        int i12 = this.bufOff;
        byte[] bArr2 = this.bufBlock;
        byte[] bArr3 = new byte[bArr2.length];
        this.bufOff = 0;
        if (this.forEncryption) {
            int i13 = i11 + i12;
            if (bArr.length >= this.macSize + i13) {
                this.cipher.processBlock(bArr2, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i11, i12);
                this.mac.update(bArr3, 0, i12);
                calculateMac();
                System.arraycopy(this.macBlock, 0, bArr, i13, this.macSize);
                reset(false);
                return i12 + this.macSize;
            }
            throw new OutputLengthException("Output buffer too short");
        }
        int i14 = this.macSize;
        if (i12 < i14) {
            throw new InvalidCipherTextException("data too short");
        } else if (bArr.length >= (i11 + i12) - i14) {
            if (i12 > i14) {
                this.mac.update(bArr2, 0, i12 - i14);
                this.cipher.processBlock(this.bufBlock, 0, bArr3, 0);
                System.arraycopy(bArr3, 0, bArr, i11, i12 - this.macSize);
            }
            calculateMac();
            if (verifyMac(this.bufBlock, i12 - this.macSize)) {
                reset(false);
                return i12 - this.macSize;
            }
            throw new InvalidCipherTextException("mac check in EAX failed");
        } else {
            throw new OutputLengthException("Output buffer too short");
        }
    }

    public String getAlgorithmName() {
        return this.cipher.getUnderlyingCipher().getAlgorithmName() + "/EAX";
    }

    public int getBlockSize() {
        return this.cipher.getBlockSize();
    }

    public byte[] getMac() {
        int i11 = this.macSize;
        byte[] bArr = new byte[i11];
        System.arraycopy(this.macBlock, 0, bArr, 0, i11);
        return bArr;
    }

    public int getOutputSize(int i11) {
        int i12 = i11 + this.bufOff;
        if (this.forEncryption) {
            return i12 + this.macSize;
        }
        int i13 = this.macSize;
        if (i12 < i13) {
            return 0;
        }
        return i12 - i13;
    }

    public BlockCipher getUnderlyingCipher() {
        return this.cipher.getUnderlyingCipher();
    }

    public int getUpdateOutputSize(int i11) {
        int i12 = i11 + this.bufOff;
        if (!this.forEncryption) {
            int i13 = this.macSize;
            if (i12 < i13) {
                return 0;
            }
            i12 -= i13;
        }
        return i12 - (i12 % this.blockSize);
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        CipherParameters cipherParameters2;
        byte[] bArr;
        this.forEncryption = z11;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            bArr = aEADParameters.getNonce();
            this.initialAssociatedText = aEADParameters.getAssociatedText();
            this.macSize = aEADParameters.getMacSize() / 8;
            cipherParameters2 = aEADParameters.getKey();
        } else if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArr = parametersWithIV.getIV();
            this.initialAssociatedText = null;
            this.macSize = this.mac.getMacSize() / 2;
            cipherParameters2 = parametersWithIV.getParameters();
        } else {
            throw new IllegalArgumentException("invalid parameters passed to EAX");
        }
        this.bufBlock = new byte[(z11 ? this.blockSize : this.blockSize + this.macSize)];
        byte[] bArr2 = new byte[this.blockSize];
        this.mac.init(cipherParameters2);
        int i11 = this.blockSize;
        bArr2[i11 - 1] = 0;
        this.mac.update(bArr2, 0, i11);
        this.mac.update(bArr, 0, bArr.length);
        this.mac.doFinal(this.nonceMac, 0);
        this.cipher.init(true, new ParametersWithIV(cipherParameters2, this.nonceMac));
        reset();
    }

    public void processAADByte(byte b11) {
        if (!this.cipherInitialized) {
            this.mac.update(b11);
            return;
        }
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    public void processAADBytes(byte[] bArr, int i11, int i12) {
        if (!this.cipherInitialized) {
            this.mac.update(bArr, i11, i12);
            return;
        }
        throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
    }

    public int processByte(byte b11, byte[] bArr, int i11) throws DataLengthException {
        initCipher();
        return process(b11, bArr, i11);
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
        initCipher();
        if (bArr.length >= i11 + i12) {
            int i14 = 0;
            for (int i15 = 0; i15 != i12; i15++) {
                i14 += process(bArr[i11 + i15], bArr2, i13 + i14);
            }
            return i14;
        }
        throw new DataLengthException("Input buffer too short");
    }

    public void reset() {
        reset(true);
    }
}
