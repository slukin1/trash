package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.content.provider.HbgContentProvider;
import com.huobi.provider.HbgApmProvider;
import com.huobi.provider.HbgJumpPageProvider;
import com.huobi.provider.HbgShareProver;
import com.huobi.provider.HgbProvider;
import com.huobi.provider.ImProvider;
import java.util.Map;

public class ARouter$$Group$$provider implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.PROVIDER;
        map.put("/provider/apm", RouteMeta.build(routeType, HbgApmProvider.class, "/provider/apm", "provider", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/provider/content", RouteMeta.build(routeType, HgbProvider.class, "/provider/content", "provider", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/provider/content/jump", RouteMeta.build(routeType, HbgContentProvider.class, "/provider/content/jump", "provider", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/provider/im_userinfo", RouteMeta.build(routeType, ImProvider.class, "/provider/im_userinfo", "provider", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/provider/jumpPage", RouteMeta.build(routeType, HbgJumpPageProvider.class, "/provider/jumppage", "provider", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/provider/share/h5", RouteMeta.build(routeType, HbgShareProver.class, "/provider/share/h5", "provider", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
