package zendesk.support.requestlist;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class RequestListModule_PresenterFactory implements b<RequestListPresenter> {
    private final a<RequestListModel> modelProvider;
    private final RequestListModule module;

    public RequestListModule_PresenterFactory(RequestListModule requestListModule, a<RequestListModel> aVar) {
        this.module = requestListModule;
        this.modelProvider = aVar;
    }

    public static RequestListModule_PresenterFactory create(RequestListModule requestListModule, a<RequestListModel> aVar) {
        return new RequestListModule_PresenterFactory(requestListModule, aVar);
    }

    public static RequestListPresenter presenter(RequestListModule requestListModule, Object obj) {
        return (RequestListPresenter) d.f(requestListModule.presenter((RequestListModel) obj));
    }

    public RequestListPresenter get() {
        return presenter(this.module, this.modelProvider.get());
    }
}
