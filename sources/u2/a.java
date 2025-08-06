package u2;

import com.alibaba.sdk.android.httpdns.j.d;
import com.alibaba.sdk.android.httpdns.j.f;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import t2.i;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public q2.a f16605a;

    /* renamed from: b  reason: collision with root package name */
    public b f16606b;

    /* renamed from: c  reason: collision with root package name */
    public d f16607c = new d();

    /* renamed from: d  reason: collision with root package name */
    public f f16608d = new f();

    /* renamed from: u2.a$a  reason: collision with other inner class name */
    public class C0105a implements i<e> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f16609a;

        public C0105a(String str) {
            this.f16609a = str;
        }

        public void a(Throwable th2) {
            HttpDnsLog.j("update server ips fail", th2);
            a.this.f16608d.b(this.f16609a);
        }

        /* renamed from: b */
        public void a(e eVar) {
            if (!eVar.d()) {
                HttpDnsLog.g("disable service by server response " + eVar.toString());
                a.this.f16605a.x(false);
                return;
            }
            if (!a.this.f16605a.w()) {
                a.this.f16605a.x(true);
            }
            if (eVar.c() != null) {
                a.this.d(this.f16609a, eVar.c(), eVar.b());
                a.this.f16607c.c(this.f16609a, eVar.c(), eVar.b());
            }
            a.this.f16608d.b(this.f16609a);
        }
    }

    public interface b {
        void e(boolean z11);
    }

    public a(q2.a aVar, b bVar) {
        this.f16605a = aVar;
        this.f16606b = bVar;
    }

    public final void d(String str, String[] strArr, int[] iArr) {
        b bVar;
        boolean z11 = !w2.a.e(this.f16605a.e().g(), str);
        if (this.f16605a.e().l(str, strArr, iArr) && (bVar = this.f16606b) != null) {
            bVar.e(z11);
        }
    }

    public void f() {
        g(this.f16605a.u());
    }

    public void g(String str) {
        String[] b11 = this.f16607c.b(str);
        int[] a11 = this.f16607c.a(str);
        if (b11 != null) {
            d(str, b11, a11);
        } else if (this.f16608d.a(str)) {
            f.a(this.f16605a, str, new C0105a(str));
        }
    }
}
