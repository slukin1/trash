package oi;

import com.huobi.c2c.lend.viewhandler.C2CTermListItemHandler;

public class c implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f47692b;

    /* renamed from: c  reason: collision with root package name */
    public String f47693c;

    /* renamed from: d  reason: collision with root package name */
    public a f47694d;

    public interface a {
        void a(c cVar);

        boolean b(c cVar);
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public a c() {
        return this.f47694d;
    }

    public int d() {
        return this.f47692b;
    }

    public String e() {
        return this.f47693c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!cVar.a(this) || d() != cVar.d()) {
            return false;
        }
        String e11 = e();
        String e12 = cVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        a c11 = c();
        a c12 = cVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public boolean f() {
        a aVar = this.f47694d;
        if (aVar != null) {
            return aVar.b(this);
        }
        return false;
    }

    public String getViewHandlerName() {
        return C2CTermListItemHandler.class.getName();
    }

    public int hashCode() {
        String e11 = e();
        int i11 = 43;
        int d11 = ((d() + 59) * 59) + (e11 == null ? 43 : e11.hashCode());
        a c11 = c();
        int i12 = d11 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "C2CTermListItem(position=" + d() + ", text=" + e() + ", callback=" + c() + ")";
    }
}
