package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.lancher.guide.AppWelcomeActivityV4;
import java.util.Map;

public class ARouter$$Group$$guide implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/guide/index", RouteMeta.build(RouteType.ACTIVITY, AppWelcomeActivityV4.class, "/guide/index", "guide", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
