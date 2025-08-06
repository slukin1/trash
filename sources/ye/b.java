package ye;

import android.content.Context;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTimeOrderInfo;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentTimeOrderItemHandler;

public class b implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public LinearSwapTimeOrderInfo f29392b;

    /* renamed from: c  reason: collision with root package name */
    public String f29393c;

    /* renamed from: d  reason: collision with root package name */
    public String f29394d;

    /* renamed from: e  reason: collision with root package name */
    public a f29395e;

    /* renamed from: f  reason: collision with root package name */
    public int f29396f;

    /* renamed from: g  reason: collision with root package name */
    public String f29397g;

    public interface a {
        void a(Context context, b bVar);

        void b(b bVar);
    }

    public b(LinearSwapTimeOrderInfo linearSwapTimeOrderInfo, String str, String str2, a aVar, int i11, String str3) {
        this.f29392b = linearSwapTimeOrderInfo;
        this.f29393c = str;
        this.f29394d = str2;
        this.f29395e = aVar;
        this.f29396f = i11;
        this.f29397g = str3;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public a c() {
        return this.f29395e;
    }

    public String d() {
        return this.f29394d;
    }

    public String e() {
        return this.f29397g;
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
        LinearSwapTimeOrderInfo g11 = g();
        LinearSwapTimeOrderInfo g12 = bVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = bVar.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        String d11 = d();
        String d12 = bVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = bVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (f() != bVar.f()) {
            return false;
        }
        String e11 = e();
        String e12 = bVar.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public int f() {
        return this.f29396f;
    }

    public LinearSwapTimeOrderInfo g() {
        return this.f29392b;
    }

    public String getQuoteCurrency() {
        return this.f29393c;
    }

    public String getViewHandlerName() {
        return LinearSwapCurrentTimeOrderItemHandler.class.getName();
    }

    public int hashCode() {
        LinearSwapTimeOrderInfo g11 = g();
        int i11 = 43;
        int hashCode = g11 == null ? 43 : g11.hashCode();
        String quoteCurrency = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        String d11 = d();
        int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
        a c11 = c();
        int hashCode4 = (((hashCode3 * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + f();
        String e11 = e();
        int i12 = hashCode4 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "LinearSwapCurrentTimeOrderItem(orderInfo=" + g() + ", quoteCurrency=" + getQuoteCurrency() + ", contractShortType=" + d() + ", callback=" + c() + ", marginMode=" + f() + ", contractType=" + e() + ")";
    }
}
