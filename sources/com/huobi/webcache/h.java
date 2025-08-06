package com.huobi.webcache;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Dns;
import okhttp3.Interceptor;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public boolean f20735a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f20736b = 1;

    /* renamed from: c  reason: collision with root package name */
    public String f20737c;

    /* renamed from: d  reason: collision with root package name */
    public long f20738d = 524288000;

    /* renamed from: e  reason: collision with root package name */
    public int f20739e = 64;

    /* renamed from: f  reason: collision with root package name */
    public long f20740f = 5;

    /* renamed from: g  reason: collision with root package name */
    public long f20741g = 5;

    /* renamed from: h  reason: collision with root package name */
    public boolean f20742h = false;

    /* renamed from: i  reason: collision with root package name */
    public SSLSocketFactory f20743i = null;

    /* renamed from: j  reason: collision with root package name */
    public X509TrustManager f20744j = null;

    /* renamed from: k  reason: collision with root package name */
    public Dns f20745k = null;

    /* renamed from: l  reason: collision with root package name */
    public CacheStrategy f20746l = CacheStrategy.FORCE;

    /* renamed from: m  reason: collision with root package name */
    public boolean f20747m = false;

    /* renamed from: n  reason: collision with root package name */
    public Context f20748n;

    /* renamed from: o  reason: collision with root package name */
    public b f20749o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f20750p = false;

    /* renamed from: q  reason: collision with root package name */
    public boolean f20751q = false;

    /* renamed from: r  reason: collision with root package name */
    public boolean f20752r = false;

    /* renamed from: s  reason: collision with root package name */
    public boolean f20753s = true;

    /* renamed from: t  reason: collision with root package name */
    public HashSet<String> f20754t = new HashSet<>();

    /* renamed from: u  reason: collision with root package name */
    public HashSet<String> f20755u = new HashSet<>();

    /* renamed from: v  reason: collision with root package name */
    public HashSet<String> f20756v = new HashSet<>();

    /* renamed from: w  reason: collision with root package name */
    public HashSet<String> f20757w = new HashSet<>();

    /* renamed from: x  reason: collision with root package name */
    public HashSet<String> f20758x = new HashSet<>();

    /* renamed from: y  reason: collision with root package name */
    public ConcurrentHashMap<String, String> f20759y = new ConcurrentHashMap<>();

    /* renamed from: z  reason: collision with root package name */
    public List<Interceptor> f20760z = new ArrayList();

    public h(Context context) {
        this.f20748n = context;
        n(context.getFilesDir().getPath());
        this.f20757w.addAll(CacheExtensionConfig.f20637d);
    }

    public h a(String str) {
        this.f20758x.add(str);
        return this;
    }

    public h b(String str) {
        this.f20757w.add(str);
        return this;
    }

    public h c(String str) {
        this.f20756v.add(str);
        return this;
    }

    public void d(Interceptor interceptor) {
        if (interceptor != null) {
            this.f20760z.add(interceptor);
        }
    }

    public h e(String str) {
        this.f20754t.add(str);
        return this;
    }

    public void f() {
        g.h().t(this.f20748n);
        g.h().j(this.f20737c, this.f20736b, this.f20738d);
        g.h().v(this.f20737c, this.f20738d, this.f20740f, this.f20741g, this.f20742h, this.f20743i, this.f20744j, this.f20745k, this.f20760z);
        g.h().u(this.f20747m);
        g.h().x(this.f20735a);
        g.h().r(this.f20746l);
        g.h().s(this.f20752r);
        g.h().w(this.f20749o);
        WebCacheInterecptRequest.d().m(this.f20747m);
        WebCacheInterecptRequest.d().k(this.f20746l);
        WebCacheInterecptRequest.d().i(this.f20751q);
        WebCacheInterecptRequest.d().j(this.f20750p);
        WebCacheInterecptRequest.d().n(this.f20756v);
        WebCacheInterecptRequest.d().o(this.f20754t);
        WebCacheInterecptRequest.d().h(this.f20758x);
        WebCacheInterecptRequest.d().l(this.f20757w);
        WebCacheInterecptRequest.d().q(this.f20753s);
        WebCacheInterecptRequest.d().r(this.f20735a);
        WebCacheInterecptRequest.d().k(this.f20746l);
        WebCacheInterecptRequest.d().p(this.f20759y);
        c.j().s(this.f20747m);
    }

    public h g(boolean z11) {
        this.f20751q = z11;
        return this;
    }

    public h h(boolean z11) {
        this.f20750p = z11;
        return this;
    }

    public h i(CacheStrategy cacheStrategy) {
        this.f20746l = cacheStrategy;
        return this;
    }

    public void j(boolean z11) {
        this.f20752r = z11;
    }

    public h k(long j11) {
        this.f20740f = j11;
        return this;
    }

    public h l(boolean z11) {
        this.f20747m = z11;
        return this;
    }

    public h m(Dns dns) {
        this.f20745k = dns;
        return this;
    }

    public h n(String str) {
        this.f20737c = str;
        return this;
    }

    public h o(long j11) {
        this.f20738d = j11;
        return this;
    }

    public h p(int i11) {
        this.f20736b = i11;
        return this;
    }

    public void q(b bVar) {
        this.f20749o = bVar;
    }

    public h r(int i11) {
        this.f20739e = i11;
        return this;
    }

    public h s(long j11) {
        this.f20741g = j11;
        return this;
    }

    public h t(SSLSocketFactory sSLSocketFactory) {
        this.f20743i = sSLSocketFactory;
        return this;
    }

    public h u(boolean z11) {
        this.f20742h = z11;
        return this;
    }

    public void v(ConcurrentHashMap<String, String> concurrentHashMap) {
        if (concurrentHashMap != null) {
            this.f20759y.clear();
            this.f20759y.putAll(concurrentHashMap);
        }
    }

    public h w(boolean z11) {
        this.f20753s = z11;
        return this;
    }

    public void x(boolean z11) {
        this.f20735a = z11;
    }

    public h y(X509TrustManager x509TrustManager) {
        this.f20744j = x509TrustManager;
        return this;
    }
}
