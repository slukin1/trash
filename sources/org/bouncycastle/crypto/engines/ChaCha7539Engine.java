package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

public class ChaCha7539Engine extends Salsa20Engine {
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i11 = iArr[12] + 1;
        iArr[12] = i11;
        if (i11 == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    public void advanceCounter(long j11) {
        int i11 = (int) (j11 >>> 32);
        int i12 = (int) j11;
        if (i11 <= 0) {
            int[] iArr = this.engineState;
            int i13 = iArr[12];
            iArr[12] = iArr[12] + i12;
            if (i13 != 0 && iArr[12] < i13) {
                throw new IllegalStateException("attempt to increase counter past 2^32.");
            }
            return;
        }
        throw new IllegalStateException("attempt to increase counter past 2^32.");
    }

    public void generateKeyStream(byte[] bArr) {
        ChaChaEngine.chachaCore(this.rounds, this.engineState, this.f59185x);
        Pack.intToLittleEndian(this.f59185x, bArr, 0);
    }

    public String getAlgorithmName() {
        return "ChaCha7539";
    }

    public long getCounter() {
        return ((long) this.engineState[12]) & 4294967295L;
    }

    public int getNonceSize() {
        return 12;
    }

    public void resetCounter() {
        this.engineState[12] = 0;
    }

    public void retreatCounter() {
        int[] iArr = this.engineState;
        if (iArr[12] != 0) {
            iArr[12] = iArr[12] - 1;
            return;
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    public void retreatCounter(long j11) {
        int i11 = (int) (j11 >>> 32);
        int i12 = (int) j11;
        if (i11 == 0) {
            int[] iArr = this.engineState;
            if ((((long) iArr[12]) & 4294967295L) >= (4294967295L & ((long) i12))) {
                iArr[12] = iArr[12] - i12;
                return;
            }
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        throw new IllegalStateException("attempt to reduce counter past zero.");
    }

    public void setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length == 32) {
                packTauOrSigma(bArr.length, this.engineState, 0);
                Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 8);
            } else {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 256 bit key");
            }
        }
        Pack.littleEndianToInt(bArr2, 0, this.engineState, 13, 3);
    }
}
