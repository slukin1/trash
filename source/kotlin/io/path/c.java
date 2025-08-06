package kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import kotlin.collections.ArrayDeque;

public final class c extends SimpleFileVisitor<Path> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f56739a;

    /* renamed from: b  reason: collision with root package name */
    public f f56740b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayDeque<f> f56741c = new ArrayDeque<>();

    public c(boolean z11) {
        this.f56739a = z11;
    }

    /* renamed from: a */
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) {
        this.f56741c.add(new f(path, basicFileAttributes.fileKey(), this.f56740b));
        return super.preVisitDirectory(path, basicFileAttributes);
    }

    public final List<f> b(f fVar) {
        this.f56740b = fVar;
        Files.walkFileTree(fVar.d(), e.f56742a.b(this.f56739a), 1, this);
        this.f56741c.removeFirst();
        ArrayDeque<f> arrayDeque = this.f56741c;
        this.f56741c = new ArrayDeque<>();
        return arrayDeque;
    }

    /* renamed from: c */
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        this.f56741c.add(new f(path, (Object) null, this.f56740b));
        return super.visitFile(path, basicFileAttributes);
    }
}
