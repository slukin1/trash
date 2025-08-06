package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvidePushDeviceIdStorageFactory implements b<PushDeviceIdStorage> {
    private final a<BaseStorage> additionalSdkStorageProvider;

    public ZendeskStorageModule_ProvidePushDeviceIdStorageFactory(a<BaseStorage> aVar) {
        this.additionalSdkStorageProvider = aVar;
    }

    public static ZendeskStorageModule_ProvidePushDeviceIdStorageFactory create(a<BaseStorage> aVar) {
        return new ZendeskStorageModule_ProvidePushDeviceIdStorageFactory(aVar);
    }

    public static PushDeviceIdStorage providePushDeviceIdStorage(BaseStorage baseStorage) {
        return (PushDeviceIdStorage) d.f(ZendeskStorageModule.providePushDeviceIdStorage(baseStorage));
    }

    public PushDeviceIdStorage get() {
        return providePushDeviceIdStorage(this.additionalSdkStorageProvider.get());
    }
}
