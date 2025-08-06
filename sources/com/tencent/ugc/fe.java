package com.tencent.ugc;

final /* synthetic */ class fe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50512a;

    private fe(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50512a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fe(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        UGCSingleFileAudioFrameProvider.lambda$initialize$0(this.f50512a);
    }
}
