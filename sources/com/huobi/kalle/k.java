package com.huobi.kalle;

import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public final RequestMethod f74738a;

    /* renamed from: b  reason: collision with root package name */
    public final Headers f74739b;

    /* renamed from: c  reason: collision with root package name */
    public final Proxy f74740c;

    /* renamed from: d  reason: collision with root package name */
    public final SSLSocketFactory f74741d;

    /* renamed from: e  reason: collision with root package name */
    public final HostnameVerifier f74742e;

    /* renamed from: f  reason: collision with root package name */
    public final int f74743f;

    /* renamed from: g  reason: collision with root package name */
    public final int f74744g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f74745h;

    public static abstract class a<T extends a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public final RequestMethod f74746a;

        /* renamed from: b  reason: collision with root package name */
        public final Headers f74747b;

        /* renamed from: c  reason: collision with root package name */
        public Proxy f74748c = Kalle.a().m();

        /* renamed from: d  reason: collision with root package name */
        public SSLSocketFactory f74749d = Kalle.a().o();

        /* renamed from: e  reason: collision with root package name */
        public HostnameVerifier f74750e = Kalle.a().h();

        /* renamed from: f  reason: collision with root package name */
        public int f74751f = Kalle.a().d();

        /* renamed from: g  reason: collision with root package name */
        public int f74752g = Kalle.a().n();

        /* renamed from: h  reason: collision with root package name */
        public Object f74753h;

        public a(RequestMethod requestMethod) {
            Headers headers = new Headers();
            this.f74747b = headers;
            this.f74746a = requestMethod;
            headers.i(Kalle.a().g());
        }

        public T i(Headers headers) {
            this.f74747b.G(headers);
            return this;
        }
    }

    public <T extends a<T>> k(a<T> aVar) {
        this.f74738a = aVar.f74746a;
        this.f74739b = aVar.f74747b;
        this.f74740c = aVar.f74748c;
        this.f74741d = aVar.f74749d;
        this.f74742e = aVar.f74750e;
        this.f74743f = aVar.f74751f;
        this.f74744g = aVar.f74752g;
        this.f74745h = aVar.f74753h;
    }

    public Headers c() {
        return this.f74739b;
    }

    public abstract l d();

    public int e() {
        return this.f74743f;
    }

    public abstract i f();

    public HostnameVerifier g() {
        return this.f74742e;
    }

    public RequestMethod h() {
        return this.f74738a;
    }

    public Proxy i() {
        return this.f74740c;
    }

    public int j() {
        return this.f74744g;
    }

    public SSLSocketFactory k() {
        return this.f74741d;
    }

    public abstract Url l();
}
