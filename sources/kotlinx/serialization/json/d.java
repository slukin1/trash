package kotlinx.serialization.json;

import kotlin.jvm.internal.x;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public boolean f57837a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57838b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57839c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f57840d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f57841e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57842f;

    /* renamed from: g  reason: collision with root package name */
    public String f57843g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f57844h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f57845i;

    /* renamed from: j  reason: collision with root package name */
    public String f57846j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f57847k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f57848l;

    /* renamed from: m  reason: collision with root package name */
    public q f57849m;

    /* renamed from: n  reason: collision with root package name */
    public kotlinx.serialization.modules.d f57850n;

    public d(a aVar) {
        this.f57837a = aVar.f().e();
        this.f57838b = aVar.f().f();
        this.f57839c = aVar.f().g();
        this.f57840d = aVar.f().m();
        this.f57841e = aVar.f().b();
        this.f57842f = aVar.f().i();
        this.f57843g = aVar.f().j();
        this.f57844h = aVar.f().d();
        this.f57845i = aVar.f().l();
        this.f57846j = aVar.f().c();
        this.f57847k = aVar.f().a();
        this.f57848l = aVar.f().k();
        this.f57849m = aVar.f().h();
        this.f57850n = aVar.a();
    }

    public final JsonConfiguration a() {
        if (!this.f57845i || x.b(this.f57846j, "type")) {
            if (!this.f57842f) {
                if (!x.b(this.f57843g, "    ")) {
                    throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
                }
            } else if (!x.b(this.f57843g, "    ")) {
                String str = this.f57843g;
                boolean z11 = false;
                int i11 = 0;
                while (true) {
                    boolean z12 = true;
                    if (i11 >= str.length()) {
                        z11 = true;
                        break;
                    }
                    char charAt = str.charAt(i11);
                    if (!(charAt == ' ' || charAt == 9 || charAt == 13 || charAt == 10)) {
                        z12 = false;
                    }
                    if (!z12) {
                        break;
                    }
                    i11++;
                }
                if (!z11) {
                    throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.f57843g).toString());
                }
            }
            return new JsonConfiguration(this.f57837a, this.f57839c, this.f57840d, this.f57841e, this.f57842f, this.f57838b, this.f57843g, this.f57844h, this.f57845i, this.f57846j, this.f57847k, this.f57848l, this.f57849m);
        }
        throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
    }

    public final kotlinx.serialization.modules.d b() {
        return this.f57850n;
    }

    public final void c(boolean z11) {
        this.f57841e = z11;
    }

    public final void d(boolean z11) {
        this.f57844h = z11;
    }

    public final void e(boolean z11) {
        this.f57839c = z11;
    }

    public final void f(boolean z11) {
        this.f57842f = z11;
    }

    public final void g(kotlinx.serialization.modules.d dVar) {
        this.f57850n = dVar;
    }
}
