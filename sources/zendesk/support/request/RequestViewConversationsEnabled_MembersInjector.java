package zendesk.support.request;

import com.squareup.picasso.Picasso;
import oz.a;
import zendesk.support.suas.Store;

public final class RequestViewConversationsEnabled_MembersInjector implements a<RequestViewConversationsEnabled> {
    private final q00.a<ActionFactory> afProvider;
    private final q00.a<CellFactory> cellFactoryProvider;
    private final q00.a<Picasso> picassoProvider;
    private final q00.a<Store> storeProvider;

    public RequestViewConversationsEnabled_MembersInjector(q00.a<Store> aVar, q00.a<ActionFactory> aVar2, q00.a<CellFactory> aVar3, q00.a<Picasso> aVar4) {
        this.storeProvider = aVar;
        this.afProvider = aVar2;
        this.cellFactoryProvider = aVar3;
        this.picassoProvider = aVar4;
    }

    public static a<RequestViewConversationsEnabled> create(q00.a<Store> aVar, q00.a<ActionFactory> aVar2, q00.a<CellFactory> aVar3, q00.a<Picasso> aVar4) {
        return new RequestViewConversationsEnabled_MembersInjector(aVar, aVar2, aVar3, aVar4);
    }

    public static void injectAf(RequestViewConversationsEnabled requestViewConversationsEnabled, Object obj) {
        requestViewConversationsEnabled.f62981af = (ActionFactory) obj;
    }

    public static void injectCellFactory(RequestViewConversationsEnabled requestViewConversationsEnabled, Object obj) {
        requestViewConversationsEnabled.cellFactory = (CellFactory) obj;
    }

    public static void injectPicasso(RequestViewConversationsEnabled requestViewConversationsEnabled, Picasso picasso) {
        requestViewConversationsEnabled.picasso = picasso;
    }

    public static void injectStore(RequestViewConversationsEnabled requestViewConversationsEnabled, Store store) {
        requestViewConversationsEnabled.store = store;
    }

    public void injectMembers(RequestViewConversationsEnabled requestViewConversationsEnabled) {
        injectStore(requestViewConversationsEnabled, this.storeProvider.get());
        injectAf(requestViewConversationsEnabled, this.afProvider.get());
        injectCellFactory(requestViewConversationsEnabled, this.cellFactoryProvider.get());
        injectPicasso(requestViewConversationsEnabled, this.picassoProvider.get());
    }
}
