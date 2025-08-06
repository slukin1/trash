package com.tencent.ugc;

final /* synthetic */ class et implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMultiFileAudioFrameProvider f50485a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50486b;

    private et(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider, long j11) {
        this.f50485a = uGCMultiFileAudioFrameProvider;
        this.f50486b = j11;
    }

    public static Runnable a(UGCMultiFileAudioFrameProvider uGCMultiFileAudioFrameProvider, long j11) {
        return new et(uGCMultiFileAudioFrameProvider, j11);
    }

    public final void run() {
        UGCMultiFileAudioFrameProvider.lambda$seekTo$2(this.f50485a, this.f50486b);
    }
}
