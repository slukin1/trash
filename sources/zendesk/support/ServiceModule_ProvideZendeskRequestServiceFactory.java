package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ServiceModule_ProvideZendeskRequestServiceFactory implements b<ZendeskRequestService> {
    private final a<RequestService> requestServiceProvider;

    public ServiceModule_ProvideZendeskRequestServiceFactory(a<RequestService> aVar) {
        this.requestServiceProvider = aVar;
    }

    public static ServiceModule_ProvideZendeskRequestServiceFactory create(a<RequestService> aVar) {
        return new ServiceModule_ProvideZendeskRequestServiceFactory(aVar);
    }

    public static ZendeskRequestService provideZendeskRequestService(Object obj) {
        return (ZendeskRequestService) d.f(ServiceModule.provideZendeskRequestService((RequestService) obj));
    }

    public ZendeskRequestService get() {
        return provideZendeskRequestService(this.requestServiceProvider.get());
    }
}
