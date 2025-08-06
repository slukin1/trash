package okio.internal;

import d10.a;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;
import okio.FileSystem;
import okio.Path;

public final class ResourceFileSystem$roots$2 extends Lambda implements a<List<? extends Pair<? extends FileSystem, ? extends Path>>> {
    public final /* synthetic */ ResourceFileSystem this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ResourceFileSystem$roots$2(ResourceFileSystem resourceFileSystem) {
        super(0);
        this.this$0 = resourceFileSystem;
    }

    public final List<Pair<FileSystem, Path>> invoke() {
        ResourceFileSystem resourceFileSystem = this.this$0;
        return resourceFileSystem.toClasspathRoots(resourceFileSystem.classLoader);
    }
}
