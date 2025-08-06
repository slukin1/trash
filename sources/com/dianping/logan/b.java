package com.dianping.logan;

public class b implements c {

    /* renamed from: d  reason: collision with root package name */
    public static b f64858d;

    /* renamed from: a  reason: collision with root package name */
    public c f64859a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64860b;

    /* renamed from: c  reason: collision with root package name */
    public e f64861c;

    public static b g() {
        if (f64858d == null) {
            synchronized (b.class) {
                f64858d = new b();
            }
        }
        return f64858d;
    }

    public void a() {
        c cVar = this.f64859a;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void b(String str, String str2, int i11, String str3, String str4) {
        if (!this.f64860b) {
            if (CLoganProtocol.g()) {
                CLoganProtocol i12 = CLoganProtocol.i();
                this.f64859a = i12;
                i12.f(this.f64861c);
                this.f64859a.b(str, str2, i11, str3, str4);
                this.f64860b = true;
                return;
            }
            this.f64859a = null;
        }
    }

    public void c(int i11, String str, long j11, String str2, long j12, boolean z11) {
        c cVar = this.f64859a;
        if (cVar != null) {
            cVar.c(i11, str, j11, str2, j12, z11);
        }
    }

    public void d(String str) {
        c cVar = this.f64859a;
        if (cVar != null) {
            cVar.d(str);
        }
    }

    public void e(boolean z11) {
        c cVar = this.f64859a;
        if (cVar != null) {
            cVar.e(z11);
        }
    }

    public void f(e eVar) {
        this.f64861c = eVar;
    }
}
