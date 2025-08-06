package zendesk.support.request;

import android.content.Context;
import com.squareup.picasso.Picasso;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;
import zendesk.configurations.ConfigurationHelper;
import zendesk.core.ActionHandlerRegistry;
import zendesk.support.suas.Dispatcher;

public final class RequestModule_ProvidesMessageFactoryFactory implements b<CellFactory> {
    private final a<ActionFactory> actionFactoryProvider;
    private final a<ConfigurationHelper> configHelperProvider;
    private final a<Context> contextProvider;
    private final a<Dispatcher> dispatcherProvider;
    private final RequestModule module;
    private final a<Picasso> picassoProvider;
    private final a<ActionHandlerRegistry> registryProvider;

    public RequestModule_ProvidesMessageFactoryFactory(RequestModule requestModule, a<Context> aVar, a<Picasso> aVar2, a<ActionFactory> aVar3, a<Dispatcher> aVar4, a<ActionHandlerRegistry> aVar5, a<ConfigurationHelper> aVar6) {
        this.module = requestModule;
        this.contextProvider = aVar;
        this.picassoProvider = aVar2;
        this.actionFactoryProvider = aVar3;
        this.dispatcherProvider = aVar4;
        this.registryProvider = aVar5;
        this.configHelperProvider = aVar6;
    }

    public static RequestModule_ProvidesMessageFactoryFactory create(RequestModule requestModule, a<Context> aVar, a<Picasso> aVar2, a<ActionFactory> aVar3, a<Dispatcher> aVar4, a<ActionHandlerRegistry> aVar5, a<ConfigurationHelper> aVar6) {
        return new RequestModule_ProvidesMessageFactoryFactory(requestModule, aVar, aVar2, aVar3, aVar4, aVar5, aVar6);
    }

    public static CellFactory providesMessageFactory(RequestModule requestModule, Context context, Picasso picasso, Object obj, Dispatcher dispatcher, ActionHandlerRegistry actionHandlerRegistry, ConfigurationHelper configurationHelper) {
        return (CellFactory) d.f(requestModule.providesMessageFactory(context, picasso, (ActionFactory) obj, dispatcher, actionHandlerRegistry, configurationHelper));
    }

    public CellFactory get() {
        return providesMessageFactory(this.module, this.contextProvider.get(), this.picassoProvider.get(), this.actionFactoryProvider.get(), this.dispatcherProvider.get(), this.registryProvider.get(), this.configHelperProvider.get());
    }
}
