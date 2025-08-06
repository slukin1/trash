package kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.jvm.internal.x;

public final class c implements f {

    /* renamed from: a  reason: collision with root package name */
    public final f f57625a;

    /* renamed from: b  reason: collision with root package name */
    public final kotlin.reflect.c<?> f57626b;

    /* renamed from: c  reason: collision with root package name */
    public final String f57627c;

    public c(f fVar, kotlin.reflect.c<?> cVar) {
        this.f57625a = fVar;
        this.f57626b = cVar;
        this.f57627c = fVar.h() + '<' + cVar.f() + '>';
    }

    public boolean b() {
        return this.f57625a.b();
    }

    public int c(String str) {
        return this.f57625a.c(str);
    }

    public f d(int i11) {
        return this.f57625a.d(i11);
    }

    public int e() {
        return this.f57625a.e();
    }

    public boolean equals(Object obj) {
        c cVar = obj instanceof c ? (c) obj : null;
        if (cVar != null && x.b(this.f57625a, cVar.f57625a) && x.b(cVar.f57626b, this.f57626b)) {
            return true;
        }
        return false;
    }

    public String f(int i11) {
        return this.f57625a.f(i11);
    }

    public List<Annotation> g(int i11) {
        return this.f57625a.g(i11);
    }

    public List<Annotation> getAnnotations() {
        return this.f57625a.getAnnotations();
    }

    public h getKind() {
        return this.f57625a.getKind();
    }

    public String h() {
        return this.f57627c;
    }

    public int hashCode() {
        return (this.f57626b.hashCode() * 31) + h().hashCode();
    }

    public boolean i(int i11) {
        return this.f57625a.i(i11);
    }

    public boolean isInline() {
        return this.f57625a.isInline();
    }

    public String toString() {
        return "ContextDescriptor(kClass: " + this.f57626b + ", original: " + this.f57625a + ')';
    }
}
