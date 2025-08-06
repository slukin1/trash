package com.huobi.woodpecker.kalle;

import java.net.Proxy;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    public final RequestMethod f21096a;

    /* renamed from: b  reason: collision with root package name */
    public final Headers f21097b;

    /* renamed from: c  reason: collision with root package name */
    public final Proxy f21098c;

    /* renamed from: d  reason: collision with root package name */
    public final SSLSocketFactory f21099d;

    /* renamed from: e  reason: collision with root package name */
    public final HostnameVerifier f21100e;

    /* renamed from: f  reason: collision with root package name */
    public final int f21101f;

    /* renamed from: g  reason: collision with root package name */
    public final int f21102g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f21103h;

    public static abstract class a<T extends a<T>> {

        /* renamed from: a  reason: collision with root package name */
        public final RequestMethod f21104a;

        /* renamed from: b  reason: collision with root package name */
        public final Headers f21105b;

        /* renamed from: c  reason: collision with root package name */
        public Proxy f21106c = Kalle.b().m();

        /* renamed from: d  reason: collision with root package name */
        public SSLSocketFactory f21107d = Kalle.b().o();

        /* renamed from: e  reason: collision with root package name */
        public HostnameVerifier f21108e = Kalle.b().h();

        /* renamed from: f  reason: collision with root package name */
        public int f21109f = Kalle.b().d();

        /* renamed from: g  reason: collision with root package name */
        public int f21110g = Kalle.b().n();

        /* renamed from: h  reason: collision with root package name */
        public Object f21111h;

        public a(RequestMethod requestMethod) {
            Headers headers = new Headers();
            this.f21105b = headers;
            this.f21104a = requestMethod;
            headers.i(Kalle.b().g());
        }

        public T i(Headers headers) {
            this.f21105b.G(headers);
            return this;
        }
    }

    public <T extends a<T>> k(a<T> aVar) {
        this.f21096a = aVar.f21104a;
        this.f21097b = aVar.f21105b;
        this.f21098c = aVar.f21106c;
        this.f21099d = aVar.f21107d;
        this.f21100e = aVar.f21108e;
        this.f21101f = aVar.f21109f;
        this.f21102g = aVar.f21110g;
        this.f21103h = aVar.f21111h;
    }

    public Headers c() {
        return this.f21097b;
    }

    public abstract l d();

    public int e() {
        return this.f21101f;
    }

    public abstract i f();

    public HostnameVerifier g() {
        return this.f21100e;
    }

    public RequestMethod h() {
        return this.f21096a;
    }

    public Proxy i() {
        return this.f21098c;
    }

    public int j() {
        return this.f21102g;
    }

    public SSLSocketFactory k() {
        return this.f21099d;
    }

    public abstract Url l();
}
