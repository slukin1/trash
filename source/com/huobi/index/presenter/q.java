package com.huobi.index.presenter;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexPresenter f73467b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f73468c;

    public /* synthetic */ q(IndexPresenter indexPresenter, boolean z11) {
        this.f73467b = indexPresenter;
        this.f73468c = z11;
    }

    public final void run() {
        this.f73467b.f2(this.f73468c);
    }
}
