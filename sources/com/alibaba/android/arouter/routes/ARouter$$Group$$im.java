package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.hbg.module.huobi.im.c2c.ui.CustomerInfoActivity;
import com.hbg.module.huobi.im.c2c.ui.ImC2CChatActivity;
import com.hbg.module.huobi.im.group.ui.JoinGroupAdminActivity;
import com.hbg.module.huobi.im.group.ui.chat.ImGroupChatActivity;
import java.util.Map;

public class ARouter$$Group$$im implements IRouteGroup {
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put("/im/accountManager", RouteMeta.build(routeType, CustomerInfoActivity.class, "/im/accountmanager", "im", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/im/applylist", RouteMeta.build(routeType, JoinGroupAdminActivity.class, "/im/applylist", "im", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/im/chat", RouteMeta.build(routeType, ImC2CChatActivity.class, "/im/chat", "im", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
        map.put("/im/groupchat", RouteMeta.build(routeType, ImGroupChatActivity.class, "/im/groupchat", "im", (Map<String, Integer>) null, -1, Integer.MIN_VALUE));
    }
}
