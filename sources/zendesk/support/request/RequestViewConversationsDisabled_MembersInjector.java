package zendesk.support.request;

import com.squareup.picasso.Picasso;
import oz.a;
import zendesk.support.suas.Store;

public final class RequestViewConversationsDisabled_MembersInjector implements a<RequestViewConversationsDisabled> {
    private final q00.a<ActionFactory> afProvider;
    private final q00.a<Picasso> picassoProvider;
    private final q00.a<Store> storeProvider;

    public RequestViewConversationsDisabled_MembersInjector(q00.a<Store> aVar, q00.a<ActionFactory> aVar2, q00.a<Picasso> aVar3) {
        this.storeProvider = aVar;
        this.afProvider = aVar2;
        this.picassoProvider = aVar3;
    }

    public static a<RequestViewConversationsDisabled> create(q00.a<Store> aVar, q00.a<ActionFactory> aVar2, q00.a<Picasso> aVar3) {
        return new RequestViewConversationsDisabled_MembersInjector(aVar, aVar2, aVar3);
    }

    public static void injectAf(RequestViewConversationsDisabled requestViewConversationsDisabled, Object obj) {
        requestViewConversationsDisabled.f62980af = (ActionFactory) obj;
    }

    public static void injectPicasso(RequestViewConversationsDisabled requestViewConversationsDisabled, Picasso picasso) {
        requestViewConversationsDisabled.picasso = picasso;
    }

    public static void injectStore(RequestViewConversationsDisabled requestViewConversationsDisabled, Store store) {
        requestViewConversationsDisabled.store = store;
    }

    public void injectMembers(RequestViewConversationsDisabled requestViewConversationsDisabled) {
        injectStore(requestViewConversationsDisabled, this.storeProvider.get());
        injectAf(requestViewConversationsDisabled, this.afProvider.get());
        injectPicasso(requestViewConversationsDisabled, this.picassoProvider.get());
    }
}
