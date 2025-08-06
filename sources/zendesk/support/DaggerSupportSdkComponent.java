package zendesk.support;

import android.content.Context;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.n;
import dagger.internal.d;
import dagger.internal.e;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import okhttp3.OkHttpClient;
import q00.a;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.AuthenticationProvider;
import zendesk.core.CoreModule;
import zendesk.core.CoreModule_ActionHandlerRegistryFactory;
import zendesk.core.CoreModule_GetApplicationContextFactory;
import zendesk.core.CoreModule_GetAuthenticationProviderFactory;
import zendesk.core.CoreModule_GetExecutorServiceFactory;
import zendesk.core.CoreModule_GetMemoryCacheFactory;
import zendesk.core.CoreModule_GetSessionStorageFactory;
import zendesk.core.MemoryCache;
import zendesk.core.SessionStorage;
import zendesk.support.request.RequestActivity;
import zendesk.support.request.RequestActivity_MembersInjector;
import zendesk.support.request.RequestComponent;
import zendesk.support.request.RequestModule;
import zendesk.support.request.RequestModule_ProvidesActionFactoryFactory;
import zendesk.support.request.RequestModule_ProvidesAsyncMiddlewareFactory;
import zendesk.support.request.RequestModule_ProvidesAttachmentDownloaderComponentFactory;
import zendesk.support.request.RequestModule_ProvidesAttachmentDownloaderFactory;
import zendesk.support.request.RequestModule_ProvidesAttachmentToDiskServiceFactory;
import zendesk.support.request.RequestModule_ProvidesBelvedereFactory;
import zendesk.support.request.RequestModule_ProvidesComponentListenerFactory;
import zendesk.support.request.RequestModule_ProvidesConUpdatesComponentFactory;
import zendesk.support.request.RequestModule_ProvidesDiskQueueFactory;
import zendesk.support.request.RequestModule_ProvidesDispatcherFactory;
import zendesk.support.request.RequestModule_ProvidesMessageFactoryFactory;
import zendesk.support.request.RequestModule_ProvidesPersistenceComponentFactory;
import zendesk.support.request.RequestModule_ProvidesReducerFactory;
import zendesk.support.request.RequestModule_ProvidesStoreFactory;
import zendesk.support.request.RequestViewConversationsDisabled;
import zendesk.support.request.RequestViewConversationsDisabled_MembersInjector;
import zendesk.support.request.RequestViewConversationsEnabled;
import zendesk.support.request.RequestViewConversationsEnabled_MembersInjector;
import zendesk.support.requestlist.RequestInfoDataSource;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListActivity_MembersInjector;
import zendesk.support.requestlist.RequestListComponent;
import zendesk.support.requestlist.RequestListModule;
import zendesk.support.requestlist.RequestListModule_ModelFactory;
import zendesk.support.requestlist.RequestListModule_PresenterFactory;
import zendesk.support.requestlist.RequestListModule_RefreshHandlerFactory;
import zendesk.support.requestlist.RequestListModule_RepositoryFactory;
import zendesk.support.requestlist.RequestListViewModule;
import zendesk.support.requestlist.RequestListViewModule_ViewFactory;
import zendesk.support.suas.Dispatcher;
import zendesk.support.suas.Reducer;
import zendesk.support.suas.Store;

public final class DaggerSupportSdkComponent {

    public static final class Builder {
        private CoreModule coreModule;
        private SupportModule supportModule;
        private SupportSdkModule supportSdkModule;

        public SupportSdkComponent build() {
            d.a(this.coreModule, CoreModule.class);
            d.a(this.supportModule, SupportModule.class);
            if (this.supportSdkModule == null) {
                this.supportSdkModule = new SupportSdkModule();
            }
            return new SupportSdkComponentImpl(this.coreModule, this.supportModule, this.supportSdkModule);
        }

        public Builder coreModule(CoreModule coreModule2) {
            this.coreModule = (CoreModule) d.b(coreModule2);
            return this;
        }

        public Builder supportModule(SupportModule supportModule2) {
            this.supportModule = (SupportModule) d.b(supportModule2);
            return this;
        }

        public Builder supportSdkModule(SupportSdkModule supportSdkModule2) {
            this.supportSdkModule = (SupportSdkModule) d.b(supportSdkModule2);
            return this;
        }

        private Builder() {
        }
    }

