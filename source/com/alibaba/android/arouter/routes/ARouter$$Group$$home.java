package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huobi.home.ui.TransferAmountGuideActivity;
import com.huobi.index.ui.widget.HomeTransferAmountFragment;
import com.huobi.index.ui.widget.QuickAdditionFragment;
import com.huobi.operation.MoreOperationActivity;
import com.huobi.staring.ui.RemindInfoActivity;
import java.util.Map;

public class ARouter$$Group$$home implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.FRAGMENT;
        map.put("/home/ReplaceFunction", RouteMeta.build(routeType, QuickAdditionFragment.class, "/home/replacefunction", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/home/TransferAmount", RouteMeta.build(routeType, HomeTransferAmountFragment.class, "/home/transferamount", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        RouteType routeType2 = RouteType.ACTIVITY;
        map.put("/home/operation/more", RouteMeta.build(routeType2, MoreOperationActivity.class, "/home/operation/more", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/home/remindInfo", RouteMeta.build(routeType2, RemindInfoActivity.class, "/home/remindinfo", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/home/transferAmountGuide", RouteMeta.build(routeType2, TransferAmountGuideActivity.class, "/home/transferamountguide", "home", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
