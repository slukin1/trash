package bo;

import com.hbg.lib.network.otc.core.bean.MarketPrice;
import com.huobi.main.trade.viewhandler.OtcPriceItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public MarketPrice.Price f76999b;

    /* renamed from: c  reason: collision with root package name */
    public String f77000c;

    /* renamed from: d  reason: collision with root package name */
    public C0827a f77001d;

    /* renamed from: bo.a$a  reason: collision with other inner class name */
    public interface C0827a {
        boolean b(a aVar);

        void d(a aVar);
    }

    public a(MarketPrice.Price price, C0827a aVar) {
        h(price);
        f(aVar);
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0827a c() {
        return this.f77001d;
    }

    public String d() {
        return this.f77000c;
    }

    public MarketPrice.Price e() {
        return this.f76999b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        MarketPrice.Price e11 = e();
        MarketPrice.Price e12 = aVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        C0827a c11 = c();
        C0827a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(C0827a aVar) {
        this.f77001d = aVar;
    }

    public void g(String str) {
        this.f77000c = str;
    }

    public String getViewHandlerName() {
        return OtcPriceItemHandler.class.getName();
    }

    public void h(MarketPrice.Price price) {
        this.f76999b = price;
    }

    public int hashCode() {
        MarketPrice.Price e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        String d11 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        C0827a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OtcPriceItem(price=" + e() + ", legalSymbol=" + d() + ", callback=" + c() + ")";
    }
}
