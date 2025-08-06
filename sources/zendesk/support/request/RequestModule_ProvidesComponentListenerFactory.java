package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class RequestModule_ProvidesComponentListenerFactory implements b<HeadlessComponentListener> {
    private final a<AttachmentDownloaderComponent> attachmentDownloaderProvider;
    private final a<ComponentPersistence> persistenceProvider;
    private final a<ComponentUpdateActionHandlers> updatesComponentProvider;

    public RequestModule_ProvidesComponentListenerFactory(a<ComponentPersistence> aVar, a<AttachmentDownloaderComponent> aVar2, a<ComponentUpdateActionHandlers> aVar3) {
        this.persistenceProvider = aVar;
        this.attachmentDownloaderProvider = aVar2;
        this.updatesComponentProvider = aVar3;
    }

    public static RequestModule_ProvidesComponentListenerFactory create(a<ComponentPersistence> aVar, a<AttachmentDownloaderComponent> aVar2, a<ComponentUpdateActionHandlers> aVar3) {
        return new RequestModule_ProvidesComponentListenerFactory(aVar, aVar2, aVar3);
    }

    public static HeadlessComponentListener providesComponentListener(Object obj, Object obj2, Object obj3) {
        return (HeadlessComponentListener) d.f(RequestModule.providesComponentListener((ComponentPersistence) obj, (AttachmentDownloaderComponent) obj2, (ComponentUpdateActionHandlers) obj3));
    }

    public HeadlessComponentListener get() {
        return providesComponentListener(this.persistenceProvider.get(), this.attachmentDownloaderProvider.get(), this.updatesComponentProvider.get());
    }
}
