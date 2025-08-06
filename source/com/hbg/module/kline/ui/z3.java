package com.hbg.module.kline.ui;

import android.view.animation.Animation;
import com.hbg.module.kline.ui.MarketInfoFragment;

public final /* synthetic */ class z3 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Animation f24312b;

    public /* synthetic */ z3(Animation animation) {
        this.f24312b = animation;
    }

    public final void run() {
        MarketInfoFragment.f.b(this.f24312b);
    }
}
