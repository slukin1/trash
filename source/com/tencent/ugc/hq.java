package com.tencent.ugc;

final /* synthetic */ class hq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f50631a;

    private hq(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        this.f50631a = videoDemuxerFFmpeg;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        return new hq(videoDemuxerFFmpeg);
    }

    public final void run() {
        this.f50631a.getNextEncodeVideoFrameInternal();
    }
}
