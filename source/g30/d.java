package g30;

import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.e;

public final class d implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    public final a<f> f60290a;

    /* renamed from: b  reason: collision with root package name */
    public final a<e> f60291b;

    public d(a<f> aVar, a<e> aVar2) {
        this.f60290a = aVar;
        this.f60291b = aVar2;
    }

    public static d a(a<f> aVar, a<e> aVar2) {
        return new d(aVar, aVar2);
    }

    public static c c(f fVar, e eVar) {
        return new c(fVar, eVar);
    }

    /* renamed from: b */
    public c get() {
        return c(this.f60290a.get(), this.f60291b.get());
    }
}
