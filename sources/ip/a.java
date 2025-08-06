package ip;

import com.huobi.otc.enums.OtcAdsFilterType;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public String f84280b;

    /* renamed from: c  reason: collision with root package name */
    public Object f84281c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f84282d;

    /* renamed from: e  reason: collision with root package name */
    public OtcAdsFilterType f84283e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f84284f;

    public a(String str, Object obj, OtcAdsFilterType otcAdsFilterType, boolean z11) {
        this.f84280b = str;
        this.f84281c = obj;
        this.f84283e = otcAdsFilterType;
        this.f84282d = z11;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public Object c() {
        return this.f84281c;
    }

    public String d() {
        return this.f84280b;
    }

    public OtcAdsFilterType e() {
        return this.f84283e;
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
        Object c11 = c();
        Object c12 = aVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        if (g() != aVar.g()) {
            return false;
        }
        OtcAdsFilterType e11 = e();
        OtcAdsFilterType e12 = aVar.e();
        if (e11 != null ? e11.equals(e12) : e12 == null) {
            return f() == aVar.f();
        }
        return false;
    }

    public boolean f() {
        return this.f84284f;
    }

    public boolean g() {
        return this.f84282d;
    }

    public String getViewHandlerName() {
        return null;
    }

    public int hashCode() {
        String d11 = d();
        int i11 = 43;
        int hashCode = d11 == null ? 43 : d11.hashCode();
        Object c11 = c();
        int i12 = 79;
        int hashCode2 = ((((hashCode + 59) * 59) + (c11 == null ? 43 : c11.hashCode())) * 59) + (g() ? 79 : 97);
        OtcAdsFilterType e11 = e();
        int i13 = hashCode2 * 59;
        if (e11 != null) {
            i11 = e11.hashCode();
        }
        int i14 = (i13 + i11) * 59;
        if (!f()) {
            i12 = 97;
        }
        return i14 + i12;
    }

    public String toString() {
        return "OtcAdsFilterItem(name=" + d() + ", data=" + c() + ", isChecked=" + g() + ", type=" + e() + ", isBuy=" + f() + ")";
    }
}
