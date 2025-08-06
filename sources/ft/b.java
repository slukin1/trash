package ft;

import com.huobi.trade.prime.viewhandler.PrimeEmptyHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f84141b;

    public b(String str) {
        d(str);
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public String c() {
        return this.f84141b;
    }

    public void d(String str) {
        this.f84141b = str;
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
        String c11 = c();
        String c12 = bVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String getViewHandlerName() {
        return PrimeEmptyHandler.class.getName();
    }

    public int hashCode() {
        String c11 = c();
        return 59 + (c11 == null ? 43 : c11.hashCode());
    }

    public String toString() {
        return "PrimeListEmptyItem(title=" + c() + ")";
    }
}
