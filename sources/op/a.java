package op;

import android.text.TextUtils;
import com.hbg.bean.Merchant;
import com.huobi.otc.bean.OtcAdvertLabelBean;
import com.huobi.otc.enums.OtcReceiveOrderAdsType;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import up.g;

public final class a {

    /* renamed from: u  reason: collision with root package name */
    public static volatile HashMap<Integer, a> f84520u = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public String f84521a;

    /* renamed from: b  reason: collision with root package name */
    public int f84522b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f84523c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84524d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f84525e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f84526f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f84527g;

    /* renamed from: h  reason: collision with root package name */
    public String f84528h;

    /* renamed from: i  reason: collision with root package name */
    public String f84529i;

    /* renamed from: j  reason: collision with root package name */
    public String f84530j;

    /* renamed from: k  reason: collision with root package name */
    public String f84531k;

    /* renamed from: l  reason: collision with root package name */
    public String f84532l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f84533m = "USD";

    /* renamed from: n  reason: collision with root package name */
    public String f84534n = OtcReceiveOrderAdsType.ALL_ADS.getValue();

    /* renamed from: o  reason: collision with root package name */
    public List<C0880a> f84535o = Collections.synchronizedList(new ArrayList());

    /* renamed from: p  reason: collision with root package name */
    public ip.a f84536p;

    /* renamed from: q  reason: collision with root package name */
    public ip.a f84537q;

    /* renamed from: r  reason: collision with root package name */
    public int f84538r;

    /* renamed from: s  reason: collision with root package name */
    public HashMap<String, List<OtcAdvertLabelBean>> f84539s = new HashMap<>();

    /* renamed from: t  reason: collision with root package name */
    public HashMap<String, List<OtcAdvertLabelBean>> f84540t = new HashMap<>();

    /* renamed from: op.a$a  reason: collision with other inner class name */
    public interface C0880a {
        void O9();

        void j4(int i11, String str, boolean z11);
    }

    public static a r(int i11) {
        a aVar = f84520u.get(Integer.valueOf(i11));
        if (aVar != null) {
            return aVar;
        }
        synchronized (a.class) {
            if (f84520u.get(Integer.valueOf(i11)) == null) {
                a aVar2 = new a();
                aVar2.f84538r = i11;
                f84520u.put(Integer.valueOf(i11), aVar2);
            }
        }
        return f84520u.get(Integer.valueOf(i11));
    }

    public void A() {
        this.f84522b = 0;
        this.f84521a = "";
        this.f84534n = OtcReceiveOrderAdsType.ALL_ADS.getValue();
        this.f84528h = Merchant.NORMAL.value;
        this.f84529i = "0";
        this.f84530j = "0";
        this.f84533m = g.c(this.f84538r == 2 ? "otc_brand_select_trade_currency_quote_asset" : "otc_select_trade_currency_quote_asset");
        this.f84524d = false;
        this.f84526f = false;
        this.f84525e = false;
        this.f84523c = false;
        this.f84527g = false;
        this.f84532l = "";
        this.f84531k = "";
    }

    public void B(C0880a aVar) {
        if (!this.f84535o.contains(aVar)) {
            this.f84535o.add(aVar);
        }
    }

    public void C(String str) {
        this.f84529i = str;
    }

    public void D(String str) {
        this.f84521a = str;
    }

    public void E(String str) {
        this.f84531k = str;
    }

    public void F(String str) {
        this.f84533m = str;
    }

    public void G(boolean z11) {
        this.f84527g = z11;
    }

    public void H(String str) {
        this.f84532l = str;
    }

    public void I(int i11) {
        this.f84522b = i11;
    }

    public void J(String str) {
        this.f84528h = str;
    }

    public void K(boolean z11) {
        this.f84523c = z11;
    }

    public void L(boolean z11) {
        this.f84525e = z11;
    }

    public void M(String str) {
        this.f84530j = str;
    }

    public void N(boolean z11) {
        this.f84524d = z11;
    }

    public void O(boolean z11) {
        this.f84526f = z11;
    }

    public void P(C0880a aVar) {
        this.f84535o.remove(aVar);
    }

    public String a() {
        return this.f84529i;
    }

    public String b() {
        return this.f84521a;
    }

    public String c() {
        return this.f84521a;
    }

    public String d() {
        return this.f84531k;
    }

