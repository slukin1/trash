package com.tencent.ugc.renderer;

import android.graphics.Matrix;
import com.tencent.ugc.videobase.base.TakeSnapshotListener;
import java.nio.ByteBuffer;

final /* synthetic */ class u implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final VideoRenderer f50798a;

    /* renamed from: b  reason: collision with root package name */
    private final ByteBuffer f50799b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50800c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50801d;

    /* renamed from: e  reason: collision with root package name */
    private final Matrix f50802e;

    /* renamed from: f  reason: collision with root package name */
    private final TakeSnapshotListener f50803f;

    private u(VideoRenderer videoRenderer, ByteBuffer byteBuffer, int i11, int i12, Matrix matrix, TakeSnapshotListener takeSnapshotListener) {
        this.f50798a = videoRenderer;
        this.f50799b = byteBuffer;
        this.f50800c = i11;
        this.f50801d = i12;
        this.f50802e = matrix;
        this.f50803f = takeSnapshotListener;
    }

    public static Runnable a(VideoRenderer videoRenderer, ByteBuffer byteBuffer, int i11, int i12, Matrix matrix, TakeSnapshotListener takeSnapshotListener) {
        return new u(videoRenderer, byteBuffer, i11, i12, matrix, takeSnapshotListener);
    }

    public final void run() {
        this.f50798a.notifySnapshotCompleted(this.f50799b, this.f50800c, this.f50801d, this.f50802e, this.f50803f);
    }
}
