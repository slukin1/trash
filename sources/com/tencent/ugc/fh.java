package com.tencent.ugc;

final /* synthetic */ class fh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50515a;

    private fh(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50515a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fh(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        this.f50515a.startInternal();
    }
}
