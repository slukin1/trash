package zendesk.support.request;

import com.squareup.picasso.Picasso;
import oz.a;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.suas.Store;

public final class RequestActivity_MembersInjector implements a<RequestActivity> {
    private final q00.a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final q00.a<ActionFactory> afProvider;
    private final q00.a<HeadlessComponentListener> headlessComponentListenerProvider;
    private final q00.a<Picasso> picassoProvider;
    private final q00.a<Store> storeProvider;

    public RequestActivity_MembersInjector(q00.a<Store> aVar, q00.a<ActionFactory> aVar2, q00.a<HeadlessComponentListener> aVar3, q00.a<Picasso> aVar4, q00.a<ActionHandlerRegistry> aVar5) {
        this.storeProvider = aVar;
        this.afProvider = aVar2;
        this.headlessComponentListenerProvider = aVar3;
        this.picassoProvider = aVar4;
        this.actionHandlerRegistryProvider = aVar5;
    }

    public static a<RequestActivity> create(q00.a<Store> aVar, q00.a<ActionFactory> aVar2, q00.a<HeadlessComponentListener> aVar3, q00.a<Picasso> aVar4, q00.a<ActionHandlerRegistry> aVar5) {
        return new RequestActivity_MembersInjector(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static void injectActionHandlerRegistry(RequestActivity requestActivity, ActionHandlerRegistry actionHandlerRegistry) {
        requestActivity.actionHandlerRegistry = actionHandlerRegistry;
    }

    public static void injectAf(RequestActivity requestActivity, Object obj) {
        requestActivity.f62979af = (ActionFactory) obj;
    }

    public static void injectHeadlessComponentListener(RequestActivity requestActivity, Object obj) {
        requestActivity.headlessComponentListener = (HeadlessComponentListener) obj;
    }

    public static void injectPicasso(RequestActivity requestActivity, Picasso picasso) {
        requestActivity.picasso = picasso;
    }

    public static void injectStore(RequestActivity requestActivity, Store store) {
        requestActivity.store = store;
    }

    public void injectMembers(RequestActivity requestActivity) {
        injectStore(requestActivity, this.storeProvider.get());
        injectAf(requestActivity, this.afProvider.get());
        injectHeadlessComponentListener(requestActivity, this.headlessComponentListenerProvider.get());
        injectPicasso(requestActivity, this.picassoProvider.get());
        injectActionHandlerRegistry(requestActivity, this.actionHandlerRegistryProvider.get());
    }
}
