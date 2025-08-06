package zendesk.support.requestlist;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.MemoryCache;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.requestlist.RequestInfoDataSource;

public final class RequestListModule_ModelFactory implements b<RequestListModel> {
    private final a<SupportBlipsProvider> blipsProvider;
    private final a<MemoryCache> memoryCacheProvider;
    private final RequestListModule module;
    private final a<RequestInfoDataSource.Repository> requestInfoDataSourceProvider;
    private final a<SupportSettingsProvider> settingsProvider;

    public RequestListModule_ModelFactory(RequestListModule requestListModule, a<RequestInfoDataSource.Repository> aVar, a<MemoryCache> aVar2, a<SupportBlipsProvider> aVar3, a<SupportSettingsProvider> aVar4) {
        this.module = requestListModule;
        this.requestInfoDataSourceProvider = aVar;
        this.memoryCacheProvider = aVar2;
        this.blipsProvider = aVar3;
        this.settingsProvider = aVar4;
    }

    public static RequestListModule_ModelFactory create(RequestListModule requestListModule, a<RequestInfoDataSource.Repository> aVar, a<MemoryCache> aVar2, a<SupportBlipsProvider> aVar3, a<SupportSettingsProvider> aVar4) {
        return new RequestListModule_ModelFactory(requestListModule, aVar, aVar2, aVar3, aVar4);
    }

    public static RequestListModel model(RequestListModule requestListModule, RequestInfoDataSource.Repository repository, MemoryCache memoryCache, SupportBlipsProvider supportBlipsProvider, SupportSettingsProvider supportSettingsProvider) {
        return (RequestListModel) d.f(requestListModule.model(repository, memoryCache, supportBlipsProvider, supportSettingsProvider));
    }

    public RequestListModel get() {
        return model(this.module, this.requestInfoDataSourceProvider.get(), this.memoryCacheProvider.get(), this.blipsProvider.get(), this.settingsProvider.get());
    }
}
