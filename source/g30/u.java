package g30;

import android.content.Context;
import android.content.res.Resources;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class u implements b<Resources> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Context> f60313a;

    public u(a<Context> aVar) {
        this.f60313a = aVar;
    }

    public static u a(a<Context> aVar) {
        return new u(aVar);
    }

    public static Resources c(Context context) {
        return (Resources) d.f(r.c(context));
    }

    /* renamed from: b */
    public Resources get() {
        return c(this.f60313a.get());
    }
}
