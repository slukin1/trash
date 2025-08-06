package kotlinx.serialization.internal;

import c10.a;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.k;
import kotlin.reflect.c;
import kotlinx.serialization.b;

public final class ClassValueParametrizedCache<T> implements e1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final p<c<Object>, List<? extends kotlin.reflect.p>, b<T>> f57653a;

    /* renamed from: b  reason: collision with root package name */
    public final ClassValueReferences<ParametrizedCacheEntry<T>> f57654b = new ClassValueReferences<>();

    public ClassValueParametrizedCache(p<? super c<Object>, ? super List<? extends kotlin.reflect.p>, ? extends b<T>> pVar) {
        this.f57653a = pVar;
    }

    public Object a(c<Object> cVar, List<? extends kotlin.reflect.p> list) {
        Object obj;
        MutableSoftReference mutableSoftReference = (MutableSoftReference) this.f57654b.get(a.a(cVar));
        T t11 = mutableSoftReference.f57663a.get();
        if (t11 == null) {
            t11 = mutableSoftReference.a(new ClassValueParametrizedCache$getgIAlus$$inlined$getOrSet$1());
        }
        ParametrizedCacheEntry parametrizedCacheEntry = (ParametrizedCacheEntry) t11;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (kotlin.reflect.p o0Var : list) {
            arrayList.add(new o0(o0Var));
        }
        ConcurrentHashMap a11 = parametrizedCacheEntry.f57668a;
        Object obj2 = a11.get(arrayList);
        if (obj2 == null) {
            try {
                Result.a aVar = Result.Companion;
                obj = Result.m3072constructorimpl(this.f57653a.invoke(cVar, list));
            } catch (Throwable th2) {
                Result.a aVar2 = Result.Companion;
                obj = Result.m3072constructorimpl(k.a(th2));
            }
            Result r62 = Result.m3071boximpl(obj);
            Object putIfAbsent = a11.putIfAbsent(arrayList, r62);
            obj2 = putIfAbsent == null ? r62 : putIfAbsent;
        }
        return ((Result) obj2).m3081unboximpl();
    }
}
