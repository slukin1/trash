package kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

final class ExceptionsCollector {

    /* renamed from: a  reason: collision with root package name */
    public final int f56725a;

    /* renamed from: b  reason: collision with root package name */
    public int f56726b;

    /* renamed from: c  reason: collision with root package name */
    public final List<Exception> f56727c;

    /* renamed from: d  reason: collision with root package name */
    public Path f56728d;

    public ExceptionsCollector() {
        this(0, 1, (r) null);
    }

    public ExceptionsCollector(int i11) {
        this.f56725a = i11;
        this.f56727c = new ArrayList();
    }

    public final void a(Exception exc) {
        boolean z11 = true;
        this.f56726b++;
        if (this.f56727c.size() >= this.f56725a) {
            z11 = false;
        }
        if (z11) {
            if (this.f56728d != null) {
                exc = (FileSystemException) new FileSystemException(String.valueOf(this.f56728d)).initCause(exc);
            }
            this.f56727c.add(exc);
        }
    }

    public final void b(Path path) {
        Path path2 = this.f56728d;
        this.f56728d = path2 != null ? path2.resolve(path) : null;
    }

    public final void c(Path path) {
        Path path2 = this.f56728d;
        Path path3 = null;
        if (x.b(path, path2 != null ? path2.getFileName() : null)) {
            Path path4 = this.f56728d;
            if (path4 != null) {
                path3 = path4.getParent();
            }
            this.f56728d = path3;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final List<Exception> d() {
        return this.f56727c;
    }

    public final int e() {
        return this.f56726b;
    }

    public final void f(Path path) {
        this.f56728d = path;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExceptionsCollector(int i11, int i12, r rVar) {
        this((i12 & 1) != 0 ? 64 : i11);
    }
}
