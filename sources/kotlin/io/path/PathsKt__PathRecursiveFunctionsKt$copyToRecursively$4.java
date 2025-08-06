package kotlin.io.path;

import d10.q;
import java.nio.file.Path;
import kotlin.jvm.internal.Lambda;

final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4 extends Lambda implements q<a, Path, Path, CopyActionResult> {
    public final /* synthetic */ boolean $followLinks;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$4(boolean z11) {
        super(3);
        this.$followLinks = z11;
    }

    public final CopyActionResult invoke(a aVar, Path path, Path path2) {
        return aVar.a(path, path2, this.$followLinks);
    }
}
