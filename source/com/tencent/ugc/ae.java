package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class ae implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50129a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50130b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50131c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f50132d;

    /* renamed from: e  reason: collision with root package name */
    private final int f50133e;

    /* renamed from: f  reason: collision with root package name */
    private final TXVideoEditer.TXThumbnailListener f50134f;

    private ae(TXVideoEditer tXVideoEditer, int i11, int i12, boolean z11, int i13, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        this.f50129a = tXVideoEditer;
        this.f50130b = i11;
        this.f50131c = i12;
        this.f50132d = z11;
        this.f50133e = i13;
        this.f50134f = tXThumbnailListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, int i12, boolean z11, int i13, TXVideoEditer.TXThumbnailListener tXThumbnailListener) {
        return new ae(tXVideoEditer, i11, i12, z11, i13, tXThumbnailListener);
    }

    public final void run() {
        TXVideoEditer.lambda$getThumbnail$34(this.f50129a, this.f50130b, this.f50131c, this.f50132d, this.f50133e, this.f50134f);
    }
}
