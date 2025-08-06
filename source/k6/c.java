package k6;

import android.content.Context;
import c6.b;

public class c implements a {

    /* renamed from: a  reason: collision with root package name */
    public a f69009a;

    /* renamed from: b  reason: collision with root package name */
    public b<c> f69010b;

    public interface a {
        String E0();

        double a();

        String b();

        boolean c();

        int d(Context context);

        double e();

        boolean f();

        int g(Context context);

        String getIndex();

        int h();

        float i(Context context);

        float j(Context context);

        boolean k();

        float l();

        int m(Context context);

        String n();

        int o();

        String o0();
    }

    public c(b<c> bVar) {
        d(bVar);
    }

    public boolean a(Object obj) {
        return obj instanceof c;
    }

    public b<c> b() {
        return this.f69010b;
    }

    public a c() {
        return this.f69009a;
    }

    public void d(b<c> bVar) {
        this.f69010b = bVar;
    }

    public void e(a aVar) {
        this.f69009a = aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!cVar.a(this)) {
            return false;
        }
        a c11 = c();
        a c12 = cVar.c();
        if (c11 != null ? !c11.equals(c12) : c12 != null) {
            return false;
        }
        b<c> b11 = b();
        b<c> b12 = cVar.b();
        return b11 != null ? b11.equals(b12) : b12 == null;
    }

    public int hashCode() {
        a c11 = c();
        int i11 = 43;
        int hashCode = c11 == null ? 43 : c11.hashCode();
        b<c> b11 = b();
        int i12 = (hashCode + 59) * 59;
        if (b11 != null) {
            i11 = b11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "TradeTrendItem(iTradeTrend=" + c() + ", callback=" + b() + ")";
    }
}
