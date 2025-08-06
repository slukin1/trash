package com.tencent.ugc;

final /* synthetic */ class fn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50522a;

    private fn(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50522a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fn(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        this.f50522a.DecodeOrAppendMuteFrame();
    }
}
