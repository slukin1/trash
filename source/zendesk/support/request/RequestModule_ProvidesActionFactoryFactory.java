package zendesk.support.request;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import q00.a;
import zendesk.core.AuthenticationProvider;
import zendesk.support.RequestProvider;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSettingsProvider;
import zendesk.support.SupportUiStorage;
import zendesk.support.UploadProvider;

public final class RequestModule_ProvidesActionFactoryFactory implements b<ActionFactory> {
    private final a<AuthenticationProvider> authProvider;
    private final a<zendesk.belvedere.a> belvedereProvider;
    private final a<SupportBlipsProvider> blipsProvider;
    private final a<ExecutorService> executorProvider;
    private final a<Executor> mainThreadExecutorProvider;
    private final a<RequestProvider> requestProvider;
    private final a<SupportSettingsProvider> settingsProvider;
    private final a<SupportUiStorage> supportUiStorageProvider;
    private final a<UploadProvider> uploadProvider;

    public RequestModule_ProvidesActionFactoryFactory(a<RequestProvider> aVar, a<SupportSettingsProvider> aVar2, a<UploadProvider> aVar3, a<zendesk.belvedere.a> aVar4, a<SupportUiStorage> aVar5, a<ExecutorService> aVar6, a<Executor> aVar7, a<AuthenticationProvider> aVar8, a<SupportBlipsProvider> aVar9) {
        this.requestProvider = aVar;
        this.settingsProvider = aVar2;
        this.uploadProvider = aVar3;
        this.belvedereProvider = aVar4;
        this.supportUiStorageProvider = aVar5;
        this.executorProvider = aVar6;
        this.mainThreadExecutorProvider = aVar7;
        this.authProvider = aVar8;
        this.blipsProvider = aVar9;
    }

    public static RequestModule_ProvidesActionFactoryFactory create(a<RequestProvider> aVar, a<SupportSettingsProvider> aVar2, a<UploadProvider> aVar3, a<zendesk.belvedere.a> aVar4, a<SupportUiStorage> aVar5, a<ExecutorService> aVar6, a<Executor> aVar7, a<AuthenticationProvider> aVar8, a<SupportBlipsProvider> aVar9) {
        return new RequestModule_ProvidesActionFactoryFactory(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static ActionFactory providesActionFactory(RequestProvider requestProvider2, SupportSettingsProvider supportSettingsProvider, UploadProvider uploadProvider2, zendesk.belvedere.a aVar, SupportUiStorage supportUiStorage, ExecutorService executorService, Executor executor, AuthenticationProvider authenticationProvider, SupportBlipsProvider supportBlipsProvider) {
        return (ActionFactory) d.f(RequestModule.providesActionFactory(requestProvider2, supportSettingsProvider, uploadProvider2, aVar, supportUiStorage, executorService, executor, authenticationProvider, supportBlipsProvider));
    }

    public ActionFactory get() {
        return providesActionFactory(this.requestProvider.get(), this.settingsProvider.get(), this.uploadProvider.get(), this.belvedereProvider.get(), this.supportUiStorageProvider.get(), this.executorProvider.get(), this.mainThreadExecutorProvider.get(), this.authProvider.get(), this.blipsProvider.get());
    }
}
