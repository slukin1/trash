package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory implements b<AcceptHeaderInterceptor> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory INSTANCE = new ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory();

        private InstanceHolder() {
        }
    }

    public static ZendeskNetworkModule_ProvidesAcceptHeaderInterceptorFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AcceptHeaderInterceptor providesAcceptHeaderInterceptor() {
        return (AcceptHeaderInterceptor) d.f(ZendeskNetworkModule.providesAcceptHeaderInterceptor());
    }

    public AcceptHeaderInterceptor get() {
        return providesAcceptHeaderInterceptor();
    }
}
