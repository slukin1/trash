package ws;

import com.huobi.trade.handler.MarginBalanceDialogItemHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public int f85035b;

    /* renamed from: c  reason: collision with root package name */
    public String f85036c;

    /* renamed from: d  reason: collision with root package name */
    public String f85037d;

    /* renamed from: e  reason: collision with root package name */
    public String f85038e;

    public b(int i11, String str, String str2, String str3) {
        this.f85035b = i11;
        this.f85036c = str;
        this.f85037d = str2;
        this.f85038e = str3;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public String c() {
        return this.f85037d;
    }

    public String d() {
        return this.f85036c;
    }

    public String e() {
        return this.f85038e;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this) || f() != bVar.f()) {
            return false;
        }
        String d11 = d();
        String d12 = bVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = bVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = bVar.e();
        return e11 != null ? e11.equals(e12) : e12 == null;
    }

    public int f() {
        return this.f85035b;
    }

    public void g(String str) {
        this.f85037d = str;
    }

    public String getViewHandlerName() {
        return MarginBalanceDialogItemHandler.class.getName();
    }

    public void h(String str) {
        this.f85038e = str;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int f11 = ((f() + 59) * 59) + (d11 == null ? 43 : d11.hashCode());
        String c11 = c();
        int hashCode = (f11 * 59) + (c11 == null ? 43 : c11.hashCode());
        String e11 = e();
        int i12 = hashCode * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "MarginBalanceDialogItem(type=" + f() + ", label=" + d() + ", baseCurrencyAmount=" + c() + ", quoteCurrencyAmount=" + e() + ")";
    }
}
