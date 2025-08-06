package zendesk.classic.messaging;

import dagger.internal.b;
import dagger.internal.d;
import g30.h;
import zendesk.classic.messaging.components.DateProvider;

public final class MessagingActivityModule_DateProviderFactory implements b<DateProvider> {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final MessagingActivityModule_DateProviderFactory f62364a = new MessagingActivityModule_DateProviderFactory();
    }

    public static MessagingActivityModule_DateProviderFactory a() {
        return a.f62364a;
    }

    public static DateProvider b() {
        return (DateProvider) d.f(h.b());
    }

    /* renamed from: c */
    public DateProvider get() {
        return b();
    }
}
