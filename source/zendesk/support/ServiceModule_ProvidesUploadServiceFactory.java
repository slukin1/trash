package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.RestServiceProvider;

public final class ServiceModule_ProvidesUploadServiceFactory implements b<UploadService> {
    private final a<RestServiceProvider> restServiceProvider;

    public ServiceModule_ProvidesUploadServiceFactory(a<RestServiceProvider> aVar) {
        this.restServiceProvider = aVar;
    }

    public static ServiceModule_ProvidesUploadServiceFactory create(a<RestServiceProvider> aVar) {
        return new ServiceModule_ProvidesUploadServiceFactory(aVar);
    }

    public static UploadService providesUploadService(RestServiceProvider restServiceProvider2) {
        return (UploadService) d.f(ServiceModule.providesUploadService(restServiceProvider2));
    }

    public UploadService get() {
        return providesUploadService(this.restServiceProvider.get());
    }
}
