package com.tencent.ugc.decoder;

import com.tencent.ugc.decoder.VideoDecoderDef;

final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HardwareVideoDecoder f50338a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoDecoderDef.ConsumerScene f50339b;

    private g(HardwareVideoDecoder hardwareVideoDecoder, VideoDecoderDef.ConsumerScene consumerScene) {
        this.f50338a = hardwareVideoDecoder;
        this.f50339b = consumerScene;
    }

    public static Runnable a(HardwareVideoDecoder hardwareVideoDecoder, VideoDecoderDef.ConsumerScene consumerScene) {
        return new g(hardwareVideoDecoder, consumerScene);
    }

    public final void run() {
        HardwareVideoDecoder.lambda$setScene$1(this.f50338a, this.f50339b);
    }
}