    public HashMap<String, List<OtcAdvertLabelBean>> e() {
        return this.f84539s;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        String c11 = c();
        String c12 = aVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (i() != aVar.i() || u() != aVar.u() || w() != aVar.w() || v() != aVar.v() || x() != aVar.x() || t() != aVar.t()) {
            return false;
        }
        String j11 = j();
        String j12 = aVar.j();
        if (j11 != null ? !j11.equals(j12) : j12 != null) {
            return false;
        }
        String a11 = a();
        String a12 = aVar.a();
        if (a11 != null ? !a11.equals(a12) : a12 != null) {
            return false;
        }
        String n11 = n();
        String n12 = aVar.n();
        if (n11 != null ? !n11.equals(n12) : n12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String g11 = g();
        String g12 = aVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = aVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String o11 = o();
        String o12 = aVar.o();
        if (o11 != null ? !o11.equals(o12) : o12 != null) {
            return false;
        }
        List<C0880a> m11 = m();
        List<C0880a> m12 = aVar.m();
        if (m11 != null ? !m11.equals(m12) : m12 != null) {
            return false;
        }
        ip.a l11 = l();
        ip.a l12 = aVar.l();
        if (l11 != null ? !l11.equals(l12) : l12 != null) {
            return false;
        }
        ip.a k11 = k();
        ip.a k12 = aVar.k();
        if (k11 != null ? !k11.equals(k12) : k12 != null) {
            return false;
        }
        if (h() != aVar.h()) {
            return false;
        }
        HashMap<String, List<OtcAdvertLabelBean>> e11 = e();
        HashMap<String, List<OtcAdvertLabelBean>> e12 = aVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        HashMap<String, List<OtcAdvertLabelBean>> p11 = p();
        HashMap<String, List<OtcAdvertLabelBean>> p12 = aVar.p();
        return p11 != null ? p11.equals(p12) : p12 == null;
    }

    public String f() {
        return this.f84533m;
    }

    public String g() {
        return this.f84532l;
    }

    public int h() {
        return this.f84538r;
    }

    public int hashCode() {
        String c11 = c();
        int i11 = 43;
        int i12 = 79;
        int hashCode = ((((((((((((c11 == null ? 43 : c11.hashCode()) + 59) * 59) + i()) * 59) + (u() ? 79 : 97)) * 59) + (w() ? 79 : 97)) * 59) + (v() ? 79 : 97)) * 59) + (x() ? 79 : 97)) * 59;
        if (!t()) {
            i12 = 97;
        }
        String j11 = j();
        int hashCode2 = ((hashCode + i12) * 59) + (j11 == null ? 43 : j11.hashCode());
        String a11 = a();
        int hashCode3 = (hashCode2 * 59) + (a11 == null ? 43 : a11.hashCode());
        String n11 = n();
        int hashCode4 = (hashCode3 * 59) + (n11 == null ? 43 : n11.hashCode());
        String d11 = d();
        int hashCode5 = (hashCode4 * 59) + (d11 == null ? 43 : d11.hashCode());
        String g11 = g();
        int hashCode6 = (hashCode5 * 59) + (g11 == null ? 43 : g11.hashCode());
        String f11 = f();
        int hashCode7 = (hashCode6 * 59) + (f11 == null ? 43 : f11.hashCode());
        String o11 = o();
        int hashCode8 = (hashCode7 * 59) + (o11 == null ? 43 : o11.hashCode());
        List<C0880a> m11 = m();
        int hashCode9 = (hashCode8 * 59) + (m11 == null ? 43 : m11.hashCode());
        ip.a l11 = l();
        int hashCode10 = (hashCode9 * 59) + (l11 == null ? 43 : l11.hashCode());
        ip.a k11 = k();
        int hashCode11 = (((hashCode10 * 59) + (k11 == null ? 43 : k11.hashCode())) * 59) + h();
        HashMap<String, List<OtcAdvertLabelBean>> e11 = e();
        int hashCode12 = (hashCode11 * 59) + (e11 == null ? 43 : e11.hashCode());
        HashMap<String, List<OtcAdvertLabelBean>> p11 = p();
        int i13 = hashCode12 * 59;
        if (p11 != null) {
            i11 = p11.hashCode();
        }
        return i13 + i11;
    }

    public int i() {
        return this.f84522b;
    }

    public String j() {
        return this.f84528h;
    }

    public ip.a k() {
        return this.f84537q;
    }

    public ip.a l() {
        return this.f84536p;
    }

    public List<C0880a> m() {
        return this.f84535o;
    }

    public String n() {
        return this.f84530j;
    }

    public String o() {
        return this.f84534n;
    }

    public HashMap<String, List<OtcAdvertLabelBean>> p() {
        return this.f84540t;
    }

    public String q(List<String> list) {
        String str;
        String str2 = "";
        if (list.isEmpty()) {
            return str2;
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (i11 == 0) {
                str = list.get(i11);
            } else {
                str = str2 + Constants.ACCEPT_TIME_SEPARATOR_SP + list.get(i11);
            }
            str2 = str;
        }
        return str2;
    }

    public boolean s() {
        return TextUtils.equals(this.f84521a, "1");
    }

    public boolean t() {
        return this.f84527g;
    }

    public String toString() {
        return "OtcAdsListModel(blueShieldValue=" + c() + ", makerCompleteRate=" + i() + ", isMerchantOpen=" + u() + ", isThumbsUp=" + w() + ", onlyTradable=" + v() + ", isTraded=" + x() + ", isFollow=" + t() + ", merchant=" + j() + ", amount=" + a() + ", payMethod=" + n() + ", brandSiteTagIdsString=" + d() + ", labelId=" + g() + ", currency=" + f() + ", receiveOrder=" + o() + ", observers=" + m() + ", methodSeaView=" + l() + ", merchantLevelSeaView=" + k() + ", listType=" + h() + ", buyAdvertLabels=" + e() + ", sellAdvertLabels=" + p() + ")";
    }

    public boolean u() {
        return this.f84523c;
    }

    public boolean v() {
        return this.f84525e;
    }

    public boolean w() {
        return this.f84524d;
    }

    public boolean x() {
        return this.f84526f;
    }

    public void y() {
        for (int i11 = 0; i11 < this.f84535o.size(); i11++) {
            C0880a aVar = this.f84535o.get(i11);
            if (aVar != null) {
                aVar.O9();
            }
        }
    }

    public void z(boolean z11) {
        for (int i11 = 0; i11 < this.f84535o.size(); i11++) {
            C0880a aVar = this.f84535o.get(i11);
            if (aVar != null) {
                aVar.j4(this.f84538r, f(), z11);
            }
        }
    }
}
