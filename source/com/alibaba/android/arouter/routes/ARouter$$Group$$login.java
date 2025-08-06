package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.huobi.login.v2.ui.CaptchaCodeActivityV2;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.login.v2.ui.ForgetPasswordActivityV2;
import com.huobi.login.v2.ui.PasswordSetActivityV2;
import com.huobi.login.v2.ui.UserLoginActivityV2;
import com.huobi.login.v3.ui.UserRegisterActivityV3;
import java.util.Map;

public class ARouter$$Group$$login implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/login/CountryPicker", RouteMeta.build(routeType, CountryAreaSelectActivityV2.class, "/login/countrypicker", FirebaseAnalytics.Event.LOGIN, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/codeInput", RouteMeta.build(routeType, CaptchaCodeActivityV2.class, "/login/codeinput", FirebaseAnalytics.Event.LOGIN, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/forgetPassword", RouteMeta.build(routeType, ForgetPasswordActivityV2.class, "/login/forgetpassword", FirebaseAnalytics.Event.LOGIN, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/index", RouteMeta.build(routeType, UserLoginActivityV2.class, "/login/index", FirebaseAnalytics.Event.LOGIN, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/password_set_v2", RouteMeta.build(routeType, PasswordSetActivityV2.class, "/login/password_set_v2", FirebaseAnalytics.Event.LOGIN, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/login/register_v2", RouteMeta.build(routeType, UserRegisterActivityV3.class, "/login/register_v2", FirebaseAnalytics.Event.LOGIN, (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
