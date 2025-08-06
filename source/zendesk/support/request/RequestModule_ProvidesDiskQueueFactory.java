package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;
import q00.a;
import zendesk.support.request.ComponentPersistence;

public final class RequestModule_ProvidesDiskQueueFactory implements b<ComponentPersistence.PersistenceQueue> {
    private final a<ExecutorService> executorServiceProvider;

    public RequestModule_ProvidesDiskQueueFactory(a<ExecutorService> aVar) {
        this.executorServiceProvider = aVar;
    }

    public static RequestModule_ProvidesDiskQueueFactory create(a<ExecutorService> aVar) {
        return new RequestModule_ProvidesDiskQueueFactory(aVar);
    }

    public static ComponentPersistence.PersistenceQueue providesDiskQueue(ExecutorService executorService) {
        return (ComponentPersistence.PersistenceQueue) d.f(RequestModule.providesDiskQueue(executorService));
    }

    public ComponentPersistence.PersistenceQueue get() {
        return providesDiskQueue(this.executorServiceProvider.get());
    }
}
