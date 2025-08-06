package bo;

import com.huobi.main.trade.viewhandler.OtcTradeListHeaderItemHandler;
import s9.a;

public class b implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f77002b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f77003c;

    /* renamed from: d  reason: collision with root package name */
    public String f77004d;

    /* renamed from: e  reason: collision with root package name */
    public String f77005e;

    public b(String str) {
        this.f77002b = str;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public String c() {
        return this.f77005e;
    }

    public String d() {
        return this.f77004d;
    }

    public String e() {
        return this.f77002b;
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
        String e11 = e();
        String e12 = bVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        if (f() != bVar.f()) {
            return false;
        }
        String d11 = d();
        String d12 = bVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = bVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public boolean f() {
        return this.f77003c;
    }

    public String getViewHandlerName() {
        return OtcTradeListHeaderItemHandler.class.getName();
    }

    public int hashCode() {
        String e11 = e();
        int i11 = 43;
        int hashCode = (((e11 == null ? 43 : e11.hashCode()) + 59) * 59) + (f() ? 79 : 97);
        String d11 = d();
        int hashCode2 = (hashCode * 59) + (d11 == null ? 43 : d11.hashCode());
        String c11 = c();
        int i12 = hashCode2 * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "OtcTradeListHeaderItem(text=" + e() + ", nightMode=" + f() + ", activityTitle=" + d() + ", activityId=" + c() + ")";
    }
}
