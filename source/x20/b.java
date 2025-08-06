package x20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Objects;
import org.junit.runners.model.FrameworkMember;

public class b extends FrameworkMember<b> {

    /* renamed from: a  reason: collision with root package name */
    public final Field f26323a;

    public b(Field field) {
        Objects.requireNonNull(field, "FrameworkField cannot be created without an underlying field.");
        this.f26323a = field;
    }

    public Class<?> a() {
        return this.f26323a.getDeclaringClass();
    }

    public int b() {
        return this.f26323a.getModifiers();
    }

    public String c() {
        return j().getName();
    }

    public Class<?> d() {
        return this.f26323a.getType();
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.f26323a.getAnnotation(cls);
    }

    public Annotation[] getAnnotations() {
        return this.f26323a.getAnnotations();
    }

    public Object i(Object obj) throws IllegalArgumentException, IllegalAccessException {
        return this.f26323a.get(obj);
    }

    public Field j() {
        return this.f26323a;
    }

    /* renamed from: k */
    public boolean g(b bVar) {
        return bVar.c().equals(c());
    }

    public String toString() {
        return this.f26323a.toString();
    }
}
