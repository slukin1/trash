package com.tencent.ugc;

import android.graphics.Bitmap;

final /* synthetic */ class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50244a;

    /* renamed from: b  reason: collision with root package name */
    private final UGCThumbnailGenerator f50245b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f50246c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50247d;

    /* renamed from: e  reason: collision with root package name */
    private final long f50248e;

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap f50249f;

    private bu(TXVideoEditer tXVideoEditer, UGCThumbnailGenerator uGCThumbnailGenerator, boolean z11, int i11, long j11, Bitmap bitmap) {
        this.f50244a = tXVideoEditer;
        this.f50245b = uGCThumbnailGenerator;
        this.f50246c = z11;
        this.f50247d = i11;
        this.f50248e = j11;
        this.f50249f = bitmap;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, UGCThumbnailGenerator uGCThumbnailGenerator, boolean z11, int i11, long j11, Bitmap bitmap) {
        return new bu(tXVideoEditer, uGCThumbnailGenerator, z11, i11, j11, bitmap);
    }

    public final void run() {
        this.f50244a.handleThumbnailGeneratedDuringProcessing(this.f50245b, this.f50246c, this.f50247d, this.f50248e, this.f50249f);
    }
}
