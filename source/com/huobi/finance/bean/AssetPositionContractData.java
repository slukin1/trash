package com.huobi.finance.bean;

import com.hbg.lib.data.symbol.TradeType;
import com.huobi.asset.AssetAccountType;
import com.huobi.contract.entity.ContractAccountInfo;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.finance.viewhandler.AssetPositionContractItemViewHandler;
import i6.m;

public class AssetPositionContractData extends BasePositionSortAccountItem<AssetPositionContractData> {
    public int A;

    /* renamed from: b  reason: collision with root package name */
    public AssetAccountType f45269b = AssetAccountType.FUTURE;

    /* renamed from: c  reason: collision with root package name */
    public TradeType f45270c;

    /* renamed from: d  reason: collision with root package name */
    public ContractAccountInfo f45271d;

    /* renamed from: e  reason: collision with root package name */
    public String f45272e;

    /* renamed from: f  reason: collision with root package name */
    public String f45273f;

    /* renamed from: g  reason: collision with root package name */
    public String f45274g;

    /* renamed from: h  reason: collision with root package name */
    public String f45275h;

    /* renamed from: i  reason: collision with root package name */
    public String f45276i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f45277j;

    /* renamed from: k  reason: collision with root package name */
    public String f45278k;

    /* renamed from: l  reason: collision with root package name */
    public String f45279l;

    /* renamed from: m  reason: collision with root package name */
    public String f45280m;

    /* renamed from: n  reason: collision with root package name */
    public String f45281n;

    /* renamed from: o  reason: collision with root package name */
    public String f45282o;

    /* renamed from: p  reason: collision with root package name */
    public String f45283p;

    /* renamed from: q  reason: collision with root package name */
    public String f45284q;

    /* renamed from: r  reason: collision with root package name */
    public String f45285r;

    /* renamed from: s  reason: collision with root package name */
    public String f45286s;

    /* renamed from: t  reason: collision with root package name */
    public String f45287t;

    /* renamed from: u  reason: collision with root package name */
    public String f45288u;

    /* renamed from: v  reason: collision with root package name */
    public String f45289v;

    /* renamed from: w  reason: collision with root package name */
    public String f45290w;

    /* renamed from: x  reason: collision with root package name */
    public String f45291x;

    /* renamed from: y  reason: collision with root package name */
    public String f45292y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f45293z;

    public String A() {
        return this.f45282o;
    }

    public String B() {
        return this.f45272e;
    }

    public String C() {
        return this.f45275h;
    }

    public String D() {
        return this.f45274g;
    }

    public TradeType E() {
        return this.f45270c;
    }

    public boolean F() {
        return this.f45293z;
    }

    public boolean G() {
        return this.f45277j;
    }

    public void H(String str) {
        this.f45283p = str;
    }

    public void I(String str) {
        this.f45284q = str;
    }

    public void J(String str) {
        this.f45289v = str;
    }

    public void K(boolean z11) {
        this.f45293z = z11;
    }

    public void L(String str) {
        this.f45276i = str;
    }

    public void M(String str) {
        this.f45292y = str;
    }

    public void N(boolean z11) {
        this.f45277j = z11;
    }

    public void O(String str) {
        this.f45287t = str;
    }

    public void P(String str) {
        this.f45273f = str;
    }

    public void Q(String str) {
        this.f45290w = str;
    }

    public void R(String str) {
        this.f45291x = str;
    }

    public void S(String str) {
        this.f45278k = str;
    }

    public void T(String str) {
        this.f45279l = str;
    }

    public void U(String str) {
        this.f45288u = str;
    }

    public void V(String str) {
        this.f45285r = str;
    }

    public void W(int i11) {
        this.A = i11;
    }

    public void X(String str) {
        this.f45286s = str;
    }

    public void Y(String str) {
        this.f45280m = str;
    }

    public void Z(String str) {
        this.f45282o = str;
    }

    public void a0(String str) {
        this.f45272e = str;
    }

    public void b0(String str) {
        this.f45275h = str;
    }

    public void c0(String str) {
        this.f45274g = str;
    }

    public void d0(TradeType tradeType) {
        this.f45270c = tradeType;
    }

