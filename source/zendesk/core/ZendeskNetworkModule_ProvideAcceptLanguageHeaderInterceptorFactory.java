package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory implements b<AcceptLanguageHeaderInterceptor> {
    private final a<Context> contextProvider;

    public ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory(a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory create(a<Context> aVar) {
        return new ZendeskNetworkModule_ProvideAcceptLanguageHeaderInterceptorFactory(aVar);
    }

    public static AcceptLanguageHeaderInterceptor provideAcceptLanguageHeaderInterceptor(Context context) {
        return (AcceptLanguageHeaderInterceptor) d.f(ZendeskNetworkModule.provideAcceptLanguageHeaderInterceptor(context));
    }

    public AcceptLanguageHeaderInterceptor get() {
        return provideAcceptLanguageHeaderInterceptor(this.contextProvider.get());
    }
}
