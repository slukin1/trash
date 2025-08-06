package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class bp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXVideoProcessListener f50233a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50234b;

    private bp(TXVideoEditer.TXVideoProcessListener tXVideoProcessListener, float f11) {
        this.f50233a = tXVideoProcessListener;
        this.f50234b = f11;
    }

    public static Runnable a(TXVideoEditer.TXVideoProcessListener tXVideoProcessListener, float f11) {
        return new bp(tXVideoProcessListener, f11);
    }

    public final void run() {
        this.f50233a.onProcessProgress(this.f50234b);
    }
}
