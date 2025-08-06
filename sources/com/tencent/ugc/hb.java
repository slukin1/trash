package com.tencent.ugc;

import com.tencent.ugc.encoder.VideoEncoderDef;

final /* synthetic */ class hb implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50591a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50592b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoEncoderDef.EncoderType f50593c;

    private hb(UGCVideoProcessor uGCVideoProcessor, boolean z11, VideoEncoderDef.EncoderType encoderType) {
        this.f50591a = uGCVideoProcessor;
        this.f50592b = z11;
        this.f50593c = encoderType;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, boolean z11, VideoEncoderDef.EncoderType encoderType) {
        return new hb(uGCVideoProcessor, z11, encoderType);
    }

    public final void run() {
        UGCVideoProcessor.lambda$start$1(this.f50591a, this.f50592b, this.f50593c);
    }
}
