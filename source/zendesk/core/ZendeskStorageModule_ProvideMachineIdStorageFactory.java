package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskStorageModule_ProvideMachineIdStorageFactory implements b<MachineIdStorage> {
    private final a<Context> contextProvider;

    public ZendeskStorageModule_ProvideMachineIdStorageFactory(a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static ZendeskStorageModule_ProvideMachineIdStorageFactory create(a<Context> aVar) {
        return new ZendeskStorageModule_ProvideMachineIdStorageFactory(aVar);
    }

    public static MachineIdStorage provideMachineIdStorage(Context context) {
        return (MachineIdStorage) d.f(ZendeskStorageModule.provideMachineIdStorage(context));
    }

    public MachineIdStorage get() {
        return provideMachineIdStorage(this.contextProvider.get());
    }
}
