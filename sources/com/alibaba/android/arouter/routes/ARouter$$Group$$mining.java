package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.savings.mining.ui.MiningDetailActivity;
import java.util.Map;

public class ARouter$$Group$$mining implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/mining/detail", RouteMeta.build(RouteType.ACTIVITY, MiningDetailActivity.class, "/mining/detail", "mining", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
