package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import java.io.File;
import q00.a;

public final class ZendeskStorageModule_ProvidesDataDirFactory implements b<File> {
    private final a<Context> contextProvider;

    public ZendeskStorageModule_ProvidesDataDirFactory(a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static ZendeskStorageModule_ProvidesDataDirFactory create(a<Context> aVar) {
        return new ZendeskStorageModule_ProvidesDataDirFactory(aVar);
    }

    public static File providesDataDir(Context context) {
        return (File) d.f(ZendeskStorageModule.providesDataDir(context));
    }

    public File get() {
        return providesDataDir(this.contextProvider.get());
    }
}
