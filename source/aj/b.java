package aj;

import com.huobi.contract.viewhandler.ContractPopWindowItemHandler;

public class b implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f40702b;

    /* renamed from: c  reason: collision with root package name */
    public int f40703c;

    /* renamed from: d  reason: collision with root package name */
    public String f40704d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f40705e;

    /* renamed from: f  reason: collision with root package name */
    public a f40706f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f40707g;

    public interface a {
        void a(b bVar);
    }

    public b(int i11, int i12, String str, a aVar) {
        k(i11);
        j(i12);
        l(str);
        m(false);
        i(aVar);
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public a c() {
        return this.f40706f;
    }

    public int d() {
        return this.f40703c;
    }

    public int e() {
        return this.f40702b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this) || e() != bVar.e() || d() != bVar.d()) {
            return false;
        }
        String f11 = f();
        String f12 = bVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        if (g() != bVar.g()) {
            return false;
        }
        a c11 = c();
        a c12 = bVar.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return h() == bVar.h();
        }
        return false;
    }

    public String f() {
        return this.f40704d;
    }

    public boolean g() {
        return this.f40705e;
    }

    public String getViewHandlerName() {
        return ContractPopWindowItemHandler.class.getName();
    }

    public boolean h() {
        return this.f40707g;
    }

    public int hashCode() {
        int e11 = ((e() + 59) * 59) + d();
        String f11 = f();
        int i11 = 43;
        int i12 = 79;
        int hashCode = (((e11 * 59) + (f11 == null ? 43 : f11.hashCode())) * 59) + (g() ? 79 : 97);
        a c11 = c();
        int i13 = hashCode * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!h()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public void i(a aVar) {
        this.f40706f = aVar;
    }

    public void j(int i11) {
        this.f40703c = i11;
    }

    public void k(int i11) {
        this.f40702b = i11;
    }

    public void l(String str) {
        this.f40704d = str;
    }

    public void m(boolean z11) {
        this.f40705e = z11;
    }

    public void n(boolean z11) {
        this.f40707g = z11;
    }

    public String toString() {
        return "ContractPopWindowItem(itemType=" + e() + ", imgResId=" + d() + ", name=" + f() + ", showDot=" + g() + ", callback=" + c() + ", showRedDot=" + h() + ")";
    }

    public b(int i11, int i12, String str, boolean z11, a aVar) {
        k(i11);
        j(i12);
        l(str);
        m(z11);
        i(aVar);
        n(false);
    }

    public b(int i11, int i12, String str, a aVar, boolean z11) {
        k(i11);
        j(i12);
        l(str);
        i(aVar);
        n(z11);
    }
}
