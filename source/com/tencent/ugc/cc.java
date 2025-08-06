package com.tencent.ugc;

import com.tencent.ugc.TXVideoEditer;

final /* synthetic */ class cc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer.AnonymousClass3 f50267a;

    /* renamed from: b  reason: collision with root package name */
    private final AudioFrame f50268b;

    private cc(TXVideoEditer.AnonymousClass3 r12, AudioFrame audioFrame) {
        this.f50267a = r12;
        this.f50268b = audioFrame;
    }

    public static Runnable a(TXVideoEditer.AnonymousClass3 r12, AudioFrame audioFrame) {
        return new cc(r12, audioFrame);
    }

    public final void run() {
        TXVideoEditer.AnonymousClass3.a(this.f50267a, this.f50268b);
    }
}
