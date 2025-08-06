package com.huobi.woodpecker.kalle;

import com.huobi.woodpecker.kalle.Url;
import com.huobi.woodpecker.kalle.i;
import com.huobi.woodpecker.kalle.k;

public class c extends k {

    /* renamed from: i  reason: collision with root package name */
    public final Url f21045i;

    /* renamed from: j  reason: collision with root package name */
    public final l f21046j;

    /* renamed from: k  reason: collision with root package name */
    public final i f21047k;

    public static class b<T extends b<T>> extends k.a<T> {

        /* renamed from: i  reason: collision with root package name */
        public Url.a f21048i;

        /* renamed from: j  reason: collision with root package name */
        public i.b f21049j;

        /* renamed from: k  reason: collision with root package name */
        public l f21050k;

        public b(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            this.f21048i = url.c();
            i.b f11 = i.f();
            this.f21049j = f11;
            f11.b(Kalle.b().l());
        }

        public T m(l lVar) {
            this.f21050k = lVar;
            return this;
        }

        public T n(i iVar) {
            this.f21049j.g(iVar);
            return this;
        }
    }

    /* renamed from: com.huobi.woodpecker.kalle.c$c  reason: collision with other inner class name */
    public static class C0162c extends b<C0162c> {
        public c o() {
            return new c(this);
        }

        public C0162c(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }
    }

    public c(b bVar) {
        super(bVar);
        this.f21045i = bVar.f21048i.j();
        i e11 = bVar.f21049j.e();
        this.f21047k = e11;
        this.f21046j = bVar.f21050k == null ? e11.d() ? e11.g() : e11.h() : bVar.f21050k;
    }

    public static C0162c m(Url url, RequestMethod requestMethod) {
        return new C0162c(url, requestMethod);
    }

    public l d() {
        return this.f21046j;
    }

    public i f() {
        return this.f21047k;
    }

    public Url l() {
        return this.f21045i;
    }
}
