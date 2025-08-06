package com.tencent.ugc;

final /* synthetic */ class ee implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50404a;

    private ee(UGCMediaListSource uGCMediaListSource) {
        this.f50404a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new ee(uGCMediaListSource);
    }

    public final void run() {
        this.f50404a.loadNextAudioFrameInternal(5);
    }
}
