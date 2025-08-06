package com.hbg.lib.network.contract;

import android.content.Context;
import c9.b;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import s7.a;

public class ContractPositionApi {

    /* renamed from: a  reason: collision with root package name */
    public static Map<String, a> f69209a = new ConcurrentHashMap(4);

    public static a a(String str) {
        a aVar = f69209a.get(str);
        if (aVar == null) {
            synchronized (ContractPositionApi.class) {
                aVar = f69209a.get(str);
                if (aVar == null) {
                    aVar = new a(str);
                    f69209a.put(str, aVar);
                }
            }
        }
        return aVar;
    }

    public static a b() {
        return a(RemoteMessageConst.NOTIFICATION);
    }

    public static a c() {
        return a("linear-swap-notification");
    }

    public static a d() {
        return a("ws/v5/notification");
    }

    public static a e() {
        return a("swap-notification");
    }

    public static void f(String str, Context context, b bVar) {
        a(str).e(context, bVar);
    }
}
