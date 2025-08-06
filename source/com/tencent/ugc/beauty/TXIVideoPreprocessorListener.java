package com.tencent.ugc.beauty;

public interface TXIVideoPreprocessorListener {
    void didDetectFacePoints(float[] fArr);

    void didProcessFrame(int i11, int i12, int i13, long j11);

    void didProcessFrame(byte[] bArr, int i11, int i12, int i13, long j11);

    int willAddWatermark(int i11, int i12, int i13);
}
