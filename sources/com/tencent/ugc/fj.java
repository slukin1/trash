package com.tencent.ugc;

final /* synthetic */ class fj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50517a;

    private fj(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50517a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fj(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        this.f50517a.DecodeOrAppendMuteFrame();
    }
}
