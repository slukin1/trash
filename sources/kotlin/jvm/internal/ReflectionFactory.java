package kotlin.jvm.internal;

import java.util.List;
import kotlin.reflect.c;
import kotlin.reflect.e;
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

public class ReflectionFactory {
    public g a(FunctionReference functionReference) {
        return functionReference;
    }

    public c b(Class cls) {
        return new p(cls);
    }

    public f c(Class cls, String str) {
        return new a0(cls, str);
    }

    public i d(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public j e(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public k f(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    public p g(p pVar, p pVar2) {
        return new TypeReference(pVar.c(), pVar.g(), pVar2, ((TypeReference) pVar).k());
    }

    public m h(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public n i(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public o j(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    public String k(v vVar) {
        String obj = vVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }

    public String l(Lambda lambda) {
        return k(lambda);
    }

    public p m(e eVar, List<q> list, boolean z11) {
        return new TypeReference(eVar, list, z11);
    }
}
