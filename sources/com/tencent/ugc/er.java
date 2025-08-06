package com.tencent.ugc;

final /* synthetic */ class er implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFileAudioFrameProvider f50483a;

    private er(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        this.f50483a = uGCMultiFileAudioFrameProvider;
    }

    public static Runnable a(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider) {
        return new er(uGCMultiFileAudioFrameProvider);
    }

    public final void run() {
        UGCMultiFileAudioFrameProvider.lambda$start$0(this.f50483a);
    }
}
