package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;
import com.tencent.ugc.videobase.common.EncodedVideoFrame;

final /* synthetic */ class by implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass2 f50260a;

    /* renamed from: b  reason: collision with root package name */
    private final EncodedVideoFrame f50261b;

    private by(TXVideoEditer.AnonymousClass2 r12, EncodedVideoFrame encodedVideoFrame) {
        this.f50260a = r12;
        this.f50261b = encodedVideoFrame;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass2 r12, EncodedVideoFrame encodedVideoFrame) {
        return new by(r12, encodedVideoFrame);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass2.a(this.f50260a, this.f50261b);
    }
}
