package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Store;

public final class RequestModule_ProvidesDispatcherFactory implements b<Dispatcher> {
    private final a<Store> storeProvider;

    public RequestModule_ProvidesDispatcherFactory(a<Store> aVar) {
        this.storeProvider = aVar;
    }

    public static RequestModule_ProvidesDispatcherFactory create(a<Store> aVar) {
        return new RequestModule_ProvidesDispatcherFactory(aVar);
    }

    public static Dispatcher providesDispatcher(Store store) {
        return (Dispatcher) d.f(RequestModule.providesDispatcher(store));
    }

    public Dispatcher get() {
        return providesDispatcher(this.storeProvider.get());
    }
}
