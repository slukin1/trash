package vk;

import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.huobi.finance.bean.BaseAssetInfo;
import com.huobi.finance.viewhandler.UsdtExchangeViewHandler;
import java.util.Map;

public class y implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public BaseAssetInfo f48018b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, SymbolPrice> f48019c;

    /* renamed from: d  reason: collision with root package name */
    public String f48020d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f48021e;

    /* renamed from: f  reason: collision with root package name */
    public a f48022f;

    public interface a {
        void i(y yVar, boolean z11);
    }

    public y(BaseAssetInfo baseAssetInfo) {
        this.f48018b = baseAssetInfo;
    }

    public boolean a(Object obj) {
        return obj instanceof y;
    }

    public BaseAssetInfo c() {
        return this.f48018b;
    }

    public a d() {
        return this.f48022f;
    }

    public String e() {
        return this.f48020d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (!yVar.a(this)) {
            return false;
        }
        BaseAssetInfo c11 = c();
        BaseAssetInfo c12 = yVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        Map<String, SymbolPrice> f11 = f();
        Map<String, SymbolPrice> f12 = yVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = yVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (g() != yVar.g()) {
            return false;
        }
        a d11 = d();
        a d12 = yVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public Map<String, SymbolPrice> f() {
        return this.f48019c;
    }

    public boolean g() {
        return this.f48021e;
    }

    public String getViewHandlerName() {
        return UsdtExchangeViewHandler.class.getName();
    }

    public void h(a aVar) {
        this.f48022f = aVar;
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
        this.f48021e = z11;
    }

    public void j(String str) {
        this.f48020d = str;
    }

    public String toString() {
        return "UsdtExchangeItem(mBaseAssetInfo=" + c() + ", mSymbolPriceMap=" + f() + ", mEstimateUsdt=" + e() + ", mChecked=" + g() + ", mCallback=" + d() + ")";
    }
}
