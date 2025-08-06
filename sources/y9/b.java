package y9;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f76825a;

    /* renamed from: b  reason: collision with root package name */
    public String f76826b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f76827c;

    public b(String str, String str2, boolean z11) {
        this.f76825a = str;
        this.f76826b = str2;
        this.f76827c = z11;
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public String b() {
        return this.f76825a;
    }

    public String c() {
        return this.f76826b;
    }

    public boolean d() {
        return this.f76827c;
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
        String b11 = b();
        String b12 = bVar.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        String c11 = c();
        String c12 = bVar.c();
        if (c11 != null ? c11.equals(c12) : c12 == null) {
            return d() == bVar.d();
        }
        return false;
    }

    public int hashCode() {
        String b11 = b();
        int i11 = 43;
        int hashCode = b11 == null ? 43 : b11.hashCode();
        String c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return ((i12 + i11) * 59) + (d() ? 79 : 97);
    }

    public String toString() {
        return "RankPrimaryTitle(title=" + b() + ", urls=" + c() + ", showRedDot=" + d() + ")";
    }
}
