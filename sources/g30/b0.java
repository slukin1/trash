package g30;

import android.os.Handler;
import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.e;

public final class b0 implements b<a0> {

    /* renamed from: a  reason: collision with root package name */
    public final a<f> f60285a;

    /* renamed from: b  reason: collision with root package name */
    public final a<Handler> f60286b;

    /* renamed from: c  reason: collision with root package name */
    public final a<e> f60287c;

    public b0(a<f> aVar, a<Handler> aVar2, a<e> aVar3) {
        this.f60285a = aVar;
        this.f60286b = aVar2;
        this.f60287c = aVar3;
    }

    public static b0 a(a<f> aVar, a<Handler> aVar2, a<e> aVar3) {
        return new b0(aVar, aVar2, aVar3);
    }

    public static a0 c(f fVar, Handler handler, e eVar) {
        return new a0(fVar, handler, eVar);
    }

    /* renamed from: b */
    public a0 get() {
        return c(this.f60285a.get(), this.f60286b.get(), this.f60287c.get());
    }
}
