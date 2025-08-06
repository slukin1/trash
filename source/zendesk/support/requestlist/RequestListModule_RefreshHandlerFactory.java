package zendesk.support.requestlist;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class RequestListModule_RefreshHandlerFactory implements b<RequestListSyncHandler> {
    private final a<RequestListPresenter> presenterProvider;

    public RequestListModule_RefreshHandlerFactory(a<RequestListPresenter> aVar) {
        this.presenterProvider = aVar;
    }

    public static RequestListModule_RefreshHandlerFactory create(a<RequestListPresenter> aVar) {
        return new RequestListModule_RefreshHandlerFactory(aVar);
    }

    public static RequestListSyncHandler refreshHandler(Object obj) {
        return (RequestListSyncHandler) d.f(RequestListModule.refreshHandler((RequestListPresenter) obj));
    }

    public RequestListSyncHandler get() {
        return refreshHandler(this.presenterProvider.get());
    }
}
