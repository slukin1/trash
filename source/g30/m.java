package g30;

import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.j;

public final class m implements b<l> {

    /* renamed from: a  reason: collision with root package name */
    public final a<j> f60301a;

    public m(a<j> aVar) {
        this.f60301a = aVar;
    }

    public static m a(a<j> aVar) {
        return new m(aVar);
    }

    public static l c(Object obj) {
        return new l((j) obj);
    }

    /* renamed from: b */
    public l get() {
        return c(this.f60301a.get());
    }
}
