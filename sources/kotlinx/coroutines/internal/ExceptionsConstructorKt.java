package kotlinx.coroutines.internal;

import c10.a;
import d10.l;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import kotlin.Result;
import kotlin.k;
import kotlinx.coroutines.c0;

public final class ExceptionsConstructorKt {

    /* renamed from: a  reason: collision with root package name */
    public static final int f57282a = e(Throwable.class, -1);

    /* renamed from: b  reason: collision with root package name */
    public static final CtorCache f57283b;

    static {
        CtorCache ctorCache;
        try {
            if (l.a()) {
                ctorCache = j0.f57320a;
            } else {
                ctorCache = b.f57296a;
            }
        } catch (Throwable unused) {
            ctorCache = j0.f57320a;
        }
        f57283b = ctorCache;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00fc, code lost:
        r13 = (d10.l) r6.getFirst();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <E extends java.lang.Throwable> d10.l<java.lang.Throwable, java.lang.Throwable> b(java.lang.Class<E> r13) {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1 r1 = kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1.INSTANCE
            int r2 = f57282a
            r3 = 0
            int r4 = e(r13, r3)
            if (r2 == r4) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.reflect.Constructor[] r13 = r13.getConstructors()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r4 = r13.length
            r2.<init>(r4)
            int r4 = r13.length
            r5 = r3
        L_0x001a:
            r6 = 0
            if (r5 >= r4) goto L_0x00ba
            r7 = r13[r5]
            java.lang.Class[] r8 = r7.getParameterTypes()
            int r9 = r8.length
            if (r9 == 0) goto L_0x00a2
            r10 = 2
            r11 = -1
            r12 = 1
            if (r9 == r12) goto L_0x0065
            if (r9 == r10) goto L_0x0037
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            kotlin.Pair r6 = kotlin.l.a(r6, r7)
            goto L_0x00b3
        L_0x0037:
            r9 = r8[r3]
            boolean r9 = kotlin.jvm.internal.x.b(r9, r0)
            if (r9 == 0) goto L_0x005c
            r8 = r8[r12]
            java.lang.Class<java.lang.Throwable> r9 = java.lang.Throwable.class
            boolean r8 = kotlin.jvm.internal.x.b(r8, r9)
            if (r8 == 0) goto L_0x005c
            kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$1 r6 = new kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$1
            r6.<init>(r7)
            d10.l r6 = f(r6)
            r7 = 3
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            kotlin.Pair r6 = kotlin.l.a(r6, r7)
            goto L_0x00b3
        L_0x005c:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            kotlin.Pair r6 = kotlin.l.a(r6, r7)
            goto L_0x00b3
        L_0x0065:
            r8 = r8[r3]
            boolean r9 = kotlin.jvm.internal.x.b(r8, r0)
            if (r9 == 0) goto L_0x007f
            kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$2 r6 = new kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$2
            r6.<init>(r7)
            d10.l r6 = f(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r10)
            kotlin.Pair r6 = kotlin.l.a(r6, r7)
            goto L_0x00b3
        L_0x007f:
            java.lang.Class<java.lang.Throwable> r9 = java.lang.Throwable.class
            boolean r8 = kotlin.jvm.internal.x.b(r8, r9)
            if (r8 == 0) goto L_0x0099
            kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$3 r6 = new kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$3
            r6.<init>(r7)
            d10.l r6 = f(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r12)
            kotlin.Pair r6 = kotlin.l.a(r6, r7)
            goto L_0x00b3
        L_0x0099:
            java.lang.Integer r7 = java.lang.Integer.valueOf(r11)
            kotlin.Pair r6 = kotlin.l.a(r6, r7)
            goto L_0x00b3
        L_0x00a2:
            kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$4 r6 = new kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$1$4
            r6.<init>(r7)
            d10.l r6 = f(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)
            kotlin.Pair r6 = kotlin.l.a(r6, r7)
        L_0x00b3:
            r2.add(r6)
            int r5 = r5 + 1
            goto L_0x001a
        L_0x00ba:
            java.util.Iterator r13 = r2.iterator()
            boolean r0 = r13.hasNext()
            if (r0 != 0) goto L_0x00c5
            goto L_0x00f8
        L_0x00c5:
            java.lang.Object r6 = r13.next()
            boolean r0 = r13.hasNext()
            if (r0 != 0) goto L_0x00d0
            goto L_0x00f8
        L_0x00d0:
            r0 = r6
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.lang.Object r0 = r0.getSecond()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
        L_0x00dd:
            java.lang.Object r2 = r13.next()
            r3 = r2
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r3 = r3.getSecond()
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r0 >= r3) goto L_0x00f2
            r6 = r2
            r0 = r3
        L_0x00f2:
            boolean r2 = r13.hasNext()
            if (r2 != 0) goto L_0x00dd
        L_0x00f8:
            kotlin.Pair r6 = (kotlin.Pair) r6
            if (r6 == 0) goto L_0x0106
            java.lang.Object r13 = r6.getFirst()
            d10.l r13 = (d10.l) r13
            if (r13 != 0) goto L_0x0105
            goto L_0x0106
        L_0x0105:
            r1 = r13
        L_0x0106:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ExceptionsConstructorKt.b(java.lang.Class):d10.l");
    }

    public static final int c(Class<?> cls, int i11) {
        Class<? super Object> superclass;
        do {
            Field[] declaredFields = r5.getDeclaredFields();
            int length = declaredFields.length;
            int i12 = 0;
            Class<? super Object> cls2 = cls;
            for (int i13 = 0; i13 < length; i13++) {
                if (!Modifier.isStatic(declaredFields[i13].getModifiers())) {
                    i12++;
                }
            }
            i11 += i12;
            superclass = cls2.getSuperclass();
            cls2 = superclass;
        } while (superclass != null);
        return i11;
    }

    public static /* synthetic */ int d(Class cls, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return c(cls, i11);
    }

    public static final int e(Class<?> cls, int i11) {
        Integer num;
        a.c(cls);
        try {
            Result.a aVar = Result.Companion;
            num = Result.m3072constructorimpl(Integer.valueOf(d(cls, 0, 1, (Object) null)));
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            num = Result.m3072constructorimpl(k.a(th2));
        }
        Integer valueOf = Integer.valueOf(i11);
        if (Result.m3078isFailureimpl(num)) {
            num = valueOf;
        }
        return ((Number) num).intValue();
    }

    public static final l<Throwable, Throwable> f(l<? super Throwable, ? extends Throwable> lVar) {
        return new ExceptionsConstructorKt$safeCtor$1(lVar);
    }

    public static final <E extends Throwable> E g(E e11) {
        E e12;
        if (!(e11 instanceof c0)) {
            return (Throwable) f57283b.a(e11.getClass()).invoke(e11);
        }
        try {
            Result.a aVar = Result.Companion;
            e12 = Result.m3072constructorimpl(((c0) e11).createCopy());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            e12 = Result.m3072constructorimpl(k.a(th2));
        }
        if (Result.m3078isFailureimpl(e12)) {
            e12 = null;
        }
        return (Throwable) e12;
    }
}
