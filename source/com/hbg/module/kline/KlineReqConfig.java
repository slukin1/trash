package com.hbg.module.kline;

import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.module.kline.bean.KlineReqConfigData;
import com.huobi.store.AppConfigManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KlineReqConfig {

    /* renamed from: a  reason: collision with root package name */
    public static final Map<String, KlineReqConfigData> f23490a = new HashMap();

    public static long a(int i11, String str, long j11) {
        KlineReqConfigData b11 = b(i11, str);
        long startTime = b11 != null ? b11.getStartTime() : 0;
        return startTime > 0 ? Math.max(j11, startTime) : j11;
    }

    public static KlineReqConfigData b(int i11, String str) {
        Map<String, KlineReqConfigData> map = f23490a;
        KlineReqConfigData klineReqConfigData = map.get(i11 + "_" + str);
        if (klineReqConfigData != null) {
            return klineReqConfigData;
        }
        return null;
    }

    public static boolean c(int i11, String str) {
        return b(i11, str) != null;
    }

    public static void d() {
        List<KlineReqConfigData> k11 = AppConfigManager.k(MgtConfigNumber.KLINE_REQ.number, KlineReqConfigData.class);
        Map<String, KlineReqConfigData> map = f23490a;
        synchronized (map) {
            map.clear();
            if (k11 != null) {
                for (KlineReqConfigData next : k11) {
                    if (next != null) {
                        Map<String, KlineReqConfigData> map2 = f23490a;
                        map2.put(next.getTradeType() + "_" + next.getSymbol(), next);
                    }
                }
            }
        }
    }
}
