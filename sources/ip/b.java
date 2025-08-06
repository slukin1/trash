package ip;

import com.hbg.lib.network.otc.core.bean.QuickTradeConfigBean;
import com.huobi.otc.enums.OtcCurrencySelectType;
import com.huobi.otc.handler.OtcCurrencySelectHandler;
import com.huobi.otc.handler.OtcNewCurrencySelectHandler;

public class b implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public OtcCurrencySelectType f84285b;

    /* renamed from: c  reason: collision with root package name */
    public QuickTradeConfigBean.Asset f84286c;

    /* renamed from: d  reason: collision with root package name */
    public QuickTradeConfigBean.Asset f84287d;

    /* renamed from: e  reason: collision with root package name */
    public String f84288e;

    /* renamed from: f  reason: collision with root package name */
    public String f84289f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f84290g;

    /* renamed from: h  reason: collision with root package name */
    public C0868b f84291h;

    /* renamed from: i  reason: collision with root package name */
    public a f84292i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f84293j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f84294k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f84295l = true;

    public interface a {
        void Ra(QuickTradeConfigBean.Asset asset);
    }

    /* renamed from: ip.b$b  reason: collision with other inner class name */
    public interface C0868b {
        void a(b bVar);
    }

    public b(OtcCurrencySelectType otcCurrencySelectType, QuickTradeConfigBean.Asset asset, String str, a aVar, boolean z11) {
        this.f84293j = z11;
        this.f84285b = otcCurrencySelectType;
        this.f84287d = asset;
        this.f84288e = str;
        this.f84292i = aVar;
        this.f84295l = false;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public C0868b c() {
        return this.f84291h;
    }

    public QuickTradeConfigBean.Asset d() {
        return this.f84287d;
    }

    public a e() {
        return this.f84292i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this)) {
            return false;
        }
        OtcCurrencySelectType i11 = i();
        OtcCurrencySelectType i12 = bVar.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        QuickTradeConfigBean.Asset f11 = f();
        QuickTradeConfigBean.Asset f12 = bVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        QuickTradeConfigBean.Asset d11 = d();
        QuickTradeConfigBean.Asset d12 = bVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String g11 = g();
        String g12 = bVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String h11 = h();
        String h12 = bVar.h();
        if (h11 != null ? !h11.equals(h12) : h12 != null) {
            return false;
        }
        if (l() != bVar.l()) {
            return false;
        }
        C0868b c11 = c();
        C0868b c12 = bVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        a e11 = e();
        a e12 = bVar.e();
        if (e11 != null ? e11.equals(e12) : e12 == null) {
            return k() == bVar.k() && j() == bVar.j() && m() == bVar.m();
        }
        return false;
    }

    public QuickTradeConfigBean.Asset f() {
        return this.f84286c;
    }

    public String g() {
        return this.f84288e;
    }

    public String getViewHandlerName() {
        if (this.f84293j) {
            return OtcNewCurrencySelectHandler.class.getName();
        }
        return OtcCurrencySelectHandler.class.getName();
    }

    public String h() {
        return this.f84289f;
    }

    public int hashCode() {
        OtcCurrencySelectType i11 = i();
        int i12 = 43;
        int hashCode = i11 == null ? 43 : i11.hashCode();
        QuickTradeConfigBean.Asset f11 = f();
        int hashCode2 = ((hashCode + 59) * 59) + (f11 == null ? 43 : f11.hashCode());
        QuickTradeConfigBean.Asset d11 = d();
        int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
        String g11 = g();
        int hashCode4 = (hashCode3 * 59) + (g11 == null ? 43 : g11.hashCode());
        String h11 = h();
        int i13 = 79;
        int hashCode5 = (((hashCode4 * 59) + (h11 == null ? 43 : h11.hashCode())) * 59) + (l() ? 79 : 97);
        C0868b c11 = c();
        int hashCode6 = (hashCode5 * 59) + (c11 == null ? 43 : c11.hashCode());
        a e11 = e();
        int i14 = hashCode6 * 59;
        if (e11 != null) {
            i12 = e11.hashCode();
        }
        int i15 = (((((i14 + i12) * 59) + (k() ? 79 : 97)) * 59) + (j() ? 79 : 97)) * 59;
        if (!m()) {
            i13 = 97;
        }
        return i15 + i13;
    }

    public OtcCurrencySelectType i() {
        return this.f84285b;
    }

    public boolean j() {
        return this.f84294k;
    }

    public boolean k() {
        return this.f84293j;
    }

    public boolean l() {
        return this.f84290g;
    }

    public boolean m() {
        return this.f84295l;
    }

    public void n(boolean z11) {
        this.f84294k = z11;
    }

    public String toString() {
        return "OtcCurrencySelectItem(type=" + i() + ", data=" + f() + ", coinInfo=" + d() + ", groupTitle=" + g() + ", parentTitle=" + h() + ", isNotShowLine=" + l() + ", callback=" + c() + ", coinInfoCallback=" + e() + ", isNewType=" + k() + ", isCurrentSelected=" + j() + ", isSelectCurrency=" + m() + ")";
    }
}
