package com.hbg.component.kline.render;

import java.util.List;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CandleStickRender f67317b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f67318c;

    public /* synthetic */ l(CandleStickRender candleStickRender, List list) {
        this.f67317b = candleStickRender;
        this.f67318c = list;
    }

    public final void run() {
        this.f67317b.Z3(this.f67318c);
    }
}
