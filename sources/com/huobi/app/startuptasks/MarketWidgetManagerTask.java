package com.huobi.app.startuptasks;

import bh.j;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.data.MarketSymbolSearchImpl;
import gf.a;

public final class MarketWidgetManagerTask extends BaseAppStartTask {
    public void c() {
        a.h(j.c().getApplicationContext());
        MarketModuleConfig.d(new MarketSymbolSearchImpl());
    }
}
