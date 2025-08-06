package com.tencent.ugc;

final /* synthetic */ class hs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f50633a;

    private hs(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        this.f50633a = videoDemuxerFFmpeg;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        return new hs(videoDemuxerFFmpeg);
    }

    public final void run() {
        this.f50633a.getNextEncodeVideoFrameInternal();
    }
}
