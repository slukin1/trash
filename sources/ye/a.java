package ye;

import android.content.Context;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapCurrentOrderInfo;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentOrderItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public LinearSwapCurrentOrderInfo f29386b;

    /* renamed from: c  reason: collision with root package name */
    public String f29387c;

    /* renamed from: d  reason: collision with root package name */
    public String f29388d;

    /* renamed from: e  reason: collision with root package name */
    public C0260a f29389e;

    /* renamed from: f  reason: collision with root package name */
    public int f29390f;

    /* renamed from: g  reason: collision with root package name */
    public String f29391g;

    /* renamed from: ye.a$a  reason: collision with other inner class name */
    public interface C0260a {
        void a(a aVar, Context context);

        void b(a aVar);
    }

    public a(LinearSwapCurrentOrderInfo linearSwapCurrentOrderInfo, String str, String str2, C0260a aVar, int i11, String str3) {
        this.f29386b = linearSwapCurrentOrderInfo;
        this.f29387c = str;
        this.f29388d = str2;
        this.f29389e = aVar;
        this.f29390f = i11;
        this.f29391g = str3;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0260a c() {
        return this.f29389e;
    }

    public String d() {
        return this.f29388d;
    }

    public String e() {
        return this.f29391g;
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
        LinearSwapCurrentOrderInfo g11 = g();
        LinearSwapCurrentOrderInfo g12 = aVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = aVar.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        String d11 = d();
        String d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        C0260a c11 = c();
        C0260a c12 = aVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (f() != aVar.f()) {
            return false;
        }
        String e11 = e();
        String e12 = aVar.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public int f() {
        return this.f29390f;
    }

    public LinearSwapCurrentOrderInfo g() {
        return this.f29386b;
    }

    public String getQuoteCurrency() {
        return this.f29387c;
    }

    public String getViewHandlerName() {
        return LinearSwapCurrentOrderItemHandler.class.getName();
    }

    public int hashCode() {
        LinearSwapCurrentOrderInfo g11 = g();
        int i11 = 43;
        int hashCode = g11 == null ? 43 : g11.hashCode();
        String quoteCurrency = getQuoteCurrency();
        int hashCode2 = ((hashCode + 59) * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        String d11 = d();
        int hashCode3 = (hashCode2 * 59) + (d11 == null ? 43 : d11.hashCode());
        C0260a c11 = c();
        int hashCode4 = (((hashCode3 * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + f();
        String e11 = e();
        int i12 = hashCode4 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "LinearSwapCurrentOrderItem(orderInfo=" + g() + ", quoteCurrency=" + getQuoteCurrency() + ", contractShortType=" + d() + ", callback=" + c() + ", marginMode=" + f() + ", contractType=" + e() + ")";
    }
}
