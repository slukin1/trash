package com.google.android.exoplayer2.decoder;

import android.media.MediaCodec;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class CryptoInfo {
    public int clearBlocks;
    public int encryptedBlocks;
    private final MediaCodec.CryptoInfo frameworkCryptoInfo;

    /* renamed from: iv  reason: collision with root package name */
    public byte[] f65853iv;
    public byte[] key;
    public int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    public int numSubSamples;
    private final PatternHolderV24 patternHolder;

    public static final class PatternHolderV24 {
        private final MediaCodec.CryptoInfo frameworkCryptoInfo;
        private final MediaCodec.CryptoInfo.Pattern pattern;

        /* access modifiers changed from: private */
        public void set(int i11, int i12) {
            this.pattern.set(i11, i12);
            this.frameworkCryptoInfo.setPattern(this.pattern);
        }

        private PatternHolderV24(MediaCodec.CryptoInfo cryptoInfo) {
            this.frameworkCryptoInfo = cryptoInfo;
            this.pattern = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }
    }

    public CryptoInfo() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.frameworkCryptoInfo = cryptoInfo;
        this.patternHolder = Util.SDK_INT >= 24 ? new PatternHolderV24(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo getFrameworkCryptoInfo() {
        return this.frameworkCryptoInfo;
    }

    public void increaseClearDataFirstSubSampleBy(int i11) {
        if (i11 != 0) {
            if (this.numBytesOfClearData == null) {
                int[] iArr = new int[1];
                this.numBytesOfClearData = iArr;
                this.frameworkCryptoInfo.numBytesOfClearData = iArr;
            }
            int[] iArr2 = this.numBytesOfClearData;
            iArr2[0] = iArr2[0] + i11;
        }
    }

    public void set(int i11, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i12, int i13, int i14) {
        this.numSubSamples = i11;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.f65853iv = bArr2;
        this.mode = i12;
        this.encryptedBlocks = i13;
        this.clearBlocks = i14;
        MediaCodec.CryptoInfo cryptoInfo = this.frameworkCryptoInfo;
        cryptoInfo.numSubSamples = i11;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i12;
        if (Util.SDK_INT >= 24) {
            ((PatternHolderV24) Assertions.checkNotNull(this.patternHolder)).set(i13, i14);
        }
    }
}
