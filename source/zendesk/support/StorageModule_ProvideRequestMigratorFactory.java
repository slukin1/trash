package zendesk.support;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class StorageModule_ProvideRequestMigratorFactory implements b<RequestMigrator> {
    private final a<Context> contextProvider;
    private final StorageModule module;

    public StorageModule_ProvideRequestMigratorFactory(StorageModule storageModule, a<Context> aVar) {
        this.module = storageModule;
        this.contextProvider = aVar;
    }

    public static StorageModule_ProvideRequestMigratorFactory create(StorageModule storageModule, a<Context> aVar) {
        return new StorageModule_ProvideRequestMigratorFactory(storageModule, aVar);
    }

    public static RequestMigrator provideRequestMigrator(StorageModule storageModule, Context context) {
        return (RequestMigrator) d.f(storageModule.provideRequestMigrator(context));
    }

    public RequestMigrator get() {
        return provideRequestMigrator(this.module, this.contextProvider.get());
    }
}
