package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.otc.ui.OtcExchangeShellActivity;
import com.huobi.otc.ui.OtcMyOrderListActivity;
import com.huobi.otc.ui.OtcNewUserShellActivity;
import com.huobi.otc.ui.OtcPayMethodShellActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.ui.OtcTradeSettingShellActivity;
import com.huobi.otc.ui.OtcWordAdShellActivity;
import java.util.Map;

public class ARouter$$Group$$otc implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/otc/index", RouteMeta.build(routeType, OtcTradeActivity.class, "/otc/index", "otc", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/otc/paymentList", RouteMeta.build(routeType, OtcPayMethodShellActivity.class, "/otc/paymentlist", "otc", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/otc/trade/OrderList", RouteMeta.build(routeType, OtcMyOrderListActivity.class, "/otc/trade/orderlist", "otc", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/otc/trade/exchange", RouteMeta.build(routeType, OtcExchangeShellActivity.class, "/otc/trade/exchange", "otc", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/otc/trade/p2PTradingLeading", RouteMeta.build(routeType, OtcTradeSettingShellActivity.class, "/otc/trade/p2ptradingleading", "otc", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/otc/user/guide", RouteMeta.build(routeType, OtcNewUserShellActivity.class, "/otc/user/guide", "otc", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/otc/word/ad", RouteMeta.build(routeType, OtcWordAdShellActivity.class, "/otc/word/ad", "otc", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
