package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.RestServiceProvider;

public final class ServiceModule_ProvidesRequestServiceFactory implements b<RequestService> {
    private final a<RestServiceProvider> restServiceProvider;

    public ServiceModule_ProvidesRequestServiceFactory(a<RestServiceProvider> aVar) {
        this.restServiceProvider = aVar;
    }

    public static ServiceModule_ProvidesRequestServiceFactory create(a<RestServiceProvider> aVar) {
        return new ServiceModule_ProvidesRequestServiceFactory(aVar);
    }

    public static RequestService providesRequestService(RestServiceProvider restServiceProvider2) {
        return (RequestService) d.f(ServiceModule.providesRequestService(restServiceProvider2));
    }

    public RequestService get() {
        return providesRequestService(this.restServiceProvider.get());
    }
}
