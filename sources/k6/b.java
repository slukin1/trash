package k6;

public class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f69007a;

    /* renamed from: b  reason: collision with root package name */
    public C0742b f69008b;

    public interface a {
        String E0();

        double a();

        String b();

        int c();

        int d();

        boolean e();

        int f();

        String g();

        String h();

        String o0();
    }

    /* renamed from: k6.b$b  reason: collision with other inner class name */
    public interface C0742b {
        void a(b bVar);

        void b(b bVar);
    }

    public b(C0742b bVar) {
        d(bVar);
    }

    public boolean a(Object obj) {
        return obj instanceof b;
    }

    public C0742b b() {
        return this.f69008b;
    }

    public a c() {
        return this.f69007a;
    }

    public void d(C0742b bVar) {
        this.f69008b = bVar;
    }

    public void e(a aVar) {
        this.f69007a = aVar;
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
        a c11 = c();
        a c12 = bVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        C0742b b11 = b();
        C0742b b12 = bVar.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public int hashCode() {
        a c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        C0742b b11 = b();
        int i12 = (hashCode + 59) * 59;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "NewestPriceItem(iNewestPrice=" + c() + ", callback=" + b() + ")";
    }
}
