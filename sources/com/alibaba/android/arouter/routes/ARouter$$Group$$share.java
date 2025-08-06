package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.module.share.ui.FeedShareActivity;
import com.hbg.module.share.ui.GroupShareActivity;
import java.util.Map;

public class ARouter$$Group$$share implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/share/shareFeed", RouteMeta.build(routeType, FeedShareActivity.class, "/share/sharefeed", "share", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/share/shareGroup", RouteMeta.build(routeType, GroupShareActivity.class, "/share/sharegroup", "share", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
