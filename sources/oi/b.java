package oi;

import com.huobi.c2c.lend.viewhandler.C2CRateListItemHandler;

public class b implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public int f47688b;

    /* renamed from: c  reason: collision with root package name */
    public String f47689c;

    /* renamed from: d  reason: collision with root package name */
    public String f47690d;

    /* renamed from: e  reason: collision with root package name */
    public a f47691e;

    public interface a {
        void a(b bVar);
    }

    public b(int i11, String str, String str2, a aVar) {
        this.f47688b = i11;
        this.f47689c = str;
        this.f47690d = str2;
        this.f47691e = aVar;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public String c() {
        return this.f47690d;
    }

    public a d() {
        return this.f47691e;
    }

    public int e() {
        return this.f47688b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (!bVar.a(this) || e() != bVar.e()) {
            return false;
        }
        String f11 = f();
        String f12 = bVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = bVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        a d11 = d();
        a d12 = bVar.d();
        return d11 != null ? d11.equals(d12) : d12 == null;
    }

    public String f() {
        return this.f47689c;
    }

    public String getViewHandlerName() {
        return C2CRateListItemHandler.class.getName();
    }

    public int hashCode() {
        String f11 = f();
        int i11 = 43;
        int e11 = ((e() + 59) * 59) + (f11 == null ? 43 : f11.hashCode());
        String c11 = c();
        int hashCode = (e11 * 59) + (c11 == null ? 43 : c11.hashCode());
        a d11 = d();
        int i12 = hashCode * 59;
        if (d11 != null) {
            i11 = d11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "C2CRateListItem(position=" + e() + ", rate=" + f() + ", amount=" + c() + ", callback=" + d() + ")";
    }
}
