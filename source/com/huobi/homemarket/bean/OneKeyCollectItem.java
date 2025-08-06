package com.huobi.homemarket.bean;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.core.bean.OneKeySelectItem;
import com.hbg.lib.network.pro.core.bean.DefiChainInfo;
import com.hbg.module.market.R$color;
import com.huobi.homemarket.handler.OneKeyCollectViewHandler;
import i6.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import u6.g;

public class OneKeyCollectItem implements s9.a {

    /* renamed from: k  reason: collision with root package name */
    public static final String[] f72669k;

    /* renamed from: l  reason: collision with root package name */
    public static final HashSet<String> f72670l;

    /* renamed from: b  reason: collision with root package name */
    public String f72671b;

    /* renamed from: c  reason: collision with root package name */
    public String f72672c;

    /* renamed from: d  reason: collision with root package name */
    public String f72673d;

    /* renamed from: e  reason: collision with root package name */
    public String f72674e;

    /* renamed from: f  reason: collision with root package name */
    public String f72675f;

    /* renamed from: g  reason: collision with root package name */
    public String f72676g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f72677h = true;

    /* renamed from: i  reason: collision with root package name */
    public int f72678i;

    /* renamed from: j  reason: collision with root package name */
    public c f72679j;

    public class a extends EasySubscriber<List<OneKeySelectItem>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f72680b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f72681c;

        public a(c cVar, b bVar) {
            this.f72680b = cVar;
            this.f72681c = bVar;
        }

        public void onNext(List<OneKeySelectItem> list) {
            double d11;
            double d12;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (OneKeySelectItem next : list) {
                    if (next != null) {
                        OneKeyCollectItem oneKeyCollectItem = new OneKeyCollectItem();
                        try {
                            d11 = Double.parseDouble(next.open);
                        } catch (Throwable unused) {
                            d11 = 0.0d;
                        }
                        oneKeyCollectItem.l(next.baseCurrency);
                        oneKeyCollectItem.t(next.symbol);
                        oneKeyCollectItem.p(next.quoteCurrency);
                        oneKeyCollectItem.s(true);
                        oneKeyCollectItem.n(this.f72680b);
                        oneKeyCollectItem.o(next.price);
                        try {
                            d12 = Double.parseDouble(next.upDown);
                        } catch (Throwable unused2) {
                            d12 = 0.0d;
                        }
                        String i11 = m.i((d12 / d11) * 100.0d, PrecisionUtil.v(next.baseCurrency));
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(Double.compare(d12, 0.0d) > 0 ? "+" : "");
                        sb2.append(i11);
                        sb2.append("%");
                        oneKeyCollectItem.r(sb2.toString());
                        oneKeyCollectItem.q(R$color.kColorThreeLevelText);
                        arrayList.add(oneKeyCollectItem);
                    }
                }
                this.f72681c.a(arrayList);
            }
        }
    }

    public interface b {
        void a(List<OneKeyCollectItem> list);
    }

    public interface c {
        void a(boolean z11);
    }

    static {
        String[] strArr = {"BTC", DefiChainInfo.CHAIN_ETH, "HT", "BCH", "LTC", "BSV"};
        f72669k = strArr;
        f72670l = new HashSet<>(Arrays.asList(strArr));
    }

    public static void e(b bVar, c cVar) {
        v7.b.a().getFavoriteRecommend().b().compose(RxJavaHelper.t((g) null)).subscribe(new a(cVar, bVar));
    }

    public boolean a(Object obj) {
        return obj instanceof OneKeyCollectItem;
    }

    public String c() {
        return this.f72671b;
    }

    public String d() {
        return this.f72676g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OneKeyCollectItem)) {
            return false;
        }
        OneKeyCollectItem oneKeyCollectItem = (OneKeyCollectItem) obj;
        if (!oneKeyCollectItem.a(this)) {
            return false;
        }
        String c11 = c();
        String c12 = oneKeyCollectItem.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = oneKeyCollectItem.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        String j11 = j();
        String j12 = oneKeyCollectItem.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String i11 = i();
        String i12 = oneKeyCollectItem.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String g11 = g();
        String g12 = oneKeyCollectItem.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = oneKeyCollectItem.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        if (k() != oneKeyCollectItem.k() || h() != oneKeyCollectItem.h()) {
            return false;
        }
        c f11 = f();
        c f12 = oneKeyCollectItem.f();
        return f11 != null ? f11.equals(f12) : f12 == null;
    }

    public c f() {
        return this.f72679j;
    }

    public String g() {
        return this.f72675f;
    }

    public String getQuoteCurrency() {
        return this.f72672c;
    }

    public String getViewHandlerName() {
        return OneKeyCollectViewHandler.class.getName();
    }

    public int h() {
        return this.f72678i;
    }

    public int hashCode() {
        String c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        String quoteCurrency = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        String j11 = j();
        int hashCode3 = (hashCode2 * 59) + (j11 == null ? 43 : j11.hashCode());
        String i12 = i();
        int hashCode4 = (hashCode3 * 59) + (i12 == null ? 43 : i12.hashCode());
        String g11 = g();
        int hashCode5 = (hashCode4 * 59) + (g11 == null ? 43 : g11.hashCode());
        String d11 = d();
        int hashCode6 = (((((hashCode5 * 59) + (d11 == null ? 43 : d11.hashCode())) * 59) + (k() ? 79 : 97)) * 59) + h();
        c f11 = f();
        int i13 = hashCode6 * 59;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return i13 + i11;
    }

    public String i() {
        return this.f72674e;
    }

    public String j() {
        return this.f72673d;
    }

    public boolean k() {
        return this.f72677h;
    }

    public void l(String str) {
        this.f72671b = str;
    }

    public void m(String str) {
        this.f72676g = str;
    }

    public void n(c cVar) {
        this.f72679j = cVar;
    }

    public void o(String str) {
        this.f72675f = str;
    }

    public void p(String str) {
        this.f72672c = str;
    }

    public void q(int i11) {
        this.f72678i = i11;
    }

    public void r(String str) {
        this.f72674e = str;
    }

    public void s(boolean z11) {
        this.f72677h = z11;
        c cVar = this.f72679j;
        if (cVar != null) {
            cVar.a(z11);
        }
    }

    public void t(String str) {
        this.f72673d = str;
    }

    public String toString() {
        return "OneKeyCollectItem(currency=" + c() + ", quoteCurrency=" + getQuoteCurrency() + ", symbol=" + j() + ", riseRate=" + i() + ", price=" + g() + ", estimate=" + d() + ", isSelected=" + k() + ", rateTextColor=" + h() + ", onSelectChangedListener=" + f() + ")";
    }
}
