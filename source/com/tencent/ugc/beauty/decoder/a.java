package com.tencent.ugc.beauty.decoder;

final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoFrameReader f50189a;

    private a(VideoFrameReader videoFrameReader) {
        this.f50189a = videoFrameReader;
    }

    public static Runnable a(VideoFrameReader videoFrameReader) {
        return new a(videoFrameReader);
    }

    public final void run() {
        this.f50189a.threadLoop();
    }
}
