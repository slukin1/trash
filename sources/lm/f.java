package lm;

import android.text.TextUtils;
import com.huobi.kalle.RequestMethod;
import com.huobi.kalle.Url;
import com.huobi.kalle.b;
import com.huobi.kalle.c;
import com.huobi.kalle.simple.Callback;
import com.huobi.kalle.simple.cache.CacheMode;

public class f extends com.huobi.kalle.b implements g {

    /* renamed from: l  reason: collision with root package name */
    public final CacheMode f76264l;

    /* renamed from: m  reason: collision with root package name */
    public final String f76265m;

    /* renamed from: n  reason: collision with root package name */
    public final d f76266n;

    public static class b extends b.C0799b<b> {

        /* renamed from: l  reason: collision with root package name */
        public CacheMode f76267l;

        /* renamed from: m  reason: collision with root package name */
        public String f76268m;

        /* renamed from: n  reason: collision with root package name */
        public d f76269n;

        public b r(String str) {
            this.f76268m = str;
            return this;
        }

        public b s(CacheMode cacheMode) {
            this.f76267l = cacheMode;
            return this;
        }

        public b t(d dVar) {
            this.f76269n = dVar;
            return this;
        }

        public <S, F> c u(Callback<S, F> callback) {
            return e.b().c(new f(this), callback);
        }

        public b(Url url, RequestMethod requestMethod) {
            super(url, requestMethod);
        }
    }

    public static b n(Url url, RequestMethod requestMethod) {
        return new b(url, requestMethod);
    }

    public CacheMode a() {
        return this.f76264l;
    }

    public String b() {
        return this.f76265m;
    }

    public d converter() {
        return this.f76266n;
    }

    public f(b bVar) {
        super(bVar);
        this.f76264l = bVar.f76267l == null ? CacheMode.HTTP : bVar.f76267l;
        this.f76265m = TextUtils.isEmpty(bVar.f76268m) ? l().toString() : bVar.f76268m;
        this.f76266n = bVar.f76269n;
    }
}
