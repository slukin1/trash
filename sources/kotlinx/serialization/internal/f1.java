package kotlinx.serialization.internal;

import c10.a;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.x;
import kotlin.reflect.c;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.b;
import kotlinx.serialization.f;

public final class f1 {
    public static final Object a(Class<?> cls) {
        try {
            Field declaredField = cls.getDeclaredField("Companion");
            declaredField.setAccessible(true);
            return declaredField.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final <T> b<T> b(c<T> cVar) {
        return d(cVar, new b[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        if (r3 == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        r0 = r4.getField("INSTANCE");
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0073 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0074  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.b<T> c(java.lang.Class<T> r8, kotlinx.serialization.b<java.lang.Object>... r9) {
        /*
            boolean r0 = r8.isEnum()
            if (r0 == 0) goto L_0x0011
            boolean r0 = i(r8)
            if (r0 == 0) goto L_0x0011
            kotlinx.serialization.b r8 = e(r8)
            return r8
        L_0x0011:
            boolean r0 = r8.isInterface()
            if (r0 == 0) goto L_0x001e
            kotlinx.serialization.b r0 = g(r8)
            if (r0 == 0) goto L_0x001e
            return r0
        L_0x001e:
            int r0 = r9.length
            java.lang.Object[] r9 = java.util.Arrays.copyOf(r9, r0)
            kotlinx.serialization.b[] r9 = (kotlinx.serialization.b[]) r9
            kotlinx.serialization.b r9 = h(r8, r9)
            if (r9 == 0) goto L_0x002c
            return r9
        L_0x002c:
            kotlinx.serialization.b r9 = f(r8)
            if (r9 == 0) goto L_0x0033
            return r9
        L_0x0033:
            r9 = 0
            java.lang.Class[] r0 = r8.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x0070 }
            int r1 = r0.length     // Catch:{ NoSuchFieldException -> 0x0070 }
            r2 = 0
            r4 = r9
            r3 = r2
        L_0x003c:
            if (r2 >= r1) goto L_0x0054
            r5 = r0[r2]     // Catch:{ NoSuchFieldException -> 0x0070 }
            java.lang.String r6 = r5.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x0070 }
            java.lang.String r7 = "$serializer"
            boolean r6 = kotlin.jvm.internal.x.b(r6, r7)     // Catch:{ NoSuchFieldException -> 0x0070 }
            if (r6 == 0) goto L_0x0051
            if (r3 == 0) goto L_0x004f
            goto L_0x0056
        L_0x004f:
            r3 = 1
            r4 = r5
        L_0x0051:
            int r2 = r2 + 1
            goto L_0x003c
        L_0x0054:
            if (r3 != 0) goto L_0x0057
        L_0x0056:
            r4 = r9
        L_0x0057:
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ NoSuchFieldException -> 0x0070 }
            if (r4 == 0) goto L_0x0068
            java.lang.String r0 = "INSTANCE"
            java.lang.reflect.Field r0 = r4.getField(r0)     // Catch:{ NoSuchFieldException -> 0x0070 }
            if (r0 == 0) goto L_0x0068
            java.lang.Object r0 = r0.get(r9)     // Catch:{ NoSuchFieldException -> 0x0070 }
            goto L_0x0069
        L_0x0068:
            r0 = r9
        L_0x0069:
            boolean r1 = r0 instanceof kotlinx.serialization.b     // Catch:{ NoSuchFieldException -> 0x0070 }
            if (r1 == 0) goto L_0x0070
            kotlinx.serialization.b r0 = (kotlinx.serialization.b) r0     // Catch:{ NoSuchFieldException -> 0x0070 }
            goto L_0x0071
        L_0x0070:
            r0 = r9
        L_0x0071:
            if (r0 == 0) goto L_0x0074
            return r0
        L_0x0074:
            boolean r0 = j(r8)
            if (r0 == 0) goto L_0x0083
            kotlinx.serialization.PolymorphicSerializer r9 = new kotlinx.serialization.PolymorphicSerializer
            kotlin.reflect.c r8 = c10.a.c(r8)
            r9.<init>(r8)
        L_0x0083:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.f1.c(java.lang.Class, kotlinx.serialization.b[]):kotlinx.serialization.b");
    }

    public static final <T> b<T> d(c<T> cVar, b<Object>... bVarArr) {
        return c(a.a(cVar), (b[]) Arrays.copyOf(bVarArr, bVarArr.length));
    }

    public static final <T> b<T> e(Class<T> cls) {
        return new EnumSerializer(cls.getCanonicalName(), (Enum[]) cls.getEnumConstants());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003c, code lost:
        if (r5 == false) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0085, code lost:
        if (r5 == false) goto L_0x0087;
     */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0082 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.b<T> f(java.lang.Class<T> r11) {
        /*
            java.lang.reflect.Field[] r0 = r11.getDeclaredFields()
            int r1 = r0.length
            r2 = 0
            r3 = 0
            r4 = r2
            r5 = r4
            r6 = r3
        L_0x000a:
            r7 = 1
            if (r4 >= r1) goto L_0x003c
            r8 = r0[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "INSTANCE"
            boolean r9 = kotlin.jvm.internal.x.b(r9, r10)
            if (r9 == 0) goto L_0x0031
            java.lang.Class r9 = r8.getType()
            boolean r9 = kotlin.jvm.internal.x.b(r9, r11)
            if (r9 == 0) goto L_0x0031
            int r9 = r8.getModifiers()
            boolean r9 = java.lang.reflect.Modifier.isStatic(r9)
            if (r9 == 0) goto L_0x0031
            r9 = r7
            goto L_0x0032
        L_0x0031:
            r9 = r2
        L_0x0032:
            if (r9 == 0) goto L_0x0039
            if (r5 == 0) goto L_0x0037
            goto L_0x003e
        L_0x0037:
            r5 = r7
            r6 = r8
        L_0x0039:
            int r4 = r4 + 1
            goto L_0x000a
        L_0x003c:
            if (r5 != 0) goto L_0x003f
        L_0x003e:
            r6 = r3
        L_0x003f:
            java.lang.reflect.Field r6 = (java.lang.reflect.Field) r6
            if (r6 != 0) goto L_0x0044
            return r3
        L_0x0044:
            java.lang.Object r0 = r6.get(r3)
            java.lang.reflect.Method[] r11 = r11.getMethods()
            int r1 = r11.length
            r4 = r2
            r5 = r4
            r6 = r3
        L_0x0050:
            if (r4 >= r1) goto L_0x0085
            r8 = r11[r4]
            java.lang.String r9 = r8.getName()
            java.lang.String r10 = "serializer"
            boolean r9 = kotlin.jvm.internal.x.b(r9, r10)
            if (r9 == 0) goto L_0x007a
            java.lang.Class[] r9 = r8.getParameterTypes()
            int r9 = r9.length
            if (r9 != 0) goto L_0x0069
            r9 = r7
            goto L_0x006a
        L_0x0069:
            r9 = r2
        L_0x006a:
            if (r9 == 0) goto L_0x007a
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<kotlinx.serialization.b> r10 = kotlinx.serialization.b.class
            boolean r9 = kotlin.jvm.internal.x.b(r9, r10)
            if (r9 == 0) goto L_0x007a
            r9 = r7
            goto L_0x007b
        L_0x007a:
            r9 = r2
        L_0x007b:
            if (r9 == 0) goto L_0x0082
            if (r5 == 0) goto L_0x0080
            goto L_0x0087
        L_0x0080:
            r5 = r7
            r6 = r8
        L_0x0082:
            int r4 = r4 + 1
            goto L_0x0050
        L_0x0085:
            if (r5 != 0) goto L_0x0088
        L_0x0087:
            r6 = r3
        L_0x0088:
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            if (r6 != 0) goto L_0x008d
            return r3
        L_0x008d:
            java.lang.Object[] r11 = new java.lang.Object[r2]
            java.lang.Object r11 = r6.invoke(r0, r11)
            boolean r0 = r11 instanceof kotlinx.serialization.b
            if (r0 == 0) goto L_0x009a
            r3 = r11
            kotlinx.serialization.b r3 = (kotlinx.serialization.b) r3
        L_0x009a:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.f1.f(java.lang.Class):kotlinx.serialization.b");
    }

    public static final <T> b<T> g(Class<T> cls) {
        f fVar = (f) cls.getAnnotation(f.class);
        if (fVar == null || x.b(Reflection.b(fVar.with()), Reflection.b(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer(a.c(cls));
        }
        return null;
    }

    public static final <T> b<T> h(Class<?> cls, b<Object>... bVarArr) {
        Class[] clsArr;
        Object a11 = a(cls);
        if (a11 == null) {
            return null;
        }
        try {
            if (bVarArr.length == 0) {
                clsArr = new Class[0];
            } else {
                int length = bVarArr.length;
                Class[] clsArr2 = new Class[length];
                for (int i11 = 0; i11 < length; i11++) {
                    clsArr2[i11] = b.class;
                }
                clsArr = clsArr2;
            }
            Object invoke = a11.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(clsArr, clsArr.length)).invoke(a11, Arrays.copyOf(bVarArr, bVarArr.length));
            if (invoke instanceof b) {
                return (b) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (InvocationTargetException e11) {
            Throwable cause = e11.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e11.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e11;
        }
    }

    public static final <T> boolean i(Class<T> cls) {
        return cls.getAnnotation(f.class) == null && cls.getAnnotation(kotlinx.serialization.c.class) == null;
    }

    public static final <T> boolean j(Class<T> cls) {
        if (cls.getAnnotation(kotlinx.serialization.c.class) != null) {
            return true;
        }
        f fVar = (f) cls.getAnnotation(f.class);
        if (fVar == null || !x.b(Reflection.b(fVar.with()), Reflection.b(PolymorphicSerializer.class))) {
            return false;
        }
        return true;
    }

    public static final boolean k(c<Object> cVar) {
        return a.a(cVar).isArray();
    }

    public static final Void l(c<?> cVar) {
        g1.f(cVar);
        throw new KotlinNothingValueException();
    }

    public static final Void m(Class<?> cls) {
        throw new SerializationException(g1.e(a.c(cls)));
    }

    public static final <T, E extends T> E[] n(ArrayList<E> arrayList, c<T> cVar) {
        return arrayList.toArray((Object[]) Array.newInstance(a.a(cVar), arrayList.size()));
    }
}
