package com.tencent.ugc.encoder;

import com.tencent.ugc.encoder.VideoEncoderDef;

final /* synthetic */ class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoEncodeController f50475a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoEncodeParams f50476b;

    /* renamed from: c  reason: collision with root package name */
    private final VideoEncoderDef.VideoEncoderDataListener f50477c;

    private z(UGCVideoEncodeController uGCVideoEncodeController, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        this.f50475a = uGCVideoEncodeController;
        this.f50476b = videoEncodeParams;
        this.f50477c = videoEncoderDataListener;
    }

    public static Runnable a(UGCVideoEncodeController uGCVideoEncodeController, VideoEncodeParams videoEncodeParams, VideoEncoderDef.VideoEncoderDataListener videoEncoderDataListener) {
        return new z(uGCVideoEncodeController, videoEncodeParams, videoEncoderDataListener);
    }

    public final void run() {
        UGCVideoEncodeController.lambda$start$0(this.f50475a, this.f50476b, this.f50477c);
    }
}
