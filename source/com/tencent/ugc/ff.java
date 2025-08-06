package com.tencent.ugc;

final /* synthetic */ class ff implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50513a;

    private ff(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50513a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new ff(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        this.f50513a.DecodeOrAppendMuteFrame();
    }
}
