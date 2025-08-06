package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.support.request.AttachmentDownloaderComponent;
import zendesk.support.suas.Dispatcher;

public final class RequestModule_ProvidesAttachmentDownloaderComponentFactory implements b<AttachmentDownloaderComponent> {
    private final a<ActionFactory> actionFactoryProvider;
    private final a<AttachmentDownloaderComponent.AttachmentDownloader> attachmentDownloaderProvider;
    private final a<Dispatcher> dispatcherProvider;

    public RequestModule_ProvidesAttachmentDownloaderComponentFactory(a<Dispatcher> aVar, a<ActionFactory> aVar2, a<AttachmentDownloaderComponent.AttachmentDownloader> aVar3) {
        this.dispatcherProvider = aVar;
        this.actionFactoryProvider = aVar2;
        this.attachmentDownloaderProvider = aVar3;
    }

    public static RequestModule_ProvidesAttachmentDownloaderComponentFactory create(a<Dispatcher> aVar, a<ActionFactory> aVar2, a<AttachmentDownloaderComponent.AttachmentDownloader> aVar3) {
        return new RequestModule_ProvidesAttachmentDownloaderComponentFactory(aVar, aVar2, aVar3);
    }

    public static AttachmentDownloaderComponent providesAttachmentDownloaderComponent(Dispatcher dispatcher, Object obj, Object obj2) {
        return (AttachmentDownloaderComponent) d.f(RequestModule.providesAttachmentDownloaderComponent(dispatcher, (ActionFactory) obj, (AttachmentDownloaderComponent.AttachmentDownloader) obj2));
    }

    public AttachmentDownloaderComponent get() {
        return providesAttachmentDownloaderComponent(this.dispatcherProvider.get(), this.actionFactoryProvider.get(), this.attachmentDownloaderProvider.get());
    }
}
