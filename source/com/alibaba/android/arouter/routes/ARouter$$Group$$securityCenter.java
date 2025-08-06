package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.account.ui.UpdateOtcTradePwdActivity;
import java.util.Map;

public class ARouter$$Group$$securityCenter implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/securityCenter/setFundPassword", RouteMeta.build(RouteType.ACTIVITY, UpdateOtcTradePwdActivity.class, "/securitycenter/setfundpassword", "securitycenter", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
