package kotlinx.serialization.internal;

import d10.l;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.reflect.c;
import kotlinx.serialization.b;

public final class t<T> implements r1<T> {

    /* renamed from: a  reason: collision with root package name */
    public final l<c<?>, b<T>> f57765a;

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentHashMap<Class<?>, l<T>> f57766b = new ConcurrentHashMap<>();

    public t(l<? super c<?>, ? extends b<T>> lVar) {
        this.f57765a = lVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = new kotlinx.serialization.internal.l(r4.f57765a.invoke(r5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlinx.serialization.b<T> a(kotlin.reflect.c<java.lang.Object> r5) {
        /*
            r4 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.Class<?>, kotlinx.serialization.internal.l<T>> r0 = r4.f57766b
            java.lang.Class r1 = c10.a.a(r5)
            java.lang.Object r2 = r0.get(r1)
            if (r2 != 0) goto L_0x0021
            kotlinx.serialization.internal.l r2 = new kotlinx.serialization.internal.l
            d10.l<kotlin.reflect.c<?>, kotlinx.serialization.b<T>> r3 = r4.f57765a
            java.lang.Object r5 = r3.invoke(r5)
            kotlinx.serialization.b r5 = (kotlinx.serialization.b) r5
            r2.<init>(r5)
            java.lang.Object r5 = r0.putIfAbsent(r1, r2)
            if (r5 != 0) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r2 = r5
        L_0x0021:
            kotlinx.serialization.internal.l r2 = (kotlinx.serialization.internal.l) r2
            kotlinx.serialization.b<T> r5 = r2.f57739a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.t.a(kotlin.reflect.c):kotlinx.serialization.b");
    }
}
