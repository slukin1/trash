package kotlinx.serialization.internal;

import d10.l;
import d10.p;
import java.util.List;
import kotlin.Result;
import kotlin.k;
import kotlin.reflect.c;
import kotlinx.serialization.b;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f57746a;

    static {
        Object obj;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m3072constructorimpl(Class.forName("java.lang.ClassValue"));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        if (Result.m3079isSuccessimpl(obj)) {
            Result.a aVar3 = Result.Companion;
            Class cls = (Class) obj;
            obj = Boolean.TRUE;
        }
        Object r02 = Result.m3072constructorimpl(obj);
        Boolean bool = Boolean.FALSE;
        if (Result.m3078isFailureimpl(r02)) {
            r02 = bool;
        }
        f57746a = ((Boolean) r02).booleanValue();
    }

    public static final <T> r1<T> a(l<? super c<?>, ? extends b<T>> lVar) {
        return f57746a ? new ClassValueCache(lVar) : new t(lVar);
    }

    public static final <T> e1<T> b(p<? super c<Object>, ? super List<? extends kotlin.reflect.p>, ? extends b<T>> pVar) {
        return f57746a ? new ClassValueParametrizedCache(pVar) : new u(pVar);
    }
}
