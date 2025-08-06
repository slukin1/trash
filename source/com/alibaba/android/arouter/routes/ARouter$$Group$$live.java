package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.lib.network.pro.core.bean.ChainInfo;
import com.hbg.module.content.ui.activity.live.LiveDetailActivity;
import com.hbg.module.livesquare.ui.LiveCategoryActivity;
import com.hbg.module.livesquare.ui.LiveSquareActivity;
import com.hbg.module.livesquare.ui.LiveSquareSubActivity;
import java.util.Map;

public class ARouter$$Group$$live implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/live/category_list", RouteMeta.build(routeType, LiveCategoryActivity.class, "/live/category_list", ChainInfo.CHAIN_TYPE_LIVE, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/live/room", RouteMeta.build(routeType, LiveDetailActivity.class, "/live/room", ChainInfo.CHAIN_TYPE_LIVE, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/live/square", RouteMeta.build(routeType, LiveSquareActivity.class, "/live/square", ChainInfo.CHAIN_TYPE_LIVE, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/live/sub", RouteMeta.build(routeType, LiveSquareSubActivity.class, "/live/sub", ChainInfo.CHAIN_TYPE_LIVE, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
