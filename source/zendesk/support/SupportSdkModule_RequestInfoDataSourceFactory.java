package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import q00.a;
import zendesk.support.requestlist.RequestInfoDataSource;

public final class SupportSdkModule_RequestInfoDataSourceFactory implements b<RequestInfoDataSource.LocalDataSource> {
    private final a<ExecutorService> backgroundThreadExecutorProvider;
    private final a<Executor> mainThreadExecutorProvider;
    private final SupportSdkModule module;
    private final a<SupportUiStorage> supportUiStorageProvider;

    public SupportSdkModule_RequestInfoDataSourceFactory(SupportSdkModule supportSdkModule, a<SupportUiStorage> aVar, a<Executor> aVar2, a<ExecutorService> aVar3) {
        this.module = supportSdkModule;
        this.supportUiStorageProvider = aVar;
        this.mainThreadExecutorProvider = aVar2;
        this.backgroundThreadExecutorProvider = aVar3;
    }

    public static SupportSdkModule_RequestInfoDataSourceFactory create(SupportSdkModule supportSdkModule, a<SupportUiStorage> aVar, a<Executor> aVar2, a<ExecutorService> aVar3) {
        return new SupportSdkModule_RequestInfoDataSourceFactory(supportSdkModule, aVar, aVar2, aVar3);
    }

    public static RequestInfoDataSource.LocalDataSource requestInfoDataSource(SupportSdkModule supportSdkModule, SupportUiStorage supportUiStorage, Executor executor, ExecutorService executorService) {
        return (RequestInfoDataSource.LocalDataSource) d.f(supportSdkModule.requestInfoDataSource(supportUiStorage, executor, executorService));
    }

    public RequestInfoDataSource.LocalDataSource get() {
        return requestInfoDataSource(this.module, this.supportUiStorageProvider.get(), this.mainThreadExecutorProvider.get(), this.backgroundThreadExecutorProvider.get());
    }
}
