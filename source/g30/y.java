package g30;

import android.content.Context;
import dagger.internal.b;
import q00.a;

public final class y implements b<x> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Context> f60319a;

    public y(a<Context> aVar) {
        this.f60319a = aVar;
    }

    public static y a(a<Context> aVar) {
        return new y(aVar);
    }

    public static x c(Context context) {
        return new x(context);
    }

    /* renamed from: b */
    public x get() {
        return c(this.f60319a.get());
    }
}
