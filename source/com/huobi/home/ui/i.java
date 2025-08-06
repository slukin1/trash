package com.huobi.home.ui;

import com.huobi.finance.bean.TsvMsg;
import com.huobi.home.ui.HomeFragment;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomeFragment f72556b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f72557c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TsvMsg f72558d;

    public /* synthetic */ i(HomeFragment homeFragment, String str, TsvMsg tsvMsg) {
        this.f72556b = homeFragment;
        this.f72557c = str;
        this.f72558d = tsvMsg;
    }

    public final void run() {
        HomeFragment.e.c(this.f72556b, this.f72557c, this.f72558d);
    }
}
