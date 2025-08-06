package com.huobi.finance.bean;

import android.text.TextUtils;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.MaxRateMiningProject;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.finance.viewhandler.CurrencyDetailTradeItemViewHandler;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.List;
import s9.a;

public class CurrencyIntroBean {

    /* renamed from: a  reason: collision with root package name */
    public String f45343a;

    /* renamed from: b  reason: collision with root package name */
    public MaxRateMiningProject f45344b;

    /* renamed from: c  reason: collision with root package name */
    public List<TradeItem> f45345c;

    public static class TradeItem implements a {

        /* renamed from: b  reason: collision with root package name */
        public View.OnClickListener f45346b;

        /* renamed from: c  reason: collision with root package name */
        public String f45347c;

        /* renamed from: d  reason: collision with root package name */
        public String f45348d;

        /* renamed from: e  reason: collision with root package name */
        public String f45349e;

        /* renamed from: f  reason: collision with root package name */
        public String f45350f;

        /* renamed from: g  reason: collision with root package name */
        public String f45351g;

        /* renamed from: h  reason: collision with root package name */
        public SymbolPrice f45352h;

        /* renamed from: i  reason: collision with root package name */
        public int f45353i = -1;

        /* renamed from: j  reason: collision with root package name */
        public String f45354j;

        public boolean a(Object obj) {
            return obj instanceof TradeItem;
        }

        public String c() {
            return this.f45347c;
        }

        public String d() {
            return this.f45354j;
        }

        public View.OnClickListener e() {
            return this.f45346b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof TradeItem)) {
                return false;
            }
            TradeItem tradeItem = (TradeItem) obj;
            if (!tradeItem.a(this)) {
                return false;
            }
            View.OnClickListener e11 = e();
            View.OnClickListener e12 = tradeItem.e();
            if (e11 != null ? !e11.equals(e12) : e12 != null) {
                return false;
            }
            String c11 = c();
            String c12 = tradeItem.c();
            if (c11 != null ? !c11.equals(c12) : c12 != null) {
                return false;
            }
            String i11 = i();
            String i12 = tradeItem.i();
            if (i11 != null ? !i11.equals(i12) : i12 != null) {
                return false;
            }
            String g11 = g();
            String g12 = tradeItem.g();
            if (g11 != null ? !g11.equals(g12) : g12 != null) {
                return false;
            }
            String h11 = h();
            String h12 = tradeItem.h();
            if (h11 != null ? !h11.equals(h12) : h12 != null) {
                return false;
            }
            String quoteCurrency = getQuoteCurrency();
            String quoteCurrency2 = tradeItem.getQuoteCurrency();
            if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
                return false;
            }
            SymbolPrice symbolPrice = getSymbolPrice();
            SymbolPrice symbolPrice2 = tradeItem.getSymbolPrice();
            if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
                return false;
            }
            if (f() != tradeItem.f()) {
                return false;
            }
            String d11 = d();
            String d12 = tradeItem.d();
            return d11 != null ? d11.equals(d12) : d12 == null;
        }

        public int f() {
            return this.f45353i;
        }

        public String g() {
            return this.f45349e;
        }

        public String getQuoteCurrency() {
            return this.f45351g;
        }

        public SymbolPrice getSymbolPrice() {
            return this.f45352h;
        }

        public String getViewHandlerName() {
            return CurrencyDetailTradeItemViewHandler.class.getName();
        }

        public String h() {
            return this.f45350f;
        }

        public int hashCode() {
            View.OnClickListener e11 = e();
            int i11 = 43;
            int hashCode = e11 == null ? 43 : e11.hashCode();
            String c11 = c();
            int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
            String i12 = i();
            int hashCode3 = (hashCode2 * 59) + (i12 == null ? 43 : i12.hashCode());
            String g11 = g();
            int hashCode4 = (hashCode3 * 59) + (g11 == null ? 43 : g11.hashCode());
            String h11 = h();
            int hashCode5 = (hashCode4 * 59) + (h11 == null ? 43 : h11.hashCode());
            String quoteCurrency = getQuoteCurrency();
            int hashCode6 = (hashCode5 * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
            SymbolPrice symbolPrice = getSymbolPrice();
            int hashCode7 = (((hashCode6 * 59) + (symbolPrice == null ? 43 : symbolPrice.hashCode())) * 59) + f();
            String d11 = d();
            int i13 = hashCode7 * 59;
            if (d11 != null) {
                i11 = d11.hashCode();
            }
            return i13 + i11;
        }

        public String i() {
            return this.f45348d;
        }

        public void j(String str) {
            this.f45347c = str;
        }

        public void k(String str) {
            this.f45354j = str;
        }

        public void l(View.OnClickListener onClickListener) {
            this.f45346b = onClickListener;
        }

        public void m(int i11) {
            this.f45353i = i11;
        }

        public void n(String str) {
            this.f45351g = str;
        }

        public void o(String str) {
            this.f45349e = str;
        }

        public void p(String str) {
            this.f45350f = str;
        }

        public void q(SymbolPrice symbolPrice) {
            this.f45352h = symbolPrice;
        }

        public void r(String str) {
            this.f45348d = str;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("TradeItem{label='");
            sb2.append(this.f45347c);
            sb2.append('\'');
            sb2.append(", symbol='");
            sb2.append(this.f45350f);
            sb2.append('\'');
            sb2.append(", quoteCurrency='");
            sb2.append(this.f45351g);
            sb2.append('\'');
            sb2.append(", symbolPrice=");
            SymbolPrice symbolPrice = this.f45352h;
            sb2.append(symbolPrice == null ? OptionsBridge.NULL_VALUE : symbolPrice.getClose());
            sb2.append(", pricePrecision=");
            sb2.append(this.f45353i);
            sb2.append(", loanMultiple='");
            sb2.append(this.f45354j);
            sb2.append('\'');
            sb2.append('}');
            return sb2.toString();
        }
    }

    public boolean a(Object obj) {
        return obj instanceof CurrencyIntroBean;
    }

    public String b() {
        return this.f45343a;
    }

    public MaxRateMiningProject c() {
        return this.f45344b;
    }

    public List<TradeItem> d() {
        return this.f45345c;
    }

    public boolean e() {
        MaxRateMiningProject maxRateMiningProject = this.f45344b;
        return maxRateMiningProject != null && !TextUtils.isEmpty(maxRateMiningProject.getCurrency()) && !TextUtils.isEmpty(this.f45344b.getProjectId());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyIntroBean)) {
            return false;
        }
        CurrencyIntroBean currencyIntroBean = (CurrencyIntroBean) obj;
        if (!currencyIntroBean.a(this)) {
            return false;
        }
        String b11 = b();
        String b12 = currencyIntroBean.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        MaxRateMiningProject c11 = c();
        MaxRateMiningProject c12 = currencyIntroBean.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        List<TradeItem> d11 = d();
        List<TradeItem> d12 = currencyIntroBean.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public boolean f() {
        List<TradeItem> list = this.f45345c;
        return (list == null || list.size() == 0) ? false : true;
    }

    public void g(String str) {
        this.f45343a = str;
    }

    public void h(MaxRateMiningProject maxRateMiningProject) {
        this.f45344b = maxRateMiningProject;
    }

    public int hashCode() {
        String b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        MaxRateMiningProject c11 = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode());
        List<TradeItem> d11 = d();
        int i12 = hashCode2 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public void i(List<TradeItem> list) {
        this.f45345c = list;
    }

    public String toString() {
        return "CurrencyIntroBean(currency=" + b() + ", earnProject=" + c() + ", tradeItemList=" + d() + ")";
    }
}
