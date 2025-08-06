package com.huobi.finance.bean;

import android.content.Context;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.hbg.grid.bean.GridStrategy;
import com.hbg.module.exchange.R$string;
import com.huobi.asset.AssetAccountType;
import com.huobi.finance.viewhandler.AssetPositionQuantItemViewHandler;
import i6.m;
import java.util.Locale;

public class AssetPositionQuantData extends BasePositionSortAccountItem<AssetPositionQuantData> {

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f45322b = AssetAccountType.QUANT;

    /* renamed from: c  reason: collision with root package name */
    public String f45323c;

    /* renamed from: d  reason: collision with root package name */
    public String f45324d;

    /* renamed from: e  reason: collision with root package name */
    public String f45325e;

    /* renamed from: f  reason: collision with root package name */
    public String f45326f;

    /* renamed from: g  reason: collision with root package name */
    public String f45327g;

    /* renamed from: h  reason: collision with root package name */
    public String f45328h;

    /* renamed from: i  reason: collision with root package name */
    public String f45329i;

    /* renamed from: j  reason: collision with root package name */
    public String f45330j;

    /* renamed from: k  reason: collision with root package name */
    public String f45331k;

    /* renamed from: l  reason: collision with root package name */
    public long f45332l;

    /* renamed from: m  reason: collision with root package name */
    public int f45333m;

    /* renamed from: n  reason: collision with root package name */
    public String f45334n;

    /* renamed from: o  reason: collision with root package name */
    public String f45335o;

    /* renamed from: p  reason: collision with root package name */
    public String f45336p;

    public static AssetPositionQuantData g(GridStrategy gridStrategy, Context context) {
        AssetPositionQuantData assetPositionQuantData = new AssetPositionQuantData();
        assetPositionQuantData.D(String.valueOf(gridStrategy.getId()));
        assetPositionQuantData.F(gridStrategy.getSymbol());
        assetPositionQuantData.G(gridStrategy.getBaseCurrency() + "/" + gridStrategy.getQuoteCurrency());
        assetPositionQuantData.E(String.format(Locale.ENGLISH, context.getString(R$string.n_grid_strategy_name), new Object[]{gridStrategy.getName()}));
        assetPositionQuantData.v(m.u(gridStrategy.getInvestAmount(), PrecisionUtil.C(gridStrategy.getSymbol())));
        assetPositionQuantData.z(gridStrategy.getTotalProfit());
        assetPositionQuantData.B(gridStrategy.getQuoteCurrency());
        assetPositionQuantData.w(gridStrategy.getTotalProfitRate());
        assetPositionQuantData.A(m.Q(gridStrategy.getTotalProfitRate(), 2, 1));
        assetPositionQuantData.C(gridStrategy.getRunTime());
        assetPositionQuantData.I(gridStrategy.getTradeNum());
        assetPositionQuantData.H(gridStrategy.getTotalProfitRate());
        assetPositionQuantData.y(gridStrategy.getMinPrice());
        assetPositionQuantData.x(gridStrategy.getMaxPrice());
        return assetPositionQuantData;
    }

    public void A(String str) {
        this.f45329i = str;
    }

    public void B(String str) {
        this.f45331k = str;
    }

    public void C(long j11) {
        this.f45332l = j11;
    }

    public void D(String str) {
        this.f45323c = str;
    }

    public void E(String str) {
        this.f45324d = str;
    }

    public void F(String str) {
        this.f45325e = str;
    }

    public void G(String str) {
        this.f45326f = str;
    }

    public void H(String str) {
        this.f45334n = str;
    }

    public void I(int i11) {
        this.f45333m = i11;
    }

