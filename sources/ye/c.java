package ye;

import com.hbg.lib.network.linear.swap.core.bean.LinearSwapTrackOrderInfo;
import com.hbg.module.linear.swap.viewhandler.LinearSwapCurrentTrackOrderHandler;

public class c implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public transient String f29398b;

    /* renamed from: c  reason: collision with root package name */
    public a f29399c;

    /* renamed from: d  reason: collision with root package name */
    public LinearSwapTrackOrderInfo f29400d;

    /* renamed from: e  reason: collision with root package name */
    public String f29401e;

    /* renamed from: f  reason: collision with root package name */
    public String f29402f;

    /* renamed from: g  reason: collision with root package name */
    public int f29403g;

    /* renamed from: h  reason: collision with root package name */
    public String f29404h;

    public interface a {
        void a(c cVar);
    }

    public c(String str, a aVar, LinearSwapTrackOrderInfo linearSwapTrackOrderInfo, String str2, String str3, int i11, String str4) {
        this.f29398b = str;
        this.f29399c = aVar;
        this.f29400d = linearSwapTrackOrderInfo;
        this.f29401e = str2;
        this.f29402f = str3;
        this.f29403g = i11;
        this.f29404h = str4;
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public a c() {
        return this.f29399c;
    }

    public String d() {
        return this.f29398b;
    }

    public String e() {
        return this.f29402f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!cVar.a(this)) {
            return false;
        }
        a c11 = c();
        a c12 = cVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        LinearSwapTrackOrderInfo g11 = g();
        LinearSwapTrackOrderInfo g12 = cVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        String quoteCurrency = getQuoteCurrency();
        String quoteCurrency2 = cVar.getQuoteCurrency();
        if (quoteCurrency != null ? !quoteCurrency.equals(quoteCurrency2) : quoteCurrency2 != null) {
            return false;
        }
        String e11 = e();
        String e12 = cVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (h() != cVar.h()) {
            return false;
        }
        String f11 = f();
        String f12 = cVar.f();
        return f11 != null ? f11.equals(f12) : f12 == null;
    }

    public String f() {
        return this.f29404h;
    }

    public LinearSwapTrackOrderInfo g() {
        return this.f29400d;
    }

    public String getQuoteCurrency() {
        return this.f29401e;
    }

    public String getViewHandlerName() {
        return LinearSwapCurrentTrackOrderHandler.class.getName();
    }

    public int h() {
        return this.f29403g;
    }

    public int hashCode() {
        a c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        LinearSwapTrackOrderInfo g11 = g();
        int hashCode2 = ((hashCode + 59) * 59) + (g11 == null ? 43 : g11.hashCode());
        String quoteCurrency = getQuoteCurrency();
        int hashCode3 = (hashCode2 * 59) + (quoteCurrency == null ? 43 : quoteCurrency.hashCode());
        String e11 = e();
        int hashCode4 = (((hashCode3 * 59) + (e11 == null ? 43 : e11.hashCode())) * 59) + h();
        String f11 = f();
        int i12 = hashCode4 * 59;
        if (f11 != null) {
            i11 = f11.hashCode();
        }
        return i12 + i11;
    }

    public String i() {
        return this.f29400d.getOffset();
    }

    public boolean j() {
        return "buy".equals(this.f29400d.getDirection());
    }

    public boolean k() {
        return "settlement".equals(this.f29400d.getOrderSource());
    }

    public String toString() {
        return "LinearSwapCurrentTrackOrderItem(contractFace=" + d() + ", callback=" + c() + ", info=" + g() + ", quoteCurrency=" + getQuoteCurrency() + ", contractShortType=" + e() + ", marginMode=" + h() + ", contractType=" + f() + ")";
    }
}
