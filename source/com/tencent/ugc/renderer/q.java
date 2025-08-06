package com.tencent.ugc.renderer;

import com.tencent.ugc.videobase.base.TakeSnapshotListener;
import java.nio.ByteBuffer;

final /* synthetic */ class q implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50787a;

    /* renamed from: b  reason: collision with root package name */
    private final RenderViewHelperInterface f50788b;

    /* renamed from: c  reason: collision with root package name */
    private final ByteBuffer f50789c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50790d;

    /* renamed from: e  reason: collision with root package name */
    private final int f50791e;

    /* renamed from: f  reason: collision with root package name */
    private final TakeSnapshotListener f50792f;

    private q(VideoRenderer videoRenderer, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i11, int i12, TakeSnapshotListener takeSnapshotListener) {
        this.f50787a = videoRenderer;
        this.f50788b = renderViewHelperInterface;
        this.f50789c = byteBuffer;
        this.f50790d = i11;
        this.f50791e = i12;
        this.f50792f = takeSnapshotListener;
    }

    public static Runnable a(VideoRenderer videoRenderer, RenderViewHelperInterface renderViewHelperInterface, ByteBuffer byteBuffer, int i11, int i12, TakeSnapshotListener takeSnapshotListener) {
        return new q(videoRenderer, renderViewHelperInterface, byteBuffer, i11, i12, takeSnapshotListener);
    }

    public final void run() {
        VideoRenderer.lambda$snapshotVideoFrameFromFrameBuffer$12(this.f50787a, this.f50788b, this.f50789c, this.f50790d, this.f50791e, this.f50792f);
    }
}
