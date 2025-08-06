package com.huobi.index.ui;

import com.huobi.finance.bean.TsvMsg;
import com.huobi.index.ui.IndexFragment;

public final /* synthetic */ class r0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexFragment.p f73973b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f73974c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TsvMsg f73975d;

    public /* synthetic */ r0(IndexFragment.p pVar, String str, TsvMsg tsvMsg) {
        this.f73973b = pVar;
        this.f73974c = str;
        this.f73975d = tsvMsg;
    }

    public final void run() {
        this.f73973b.b(this.f73974c, this.f73975d);
    }
}
