package com.tencent.ugc;

final /* synthetic */ class bg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoEditer f50215a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50216b;

    private bg(TXVideoEditer tXVideoEditer, boolean z11) {
        this.f50215a = tXVideoEditer;
        this.f50216b = z11;
    }

    public static Runnable a(TXVideoEditer tXVideoEditer, boolean z11) {
        return new bg(tXVideoEditer, z11);
    }

    public final void run() {
        this.f50215a.mIsFullIFrame = this.f50216b;
    }
}
