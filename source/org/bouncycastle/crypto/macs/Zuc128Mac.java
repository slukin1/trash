package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.Zuc128CoreEngine;

public final class Zuc128Mac implements Mac {
    private static final int TOPBIT = 128;
    private int theByteIndex;
    private final InternalZuc128Engine theEngine = new InternalZuc128Engine();
    private final int[] theKeyStream = new int[2];
    private int theMac;
    private Zuc128CoreEngine theState;
    private int theWordIndex;

    public static class InternalZuc128Engine extends Zuc128CoreEngine {
        private InternalZuc128Engine() {
        }

        public int createKeyStreamWord() {
            return super.makeKeyStreamWord();
        }
    }

    private int getFinalWord() {
        if (this.theByteIndex != 0) {
            return this.theEngine.createKeyStreamWord();
        }
        int[] iArr = this.theKeyStream;
        int length = (this.theWordIndex + 1) % iArr.length;
        this.theWordIndex = length;
        return iArr[length];
    }

    private int getKeyStreamWord(int i11) {
        int[] iArr = this.theKeyStream;
        int i12 = this.theWordIndex;
        int i13 = iArr[i12];
        if (i11 == 0) {
            return i13;
        }
        int i14 = iArr[(i12 + 1) % iArr.length];
        return (i14 >>> (32 - i11)) | (i13 << i11);
    }

    private void initKeyStream() {
        int i11 = 0;
        this.theMac = 0;
        while (true) {
            int[] iArr = this.theKeyStream;
            if (i11 < iArr.length - 1) {
                iArr[i11] = this.theEngine.createKeyStreamWord();
                i11++;
            } else {
                this.theWordIndex = iArr.length - 1;
                this.theByteIndex = 3;
                return;
            }
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
        this.theMac = getKeyStreamWord(i11) ^ this.theMac;
    }

    public int doFinal(byte[] bArr, int i11) {
        shift4NextByte();
        int keyStreamWord = this.theMac ^ getKeyStreamWord(this.theByteIndex * 8);
        this.theMac = keyStreamWord;
        int finalWord = keyStreamWord ^ getFinalWord();
        this.theMac = finalWord;
        Zuc128CoreEngine.encode32be(finalWord, bArr, i11);
        reset();
        return getMacSize();
    }

    public String getAlgorithmName() {
        return "Zuc128Mac";
    }

    public int getMacSize() {
        return 4;
    }

    public void init(CipherParameters cipherParameters) {
        this.theEngine.init(true, cipherParameters);
        this.theState = (Zuc128CoreEngine) this.theEngine.copy();
        initKeyStream();
    }

    public void reset() {
        Zuc128CoreEngine zuc128CoreEngine = this.theState;
        if (zuc128CoreEngine != null) {
            this.theEngine.reset(zuc128CoreEngine);
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
