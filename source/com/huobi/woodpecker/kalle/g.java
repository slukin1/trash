package com.huobi.woodpecker.kalle;

import com.google.common.net.HttpHeaders;
import com.huobi.woodpecker.kalle.i;
import com.huobi.woodpecker.kalle.ssl.SSLUtils;
import com.huobi.woodpecker.kalle.util.MainExecutor;
import com.huobi.woodpecker.kalle.util.WorkExecutor;
import java.net.Proxy;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import xu.d;
import xu.e;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f21062a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f21063b;

    /* renamed from: c  reason: collision with root package name */
    public final Charset f21064c;

    /* renamed from: d  reason: collision with root package name */
    public final Headers f21065d;

    /* renamed from: e  reason: collision with root package name */
    public final Proxy f21066e;

    /* renamed from: f  reason: collision with root package name */
    public final SSLSocketFactory f21067f;

    /* renamed from: g  reason: collision with root package name */
    public final HostnameVerifier f21068g;

    /* renamed from: h  reason: collision with root package name */
    public final int f21069h;

    /* renamed from: i  reason: collision with root package name */
    public final int f21070i;

    /* renamed from: j  reason: collision with root package name */
    public final i f21071j;

    /* renamed from: k  reason: collision with root package name */
    public final cv.a f21072k;

    /* renamed from: l  reason: collision with root package name */
    public final e f21073l;

    /* renamed from: m  reason: collision with root package name */
    public final xu.b f21074m;

    /* renamed from: n  reason: collision with root package name */
    public final av.b f21075n;

    /* renamed from: o  reason: collision with root package name */
    public final List<d> f21076o;

    /* renamed from: p  reason: collision with root package name */
    public final bv.d f21077p;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public Executor f21078a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f21079b;

        /* renamed from: c  reason: collision with root package name */
        public Charset f21080c;

        /* renamed from: d  reason: collision with root package name */
        public Headers f21081d;

        /* renamed from: e  reason: collision with root package name */
        public Proxy f21082e;

        /* renamed from: f  reason: collision with root package name */
        public SSLSocketFactory f21083f;

        /* renamed from: g  reason: collision with root package name */
        public HostnameVerifier f21084g;

        /* renamed from: h  reason: collision with root package name */
        public int f21085h;

        /* renamed from: i  reason: collision with root package name */
        public int f21086i;

        /* renamed from: j  reason: collision with root package name */
        public i.b f21087j;

        /* renamed from: k  reason: collision with root package name */
        public cv.a f21088k;

        /* renamed from: l  reason: collision with root package name */
        public e f21089l;

        /* renamed from: m  reason: collision with root package name */
        public xu.b f21090m;

        /* renamed from: n  reason: collision with root package name */
        public av.b f21091n;

        /* renamed from: o  reason: collision with root package name */
        public List<d> f21092o;

        /* renamed from: p  reason: collision with root package name */
        public bv.d f21093p;

        public b q(d dVar) {
            this.f21092o.add(dVar);
            return this;
        }

        public g r() {
            return new g(this);
        }

        public b s(cv.a aVar) {
            this.f21088k = aVar;
            return this;
        }

        public b t(Executor executor) {
            this.f21079b = executor;
            return this;
        }

        public b u(e eVar) {
            this.f21089l = eVar;
            return this;
        }

        public b v(Executor executor) {
            this.f21078a = executor;
            return this;
        }

        public b() {
            this.f21081d = new Headers();
            this.f21087j = i.f();
            this.f21092o = new ArrayList();
            this.f21081d.H("Accept", "*/*");
            this.f21081d.H(HttpHeaders.ACCEPT_ENCODING, "gzip, deflate");
            this.f21081d.H("Content-Type", "application/x-www-form-urlencoded");
            this.f21081d.H(HttpHeaders.CONNECTION, "keep-alive");
            this.f21081d.H("User-Agent", Headers.f21024d);
            this.f21081d.H("Accept-Language", Headers.f21023c);
        }
    }

    public static b q() {
        return new b();
    }

    public cv.a a() {
        return this.f21072k;
    }

    public Charset b() {
        return this.f21064c;
    }

    public xu.b c() {
        return this.f21074m;
    }

    public int d() {
        return this.f21069h;
    }

    public bv.d e() {
        return this.f21077p;
    }

    public av.b f() {
        return this.f21075n;
    }

    public Headers g() {
        return this.f21065d;
    }

    public HostnameVerifier h() {
        return this.f21068g;
    }

    public List<d> i() {
        return this.f21076o;
    }

    public Executor j() {
        return this.f21063b;
    }

    public e k() {
        return this.f21073l;
    }

    public i l() {
        return this.f21071j;
    }

    public Proxy m() {
        return this.f21066e;
    }

    public int n() {
        return this.f21070i;
    }

    public SSLSocketFactory o() {
        return this.f21067f;
    }

    public Executor p() {
        return this.f21062a;
    }

    public g(b bVar) {
        this.f21062a = bVar.f21078a == null ? new WorkExecutor() : bVar.f21078a;
        this.f21063b = bVar.f21079b == null ? new MainExecutor() : bVar.f21079b;
        this.f21064c = bVar.f21080c == null ? Charset.defaultCharset() : bVar.f21080c;
        this.f21065d = bVar.f21081d;
        this.f21066e = bVar.f21082e;
        this.f21067f = bVar.f21083f == null ? SSLUtils.f21124b : bVar.f21083f;
        this.f21068g = bVar.f21084g == null ? SSLUtils.f21123a : bVar.f21084g;
        int i11 = 10000;
        this.f21069h = bVar.f21085h <= 0 ? 10000 : bVar.f21085h;
        this.f21070i = bVar.f21086i > 0 ? bVar.f21086i : i11;
        this.f21071j = bVar.f21087j.e();
        this.f21072k = bVar.f21088k == null ? cv.a.f22739a : bVar.f21088k;
        this.f21073l = bVar.f21089l == null ? e.f23444a : bVar.f21089l;
        this.f21074m = bVar.f21090m == null ? dv.b.c().a() : bVar.f21090m;
        this.f21075n = bVar.f21091n == null ? av.b.f19373a : bVar.f21091n;
        this.f21076o = Collections.unmodifiableList(bVar.f21092o);
        this.f21077p = bVar.f21093p == null ? bv.d.f19384a : bVar.f21093p;
    }
}
