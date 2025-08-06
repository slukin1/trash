package com.huobi.kalle;

import com.huobi.kalle.Url;
import com.huobi.kalle.k;

public class p extends k {

    /* renamed from: i  reason: collision with root package name */
    public final Url f74763i;

    public static class b<T extends b<T>> extends k.a<T> {

        /* renamed from: i  reason: collision with root package name */
        public Url.a f74764i;

        public b(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            Url.a c11 = url.c();
            this.f74764i = c11;
            c11.g(Kalle.a().l());
        }
    }

    public static class c extends b<c> {
        public p k() {
            return new p(this);
        }

        public c(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }
    }

    public p(b bVar) {
        super(bVar);
        this.f74763i = bVar.f74764i.i();
    }

    public static c m(Url url, RequestMethod requestMethod) {
        return new c(url, requestMethod);
    }

    public l d() {
        throw new AssertionError("It should not be called.");
    }

    public i f() {
        return this.f74763i.g();
    }

    public Url l() {
        return this.f74763i;
    }
}
