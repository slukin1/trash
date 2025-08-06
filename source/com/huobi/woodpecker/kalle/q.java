package com.huobi.woodpecker.kalle;

import com.huobi.woodpecker.kalle.Url;
import com.huobi.woodpecker.kalle.k;

public class q extends k {

    /* renamed from: i  reason: collision with root package name */
    public final Url f21121i;

    public static class b<T extends b<T>> extends k.a<T> {

        /* renamed from: i  reason: collision with root package name */
        public Url.a f21122i;

        public b(Url url, RequestMethod requestMethod) {
            super(requestMethod);
            Url.a c11 = url.c();
            this.f21122i = c11;
            c11.g(Kalle.b().l());
        }
    }

    public static class c extends b<c> {
        public q k() {
            return new q(this);
        }

        public c(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }
    }

    public q(b bVar) {
        super(bVar);
        this.f21121i = bVar.f21122i.j();
    }

    public static c m(Url url, RequestMethod requestMethod) {
        return new c(url, requestMethod);
    }

    public l d() {
        throw new AssertionError("It should not be called.");
    }

    public i f() {
        return this.f21121i.g();
    }

    public Url l() {
        return this.f21121i;
    }
}
