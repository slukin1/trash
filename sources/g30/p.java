package g30;

import android.content.Context;
import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.j;

public final class p implements b<j> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Context> f60305a;

    /* renamed from: b  reason: collision with root package name */
    public final a<x> f60306b;

    public p(a<Context> aVar, a<x> aVar2) {
        this.f60305a = aVar;
        this.f60306b = aVar2;
    }

    public static p a(a<Context> aVar, a<x> aVar2) {
        return new p(aVar, aVar2);
    }

    public static j c(Context context, Object obj) {
        return new j(context, (x) obj);
    }

    /* renamed from: b */
    public j get() {
        return c(this.f60305a.get(), this.f60306b.get());
    }
}
