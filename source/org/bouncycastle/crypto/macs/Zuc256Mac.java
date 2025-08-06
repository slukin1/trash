package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.Zuc128CoreEngine;
import org.bouncycastle.crypto.engines.Zuc256CoreEngine;

public final class Zuc256Mac implements Mac {
    private static final int TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc256Engine theEngine;
    private final int[] theKeyStream;
    private final int[] theMac;
    private final int theMacLength;
    private Zuc256CoreEngine theState;
    private int theWordIndex;

    public static class InternalZuc256Engine extends Zuc256CoreEngine {
        public InternalZuc256Engine(int i11) {
            super(i11);
        }

        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    public Zuc256Mac(int i11) {
        this.theEngine = new InternalZuc256Engine(i11);
        this.theMacLength = i11;
        int i12 = i11 / 32;
        this.theMac = new int[i12];
        this.theKeyStream = new int[(i12 + 1)];
    }

    private int getKeyStreamWord(int i11, int i12) {
        int[] iArr = this.theKeyStream;
        int i13 = this.theWordIndex;
        int i14 = iArr[(i13 + i11) % iArr.length];
        if (i12 == 0) {
            return i14;
        }
        int i15 = iArr[((i13 + i11) + 1) % iArr.length];
        return (i15 >>> (32 - i12)) | (i14 << i12);
    }

    private void initKeyStream() {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int[] iArr = this.theMac;
            if (i12 >= iArr.length) {
                break;
            }
            iArr[i12] = this.theEngine.createKeyStreamWord();
            i12++;
        }
        while (true) {
            int[] iArr2 = this.theKeyStream;
            if (i11 < iArr2.length - 1) {
                iArr2[i11] = this.theEngine.createKeyStreamWord();
                i11++;
            } else {
                this.theWordIndex = iArr2.length - 1;
                this.theByteIndex = 3;
                return;
            }
        }
    }

    private void shift4Final() {
        int i11 = (this.theByteIndex + 1) % 4;
        this.theByteIndex = i11;
        if (i11 == 0) {
            this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        }
    }

    private void shift4NextByte() {
        int i11 = (this.theByteIndex + 1) % 4;
        this.theByteIndex = i11;
        if (i11 == 0) {
            this.theKeyStream[this.theWordIndex] = this.theEngine.createKeyStreamWord();
            this.theWordIndex = (this.theWordIndex + 1) % this.theKeyStream.length;
        }
    }

    private void updateMac(int i11) {
        int i12 = 0;
        while (true) {
            int[] iArr = this.theMac;
            if (i12 < iArr.length) {
                iArr[i12] = iArr[i12] ^ getKeyStreamWord(i12, i11);
                i12++;
            } else {
                return;
            }
        }
    }

    public int doFinal(byte[] bArr, int i11) {
        shift4Final();
        updateMac(this.theByteIndex * 8);
        int i12 = 0;
        while (true) {
            int[] iArr = this.theMac;
            if (i12 < iArr.length) {
                Zuc128CoreEngine.encode32be(iArr[i12], bArr, (i12 * 4) + i11);
                i12++;
            } else {
                reset();
                return getMacSize();
            }
        }
    }

    public String getAlgorithmName() {
        return "Zuc256Mac-" + this.theMacLength;
    }

    public int getMacSize() {
        return this.theMacLength / 8;
    }

    public void init(CipherParameters cipherParameters) {
        this.theEngine.init(true, cipherParameters);
        this.theState = (Zuc256CoreEngine) this.theEngine.copy();
        initKeyStream();
    }

    public void reset() {
        Zuc256CoreEngine zuc256CoreEngine = this.theState;
        if (zuc256CoreEngine != null) {
            this.theEngine.reset(zuc256CoreEngine);
        }
        initKeyStream();
    }

    public void update(byte b11) {
        shift4NextByte();
        int i11 = this.theByteIndex * 8;
        int i12 = 128;
        int i13 = 0;
        while (i12 > 0) {
            if ((b11 & i12) != 0) {
                updateMac(i11 + i13);
            }
            i12 >>= 1;
            i13++;
        }
    }

    public void update(byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            update(bArr[i11 + i13]);
        }
    }
}
