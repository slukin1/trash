package g30;

import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.h;

public final class j implements b<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final a<h> f60296a;

    public j(a<h> aVar) {
        this.f60296a = aVar;
    }

    public static j a(a<h> aVar) {
        return new j(aVar);
    }

    public static boolean c(Object obj) {
        return h.d((h) obj);
    }

    /* renamed from: b */
    public Boolean get() {
        return Boolean.valueOf(c(this.f60296a.get()));
    }
}
