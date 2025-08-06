package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;

public final class RequestModule_ProvidesAsyncMiddlewareFactory implements b<AsyncMiddleware> {

    public static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final RequestModule_ProvidesAsyncMiddlewareFactory INSTANCE = new RequestModule_ProvidesAsyncMiddlewareFactory();

        private InstanceHolder() {
        }
    }

    public static RequestModule_ProvidesAsyncMiddlewareFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static AsyncMiddleware providesAsyncMiddleware() {
        return (AsyncMiddleware) d.f(RequestModule.providesAsyncMiddleware());
    }

    public AsyncMiddleware get() {
        return providesAsyncMiddleware();
    }
}
