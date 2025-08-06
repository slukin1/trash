package t2;

import s2.b;
import s2.c;
import t2.f;

public class d implements f.a {

    /* renamed from: a  reason: collision with root package name */
    public b f16550a;

    public d(b bVar) {
        this.f16550a = bVar;
    }

    public void a(c cVar, Throwable th2) {
        if (this.f16550a == null) {
            return;
        }
        if (cVar.e().contains("/ss")) {
            b bVar = this.f16550a;
            String d11 = cVar.d();
            bVar.d(d11, c.a(th2) + "", c.b(th2), 0);
            return;
        }
        b bVar2 = this.f16550a;
        String d12 = cVar.d();
        bVar2.e(d12, c.a(th2) + "", c.b(th2), 0, 0);
    }

    public void b(c cVar) {
    }

    public void c(c cVar, Object obj) {
    }
}
