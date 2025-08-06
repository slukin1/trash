package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

final /* synthetic */ class cw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50308a;

    /* renamed from: b  reason: collision with root package name */
    private final TXVideoJoiner.TXVideoJoinerListener f50309b;

    private cw(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoJoinerListener tXVideoJoinerListener) {
        this.f50308a = tXVideoJoiner;
        this.f50309b = tXVideoJoinerListener;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, TXVideoJoiner.TXVideoJoinerListener tXVideoJoinerListener) {
        return new cw(tXVideoJoiner, tXVideoJoinerListener);
    }

    public final void run() {
        this.f50308a.mTXVideoJoinerListener = this.f50309b;
    }
}
