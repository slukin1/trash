package kotlin.jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import kotlin.reflect.c;
import kotlin.reflect.f;
import kotlin.reflect.g;
import kotlin.reflect.i;
import kotlin.reflect.j;
import kotlin.reflect.k;
import kotlin.reflect.m;
import kotlin.reflect.n;
import kotlin.reflect.o;
import kotlin.reflect.p;
import kotlin.reflect.q;

public class Reflection {

    /* renamed from: a  reason: collision with root package name */
    public static final ReflectionFactory f56754a;

    /* renamed from: b  reason: collision with root package name */
    public static final c[] f56755b = new c[0];

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f56754a = reflectionFactory;
    }

    public static g a(FunctionReference functionReference) {
        return f56754a.a(functionReference);
    }

    public static c b(Class cls) {
        return f56754a.b(cls);
    }

    public static f c(Class cls) {
        return f56754a.c(cls, "");
    }

    public static i d(MutablePropertyReference0 mutablePropertyReference0) {
        return f56754a.d(mutablePropertyReference0);
    }

    public static j e(MutablePropertyReference1 mutablePropertyReference1) {
        return f56754a.e(mutablePropertyReference1);
    }

    public static k f(MutablePropertyReference2 mutablePropertyReference2) {
        return f56754a.f(mutablePropertyReference2);
    }

    public static p g(Class cls) {
        return f56754a.m(b(cls), Collections.emptyList(), true);
    }

    public static p h(p pVar, p pVar2) {
        return f56754a.g(pVar, pVar2);
    }

    public static m i(PropertyReference0 propertyReference0) {
        return f56754a.h(propertyReference0);
    }

    public static n j(PropertyReference1 propertyReference1) {
        return f56754a.i(propertyReference1);
    }

    public static o k(PropertyReference2 propertyReference2) {
        return f56754a.j(propertyReference2);
    }

    public static String l(v vVar) {
        return f56754a.k(vVar);
    }

    public static String m(Lambda lambda) {
        return f56754a.l(lambda);
    }

    public static p n(Class cls) {
        return f56754a.m(b(cls), Collections.emptyList(), false);
    }

    public static p o(Class cls, q qVar) {
        return f56754a.m(b(cls), Collections.singletonList(qVar), false);
    }

    public static p p(Class cls, q qVar, q qVar2) {
        return f56754a.m(b(cls), Arrays.asList(new q[]{qVar, qVar2}), false);
    }
}
