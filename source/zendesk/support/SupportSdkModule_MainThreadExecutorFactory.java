package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import java.util.concurrent.Executor;

public final class SupportSdkModule_MainThreadExecutorFactory implements b<Executor> {
    private final SupportSdkModule module;

    public SupportSdkModule_MainThreadExecutorFactory(SupportSdkModule supportSdkModule) {
        this.module = supportSdkModule;
    }

    public static SupportSdkModule_MainThreadExecutorFactory create(SupportSdkModule supportSdkModule) {
        return new SupportSdkModule_MainThreadExecutorFactory(supportSdkModule);
    }

    public static Executor mainThreadExecutor(SupportSdkModule supportSdkModule) {
        return (Executor) d.f(supportSdkModule.mainThreadExecutor());
    }

    public Executor get() {
        return mainThreadExecutor(this.module);
    }
}
