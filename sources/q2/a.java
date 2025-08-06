package q2;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.huochat.community.network.domain.DomainTool;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import m2.e;
import p2.c;
import w2.b;

public class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public Context f16382a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16383b = true;

    /* renamed from: c  reason: collision with root package name */
    public p2.a f16384c = new p2.a(e.f16150a, b.f16740a, "");

    /* renamed from: d  reason: collision with root package name */
    public String[] f16385d = e.f16151b;

    /* renamed from: e  reason: collision with root package name */
    public p2.b f16386e;

    /* renamed from: f  reason: collision with root package name */
    public String f16387f;

    /* renamed from: g  reason: collision with root package name */
    public String f16388g = DomainTool.DOMAIN_PREFIX_HTTP;

    /* renamed from: h  reason: collision with root package name */
    public String f16389h = "";

    /* renamed from: i  reason: collision with root package name */
    public int f16390i = DefaultControlDispatcher.DEFAULT_FAST_FORWARD_MS;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16391j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f16392k = false;

    /* renamed from: l  reason: collision with root package name */
    public boolean f16393l = false;

    /* renamed from: m  reason: collision with root package name */
    public com.alibaba.sdk.android.httpdns.c.a f16394m;

    /* renamed from: n  reason: collision with root package name */
    public ExecutorService f16395n = w2.c.c();

    /* renamed from: o  reason: collision with root package name */
    public ExecutorService f16396o = w2.c.d();

    public a(Context context, String str) {
        this.f16382a = context;
        this.f16387f = str;
        this.f16386e = new p2.b(this);
        com.alibaba.sdk.android.httpdns.c.a aVar = new com.alibaba.sdk.android.httpdns.c.a();
        aVar.b(context, this);
        this.f16394m = aVar;
    }

    public void a(SharedPreferences sharedPreferences) {
        this.f16383b = sharedPreferences.getBoolean("enable", true);
    }

    public void b(SharedPreferences.Editor editor) {
        editor.putBoolean("enable", this.f16383b);
    }

    public ExecutorService c() {
        return this.f16395n;
    }

    public p2.a d() {
        return this.f16384c;
    }

    public p2.b e() {
        return this.f16386e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f16383b == aVar.f16383b && this.f16390i == aVar.f16390i && w2.a.m(this.f16382a, aVar.f16382a)) {
            p2.a aVar2 = this.f16384c;
            if (w2.a.m(aVar2, aVar2) && w2.a.m(this.f16387f, aVar.f16387f) && w2.a.m(this.f16388g, aVar.f16388g) && w2.a.m(this.f16389h, aVar.f16389h) && w2.a.m(this.f16395n, aVar.f16395n)) {
                return true;
            }
        }
        return false;
    }

    public void f() {
        com.alibaba.sdk.android.httpdns.c.a aVar = this.f16394m;
        if (aVar != null) {
            aVar.c(this.f16382a, this);
        }
    }

    public boolean g(String str) {
        if (this.f16389h.equals(str)) {
            return false;
        }
        this.f16389h = str;
        f();
        return true;
    }

    public boolean h(boolean z11) {
        String str = this.f16388g;
        this.f16388g = z11 ? DomainTool.DOMAIN_PREFIX : DomainTool.DOMAIN_PREFIX_HTTP;
        if (!this.f16388g.equals(str)) {
            f();
        }
        return !this.f16388g.equals(str);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f16382a, Boolean.valueOf(this.f16383b), this.f16387f, this.f16388g, this.f16386e, this.f16389h, Integer.valueOf(this.f16390i), this.f16395n, this.f16384c});
    }

    public c[] i() {
        return new c[]{this, this.f16386e};
    }

    public ExecutorService j() {
        return this.f16396o;
    }

    public void k(boolean z11) {
        this.f16391j = z11;
    }

    public String[] l() {
        return this.f16385d;
    }

    public String m() {
        return this.f16388g;
    }

    public void n(boolean z11) {
        this.f16392k = z11;
    }

    public boolean o() {
        return w2.a.e(this.f16389h, this.f16386e.g());
    }

    public void p(boolean z11) {
        this.f16393l = z11;
    }

    public boolean q() {
        return this.f16384c.d(this.f16386e);
    }

    public boolean r() {
        return this.f16393l;
    }

    public String s() {
        return this.f16387f;
    }

    public Context t() {
        return this.f16382a;
    }

    public String u() {
        return this.f16389h;
    }

    public int v() {
        return this.f16390i;
    }

    public boolean w() {
        return this.f16383b && !this.f16391j && !this.f16392k;
    }

    public void x(boolean z11) {
        if (this.f16383b != z11) {
            this.f16383b = z11;
            f();
        }
    }

    public void y(int i11) {
        if (this.f16390i != i11) {
            this.f16390i = i11;
            f();
        }
    }
}
