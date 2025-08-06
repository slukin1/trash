package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import java.util.Map;

public class ARouter$$Group$$webView implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/webView/index", RouteMeta.build(RouteType.ACTIVITY, HBBaseWebActivity.class, "/webview/index", "webview", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