    public static final class RequestComponentImpl implements RequestComponent {
        private a providesActionFactoryProvider;
        private a providesAsyncMiddlewareProvider;
        private a providesAttachmentDownloaderComponentProvider;
        private a providesAttachmentDownloaderProvider;
        private a providesAttachmentToDiskServiceProvider;
        private a<zendesk.belvedere.a> providesBelvedereProvider;
        private a providesComponentListenerProvider;
        private a providesConUpdatesComponentProvider;
        private a providesDiskQueueProvider;
        private a<Dispatcher> providesDispatcherProvider;
        private a providesMessageFactoryProvider;
        private a providesPersistenceComponentProvider;
        private a<List<Reducer>> providesReducerProvider;
        private a<Store> providesStoreProvider;
        private final RequestComponentImpl requestComponentImpl;
        private final SupportSdkComponentImpl supportSdkComponentImpl;

        private void initialize(RequestModule requestModule) {
            this.providesReducerProvider = dagger.internal.a.a(RequestModule_ProvidesReducerFactory.create());
            a a11 = dagger.internal.a.a(RequestModule_ProvidesAsyncMiddlewareFactory.create());
            this.providesAsyncMiddlewareProvider = a11;
            this.providesStoreProvider = dagger.internal.a.a(RequestModule_ProvidesStoreFactory.create(this.providesReducerProvider, a11));
            this.providesBelvedereProvider = dagger.internal.a.a(RequestModule_ProvidesBelvedereFactory.create(this.supportSdkComponentImpl.getApplicationContextProvider));
            this.providesActionFactoryProvider = dagger.internal.a.a(RequestModule_ProvidesActionFactoryFactory.create(this.supportSdkComponentImpl.providesRequestProvider, this.supportSdkComponentImpl.providesSettingsProvider, this.supportSdkComponentImpl.providesUploadProvider, this.providesBelvedereProvider, this.supportSdkComponentImpl.supportUiStorageProvider, this.supportSdkComponentImpl.getExecutorServiceProvider, this.supportSdkComponentImpl.mainThreadExecutorProvider, this.supportSdkComponentImpl.getAuthenticationProvider, this.supportSdkComponentImpl.providesBlipsProvider));
            this.providesDiskQueueProvider = dagger.internal.a.a(RequestModule_ProvidesDiskQueueFactory.create(this.supportSdkComponentImpl.getExecutorServiceProvider));
            this.providesPersistenceComponentProvider = dagger.internal.a.a(RequestModule_ProvidesPersistenceComponentFactory.create(this.supportSdkComponentImpl.supportUiStorageProvider, this.providesDiskQueueProvider, this.supportSdkComponentImpl.getExecutorServiceProvider));
            this.providesDispatcherProvider = dagger.internal.a.a(RequestModule_ProvidesDispatcherFactory.create(this.providesStoreProvider));
            a a12 = dagger.internal.a.a(RequestModule_ProvidesAttachmentToDiskServiceFactory.create(this.supportSdkComponentImpl.providesOkHttpClientProvider, this.supportSdkComponentImpl.getExecutorServiceProvider));
            this.providesAttachmentToDiskServiceProvider = a12;
            a a13 = dagger.internal.a.a(RequestModule_ProvidesAttachmentDownloaderFactory.create(this.providesBelvedereProvider, a12));
            this.providesAttachmentDownloaderProvider = a13;
            this.providesAttachmentDownloaderComponentProvider = dagger.internal.a.a(RequestModule_ProvidesAttachmentDownloaderComponentFactory.create(this.providesDispatcherProvider, this.providesActionFactoryProvider, a13));
            a a14 = e.a(RequestModule_ProvidesConUpdatesComponentFactory.create(this.supportSdkComponentImpl.getApplicationContextProvider, this.supportSdkComponentImpl.actionHandlerRegistryProvider, this.supportSdkComponentImpl.requestInfoDataSourceProvider));
            this.providesConUpdatesComponentProvider = a14;
            this.providesComponentListenerProvider = dagger.internal.a.a(RequestModule_ProvidesComponentListenerFactory.create(this.providesPersistenceComponentProvider, this.providesAttachmentDownloaderComponentProvider, a14));
            this.providesMessageFactoryProvider = dagger.internal.a.a(RequestModule_ProvidesMessageFactoryFactory.create(requestModule, this.supportSdkComponentImpl.getApplicationContextProvider, this.supportSdkComponentImpl.providesPicassoProvider, this.providesActionFactoryProvider, this.providesDispatcherProvider, this.supportSdkComponentImpl.actionHandlerRegistryProvider, this.supportSdkComponentImpl.configurationHelperProvider));
        }

