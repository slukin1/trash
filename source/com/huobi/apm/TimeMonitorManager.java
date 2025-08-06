package com.huobi.apm;

import ah.b;
import java.util.HashMap;

public class TimeMonitorManager {

    /* renamed from: b  reason: collision with root package name */
    public static TimeMonitorManager f42117b;

    /* renamed from: a  reason: collision with root package name */
    public HashMap<String, b> f42118a;

    public TimeMonitorManager() {
        this.f42118a = null;
        this.f42118a = new HashMap<>();
    }

    public static synchronized TimeMonitorManager a() {
        TimeMonitorManager timeMonitorManager;
        synchronized (TimeMonitorManager.class) {
            if (f42117b == null) {
                f42117b = new TimeMonitorManager();
            }
            timeMonitorManager = f42117b;
        }
        return timeMonitorManager;
    }

    public b b(String str) {
        b bVar = this.f42118a.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b(str);
        this.f42118a.put(str, bVar2);
        return bVar2;
    }
}
