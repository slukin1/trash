package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.descriptors.f;

public final class m1 implements f {

    /* renamed from: a  reason: collision with root package name */
    public final String f57744a;

    /* renamed from: b  reason: collision with root package name */
    public final e f57745b;

    public m1(String str, e eVar) {
        this.f57744a = str;
        this.f57745b = eVar;
    }

    public final Void a() {
        throw new IllegalStateException("Primitive descriptor does not have elements");
    }

    public boolean b() {
        return f.a.c(this);
    }

    public int c(String str) {
        a();
        throw new KotlinNothingValueException();
    }

    public f d(int i11) {
        a();
        throw new KotlinNothingValueException();
    }

    public int e() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        return x.b(h(), m1Var.h()) && x.b(getKind(), m1Var.getKind());
    }

    public String f(int i11) {
        a();
        throw new KotlinNothingValueException();
    }

    public List<Annotation> g(int i11) {
        a();
        throw new KotlinNothingValueException();
    }

    public List<Annotation> getAnnotations() {
        return f.a.a(this);
    }

    public String h() {
        return this.f57744a;
    }

    public int hashCode() {
        return h().hashCode() + (getKind().hashCode() * 31);
    }

    public boolean i(int i11) {
        a();
        throw new KotlinNothingValueException();
    }

    public boolean isInline() {
        return f.a.b(this);
    }

    /* renamed from: j */
    public e getKind() {
        return this.f57745b;
    }

    public String toString() {
        return "PrimitiveDescriptor(" + h() + ')';
    }
}
