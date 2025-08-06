package com.tencent.ugc;

final /* synthetic */ class ho implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f50628a;

    private ho(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        this.f50628a = videoDemuxerFFmpeg;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        return new ho(videoDemuxerFFmpeg);
    }

    public final void run() {
        VideoDemuxerFFmpeg.lambda$close$1(this.f50628a);
    }
}
