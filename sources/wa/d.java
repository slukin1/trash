package wa;

import android.text.TextUtils;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.pro.core.bean.CurrencyRateBean;
import com.hbg.lite.config.bean.OtcCurrencyRateBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ra.c;
import rx.Observable;
import x8.a;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static List<OtcCurrencyRateBean> f85027a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, String> f85028b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static String f85029c;

    public static String c(String str) {
        if (f85028b.containsKey(str)) {
            return f85028b.get(str);
        }
        String d11 = ConfigPreferences.d("user_config", "config_app_cny_usd_rate" + str);
        if (!TextUtils.isEmpty(d11)) {
            f85028b.put(str, d11);
        }
        return d11;
    }

    public static Observable<List<OtcCurrencyRateBean>> d(boolean z11) {
        Observable<R> map = a.a().r(c.c().D() + "general/exchange_rate/list").b().map(c.f61234b);
        return z11 ? Observable.concat(Observable.just(f85027a), map).takeFirst(b.f61233b) : map;
    }

    public static /* synthetic */ Boolean f(List list) {
        return Boolean.valueOf(list != null);
    }

    public static void g(String str, String str2) {
        f85028b.put(str, str2);
        ConfigPreferences.m("user_config", "config_app_cny_usd_rate" + str, str2);
    }

    public static void h(List<CurrencyRateBean> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (CurrencyRateBean next : list) {
                if (next != null) {
                    OtcCurrencyRateBean otcCurrencyRateBean = new OtcCurrencyRateBean();
                    otcCurrencyRateBean.j(next);
                    otcCurrencyRateBean.e();
                    String str = "0";
                    if (otcCurrencyRateBean.h()) {
                        if (next.getRate() != null) {
                            str = next.getRate().toPlainString();
                        }
                        f85029c = str;
                        g(otcCurrencyRateBean.b(), f85029c);
                    } else if (otcCurrencyRateBean.g() && !otcCurrencyRateBean.f()) {
                        if (next.getRate() != null) {
                            str = next.getRate().toPlainString();
                        }
                        g(otcCurrencyRateBean.b(), str);
                    }
                }
            }
            f85027a = arrayList;
        }
    }
}
