package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class al implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50146a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50147b;

    /* renamed from: c  reason: collision with root package name */
    private final long f50148c;

    /* renamed from: d  reason: collision with root package name */
    private final int f50149d;

    /* renamed from: e  reason: collision with root package name */
    private final TXVideoEditer.TXVideoProcessListener f50150e;

    private al(TXVideoEditer tXVideoEditer, int i11, long j11, int i12, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        this.f50146a = tXVideoEditer;
        this.f50147b = i11;
        this.f50148c = j11;
        this.f50149d = i12;
        this.f50150e = tXVideoProcessListener;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, int i11, long j11, int i12, TXVideoEditer.TXVideoProcessListener tXVideoProcessListener) {
        return new al(tXVideoEditer, i11, j11, i12, tXVideoProcessListener);
    }

    public final void run() {
        TXVideoEditer.lambda$handleThumbnailGeneratedDuringProcessing$40(this.f50146a, this.f50147b, this.f50148c, this.f50149d, this.f50150e);
    }
}
