package com.huobi.kalle;

import com.google.common.net.HttpHeaders;
import com.huobi.kalle.i;
import com.huobi.kalle.ssl.SSLUtils;
import com.huobi.kalle.util.MainExecutor;
import com.huobi.kalle.util.WorkExecutor;
import hm.d;
import hm.e;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f74704a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f74705b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f74706c;

    /* renamed from: d  reason: collision with root package name */
    public final Headers f74707d;

    /* renamed from: e  reason: collision with root package name */
    public final Proxy f74708e;

    /* renamed from: f  reason: collision with root package name */
    public final SSLSocketFactory f74709f;

    /* renamed from: g  reason: collision with root package name */
    public final HostnameVerifier f74710g;

    /* renamed from: h  reason: collision with root package name */
    public final int f74711h;

    /* renamed from: i  reason: collision with root package name */
    public final int f74712i;

    /* renamed from: j  reason: collision with root package name */
    public final i f74713j;

    /* renamed from: k  reason: collision with root package name */
    public final mm.a f74714k;

    /* renamed from: l  reason: collision with root package name */
    public final e f74715l;

    /* renamed from: m  reason: collision with root package name */
    public final hm.b f74716m;

    /* renamed from: n  reason: collision with root package name */
    public final km.b f74717n;

    /* renamed from: o  reason: collision with root package name */
    public final List<d> f74718o;

    /* renamed from: p  reason: collision with root package name */
    public final lm.d f74719p;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Executor f74720a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f74721b;

        /* renamed from: c  reason: collision with root package name */
        public Charset f74722c;

        /* renamed from: d  reason: collision with root package name */
        public Headers f74723d;

        /* renamed from: e  reason: collision with root package name */
        public Proxy f74724e;

        /* renamed from: f  reason: collision with root package name */
        public SSLSocketFactory f74725f;

        /* renamed from: g  reason: collision with root package name */
        public HostnameVerifier f74726g;

        /* renamed from: h  reason: collision with root package name */
        public int f74727h;

        /* renamed from: i  reason: collision with root package name */
        public int f74728i;

        /* renamed from: j  reason: collision with root package name */
        public i.b f74729j;

        /* renamed from: k  reason: collision with root package name */
        public mm.a f74730k;

        /* renamed from: l  reason: collision with root package name */
        public e f74731l;

        /* renamed from: m  reason: collision with root package name */
        public hm.b f74732m;

        /* renamed from: n  reason: collision with root package name */
        public km.b f74733n;

        /* renamed from: o  reason: collision with root package name */
        public List<d> f74734o;

        /* renamed from: p  reason: collision with root package name */
        public lm.d f74735p;

        public b q(d dVar) {
            this.f74734o.add(dVar);
            return this;
        }

        public g r() {
            return new g(this);
        }

        public b s(mm.a aVar) {
            this.f74730k = aVar;
            return this;
        }

        public b t(Executor executor) {
            this.f74721b = executor;
            return this;
        }

        public b u(e eVar) {
            this.f74731l = eVar;
            return this;
        }

        public b v(Executor executor) {
            this.f74720a = executor;
            return this;
        }

        public b() {
            this.f74723d = new Headers();
            this.f74729j = i.f();
            this.f74734o = new ArrayList();
            this.f74723d.H("Accept", "*/*");
            this.f74723d.H(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
            this.f74723d.H("Content-Type", "application/x-www-form-urlencoded");
            this.f74723d.H(HttpHeaders.CONNECTION, "keep-alive");
            this.f74723d.H("User-Agent", Headers.f74666d);
            this.f74723d.H("Accept-Language", Headers.f74665c);
        }
    }

    public static b q() {
        return new b();
    }

    public mm.a a() {
        return this.f74714k;
    }

    public Charset b() {
        return this.f74706c;
    }

    public hm.b c() {
        return this.f74716m;
    }

    public int d() {
        return this.f74711h;
    }

    public lm.d e() {
        return this.f74719p;
    }

    public km.b f() {
        return this.f74717n;
    }

    public Headers g() {
        return this.f74707d;
    }

    public HostnameVerifier h() {
        return this.f74710g;
    }

    public List<d> i() {
        return this.f74718o;
    }

    public Executor j() {
        return this.f74705b;
    }

    public e k() {
        return this.f74715l;
    }

    public i l() {
        return this.f74713j;
    }

    public Proxy m() {
        return this.f74708e;
    }

    public int n() {
        return this.f74712i;
    }

    public SSLSocketFactory o() {
        return this.f74709f;
    }

    public Executor p() {
        return this.f74704a;
    }

    public g(b bVar) {
        this.f74704a = bVar.f74720a == null ? new WorkExecutor() : bVar.f74720a;
        this.f74705b = bVar.f74721b == null ? new MainExecutor() : bVar.f74721b;
        this.f74706c = bVar.f74722c == null ? Charset.defaultCharset() : bVar.f74722c;
        this.f74707d = bVar.f74723d;
        this.f74708e = bVar.f74724e;
        this.f74709f = bVar.f74725f == null ? SSLUtils.f74766b : bVar.f74725f;
        this.f74710g = bVar.f74726g == null ? SSLUtils.f74765a : bVar.f74726g;
        int i11 = 10000;
        this.f74711h = bVar.f74727h <= 0 ? 10000 : bVar.f74727h;
        this.f74712i = bVar.f74728i > 0 ? bVar.f74728i : i11;
        this.f74713j = bVar.f74729j.e();
        this.f74714k = bVar.f74730k == null ? mm.a.f76319a : bVar.f74730k;
        this.f74715l = bVar.f74731l == null ? e.f76193a : bVar.f74731l;
        this.f74716m = bVar.f74732m == null ? nm.b.c().a() : bVar.f74732m;
        this.f74717n = bVar.f74733n == null ? km.b.f76232a : bVar.f74733n;
        this.f74718o = Collections.unmodifiableList(bVar.f74734o);
        this.f74719p = bVar.f74735p == null ? lm.d.f76249a : bVar.f74735p;
    }
}
