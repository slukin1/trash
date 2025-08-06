package com.huobi.trade.ui;

import com.hbg.lib.network.hbg.grid.bean.GridSymbolsConfig;
import rx.functions.Action1;

public final /* synthetic */ class o4 implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TradeVerticalSpotFragment f82684b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f82685c;

    public /* synthetic */ o4(TradeVerticalSpotFragment tradeVerticalSpotFragment, String str) {
        this.f82684b = tradeVerticalSpotFragment;
        this.f82685c = str;
    }

    public final void call(Object obj) {
        this.f82684b.Em(this.f82685c, (GridSymbolsConfig) obj);
    }
}
