package com.tencent.ugc;

final /* synthetic */ class fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50516a;

    private fi(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        this.f50516a = uGCSingleFileAudioFrameProvider;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider) {
        return new fi(uGCSingleFileAudioFrameProvider);
    }

    public final void run() {
        this.f50516a.stopInternal();
    }
}
