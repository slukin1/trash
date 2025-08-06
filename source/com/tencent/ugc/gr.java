package com.tencent.ugc;

final /* synthetic */ class gr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoProcessor f50567a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50568b;

    private gr(UGCVideoProcessor uGCVideoProcessor, int i11) {
        this.f50567a = uGCVideoProcessor;
        this.f50568b = i11;
    }

    public static Runnable a(UGCVideoProcessor uGCVideoProcessor, int i11) {
        return new gr(uGCVideoProcessor, i11);
    }

    public final void run() {
        this.f50567a.mTransitionType = this.f50568b;
    }
}
