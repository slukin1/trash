package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import java.util.Map;

public class ARouter$$Root$$hbg_module_market implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put(PrimeRounds.ROUND_TRADE_MARKET_TYPE, ARouter$$Group$$market.class);
    }
}
