package com.hbg.lib.data;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import java.math.BigDecimal;
import java.util.Map;

public class HbgDataModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public static a f68827a;

    public interface a {
        Map<String, BigDecimal> a(String str, Map<String, SymbolPrice> map);
    }

    public static a a() {
        return f68827a;
    }

    public static void b(a aVar) {
        f68827a = aVar;
    }
}
