package kotlin.io.path;

import d10.l;
import d10.p;
import d10.q;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

final class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5 extends Lambda implements l<d, Unit> {
    public final /* synthetic */ q<a, Path, Path, CopyActionResult> $copyAction;
    public final /* synthetic */ q<Path, Path, Exception, OnErrorResult> $onError;
    public final /* synthetic */ Path $target;
    public final /* synthetic */ Path $this_copyToRecursively;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5(q<? super a, ? super Path, ? super Path, ? extends CopyActionResult> qVar, Path path, Path path2, q<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> qVar2) {
        super(1);
        this.$copyAction = qVar;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$onError = qVar2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((d) obj);
        return Unit.f56620a;
    }

    public final void invoke(d dVar) {
        final q<a, Path, Path, CopyActionResult> qVar = this.$copyAction;
        final Path path = this.$this_copyToRecursively;
        final Path path2 = this.$target;
        final q<Path, Path, Exception, OnErrorResult> qVar2 = this.$onError;
        dVar.a(new p<Path, BasicFileAttributes, FileVisitResult>() {
            public final FileVisitResult invoke(Path path, BasicFileAttributes basicFileAttributes) {
                return PathsKt__PathRecursiveFunctionsKt.c(qVar, path, path2, qVar2, path, basicFileAttributes);
            }
        });
        final q<a, Path, Path, CopyActionResult> qVar3 = this.$copyAction;
        final Path path3 = this.$this_copyToRecursively;
        final Path path4 = this.$target;
        final q<Path, Path, Exception, OnErrorResult> qVar4 = this.$onError;
        dVar.b(new p<Path, BasicFileAttributes, FileVisitResult>() {
            public final FileVisitResult invoke(Path path, BasicFileAttributes basicFileAttributes) {
                return PathsKt__PathRecursiveFunctionsKt.c(qVar3, path3, path4, qVar4, path, basicFileAttributes);
            }
        });
        final q<Path, Path, Exception, OnErrorResult> qVar5 = this.$onError;
        final Path path5 = this.$this_copyToRecursively;
        final Path path6 = this.$target;
        dVar.c(new p<Path, Exception, FileVisitResult>() {
            public final FileVisitResult invoke(Path path, Exception exc) {
                return PathsKt__PathRecursiveFunctionsKt.e(qVar5, path5, path6, path, exc);
            }
        });
        final q<Path, Path, Exception, OnErrorResult> qVar6 = this.$onError;
        final Path path7 = this.$this_copyToRecursively;
        final Path path8 = this.$target;
        dVar.d(new p<Path, IOException, FileVisitResult>() {
            public final FileVisitResult invoke(Path path, IOException iOException) {
                if (iOException == null) {
                    return FileVisitResult.CONTINUE;
                }
                return PathsKt__PathRecursiveFunctionsKt.e(qVar6, path7, path8, path, iOException);
            }
        });
    }
}
