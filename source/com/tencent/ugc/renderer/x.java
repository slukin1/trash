package com.tencent.ugc.renderer;

import com.tencent.ugc.videobase.base.TakeSnapshotListener;

final /* synthetic */ class x implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50809a;

    /* renamed from: b  reason: collision with root package name */
    private final TakeSnapshotListener f50810b;

    private x(VideoRenderer videoRenderer, TakeSnapshotListener takeSnapshotListener) {
        this.f50809a = videoRenderer;
        this.f50810b = takeSnapshotListener;
    }

    public static Runnable a(VideoRenderer videoRenderer, TakeSnapshotListener takeSnapshotListener) {
        return new x(videoRenderer, takeSnapshotListener);
    }

    public final void run() {
        VideoRenderer.lambda$takeSnapshot$3(this.f50809a, this.f50810b);
    }
}
