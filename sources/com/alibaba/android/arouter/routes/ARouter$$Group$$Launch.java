package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.activity.StartFlashActivity;
import com.huobi.index.ui.NewOldSelectActivity;
import java.util.Map;

public class ARouter$$Group$$Launch implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/Launch/index", RouteMeta.build(routeType, StartFlashActivity.class, "/launch/index", "launch", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/Launch/new_old_select", RouteMeta.build(routeType, NewOldSelectActivity.class, "/launch/new_old_select", "launch", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
