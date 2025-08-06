package com.tencent.ugc;

final /* synthetic */ class hr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f50632a;

    private hr(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        this.f50632a = videoDemuxerFFmpeg;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg) {
        return new hr(videoDemuxerFFmpeg);
    }

    public final void run() {
        this.f50632a.getNextEncodeVideoFrameInternal();
    }
}
