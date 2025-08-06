package kotlinx.serialization.internal;

import d10.p;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.c;
import kotlinx.serialization.b;

public final class u<T> implements e1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final p<c<Object>, List<? extends kotlin.reflect.p>, b<T>> f57769a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, ParametrizedCacheEntry<T>> f57770b = new ConcurrentHashMap<>();

    public u(p<? super c<Object>, ? super List<? extends kotlin.reflect.p>, ? extends b<T>> pVar) {
        this.f57769a = pVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(kotlin.reflect.c<java.lang.Object> r6, java.util.List<? extends kotlin.reflect.p> r7) {
        /*
            r5 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, kotlinx.serialization.internal.ParametrizedCacheEntry<T>> r0 = r5.f57770b
            java.lang.Class r1 = c10.a.a(r6)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0019
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = new kotlinx.serialization.internal.ParametrizedCacheEntry
            r2.<init>()
            java.lang.Object r0 = r0.putIfAbsent(r1, r2)
            if (r0 != 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            r2 = r0
        L_0x0019:
            kotlinx.serialization.internal.ParametrizedCacheEntry r2 = (kotlinx.serialization.internal.ParametrizedCacheEntry) r2
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt__IterablesKt.u(r7, r1)
            r0.<init>(r1)
            java.util.Iterator r1 = r7.iterator()
        L_0x002a:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x003f
            java.lang.Object r3 = r1.next()
            kotlin.reflect.p r3 = (kotlin.reflect.p) r3
            kotlinx.serialization.internal.o0 r4 = new kotlinx.serialization.internal.o0
            r4.<init>(r3)
            r0.add(r4)
            goto L_0x002a
        L_0x003f:
            java.util.concurrent.ConcurrentHashMap r1 = r2.f57668a
            java.lang.Object r2 = r1.get(r0)
            if (r2 != 0) goto L_0x0070
            kotlin.Result$a r2 = kotlin.Result.Companion     // Catch:{ all -> 0x0058 }
            d10.p<kotlin.reflect.c<java.lang.Object>, java.util.List<? extends kotlin.reflect.p>, kotlinx.serialization.b<T>> r2 = r5.f57769a     // Catch:{ all -> 0x0058 }
            java.lang.Object r6 = r2.invoke(r6, r7)     // Catch:{ all -> 0x0058 }
            kotlinx.serialization.b r6 = (kotlinx.serialization.b) r6     // Catch:{ all -> 0x0058 }
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)     // Catch:{ all -> 0x0058 }
            goto L_0x0063
        L_0x0058:
            r6 = move-exception
            kotlin.Result$a r7 = kotlin.Result.Companion
            java.lang.Object r6 = kotlin.k.a(r6)
            java.lang.Object r6 = kotlin.Result.m3072constructorimpl(r6)
        L_0x0063:
            kotlin.Result r6 = kotlin.Result.m3071boximpl(r6)
            java.lang.Object r7 = r1.putIfAbsent(r0, r6)
            if (r7 != 0) goto L_0x006f
            r2 = r6
            goto L_0x0070
        L_0x006f:
            r2 = r7
        L_0x0070:
            kotlin.Result r2 = (kotlin.Result) r2
            java.lang.Object r6 = r2.m3081unboximpl()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.u.a(kotlin.reflect.c, java.util.List):java.lang.Object");
    }
}
