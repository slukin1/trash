package com.huobi.kalle;

import com.huobi.kalle.Url;
import com.huobi.kalle.i;
import com.huobi.kalle.k;

public class b extends k {

    /* renamed from: i  reason: collision with root package name */
    public final Url f74687i;

    /* renamed from: j  reason: collision with root package name */
    public final l f74688j;

    /* renamed from: k  reason: collision with root package name */
    public final i f74689k;

    /* renamed from: com.huobi.kalle.b$b  reason: collision with other inner class name */
    public static class C0799b<T extends C0799b<T>> extends k.a<T> {

        /* renamed from: i  reason: collision with root package name */
        public Url.a f74690i;

        /* renamed from: j  reason: collision with root package name */
        public i.b f74691j;

        /* renamed from: k  reason: collision with root package name */
        public l f74692k;

        public C0799b(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            this.f74690i = url.c();
            i.b f11 = i.f();
            this.f74691j = f11;
            f11.b(Kalle.a().l());
        }

        public T m(l lVar) {
            this.f74692k = lVar;
            return this;
        }

        public T n(i iVar) {
            this.f74691j.g(iVar);
            return this;
        }
    }

    public static class c extends C0799b<c> {
        public b o() {
            return new b(this);
        }

        public c(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }
    }

    public b(C0799b bVar) {
        super(bVar);
        this.f74687i = bVar.f74690i.i();
        i e11 = bVar.f74691j.e();
        this.f74689k = e11;
        this.f74688j = bVar.f74692k == null ? e11.d() ? e11.g() : e11.h() : bVar.f74692k;
    }

    public static c m(Url url, RequestMethod requestMethod) {
        return new c(url, requestMethod);
    }

    public l d() {
        return this.f74688j;
    }

    public i f() {
        return this.f74689k;
    }

    public Url l() {
        return this.f74687i;
    }
}
