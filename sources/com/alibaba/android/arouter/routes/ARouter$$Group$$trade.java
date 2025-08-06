package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.module.exchange.grid.ui.GridReminderActivity;
import com.hbg.module.exchange.grid.ui.GridTradeActivity;
import java.util.Map;

public class ARouter$$Group$$trade implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/trade/grid", RouteMeta.build(routeType, GridTradeActivity.class, "/trade/grid", "trade", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/trade/gridReminder", RouteMeta.build(routeType, GridReminderActivity.class, "/trade/gridreminder", "trade", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
