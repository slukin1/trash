package ft;

import com.huobi.trade.prime.viewhandler.PrimeFourItemHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f84139b;

    /* renamed from: c  reason: collision with root package name */
    public String f84140c;

    public a(String str, String str2) {
        f(str);
        e(str2);
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public String c() {
        return this.f84140c;
    }

    public String d() {
        return this.f84139b;
    }

    public void e(String str) {
        this.f84140c = str;
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
        String d11 = d();
        String d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(String str) {
        this.f84139b = str;
    }

    public String getViewHandlerName() {
        return PrimeFourItemHandler.class.getName();
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
        return i12 + i11;
    }

    public String toString() {
        return "PrimeFourDialogItem(num=" + d() + ", content=" + c() + ")";
    }
}
