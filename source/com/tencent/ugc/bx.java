package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class bx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass2 f50259a;

    private bx(TXVideoEditer.AnonymousClass2 r12) {
        this.f50259a = r12;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass2 r12) {
        return new bx(r12);
    }

    public final void run() {
        boolean unused = TXVideoEditer.this.mIsVideoEncoderStarted = true;
    }
}
