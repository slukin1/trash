package g30;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import zendesk.belvedere.a;

public final class s implements b<a> {

    /* renamed from: a  reason: collision with root package name */
    public final q00.a<Context> f60311a;

    public s(q00.a<Context> aVar) {
        this.f60311a = aVar;
    }

    public static a a(Context context) {
        return (a) d.f(r.a(context));
    }

    public static s b(q00.a<Context> aVar) {
        return new s(aVar);
    }

    /* renamed from: c */
    public a get() {
        return a(this.f60311a.get());
    }
}
