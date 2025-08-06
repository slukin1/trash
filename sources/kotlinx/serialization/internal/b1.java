package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.h;
import kotlinx.serialization.descriptors.i;

public final class b1 implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final b1 f57695a = new b1();

    /* renamed from: b  reason: collision with root package name */
    public static final h f57696b = i.d.f57650a;

    /* renamed from: c  reason: collision with root package name */
    public static final String f57697c = "kotlin.Nothing";

    public final Void a() {
        throw new IllegalStateException("Descriptor for type `kotlin.Nothing` does not have elements");
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
        return this == obj;
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

    public h getKind() {
        return f57696b;
    }

    public String h() {
        return f57697c;
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

    public String toString() {
        return "NothingSerialDescriptor";
    }
}
