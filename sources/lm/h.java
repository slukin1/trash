package lm;

import com.huobi.kalle.Headers;

public final class h<Succeed, Failed> {

    /* renamed from: a  reason: collision with root package name */
    public final int f76270a;

    /* renamed from: b  reason: collision with root package name */
    public final Headers f76271b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f76272c;

    /* renamed from: d  reason: collision with root package name */
    public final Succeed f76273d;

    /* renamed from: e  reason: collision with root package name */
    public final Failed f76274e;

    public static final class b<Succeed, Failed> {

        /* renamed from: a  reason: collision with root package name */
        public int f76275a;

        /* renamed from: b  reason: collision with root package name */
        public Headers f76276b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f76277c;

        /* renamed from: d  reason: collision with root package name */
        public Failed f76278d;

        /* renamed from: e  reason: collision with root package name */
        public Succeed f76279e;

        public h<Succeed, Failed> f() {
            return new h<>(this);
        }

        public b<Succeed, Failed> g(int i11) {
            this.f76275a = i11;
            return this;
        }

        public b<Succeed, Failed> h(Failed failed) {
            this.f76278d = failed;
            return this;
        }

        public b<Succeed, Failed> i(boolean z11) {
            this.f76277c = z11;
            return this;
        }

        public b<Succeed, Failed> j(Headers headers) {
            this.f76276b = headers;
            return this;
        }

        public b<Succeed, Failed> k(Succeed succeed) {
            this.f76279e = succeed;
            return this;
        }

        public b() {
        }
    }

    public static <Succeed, Failed> b<Succeed, Failed> d() {
        return new b<>();
    }

    public int a() {
        return this.f76270a;
    }

    public Failed b() {
        return this.f76274e;
    }

    public boolean c() {
        return this.f76274e == null || this.f76273d != null;
    }

    public Succeed e() {
        return this.f76273d;
    }

    public h(b<Succeed, Failed> bVar) {
        this.f76270a = bVar.f76275a;
        this.f76271b = bVar.f76276b;
        this.f76272c = bVar.f76277c;
        this.f76273d = bVar.f76279e;
        this.f76274e = bVar.f76278d;
    }
}
