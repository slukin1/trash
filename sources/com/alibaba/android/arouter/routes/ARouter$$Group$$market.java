package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.lib.network.hbg.prime.PrimeRounds;
import com.hbg.module.market.widget.ui.MarketPlateDetailActivity;
import com.hbg.module.market.widget.ui.MarketWidgetSettingActivity;
import java.util.Map;

public class ARouter$$Group$$market implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/market/plateDetail", RouteMeta.build(routeType, MarketPlateDetailActivity.class, "/market/platedetail", PrimeRounds.ROUND_TRADE_MARKET_TYPE, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/market/realTimeReminder", RouteMeta.build(routeType, MarketWidgetSettingActivity.class, "/market/realtimereminder", PrimeRounds.ROUND_TRADE_MARKET_TYPE, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
