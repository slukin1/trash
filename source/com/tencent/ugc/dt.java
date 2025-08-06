package com.tencent.ugc;

final /* synthetic */ class dt implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50384a;

    private dt(UGCMediaListSource uGCMediaListSource) {
        this.f50384a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new dt(uGCMediaListSource);
    }

    public final void run() {
        this.f50384a.loadNextAudioFrameInternal(5);
    }
}
