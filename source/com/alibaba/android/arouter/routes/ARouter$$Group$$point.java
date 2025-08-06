package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.points.activity.MyPointsNewActivity;
import com.huobi.points.activity.PointsExchangeActivity;
import com.huobi.points.activity.PointsProductsActivity;
import java.util.Map;

public class ARouter$$Group$$point implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/point/card/list", RouteMeta.build(routeType, PointsProductsActivity.class, "/point/card/list", "point", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/point/card/purchase", RouteMeta.build(routeType, PointsExchangeActivity.class, "/point/card/purchase", "point", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/point/index", RouteMeta.build(routeType, MyPointsNewActivity.class, "/point/index", "point", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
