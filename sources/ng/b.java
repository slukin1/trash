package ng;

import android.net.Uri;
import fi.iki.elonen.NanoHTTPD;
import java.io.IOException;
import java.io.InputStream;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f40550a;

    /* renamed from: b  reason: collision with root package name */
    public int f40551b;

    /* renamed from: c  reason: collision with root package name */
    public NanoHTTPD f40552c;

    /* renamed from: d  reason: collision with root package name */
    public int f40553d = 0;

    public class a extends NanoHTTPD {
        public a(int i11) {
            super(i11);
        }

        public NanoHTTPD.Response u(NanoHTTPD.j jVar) {
            return b.this.b(jVar);
        }
    }

    public b(int i11, a aVar) {
        this.f40551b = i11;
        this.f40550a = aVar;
    }

    public int a() {
        return this.f40551b;
    }

    public NanoHTTPD.Response b(NanoHTTPD.j jVar) {
        String replaceFirst = Uri.parse(jVar.getUri()).getPath().replaceFirst(this.f40550a.c(), "/");
        if ("/".equals(replaceFirst)) {
            replaceFirst = "/index.html";
        }
        InputStream a11 = this.f40550a.a(replaceFirst);
        if (a11 != null) {
            return NanoHTTPD.q(NanoHTTPD.Response.Status.OK, NanoHTTPD.m(replaceFirst), a11);
        }
        NanoHTTPD.Response b11 = this.f40550a.b(jVar);
        if (b11 != null) {
            return b11;
        }
        return NanoHTTPD.s(NanoHTTPD.Response.Status.NOT_FOUND, "text/plain", "Not Found");
    }

    public void c() {
        this.f40553d = 0;
        d();
    }

    public void d() {
        try {
            a aVar = new a(this.f40551b);
            this.f40552c = aVar;
            aVar.y();
        } catch (IOException unused) {
            this.f40552c.B();
            int i11 = this.f40553d + 1;
            this.f40553d = i11;
            if (i11 > 1000) {
                this.f40551b = -1;
            } else {
                d();
            }
        }
    }

    public void e() {
        NanoHTTPD nanoHTTPD = this.f40552c;
        if (nanoHTTPD != null) {
            nanoHTTPD.B();
        }
    }
}
