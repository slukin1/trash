package com.tencent.ugc;

final /* synthetic */ class fg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50514a;

    private fg(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50514a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fg(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        UGCSingleFileAudioFrameProvider.lambda$uninitialize$1(this.f50514a);
    }
}
