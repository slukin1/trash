package kotlin.io.path;

import java.nio.file.Path;
import java.util.Iterator;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Path f56747a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f56748b;

    /* renamed from: c  reason: collision with root package name */
    public final f f56749c;

    /* renamed from: d  reason: collision with root package name */
    public Iterator<f> f56750d;

    public f(Path path, Object obj, f fVar) {
        this.f56747a = path;
        this.f56748b = obj;
        this.f56749c = fVar;
    }

    public final Iterator<f> a() {
        return this.f56750d;
    }

    public final Object b() {
        return this.f56748b;
    }

    public final f c() {
        return this.f56749c;
    }

    public final Path d() {
        return this.f56747a;
    }

    public final void e(Iterator<f> it2) {
        this.f56750d = it2;
    }
}
