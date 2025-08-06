package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.otcoption.ui.OtcOptionsIndexActivity;
import java.util.Map;

public class ARouter$$Group$$Contract implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/Contract/OtcOptions", RouteMeta.build(RouteType.ACTIVITY, OtcOptionsIndexActivity.class, "/contract/otcoptions", "contract", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
