package bv;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.RequestMethod;
import com.huobi.woodpecker.kalle.Url;
import com.huobi.woodpecker.kalle.c;
import com.huobi.woodpecker.kalle.d;
import com.huobi.woodpecker.kalle.simple.Callback;
import com.huobi.woodpecker.kalle.simple.cache.CacheMode;

public class f extends c implements g {

    /* renamed from: l  reason: collision with root package name */
    public final CacheMode f19401l;

    /* renamed from: m  reason: collision with root package name */
    public final String f19402m;

    /* renamed from: n  reason: collision with root package name */
    public final d f19403n;

    public static class b extends c.b<b> {

        /* renamed from: l  reason: collision with root package name */
        public CacheMode f19404l;

        /* renamed from: m  reason: collision with root package name */
        public String f19405m;

        /* renamed from: n  reason: collision with root package name */
        public d f19406n;

        public b r(d dVar) {
            this.f19406n = dVar;
            return this;
        }

        public <S, F> d s(Callback<S, F> callback) {
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
        return this.f19401l;
    }

    public String b() {
        return this.f19402m;
    }

    public d converter() {
        return this.f19403n;
    }

    public f(b bVar) {
        super(bVar);
        this.f19401l = bVar.f19404l == null ? CacheMode.HTTP : bVar.f19404l;
        this.f19402m = TextUtils.isEmpty(bVar.f19405m) ? l().toString() : bVar.f19405m;
        this.f19403n = bVar.f19406n;
    }
}
