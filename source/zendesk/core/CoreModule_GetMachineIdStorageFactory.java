package zendesk.core;

import dagger.internal.b;
import dagger.internal.d;

public final class CoreModule_GetMachineIdStorageFactory implements b<MachineIdStorage> {
    private final CoreModule module;

    public CoreModule_GetMachineIdStorageFactory(CoreModule coreModule) {
        this.module = coreModule;
    }

    public static CoreModule_GetMachineIdStorageFactory create(CoreModule coreModule) {
        return new CoreModule_GetMachineIdStorageFactory(coreModule);
    }

    public static MachineIdStorage getMachineIdStorage(CoreModule coreModule) {
        return (MachineIdStorage) d.f(coreModule.getMachineIdStorage());
    }

    public MachineIdStorage get() {
        return getMachineIdStorage(this.module);
    }
}
