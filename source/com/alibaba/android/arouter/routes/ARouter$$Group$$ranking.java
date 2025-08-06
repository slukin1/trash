package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.index.ui.RankingActivity;
import java.util.Map;

public class ARouter$$Group$$ranking implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/ranking/index", RouteMeta.build(RouteType.ACTIVITY, RankingActivity.class, "/ranking/index", "ranking", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
