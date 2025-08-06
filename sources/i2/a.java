package i2;

import com.alibaba.fastjson.util.TypeUtils;
import d2.b;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class a implements Comparable<a> {

    /* renamed from: b  reason: collision with root package name */
    public final String f15962b;

    /* renamed from: c  reason: collision with root package name */
    public final Method f15963c;

    /* renamed from: d  reason: collision with root package name */
    public final Field f15964d;

    /* renamed from: e  reason: collision with root package name */
    public int f15965e = 0;

    /* renamed from: f  reason: collision with root package name */
    public final Class<?> f15966f;

    /* renamed from: g  reason: collision with root package name */
    public final Type f15967g;

    /* renamed from: h  reason: collision with root package name */
    public final Class<?> f15968h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f15969i;

    /* renamed from: j  reason: collision with root package name */
    public final int f15970j;

    /* renamed from: k  reason: collision with root package name */
    public final int f15971k;

    /* renamed from: l  reason: collision with root package name */
    public final String f15972l;

    /* renamed from: m  reason: collision with root package name */
    public final b f15973m;

    /* renamed from: n  reason: collision with root package name */
    public final b f15974n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f15975o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f15976p;

    /* renamed from: q  reason: collision with root package name */
    public final char[] f15977q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f15978r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f15979s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f15980t;

    /* renamed from: u  reason: collision with root package name */
    public final String f15981u;

    /* renamed from: v  reason: collision with root package name */
    public final String[] f15982v;

    public a(String str, Class<?> cls, Class<?> cls2, Type type, Field field, int i11, int i12, int i13) {
        this.f15962b = str;
        this.f15968h = cls;
        this.f15966f = cls2;
        this.f15967g = type;
        this.f15963c = null;
        this.f15964d = field;
        this.f15965e = i11;
        this.f15970j = i12;
        this.f15971k = 0;
        this.f15978r = cls2.isEnum();
        if (field != null) {
            int modifiers = field.getModifiers();
            int i14 = modifiers & 1;
            this.f15975o = true;
            this.f15976p = Modifier.isTransient(modifiers);
        } else {
            this.f15976p = false;
            this.f15975o = false;
        }
        this.f15977q = b();
        if (field != null) {
            TypeUtils.Y(field);
        }
        this.f15972l = "";
        this.f15973m = null;
        this.f15974n = null;
        this.f15969i = false;
        this.f15979s = false;
        this.f15980t = false;
        this.f15981u = null;
        this.f15982v = new String[0];
    }

    public static boolean f(Type[] typeArr, TypeVariable[] typeVariableArr, Type[] typeArr2) {
        if (typeArr2 == null || typeVariableArr.length == 0) {
            return false;
        }
        boolean z11 = false;
        for (int i11 = 0; i11 < typeArr.length; i11++) {
            ParameterizedType parameterizedType = typeArr[i11];
            if (parameterizedType instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = parameterizedType;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (f(actualTypeArguments, typeVariableArr, typeArr2)) {
                    typeArr[i11] = new c(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                    z11 = true;
                }
            } else if (parameterizedType instanceof TypeVariable) {
                for (int i12 = 0; i12 < typeVariableArr.length; i12++) {
                    if (parameterizedType.equals(typeVariableArr[i12])) {
                        typeArr[i11] = typeArr2[i12];
                        z11 = true;
                    }
                }
            }
        }
        return z11;
    }

    public static Type h(Class<?> cls, Type type, Type type2) {
        ParameterizedType parameterizedType;
        TypeVariable[] typeVariableArr;
        if (!(cls == null || type == null)) {
            if (type2 instanceof GenericArrayType) {
                Type genericComponentType = ((GenericArrayType) type2).getGenericComponentType();
                Type h11 = h(cls, type, genericComponentType);
                return genericComponentType != h11 ? Array.newInstance(TypeUtils.D(h11), 0).getClass() : type2;
            } else if (!TypeUtils.P(type)) {
                return type2;
            } else {
                if (type2 instanceof TypeVariable) {
                    ParameterizedType parameterizedType2 = (ParameterizedType) TypeUtils.J(type);
                    TypeVariable typeVariable = (TypeVariable) type2;
                    TypeVariable[] typeParameters = TypeUtils.D(parameterizedType2).getTypeParameters();
                    for (int i11 = 0; i11 < typeParameters.length; i11++) {
                        if (typeParameters[i11].getName().equals(typeVariable.getName())) {
                            return parameterizedType2.getActualTypeArguments()[i11];
                        }
                    }
                }
                if (type2 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType3 = (ParameterizedType) type2;
                    Type[] actualTypeArguments = parameterizedType3.getActualTypeArguments();
                    if (type instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) type;
                        typeVariableArr = cls.getTypeParameters();
                    } else if (cls.getGenericSuperclass() instanceof ParameterizedType) {
                        parameterizedType = (ParameterizedType) cls.getGenericSuperclass();
                        typeVariableArr = cls.getSuperclass().getTypeParameters();
                    } else {
                        typeVariableArr = type.getClass().getTypeParameters();
                        parameterizedType = parameterizedType3;
                    }
                    if (f(actualTypeArguments, typeVariableArr, parameterizedType.getActualTypeArguments())) {
                        return new c(actualTypeArguments, parameterizedType3.getOwnerType(), parameterizedType3.getRawType());
                    }
                }
            }
        }
        return type2;
    }

    public static Type j(Class<?> cls, Type type, TypeVariable<?> typeVariable) {
        Type[] typeArr;
        Class<?> cls2 = (Class) typeVariable.getGenericDeclaration();
        if (cls2 == cls) {
            typeArr = type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments() : null;
        } else {
            Type[] typeArr2 = null;
            Class<? super Object> cls3 = cls;
            while (cls3 != null && cls3 != Object.class && cls3 != cls2) {
                Type genericSuperclass = cls3.getGenericSuperclass();
                if (genericSuperclass instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                    f(actualTypeArguments, cls3.getTypeParameters(), typeArr2);
                    typeArr2 = actualTypeArguments;
                }
                cls3 = cls3.getSuperclass();
            }
            typeArr = typeArr2;
        }
        if (typeArr == null) {
            return null;
        }
        TypeVariable[] typeParameters = cls2.getTypeParameters();
        for (int i11 = 0; i11 < typeParameters.length; i11++) {
            if (typeVariable.equals(typeParameters[i11])) {
                return typeArr[i11];
            }
        }
        return null;
    }

    /* renamed from: a */
    public int compareTo(a aVar) {
        int i11 = this.f15965e;
        int i12 = aVar.f15965e;
        if (i11 < i12) {
            return -1;
        }
        if (i11 > i12) {
            return 1;
        }
        int compareTo = this.f15962b.compareTo(aVar.f15962b);
        if (compareTo != 0) {
            return compareTo;
        }
        Class<?> g11 = g();
        Class<?> g12 = aVar.g();
        if (!(g11 == null || g12 == null || g11 == g12)) {
            if (g11.isAssignableFrom(g12)) {
                return -1;
            }
            if (g12.isAssignableFrom(g11)) {
                return 1;
            }
        }
        Field field = this.f15964d;
        boolean z11 = false;
        boolean z12 = field != null && field.getType() == this.f15966f;
        Field field2 = aVar.f15964d;
        if (field2 != null && field2.getType() == aVar.f15966f) {
            z11 = true;
        }
        if (z12 && !z11) {
            return 1;
        }
        if (z11 && !z12) {
            return -1;
        }
        if (aVar.f15966f.isPrimitive() && !this.f15966f.isPrimitive()) {
            return 1;
        }
        if (this.f15966f.isPrimitive() && !aVar.f15966f.isPrimitive()) {
            return -1;
        }
        if (aVar.f15966f.getName().startsWith("java.") && !this.f15966f.getName().startsWith("java.")) {
            return 1;
        }
        if (!this.f15966f.getName().startsWith("java.") || aVar.f15966f.getName().startsWith("java.")) {
            return this.f15966f.getName().compareTo(aVar.f15966f.getName());
        }
        return -1;
    }

    public char[] b() {
        int length = this.f15962b.length();
        char[] cArr = new char[(length + 3)];
        String str = this.f15962b;
        str.getChars(0, str.length(), cArr, 1);
        cArr[0] = '\"';
        cArr[length + 1] = '\"';
        cArr[length + 2] = ':';
        return cArr;
    }

    public Object c(Object obj) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f15963c;
        if (method != null) {
            return method.invoke(obj, new Object[0]);
        }
        return this.f15964d.get(obj);
    }

    public b e() {
        b bVar = this.f15973m;
        if (bVar != null) {
            return bVar;
        }
        return this.f15974n;
    }

    public Class<?> g() {
        Method method = this.f15963c;
        if (method != null) {
            return method.getDeclaringClass();
        }
        Field field = this.f15964d;
        if (field != null) {
            return field.getDeclaringClass();
        }
        return null;
    }

    public String i() {
        return this.f15981u;
    }

    public Member k() {
        Method method = this.f15963c;
        if (method != null) {
            return method;
        }
        return this.f15964d;
    }

    public void l(Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        Method method = this.f15963c;
        if (method != null) {
            method.invoke(obj, new Object[]{obj2});
            return;
        }
        this.f15964d.set(obj, obj2);
    }

    public void m() throws SecurityException {
        Method method = this.f15963c;
        if (method != null) {
            TypeUtils.Y(method);
        } else {
            TypeUtils.Y(this.f15964d);
        }
    }

    public String toString() {
        return this.f15962b;
    }

    /* JADX WARNING: type inference failed for: r18v0, types: [java.lang.reflect.Type] */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001f, code lost:
        if (r9.equals(r14) != false) goto L_0x0024;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(java.lang.String r14, java.lang.reflect.Method r15, java.lang.reflect.Field r16, java.lang.Class<?> r17, java.lang.reflect.Type r18, int r19, int r20, int r21, d2.b r22, d2.b r23, java.lang.String r24) {
        /*
            r13 = this;
            r0 = r13
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r24
            java.lang.Class<java.lang.Object> r6 = java.lang.Object.class
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            r13.<init>()
            r8 = 0
            r0.f15965e = r8
            if (r2 == 0) goto L_0x0022
            java.lang.String r9 = r16.getName()
            r10 = r14
            boolean r11 = r9.equals(r14)
            if (r11 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0022:
            r10 = r14
        L_0x0023:
            r9 = r10
        L_0x0024:
            r0.f15962b = r9
            r0.f15963c = r1
            r0.f15964d = r2
            r9 = r19
            r0.f15965e = r9
            r9 = r20
            r0.f15970j = r9
            r9 = r21
            r0.f15971k = r9
            r9 = r22
            r0.f15973m = r9
            r9 = r23
            r0.f15974n = r9
            r9 = 1
            if (r2 == 0) goto L_0x0064
            int r10 = r16.getModifiers()
            r11 = r10 & 1
            if (r11 != 0) goto L_0x004e
            if (r1 != 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r11 = r8
            goto L_0x004f
        L_0x004e:
            r11 = r9
        L_0x004f:
            r0.f15975o = r11
            boolean r10 = java.lang.reflect.Modifier.isTransient(r10)
            if (r10 != 0) goto L_0x0060
            boolean r10 = com.alibaba.fastjson.util.TypeUtils.V(r15)
            if (r10 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r10 = r8
            goto L_0x0061
        L_0x0060:
            r10 = r9
        L_0x0061:
            r0.f15976p = r10
            goto L_0x0068
        L_0x0064:
            r0.f15975o = r8
            r0.f15976p = r8
        L_0x0068:
            if (r5 == 0) goto L_0x0073
            int r10 = r24.length()
            if (r10 <= 0) goto L_0x0073
            r0.f15972l = r5
            goto L_0x0077
        L_0x0073:
            java.lang.String r5 = ""
            r0.f15972l = r5
        L_0x0077:
            d2.b r5 = r13.e()
            r10 = 0
            if (r5 == 0) goto L_0x009f
            java.lang.String r11 = r5.format()
            java.lang.String r12 = r11.trim()
            int r12 = r12.length()
            if (r12 != 0) goto L_0x008d
            goto L_0x008e
        L_0x008d:
            r10 = r11
        L_0x008e:
            boolean r11 = r5.jsonDirect()
            boolean r12 = r5.unwrapped()
            r0.f15980t = r12
            java.lang.String[] r5 = r5.alternateNames()
            r0.f15982v = r5
            goto L_0x00a6
        L_0x009f:
            r0.f15980t = r8
            java.lang.String[] r5 = new java.lang.String[r8]
            r0.f15982v = r5
            r11 = r8
        L_0x00a6:
            r0.f15981u = r10
            char[] r5 = r13.b()
            r0.f15977q = r5
            if (r1 == 0) goto L_0x00b3
            com.alibaba.fastjson.util.TypeUtils.Y(r15)
        L_0x00b3:
            if (r2 == 0) goto L_0x00b8
            com.alibaba.fastjson.util.TypeUtils.Y(r16)
        L_0x00b8:
            if (r1 == 0) goto L_0x00eb
            java.lang.Class[] r2 = r15.getParameterTypes()
            int r5 = r2.length
            if (r5 != r9) goto L_0x00cb
            r2 = r2[r8]
            java.lang.reflect.Type[] r5 = r15.getGenericParameterTypes()
            r5 = r5[r8]
        L_0x00c9:
            r10 = r8
            goto L_0x00e4
        L_0x00cb:
            int r5 = r2.length
            r10 = 2
            if (r5 != r10) goto L_0x00db
            r5 = r2[r8]
            if (r5 != r7) goto L_0x00db
            r5 = r2[r9]
            if (r5 != r6) goto L_0x00db
            r2 = r2[r8]
            r5 = r2
            goto L_0x00c9
        L_0x00db:
            java.lang.Class r2 = r15.getReturnType()
            java.lang.reflect.Type r5 = r15.getGenericReturnType()
            r10 = r9
        L_0x00e4:
            java.lang.Class r1 = r15.getDeclaringClass()
            r0.f15968h = r1
            goto L_0x0102
        L_0x00eb:
            java.lang.Class r1 = r16.getType()
            java.lang.reflect.Type r5 = r16.getGenericType()
            java.lang.Class r10 = r16.getDeclaringClass()
            r0.f15968h = r10
            int r2 = r16.getModifiers()
            boolean r10 = java.lang.reflect.Modifier.isFinal(r2)
            r2 = r1
        L_0x0102:
            r0.f15969i = r10
            if (r11 == 0) goto L_0x0109
            if (r2 != r7) goto L_0x0109
            r8 = r9
        L_0x0109:
            r0.f15979s = r8
            if (r3 == 0) goto L_0x012b
            if (r2 != r6) goto L_0x012b
            boolean r1 = r5 instanceof java.lang.reflect.TypeVariable
            if (r1 == 0) goto L_0x012b
            r1 = r5
            java.lang.reflect.TypeVariable r1 = (java.lang.reflect.TypeVariable) r1
            java.lang.reflect.Type r1 = j(r3, r4, r1)
            if (r1 == 0) goto L_0x012b
            java.lang.Class r3 = com.alibaba.fastjson.util.TypeUtils.D(r1)
            r0.f15966f = r3
            r0.f15967g = r1
            boolean r1 = r2.isEnum()
            r0.f15978r = r1
            return
        L_0x012b:
            boolean r1 = r5 instanceof java.lang.Class
            if (r1 != 0) goto L_0x014b
            if (r4 == 0) goto L_0x0132
            goto L_0x0133
        L_0x0132:
            r4 = r3
        L_0x0133:
            java.lang.reflect.Type r1 = h(r3, r4, r5)
            if (r1 == r5) goto L_0x014a
            boolean r3 = r1 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x0142
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.D(r1)
            goto L_0x014a
        L_0x0142:
            boolean r3 = r1 instanceof java.lang.Class
            if (r3 == 0) goto L_0x014a
            java.lang.Class r2 = com.alibaba.fastjson.util.TypeUtils.D(r1)
        L_0x014a:
            r5 = r1
        L_0x014b:
            r0.f15967g = r5
            r0.f15966f = r2
            boolean r1 = r2.isEnum()
            r0.f15978r = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.a.<init>(java.lang.String, java.lang.reflect.Method, java.lang.reflect.Field, java.lang.Class, java.lang.reflect.Type, int, int, int, d2.b, d2.b, java.lang.String):void");
    }
}
