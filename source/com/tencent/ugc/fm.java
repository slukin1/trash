package com.tencent.ugc;

final /* synthetic */ class fm implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50521a;

    private fm(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50521a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fm(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        this.f50521a.DecodeOrAppendMuteFrame();
    }
}
