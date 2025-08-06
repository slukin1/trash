package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class br implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.TXVideoGenerateListener f50237a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50238b;

    private br(TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener, float f11) {
        this.f50237a = tXVideoGenerateListener;
        this.f50238b = f11;
    }

    public static Runnable a(TXVideoEditer.TXVideoGenerateListener tXVideoGenerateListener, float f11) {
        return new br(tXVideoGenerateListener, f11);
    }

    public final void run() {
        this.f50237a.onGenerateProgress(this.f50238b);
    }
}
