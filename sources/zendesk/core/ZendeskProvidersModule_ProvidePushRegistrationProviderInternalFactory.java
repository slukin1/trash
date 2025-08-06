package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory implements b<PushRegistrationProviderInternal> {
    private final a<PushRegistrationProvider> pushRegistrationProvider;

    public ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory(a<PushRegistrationProvider> aVar) {
        this.pushRegistrationProvider = aVar;
    }

    public static ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory create(a<PushRegistrationProvider> aVar) {
        return new ZendeskProvidersModule_ProvidePushRegistrationProviderInternalFactory(aVar);
    }

    public static PushRegistrationProviderInternal providePushRegistrationProviderInternal(PushRegistrationProvider pushRegistrationProvider2) {
        return (PushRegistrationProviderInternal) d.f(ZendeskProvidersModule.providePushRegistrationProviderInternal(pushRegistrationProvider2));
    }

    public PushRegistrationProviderInternal get() {
        return providePushRegistrationProviderInternal(this.pushRegistrationProvider.get());
    }
}
