package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;

final /* synthetic */ class hi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.b f50611a;

    /* renamed from: b  reason: collision with root package name */
    private final EncodedVideoFrame f50612b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50613c;

    private hi(UGCVideoProcessor.b bVar, EncodedVideoFrame encodedVideoFrame, boolean z11) {
        this.f50611a = bVar;
        this.f50612b = encodedVideoFrame;
        this.f50613c = z11;
    }

    public static Runnable a(UGCVideoProcessor.b bVar, EncodedVideoFrame encodedVideoFrame, boolean z11) {
        return new hi(bVar, encodedVideoFrame, z11);
    }

    public final void run() {
        UGCVideoProcessor.b.a(this.f50611a, this.f50612b, this.f50613c);
    }
}
