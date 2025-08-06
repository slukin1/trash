package i2;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.TypeUtils;
import d2.a;
import d2.d;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f15983a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<?> f15984b;

    /* renamed from: c  reason: collision with root package name */
    public final Constructor<?> f15985c;

    /* renamed from: d  reason: collision with root package name */
    public final Constructor<?> f15986d;

    /* renamed from: e  reason: collision with root package name */
    public final Method f15987e;

    /* renamed from: f  reason: collision with root package name */
    public final Method f15988f;

    /* renamed from: g  reason: collision with root package name */
    public final int f15989g;

    /* renamed from: h  reason: collision with root package name */
    public final a[] f15990h;

    /* renamed from: i  reason: collision with root package name */
    public final a[] f15991i;

    /* renamed from: j  reason: collision with root package name */
    public final int f15992j;

    /* renamed from: k  reason: collision with root package name */
    public final d f15993k;

    /* renamed from: l  reason: collision with root package name */
    public final String f15994l;

    /* renamed from: m  reason: collision with root package name */
    public final String f15995m;

    public b(Class<?> cls, Class<?> cls2, Constructor<?> constructor, Constructor<?> constructor2, Method method, Method method2, d dVar, List<a> list) {
        this.f15983a = cls;
        this.f15984b = cls2;
        this.f15985c = constructor;
        this.f15986d = constructor2;
        this.f15987e = method;
        this.f15992j = TypeUtils.K(cls);
        this.f15988f = method2;
        this.f15993k = dVar;
        String str = null;
        if (dVar != null) {
            String typeName = dVar.typeName();
            String typeKey = dVar.typeKey();
            this.f15995m = typeKey.length() > 0 ? typeKey : str;
            if (typeName.length() != 0) {
                this.f15994l = typeName;
            } else {
                this.f15994l = cls.getName();
            }
        } else {
            this.f15994l = cls.getName();
            this.f15995m = null;
        }
        a[] aVarArr = new a[list.size()];
        this.f15990h = aVarArr;
        list.toArray(aVarArr);
        a[] aVarArr2 = new a[aVarArr.length];
        System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
        Arrays.sort(aVarArr2);
        this.f15991i = !Arrays.equals(aVarArr, aVarArr2) ? aVarArr2 : aVarArr;
        if (constructor != null) {
            this.f15989g = constructor.getParameterTypes().length;
        } else if (method != null) {
            this.f15989g = method.getParameterTypes().length;
        } else {
            this.f15989g = 0;
        }
    }

    public static boolean a(List<a> list, a aVar) {
        a aVar2;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            aVar2 = list.get(size);
            if (!aVar2.f15962b.equals(aVar.f15962b) || (aVar2.f15969i && !aVar.f15969i)) {
                size--;
            }
        }
        if (aVar2.f15966f.isAssignableFrom(aVar.f15966f)) {
            list.remove(size);
        } else if (aVar2.compareTo(aVar) >= 0) {
            return false;
        } else {
            list.remove(size);
        }
        list.add(aVar);
        return true;
    }

    public static b b(Class<?> cls, Type type, PropertyNamingStrategy propertyNamingStrategy) {
        return c(cls, type, propertyNamingStrategy, false, TypeUtils.f14428a);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v96, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v97, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v99, resolved type: java.lang.Class<?>} */
    /* JADX WARNING: type inference failed for: r1v36, types: [java.lang.annotation.Annotation] */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x069c, code lost:
        if (r1.deserialize() == false) goto L_0x06a5;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:213:0x0588  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static i2.b c(java.lang.Class<?> r38, java.lang.reflect.Type r39, com.alibaba.fastjson.PropertyNamingStrategy r40, boolean r41, boolean r42) {
        /*
            r12 = r38
            r13 = r39
            r14 = r40
            java.lang.Class<java.lang.Object> r15 = java.lang.Object.class
            java.lang.Class<d2.d> r0 = d2.d.class
            java.lang.annotation.Annotation r0 = r12.getAnnotation(r0)
            r16 = r0
            d2.d r16 = (d2.d) r16
            java.lang.Class r11 = e(r16)
            java.lang.reflect.Field[] r10 = r38.getDeclaredFields()
            java.lang.reflect.Method[] r9 = r38.getMethods()
            if (r11 != 0) goto L_0x0022
            r0 = r12
            goto L_0x0023
        L_0x0022:
            r0 = r11
        L_0x0023:
            java.lang.reflect.Constructor r17 = g(r0)
            r18 = 0
            r5 = 0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            if (r41 == 0) goto L_0x0051
            r0 = r12
        L_0x0032:
            if (r0 == 0) goto L_0x0040
            java.lang.reflect.Field[] r1 = r0.getDeclaredFields()
            d(r12, r13, r14, r8, r1)
            java.lang.Class r0 = r0.getSuperclass()
            goto L_0x0032
        L_0x0040:
            i2.b r9 = new i2.b
            r4 = 0
            r0 = r9
            r1 = r38
            r2 = r11
            r3 = r17
            r6 = r18
            r7 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0051:
            boolean r0 = r38.isInterface()
            r7 = 1
            r6 = 0
            if (r0 != 0) goto L_0x0066
            int r0 = r38.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isAbstract(r0)
            if (r0 == 0) goto L_0x0064
            goto L_0x0066
        L_0x0064:
            r0 = r6
            goto L_0x0067
        L_0x0066:
            r0 = r7
        L_0x0067:
            r19 = 0
            if (r17 == 0) goto L_0x0075
            if (r0 == 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            r20 = r5
            r6 = r15
            r15 = r8
            r8 = r13
            goto L_0x01ac
        L_0x0075:
            java.lang.reflect.Constructor r20 = f(r38)
            java.lang.String r5 = "illegal json creator"
            if (r20 == 0) goto L_0x0111
            if (r0 != 0) goto L_0x0111
            com.alibaba.fastjson.util.TypeUtils.Y(r20)
            java.lang.Class[] r9 = r20.getParameterTypes()
            int r0 = r9.length
            if (r0 <= 0) goto L_0x00fe
            java.lang.annotation.Annotation[][] r13 = r20.getParameterAnnotations()
            r14 = r6
        L_0x008e:
            int r0 = r9.length
            if (r14 >= r0) goto L_0x00fe
            r0 = r13[r14]
            int r1 = r0.length
            r2 = r6
        L_0x0095:
            if (r2 >= r1) goto L_0x00a3
            r3 = r0[r2]
            boolean r4 = r3 instanceof d2.b
            if (r4 == 0) goto L_0x00a0
            d2.b r3 = (d2.b) r3
            goto L_0x00a5
        L_0x00a0:
            int r2 = r2 + 1
            goto L_0x0095
        L_0x00a3:
            r3 = r19
        L_0x00a5:
            if (r3 == 0) goto L_0x00f7
            r4 = r9[r14]
            java.lang.reflect.Type[] r0 = r20.getGenericParameterTypes()
            r7 = r0[r14]
            java.lang.String r0 = r3.name()
            java.lang.reflect.Field r15 = com.alibaba.fastjson.util.TypeUtils.H(r12, r0, r10)
            int r17 = r3.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r3.serialzeFeatures()
            int r18 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r3.parseFeatures()
            int r21 = com.alibaba.fastjson.parser.Feature.of(r0)
            i2.a r2 = new i2.a
            java.lang.String r1 = r3.name()
            r0 = r2
            r3 = r2
            r2 = r38
            r39 = r9
            r9 = r3
            r3 = r4
            r4 = r7
            r7 = r5
            r5 = r15
            r15 = r6
            r6 = r17
            r40 = r13
            r13 = r7
            r7 = r18
            r15 = r8
            r8 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            a(r15, r9)
            int r14 = r14 + 1
            r9 = r39
            r5 = r13
            r8 = r15
            r6 = 0
            r13 = r40
            goto L_0x008e
        L_0x00f7:
            r13 = r5
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r13)
            throw r0
        L_0x00fe:
            r15 = r8
            i2.b r9 = new i2.b
            r3 = 0
            r5 = 0
            r6 = 0
            r0 = r9
            r1 = r38
            r2 = r11
            r4 = r20
            r7 = r16
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0111:
            r37 = r13
            r13 = r5
            r5 = r6
            r6 = r15
            r15 = r8
            r8 = r37
            java.lang.reflect.Method r20 = h(r12, r9)
            if (r20 == 0) goto L_0x01aa
            com.alibaba.fastjson.util.TypeUtils.Y(r20)
            java.lang.Class[] r4 = r20.getParameterTypes()
            int r0 = r4.length
            if (r0 <= 0) goto L_0x01ac
            java.lang.annotation.Annotation[][] r9 = r20.getParameterAnnotations()
            r14 = r5
        L_0x012e:
            int r0 = r4.length
            if (r14 >= r0) goto L_0x0198
            r0 = r9[r14]
            int r1 = r0.length
            r6 = r5
        L_0x0135:
            if (r6 >= r1) goto L_0x0143
            r2 = r0[r6]
            boolean r3 = r2 instanceof d2.b
            if (r3 == 0) goto L_0x0140
            d2.b r2 = (d2.b) r2
            goto L_0x0145
        L_0x0140:
            int r6 = r6 + 1
            goto L_0x0135
        L_0x0143:
            r2 = r19
        L_0x0145:
            if (r2 == 0) goto L_0x0192
            r3 = r4[r14]
            java.lang.reflect.Type[] r0 = r20.getGenericParameterTypes()
            r6 = r0[r14]
            java.lang.String r0 = r2.name()
            java.lang.reflect.Field r7 = com.alibaba.fastjson.util.TypeUtils.H(r12, r0, r10)
            int r8 = r2.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r2.serialzeFeatures()
            int r17 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r2.parseFeatures()
            int r18 = com.alibaba.fastjson.parser.Feature.of(r0)
            i2.a r1 = new i2.a
            java.lang.String r2 = r2.name()
            r0 = r1
            r39 = r9
            r9 = r1
            r1 = r2
            r2 = r38
            r21 = r4
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r7
            r7 = r17
            r8 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            a(r15, r9)
            int r14 = r14 + 1
            r9 = r39
            r4 = r21
            r5 = 0
            goto L_0x012e
        L_0x0192:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            r0.<init>(r13)
            throw r0
        L_0x0198:
            i2.b r9 = new i2.b
            r3 = 0
            r4 = 0
            r6 = 0
            r0 = r9
            r1 = r38
            r2 = r11
            r5 = r20
            r7 = r16
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x01aa:
            if (r0 == 0) goto L_0x0710
        L_0x01ac:
            if (r17 == 0) goto L_0x01b1
            com.alibaba.fastjson.util.TypeUtils.Y(r17)
        L_0x01b1:
            if (r11 == 0) goto L_0x0344
            java.lang.Class<d2.c> r0 = d2.c.class
            java.lang.annotation.Annotation r0 = r11.getAnnotation(r0)
            d2.c r0 = (d2.c) r0
            if (r0 == 0) goto L_0x01c2
            java.lang.String r0 = r0.withPrefix()
            goto L_0x01c4
        L_0x01c2:
            r0 = r19
        L_0x01c4:
            if (r0 == 0) goto L_0x01cc
            int r1 = r0.length()
            if (r1 != 0) goto L_0x01ce
        L_0x01cc:
            java.lang.String r0 = "with"
        L_0x01ce:
            r13 = r0
            java.lang.reflect.Method[] r5 = r11.getMethods()
            int r4 = r5.length
            r3 = 0
        L_0x01d5:
            if (r3 >= r4) goto L_0x0303
            r2 = r5[r3]
            int r0 = r2.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x01f5
        L_0x01e3:
            r29 = r3
            r26 = r4
            r30 = r5
            r31 = r6
            r32 = r9
            r33 = r10
            r14 = r11
        L_0x01f0:
            r21 = r13
            r13 = 0
            goto L_0x02ed
        L_0x01f5:
            java.lang.Class r0 = r2.getReturnType()
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0200
            goto L_0x01e3
        L_0x0200:
            java.lang.Class<d2.b> r0 = d2.b.class
            java.lang.annotation.Annotation r0 = r2.getAnnotation(r0)
            d2.b r0 = (d2.b) r0
            if (r0 != 0) goto L_0x020e
            d2.b r0 = com.alibaba.fastjson.util.TypeUtils.N(r12, r2)
        L_0x020e:
            r21 = r0
            if (r21 == 0) goto L_0x027f
            boolean r0 = r21.deserialize()
            if (r0 != 0) goto L_0x0219
            goto L_0x01e3
        L_0x0219:
            int r23 = r21.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r21.serialzeFeatures()
            int r24 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r21.parseFeatures()
            int r25 = com.alibaba.fastjson.parser.Feature.of(r0)
            java.lang.String r0 = r21.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x026b
            java.lang.String r1 = r21.name()
            i2.a r0 = new i2.a
            r26 = 0
            r27 = 0
            r28 = 0
            r41 = r0
            r29 = r3
            r3 = r26
            r26 = r4
            r4 = r38
            r30 = r5
            r5 = r39
            r31 = r6
            r6 = r23
            r7 = r24
            r8 = r25
            r32 = r9
            r9 = r21
            r33 = r10
            r10 = r27
            r14 = r11
            r11 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            a(r15, r0)
            goto L_0x01f0
        L_0x026b:
            r29 = r3
            r26 = r4
            r30 = r5
            r31 = r6
            r32 = r9
            r33 = r10
            r14 = r11
            r6 = r23
            r7 = r24
            r8 = r25
            goto L_0x028f
        L_0x027f:
            r29 = r3
            r26 = r4
            r30 = r5
            r31 = r6
            r32 = r9
            r33 = r10
            r14 = r11
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x028f:
            java.lang.String r0 = r2.getName()
            boolean r1 = r0.startsWith(r13)
            if (r1 != 0) goto L_0x029b
        L_0x0299:
            goto L_0x01f0
        L_0x029b:
            int r1 = r0.length()
            int r3 = r13.length()
            if (r1 > r3) goto L_0x02a6
            goto L_0x0299
        L_0x02a6:
            int r1 = r13.length()
            char r1 = r0.charAt(r1)
            boolean r3 = java.lang.Character.isUpperCase(r1)
            if (r3 != 0) goto L_0x02b5
            goto L_0x0299
        L_0x02b5:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            int r4 = r13.length()
            java.lang.String r0 = r0.substring(r4)
            r3.<init>(r0)
            char r0 = java.lang.Character.toLowerCase(r1)
            r11 = 0
            r3.setCharAt(r11, r0)
            java.lang.String r1 = r3.toString()
            i2.a r10 = new i2.a
            r3 = 0
            r22 = 0
            r23 = 0
            r0 = r10
            r4 = r38
            r5 = r39
            r9 = r21
            r34 = r10
            r10 = r22
            r21 = r13
            r13 = r11
            r11 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r34
            a(r15, r0)
        L_0x02ed:
            int r3 = r29 + 1
            r8 = r39
            r11 = r14
            r13 = r21
            r4 = r26
            r5 = r30
            r6 = r31
            r9 = r32
            r10 = r33
            r7 = 1
            r14 = r40
            goto L_0x01d5
        L_0x0303:
            r31 = r6
            r32 = r9
            r33 = r10
            r14 = r11
            r13 = 0
            java.lang.Class<d2.c> r0 = d2.c.class
            java.lang.annotation.Annotation r0 = r14.getAnnotation(r0)
            d2.c r0 = (d2.c) r0
            if (r0 == 0) goto L_0x031a
            java.lang.String r0 = r0.buildMethod()
            goto L_0x031c
        L_0x031a:
            r0 = r19
        L_0x031c:
            if (r0 == 0) goto L_0x0324
            int r1 = r0.length()
            if (r1 != 0) goto L_0x0326
        L_0x0324:
            java.lang.String r0 = "build"
        L_0x0326:
            java.lang.Class[] r1 = new java.lang.Class[r13]     // Catch:{ NoSuchMethodException | SecurityException -> 0x032c }
            java.lang.reflect.Method r18 = r14.getMethod(r0, r1)     // Catch:{ NoSuchMethodException | SecurityException -> 0x032c }
        L_0x032c:
            if (r18 != 0) goto L_0x0336
            java.lang.String r0 = "create"
            java.lang.Class[] r1 = new java.lang.Class[r13]     // Catch:{ NoSuchMethodException | SecurityException -> 0x0336 }
            java.lang.reflect.Method r18 = r14.getMethod(r0, r1)     // Catch:{ NoSuchMethodException | SecurityException -> 0x0336 }
        L_0x0336:
            if (r18 == 0) goto L_0x033c
            com.alibaba.fastjson.util.TypeUtils.Y(r18)
            goto L_0x034c
        L_0x033c:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.String r1 = "buildMethod not found."
            r0.<init>(r1)
            throw r0
        L_0x0344:
            r31 = r6
            r32 = r9
            r33 = r10
            r14 = r11
            r13 = 0
        L_0x034c:
            r11 = r32
            int r10 = r11.length
            r9 = r13
        L_0x0350:
            r8 = 4
            r7 = 3
            if (r9 >= r10) goto L_0x05be
            r2 = r11[r9]
            r6 = 0
            r21 = 0
            r22 = 0
            java.lang.String r0 = r2.getName()
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x037b
        L_0x0369:
            r27 = r9
            r28 = r10
            r24 = r11
            r29 = r13
            r21 = r14
            r26 = r31
        L_0x0375:
            r25 = 1
        L_0x0377:
            r14 = r40
            goto L_0x05b0
        L_0x037b:
            java.lang.Class r1 = r2.getReturnType()
            java.lang.Class r3 = java.lang.Void.TYPE
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x0392
            java.lang.Class r3 = r2.getDeclaringClass()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0392
            goto L_0x0369
        L_0x0392:
            java.lang.Class r1 = r2.getDeclaringClass()
            r5 = r31
            if (r1 != r5) goto L_0x039c
            goto L_0x05a2
        L_0x039c:
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r3 = r1.length
            if (r3 == 0) goto L_0x05a2
            int r3 = r1.length
            r4 = 2
            if (r3 <= r4) goto L_0x03a9
            goto L_0x05a2
        L_0x03a9:
            java.lang.Class<d2.b> r3 = d2.b.class
            java.lang.annotation.Annotation r3 = r2.getAnnotation(r3)
            r23 = r3
            d2.b r23 = (d2.b) r23
            if (r23 == 0) goto L_0x03f1
            int r3 = r1.length
            if (r3 != r4) goto L_0x03f1
            r3 = r1[r13]
            java.lang.Class<java.lang.String> r4 = java.lang.String.class
            if (r3 != r4) goto L_0x03f1
            r4 = 1
            r3 = r1[r4]
            if (r3 != r5) goto L_0x03f1
            i2.a r8 = new i2.a
            r3 = 0
            r24 = 0
            r25 = 0
            java.lang.String r1 = ""
            r0 = r8
            r7 = r4
            r4 = r38
            r26 = r5
            r5 = r39
            r13 = r7
            r7 = r21
            r13 = r8
            r8 = r22
            r27 = r9
            r9 = r23
            r28 = r10
            r10 = r24
            r24 = r11
            r11 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            a(r15, r13)
        L_0x03ec:
            r21 = r14
            r25 = 1
            goto L_0x0401
        L_0x03f1:
            r26 = r5
            r27 = r9
            r28 = r10
            r24 = r11
            int r3 = r1.length
            r4 = 1
            if (r3 == r4) goto L_0x0405
            r25 = r4
            r21 = r14
        L_0x0401:
            r29 = 0
            goto L_0x0377
        L_0x0405:
            if (r23 != 0) goto L_0x040d
            d2.b r3 = com.alibaba.fastjson.util.TypeUtils.N(r12, r2)
            r9 = r3
            goto L_0x040f
        L_0x040d:
            r9 = r23
        L_0x040f:
            if (r9 != 0) goto L_0x0418
            int r3 = r0.length()
            if (r3 >= r8) goto L_0x0418
        L_0x0417:
            goto L_0x03ec
        L_0x0418:
            if (r9 == 0) goto L_0x0460
            boolean r3 = r9.deserialize()
            if (r3 != 0) goto L_0x0421
            goto L_0x0417
        L_0x0421:
            int r6 = r9.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r3 = r9.serialzeFeatures()
            int r10 = com.alibaba.fastjson.serializer.SerializerFeature.of(r3)
            com.alibaba.fastjson.parser.Feature[] r3 = r9.parseFeatures()
            int r11 = com.alibaba.fastjson.parser.Feature.of(r3)
            java.lang.String r3 = r9.name()
            int r3 = r3.length()
            if (r3 == 0) goto L_0x045c
            java.lang.String r1 = r9.name()
            i2.a r13 = new i2.a
            r3 = 0
            r21 = 0
            r22 = 0
            r0 = r13
            r4 = r38
            r5 = r39
            r7 = r10
            r8 = r11
            r10 = r21
            r11 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            a(r15, r13)
            goto L_0x03ec
        L_0x045c:
            r21 = r10
            r22 = r11
        L_0x0460:
            if (r9 != 0) goto L_0x046b
            java.lang.String r3 = "set"
            boolean r3 = r0.startsWith(r3)
            if (r3 != 0) goto L_0x046b
            goto L_0x0417
        L_0x046b:
            char r3 = r0.charAt(r7)
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 != 0) goto L_0x04a6
            r4 = 512(0x200, float:7.175E-43)
            if (r3 <= r4) goto L_0x047a
            goto L_0x04a6
        L_0x047a:
            r4 = 95
            if (r3 != r4) goto L_0x0483
            java.lang.String r0 = r0.substring(r8)
            goto L_0x04ce
        L_0x0483:
            r4 = 102(0x66, float:1.43E-43)
            if (r3 != r4) goto L_0x048c
            java.lang.String r0 = r0.substring(r7)
            goto L_0x04ce
        L_0x048c:
            int r3 = r0.length()
            r4 = 5
            if (r3 < r4) goto L_0x03ec
            char r3 = r0.charAt(r8)
            boolean r3 = java.lang.Character.isUpperCase(r3)
            if (r3 == 0) goto L_0x03ec
            java.lang.String r0 = r0.substring(r7)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.C(r0)
            goto L_0x04ce
        L_0x04a6:
            boolean r3 = com.alibaba.fastjson.util.TypeUtils.f14428a
            if (r3 == 0) goto L_0x04b3
            java.lang.String r0 = r0.substring(r7)
            java.lang.String r0 = com.alibaba.fastjson.util.TypeUtils.C(r0)
            goto L_0x04ce
        L_0x04b3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r4 = r0.charAt(r7)
            char r4 = java.lang.Character.toLowerCase(r4)
            r3.append(r4)
            java.lang.String r0 = r0.substring(r8)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
        L_0x04ce:
            r13 = r33
            java.lang.reflect.Field r3 = com.alibaba.fastjson.util.TypeUtils.H(r12, r0, r13)
            if (r3 != 0) goto L_0x0506
            r11 = 0
            r1 = r1[r11]
            java.lang.Class r4 = java.lang.Boolean.TYPE
            if (r1 != r4) goto L_0x0504
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "is"
            r1.append(r3)
            char r3 = r0.charAt(r11)
            char r3 = java.lang.Character.toUpperCase(r3)
            r1.append(r3)
            r10 = 1
            java.lang.String r3 = r0.substring(r10)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.H(r12, r1, r13)
            r3 = r1
            goto L_0x0508
        L_0x0504:
            r10 = 1
            goto L_0x0508
        L_0x0506:
            r10 = 1
            r11 = 0
        L_0x0508:
            if (r3 == 0) goto L_0x0578
            java.lang.Class<d2.b> r1 = d2.b.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            r23 = r1
            d2.b r23 = (d2.b) r23
            if (r23 == 0) goto L_0x056d
            boolean r1 = r23.deserialize()
            if (r1 != 0) goto L_0x0526
            r25 = r10
            r29 = r11
        L_0x0520:
            r33 = r13
            r21 = r14
            goto L_0x0377
        L_0x0526:
            int r6 = r23.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r1 = r23.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r1)
            com.alibaba.fastjson.parser.Feature[] r1 = r23.parseFeatures()
            int r8 = com.alibaba.fastjson.parser.Feature.of(r1)
            java.lang.String r1 = r23.name()
            int r1 = r1.length()
            if (r1 == 0) goto L_0x0564
            java.lang.String r1 = r23.name()
            i2.a r5 = new i2.a
            r21 = 0
            r0 = r5
            r4 = r38
            r35 = r5
            r5 = r39
            r25 = r10
            r10 = r23
            r29 = r11
            r11 = r21
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r35
            a(r15, r0)
            goto L_0x0520
        L_0x0564:
            r25 = r10
            r29 = r11
            r21 = r14
            r10 = r23
            goto L_0x0584
        L_0x056d:
            r25 = r10
            r29 = r11
            r7 = r21
            r8 = r22
            r10 = r23
            goto L_0x0582
        L_0x0578:
            r25 = r10
            r29 = r11
            r10 = r19
            r7 = r21
            r8 = r22
        L_0x0582:
            r21 = r14
        L_0x0584:
            r14 = r40
            if (r14 == 0) goto L_0x058c
            java.lang.String r0 = r14.translate(r0)
        L_0x058c:
            r1 = r0
            i2.a r11 = new i2.a
            r22 = 0
            r0 = r11
            r4 = r38
            r5 = r39
            r33 = r13
            r13 = r11
            r11 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            a(r15, r13)
            goto L_0x05b0
        L_0x05a2:
            r26 = r5
            r27 = r9
            r28 = r10
            r24 = r11
            r29 = r13
            r21 = r14
            goto L_0x0375
        L_0x05b0:
            int r9 = r27 + 1
            r14 = r21
            r11 = r24
            r31 = r26
            r10 = r28
            r13 = r29
            goto L_0x0350
        L_0x05be:
            r29 = r13
            r21 = r14
            r14 = r40
            java.lang.reflect.Field[] r0 = r38.getFields()
            r13 = r39
            d(r12, r13, r14, r15, r0)
            java.lang.reflect.Method[] r11 = r38.getMethods()
            int r10 = r11.length
            r9 = r29
        L_0x05d4:
            if (r9 >= r10) goto L_0x06fb
            r2 = r11[r9]
            java.lang.String r0 = r2.getName()
            int r1 = r0.length()
            if (r1 >= r8) goto L_0x05f0
        L_0x05e2:
            r22 = r7
            r23 = r8
            r29 = r9
            r19 = r10
            r24 = r11
            r27 = r33
            goto L_0x06ed
        L_0x05f0:
            int r1 = r2.getModifiers()
            boolean r1 = java.lang.reflect.Modifier.isStatic(r1)
            if (r1 == 0) goto L_0x05fb
            goto L_0x05e2
        L_0x05fb:
            java.lang.String r1 = "get"
            boolean r1 = r0.startsWith(r1)
            if (r1 == 0) goto L_0x05e2
            char r1 = r0.charAt(r7)
            boolean r1 = java.lang.Character.isUpperCase(r1)
            if (r1 == 0) goto L_0x05e2
            java.lang.Class[] r1 = r2.getParameterTypes()
            int r1 = r1.length
            if (r1 == 0) goto L_0x0615
            goto L_0x05e2
        L_0x0615:
            java.lang.Class<java.util.Collection> r1 = java.util.Collection.class
            java.lang.Class r3 = r2.getReturnType()
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 != 0) goto L_0x0645
            java.lang.Class<java.util.Map> r1 = java.util.Map.class
            java.lang.Class r3 = r2.getReturnType()
            boolean r1 = r1.isAssignableFrom(r3)
            if (r1 != 0) goto L_0x0645
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r1 = java.util.concurrent.atomic.AtomicBoolean.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x0645
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r1 = java.util.concurrent.atomic.AtomicInteger.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 == r3) goto L_0x0645
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r1 = java.util.concurrent.atomic.AtomicLong.class
            java.lang.Class r3 = r2.getReturnType()
            if (r1 != r3) goto L_0x05e2
        L_0x0645:
            java.lang.Class<d2.b> r1 = d2.b.class
            java.lang.annotation.Annotation r1 = r2.getAnnotation(r1)
            r19 = r1
            d2.b r19 = (d2.b) r19
            if (r19 == 0) goto L_0x0658
            boolean r1 = r19.deserialize()
            if (r1 == 0) goto L_0x0658
            goto L_0x05e2
        L_0x0658:
            if (r19 == 0) goto L_0x066b
            java.lang.String r1 = r19.name()
            int r1 = r1.length()
            if (r1 <= 0) goto L_0x066b
            java.lang.String r0 = r19.name()
            r6 = r33
            goto L_0x069f
        L_0x066b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            char r3 = r0.charAt(r7)
            char r3 = java.lang.Character.toLowerCase(r3)
            r1.append(r3)
            java.lang.String r0 = r0.substring(r8)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r6 = r33
            java.lang.reflect.Field r1 = com.alibaba.fastjson.util.TypeUtils.H(r12, r0, r6)
            if (r1 == 0) goto L_0x069f
            java.lang.Class<d2.b> r3 = d2.b.class
            java.lang.annotation.Annotation r1 = r1.getAnnotation(r3)
            d2.b r1 = (d2.b) r1
            if (r1 == 0) goto L_0x069f
            boolean r1 = r1.deserialize()
            if (r1 != 0) goto L_0x069f
            goto L_0x06a5
        L_0x069f:
            i2.a r1 = i(r15, r0)
            if (r1 == 0) goto L_0x06b2
        L_0x06a5:
            r27 = r6
            r22 = r7
            r23 = r8
            r29 = r9
            r19 = r10
            r24 = r11
            goto L_0x06ed
        L_0x06b2:
            if (r14 == 0) goto L_0x06b8
            java.lang.String r0 = r14.translate(r0)
        L_0x06b8:
            r1 = r0
            i2.a r5 = new i2.a
            r3 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r0 = r5
            r4 = r38
            r36 = r5
            r5 = r39
            r27 = r6
            r6 = r22
            r22 = r7
            r7 = r23
            r23 = r8
            r8 = r24
            r29 = r9
            r9 = r19
            r19 = r10
            r10 = r25
            r24 = r11
            r11 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r36
            a(r15, r0)
        L_0x06ed:
            int r9 = r29 + 1
            r10 = r19
            r7 = r22
            r8 = r23
            r11 = r24
            r33 = r27
            goto L_0x05d4
        L_0x06fb:
            i2.b r9 = new i2.b
            r4 = 0
            r0 = r9
            r1 = r38
            r2 = r21
            r3 = r17
            r5 = r20
            r6 = r18
            r7 = r16
            r8 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        L_0x0710:
            com.alibaba.fastjson.JSONException r0 = new com.alibaba.fastjson.JSONException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "default constructor not found. "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.b.c(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, boolean, boolean):i2.b");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004b, code lost:
        if ((java.util.Map.class.isAssignableFrom(r5) || java.util.Collection.class.isAssignableFrom(r5) || java.util.concurrent.atomic.AtomicLong.class.equals(r5) || java.util.concurrent.atomic.AtomicInteger.class.equals(r5) || java.util.concurrent.atomic.AtomicBoolean.class.equals(r5)) == false) goto L_0x0012;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(java.lang.Class<?> r18, java.lang.reflect.Type r19, com.alibaba.fastjson.PropertyNamingStrategy r20, java.util.List<i2.a> r21, java.lang.reflect.Field[] r22) {
        /*
            r0 = r20
            r1 = r22
            int r2 = r1.length
            r4 = 0
        L_0x0006:
            if (r4 >= r2) goto L_0x00d2
            r8 = r1[r4]
            int r5 = r8.getModifiers()
            r6 = r5 & 8
            if (r6 == 0) goto L_0x0016
        L_0x0012:
            r5 = r21
            goto L_0x00ce
        L_0x0016:
            r5 = r5 & 16
            r6 = 1
            if (r5 == 0) goto L_0x004e
            java.lang.Class r5 = r8.getType()
            java.lang.Class<java.util.Map> r7 = java.util.Map.class
            boolean r7 = r7.isAssignableFrom(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.Collection> r7 = java.util.Collection.class
            boolean r7 = r7.isAssignableFrom(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.concurrent.atomic.AtomicLong> r7 = java.util.concurrent.atomic.AtomicLong.class
            boolean r7 = r7.equals(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.concurrent.atomic.AtomicInteger> r7 = java.util.concurrent.atomic.AtomicInteger.class
            boolean r7 = r7.equals(r5)
            if (r7 != 0) goto L_0x004a
            java.lang.Class<java.util.concurrent.atomic.AtomicBoolean> r7 = java.util.concurrent.atomic.AtomicBoolean.class
            boolean r5 = r7.equals(r5)
            if (r5 == 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r5 = 0
            goto L_0x004b
        L_0x004a:
            r5 = r6
        L_0x004b:
            if (r5 != 0) goto L_0x004e
            goto L_0x0012
        L_0x004e:
            java.util.Iterator r5 = r21.iterator()
        L_0x0052:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x006b
            java.lang.Object r7 = r5.next()
            i2.a r7 = (i2.a) r7
            java.lang.String r7 = r7.f15962b
            java.lang.String r9 = r8.getName()
            boolean r7 = r7.equals(r9)
            if (r7 == 0) goto L_0x0052
            goto L_0x006c
        L_0x006b:
            r6 = 0
        L_0x006c:
            if (r6 == 0) goto L_0x006f
            goto L_0x0012
        L_0x006f:
            java.lang.String r5 = r8.getName()
            java.lang.Class<d2.b> r6 = d2.b.class
            java.lang.annotation.Annotation r6 = r8.getAnnotation(r6)
            r15 = r6
            d2.b r15 = (d2.b) r15
            if (r15 == 0) goto L_0x00ab
            boolean r6 = r15.deserialize()
            if (r6 != 0) goto L_0x0085
            goto L_0x0012
        L_0x0085:
            int r6 = r15.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r7 = r15.serialzeFeatures()
            int r7 = com.alibaba.fastjson.serializer.SerializerFeature.of(r7)
            com.alibaba.fastjson.parser.Feature[] r9 = r15.parseFeatures()
            int r9 = com.alibaba.fastjson.parser.Feature.of(r9)
            java.lang.String r10 = r15.name()
            int r10 = r10.length()
            if (r10 == 0) goto L_0x00a7
            java.lang.String r5 = r15.name()
        L_0x00a7:
            r11 = r6
            r12 = r7
            r13 = r9
            goto L_0x00ae
        L_0x00ab:
            r11 = 0
            r12 = 0
            r13 = 0
        L_0x00ae:
            if (r0 == 0) goto L_0x00b4
            java.lang.String r5 = r0.translate(r5)
        L_0x00b4:
            r6 = r5
            i2.a r14 = new i2.a
            r7 = 0
            r16 = 0
            r17 = 0
            r5 = r14
            r9 = r18
            r10 = r19
            r3 = r14
            r14 = r16
            r16 = r17
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r5 = r21
            a(r5, r3)
        L_0x00ce:
            int r4 = r4 + 1
            goto L_0x0006
        L_0x00d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.b.d(java.lang.Class, java.lang.reflect.Type, com.alibaba.fastjson.PropertyNamingStrategy, java.util.List, java.lang.reflect.Field[]):void");
    }

    public static Class<?> e(d dVar) {
        Class<?> builder;
        if (dVar == null || (builder = dVar.builder()) == Void.class) {
            return null;
        }
        return builder;
    }

    public static Constructor<?> f(Class<?> cls) {
        Constructor<?> constructor = null;
        for (Constructor<?> constructor2 : cls.getDeclaredConstructors()) {
            if (((a) constructor2.getAnnotation(a.class)) != null) {
                if (constructor == null) {
                    constructor = constructor2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        return constructor;
    }

    public static Constructor<?> g(Class<?> cls) {
        Constructor<?> constructor = null;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            Constructor<?> constructor2 = declaredConstructors[i11];
            if (constructor2.getParameterTypes().length == 0) {
                constructor = constructor2;
                break;
            }
            i11++;
        }
        if (constructor != null || !cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
            return constructor;
        }
        for (Constructor<?> constructor3 : declaredConstructors) {
            Class[] parameterTypes = constructor3.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(cls.getDeclaringClass())) {
                return constructor3;
            }
        }
        return constructor;
    }

    public static Method h(Class<?> cls, Method[] methodArr) {
        Method method = null;
        for (Method method2 : methodArr) {
            if (Modifier.isStatic(method2.getModifiers()) && cls.isAssignableFrom(method2.getReturnType()) && ((a) method2.getAnnotation(a.class)) != null) {
                if (method == null) {
                    method = method2;
                } else {
                    throw new JSONException("multi-JSONCreator");
                }
            }
        }
        return method;
    }

    public static a i(List<a> list, String str) {
        for (a next : list) {
            if (next.f15962b.equals(str)) {
                return next;
            }
            Field field = next.f15964d;
            if (field != null && next.e() != null && field.getName().equals(str)) {
                return next;
            }
        }
        return null;
    }
}