    public boolean e(Object obj) {
        return obj instanceof AssetPositionContractData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AssetPositionContractData)) {
            return false;
        }
        AssetPositionContractData assetPositionContractData = (AssetPositionContractData) obj;
        if (!assetPositionContractData.e(this)) {
            return false;
        }
        AssetAccountType p11 = p();
        AssetAccountType p12 = assetPositionContractData.p();
        if (p11 != null ? !p11.equals(p12) : p12 != null) {
            return false;
        }
        TradeType E = E();
        TradeType E2 = assetPositionContractData.E();
        if (E != null ? !E.equals(E2) : E2 != null) {
            return false;
        }
        ContractAccountInfo g11 = g();
        ContractAccountInfo g12 = assetPositionContractData.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String B = B();
        String B2 = assetPositionContractData.B();
        if (B != null ? !B.equals(B2) : B2 != null) {
            return false;
        }
        String n11 = n();
        String n12 = assetPositionContractData.n();
        if (n11 != null ? !n11.equals(n12) : n12 != null) {
            return false;
        }
        String D = D();
        String D2 = assetPositionContractData.D();
        if (D != null ? !D.equals(D2) : D2 != null) {
            return false;
        }
        String C = C();
        String C2 = assetPositionContractData.C();
        if (C != null ? !C.equals(C2) : C2 != null) {
            return false;
        }
        String k11 = k();
        String k12 = assetPositionContractData.k();
        if (k11 != null ? !k11.equals(k12) : k12 != null) {
            return false;
        }
        if (G() != assetPositionContractData.G()) {
            return false;
        }
        String s11 = s();
        String s12 = assetPositionContractData.s();
        if (s11 != null ? !s11.equals(s12) : s12 != null) {
            return false;
        }
        String t11 = t();
        String t12 = assetPositionContractData.t();
        if (t11 != null ? !t11.equals(t12) : t12 != null) {
            return false;
        }
        String z11 = z();
        String z12 = assetPositionContractData.z();
        if (z11 != null ? !z11.equals(z12) : z12 != null) {
            return false;
        }
        String o11 = o();
        String o12 = assetPositionContractData.o();
        if (o11 != null ? !o11.equals(o12) : o12 != null) {
            return false;
        }
        String A2 = A();
        String A3 = assetPositionContractData.A();
        if (A2 != null ? !A2.equals(A3) : A3 != null) {
            return false;
        }
        String h11 = h();
        String h12 = assetPositionContractData.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        String i11 = i();
        String i12 = assetPositionContractData.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String w11 = w();
        String w12 = assetPositionContractData.w();
        if (w11 != null ? !w11.equals(w12) : w12 != null) {
            return false;
        }
        String y11 = y();
        String y12 = assetPositionContractData.y();
        if (y11 != null ? !y11.equals(y12) : y12 != null) {
            return false;
        }
        String m11 = m();
        String m12 = assetPositionContractData.m();
        if (m11 != null ? !m11.equals(m12) : m12 != null) {
            return false;
        }
        String u11 = u();
        String u12 = assetPositionContractData.u();
        if (u11 != null ? !u11.equals(u12) : u12 != null) {
            return false;
        }
        String j11 = j();
        String j12 = assetPositionContractData.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String q11 = q();
        String q12 = assetPositionContractData.q();
        if (q11 != null ? !q11.equals(q12) : q12 != null) {
            return false;
        }
        String r11 = r();
        String r12 = assetPositionContractData.r();
        if (r11 != null ? !r11.equals(r12) : r12 != null) {
            return false;
        }
        String l11 = l();
        String l12 = assetPositionContractData.l();
        if (l11 != null ? l11.equals(l12) : l12 == null) {
            return F() == assetPositionContractData.F() && x() == assetPositionContractData.x();
        }
        return false;
    }

    /* renamed from: f */
    public int a(int i11, AssetPositionContractData assetPositionContractData) {
        if (i11 == 1) {
            return m.a(v()).compareTo(m.a(assetPositionContractData.v()));
        }
        if (i11 == 2) {
            return m.a(this.f45285r).compareTo(m.a(assetPositionContractData.f45285r));
        }
        if (i11 != 3) {
            return 0;
        }
        return m.a(this.f45287t).compareTo(m.a(assetPositionContractData.f45287t));
    }

    public ContractAccountInfo g() {
        return this.f45271d;
    }

    public String getViewHandlerName() {
        return AssetPositionContractItemViewHandler.class.getName();
    }

    public String h() {
        return this.f45283p;
    }

    public int hashCode() {
        AssetAccountType p11 = p();
        int i11 = 43;
        int hashCode = p11 == null ? 43 : p11.hashCode();
        TradeType E = E();
        int hashCode2 = ((hashCode + 59) * 59) + (E == null ? 43 : E.hashCode());
        ContractAccountInfo g11 = g();
        int hashCode3 = (hashCode2 * 59) + (g11 == null ? 43 : g11.hashCode());
        String B = B();
        int hashCode4 = (hashCode3 * 59) + (B == null ? 43 : B.hashCode());
        String n11 = n();
        int hashCode5 = (hashCode4 * 59) + (n11 == null ? 43 : n11.hashCode());
        String D = D();
        int hashCode6 = (hashCode5 * 59) + (D == null ? 43 : D.hashCode());
        String C = C();
        int hashCode7 = (hashCode6 * 59) + (C == null ? 43 : C.hashCode());
        String k11 = k();
        int i12 = 79;
        int hashCode8 = (((hashCode7 * 59) + (k11 == null ? 43 : k11.hashCode())) * 59) + (G() ? 79 : 97);
        String s11 = s();
        int hashCode9 = (hashCode8 * 59) + (s11 == null ? 43 : s11.hashCode());
        String t11 = t();
        int hashCode10 = (hashCode9 * 59) + (t11 == null ? 43 : t11.hashCode());
        String z11 = z();
        int hashCode11 = (hashCode10 * 59) + (z11 == null ? 43 : z11.hashCode());
        String o11 = o();
        int hashCode12 = (hashCode11 * 59) + (o11 == null ? 43 : o11.hashCode());
        String A2 = A();
        int hashCode13 = (hashCode12 * 59) + (A2 == null ? 43 : A2.hashCode());
        String h11 = h();
        int hashCode14 = (hashCode13 * 59) + (h11 == null ? 43 : h11.hashCode());
        String i13 = i();
        int hashCode15 = (hashCode14 * 59) + (i13 == null ? 43 : i13.hashCode());
        String w11 = w();
        int hashCode16 = (hashCode15 * 59) + (w11 == null ? 43 : w11.hashCode());
        String y11 = y();
        int hashCode17 = (hashCode16 * 59) + (y11 == null ? 43 : y11.hashCode());
        String m11 = m();
        int hashCode18 = (hashCode17 * 59) + (m11 == null ? 43 : m11.hashCode());
        String u11 = u();
        int hashCode19 = (hashCode18 * 59) + (u11 == null ? 43 : u11.hashCode());
        String j11 = j();
        int hashCode20 = (hashCode19 * 59) + (j11 == null ? 43 : j11.hashCode());
        String q11 = q();
        int hashCode21 = (hashCode20 * 59) + (q11 == null ? 43 : q11.hashCode());
        String r11 = r();
        int hashCode22 = (hashCode21 * 59) + (r11 == null ? 43 : r11.hashCode());
        String l11 = l();
        int i14 = hashCode22 * 59;
        if (l11 != null) {
            i11 = l11.hashCode();
        }
        int i15 = (i14 + i11) * 59;
        if (!F()) {
            i12 = 97;
        }
        return ((i15 + i12) * 59) + x();
    }

    public String i() {
        return this.f45284q;
    }

    public String j() {
        return this.f45289v;
    }

    public String k() {
        return this.f45276i;
    }

    public String l() {
        return this.f45292y;
    }

    public String m() {
        return this.f45287t;
    }

    public String n() {
        return this.f45273f;
    }

    public String o() {
        return this.f45281n;
    }

    public AssetAccountType p() {
        return this.f45269b;
    }

    public String q() {
        return this.f45290w;
    }

    public String r() {
        return this.f45291x;
    }

    public String s() {
        return this.f45278k;
    }

    public String t() {
        return this.f45279l;
    }

    public String toString() {
        return "AssetPositionContractData(itemType=" + p() + ", tradeType=" + E() + ", accountInfo=" + g() + ", symbol=" + B() + ", direction=" + n() + ", tradePartition=" + D() + ", title=" + C() + ", contractCode=" + k() + ", isCross=" + G() + ", pair=" + s() + ", periodLabelText=" + t() + ", riskRate=" + z() + ", hold=" + o() + ", startPrice=" + A() + ", amount=" + h() + ", amountUnit=" + i() + ", profit=" + w() + ", profitRatio=" + y() + ", defaultProfitRatio=" + m() + ", positionMargin=" + u() + ", available=" + j() + ", lastPrice=" + q() + ", leverRate=" + r() + ", contractFace=" + l() + ", isCoinUnit=" + F() + ", profitColor=" + x() + ")";
    }

    public String u() {
        return this.f45288u;
    }

    public String v() {
        String str;
        if (!this.f45293z) {
            str = m.a(this.f45283p).multiply(m.a(this.f45292y)).toPlainString();
        } else {
            str = this.f45283p;
        }
        return LegalCurrencyConfigUtil.E(B(), str);
    }

    public String w() {
        return this.f45285r;
    }

    public int x() {
        return this.A;
    }

    public String y() {
        return this.f45286s;
    }

    public String z() {
        return this.f45280m;
    }
}
