package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, c> f38001a = new ConcurrentHashMap(16);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f38002b = new Object();

    public static c a(GrsBaseInfo grsBaseInfo, Context context) {
        synchronized (f38002b) {
            int uniqueCode = grsBaseInfo.uniqueCode();
            Map<String, c> map = f38001a;
            c cVar = map.get(context.getPackageName() + uniqueCode);
            if (cVar == null) {
                Logger.i("GrsClientManager", "grsClientImpl == null, and new GrsClientImpl");
                c cVar2 = new c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, cVar2);
                return cVar2;
            } else if (cVar.a((Object) new c(grsBaseInfo))) {
                return cVar;
            } else {
                Logger.i("GrsClientManager", "The app_name, ser_country, reg_country and issue_country is equal, but other not.");
                c cVar3 = new c(context, grsBaseInfo);
                map.put(context.getPackageName() + uniqueCode, cVar3);
                return cVar3;
            }
        }
    }
}
