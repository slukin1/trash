package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.module.account.index.ui.AccountActivity;
import java.util.Map;

public class ARouter$$Group$$newAccount implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        map.put("/newAccount/index", RouteMeta.build(RouteType.ACTIVITY, AccountActivity.class, "/newaccount/index", "newaccount", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
