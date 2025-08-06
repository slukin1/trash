package com.tencent.ugc.preprocessor;

import com.tencent.ugc.videobase.frame.PixelFrame;

final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoPreprocessor f50728a;

    /* renamed from: b  reason: collision with root package name */
    private final PixelFrame f50729b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50730c;

    private u(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j11) {
        this.f50728a = videoPreprocessor;
        this.f50729b = pixelFrame;
        this.f50730c = j11;
    }

    public static Runnable a(VideoPreprocessor videoPreprocessor, PixelFrame pixelFrame, long j11) {
        return new u(videoPreprocessor, pixelFrame, j11);
    }

    public final void run() {
        VideoPreprocessor.lambda$processFrame$1(this.f50728a, this.f50729b, this.f50730c);
    }
}
