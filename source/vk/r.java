package vk;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.viewhandler.HtExchangeViewHandler;
import java.util.Map;

public class r implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public BaseAssetInfo f48004b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, SymbolPrice> f48005c;

    /* renamed from: d  reason: collision with root package name */
    public String f48006d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48007e;

    /* renamed from: f  reason: collision with root package name */
    public a f48008f;

    public interface a {
        void v(r rVar, boolean z11);
    }

    public r(BaseAssetInfo baseAssetInfo) {
        this.f48004b = baseAssetInfo;
    }

    public boolean a(Object obj) {
        return obj instanceof r;
    }

    public BaseAssetInfo c() {
        return this.f48004b;
    }

    public a d() {
        return this.f48008f;
    }

    public String e() {
        return this.f48006d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        if (!rVar.a(this)) {
            return false;
        }
        BaseAssetInfo c11 = c();
        BaseAssetInfo c12 = rVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        Map<String, SymbolPrice> f11 = f();
        Map<String, SymbolPrice> f12 = rVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = rVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (g() != rVar.g()) {
            return false;
        }
        a d11 = d();
        a d12 = rVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public Map<String, SymbolPrice> f() {
        return this.f48005c;
    }

    public boolean g() {
        return this.f48007e;
    }

    public String getViewHandlerName() {
        return HtExchangeViewHandler.class.getName();
    }

    public void h(a aVar) {
        this.f48008f = aVar;
    }

    public int hashCode() {
        BaseAssetInfo c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        Map<String, SymbolPrice> f11 = f();
        int hashCode2 = ((hashCode + 59) * 59) + (f11 == null ? 43 : f11.hashCode());
        String e11 = e();
        int hashCode3 = (((hashCode2 * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + (g() ? 79 : 97);
        a d11 = d();
        int i12 = hashCode3 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public void i(boolean z11) {
        this.f48007e = z11;
    }

    public void j(String str) {
        this.f48006d = str;
    }

    public String toString() {
        return "HtExchangeItem(mBaseAssetInfo=" + c() + ", mSymbolPriceMap=" + f() + ", mEstimateHt=" + e() + ", mChecked=" + g() + ", mCallback=" + d() + ")";
    }
}
