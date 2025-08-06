package com.google.android.exoplayer2.extractor.wav;

final class WavHeader {
    public final int averageBytesPerSecond;
    public final int bitsPerSample;
    public final int blockSize;
    public final byte[] extraData;
    public final int formatType;
    public final int frameRateHz;
    public final int numChannels;

    public WavHeader(int i11, int i12, int i13, int i14, int i15, int i16, byte[] bArr) {
        this.formatType = i11;
        this.numChannels = i12;
        this.frameRateHz = i13;
        this.averageBytesPerSecond = i14;
        this.blockSize = i15;
        this.bitsPerSample = i16;
        this.extraData = bArr;
    }
}
