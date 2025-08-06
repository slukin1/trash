package zendesk.support.requestlist;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import zendesk.core.MemoryCache;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.requestlist.RequestInfoDataSource;

public class RequestListModule {
    public static RequestListSyncHandler refreshHandler(RequestListPresenter requestListPresenter) {
        return new RequestListSyncHandler(requestListPresenter);
    }

    public static RequestInfoDataSource.Repository repository(RequestInfoDataSource.LocalDataSource localDataSource, SupportUiStorage supportUiStorage, RequestProvider requestProvider, Executor executor, ExecutorService executorService) {
        return new RequestInfoDataSource.Repository(localDataSource, new RequestInfoDataSource.RemoteDataSource(new RequestInfoDataSource.Network(requestProvider), new RequestInfoDataSource.Disk(executor, executorService, supportUiStorage, RequestInfoDataSource.REMOTE)), new RequestInfoMerger());
    }

    public RequestListModel model(RequestInfoDataSource.Repository repository, MemoryCache memoryCache, SupportBlipsProvider supportBlipsProvider, SupportSettingsProvider supportSettingsProvider) {
        return new RequestListModel(repository, memoryCache, supportBlipsProvider, supportSettingsProvider);
    }

    public RequestListPresenter presenter(RequestListModel requestListModel) {
        return new RequestListPresenter(requestListModel);
    }
}
