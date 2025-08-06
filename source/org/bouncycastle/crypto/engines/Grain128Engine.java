package org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class Grain128Engine implements StreamCipher {
    private static final int STATE_SIZE = 4;
    private int index = 4;
    private boolean initialised = false;
    private int[] lfsr;
    private int[] nfsr;
    private byte[] out;
    private int output;
    private byte[] workingIV;
    private byte[] workingKey;

    private byte getKeyStream() {
        if (this.index > 3) {
            oneRound();
            this.index = 0;
        }
        byte[] bArr = this.out;
        int i11 = this.index;
        this.index = i11 + 1;
        return bArr[i11];
    }

    private int getOutput() {
        int[] iArr = this.nfsr;
        int i11 = (iArr[0] >>> 2) | (iArr[1] << 30);
        int i12 = (iArr[0] >>> 12) | (iArr[1] << 20);
        int i13 = (iArr[0] >>> 15) | (iArr[1] << 17);
        int i14 = (iArr[1] >>> 4) | (iArr[2] << 28);
        int i15 = (iArr[1] >>> 13) | (iArr[2] << 19);
        int i16 = iArr[2];
        int i17 = (iArr[2] >>> 9) | (iArr[3] << 23);
        int i18 = (iArr[2] >>> 25) | (iArr[3] << 7);
        int i19 = (iArr[3] << 1) | (iArr[2] >>> 31);
        int[] iArr2 = this.lfsr;
        int i21 = (iArr2[0] >>> 8) | (iArr2[1] << 24);
        int i22 = (iArr2[0] >>> 13) | (iArr2[1] << 19);
        int i23 = (iArr2[0] >>> 20) | (iArr2[1] << 12);
        int i24 = (iArr2[1] >>> 10) | (iArr2[2] << 22);
        int i25 = (iArr2[1] >>> 28) | (iArr2[2] << 4);
        int i26 = (iArr2[2] >>> 15) | (iArr2[3] << 17);
        int i27 = i19 & i12 & ((iArr2[2] >>> 31) | (iArr2[3] << 1));
        return ((((((((i27 ^ ((((i22 & i23) ^ (i12 & i21)) ^ (i19 & i24)) ^ (i25 & i26))) ^ ((iArr2[2] >>> 29) | (iArr2[3] << 3))) ^ i11) ^ i13) ^ i14) ^ i15) ^ i16) ^ i17) ^ i18;
    }

    private int getOutputLFSR() {
        int[] iArr = this.lfsr;
        int i11 = iArr[0];
        int i12 = (iArr[0] >>> 7) | (iArr[1] << 25);
        int i13 = (iArr[1] >>> 6) | (iArr[2] << 26);
        return iArr[3] ^ ((((i12 ^ i11) ^ i13) ^ ((iArr[2] >>> 6) | (iArr[3] << 26))) ^ ((iArr[2] >>> 17) | (iArr[3] << 15)));
    }

    private int getOutputNFSR() {
        int[] iArr = this.nfsr;
        int i11 = iArr[0];
        int i12 = (iArr[0] >>> 3) | (iArr[1] << 29);
        int i13 = (iArr[0] >>> 11) | (iArr[1] << 21);
        int i14 = (iArr[0] >>> 13) | (iArr[1] << 19);
        int i15 = (iArr[0] >>> 17) | (iArr[1] << 15);
        int i16 = (iArr[0] >>> 18) | (iArr[1] << 14);
        int i17 = (iArr[0] >>> 26) | (iArr[1] << 6);
        int i18 = (iArr[0] >>> 27) | (iArr[1] << 5);
        int i19 = (iArr[1] >>> 8) | (iArr[2] << 24);
        int i21 = (iArr[1] >>> 16) | (iArr[2] << 16);
        int i22 = (iArr[1] >>> 24) | (iArr[2] << 8);
        int i23 = (iArr[1] >>> 27) | (iArr[2] << 5);
        int i24 = (iArr[1] >>> 29) | (iArr[2] << 3);
        int i25 = (iArr[2] >>> 1) | (iArr[3] << 31);
        return (((((((iArr[3] ^ (((i11 ^ i17) ^ i22) ^ ((iArr[2] >>> 27) | (iArr[3] << 5)))) ^ (i12 & ((iArr[2] >>> 3) | (iArr[3] << 29)))) ^ (i13 & i14)) ^ (i15 & i16)) ^ (i18 & i23)) ^ (i19 & i21)) ^ (i24 & i25)) ^ (((iArr[2] >>> 4) | (iArr[3] << 28)) & ((iArr[2] >>> 20) | (iArr[3] << 12)));
    }

    private void initGrain() {
        for (int i11 = 0; i11 < 8; i11++) {
            this.output = getOutput();
            this.nfsr = shift(this.nfsr, (getOutputNFSR() ^ this.lfsr[0]) ^ this.output);
            this.lfsr = shift(this.lfsr, getOutputLFSR() ^ this.output);
        }
        this.initialised = true;
    }

    private void oneRound() {
        int output2 = getOutput();
        this.output = output2;
        byte[] bArr = this.out;
        bArr[0] = (byte) output2;
        bArr[1] = (byte) (output2 >> 8);
        bArr[2] = (byte) (output2 >> 16);
        bArr[3] = (byte) (output2 >> 24);
        this.nfsr = shift(this.nfsr, getOutputNFSR() ^ this.lfsr[0]);
        this.lfsr = shift(this.lfsr, getOutputLFSR());
    }

    private void setKey(byte[] bArr, byte[] bArr2) {
        bArr2[12] = -1;
        bArr2[13] = -1;
        bArr2[14] = -1;
        bArr2[15] = -1;
        this.workingKey = bArr;
        this.workingIV = bArr2;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.nfsr;
            if (i11 < iArr.length) {
                byte[] bArr3 = this.workingKey;
                int i13 = i12 + 3;
                int i14 = i12 + 2;
                int i15 = i12 + 1;
                iArr[i11] = (bArr3[i12] & 255) | (bArr3[i13] << Ascii.CAN) | ((bArr3[i14] << 16) & 16711680) | ((bArr3[i15] << 8) & 65280);
                int[] iArr2 = this.lfsr;
                byte[] bArr4 = this.workingIV;
                iArr2[i11] = (bArr4[i12] & 255) | (bArr4[i13] << Ascii.CAN) | ((bArr4[i14] << 16) & 16711680) | ((bArr4[i15] << 8) & 65280);
                i12 += 4;
                i11++;
            } else {
                return;
            }
        }
    }

    private int[] shift(int[] iArr, int i11) {
        iArr[0] = iArr[1];
        iArr[1] = iArr[2];
        iArr[2] = iArr[3];
        iArr[3] = i11;
        return iArr;
    }

    public String getAlgorithmName() {
        return "Grain-128";
    }

    public void init(boolean z11, CipherParameters cipherParameters) throws IllegalArgumentException {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] iv2 = parametersWithIV.getIV();
            if (iv2 == null || iv2.length != 12) {
                throw new IllegalArgumentException("Grain-128  requires exactly 12 bytes of IV");
            } else if (parametersWithIV.getParameters() instanceof KeyParameter) {
                KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
                this.workingIV = new byte[keyParameter.getKey().length];
                this.workingKey = new byte[keyParameter.getKey().length];
                this.lfsr = new int[4];
                this.nfsr = new int[4];
                this.out = new byte[4];
                System.arraycopy(iv2, 0, this.workingIV, 0, iv2.length);
                System.arraycopy(keyParameter.getKey(), 0, this.workingKey, 0, keyParameter.getKey().length);
                reset();
            } else {
                throw new IllegalArgumentException("Grain-128 Init parameters must include a key");
            }
        } else {
            throw new IllegalArgumentException("Grain-128 Init parameters must include an IV");
        }
    }

    public int processBytes(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws DataLengthException {
        if (!this.initialised) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        } else if (i11 + i12 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i13 + i12 <= bArr2.length) {
            for (int i14 = 0; i14 < i12; i14++) {
                bArr2[i13 + i14] = (byte) (bArr[i11 + i14] ^ getKeyStream());
            }
            return i12;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
        this.index = 4;
        setKey(this.workingKey, this.workingIV);
        initGrain();
    }

    public byte returnByte(byte b11) {
        if (this.initialised) {
            return (byte) (b11 ^ getKeyStream());
        }
        throw new IllegalStateException(getAlgorithmName() + " not initialised");
    }
}
