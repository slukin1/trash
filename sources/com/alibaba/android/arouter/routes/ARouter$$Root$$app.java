package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sentry.a;
import com.tencent.android.tpush.common.Constants;
import java.util.Map;

public class ARouter$$Root$$app implements IRouteRoot {
    public void loadInto(Map<String, Class<? extends IRouteGroup>> map) {
        map.put("Contract", ARouter$$Group$$Contract.class);
        map.put("Launch", ARouter$$Group$$Launch.class);
        map.put(Constants.FLAG_ACCOUNT, ARouter$$Group$$account.class);
        map.put(a.f30241h, ARouter$$Group$$app.class);
        map.put("balance", ARouter$$Group$$balance.class);
        map.put("guide", ARouter$$Group$$guide.class);
        map.put("home", ARouter$$Group$$home.class);
        map.put(FirebaseAnalytics.Event.LOGIN, ARouter$$Group$$login.class);
        map.put("mining", ARouter$$Group$$mining.class);
        map.put(OptionsBridge.NETWORK_KEY, ARouter$$Group$$network.class);
        map.put("point", ARouter$$Group$$point.class);
        map.put("provider", ARouter$$Group$$provider.class);
        map.put("ranking", ARouter$$Group$$ranking.class);
        map.put("reminder", ARouter$$Group$$reminder.class);
        map.put("securityCenter", ARouter$$Group$$securityCenter.class);
    }
}
