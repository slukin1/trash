package com.hbg.module.kline.ui;

import android.widget.TextView;

public final /* synthetic */ class m3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketInfoFragment f24232b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TextView f24233c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TextView f24234d;

    public /* synthetic */ m3(MarketInfoFragment marketInfoFragment, TextView textView, TextView textView2) {
        this.f24232b = marketInfoFragment;
        this.f24233c = textView;
        this.f24234d = textView2;
    }

    public final void run() {
        this.f24232b.Wl(this.f24233c, this.f24234d);
    }
}
