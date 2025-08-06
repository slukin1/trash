package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

final /* synthetic */ class cz implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner.AnonymousClass3 f50313a;

    /* renamed from: b  reason: collision with root package name */
    private final float f50314b;

    private cz(TXVideoJoiner.AnonymousClass3 r12, float f11) {
        this.f50313a = r12;
        this.f50314b = f11;
    }

    public static Runnable a(TXVideoJoiner.AnonymousClass3 r12, float f11) {
        return new cz(r12, f11);
    }

    public final void run() {
        TXVideoJoiner.this.notifyJoinProgress(this.f50314b);
    }
}
