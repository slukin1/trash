package com.tencent.ugc;

import com.tencent.ugc.encoder.VideoEncodeParams;

final /* synthetic */ class gp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50563a;

    /* renamed from: b  reason: collision with root package name */
    private final VideoEncodeParams f50564b;

    private gp(UGCVideoProcessor uGCVideoProcessor, VideoEncodeParams videoEncodeParams) {
        this.f50563a = uGCVideoProcessor;
        this.f50564b = videoEncodeParams;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, VideoEncodeParams videoEncodeParams) {
        return new gp(uGCVideoProcessor, videoEncodeParams);
    }

    public final void run() {
        this.f50563a.mVideoEncodeParams = this.f50564b;
    }
}
