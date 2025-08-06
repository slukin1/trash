package ye;

import android.content.Context;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTriggerOrderInfo;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentTriggerOrderItemHandler;

public class d implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public LinearSwapTriggerOrderInfo f29405b;

    /* renamed from: c  reason: collision with root package name */
    public String f29406c;

    /* renamed from: d  reason: collision with root package name */
    public String f29407d;

    /* renamed from: e  reason: collision with root package name */
    public a f29408e;

    /* renamed from: f  reason: collision with root package name */
    public int f29409f;

    /* renamed from: g  reason: collision with root package name */
    public String f29410g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29411h;

    public interface a {
        void a(d dVar, Context context);

        void b(d dVar);
    }

    public d(LinearSwapTriggerOrderInfo linearSwapTriggerOrderInfo, String str, String str2, a aVar, int i11, String str3, boolean z11) {
        this.f29405b = linearSwapTriggerOrderInfo;
        this.f29406c = str;
        this.f29407d = str2;
        this.f29408e = aVar;
        this.f29409f = i11;
        this.f29410g = str3;
        this.f29411h = z11;
    }

    public boolean a(Object obj) {
        return obj instanceof d;
    }

    public a c() {
        return this.f29408e;
    }

    public String d() {
        return this.f29407d;
    }

    public String e() {
        return this.f29410g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (!dVar.a(this)) {
            return false;
        }
        LinearSwapTriggerOrderInfo g11 = g();
        LinearSwapTriggerOrderInfo g12 = dVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = dVar.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        String d11 = d();
        String d12 = dVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = dVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (f() != dVar.f()) {
            return false;
        }
        String e11 = e();
        String e12 = dVar.e();
        if (e11 != null ? e11.equals(e12) : e12 == null) {
            return h() == dVar.h();
        }
        return false;
    }

    public int f() {
        return this.f29409f;
    }

    public LinearSwapTriggerOrderInfo g() {
        return this.f29405b;
    }

    public String getQuoteCurrency() {
        return this.f29406c;
    }

    public String getViewHandlerName() {
        return LinearSwapCurrentTriggerOrderItemHandler.class.getName();
    }

    public boolean h() {
        return this.f29411h;
    }

    public int hashCode() {
        LinearSwapTriggerOrderInfo g11 = g();
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
        return ((i12 + i11) * 59) + (h() ? 79 : 97);
    }

    public String toString() {
        return "LinearSwapCurrentTriggerOrderItem(orderInfo=" + g() + ", quoteCurrency=" + getQuoteCurrency() + ", contractShortType=" + d() + ", callback=" + c() + ", marginMode=" + f() + ", contractType=" + e() + ", isTriggerOrder=" + h() + ")";
    }
}
