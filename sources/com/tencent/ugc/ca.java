package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.encoder.VideoEncoderDef;

final /* synthetic */ class ca implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass2 f50264a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoEncoderDef.EncoderType f50265b;

    private ca(TXVideoEditer.AnonymousClass2 r12, VideoEncoderDef.EncoderType encoderType) {
        this.f50264a = r12;
        this.f50265b = encoderType;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass2 r12, VideoEncoderDef.EncoderType encoderType) {
        return new ca(r12, encoderType);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass2.a(this.f50264a, this.f50265b);
    }
}
