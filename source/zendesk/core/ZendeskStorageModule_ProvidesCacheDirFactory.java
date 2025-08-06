package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import java.io.File;
import q00.a;

public final class ZendeskStorageModule_ProvidesCacheDirFactory implements b<File> {
    private final a<Context> contextProvider;

    public ZendeskStorageModule_ProvidesCacheDirFactory(a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static ZendeskStorageModule_ProvidesCacheDirFactory create(a<Context> aVar) {
        return new ZendeskStorageModule_ProvidesCacheDirFactory(aVar);
    }

    public static File providesCacheDir(Context context) {
        return (File) d.f(ZendeskStorageModule.providesCacheDir(context));
    }

    public File get() {
        return providesCacheDir(this.contextProvider.get());
    }
}
