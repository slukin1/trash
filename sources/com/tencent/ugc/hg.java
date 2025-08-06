package com.tencent.ugc;

import com.tencent.ugc.UGCVideoProcessor;

final /* synthetic */ class hg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor.AnonymousClass1 f50606a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50607b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50608c;

    private hg(UGCVideoProcessor.AnonymousClass1 r12, int i11, int i12) {
        this.f50606a = r12;
        this.f50607b = i11;
        this.f50608c = i12;
    }

    public static Runnable a(UGCVideoProcessor.AnonymousClass1 r12, int i11, int i12) {
        return new hg(r12, i11, i12);
    }

    public final void run() {
        UGCVideoProcessor.this.mVideoProcessManager.setOutputSize(this.f50607b, this.f50608c);
    }
}
