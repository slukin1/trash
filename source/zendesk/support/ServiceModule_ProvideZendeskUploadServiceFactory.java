package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ServiceModule_ProvideZendeskUploadServiceFactory implements b<ZendeskUploadService> {
    private final a<UploadService> uploadServiceProvider;

    public ServiceModule_ProvideZendeskUploadServiceFactory(a<UploadService> aVar) {
        this.uploadServiceProvider = aVar;
    }

    public static ServiceModule_ProvideZendeskUploadServiceFactory create(a<UploadService> aVar) {
        return new ServiceModule_ProvideZendeskUploadServiceFactory(aVar);
    }

    public static ZendeskUploadService provideZendeskUploadService(Object obj) {
        return (ZendeskUploadService) d.f(ServiceModule.provideZendeskUploadService((UploadService) obj));
    }

    public ZendeskUploadService get() {
        return provideZendeskUploadService(this.uploadServiceProvider.get());
    }
}
