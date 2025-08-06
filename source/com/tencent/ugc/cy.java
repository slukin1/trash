package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

final /* synthetic */ class cy implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner.AnonymousClass1 f50312a;

    private cy(TXVideoJoiner.AnonymousClass1 r12) {
        this.f50312a = r12;
    }

    public static Runnable a(TXVideoJoiner.AnonymousClass1 r12) {
        return new cy(r12);
    }

    public final void run() {
        TXVideoJoiner.this.stopPlayInternal();
    }
}
