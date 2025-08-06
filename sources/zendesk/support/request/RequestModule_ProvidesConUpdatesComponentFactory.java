package zendesk.support.request;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.requestlist.RequestInfoDataSource;

public final class RequestModule_ProvidesConUpdatesComponentFactory implements b<ComponentUpdateActionHandlers> {
    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<Context> contextProvider;
    private final a<RequestInfoDataSource.LocalDataSource> dataSourceProvider;

    public RequestModule_ProvidesConUpdatesComponentFactory(a<Context> aVar, a<ActionHandlerRegistry> aVar2, a<RequestInfoDataSource.LocalDataSource> aVar3) {
        this.contextProvider = aVar;
        this.actionHandlerRegistryProvider = aVar2;
        this.dataSourceProvider = aVar3;
    }

    public static RequestModule_ProvidesConUpdatesComponentFactory create(a<Context> aVar, a<ActionHandlerRegistry> aVar2, a<RequestInfoDataSource.LocalDataSource> aVar3) {
        return new RequestModule_ProvidesConUpdatesComponentFactory(aVar, aVar2, aVar3);
    }

    public static ComponentUpdateActionHandlers providesConUpdatesComponent(Context context, ActionHandlerRegistry actionHandlerRegistry, RequestInfoDataSource.LocalDataSource localDataSource) {
        return (ComponentUpdateActionHandlers) d.f(RequestModule.providesConUpdatesComponent(context, actionHandlerRegistry, localDataSource));
    }

    public ComponentUpdateActionHandlers get() {
        return providesConUpdatesComponent(this.contextProvider.get(), this.actionHandlerRegistryProvider.get(), this.dataSourceProvider.get());
    }
}
