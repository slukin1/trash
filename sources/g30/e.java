package g30;

import dagger.internal.b;
import q00.a;
import zendesk.classic.messaging.components.DateProvider;

public final class e implements b<zendesk.classic.messaging.e> {

    /* renamed from: a  reason: collision with root package name */
    public final a<DateProvider> f60292a;

    public e(a<DateProvider> aVar) {
        this.f60292a = aVar;
    }

    public static e a(a<DateProvider> aVar) {
        return new e(aVar);
    }

    public static zendesk.classic.messaging.e c(DateProvider dateProvider) {
        return new zendesk.classic.messaging.e(dateProvider);
    }

    /* renamed from: b */
    public zendesk.classic.messaging.e get() {
        return c(this.f60292a.get());
    }
}
