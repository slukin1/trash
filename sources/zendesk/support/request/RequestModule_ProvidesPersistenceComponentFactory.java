package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.ExecutorService;
import q00.a;
import zendesk.support.SupportUiStorage;
import zendesk.support.request.ComponentPersistence;

public final class RequestModule_ProvidesPersistenceComponentFactory implements b<ComponentPersistence> {
    private final a<ExecutorService> executorServiceProvider;
    private final a<ComponentPersistence.PersistenceQueue> queueProvider;
    private final a<SupportUiStorage> supportUiStorageProvider;

    public RequestModule_ProvidesPersistenceComponentFactory(a<SupportUiStorage> aVar, a<ComponentPersistence.PersistenceQueue> aVar2, a<ExecutorService> aVar3) {
        this.supportUiStorageProvider = aVar;
        this.queueProvider = aVar2;
        this.executorServiceProvider = aVar3;
    }

    public static RequestModule_ProvidesPersistenceComponentFactory create(a<SupportUiStorage> aVar, a<ComponentPersistence.PersistenceQueue> aVar2, a<ExecutorService> aVar3) {
        return new RequestModule_ProvidesPersistenceComponentFactory(aVar, aVar2, aVar3);
    }

    public static ComponentPersistence providesPersistenceComponent(SupportUiStorage supportUiStorage, Object obj, ExecutorService executorService) {
        return (ComponentPersistence) d.f(RequestModule.providesPersistenceComponent(supportUiStorage, (ComponentPersistence.PersistenceQueue) obj, executorService));
    }

    public ComponentPersistence get() {
        return providesPersistenceComponent(this.supportUiStorageProvider.get(), this.queueProvider.get(), this.executorServiceProvider.get());
    }
}
