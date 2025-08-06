package com.hbg.module.kline.ui;

import android.view.ViewGroup;

public final /* synthetic */ class l3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24223b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f24224c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f24225d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f24226e;

    public /* synthetic */ l3(MarketInfoFragment marketInfoFragment, ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3) {
        this.f24223b = marketInfoFragment;
        this.f24224c = viewGroup;
        this.f24225d = viewGroup2;
        this.f24226e = viewGroup3;
    }

    public final void run() {
        this.f24223b.Vl(this.f24224c, this.f24225d, this.f24226e);
    }
}
