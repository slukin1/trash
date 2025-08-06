package com.hbg.component.kline.render;

import java.util.List;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CandleStickRender f67297b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f67298c;

    public /* synthetic */ b(CandleStickRender candleStickRender, List list) {
        this.f67297b = candleStickRender;
        this.f67298c = list;
    }

    public final void run() {
        this.f67297b.Y3(this.f67298c);
    }
}
