package bv;

import com.huobi.woodpecker.kalle.Headers;

public final class h<Succeed, Failed> {

    /* renamed from: a  reason: collision with root package name */
    public final int f19407a;

    /* renamed from: b  reason: collision with root package name */
    public final Headers f19408b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f19409c;

    /* renamed from: d  reason: collision with root package name */
    public final Succeed f19410d;

    /* renamed from: e  reason: collision with root package name */
    public final Failed f19411e;

    public static final class b<Succeed, Failed> {

        /* renamed from: a  reason: collision with root package name */
        public int f19412a;

        /* renamed from: b  reason: collision with root package name */
        public Headers f19413b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f19414c;

        /* renamed from: d  reason: collision with root package name */
        public Failed f19415d;

        /* renamed from: e  reason: collision with root package name */
        public Succeed f19416e;

        public h<Succeed, Failed> f() {
            return new h<>(this);
        }

        public b<Succeed, Failed> g(int i11) {
            this.f19412a = i11;
            return this;
        }

        public b<Succeed, Failed> h(Failed failed) {
            this.f19415d = failed;
            return this;
        }

        public b<Succeed, Failed> i(boolean z11) {
            this.f19414c = z11;
            return this;
        }

        public b<Succeed, Failed> j(Headers headers) {
            this.f19413b = headers;
            return this;
        }

        public b<Succeed, Failed> k(Succeed succeed) {
            this.f19416e = succeed;
            return this;
        }

        public b() {
        }
    }

    public static <Succeed, Failed> b<Succeed, Failed> d() {
        return new b<>();
    }

    public int a() {
        return this.f19407a;
    }

    public Failed b() {
        return this.f19411e;
    }

    public boolean c() {
        return this.f19411e == null || this.f19410d != null;
    }

    public Succeed e() {
        return this.f19410d;
    }

    public h(b<Succeed, Failed> bVar) {
        this.f19407a = bVar.f19412a;
        this.f19408b = bVar.f19413b;
        this.f19409c = bVar.f19414c;
        this.f19410d = bVar.f19416e;
        this.f19411e = bVar.f19415d;
    }
}
