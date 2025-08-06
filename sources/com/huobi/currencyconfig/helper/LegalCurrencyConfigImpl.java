package com.huobi.currencyconfig.helper;

import android.text.TextUtils;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.network.rx.SilentSubscriber;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.HbgDataModuleConfig;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.hbg.core.bean.PricingMethodBean;
import com.hbg.lib.network.mgt.core.bean.LegalRateBean;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import i6.d;
import i6.m;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jj.a;
import jj.b;
import jj.e;
import rx.Observable;

public class LegalCurrencyConfigImpl implements a {

    /* renamed from: a  reason: collision with root package name */
    public List<LegalRateBean> f43750a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<String, String> f43751b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public Map<String, SymbolPrice> f43752c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, BigDecimal> f43753d = new ConcurrentHashMap();

    public static /* synthetic */ Boolean v(Map map) {
        return Boolean.valueOf(map != null && !map.isEmpty());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Map w(List list) {
        HashMap hashMap = new HashMap();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            SymbolPrice symbolPrice = (SymbolPrice) it2.next();
            hashMap.put(symbolPrice.getSymbol(), symbolPrice);
        }
        i(hashMap);
        return hashMap;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ List x(List list) {
        A(list);
        return list;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(Map map) {
        Map<String, BigDecimal> a11 = HbgDataModuleConfig.a().a("usdt", map);
        synchronized (this.f43753d) {
            this.f43753d.clear();
            this.f43753d.putAll(a11);
        }
    }

    public void A(List<LegalRateBean> list) {
        if (list != null && !list.isEmpty()) {
            this.f43750a = list;
            for (LegalRateBean next : list) {
                if (next != null) {
                    next.initPreAndAfter();
                    z(next.getName(), next.getRate() != null ? next.getRate().toPlainString() : "0");
                }
            }
            d.b("LegalCurrencyConfigImpl-->\n list-->" + list + "\n mCurrencyRateMap-->" + this.f43751b);
        }
    }

    public final void B() {
        Observable.just(this.f43752c).compose(RxJavaHelper.s()).subscribe(SilentSubscriber.a(new b(this)));
    }

    public String a(String str, String str2, String str3) {
        BigDecimal bigDecimal;
        if (this.f43753d.isEmpty()) {
            return "0.00";
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            bigDecimal = this.f43753d.get(g11);
        }
        if (bigDecimal != null) {
            return LegalCurrencyConfigUtil.h(m.a(str3).multiply(bigDecimal).toPlainString(), str2);
        }
        return "0.00";
    }

    public String b(String str, BigDecimal bigDecimal, String str2, int i11) {
        BigDecimal bigDecimal2;
        if (this.f43753d.isEmpty()) {
            return "0.00";
        }
        String g11 = StringUtils.g(str);
        if (bigDecimal == null) {
            synchronized (this.f43753d) {
                bigDecimal2 = this.f43753d.get(g11);
            }
            bigDecimal = bigDecimal2;
        }
        if (bigDecimal == null || m.c0(bigDecimal)) {
            return "0.00";
        }
        return u(m.a(str2).divide(bigDecimal, i11, 1), i11, i11);
    }

    public String c(String str, String str2, String str3) {
        BigDecimal bigDecimal;
        if (this.f43753d.isEmpty()) {
            return "0.00";
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            bigDecimal = this.f43753d.get(g11);
        }
        if (bigDecimal != null) {
            return LegalCurrencyConfigUtil.C(m.a(str3).multiply(bigDecimal).toPlainString(), str2);
        }
        return "0.00";
    }

    public String d(String str) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str) && "usd".equals(str.toLowerCase(Locale.US))) {
            return "1";
        }
        PricingMethodBean pricingMethodBean = LegalCurrencyConfigUtil.f43759c.get(str);
        if (pricingMethodBean != null) {
            str2 = pricingMethodBean.getFiatName();
        } else {
            str2 = "usd_" + str;
        }
        if (this.f43751b.containsKey(str2)) {
            str3 = this.f43751b.get(str2);
        } else {
            String d11 = ConfigPreferences.d("user_config", "config_app_cny_usd_rate" + str2);
            if (!TextUtils.isEmpty(d11)) {
                this.f43751b.put(str2, d11);
            }
            str3 = d11;
        }
        if (TextUtils.isEmpty(str3)) {
            return "1";
        }
        return str3;
    }

    public Map<String, SymbolPrice> e(TradeType tradeType) {
        return this.f43752c;
    }

    public Map<String, SymbolPrice> f() {
        return this.f43752c;
    }

    public BigDecimal g(String str) {
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2 = BigDecimal.ONE;
        if (this.f43753d == null) {
            return bigDecimal2;
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            bigDecimal = this.f43753d.get(g11);
        }
        return bigDecimal != null ? bigDecimal : bigDecimal2;
    }

    public Observable<Map<String, SymbolPrice>> h() {
        return x8.a.a().getSymbolPrice().b().map(new jj.d(this));
    }

    public void i(Map<String, SymbolPrice> map) {
        this.f43752c.clear();
        this.f43752c.putAll(map);
        B();
    }

    public boolean j(String str) {
        boolean containsKey;
        if (this.f43753d == null) {
            return false;
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            containsKey = this.f43753d.containsKey(g11);
        }
        return containsKey;
    }

    public Observable<Map<String, SymbolPrice>> k(boolean z11) {
        Observable<Map<String, SymbolPrice>> h11 = h();
        return z11 ? Observable.concat(Observable.just(this.f43752c), h11).takeFirst(e.f55954b) : h11;
    }

    public String l(String str, String str2, int i11) {
        BigDecimal bigDecimal;
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            bigDecimal = this.f43753d.get(g11);
        }
        if (bigDecimal != null) {
            return LegalCurrencyConfigUtil.b(m.a(str2).multiply(bigDecimal).toPlainString(), i11);
        }
        return "0.00";
    }

    public String m(String str, String str2) {
        BigDecimal bigDecimal;
        if (this.f43753d.isEmpty()) {
            return "0.00";
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            bigDecimal = this.f43753d.get(g11);
        }
        if (bigDecimal == null || m.c0(bigDecimal)) {
            return "0.00";
        }
        return u(m.a(str2).divide(bigDecimal, 8, 4), 8, 2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0017, code lost:
        r3 = r2.f43750a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public rx.Observable<java.util.List<com.hbg.lib.network.mgt.core.bean.LegalRateBean>> n(boolean r3) {
        /*
            r2 = this;
            l8.b r0 = l8.a.a()
            d9.a r0 = r0.getCurrencyRateList()
            rx.Observable r0 = r0.b()
            jj.c r1 = new jj.c
            r1.<init>(r2)
            rx.Observable r0 = r0.map(r1)
            if (r3 == 0) goto L_0x0020
            java.util.List<com.hbg.lib.network.mgt.core.bean.LegalRateBean> r3 = r2.f43750a
            if (r3 == 0) goto L_0x0020
            rx.Observable r3 = rx.Observable.just(r3)
            return r3
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.currencyconfig.helper.LegalCurrencyConfigImpl.n(boolean):rx.Observable");
    }

    public String o(String str, String str2) {
        BigDecimal bigDecimal;
        if (this.f43753d == null) {
            return "0.00";
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            bigDecimal = this.f43753d.get(g11);
        }
        if (bigDecimal != null) {
            return LegalCurrencyConfigUtil.g(m.a(str2).multiply(bigDecimal).toPlainString());
        }
        return "0.00";
    }

    public String p(String str, String str2) {
        BigDecimal bigDecimal;
        if (this.f43753d == null) {
            return "0.00";
        }
        String g11 = StringUtils.g(str);
        synchronized (this.f43753d) {
            bigDecimal = this.f43753d.get(g11);
        }
        if (bigDecimal != null) {
            return LegalCurrencyConfigUtil.B(m.a(str2).multiply(bigDecimal).toPlainString());
        }
        return "0.00";
    }

    public final String u(BigDecimal bigDecimal, int i11, int i12) {
        BigDecimal stripTrailingZeros = bigDecimal.stripTrailingZeros();
        if (stripTrailingZeros.scale() >= i11) {
            return stripTrailingZeros.setScale(i11, 1).stripTrailingZeros().toPlainString();
        }
        if (stripTrailingZeros.scale() < i12) {
            return stripTrailingZeros.setScale(i12, 1).toPlainString();
        }
        return stripTrailingZeros.toPlainString();
    }

    public final void z(String str, String str2) {
        this.f43751b.put(str, str2);
        ConfigPreferences.m("user_config", "config_app_cny_usd_rate" + str, str2);
    }
}
