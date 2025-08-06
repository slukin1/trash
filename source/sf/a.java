package sf;

import com.hbg.lib.network.option.core.bean.OptionOrderInfo;
import com.hbg.module.option.viewhandler.OptionCurrentOrderItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public OptionOrderInfo f37236b;

    /* renamed from: c  reason: collision with root package name */
    public String f37237c;

    /* renamed from: d  reason: collision with root package name */
    public C0510a f37238d;

    /* renamed from: sf.a$a  reason: collision with other inner class name */
    public interface C0510a {
        void a(a aVar);
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0510a c() {
        return this.f37238d;
    }

    public OptionOrderInfo d() {
        return this.f37236b;
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
        OptionOrderInfo d11 = d();
        OptionOrderInfo d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = aVar.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        C0510a c11 = c();
        C0510a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getQuoteCurrency() {
        return this.f37237c;
    }

    public String getViewHandlerName() {
        return OptionCurrentOrderItemHandler.class.getName();
    }

    public int hashCode() {
        OptionOrderInfo d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        String quoteCurrency = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        C0510a c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OptionCurrentOrderItem(orderInfo=" + d() + ", quoteCurrency=" + getQuoteCurrency() + ", callback=" + c() + ")";
    }
}
