package ws;

import com.huobi.trade.handler.TradePopWindowItemHandler;

public class g implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f85049b;

    /* renamed from: c  reason: collision with root package name */
    public int f85050c;

    /* renamed from: d  reason: collision with root package name */
    public String f85051d;

    /* renamed from: e  reason: collision with root package name */
    public a f85052e;

    public interface a {
        void a(g gVar);
    }

    public g(int i11, int i12, String str, a aVar) {
        i(i11);
        h(i12);
        j(str);
        g(aVar);
    }

    public boolean a(Object obj) {
        return obj instanceof g;
    }

    public a c() {
        return this.f85052e;
    }

    public int d() {
        return this.f85050c;
    }

    public int e() {
        return this.f85049b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (!gVar.a(this) || e() != gVar.e() || d() != gVar.d()) {
            return false;
        }
        String f11 = f();
        String f12 = gVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = gVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String f() {
        return this.f85051d;
    }

    public void g(a aVar) {
        this.f85052e = aVar;
    }

    public String getViewHandlerName() {
        return TradePopWindowItemHandler.class.getName();
    }

    public void h(int i11) {
        this.f85050c = i11;
    }

    public int hashCode() {
        int e11 = ((e() + 59) * 59) + d();
        String f11 = f();
        int i11 = 43;
        int hashCode = (e11 * 59) + (f11 == null ? 43 : f11.hashCode());
        a c11 = c();
        int i12 = hashCode * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public void i(int i11) {
        this.f85049b = i11;
    }

    public void j(String str) {
        this.f85051d = str;
    }

    public String toString() {
        return "TradePopWindowItem(itemType=" + e() + ", imgResId=" + d() + ", name=" + f() + ", callback=" + c() + ")";
    }
}