        private RequestActivity injectRequestActivity(RequestActivity requestActivity) {
            RequestActivity_MembersInjector.injectStore(requestActivity, this.providesStoreProvider.get());
            RequestActivity_MembersInjector.injectAf(requestActivity, this.providesActionFactoryProvider.get());
            RequestActivity_MembersInjector.injectHeadlessComponentListener(requestActivity, this.providesComponentListenerProvider.get());
            RequestActivity_MembersInjector.injectPicasso(requestActivity, (Picasso) this.supportSdkComponentImpl.providesPicassoProvider.get());
            RequestActivity_MembersInjector.injectActionHandlerRegistry(requestActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.supportSdkComponentImpl.coreModule));
            return requestActivity;
        }

        private RequestViewConversationsDisabled injectRequestViewConversationsDisabled(RequestViewConversationsDisabled requestViewConversationsDisabled) {
            RequestViewConversationsDisabled_MembersInjector.injectStore(requestViewConversationsDisabled, this.providesStoreProvider.get());
            RequestViewConversationsDisabled_MembersInjector.injectAf(requestViewConversationsDisabled, this.providesActionFactoryProvider.get());
            RequestViewConversationsDisabled_MembersInjector.injectPicasso(requestViewConversationsDisabled, (Picasso) this.supportSdkComponentImpl.providesPicassoProvider.get());
            return requestViewConversationsDisabled;
        }

        private RequestViewConversationsEnabled injectRequestViewConversationsEnabled(RequestViewConversationsEnabled requestViewConversationsEnabled) {
            RequestViewConversationsEnabled_MembersInjector.injectStore(requestViewConversationsEnabled, this.providesStoreProvider.get());
            RequestViewConversationsEnabled_MembersInjector.injectAf(requestViewConversationsEnabled, this.providesActionFactoryProvider.get());
            RequestViewConversationsEnabled_MembersInjector.injectCellFactory(requestViewConversationsEnabled, this.providesMessageFactoryProvider.get());
            RequestViewConversationsEnabled_MembersInjector.injectPicasso(requestViewConversationsEnabled, (Picasso) this.supportSdkComponentImpl.providesPicassoProvider.get());
            return requestViewConversationsEnabled;
        }

        public void inject(RequestActivity requestActivity) {
            injectRequestActivity(requestActivity);
        }

        private RequestComponentImpl(SupportSdkComponentImpl supportSdkComponentImpl2, RequestModule requestModule) {
            this.requestComponentImpl = this;
            this.supportSdkComponentImpl = supportSdkComponentImpl2;
            initialize(requestModule);
        }

        public void inject(RequestViewConversationsEnabled requestViewConversationsEnabled) {
            injectRequestViewConversationsEnabled(requestViewConversationsEnabled);
        }

