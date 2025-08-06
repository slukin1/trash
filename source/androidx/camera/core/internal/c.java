package androidx.camera.core.internal;

import java.util.concurrent.Executor;

public final /* synthetic */ class c {
    public static Executor a(IoConfig ioConfig) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR);
    }

    public static Executor b(IoConfig ioConfig, Executor executor) {
        return (Executor) ioConfig.retrieveOption(IoConfig.OPTION_IO_EXECUTOR, executor);
    }
}
