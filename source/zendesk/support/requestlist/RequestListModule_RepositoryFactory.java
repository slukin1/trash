package zendesk.support.requestlist;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import q00.a;
import zendesk.support.RequestProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.requestlist.RequestInfoDataSource;

public final class RequestListModule_RepositoryFactory implements b<RequestInfoDataSource.Repository> {
    private final a<ExecutorService> backgroundThreadExecutorProvider;
    private final a<RequestInfoDataSource.LocalDataSource> localDataSourceProvider;
    private final a<Executor> mainThreadExecutorProvider;
    private final a<RequestProvider> requestProvider;
    private final a<SupportUiStorage> supportUiStorageProvider;

    public RequestListModule_RepositoryFactory(a<RequestInfoDataSource.LocalDataSource> aVar, a<SupportUiStorage> aVar2, a<RequestProvider> aVar3, a<Executor> aVar4, a<ExecutorService> aVar5) {
        this.localDataSourceProvider = aVar;
        this.supportUiStorageProvider = aVar2;
        this.requestProvider = aVar3;
        this.mainThreadExecutorProvider = aVar4;
        this.backgroundThreadExecutorProvider = aVar5;
    }

    public static RequestListModule_RepositoryFactory create(a<RequestInfoDataSource.LocalDataSource> aVar, a<SupportUiStorage> aVar2, a<RequestProvider> aVar3, a<Executor> aVar4, a<ExecutorService> aVar5) {
        return new RequestListModule_RepositoryFactory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static RequestInfoDataSource.Repository repository(RequestInfoDataSource.LocalDataSource localDataSource, SupportUiStorage supportUiStorage, RequestProvider requestProvider2, Executor executor, ExecutorService executorService) {
        return (RequestInfoDataSource.Repository) d.f(RequestListModule.repository(localDataSource, supportUiStorage, requestProvider2, executor, executorService));
    }

    public RequestInfoDataSource.Repository get() {
        return repository(this.localDataSourceProvider.get(), this.supportUiStorageProvider.get(), this.requestProvider.get(), this.mainThreadExecutorProvider.get(), this.backgroundThreadExecutorProvider.get());
    }
}
