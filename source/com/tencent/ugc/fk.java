package com.tencent.ugc;

final /* synthetic */ class fk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCSingleFileAudioFrameProvider f50518a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50519b;

    private fk(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider, long j11) {
        this.f50518a = uGCSingleFileAudioFrameProvider;
        this.f50519b = j11;
    }

    public static Runnable a(UGCSingleFileAudioFrameProvider uGCSingleFileAudioFrameProvider, long j11) {
        return new fk(uGCSingleFileAudioFrameProvider, j11);
    }

    public final void run() {
        this.f50518a.seekToInFileTime(this.f50518a.timelineToFileTime(this.f50519b));
    }
}
