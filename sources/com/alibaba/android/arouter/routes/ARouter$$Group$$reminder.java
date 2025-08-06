package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.staring.ui.AllRemindNewActivity;
import java.util.Map;

public class ARouter$$Group$$reminder implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/reminder/all", RouteMeta.build(RouteType.ACTIVITY, AllRemindNewActivity.class, "/reminder/all", "reminder", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
