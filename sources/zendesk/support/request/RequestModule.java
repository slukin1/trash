package zendesk.support.request;

import android.content.Context;
import com.squareup.picasso.Picasso;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
import zendesk.belvedere.a;
import zendesk.configurations.Configuration;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.AuthenticationProvider;
import zendesk.core.Zendesk;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.UploadProvider;
import zendesk.support.request.AsyncMiddleware;
import zendesk.support.request.AttachmentDownloaderComponent;
import zendesk.support.request.ComponentPersistence;
import zendesk.support.requestlist.RequestInfoDataSource;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Filters;
import zendesk.support.suas.Reducer;
import zendesk.support.suas.Store;
import zendesk.support.suas.Suas;

public class RequestModule {
    private final Configuration configuration;

    public RequestModule(Configuration configuration2) {
        this.configuration = configuration2;
    }

    public static ActionFactory providesActionFactory(RequestProvider requestProvider, SupportSettingsProvider supportSettingsProvider, UploadProvider uploadProvider, a aVar, SupportUiStorage supportUiStorage, ExecutorService executorService, Executor executor, AuthenticationProvider authenticationProvider, SupportBlipsProvider supportBlipsProvider) {
        return new ActionFactory(requestProvider, uploadProvider, supportSettingsProvider, aVar, supportUiStorage, executorService, "5.2.0", authenticationProvider, Zendesk.INSTANCE, supportBlipsProvider, executor);
    }

    public static AsyncMiddleware providesAsyncMiddleware() {
        return new AsyncMiddleware(new AsyncMiddleware.Queue());
    }

    public static AttachmentDownloaderComponent.AttachmentDownloader providesAttachmentDownloader(a aVar, AttachmentDownloadService attachmentDownloadService) {
        return new AttachmentDownloaderComponent.AttachmentDownloader(aVar, attachmentDownloadService);
    }

    public static AttachmentDownloaderComponent providesAttachmentDownloaderComponent(Dispatcher dispatcher, ActionFactory actionFactory, AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloader) {
        return new AttachmentDownloaderComponent(dispatcher, actionFactory, attachmentDownloader);
    }

    public static AttachmentDownloadService providesAttachmentToDiskService(OkHttpClient okHttpClient, ExecutorService executorService) {
        return new AttachmentDownloadService(okHttpClient, executorService);
    }

    public static a providesBelvedere(Context context) {
        return a.c(context);
    }

    public static HeadlessComponentListener providesComponentListener(ComponentPersistence componentPersistence, AttachmentDownloaderComponent attachmentDownloaderComponent, ComponentUpdateActionHandlers componentUpdateActionHandlers) {
        return new HeadlessComponentListener(componentPersistence, attachmentDownloaderComponent, componentUpdateActionHandlers);
    }

    public static ComponentUpdateActionHandlers providesConUpdatesComponent(Context context, ActionHandlerRegistry actionHandlerRegistry, RequestInfoDataSource.LocalDataSource localDataSource) {
        return new ComponentUpdateActionHandlers(context, actionHandlerRegistry, localDataSource);
    }

    public static ComponentPersistence.PersistenceQueue providesDiskQueue(ExecutorService executorService) {
        return new ComponentPersistence.PersistenceQueue(executorService);
    }

    public static Dispatcher providesDispatcher(Store store) {
        return store;
    }

    public static ComponentPersistence providesPersistenceComponent(SupportUiStorage supportUiStorage, ComponentPersistence.PersistenceQueue persistenceQueue, ExecutorService executorService) {
        return new ComponentPersistence(supportUiStorage, persistenceQueue, executorService);
    }

    public static List<Reducer> providesReducer() {
        return Arrays.asList(new Reducer[]{new ReducerProgress(), new ReducerConfiguration(), new ReducerConversation(), new ReducerAttachments(), new ReducerAndroidLifecycle(), new ReducerUiState(), new ReducerError()});
    }

    public static Store providesStore(List<Reducer> list, AsyncMiddleware asyncMiddleware) {
        return Suas.createStore((Collection<Reducer>) list).withMiddleware(asyncMiddleware).withDefaultFilter(Filters.EQUALS).build();
    }

    public CellFactory providesMessageFactory(Context context, Picasso picasso, ActionFactory actionFactory, Dispatcher dispatcher, ActionHandlerRegistry actionHandlerRegistry, ConfigurationHelper configurationHelper) {
        return new CellFactory(context.getApplicationContext(), picasso, actionFactory, dispatcher, actionHandlerRegistry, configurationHelper, this.configuration);
    }
}
