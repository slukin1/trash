package pg;

import com.hbg.lib.network.pro.core.bean.SymbolBean;
import com.huobi.account.handler.PersonalMarketHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public SymbolBean f47700b;

    /* renamed from: c  reason: collision with root package name */
    public String f47701c;

    /* renamed from: d  reason: collision with root package name */
    public String f47702d;

    /* renamed from: e  reason: collision with root package name */
    public String f47703e;

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public String c() {
        return this.f47702d;
    }

    public String d() {
        return this.f47703e;
    }

    public String e() {
        return this.f47701c;
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
        SymbolBean f11 = f();
        SymbolBean f12 = bVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = bVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = bVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String d11 = d();
        String d12 = bVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public SymbolBean f() {
        return this.f47700b;
    }

    public String getViewHandlerName() {
        return PersonalMarketHandler.class.getName();
    }

    public int hashCode() {
        SymbolBean f11 = f();
        int i11 = 43;
        int hashCode = f11 == null ? 43 : f11.hashCode();
        String e11 = e();
        int hashCode2 = ((hashCode + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
        String c11 = c();
        int hashCode3 = (hashCode2 * 59) + (c11 == null ? 43 : c11.hashCode());
        String d11 = d();
        int i12 = hashCode3 * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "PersonalMarketBean(symbolBean=" + f() + ", price=" + e() + ", change=" + c() + ", legalCurrency=" + d() + ")";
    }
}
