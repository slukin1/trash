package com.tencent.ugc;

final /* synthetic */ class hn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f50626a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50627b;

    private hn(VideoDemuxerFFmpeg videoDemuxerFFmpeg, String str) {
        this.f50626a = videoDemuxerFFmpeg;
        this.f50627b = str;
    }

    public static Runnable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg, String str) {
        return new hn(videoDemuxerFFmpeg, str);
    }

    public final void run() {
        VideoDemuxerFFmpeg.lambda$open$0(this.f50626a, this.f50627b);
    }
}
