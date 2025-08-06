package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

final /* synthetic */ class gq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50565a;

    /* renamed from: b  reason: collision with root package name */
    private final UGCVideoProcessor.VideoEncodedFrameListener f50566b;

    private gq(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoEncodedFrameListener videoEncodedFrameListener) {
        this.f50565a = uGCVideoProcessor;
        this.f50566b = videoEncodedFrameListener;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoEncodedFrameListener videoEncodedFrameListener) {
        return new gq(uGCVideoProcessor, videoEncodedFrameListener);
    }

    public final void run() {
        this.f50565a.mVideoEncodedFrameListener = this.f50566b;
    }
}
