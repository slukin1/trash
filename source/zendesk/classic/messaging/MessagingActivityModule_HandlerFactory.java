package zendesk.classic.messaging;

import android.os.Handler;
import dagger.internal.b;
import dagger.internal.d;
import g30.h;

public final class MessagingActivityModule_HandlerFactory implements b<Handler> {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final MessagingActivityModule_HandlerFactory f62365a = new MessagingActivityModule_HandlerFactory();
    }

    public static MessagingActivityModule_HandlerFactory a() {
        return a.f62365a;
    }

    public static Handler c() {
        return (Handler) d.f(h.c());
    }

    /* renamed from: b */
    public Handler get() {
        return c();
    }
}
