package kotlin.io.path;

import d10.p;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public interface d {
    void a(p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar);

    void b(p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar);

    void c(p<? super Path, ? super IOException, ? extends FileVisitResult> pVar);

    void d(p<? super Path, ? super IOException, ? extends FileVisitResult> pVar);
}
