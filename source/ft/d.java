package ft;

import com.huobi.trade.prime.viewhandler.PrimeListOrderItemHandler;
import s9.a;

public class d implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f84145b;

    /* renamed from: c  reason: collision with root package name */
    public String f84146c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84147d;

    public d(String str, String str2, boolean z11) {
        h(str);
        g(str2);
        f(z11);
    }

    public boolean a(Object obj) {
        return obj instanceof d;
    }

    public String c() {
        return this.f84146c;
    }

    public String d() {
        return this.f84145b;
    }

    public boolean e() {
        return this.f84147d;
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
        String d11 = d();
        String d12 = dVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = dVar.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return e() == dVar.e();
        }
        return false;
    }

    public void f(boolean z11) {
        this.f84147d = z11;
    }

    public void g(String str) {
        this.f84146c = str;
    }

    public String getViewHandlerName() {
        return PrimeListOrderItemHandler.class.getName();
    }

    public void h(String str) {
        this.f84145b = str;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        String c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return ((i12 + i11) * 59) + (e() ? 79 : 97);
    }

    public String toString() {
        return "PrimeListOrderItem(title=" + d() + ", status=" + c() + ", showImg=" + e() + ")";
    }
}
