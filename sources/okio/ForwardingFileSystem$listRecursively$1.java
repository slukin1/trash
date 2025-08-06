package okio;

import d10.l;
import kotlin.jvm.internal.Lambda;

public final class ForwardingFileSystem$listRecursively$1 extends Lambda implements l<Path, Path> {
    public final /* synthetic */ ForwardingFileSystem this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ForwardingFileSystem$listRecursively$1(ForwardingFileSystem forwardingFileSystem) {
        super(1);
        this.this$0 = forwardingFileSystem;
    }

    public final Path invoke(Path path) {
        return this.this$0.onPathResult(path, "listRecursively");
    }
}
