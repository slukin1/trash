package com.tencent.ugc;

final /* synthetic */ class es implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFileAudioFrameProvider f50484a;

    private es(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        this.f50484a = uGCMultiFileAudioFrameProvider;
    }

    public static Runnable a(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        return new es(uGCMultiFileAudioFrameProvider);
    }

    public final void run() {
        UGCMultiFileAudioFrameProvider.lambda$stop$1(this.f50484a);
    }
}
