package zendesk.classic.messaging.ui;

import com.squareup.picasso.Picasso;
import dagger.internal.b;
import q00.a;

public final class d implements b<c> {

    /* renamed from: a  reason: collision with root package name */
    public final a<Picasso> f62781a;

    public d(a<Picasso> aVar) {
        this.f62781a = aVar;
    }

    public static d a(a<Picasso> aVar) {
        return new d(aVar);
    }

    public static c c(Picasso picasso) {
        return new c(picasso);
    }

    /* renamed from: b */
    public c get() {
        return c(this.f62781a.get());
    }
}
