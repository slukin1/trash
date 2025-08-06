package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.module.kline.ui.MarketInfoActivity;
import java.util.Map;

public class ARouter$$Group$$kline implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/kline/index", RouteMeta.build(RouteType.ACTIVITY, MarketInfoActivity.class, "/kline/index", "kline", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
