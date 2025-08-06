package kotlin.io.path;

import d10.p;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public final class FileVisitorBuilderImpl implements d {

    /* renamed from: a  reason: collision with root package name */
    public p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f56729a;

    /* renamed from: b  reason: collision with root package name */
    public p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> f56730b;

    /* renamed from: c  reason: collision with root package name */
    public p<? super Path, ? super IOException, ? extends FileVisitResult> f56731c;

    /* renamed from: d  reason: collision with root package name */
    public p<? super Path, ? super IOException, ? extends FileVisitResult> f56732d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56733e;

    public void a(p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar) {
        e();
        f(this.f56729a, "onPreVisitDirectory");
        this.f56729a = pVar;
    }

    public void b(p<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> pVar) {
        e();
        f(this.f56730b, "onVisitFile");
        this.f56730b = pVar;
    }

    public void c(p<? super Path, ? super IOException, ? extends FileVisitResult> pVar) {
        e();
        f(this.f56731c, "onVisitFileFailed");
        this.f56731c = pVar;
    }

    public void d(p<? super Path, ? super IOException, ? extends FileVisitResult> pVar) {
        e();
        f(this.f56732d, "onPostVisitDirectory");
        this.f56732d = pVar;
    }

    public final void e() {
        if (this.f56733e) {
            throw new IllegalStateException("This builder was already built");
        }
    }

    public final void f(Object obj, String str) {
        if (obj != null) {
            throw new IllegalStateException(str + " was already defined");
        }
    }
}
