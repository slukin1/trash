package ml;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.data.symbol.TradeType;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.module.market.MarketModuleConfig;
import com.hbg.module.market.R$color;
import i6.m;

public class d implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f76295b = false;

    /* renamed from: c  reason: collision with root package name */
    public String f76296c = "";

    /* renamed from: d  reason: collision with root package name */
    public a f76297d;

    /* renamed from: e  reason: collision with root package name */
    public SymbolPrice f76298e;

    /* renamed from: f  reason: collision with root package name */
    public String f76299f;

    /* renamed from: g  reason: collision with root package name */
    public String f76300g;

    /* renamed from: h  reason: collision with root package name */
    public int f76301h;

    /* renamed from: i  reason: collision with root package name */
    public String f76302i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f76303j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f76304k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f76305l;

    /* renamed from: m  reason: collision with root package name */
    public String f76306m;

    /* renamed from: n  reason: collision with root package name */
    public TradeType f76307n;

    /* renamed from: o  reason: collision with root package name */
    public int f76308o;

    /* renamed from: p  reason: collision with root package name */
    public int f76309p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f76310q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f76311r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f76312s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f76313t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f76314u;

    /* renamed from: v  reason: collision with root package name */
    public int f76315v;

    /* renamed from: w  reason: collision with root package name */
    public String f76316w;

    /* renamed from: x  reason: collision with root package name */
    public String f76317x;

    /* renamed from: y  reason: collision with root package name */
    public long f76318y;

    public interface a {
        void c(d dVar);
    }

    public d(int i11) {
        this.f76308o = i11;
    }

    public boolean A() {
        return this.f76310q;
    }

    public boolean B() {
        return this.f76303j;
    }

    public boolean C() {
        return this.f76313t;
    }

    public void D(a aVar) {
        this.f76297d = aVar;
    }

    public void E(boolean z11) {
        this.f76304k = z11;
    }

    public void F(String str) {
        this.f76317x = str;
    }

    public void G(boolean z11) {
        this.f76312s = z11;
    }

    public void H(boolean z11) {
        this.f76295b = z11;
    }

    public void I(String str) {
        this.f76316w = str;
    }

    public void J(String str) {
        this.f76299f = str;
    }

    public void K(boolean z11) {
        this.f76314u = z11;
    }

    public void L(boolean z11) {
        this.f76311r = z11;
    }

    public void M(boolean z11) {
        this.f76305l = z11;
    }

    public void N(boolean z11) {
        this.f76310q = z11;
    }

    public void O(String str) {
        this.f76306m = str;
    }

    public void P(String str) {
        this.f76296c = str;
    }

    public void Q(SymbolPrice symbolPrice) {
        this.f76298e = symbolPrice;
    }

    public void R(long j11) {
        this.f76318y = j11;
    }

    public void S(boolean z11) {
        this.f76303j = z11;
    }

    public void T(TradeType tradeType) {
        this.f76307n = tradeType;
    }

    public void U(boolean z11) {
        this.f76313t = z11;
    }

    public boolean a(Object obj) {
        return obj instanceof d;
    }

    public int b() {
        return this.f76309p;
    }

    public a c() {
        return this.f76297d;
    }

    public String d() {
        SymbolPrice symbolPrice = this.f76298e;
        if (symbolPrice == null || symbolPrice.getClose() == null) {
            return null;
        }
        return String.valueOf(this.f76298e.getClose());
    }

    public String e() {
        return this.f76302i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!dVar.a(this) || w() != dVar.w()) {
            return false;
        }
        String p11 = p();
        String p12 = dVar.p();
        if (p11 != null ? !p11.equals(p12) : p12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = dVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        SymbolPrice symbolPrice = getSymbolPrice();
        SymbolPrice symbolPrice2 = dVar.getSymbolPrice();
        if (symbolPrice != null ? !symbolPrice.equals(symbolPrice2) : symbolPrice2 != null) {
            return false;
        }
        String j11 = j();
        String j12 = dVar.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String t11 = t();
        String t12 = dVar.t();
        if (t11 != null ? !t11.equals(t12) : t12 != null) {
            return false;
        }
        if (l() != dVar.l()) {
            return false;
        }
        String e11 = e();
        String e12 = dVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (B() != dVar.B() || u() != dVar.u() || z() != dVar.z()) {
            return false;
        }
        String n11 = n();
        String n12 = dVar.n();
        if (n11 != null ? !n11.equals(n12) : n12 != null) {
            return false;
        }
        TradeType s11 = s();
        TradeType s12 = dVar.s();
        if (s11 != null ? !s11.equals(s12) : s12 != null) {
            return false;
        }
        if (h() != dVar.h() || b() != dVar.b() || A() != dVar.A() || y() != dVar.y() || v() != dVar.v() || C() != dVar.C() || x() != dVar.x() || f() != dVar.f()) {
            return false;
        }
        String i11 = i();
        String i12 = dVar.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String g11 = g();
        String g12 = dVar.g();
        if (g11 != null ? g11.equals(g12) : g12 == null) {
            return r() == dVar.r();
        }
        return false;
    }

    public int f() {
        return this.f76315v;
    }

    public String g() {
        return this.f76317x;
    }

    public SymbolPrice getSymbolPrice() {
        return this.f76298e;
    }

    public String getViewHandlerName() {
        if (this.f76295b) {
            return MarketModuleConfig.a().r();
        }
        return MarketModuleConfig.a().l0();
    }

    public int h() {
        return this.f76308o;
    }

    public int hashCode() {
        int i11 = 79;
        int i12 = w() ? 79 : 97;
        String p11 = p();
        int i13 = 43;
        int hashCode = ((i12 + 59) * 59) + (p11 == null ? 43 : p11.hashCode());
        a c11 = c();
        int hashCode2 = (hashCode * 59) + (c11 == null ? 43 : c11.hashCode());
        SymbolPrice symbolPrice = getSymbolPrice();
        int hashCode3 = (hashCode2 * 59) + (symbolPrice == null ? 43 : symbolPrice.hashCode());
        String j11 = j();
        int hashCode4 = (hashCode3 * 59) + (j11 == null ? 43 : j11.hashCode());
        String t11 = t();
        int hashCode5 = (((hashCode4 * 59) + (t11 == null ? 43 : t11.hashCode())) * 59) + l();
        String e11 = e();
        int hashCode6 = (((((((hashCode5 * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + (B() ? 79 : 97)) * 59) + (u() ? 79 : 97)) * 59) + (z() ? 79 : 97);
        String n11 = n();
        int hashCode7 = (hashCode6 * 59) + (n11 == null ? 43 : n11.hashCode());
        TradeType s11 = s();
        int hashCode8 = ((((((((((((((hashCode7 * 59) + (s11 == null ? 43 : s11.hashCode())) * 59) + h()) * 59) + b()) * 59) + (A() ? 79 : 97)) * 59) + (y() ? 79 : 97)) * 59) + (v() ? 79 : 97)) * 59) + (C() ? 79 : 97)) * 59;
        if (!x()) {
            i11 = 97;
        }
        int f11 = ((hashCode8 + i11) * 59) + f();
        String i14 = i();
        int hashCode9 = (f11 * 59) + (i14 == null ? 43 : i14.hashCode());
        String g11 = g();
        int i15 = hashCode9 * 59;
        if (g11 != null) {
            i13 = g11.hashCode();
        }
        long r11 = r();
        return ((i15 + i13) * 59) + ((int) (r11 ^ (r11 >>> 32)));
    }

    public String i() {
        return this.f76316w;
    }

    public String j() {
        return this.f76299f;
    }

    public String k() {
        if (m() == null) {
            return "--";
        }
        return m.S(m().doubleValue(), PrecisionUtil.v(""));
    }

    public int l() {
        return this.f76301h;
    }

    public Double m() {
        SymbolPrice symbolPrice = this.f76298e;
        if (symbolPrice == null) {
            return null;
        }
        return symbolPrice.getRise();
    }

    public String n() {
        return this.f76306m;
    }

    public String o() {
        SymbolPrice symbolPrice = this.f76298e;
        if (symbolPrice != null) {
            return symbolPrice.getSymbol();
        }
        return null;
    }

    public String p() {
        return this.f76296c;
    }

    public int q(Context context) {
        int i11 = R$color.baseColorSecondaryText;
        int color = ContextCompat.getColor(context, i11);
        SymbolPrice symbolPrice = this.f76298e;
        if (symbolPrice == null || symbolPrice.getOpen() == null || this.f76298e.getClose().doubleValue() == 0.0d) {
            return color;
        }
        double doubleValue = this.f76298e.getClose().doubleValue() - this.f76298e.getOpen().doubleValue();
        if (Double.compare(doubleValue, 0.0d) > 0) {
            return ContextCompat.getColor(context, w.h());
        }
        if (Double.compare(doubleValue, 0.0d) < 0) {
            return ContextCompat.getColor(context, w.d());
        }
        return ContextCompat.getColor(context, i11);
    }

    public long r() {
        return this.f76318y;
    }

    public TradeType s() {
        return this.f76307n;
    }

    public String t() {
        return this.f76300g;
    }

    public String toString() {
        return "SymbolPriceItem(mIsCompare=" + w() + ", symbolId=" + p() + ", callback=" + c() + ", symbolPrice=" + getSymbolPrice() + ", name=" + j() + ", unitName=" + t() + ", priceFluctuate=" + l() + ", currency=" + e() + ", isTradeSelected=" + B() + ", isCollected=" + u() + ", isSearchHistory=" + z() + ", state=" + n() + ", tradeType=" + s() + ", exchangeType=" + h() + ", collectionWeight=" + b() + ", isStTag=" + A() + ", isPrime=" + y() + ", isHadaxTag=" + v() + ", isZerofeeTag=" + C() + ", nightMode=" + x() + ", defaulWeight=" + f() + ", leverageRatio=" + i() + ", direction=" + g() + ", tradeOpenAt=" + r() + ")";
    }

    public boolean u() {
        return this.f76304k;
    }

    public boolean v() {
        return this.f76312s;
    }

    public boolean w() {
        return this.f76295b;
    }

    public boolean x() {
        return this.f76314u;
    }

    public boolean y() {
        return this.f76311r;
    }

    public boolean z() {
        return this.f76305l;
    }
}
