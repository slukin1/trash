package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.VideoEncoderInterface;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoEncoder f50427a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoEncodeParams f50428b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoEncoderInterface.VideoEncoderListener f50429c;

    private a(HardwareVideoEncoder hardwareVideoEncoder, VideoEncodeParams videoEncodeParams, VideoEncoderInterface.VideoEncoderListener videoEncoderListener) {
        this.f50427a = hardwareVideoEncoder;
        this.f50428b = videoEncodeParams;
        this.f50429c = videoEncoderListener;
    }

    public static Runnable a(HardwareVideoEncoder hardwareVideoEncoder, VideoEncodeParams videoEncodeParams, VideoEncoderInterface.VideoEncoderListener videoEncoderListener) {
        return new a(hardwareVideoEncoder, videoEncodeParams, videoEncoderListener);
    }

    public final void run() {
        HardwareVideoEncoder.lambda$start$0(this.f50427a, this.f50428b, this.f50429c);
    }
}
