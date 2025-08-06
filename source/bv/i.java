package bv;

import com.huobi.woodpecker.kalle.RequestMethod;
import com.huobi.woodpecker.kalle.Url;
import com.huobi.woodpecker.kalle.d;
import com.huobi.woodpecker.kalle.q;
import com.huobi.woodpecker.kalle.simple.Callback;
import com.huobi.woodpecker.kalle.simple.cache.CacheMode;

public class i extends q implements g {

    /* renamed from: j  reason: collision with root package name */
    public final CacheMode f19417j;

    /* renamed from: k  reason: collision with root package name */
    public final String f19418k;

    /* renamed from: l  reason: collision with root package name */
    public final d f19419l;

    public static class b extends q.b<b> {

        /* renamed from: j  reason: collision with root package name */
        public CacheMode f19420j;

        /* renamed from: k  reason: collision with root package name */
        public String f19421k;

        /* renamed from: l  reason: collision with root package name */
        public d f19422l;

        public b n(String str) {
            this.f19421k = str;
            return this;
        }

        public b o(CacheMode cacheMode) {
            this.f19420j = cacheMode;
            return this;
        }

        public b p(d dVar) {
            this.f19422l = dVar;
            return this;
        }

        public <S, F> d q(Callback<S, F> callback) {
            return e.b().d(new i(this), callback);
        }

        public b(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }
    }

    public static b n(Url url, RequestMethod requestMethod) {
        return new b(url, requestMethod);
    }

    public CacheMode a() {
        return this.f19417j;
    }

    public String b() {
        return this.f19418k;
    }

    public d converter() {
        return this.f19419l;
    }

    public i(b bVar) {
        super(bVar);
        this.f19417j = bVar.f19420j == null ? CacheMode.HTTP : bVar.f19420j;
        this.f19418k = bVar.f19421k;
        this.f19419l = bVar.f19422l;
    }
}
