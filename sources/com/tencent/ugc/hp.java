package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class hp implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoDemuxerFFmpeg f50629a;

    /* renamed from: b  reason: collision with root package name */
    private final long f50630b;

    private hp(VideoDemuxerFFmpeg videoDemuxerFFmpeg, long j11) {
        this.f50629a = videoDemuxerFFmpeg;
        this.f50630b = j11;
    }

    public static Callable a(VideoDemuxerFFmpeg videoDemuxerFFmpeg, long j11) {
        return new hp(videoDemuxerFFmpeg, j11);
    }

    public final Object call() {
        return VideoDemuxerFFmpeg.lambda$seek$2(this.f50629a, this.f50630b);
    }
}
