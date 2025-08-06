package y1;

import bolts.UnobservedTaskException;
import y1.g;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public g<?> f16866a;

    public h(g<?> gVar) {
        this.f16866a = gVar;
    }

    public void a() {
        this.f16866a = null;
    }

    public void finalize() throws Throwable {
        g.C0113g o11;
        try {
            g<?> gVar = this.f16866a;
            if (!(gVar == null || (o11 = g.o()) == null)) {
                o11.a(gVar, new UnobservedTaskException(gVar.m()));
            }
        } finally {
            super.finalize();
        }
    }
}
