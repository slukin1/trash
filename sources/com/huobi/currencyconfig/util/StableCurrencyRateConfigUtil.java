package com.huobi.currencyconfig.util;

import android.text.TextUtils;
import com.huobi.currencyconfig.bean.StableCoinCreate;
import com.huobi.currencyconfig.bean.StableCoinHints;
import com.huobi.currencyconfig.bean.StableCurrencyRateBean;
import com.huobi.currencyconfig.helper.StableCurrencyRateConfigImpl;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import jj.f;
import rx.Observable;

public class StableCurrencyRateConfigUtil {

    /* renamed from: a  reason: collision with root package name */
    public static f f43761a = new StableCurrencyRateConfigImpl();

    public static Observable<StableCoinCreate> a(Map<String, Object> map) {
        return f43761a.a(map);
    }

    public static void b(String str, Map<String, BigDecimal> map, List<StableCurrencyRateBean.StableCurrencyBean> list) {
        BigDecimal bigDecimal;
        if (map != null && list != null && !list.isEmpty()) {
            for (StableCurrencyRateBean.StableCurrencyBean next : list) {
                if (next != null && !TextUtils.isEmpty(next.getCurrency()) && map.get(next.getCurrency()) == null) {
                    if (next.getCurrency().equalsIgnoreCase(str)) {
                        map.put(str, BigDecimal.ONE);
                    } else if (!(next.getBidRate() == null || (bigDecimal = map.get("usdt")) == null)) {
                        map.put(next.getCurrency(), bigDecimal.multiply(next.getBidRate()));
                    }
                }
            }
        }
    }

    public static Observable<List<StableCoinHints>> c(boolean z11) {
        return f43761a.b(z11);
    }

    public static List<StableCurrencyRateBean.StableCurrencyBean> d() {
        return f43761a.d();
    }

    public static Observable<List<StableCurrencyRateBean.StableCurrencyBean>> e(boolean z11) {
        return f43761a.c(z11);
    }

    public static String f() {
        StableCurrencyRateBean.TradeCurrencyBean f11 = f43761a.f();
        return (f11 == null || f11.getCurrency() == null) ? "husd" : f11.getCurrency();
    }

    public static Observable<String> g(String str) {
        return f43761a.e(str);
    }
}
