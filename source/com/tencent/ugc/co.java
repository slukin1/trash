package com.tencent.ugc;

final /* synthetic */ class co implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner f50297a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50298b;

    private co(TXVideoJoiner tXVideoJoiner, boolean z11) {
        this.f50297a = tXVideoJoiner;
        this.f50298b = z11;
    }

    public static Runnable a(TXVideoJoiner tXVideoJoiner, boolean z11) {
        return new co(tXVideoJoiner, z11);
    }

    public final void run() {
        this.f50297a.mIsNeedEdit = this.f50298b;
    }
}
