package com.tencent.ugc;

final /* synthetic */ class fl implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50520a;

    private fl(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50520a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fl(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        this.f50520a.DecodeOrAppendMuteFrame();
    }
}
