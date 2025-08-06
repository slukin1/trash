package com.tencent.ugc;

final /* synthetic */ class ht implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f50634a;

    private ht(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        this.f50634a = videoDemuxerFFmpeg;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        return new ht(videoDemuxerFFmpeg);
    }

    public final void run() {
        this.f50634a.getNextEncodeVideoFrameInternal();
    }
}
