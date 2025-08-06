package aj;

import com.huobi.contract.viewhandler.ContractHeaderViewHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f40696b;

    /* renamed from: c  reason: collision with root package name */
    public int f40697c;

    /* renamed from: d  reason: collision with root package name */
    public String f40698d;

    /* renamed from: e  reason: collision with root package name */
    public String f40699e;

    /* renamed from: f  reason: collision with root package name */
    public String f40700f;

    /* renamed from: g  reason: collision with root package name */
    public int f40701g;

    public a(String str) {
        this.f40696b = str;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public String c() {
        return this.f40699e;
    }

    public String d() {
        return this.f40698d;
    }

    public String e() {
        return this.f40700f;
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
        String g11 = g();
        String g12 = aVar.g();
        if (g11 != null ? !g11.equals(g12) : g12 != null) {
            return false;
        }
        if (f() != aVar.f()) {
            return false;
        }
        String d11 = d();
        String d12 = aVar.d();
        if (d11 != null ? !d11.equals(d12) : d12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = aVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        String e11 = e();
        String e12 = aVar.e();
        if (e11 != null ? e11.equals(e12) : e12 == null) {
            return h() == aVar.h();
        }
        return false;
    }

    public int f() {
        return this.f40697c;
    }

    public String g() {
        return this.f40696b;
    }

    public String getViewHandlerName() {
        return ContractHeaderViewHandler.class.getName();
    }

    public int h() {
        return this.f40701g;
    }

    public int hashCode() {
        String g11 = g();
        int i11 = 43;
        int hashCode = (((g11 == null ? 43 : g11.hashCode()) + 59) * 59) + f();
        String d11 = d();
        int hashCode2 = (hashCode * 59) + (d11 == null ? 43 : d11.hashCode());
        String c11 = c();
        int hashCode3 = (hashCode2 * 59) + (c11 == null ? 43 : c11.hashCode());
        String e11 = e();
        int i12 = hashCode3 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        return ((i12 + i11) * 59) + h();
    }

    public void i(String str) {
        this.f40699e = str;
    }

    public void j(String str) {
        this.f40698d = str;
    }

    public void k(String str) {
        this.f40700f = str;
    }

    public void l(int i11) {
        this.f40697c = i11;
    }

    public String toString() {
        return "ContractHeaderItem(symbol=" + g() + ", itemType=" + f() + ", activityTitle=" + d() + ", activityId=" + c() + ", activityUrl=" + e() + ", urlType=" + h() + ")";
    }
}
