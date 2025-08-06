package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.activity.NetworkDetectionActivity;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.Map;

public class ARouter$$Group$$network implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/network/detection", RouteMeta.build(RouteType.ACTIVITY, NetworkDetectionActivity.class, "/network/detection", OptionsBridge.NETWORK_KEY, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
