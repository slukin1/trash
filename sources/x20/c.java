package x20;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.runners.model.FrameworkMember;

public class c extends FrameworkMember<c> {

    /* renamed from: a  reason: collision with root package name */
    public final Method f26324a;

    public class a extends ReflectiveCallable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Object f26325a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object[] f26326b;

        public a(Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            this.f26325a = obj;
            this.f26326b = objArr;
        }

        public Object b() throws Throwable {
            return c.this.f26324a.invoke(this.f26325a, this.f26326b);
        }
    }

    public c(Method method) {
        Objects.requireNonNull(method, "FrameworkMethod cannot be created without an underlying method.");
        this.f26324a = method;
    }

    public Class<?> a() {
        return this.f26324a.getDeclaringClass();
    }

    public int b() {
        return this.f26324a.getModifiers();
    }

    public String c() {
        return this.f26324a.getName();
    }

    public Class<?> d() {
        return l();
    }

    public boolean equals(Object obj) {
        if (!c.class.isInstance(obj)) {
            return false;
        }
        return ((c) obj).f26324a.equals(this.f26324a);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.f26324a.getAnnotation(cls);
    }

    public Annotation[] getAnnotations() {
        return this.f26324a.getAnnotations();
    }

    public int hashCode() {
        return this.f26324a.hashCode();
    }

    public Method j() {
        return this.f26324a;
    }

    public final Class<?>[] k() {
        return this.f26324a.getParameterTypes();
    }

    public Class<?> l() {
        return this.f26324a.getReturnType();
    }

    public Object m(Object obj, Object... objArr) throws Throwable {
        return new a(obj, objArr).a();
    }

    /* renamed from: n */
    public boolean g(c cVar) {
        if (!cVar.c().equals(c()) || cVar.k().length != k().length) {
            return false;
        }
        for (int i11 = 0; i11 < cVar.k().length; i11++) {
            if (!cVar.k()[i11].equals(k()[i11])) {
                return false;
            }
        }
        return true;
    }

    public void o(boolean z11, List<Throwable> list) {
        if (h() != z11) {
            String str = z11 ? "should" : "should not";
            list.add(new Exception("Method " + this.f26324a.getName() + "() " + str + " be static"));
        }
        if (!e()) {
            list.add(new Exception("Method " + this.f26324a.getName() + "() should be public"));
        }
        if (this.f26324a.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.f26324a.getName() + "() should be void"));
        }
    }

    public void p(boolean z11, List<Throwable> list) {
        o(z11, list);
        if (this.f26324a.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.f26324a.getName() + " should have no parameters"));
        }
    }

    public String toString() {
        return this.f26324a.toString();
    }
}
