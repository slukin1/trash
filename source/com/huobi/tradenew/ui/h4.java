package com.huobi.tradenew.ui;

import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import rx.functions.Action1;

public final /* synthetic */ class h4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotFragment f83419b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f83420c;

    public /* synthetic */ h4(TradeVerticalSpotFragment tradeVerticalSpotFragment, String str) {
        this.f83419b = tradeVerticalSpotFragment;
        this.f83420c = str;
    }

    public final void call(Object obj) {
        this.f83419b.Am(this.f83420c, (GridSymbolsConfig) obj);
    }
}