        public void inject(RequestViewConversationsDisabled requestViewConversationsDisabled) {
            injectRequestViewConversationsDisabled(requestViewConversationsDisabled);
        }
    }

    public static final class RequestListComponentImpl implements RequestListComponent {
        private a modelProvider;
        private a presenterProvider;
        private a refreshHandlerProvider;
        private a<RequestInfoDataSource.Repository> repositoryProvider;
        private final RequestListComponentImpl requestListComponentImpl;
        private final SupportSdkComponentImpl supportSdkComponentImpl;
        private a viewProvider;

        private void initialize(RequestListModule requestListModule, RequestListViewModule requestListViewModule) {
            a<RequestInfoDataSource.Repository> a11 = dagger.internal.a.a(RequestListModule_RepositoryFactory.create(this.supportSdkComponentImpl.requestInfoDataSourceProvider, this.supportSdkComponentImpl.supportUiStorageProvider, this.supportSdkComponentImpl.providesRequestProvider, this.supportSdkComponentImpl.mainThreadExecutorProvider, this.supportSdkComponentImpl.getExecutorServiceProvider));
            this.repositoryProvider = a11;
            a a12 = dagger.internal.a.a(RequestListModule_ModelFactory.create(requestListModule, a11, this.supportSdkComponentImpl.getMemoryCacheProvider, this.supportSdkComponentImpl.providesBlipsProvider, this.supportSdkComponentImpl.providesSettingsProvider));
            this.modelProvider = a12;
            this.presenterProvider = dagger.internal.a.a(RequestListModule_PresenterFactory.create(requestListModule, a12));
            this.viewProvider = dagger.internal.a.a(RequestListViewModule_ViewFactory.create(requestListViewModule, this.supportSdkComponentImpl.providesPicassoProvider));
            this.refreshHandlerProvider = dagger.internal.a.a(RequestListModule_RefreshHandlerFactory.create(this.presenterProvider));
        }

        private RequestListActivity injectRequestListActivity(RequestListActivity requestListActivity) {
            RequestListActivity_MembersInjector.injectPresenter(requestListActivity, this.presenterProvider.get());
            RequestListActivity_MembersInjector.injectView(requestListActivity, this.viewProvider.get());
            RequestListActivity_MembersInjector.injectModel(requestListActivity, this.modelProvider.get());
            RequestListActivity_MembersInjector.injectActionHandlerRegistry(requestListActivity, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.supportSdkComponentImpl.coreModule));
            RequestListActivity_MembersInjector.injectSyncHandler(requestListActivity, this.refreshHandlerProvider.get());
            return requestListActivity;
        }

        public void inject(RequestListActivity requestListActivity) {
            injectRequestListActivity(requestListActivity);
        }

        private RequestListComponentImpl(SupportSdkComponentImpl supportSdkComponentImpl2, RequestListModule requestListModule, RequestListViewModule requestListViewModule) {
            this.requestListComponentImpl = this;
            this.supportSdkComponentImpl = supportSdkComponentImpl2;
            initialize(requestListModule, requestListViewModule);
        }
    }

    public static final class SupportSdkComponentImpl implements SupportSdkComponent {
        /* access modifiers changed from: private */
        public a<ActionHandlerRegistry> actionHandlerRegistryProvider;
        /* access modifiers changed from: private */
        public a<ConfigurationHelper> configurationHelperProvider;
        /* access modifiers changed from: private */
        public final CoreModule coreModule;
        /* access modifiers changed from: private */
        public a<Context> getApplicationContextProvider;
        /* access modifiers changed from: private */
        public a<AuthenticationProvider> getAuthenticationProvider;
        /* access modifiers changed from: private */
        public a<ExecutorService> getExecutorServiceProvider;
        /* access modifiers changed from: private */
        public a<MemoryCache> getMemoryCacheProvider;
        private a<SessionStorage> getSessionStorageProvider;
        /* access modifiers changed from: private */
        public a<Executor> mainThreadExecutorProvider;
        private a<n> okHttp3DownloaderProvider;
        private a<List<ActionHandler>> providesActionHandlersProvider;
        /* access modifiers changed from: private */
        public a<SupportBlipsProvider> providesBlipsProvider;
        /* access modifiers changed from: private */
        public a<OkHttpClient> providesOkHttpClientProvider;
        /* access modifiers changed from: private */
        public a<Picasso> providesPicassoProvider;
        private a<Gson> providesProvider;
        private a<aw.a> providesRequestDiskLruCacheProvider;
        /* access modifiers changed from: private */
        public a<RequestProvider> providesRequestProvider;
        /* access modifiers changed from: private */
        public a<SupportSettingsProvider> providesSettingsProvider;
        /* access modifiers changed from: private */
        public a<UploadProvider> providesUploadProvider;
        /* access modifiers changed from: private */
        public a<RequestInfoDataSource.LocalDataSource> requestInfoDataSourceProvider;
        private final SupportSdkComponentImpl supportSdkComponentImpl;
        /* access modifiers changed from: private */
        public a<SupportUiStorage> supportUiStorageProvider;

        private void initialize(CoreModule coreModule2, SupportModule supportModule, SupportSdkModule supportSdkModule) {
            this.providesActionHandlersProvider = dagger.internal.a.a(SupportSdkModule_ProvidesActionHandlersFactory.create(supportSdkModule));
            this.providesRequestProvider = SupportModule_ProvidesRequestProviderFactory.create(supportModule);
            this.providesSettingsProvider = SupportModule_ProvidesSettingsProviderFactory.create(supportModule);
            this.providesUploadProvider = SupportModule_ProvidesUploadProviderFactory.create(supportModule);
            this.getApplicationContextProvider = CoreModule_GetApplicationContextFactory.create(coreModule2);
            CoreModule_GetSessionStorageFactory create = CoreModule_GetSessionStorageFactory.create(coreModule2);
            this.getSessionStorageProvider = create;
            this.providesRequestDiskLruCacheProvider = dagger.internal.a.a(SupportSdkModule_ProvidesRequestDiskLruCacheFactory.create(supportSdkModule, create));
            a<Gson> a11 = dagger.internal.a.a(SupportSdkModule_ProvidesFactory.create(supportSdkModule));
            this.providesProvider = a11;
            this.supportUiStorageProvider = dagger.internal.a.a(SupportSdkModule_SupportUiStorageFactory.create(supportSdkModule, this.providesRequestDiskLruCacheProvider, a11));
            this.getExecutorServiceProvider = CoreModule_GetExecutorServiceFactory.create(coreModule2);
            this.mainThreadExecutorProvider = dagger.internal.a.a(SupportSdkModule_MainThreadExecutorFactory.create(supportSdkModule));
            this.getAuthenticationProvider = CoreModule_GetAuthenticationProviderFactory.create(coreModule2);
            this.providesBlipsProvider = SupportModule_ProvidesBlipsProviderFactory.create(supportModule);
            this.providesOkHttpClientProvider = SupportModule_ProvidesOkHttpClientFactory.create(supportModule);
            this.actionHandlerRegistryProvider = CoreModule_ActionHandlerRegistryFactory.create(coreModule2);
            this.requestInfoDataSourceProvider = SupportSdkModule_RequestInfoDataSourceFactory.create(supportSdkModule, this.supportUiStorageProvider, this.mainThreadExecutorProvider, this.getExecutorServiceProvider);
            a<n> a12 = dagger.internal.a.a(SupportSdkModule_OkHttp3DownloaderFactory.create(supportSdkModule, this.providesOkHttpClientProvider));
            this.okHttp3DownloaderProvider = a12;
            this.providesPicassoProvider = dagger.internal.a.a(SupportSdkModule_ProvidesPicassoFactory.create(supportSdkModule, this.getApplicationContextProvider, a12, this.getExecutorServiceProvider));
            this.configurationHelperProvider = SupportSdkModule_ConfigurationHelperFactory.create(supportSdkModule);
            this.getMemoryCacheProvider = CoreModule_GetMemoryCacheFactory.create(coreModule2);
        }

        private DeepLinkingBroadcastReceiver injectDeepLinkingBroadcastReceiver(DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver) {
            DeepLinkingBroadcastReceiver_MembersInjector.injectRegistry(deepLinkingBroadcastReceiver, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
            return deepLinkingBroadcastReceiver;
        }

        private SdkDependencyProvider injectSdkDependencyProvider(SdkDependencyProvider sdkDependencyProvider) {
            SdkDependencyProvider_MembersInjector.injectRegistry(sdkDependencyProvider, CoreModule_ActionHandlerRegistryFactory.actionHandlerRegistry(this.coreModule));
            SdkDependencyProvider_MembersInjector.injectActionHandlers(sdkDependencyProvider, this.providesActionHandlersProvider.get());
            return sdkDependencyProvider;
        }

        public void inject(SdkDependencyProvider sdkDependencyProvider) {
            injectSdkDependencyProvider(sdkDependencyProvider);
        }

        public RequestComponent plus(RequestModule requestModule) {
            d.b(requestModule);
            return new RequestComponentImpl(this.supportSdkComponentImpl, requestModule);
        }

        private SupportSdkComponentImpl(CoreModule coreModule2, SupportModule supportModule, SupportSdkModule supportSdkModule) {
            this.supportSdkComponentImpl = this;
            this.coreModule = coreModule2;
            initialize(coreModule2, supportModule, supportSdkModule);
        }

        public void inject(DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver) {
            injectDeepLinkingBroadcastReceiver(deepLinkingBroadcastReceiver);
        }

        public RequestListComponent plus(RequestListModule requestListModule, RequestListViewModule requestListViewModule) {
            d.b(requestListModule);
            d.b(requestListViewModule);
            return new RequestListComponentImpl(this.supportSdkComponentImpl, requestListModule, requestListViewModule);
        }
    }

    private DaggerSupportSdkComponent() {
    }

    public static Builder builder() {
        return new Builder();
    }
}
