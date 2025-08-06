package com.huobi.feature.controller;

import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.symbol.TradeType;
import com.huobi.trade.bean.MarketCurrentPriceItem;

public abstract class FutureMarketDepthController {
    public abstract void b(int i11);

    public abstract double c();

    public abstract MarketCurrentPriceItem d();

    public abstract double e();

    public abstract double f();

    public abstract int g();

    public abstract boolean h();

    public abstract void i(String str, FutureContractInfo futureContractInfo, TradeType tradeType);

    public abstract void j(int i11);

    public abstract void k(String str, String str2, boolean z11);

    public abstract void l(boolean z11);
}