    public boolean e(Object obj) {
        return obj instanceof AssetPositionQuantData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetPositionQuantData)) {
            return false;
        }
        AssetPositionQuantData assetPositionQuantData = (AssetPositionQuantData) obj;
        if (!assetPositionQuantData.e(this)) {
            return false;
        }
        AssetAccountType j11 = j();
        AssetAccountType j12 = assetPositionQuantData.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String p11 = p();
        String p12 = assetPositionQuantData.p();
        if (p11 != null ? !p11.equals(p12) : p12 != null) {
            return false;
        }
        String q11 = q();
        String q12 = assetPositionQuantData.q();
        if (q11 != null ? !q11.equals(q12) : q12 != null) {
            return false;
        }
        String r11 = r();
        String r12 = assetPositionQuantData.r();
        if (r11 != null ? !r11.equals(r12) : r12 != null) {
            return false;
        }
        String s11 = s();
        String s12 = assetPositionQuantData.s();
        if (s11 != null ? !s11.equals(s12) : s12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = assetPositionQuantData.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String m11 = m();
        String m12 = assetPositionQuantData.m();
        if (m11 != null ? !m11.equals(m12) : m12 != null) {
            return false;
        }
        String n11 = n();
        String n12 = assetPositionQuantData.n();
        if (n11 != null ? !n11.equals(n12) : n12 != null) {
            return false;
        }
        String i11 = i();
        String i12 = assetPositionQuantData.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = assetPositionQuantData.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        if (o() != assetPositionQuantData.o() || u() != assetPositionQuantData.u()) {
            return false;
        }
        String t11 = t();
        String t12 = assetPositionQuantData.t();
        if (t11 != null ? !t11.equals(t12) : t12 != null) {
            return false;
        }
        String l11 = l();
        String l12 = assetPositionQuantData.l();
        if (l11 != null ? !l11.equals(l12) : l12 != null) {
            return false;
        }
        String k11 = k();
        String k12 = assetPositionQuantData.k();
        return k11 != null ? k11.equals(k12) : k12 == null;
    }

    /* renamed from: f */
    public int a(int i11, AssetPositionQuantData assetPositionQuantData) {
        if (i11 == 2) {
            return m.a(m()).compareTo(m.a(assetPositionQuantData.m()));
        }
        if (i11 != 3) {
            return 0;
        }
        return m.a(i()).compareTo(m.a(assetPositionQuantData.i()));
    }

    public String getQuoteCurrency() {
        return this.f45331k;
    }

    public String getViewHandlerName() {
        return AssetPositionQuantItemViewHandler.class.getName();
    }

    public String h() {
        return this.f45327g;
    }

    public int hashCode() {
        AssetAccountType j11 = j();
        int i11 = 43;
        int hashCode = j11 == null ? 43 : j11.hashCode();
        String p11 = p();
        int hashCode2 = ((hashCode + 59) * 59) + (p11 == null ? 43 : p11.hashCode());
        String q11 = q();
        int hashCode3 = (hashCode2 * 59) + (q11 == null ? 43 : q11.hashCode());
        String r11 = r();
        int hashCode4 = (hashCode3 * 59) + (r11 == null ? 43 : r11.hashCode());
        String s11 = s();
        int hashCode5 = (hashCode4 * 59) + (s11 == null ? 43 : s11.hashCode());
        String h11 = h();
        int hashCode6 = (hashCode5 * 59) + (h11 == null ? 43 : h11.hashCode());
        String m11 = m();
        int hashCode7 = (hashCode6 * 59) + (m11 == null ? 43 : m11.hashCode());
        String n11 = n();
        int hashCode8 = (hashCode7 * 59) + (n11 == null ? 43 : n11.hashCode());
        String i12 = i();
        int hashCode9 = (hashCode8 * 59) + (i12 == null ? 43 : i12.hashCode());
        String quoteCurrency = getQuoteCurrency();
        int hashCode10 = (hashCode9 * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        long o11 = o();
        int u11 = (((hashCode10 * 59) + ((int) (o11 ^ (o11 >>> 32)))) * 59) + u();
        String t11 = t();
        int hashCode11 = (u11 * 59) + (t11 == null ? 43 : t11.hashCode());
        String l11 = l();
        int hashCode12 = (hashCode11 * 59) + (l11 == null ? 43 : l11.hashCode());
        String k11 = k();
        int i13 = hashCode12 * 59;
        if (k11 != null) {
            i11 = k11.hashCode();
        }
        return i13 + i11;
    }

    public String i() {
        return this.f45330j;
    }

    public AssetAccountType j() {
        return this.f45322b;
    }

    public String k() {
        return this.f45336p;
    }

    public String l() {
        return this.f45335o;
    }

    public String m() {
        return this.f45328h;
    }

    public String n() {
        return this.f45329i;
    }

    public long o() {
        return this.f45332l;
    }

    public String p() {
        return this.f45323c;
    }

    public String q() {
        return this.f45324d;
    }

    public String r() {
        return this.f45325e;
    }

    public String s() {
        return this.f45326f;
    }

    public String t() {
        return this.f45334n;
    }

    public String toString() {
        return "AssetPositionQuantData(itemType=" + j() + ", strategyId=" + p() + ", strategyName=" + q() + ", symbol=" + r() + ", symbolTitle=" + s() + ", cost=" + h() + ", profit=" + m() + ", profitRatio=" + n() + ", defaultProfitRatio=" + i() + ", quoteCurrency=" + getQuoteCurrency() + ", runTime=" + o() + ", tradeNum=" + u() + ", totalProfitRate=" + t() + ", minPrice=" + l() + ", maxPrice=" + k() + ")";
    }

    public int u() {
        return this.f45333m;
    }

    public void v(String str) {
        this.f45327g = str;
    }

    public void w(String str) {
        this.f45330j = str;
    }

    public void x(String str) {
        this.f45336p = str;
    }

    public void y(String str) {
        this.f45335o = str;
    }

    public void z(String str) {
        this.f45328h = str;
    }
}
