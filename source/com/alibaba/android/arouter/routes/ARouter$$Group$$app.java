package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.activity.AppConfigAboutUsActivity;
import com.huobi.activity.AppConfigActivity;
import com.huobi.activity.AppLanguageActivity;
import com.huobi.setting.pricing.PricingMethodActivity;
import com.sumsub.sentry.a;
import java.util.Map;

public class ARouter$$Group$$app implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/app/about", RouteMeta.build(routeType, AppConfigAboutUsActivity.class, "/app/about", a.f30241h, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/app/language", RouteMeta.build(routeType, AppLanguageActivity.class, "/app/language", a.f30241h, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/app/price_method", RouteMeta.build(routeType, PricingMethodActivity.class, "/app/price_method", a.f30241h, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/app/settings", RouteMeta.build(routeType, AppConfigActivity.class, "/app/settings", a.f30241h, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
