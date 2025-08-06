package ft;

import com.huobi.trade.prime.viewhandler.PrimeListItemHandler;
import s9.a;

public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f84142b = true;

    /* renamed from: c  reason: collision with root package name */
    public String f84143c;

    /* renamed from: d  reason: collision with root package name */
    public String f84144d;

    public c(String str, String str2, boolean z11) {
        h(str);
        f(str2);
        g(z11);
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public String c() {
        return this.f84144d;
    }

    public String d() {
        return this.f84143c;
    }

    public boolean e() {
        return this.f84142b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!cVar.a(this) || e() != cVar.e()) {
            return false;
        }
        String d11 = d();
        String d12 = cVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = cVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(String str) {
        this.f84144d = str;
    }

    public void g(boolean z11) {
        this.f84142b = z11;
    }

    public String getViewHandlerName() {
        return PrimeListItemHandler.class.getName();
    }

    public void h(String str) {
        this.f84143c = str;
    }

    public int hashCode() {
        int i11 = e() ? 79 : 97;
        String d11 = d();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        String c11 = c();
        int i13 = hashCode * 59;
        if (c11 != null) {
            i12 = c11.hashCode();
        }
        return i13 + i12;
    }

    public String toString() {
        return "PrimeListItem(showTitle=" + e() + ", title=" + d() + ", desc=" + c() + ")";
    }
}
