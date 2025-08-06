package zendesk.support.requestlist;

import com.squareup.picasso.Picasso;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class RequestListViewModule_ViewFactory implements b<RequestListView> {
    private final RequestListViewModule module;
    private final a<Picasso> picassoProvider;

    public RequestListViewModule_ViewFactory(RequestListViewModule requestListViewModule, a<Picasso> aVar) {
        this.module = requestListViewModule;
        this.picassoProvider = aVar;
    }

    public static RequestListViewModule_ViewFactory create(RequestListViewModule requestListViewModule, a<Picasso> aVar) {
        return new RequestListViewModule_ViewFactory(requestListViewModule, aVar);
    }

    public static RequestListView view(RequestListViewModule requestListViewModule, Picasso picasso) {
        return (RequestListView) d.f(requestListViewModule.view(picasso));
    }

    public RequestListView get() {
        return view(this.module, this.picassoProvider.get());
    }
}
