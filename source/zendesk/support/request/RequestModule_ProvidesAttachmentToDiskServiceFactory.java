package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
import q00.a;

public final class RequestModule_ProvidesAttachmentToDiskServiceFactory implements b<AttachmentDownloadService> {
    private final a<ExecutorService> executorProvider;
    private final a<OkHttpClient> okHttpClientProvider;

    public RequestModule_ProvidesAttachmentToDiskServiceFactory(a<OkHttpClient> aVar, a<ExecutorService> aVar2) {
        this.okHttpClientProvider = aVar;
        this.executorProvider = aVar2;
    }

    public static RequestModule_ProvidesAttachmentToDiskServiceFactory create(a<OkHttpClient> aVar, a<ExecutorService> aVar2) {
        return new RequestModule_ProvidesAttachmentToDiskServiceFactory(aVar, aVar2);
    }

    public static AttachmentDownloadService providesAttachmentToDiskService(OkHttpClient okHttpClient, ExecutorService executorService) {
        return (AttachmentDownloadService) d.f(RequestModule.providesAttachmentToDiskService(okHttpClient, executorService));
    }

    public AttachmentDownloadService get() {
        return providesAttachmentToDiskService(this.okHttpClientProvider.get(), this.executorProvider.get());
    }
}
