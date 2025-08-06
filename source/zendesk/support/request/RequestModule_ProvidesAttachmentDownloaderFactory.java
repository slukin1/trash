package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.support.request.AttachmentDownloaderComponent;

public final class RequestModule_ProvidesAttachmentDownloaderFactory implements b<AttachmentDownloaderComponent.AttachmentDownloader> {
    private final a<AttachmentDownloadService> attachmentToDiskServiceProvider;
    private final a<zendesk.belvedere.a> belvedereProvider;

    public RequestModule_ProvidesAttachmentDownloaderFactory(a<zendesk.belvedere.a> aVar, a<AttachmentDownloadService> aVar2) {
        this.belvedereProvider = aVar;
        this.attachmentToDiskServiceProvider = aVar2;
    }

    public static RequestModule_ProvidesAttachmentDownloaderFactory create(a<zendesk.belvedere.a> aVar, a<AttachmentDownloadService> aVar2) {
        return new RequestModule_ProvidesAttachmentDownloaderFactory(aVar, aVar2);
    }

    public static AttachmentDownloaderComponent.AttachmentDownloader providesAttachmentDownloader(zendesk.belvedere.a aVar, Object obj) {
        return (AttachmentDownloaderComponent.AttachmentDownloader) d.f(RequestModule.providesAttachmentDownloader(aVar, (AttachmentDownloadService) obj));
    }

    public AttachmentDownloaderComponent.AttachmentDownloader get() {
        return providesAttachmentDownloader(this.belvedereProvider.get(), this.attachmentToDiskServiceProvider.get());
    }
}
