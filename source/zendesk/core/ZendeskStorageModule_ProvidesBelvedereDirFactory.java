package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import java.io.File;
import q00.a;

public final class ZendeskStorageModule_ProvidesBelvedereDirFactory implements b<File> {
    private final a<Context> contextProvider;

    public ZendeskStorageModule_ProvidesBelvedereDirFactory(a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static ZendeskStorageModule_ProvidesBelvedereDirFactory create(a<Context> aVar) {
        return new ZendeskStorageModule_ProvidesBelvedereDirFactory(aVar);
    }

    public static File providesBelvedereDir(Context context) {
        return (File) d.f(ZendeskStorageModule.providesBelvedereDir(context));
    }

    public File get() {
        return providesBelvedereDir(this.contextProvider.get());
    }
}
