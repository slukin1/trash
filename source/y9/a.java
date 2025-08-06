package y9;

import com.hbg.lib.widgets.viewhandler.CommonTabItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f76822b;

    /* renamed from: c  reason: collision with root package name */
    public String f76823c;

    /* renamed from: d  reason: collision with root package name */
    public C0825a f76824d;

    /* renamed from: y9.a$a  reason: collision with other inner class name */
    public interface C0825a {
        void a(a aVar);

        boolean b(a aVar);
    }

    public a(int i11, String str) {
        j(i11);
        i(str);
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0825a c() {
        return this.f76824d;
    }

    public String d() {
        return this.f76823c;
    }

    public int e() {
        return this.f76822b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this) || e() != aVar.e()) {
            return false;
        }
        String d11 = d();
        String d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        C0825a c11 = c();
        C0825a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public boolean f() {
        C0825a aVar = this.f76824d;
        return aVar != null && aVar.b(this);
    }

    public void g() {
        C0825a aVar = this.f76824d;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public String getViewHandlerName() {
        return CommonTabItemHandler.class.getName();
    }

    public void h(C0825a aVar) {
        this.f76824d = aVar;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int e11 = ((e() + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        C0825a c11 = c();
        int i12 = e11 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public void i(String str) {
        this.f76823c = str;
    }

    public void j(int i11) {
        this.f76822b = i11;
    }

    public String toString() {
        return "CommonTabItem(type=" + e() + ", text=" + d() + ", callback=" + c() + ")";
    }

    public a(int i11, String str, C0825a aVar) {
        j(i11);
        i(str);
        h(aVar);
    }
}
