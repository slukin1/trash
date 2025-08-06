package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

final /* synthetic */ class gx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50584a;

    /* renamed from: b  reason: collision with root package name */
    private final UGCVideoProcessor.VideoProcessListener f50585b;

    private gx(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoProcessListener videoProcessListener) {
        this.f50584a = uGCVideoProcessor;
        this.f50585b = videoProcessListener;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, UGCVideoProcessor.VideoProcessListener videoProcessListener) {
        return new gx(uGCVideoProcessor, videoProcessListener);
    }

    public final void run() {
        this.f50584a.mVideoProcessListener = this.f50585b;
    }
}
