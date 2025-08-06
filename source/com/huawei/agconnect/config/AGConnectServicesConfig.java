package com.huawei.agconnect.config;

import android.content.Context;
import com.huawei.agconnect.AGCRoutePolicy;
import com.huawei.agconnect.AGConnectOptions;
import com.huawei.agconnect.config.impl.c;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Deprecated
public abstract class AGConnectServicesConfig implements AGConnectOptions {
    private static final Map<String, AGConnectServicesConfig> INSTANCES = new HashMap();
    private static final Object INSTANCES_LOCK = new Object();

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ int f37472i = 0;

    public static AGConnectServicesConfig fromContext(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return fromContext(context, context.getPackageName());
    }

    public static AGConnectServicesConfig fromContext(Context context, String str) {
        AGConnectServicesConfig aGConnectServicesConfig;
        synchronized (INSTANCES_LOCK) {
            Map<String, AGConnectServicesConfig> map = INSTANCES;
            aGConnectServicesConfig = map.get(str);
            if (aGConnectServicesConfig == null) {
                aGConnectServicesConfig = new c(context, str);
                map.put(str, aGConnectServicesConfig);
            }
        }
        return aGConnectServicesConfig;
    }

    public abstract void overlayWith(LazyInputStream lazyInputStream);

    public abstract void overlayWith(InputStream inputStream);

    public abstract void setParam(String str, String str2);

    public abstract void setRoutePolicy(AGCRoutePolicy aGCRoutePolicy);
}
