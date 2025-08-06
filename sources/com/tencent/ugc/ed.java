package com.tencent.ugc;

final /* synthetic */ class ed implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50403a;

    private ed(UGCMediaListSource uGCMediaListSource) {
        this.f50403a = uGCMediaListSource;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource) {
        return new ed(uGCMediaListSource);
    }

    public final void run() {
        this.f50403a.loadNextAudioFrameInternal(5);
    }
}
