package kotlin.io.path;

import d10.q;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.c0;

final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2 extends Lambda implements q<a, Path, Path, CopyActionResult> {
    public final /* synthetic */ boolean $followLinks;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$2(boolean z11) {
        super(3);
        this.$followLinks = z11;
    }

    public final CopyActionResult invoke(a aVar, Path path, Path path2) {
        LinkOption[] a11 = e.f56742a.a(this.$followLinks);
        boolean isDirectory = Files.isDirectory(path2, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(a11, a11.length);
        if (!Files.isDirectory(path, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) || !isDirectory) {
            if (isDirectory) {
                PathsKt__PathRecursiveFunctionsKt.f(path2);
            }
            c0 c0Var = new c0(2);
            c0Var.b(a11);
            c0Var.a(StandardCopyOption.REPLACE_EXISTING);
            CopyOption[] copyOptionArr = (CopyOption[]) c0Var.d(new CopyOption[c0Var.c()]);
            Files.copy(path, path2, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length));
        }
        return CopyActionResult.CONTINUE;
    }
}
