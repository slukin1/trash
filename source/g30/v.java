package g30;

import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.k;
import zendesk.classic.messaging.l;

public final class v implements b<l> {

    /* renamed from: a  reason: collision with root package name */
    public final a<k> f60314a;

    public v(a<k> aVar) {
        this.f60314a = aVar;
    }

    public static v a(a<k> aVar) {
        return new v(aVar);
    }

    public static l c(Object obj) {
        return new l((k) obj);
    }

    /* renamed from: b */
    public l get() {
        return c(this.f60314a.get());
    }
}
