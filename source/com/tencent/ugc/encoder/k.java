package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.VideoEncoderInterface;

final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final SoftwareEncoderWrapper f50452a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoEncoderInterface.VideoEncoderListener f50453b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoEncodeParams f50454c;

    private k(SoftwareEncoderWrapper softwareEncoderWrapper, VideoEncoderInterface.VideoEncoderListener videoEncoderListener, VideoEncodeParams videoEncodeParams) {
        this.f50452a = softwareEncoderWrapper;
        this.f50453b = videoEncoderListener;
        this.f50454c = videoEncodeParams;
    }

    public static Runnable a(SoftwareEncoderWrapper softwareEncoderWrapper, VideoEncoderInterface.VideoEncoderListener videoEncoderListener, VideoEncodeParams videoEncodeParams) {
        return new k(softwareEncoderWrapper, videoEncoderListener, videoEncodeParams);
    }

    public final void run() {
        SoftwareEncoderWrapper.lambda$start$1(this.f50452a, this.f50453b, this.f50454c);
    }
}
