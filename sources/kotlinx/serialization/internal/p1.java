package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;

public final class p1 implements f, m {

    /* renamed from: a  reason: collision with root package name */
    public final f f57756a;

    /* renamed from: b  reason: collision with root package name */
    public final String f57757b;

    /* renamed from: c  reason: collision with root package name */
    public final Set<String> f57758c;

    public p1(f fVar) {
        this.f57756a = fVar;
        this.f57757b = fVar.h() + '?';
        this.f57758c = g1.a(fVar);
    }

    public Set<String> a() {
        return this.f57758c;
    }

    public boolean b() {
        return true;
    }

    public int c(String str) {
        return this.f57756a.c(str);
    }

    public f d(int i11) {
        return this.f57756a.d(i11);
    }

    public int e() {
        return this.f57756a.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p1) && x.b(this.f57756a, ((p1) obj).f57756a);
    }

    public String f(int i11) {
        return this.f57756a.f(i11);
    }

    public List<Annotation> g(int i11) {
        return this.f57756a.g(i11);
    }

    public List<Annotation> getAnnotations() {
        return this.f57756a.getAnnotations();
    }

    public h getKind() {
        return this.f57756a.getKind();
    }

    public String h() {
        return this.f57757b;
    }

    public int hashCode() {
        return this.f57756a.hashCode() * 31;
    }

    public boolean i(int i11) {
        return this.f57756a.i(i11);
    }

    public boolean isInline() {
        return this.f57756a.isInline();
    }

    public final f j() {
        return this.f57756a;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f57756a);
        sb2.append('?');
        return sb2.toString();
    }
}
