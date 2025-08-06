package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import java.util.List;
import q00.a;
import zendesk.support.suas.Reducer;
import zendesk.support.suas.Store;

public final class RequestModule_ProvidesStoreFactory implements b<Store> {
    private final a<AsyncMiddleware> asyncMiddlewareProvider;
    private final a<List<Reducer>> reducersProvider;

    public RequestModule_ProvidesStoreFactory(a<List<Reducer>> aVar, a<AsyncMiddleware> aVar2) {
        this.reducersProvider = aVar;
        this.asyncMiddlewareProvider = aVar2;
    }

    public static RequestModule_ProvidesStoreFactory create(a<List<Reducer>> aVar, a<AsyncMiddleware> aVar2) {
        return new RequestModule_ProvidesStoreFactory(aVar, aVar2);
    }

    public static Store providesStore(List<Reducer> list, Object obj) {
        return (Store) d.f(RequestModule.providesStore(list, (AsyncMiddleware) obj));
    }

    public Store get() {
        return providesStore(this.reducersProvider.get(), this.asyncMiddlewareProvider.get());
    }
}
