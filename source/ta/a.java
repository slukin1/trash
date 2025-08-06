package ta;

import com.hbg.lite.account.viewhanlder.LitePricingMethodItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public C0885a f84886b;

    /* renamed from: c  reason: collision with root package name */
    public int f84887c;

    /* renamed from: ta.a$a  reason: collision with other inner class name */
    public interface C0885a {
        String a(int i11);

        void onItemClick(int i11);

        boolean s(int i11);
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0885a c() {
        return this.f84886b;
    }

    public int d() {
        return this.f84887c;
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
        C0885a c11 = c();
        C0885a c12 = aVar.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return d() == aVar.d();
        }
        return false;
    }

    public String getViewHandlerName() {
        return LitePricingMethodItemHandler.class.getName();
    }

    public int hashCode() {
        C0885a c11 = c();
        return (((c11 == null ? 43 : c11.hashCode()) + 59) * 59) + d();
    }

    public String toString() {
        return "LitePricingMethodItem(callback=" + c() + ", type=" + d() + ")";
    }
}
