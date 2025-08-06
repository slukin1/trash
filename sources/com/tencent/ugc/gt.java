package com.tencent.ugc;

final /* synthetic */ class gt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50571a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50572b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50573c;

    private gt(UGCVideoProcessor uGCVideoProcessor, int i11, int i12) {
        this.f50571a = uGCVideoProcessor;
        this.f50572b = i11;
        this.f50573c = i12;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, int i11, int i12) {
        return new gt(uGCVideoProcessor, i11, i12);
    }

    public final void run() {
        this.f50571a.mVideoProcessManager.setBeautyFilter(this.f50572b, this.f50573c);
    }
}
