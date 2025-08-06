package com.tencent.ugc;

final /* synthetic */ class eu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFileAudioFrameProvider f50487a;

    private eu(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        this.f50487a = uGCMultiFileAudioFrameProvider;
    }

    public static Runnable a(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        return new eu(uGCMultiFileAudioFrameProvider);
    }

    public final void run() {
        this.f50487a.readFrameToQueue();
    }
}
