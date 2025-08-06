package com.huobi.contract.viewhandler;

import com.hbg.lib.common.utils.DateTimeUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.hbg.module.market.MarketModuleConfig;
import com.huobi.homemarket.bean.MarketSymbolPriceItem;
import com.huobi.homemarket.handler.MarketViewHandler;
import i6.r;
import java.util.HashMap;

public class MarketViewCollectionHandler extends MarketViewHandler {
    public boolean T() {
        return false;
    }

    public boolean X(MarketSymbolPriceItem marketSymbolPriceItem) {
        return SymbolBean.PRE_ONLINE.equals(marketSymbolPriceItem.i()) && marketSymbolPriceItem.l() > DateTimeUtils.v();
    }

    public void d0(MarketSymbolPriceItem marketSymbolPriceItem, r rVar) {
    }

    public void g0(MarketSymbolPriceItem marketSymbolPriceItem) {
        HashMap hashMap = new HashMap();
        hashMap.put("symbol", marketSymbolPriceItem.j());
        BaseModuleConfig.a().d("4740", hashMap, "1000047");
        HashMap hashMap2 = new HashMap();
        hashMap2.put("TransPair_current_click_id", marketSymbolPriceItem.j());
        BaseModuleConfig.a().w("App_markets_list_coin_click", hashMap2);
        MarketModuleConfig.a().m("MARKET_QUOTATIONS_SYMBOL");
        MarketModuleConfig.a().t("favorites_symbol_click", marketSymbolPriceItem.j());
    }
}
