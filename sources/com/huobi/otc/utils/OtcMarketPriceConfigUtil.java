package com.huobi.otc.utils;

import android.text.TextUtils;
import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.huobi.otc.bean.MarketCoin;
import com.huobi.otc.helper.OtcMarketPriceConfigImpl;
import java.util.List;
import lp.d;
import rx.Observable;

public class OtcMarketPriceConfigUtil {

    /* renamed from: a  reason: collision with root package name */
    public static d f79634a = new OtcMarketPriceConfigImpl();

    public static int a(String str) {
        List<MarketCoin.Coin> e11;
        if (TextUtils.isEmpty(str) || (e11 = e()) == null || e11.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        for (MarketCoin.Coin next : e11) {
            if (next != null && str.equalsIgnoreCase(next.getCoinCode())) {
                return next.getCoinId();
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int b(String str) {
        List<MarketCoin.Coin> e11;
        if (TextUtils.isEmpty(str) || (e11 = e()) == null || e11.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        for (MarketCoin.Coin next : e11) {
            if (next != null && str.equalsIgnoreCase(next.getShortName())) {
                return next.getCoinId();
            }
        }
        return Integer.MIN_VALUE;
    }

    public static String c(int i11) {
        List<MarketCoin.Coin> e11;
        if (i11 == Integer.MIN_VALUE || (e11 = e()) == null || e11.isEmpty()) {
            return "";
        }
        for (MarketCoin.Coin next : e11) {
            if (next != null && i11 == next.getCoinId()) {
                return next.getShortName();
            }
        }
        return "";
    }

    public static String d(String str) {
        MarketCoin.Coin g11 = g(str);
        if (g11 == null) {
            return null;
        }
        return g11.getShortName();
    }

    public static List<MarketCoin.Coin> e() {
        return f79634a.a();
    }

    public static Observable<List<MarketCoin.Coin>> f(boolean z11) {
        return f79634a.c(z11);
    }

    public static MarketCoin.Coin g(String str) {
        List<MarketCoin.Coin> e11;
        if (TextUtils.isEmpty(str) || (e11 = e()) == null || e11.isEmpty()) {
            return null;
        }
        for (MarketCoin.Coin next : e11) {
            if (next != null && str.equalsIgnoreCase(next.getCoinCode())) {
                return next;
            }
        }
        return null;
    }

    public static MarketCoin.Coin h(int i11) {
        List<MarketCoin.Coin> e11 = e();
        if (e11 != null && !e11.isEmpty()) {
            for (MarketCoin.Coin next : e11) {
                if (next != null && next.getCoinId() == i11) {
                    return next;
                }
            }
        }
        return null;
    }

    public static MarketCoin.Coin i(String str) {
        return h(b(str));
    }

    public static Observable<List<MarketPrice.Price>> j(boolean z11) {
        return f79634a.b(z11);
    }
}
