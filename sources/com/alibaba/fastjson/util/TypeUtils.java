package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hbg.lib.network.pro.core.bean.RiskActionData;
import com.huobi.login.usercenter.data.source.bean.KvStore;
import com.iproov.sdk.bridge.OptionsBridge;
import com.xiaomi.mipush.sdk.Constants;
import d2.b;
import d2.d;
import f2.e;
import h2.o;
import i2.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Currency;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TypeUtils {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f14428a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f14429b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f14430c = true;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f14431d = false;

    /* renamed from: e  reason: collision with root package name */
    public static Method f14432e = null;

    /* renamed from: f  reason: collision with root package name */
    public static boolean f14433f = false;

    /* renamed from: g  reason: collision with root package name */
    public static Method f14434g = null;

    /* renamed from: h  reason: collision with root package name */
    public static boolean f14435h = false;

    /* renamed from: i  reason: collision with root package name */
    public static Class<?> f14436i = null;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f14437j = false;

    /* renamed from: k  reason: collision with root package name */
    public static Class<? extends Annotation> f14438k = null;

    /* renamed from: l  reason: collision with root package name */
    public static Class<? extends Annotation> f14439l = null;

    /* renamed from: m  reason: collision with root package name */
    public static boolean f14440m = false;

    /* renamed from: n  reason: collision with root package name */
    public static Method f14441n = null;

    /* renamed from: o  reason: collision with root package name */
    public static boolean f14442o = false;

    /* renamed from: p  reason: collision with root package name */
    public static ConcurrentMap<String, Class<?>> f14443p = new ConcurrentHashMap(16, 0.75f, 1);

    /* renamed from: q  reason: collision with root package name */
    public static Class<?> f14444q;

    /* renamed from: r  reason: collision with root package name */
    public static boolean f14445r = false;

    static {
        try {
            f14428a = "true".equals(IOUtils.k("fastjson.compatibleWithJavaBean"));
            f14429b = "true".equals(IOUtils.k("fastjson.compatibleWithFieldName"));
        } catch (Throwable unused) {
        }
        a();
    }

    public static List<a> A(Class<?> cls, Map<String, String> map, boolean z11, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            y(cls2, map, propertyNamingStrategy, linkedHashMap, cls2.getDeclaredFields());
        }
        return I(cls, z11, linkedHashMap);
    }

    public static Collection B(Type type) {
        Type type2;
        Class<?> M = M(type);
        if (M == AbstractCollection.class || M == Collection.class) {
            return new ArrayList();
        }
        if (M.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (M.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (M.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (M.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (M.isAssignableFrom(EnumSet.class)) {
            if (type instanceof ParameterizedType) {
                type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            } else {
                type2 = Object.class;
            }
            return EnumSet.noneOf((Class) type2);
        }
        try {
            return (Collection) M.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class " + M.getName());
        }
    }

    public static String C(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static Class<?> D(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return D(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            return (Class) ((TypeVariable) type).getBounds()[0];
        }
        return Object.class;
    }

    public static Class<?> E(String str) {
        return (Class) f14443p.get(str);
    }

    public static Class<?> F(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (type2 instanceof Class) {
            Class<?> cls = (Class) type2;
            if (Modifier.isPublic(cls.getModifiers())) {
                return cls;
            }
            throw new JSONException("can not create ASMParser");
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Type G(Type type) {
        Type type2;
        if (type instanceof ParameterizedType) {
            type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof WildcardType) {
                Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
                if (upperBounds.length == 1) {
                    type2 = upperBounds[0];
                }
            }
        } else {
            if (type instanceof Class) {
                Class cls = (Class) type;
                if (!cls.getName().startsWith("java.")) {
                    type2 = G(cls.getGenericSuperclass());
                }
            }
            type2 = null;
        }
        return type2 == null ? Object.class : type2;
    }

    public static Field H(Class<?> cls, String str, Field[] fieldArr) {
        for (Field field : fieldArr) {
            if (str.equals(field.getName())) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return H(superclass, str, superclass.getDeclaredFields());
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<i2.a> I(java.lang.Class<?> r5, boolean r6, java.util.Map<java.lang.String, i2.a> r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.Class<d2.d> r1 = d2.d.class
            java.lang.annotation.Annotation r5 = r5.getAnnotation(r1)
            d2.d r5 = (d2.d) r5
            r1 = 0
            if (r5 == 0) goto L_0x002f
            java.lang.String[] r5 = r5.orders()
            if (r5 == 0) goto L_0x0030
            int r2 = r5.length
            int r3 = r7.size()
            if (r2 != r3) goto L_0x0030
            int r2 = r5.length
            r3 = r1
        L_0x001f:
            if (r3 >= r2) goto L_0x002d
            r4 = r5[r3]
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x002a
            goto L_0x0030
        L_0x002a:
            int r3 = r3 + 1
            goto L_0x001f
        L_0x002d:
            r2 = 1
            goto L_0x0031
        L_0x002f:
            r5 = 0
        L_0x0030:
            r2 = r1
        L_0x0031:
            if (r2 == 0) goto L_0x0044
            int r6 = r5.length
        L_0x0034:
            if (r1 >= r6) goto L_0x0061
            r2 = r5[r1]
            java.lang.Object r2 = r7.get(r2)
            i2.a r2 = (i2.a) r2
            r0.add(r2)
            int r1 = r1 + 1
            goto L_0x0034
        L_0x0044:
            java.util.Collection r5 = r7.values()
            java.util.Iterator r5 = r5.iterator()
        L_0x004c:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x005c
            java.lang.Object r7 = r5.next()
            i2.a r7 = (i2.a) r7
            r0.add(r7)
            goto L_0x004c
        L_0x005c:
            if (r6 == 0) goto L_0x0061
            java.util.Collections.sort(r0)
        L_0x0061:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.I(java.lang.Class, boolean, java.util.Map):java.util.List");
    }

    public static Type J(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? J(((Class) type).getGenericSuperclass()) : type;
    }

    public static int K(Class<?> cls) {
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar == null) {
            return 0;
        }
        return Feature.of(dVar.parseFeatures());
    }

    public static String L(Map<String, Field> map, String str, String str2, int i11) {
        if (!f14429b || map.containsKey(str2)) {
            return str2;
        }
        String substring = str.substring(i11);
        return map.containsKey(substring) ? substring : str2;
    }

    public static Class<?> M(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return M(((ParameterizedType) type).getRawType());
        }
        throw new JSONException(RiskActionData.ORDER_STATE_TODO);
    }

    public static b N(Class<?> cls, Method method) {
        boolean z11;
        b bVar;
        boolean z12;
        b bVar2;
        Class[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class[] parameterTypes = method.getParameterTypes();
            for (Class methods : interfaces) {
                for (Method method2 : methods.getMethods()) {
                    Class[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i11 = 0;
                        while (true) {
                            if (i11 >= parameterTypes.length) {
                                z12 = true;
                                break;
                            } else if (!parameterTypes2[i11].equals(parameterTypes[i11])) {
                                z12 = false;
                                break;
                            } else {
                                i11++;
                            }
                        }
                        if (z12 && (bVar2 = (b) method2.getAnnotation(b.class)) != null) {
                            return bVar2;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= parameterTypes3.length) {
                            z11 = true;
                            break;
                        } else if (!parameterTypes4[i12].equals(parameterTypes3[i12])) {
                            z11 = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                    if (z11 && (bVar = (b) method3.getAnnotation(b.class)) != null) {
                        return bVar;
                    }
                }
            }
        }
        return null;
    }

    public static boolean O(Method method) {
        if (method == null) {
            return false;
        }
        if (f14439l == null && !f14440m) {
            try {
                f14439l = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                f14440m = true;
            }
        }
        Class<? extends Annotation> cls = f14439l;
        if (cls == null) {
            return false;
        }
        return method.isAnnotationPresent(cls);
    }

    public static boolean P(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        if (!(type instanceof Class) || (genericSuperclass = ((Class) type).getGenericSuperclass()) == Object.class) {
            return false;
        }
        return P(genericSuperclass);
    }

    public static boolean Q(Object obj) {
        if (obj == null) {
            return false;
        }
        if (f14441n == null && !f14442o) {
            try {
                f14441n = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", new Class[]{Object.class});
            } catch (Throwable unused) {
                f14442o = true;
            }
        }
        Method method = f14441n;
        if (method != null) {
            try {
                return ((Boolean) method.invoke((Object) null, new Object[]{obj})).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    public static boolean R(Class<?> cls, String str) {
        d dVar = (d) cls.getAnnotation(d.class);
        if (dVar != null) {
            String[] includes = dVar.includes();
            if (includes.length > 0) {
                for (String equals : includes) {
                    if (str.equals(equals)) {
                        return false;
                    }
                }
                return true;
            }
            String[] ignores = dVar.ignores();
            for (String equals2 : ignores) {
                if (str.equals(equals2)) {
                    return true;
                }
            }
        }
        return (cls.getSuperclass() == Object.class || cls.getSuperclass() == null || !R(cls.getSuperclass(), str)) ? false : true;
    }

    public static boolean S(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt == '+' || charAt == '-') {
                if (i11 != 0) {
                    return false;
                }
            } else if (charAt < '0' || charAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean T(Class<?> cls) {
        if (f14444q == null && !f14445r) {
            try {
                f14444q = Class.forName("java.nio.file.Path");
            } catch (Throwable unused) {
                f14445r = true;
            }
        }
        Class<?> cls2 = f14444q;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static boolean U(Class<?> cls) {
        for (Class name : cls.getInterfaces()) {
            String name2 = name.getName();
            if (name2.equals("net.sf.cglib.proxy.Factory") || name2.equals("org.springframework.cglib.proxy.Factory") || name2.equals("javassist.util.proxy.ProxyObject") || name2.equals("org.apache.ibatis.javassist.util.proxy.ProxyObject")) {
                return true;
            }
        }
        return false;
    }

    public static boolean V(Method method) {
        if (method == null) {
            return false;
        }
        if (!f14437j) {
            try {
                f14438k = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f14437j = true;
                throw th2;
            }
            f14437j = true;
        }
        Class<? extends Annotation> cls = f14438k;
        if (cls == null || method.getAnnotation(cls) == null) {
            return false;
        }
        return true;
    }

    public static Class<?> W(String str) {
        return X(str, (ClassLoader) null);
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:32:0x0075 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Class<?> X(java.lang.String r5, java.lang.ClassLoader r6) {
        /*
            if (r5 == 0) goto L_0x007f
            int r0 = r5.length()
            if (r0 != 0) goto L_0x000a
            goto L_0x007f
        L_0x000a:
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r0 = f14443p
            java.lang.Object r0 = r0.get(r5)
            java.lang.Class r0 = (java.lang.Class) r0
            if (r0 == 0) goto L_0x0015
            return r0
        L_0x0015:
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 91
            r4 = 1
            if (r2 != r3) goto L_0x0030
            java.lang.String r5 = r5.substring(r4)
            java.lang.Class r5 = X(r5, r6)
            java.lang.Object r5 = java.lang.reflect.Array.newInstance(r5, r1)
            java.lang.Class r5 = r5.getClass()
            return r5
        L_0x0030:
            java.lang.String r1 = "L"
            boolean r1 = r5.startsWith(r1)
            if (r1 == 0) goto L_0x004e
            java.lang.String r1 = ";"
            boolean r1 = r5.endsWith(r1)
            if (r1 == 0) goto L_0x004e
            int r0 = r5.length()
            int r0 = r0 - r4
            java.lang.String r5 = r5.substring(r4, r0)
            java.lang.Class r5 = X(r5, r6)
            return r5
        L_0x004e:
            if (r6 == 0) goto L_0x005e
            java.lang.Class r0 = r6.loadClass(r5)     // Catch:{ all -> 0x005a }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r1 = f14443p     // Catch:{ all -> 0x005a }
            r1.put(r5, r0)     // Catch:{ all -> 0x005a }
            return r0
        L_0x005a:
            r1 = move-exception
            r1.printStackTrace()
        L_0x005e:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0075 }
            java.lang.ClassLoader r1 = r1.getContextClassLoader()     // Catch:{ all -> 0x0075 }
            if (r1 == 0) goto L_0x0075
            if (r1 == r6) goto L_0x0075
            java.lang.Class r6 = r1.loadClass(r5)     // Catch:{ all -> 0x0075 }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r0 = f14443p     // Catch:{ all -> 0x0074 }
            r0.put(r5, r6)     // Catch:{ all -> 0x0074 }
            return r6
        L_0x0074:
            r0 = r6
        L_0x0075:
            java.lang.Class r0 = java.lang.Class.forName(r5)     // Catch:{ all -> 0x007e }
            java.util.concurrent.ConcurrentMap<java.lang.String, java.lang.Class<?>> r6 = f14443p     // Catch:{ all -> 0x007e }
            r6.put(r5, r0)     // Catch:{ all -> 0x007e }
        L_0x007e:
            return r0
        L_0x007f:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.X(java.lang.String, java.lang.ClassLoader):java.lang.Class");
    }

    public static void Y(AccessibleObject accessibleObject) {
        if (f14430c && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (AccessControlException unused) {
                f14430c = false;
            }
        }
    }

    public static Locale Z(String str) {
        String[] split = str.split("_");
        if (split.length == 1) {
            return new Locale(split[0]);
        }
        if (split.length == 2) {
            return new Locale(split[0], split[1]);
        }
        return new Locale(split[0], split[1], split[2]);
    }

    public static void a() {
        Class<char[]> cls = char[].class;
        Class<boolean[]> cls2 = boolean[].class;
        Class<double[]> cls3 = double[].class;
        Class<float[]> cls4 = float[].class;
        Class<long[]> cls5 = long[].class;
        Class<int[]> cls6 = int[].class;
        Class<short[]> cls7 = short[].class;
        Class<byte[]> cls8 = byte[].class;
        f14443p.put("byte", Byte.TYPE);
        f14443p.put("short", Short.TYPE);
        f14443p.put("int", Integer.TYPE);
        f14443p.put("long", Long.TYPE);
        f14443p.put("float", Float.TYPE);
        f14443p.put("double", Double.TYPE);
        f14443p.put("boolean", Boolean.TYPE);
        f14443p.put("char", Character.TYPE);
        f14443p.put("[byte", cls8);
        f14443p.put("[short", cls7);
        f14443p.put("[int", cls6);
        f14443p.put("[long", cls5);
        f14443p.put("[float", cls4);
        f14443p.put("[double", cls3);
        f14443p.put("[boolean", cls2);
        f14443p.put("[char", cls);
        f14443p.put("[B", cls8);
        f14443p.put("[S", cls7);
        f14443p.put("[I", cls6);
        f14443p.put("[J", cls5);
        f14443p.put("[F", cls4);
        f14443p.put("[D", cls3);
        f14443p.put("[C", cls);
        f14443p.put("[Z", cls2);
        int i11 = 0;
        Class[] clsArr = {Object.class, Cloneable.class, W("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, Hashtable.class, TreeMap.class, IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, TimeUnit.class, ConcurrentHashMap.class, W("java.util.concurrent.ConcurrentSkipListMap"), W("java.util.concurrent.ConcurrentSkipListSet"), AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), BitSet.class, Calendar.class, Date.class, Locale.class, UUID.class, Time.class, java.sql.Date.class, Timestamp.class, SimpleDateFormat.class, JSONObject.class};
        for (int i12 = 0; i12 < 58; i12++) {
            Class cls9 = clsArr[i12];
            if (cls9 != null) {
                f14443p.put(cls9.getName(), cls9);
            }
        }
        String[] strArr = {"java.awt.Rectangle", "java.awt.Point", "java.awt.Font", "java.awt.Color"};
        for (int i13 = 0; i13 < 4; i13++) {
            Class<?> W = W(strArr[i13]);
            if (W == null) {
                break;
            }
            f14443p.put(W.getName(), W);
        }
        String[] strArr2 = {"org.springframework.util.LinkedMultiValueMap", "org.springframework.util.LinkedCaseInsensitiveMap", "org.springframework.remoting.support.RemoteInvocation", "org.springframework.remoting.support.RemoteInvocationResult"};
        while (i11 < 4) {
            Class<?> W2 = W(strArr2[i11]);
            if (W2 != null) {
                f14443p.put(W2.getName(), W2);
                i11++;
            } else {
                return;
            }
        }
    }

    public static Type a0(Type type) {
        if (!f14435h) {
            try {
                f14436i = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } catch (Throwable th2) {
                f14435h = true;
                throw th2;
            }
            f14435h = true;
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == f14436i ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static o b(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return c(cls, map, propertyNamingStrategy, false);
    }

    /* JADX WARNING: type inference failed for: r16v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static h2.o c(java.lang.Class<?> r16, java.util.Map<java.lang.String, java.lang.String> r17, com.alibaba.fastjson.PropertyNamingStrategy r18, boolean r19) {
        /*
            r6 = r16
            r7 = r17
            r8 = r18
            java.lang.Class<d2.d> r0 = d2.d.class
            java.lang.annotation.Annotation r0 = r6.getAnnotation(r0)
            r9 = r0
            d2.d r9 = (d2.d) r9
            r0 = 0
            r1 = 0
            if (r9 == 0) goto L_0x0084
            java.lang.String[] r2 = r9.orders()
            java.lang.String r3 = r9.typeName()
            int r4 = r3.length()
            if (r4 != 0) goto L_0x0022
            r3 = r1
        L_0x0022:
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r9.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            java.lang.Class r5 = r16.getSuperclass()
            r10 = r1
        L_0x002f:
            if (r5 == 0) goto L_0x0050
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            if (r5 == r11) goto L_0x0050
            java.lang.Class<d2.d> r11 = d2.d.class
            java.lang.annotation.Annotation r11 = r5.getAnnotation(r11)
            d2.d r11 = (d2.d) r11
            if (r11 != 0) goto L_0x0040
            goto L_0x0050
        L_0x0040:
            java.lang.String r10 = r11.typeKey()
            int r11 = r10.length()
            if (r11 == 0) goto L_0x004b
            goto L_0x0050
        L_0x004b:
            java.lang.Class r5 = r5.getSuperclass()
            goto L_0x002f
        L_0x0050:
            java.lang.Class[] r5 = r16.getInterfaces()
            int r11 = r5.length
            r12 = r0
        L_0x0056:
            if (r12 >= r11) goto L_0x0072
            r13 = r5[r12]
            java.lang.Class<d2.d> r14 = d2.d.class
            java.lang.annotation.Annotation r13 = r13.getAnnotation(r14)
            d2.d r13 = (d2.d) r13
            if (r13 == 0) goto L_0x006f
            java.lang.String r10 = r13.typeKey()
            int r13 = r10.length()
            if (r13 == 0) goto L_0x006f
            goto L_0x0072
        L_0x006f:
            int r12 = r12 + 1
            goto L_0x0056
        L_0x0072:
            if (r10 == 0) goto L_0x007f
            int r5 = r10.length()
            if (r5 != 0) goto L_0x007f
            r12 = r1
            r10 = r2
            r11 = r3
            r13 = r4
            goto L_0x0088
        L_0x007f:
            r11 = r3
            r13 = r4
            r12 = r10
            r10 = r2
            goto L_0x0088
        L_0x0084:
            r13 = r0
            r10 = r1
            r11 = r10
            r12 = r11
        L_0x0088:
            java.util.HashMap r14 = new java.util.HashMap
            r14.<init>()
            com.alibaba.fastjson.parser.ParserConfig.o(r6, r14)
            if (r19 == 0) goto L_0x0097
            java.util.List r0 = A(r6, r7, r0, r8)
            goto L_0x00a4
        L_0x0097:
            r4 = 0
            r0 = r16
            r1 = r9
            r2 = r17
            r3 = r14
            r5 = r18
            java.util.List r0 = z(r0, r1, r2, r3, r4, r5)
        L_0x00a4:
            int r1 = r0.size()
            i2.a[] r15 = new i2.a[r1]
            r0.toArray(r15)
            if (r10 == 0) goto L_0x00c8
            int r1 = r10.length
            if (r1 == 0) goto L_0x00c8
            if (r19 == 0) goto L_0x00ba
            r0 = 1
            java.util.List r0 = A(r6, r7, r0, r8)
            goto L_0x00d1
        L_0x00ba:
            r4 = 1
            r0 = r16
            r1 = r9
            r2 = r17
            r3 = r14
            r5 = r18
            java.util.List r0 = z(r0, r1, r2, r3, r4, r5)
            goto L_0x00d1
        L_0x00c8:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            java.util.Collections.sort(r1)
            r0 = r1
        L_0x00d1:
            int r1 = r0.size()
            i2.a[] r1 = new i2.a[r1]
            r0.toArray(r1)
            boolean r0 = java.util.Arrays.equals(r1, r15)
            if (r0 == 0) goto L_0x00e2
            r7 = r15
            goto L_0x00e3
        L_0x00e2:
            r7 = r1
        L_0x00e3:
            h2.o r8 = new h2.o
            r0 = r8
            r1 = r16
            r2 = r9
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.c(java.lang.Class, java.util.Map, com.alibaba.fastjson.PropertyNamingStrategy, boolean):h2.o");
    }

    public static <T> T d(Object obj, Class<T> cls, ParserConfig parserConfig) {
        T t11;
        int i11 = 0;
        if (obj == null) {
            if (cls == Integer.TYPE) {
                return 0;
            }
            if (cls == Long.TYPE) {
                return 0L;
            }
            if (cls == Short.TYPE) {
                return (short) 0;
            }
            if (cls == Byte.TYPE) {
                return (byte) 0;
            }
            if (cls == Float.TYPE) {
                return Float.valueOf(0.0f);
            }
            if (cls == Double.TYPE) {
                return Double.valueOf(0.0d);
            }
            if (cls == Boolean.TYPE) {
                return Boolean.FALSE;
            }
            return null;
        } else if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        } else if (cls == obj.getClass()) {
            return obj;
        } else {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection<Object> collection = (Collection) obj;
                        T newInstance = Array.newInstance(cls.getComponentType(), collection.size());
                        for (Object d11 : collection) {
                            Array.set(newInstance, i11, d(d11, cls.getComponentType(), parserConfig));
                            i11++;
                        }
                        return newInstance;
                    } else if (cls == byte[].class) {
                        return k(obj);
                    }
                }
                if (cls.isAssignableFrom(obj.getClass())) {
                    return obj;
                }
                if (cls == Boolean.TYPE || cls == Boolean.class) {
                    return i(obj);
                }
                if (cls == Byte.TYPE || cls == Byte.class) {
                    return j(obj);
                }
                if (cls == Character.TYPE || cls == Character.class) {
                    return l(obj);
                }
                if (cls == Short.TYPE || cls == Short.class) {
                    return u(obj);
                }
                if (cls == Integer.TYPE || cls == Integer.class) {
                    return q(obj);
                }
                if (cls == Long.TYPE || cls == Long.class) {
                    return t(obj);
                }
                if (cls == Float.TYPE || cls == Float.class) {
                    return p(obj);
                }
                if (cls == Double.TYPE || cls == Double.class) {
                    return n(obj);
                }
                if (cls == String.class) {
                    return w(obj);
                }
                if (cls == BigDecimal.class) {
                    return g(obj);
                }
                if (cls == BigInteger.class) {
                    return h(obj);
                }
                if (cls == Date.class) {
                    return m(obj);
                }
                if (cls == java.sql.Date.class) {
                    return v(obj);
                }
                if (cls == Timestamp.class) {
                    return x(obj);
                }
                if (cls.isEnum()) {
                    return o(obj, cls, parserConfig);
                }
                if (Calendar.class.isAssignableFrom(cls)) {
                    Date m11 = m(obj);
                    if (cls == Calendar.class) {
                        t11 = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    } else {
                        try {
                            t11 = (Calendar) cls.newInstance();
                        } catch (Exception e11) {
                            throw new JSONException("can not cast to : " + cls.getName(), e11);
                        }
                    }
                    t11.setTime(m11);
                    return t11;
                } else if (cls.getName().equals("javax.xml.datatype.XMLGregorianCalendar")) {
                    Date m12 = m(obj);
                    Calendar instance = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                    instance.setTime(m12);
                    return CalendarCodec.f14260b.f(instance);
                } else {
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                            return null;
                        }
                        if (cls == Currency.class) {
                            return Currency.getInstance(str);
                        }
                        if (cls == Locale.class) {
                            return Z(str);
                        }
                    }
                    throw new JSONException("can not cast to : " + cls.getName());
                }
            } else if (cls == Map.class) {
                return obj;
            } else {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                    return s(map, cls, parserConfig);
                }
                return obj;
            }
        }
    }

    public static <T> T e(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        T t11;
        Type rawType = parameterizedType.getRawType();
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType == Set.class || rawType == HashSet.class) {
                    t11 = new HashSet();
                } else if (rawType == TreeSet.class) {
                    t11 = new TreeSet();
                } else {
                    t11 = new ArrayList();
                }
                for (Object f11 : (Iterable) obj) {
                    t11.add(f(f11, type, parserConfig));
                }
                return t11;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            Type type3 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                T hashMap = new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    hashMap.put(f(entry.getKey(), type2, parserConfig), f(entry.getValue(), type3, parserConfig));
                }
                return hashMap;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        if (parameterizedType.getActualTypeArguments().length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return f(obj, rawType, parserConfig);
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }

    public static <T> T f(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == null) {
            return null;
        }
        if (type instanceof Class) {
            return d(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return e(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    public static BigDecimal g(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj instanceof BigInteger) {
            return new BigDecimal((BigInteger) obj);
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return null;
        }
        if (!(obj instanceof Map) || ((Map) obj).size() != 0) {
            return new BigDecimal(obj2);
        }
        return null;
    }

    public static BigInteger h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return BigInteger.valueOf(((Number) obj).longValue());
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0 || OptionsBridge.NULL_VALUE.equals(obj2) || "NULL".equals(obj2)) {
            return null;
        }
        return new BigInteger(obj2);
    }

    public static Boolean i(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof Number) {
            boolean z11 = true;
            if (((Number) obj).intValue() != 1) {
                z11 = false;
            }
            return Boolean.valueOf(z11);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if (com.sumsub.sns.internal.core.analytics.d.f31895b.equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if (KvStore.Y.equalsIgnoreCase(str) || "T".equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || KvStore.N.equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException("can not cast to boolean, value : " + obj);
    }

    public static Byte j(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Byte.valueOf(Byte.parseByte(str));
        }
        throw new JSONException("can not cast to byte, value : " + obj);
    }

    public static byte[] k(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.c((String) obj);
        }
        throw new JSONException("can not cast to int, value : " + obj);
    }

    public static Character l(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0) {
                return null;
            }
            if (str.length() == 1) {
                return Character.valueOf(str.charAt(0));
            }
            throw new JSONException("can not cast to char, value : " + obj);
        }
        throw new JSONException("can not cast to char, value : " + obj);
    }

    public static Date m(Object obj) {
        String str;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Date) {
            return (Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        long j11 = -1;
        if (obj instanceof Number) {
            return new Date(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str2 = (String) obj;
            e eVar = new e(str2);
            try {
                if (eVar.D0(false)) {
                    return eVar.U().getTime();
                }
                eVar.close();
                if (str2.startsWith("/Date(") && str2.endsWith(")/")) {
                    str2 = str2.substring(6, str2.length() - 2);
                }
                if (str2.indexOf(45) != -1) {
                    if (str2.length() == JSON.DEFFAULT_DATE_FORMAT.length()) {
                        str = JSON.DEFFAULT_DATE_FORMAT;
                    } else if (str2.length() == 10) {
                        str = "yyyy-MM-dd";
                    } else if (str2.length() == 19) {
                        str = "yyyy-MM-dd HH:mm:ss";
                    } else {
                        str = (str2.length() == 29 && str2.charAt(26) == ':' && str2.charAt(28) == '0') ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS";
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(str2);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : " + str2);
                    }
                } else if (str2.length() == 0) {
                    return null;
                } else {
                    j11 = Long.parseLong(str2);
                }
            } finally {
                eVar.close();
            }
        }
        if (j11 >= 0) {
            return new Date(j11);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (f14432e == null && !f14431d) {
                try {
                    f14432e = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } catch (Throwable th2) {
                    f14431d = true;
                    throw th2;
                }
                f14431d = true;
            }
            try {
                return (Date) f14432e.invoke(obj, new Object[0]);
            } catch (Exception e11) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e11);
            }
        } else if ("oracle.sql.DATE".equals(cls.getName())) {
            if (f14434g == null && !f14433f) {
                try {
                    f14434g = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused3) {
                } catch (Throwable th3) {
                    f14433f = true;
                    throw th3;
                }
                f14433f = true;
            }
            try {
                return (Date) f14434g.invoke(obj, new Object[0]);
            } catch (Exception e12) {
                throw new JSONException("can not cast oracle.sql.DATE to Date", e12);
            }
        } else {
            throw new JSONException("can not cast to Date, value : " + obj);
        }
    }

    public static Double n(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || OptionsBridge.NULL_VALUE.equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            return Double.valueOf(Double.parseDouble(obj2));
        }
        throw new JSONException("can not cast to double, value : " + obj);
    }

    public static <T> T o(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                return Enum.valueOf(cls, str);
            }
            if (obj instanceof Number) {
                int intValue = ((Number) obj).intValue();
                T[] enumConstants = cls.getEnumConstants();
                if (intValue < enumConstants.length) {
                    return enumConstants[intValue];
                }
            }
            throw new JSONException("can not cast to : " + cls.getName());
        } catch (Exception e11) {
            throw new JSONException("can not cast to : " + cls.getName(), e11);
        }
    }

    public static Float p(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (obj instanceof String) {
            String obj2 = obj.toString();
            if (obj2.length() == 0 || OptionsBridge.NULL_VALUE.equals(obj2) || "NULL".equals(obj2)) {
                return null;
            }
            if (obj2.indexOf(44) != 0) {
                obj2 = obj2.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            return Float.valueOf(Float.parseFloat(obj2));
        }
        throw new JSONException("can not cast to float, value : " + obj);
    }

    public static Integer q(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            return Integer.valueOf(Integer.parseInt(str));
        } else if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else {
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                    Iterator it2 = map.values().iterator();
                    it2.next();
                    return q(it2.next());
                }
            }
            throw new JSONException("can not cast to int, value : " + obj);
        }
    }

    public static <T> T r(Object obj, Class<T> cls) {
        return d(obj, cls, ParserConfig.m());
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [g2.l] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T s(java.util.Map<java.lang.String, java.lang.Object> r4, java.lang.Class<T> r5, com.alibaba.fastjson.parser.ParserConfig r6) {
        /*
            java.lang.Class<java.lang.StackTraceElement> r0 = java.lang.StackTraceElement.class
            r1 = 0
            if (r5 != r0) goto L_0x0032
            java.lang.String r5 = "className"
            java.lang.Object r5 = r4.get(r5)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = "methodName"
            java.lang.Object r6 = r4.get(r6)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = "fileName"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0115 }
            java.lang.String r2 = "lineNumber"
            java.lang.Object r4 = r4.get(r2)     // Catch:{ Exception -> 0x0115 }
            java.lang.Number r4 = (java.lang.Number) r4     // Catch:{ Exception -> 0x0115 }
            if (r4 != 0) goto L_0x0028
            goto L_0x002c
        L_0x0028:
            int r1 = r4.intValue()     // Catch:{ Exception -> 0x0115 }
        L_0x002c:
            java.lang.StackTraceElement r4 = new java.lang.StackTraceElement     // Catch:{ Exception -> 0x0115 }
            r4.<init>(r5, r6, r0, r1)     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x0032:
            java.lang.String r0 = com.alibaba.fastjson.JSON.DEFAULT_TYPE_KEY     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0115 }
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0115 }
            r3 = 0
            if (r2 == 0) goto L_0x006b
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0115 }
            if (r6 != 0) goto L_0x0043
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.f14180p     // Catch:{ Exception -> 0x0115 }
        L_0x0043:
            java.lang.Class r2 = r6.e(r0, r3)     // Catch:{ Exception -> 0x0115 }
            if (r2 == 0) goto L_0x0054
            boolean r0 = r2.equals(r5)     // Catch:{ Exception -> 0x0115 }
            if (r0 != 0) goto L_0x006b
            java.lang.Object r4 = s(r4, r2, r6)     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x0054:
            java.lang.ClassNotFoundException r4 = new java.lang.ClassNotFoundException     // Catch:{ Exception -> 0x0115 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0115 }
            r5.<init>()     // Catch:{ Exception -> 0x0115 }
            r5.append(r0)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r6 = " not found"
            r5.append(r6)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = r5.toString()     // Catch:{ Exception -> 0x0115 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0115 }
            throw r4     // Catch:{ Exception -> 0x0115 }
        L_0x006b:
            boolean r0 = r5.isInterface()     // Catch:{ Exception -> 0x0115 }
            if (r0 == 0) goto L_0x00ab
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0115 }
            if (r0 == 0) goto L_0x0078
            com.alibaba.fastjson.JSONObject r4 = (com.alibaba.fastjson.JSONObject) r4     // Catch:{ Exception -> 0x0115 }
            goto L_0x007e
        L_0x0078:
            com.alibaba.fastjson.JSONObject r0 = new com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0115 }
            r0.<init>((java.util.Map<java.lang.String, java.lang.Object>) r4)     // Catch:{ Exception -> 0x0115 }
            r4 = r0
        L_0x007e:
            if (r6 != 0) goto L_0x0084
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.m()     // Catch:{ Exception -> 0x0115 }
        L_0x0084:
            com.alibaba.fastjson.util.IdentityHashMap r6 = r6.k()     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r6 = r6.b(r5)     // Catch:{ Exception -> 0x0115 }
            g2.l r6 = (g2.l) r6     // Catch:{ Exception -> 0x0115 }
            if (r6 == 0) goto L_0x0099
            java.lang.String r4 = com.alibaba.fastjson.JSON.toJSONString(r4)     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r4 = com.alibaba.fastjson.JSON.parseObject((java.lang.String) r4, r5)     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x0099:
            java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0115 }
            java.lang.ClassLoader r6 = r6.getContextClassLoader()     // Catch:{ Exception -> 0x0115 }
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0115 }
            r0[r1] = r5     // Catch:{ Exception -> 0x0115 }
            java.lang.Object r4 = java.lang.reflect.Proxy.newProxyInstance(r6, r0, r4)     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x00ab:
            java.lang.Class<java.util.Locale> r0 = java.util.Locale.class
            if (r5 != r0) goto L_0x00d5
            java.lang.String r0 = "language"
            java.lang.Object r0 = r4.get(r0)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r1 = "country"
            java.lang.Object r1 = r4.get(r1)     // Catch:{ Exception -> 0x0115 }
            boolean r2 = r0 instanceof java.lang.String     // Catch:{ Exception -> 0x0115 }
            if (r2 == 0) goto L_0x00d5
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x0115 }
            boolean r2 = r1 instanceof java.lang.String     // Catch:{ Exception -> 0x0115 }
            if (r2 == 0) goto L_0x00cd
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0115 }
            java.util.Locale r4 = new java.util.Locale     // Catch:{ Exception -> 0x0115 }
            r4.<init>(r0, r1)     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x00cd:
            if (r1 != 0) goto L_0x00d5
            java.util.Locale r4 = new java.util.Locale     // Catch:{ Exception -> 0x0115 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x00d5:
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r5 != r0) goto L_0x00e2
            boolean r0 = r4 instanceof com.alibaba.fastjson.JSONObject     // Catch:{ Exception -> 0x0115 }
            if (r0 == 0) goto L_0x00e2
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x00e2:
            if (r6 != 0) goto L_0x00e8
            com.alibaba.fastjson.parser.ParserConfig r6 = com.alibaba.fastjson.parser.ParserConfig.m()     // Catch:{ Exception -> 0x0115 }
        L_0x00e8:
            g2.l r0 = r6.j(r5)     // Catch:{ Exception -> 0x0115 }
            boolean r1 = r0 instanceof g2.k     // Catch:{ Exception -> 0x0115 }
            if (r1 == 0) goto L_0x00f3
            r3 = r0
            g2.k r3 = (g2.k) r3     // Catch:{ Exception -> 0x0115 }
        L_0x00f3:
            if (r3 == 0) goto L_0x00fa
            java.lang.Object r4 = r3.f(r4, r6)     // Catch:{ Exception -> 0x0115 }
            return r4
        L_0x00fa:
            com.alibaba.fastjson.JSONException r4 = new com.alibaba.fastjson.JSONException     // Catch:{ Exception -> 0x0115 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0115 }
            r6.<init>()     // Catch:{ Exception -> 0x0115 }
            java.lang.String r0 = "can not get javaBeanDeserializer. "
            r6.append(r0)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = r5.getName()     // Catch:{ Exception -> 0x0115 }
            r6.append(r5)     // Catch:{ Exception -> 0x0115 }
            java.lang.String r5 = r6.toString()     // Catch:{ Exception -> 0x0115 }
            r4.<init>(r5)     // Catch:{ Exception -> 0x0115 }
            throw r4     // Catch:{ Exception -> 0x0115 }
        L_0x0115:
            r4 = move-exception
            com.alibaba.fastjson.JSONException r5 = new com.alibaba.fastjson.JSONException
            java.lang.String r6 = r4.getMessage()
            r5.<init>(r6, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.s(java.util.Map, java.lang.Class, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }

    public static Long t(Object obj) {
        Calendar calendar = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (str.indexOf(44) != 0) {
                str = str.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            try {
                return Long.valueOf(Long.parseLong(str));
            } catch (NumberFormatException unused) {
                e eVar = new e(str);
                if (eVar.D0(false)) {
                    calendar = eVar.U();
                }
                eVar.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it2 = map.values().iterator();
                it2.next();
                return t(it2.next());
            }
        }
        throw new JSONException("can not cast to long, value : " + obj);
    }

    public static Short u(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
            return Short.valueOf(Short.parseShort(str));
        }
        throw new JSONException("can not cast to short, value : " + obj);
    }

    public static java.sql.Date v(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.sql.Date) {
            return (java.sql.Date) obj;
        }
        if (obj instanceof Date) {
            return new java.sql.Date(((Date) obj).getTime());
        }
        if (obj instanceof Calendar) {
            return new java.sql.Date(((Calendar) obj).getTimeInMillis());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (S(str)) {
                longValue = Long.parseLong(str);
            } else {
                e eVar = new e(str);
                if (eVar.D0(false)) {
                    longValue = eVar.U().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (longValue > 0) {
            return new java.sql.Date(longValue);
        }
        throw new JSONException("can not cast to Date, value : " + obj);
    }

    public static String w(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Timestamp x(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Calendar) {
            return new Timestamp(((Calendar) obj).getTimeInMillis());
        }
        if (obj instanceof Timestamp) {
            return (Timestamp) obj;
        }
        if (obj instanceof Date) {
            return new Timestamp(((Date) obj).getTime());
        }
        long longValue = obj instanceof Number ? ((Number) obj).longValue() : 0;
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || OptionsBridge.NULL_VALUE.equals(str) || "NULL".equals(str)) {
                return null;
            }
            if (S(str)) {
                longValue = Long.parseLong(str);
            } else {
                e eVar = new e(str);
                if (eVar.D0(false)) {
                    longValue = eVar.U().getTime().getTime();
                } else {
                    throw new JSONException("can not cast to Timestamp, value : " + str);
                }
            }
        }
        if (longValue > 0) {
            return new Timestamp(longValue);
        }
        throw new JSONException("can not cast to Timestamp, value : " + obj);
    }

    public static void y(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, a> map2, Field[] fieldArr) {
        String str;
        int i11;
        int i12;
        int i13;
        Map<String, String> map3 = map;
        PropertyNamingStrategy propertyNamingStrategy2 = propertyNamingStrategy;
        Map<String, a> map4 = map2;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                b bVar = (b) field.getAnnotation(b.class);
                String name = field.getName();
                String str2 = null;
                if (bVar == null) {
                    str = null;
                    i13 = 0;
                    i12 = 0;
                    i11 = 0;
                } else if (bVar.serialize()) {
                    int ordinal = bVar.ordinal();
                    int of2 = SerializerFeature.of(bVar.serialzeFeatures());
                    int of3 = Feature.of(bVar.parseFeatures());
                    if (bVar.name().length() != 0) {
                        name = bVar.name();
                    }
                    if (bVar.label().length() != 0) {
                        str2 = bVar.label();
                    }
                    str = str2;
                    i13 = ordinal;
                    i12 = of2;
                    i11 = of3;
                }
                if (map3 == null || (name = map3.get(name)) != null) {
                    if (propertyNamingStrategy2 != null) {
                        name = propertyNamingStrategy2.translate(name);
                    }
                    String str3 = name;
                    if (!map4.containsKey(str3)) {
                        a aVar = r7;
                        a aVar2 = new a(str3, (Method) null, field, cls, (Type) null, i13, i12, i11, (b) null, bVar, str);
                        map4.put(str3, aVar);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0356, code lost:
        if (r0 == null) goto L_0x03c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x020c, code lost:
        if (r0 == null) goto L_0x0120;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<i2.a> z(java.lang.Class<?> r31, d2.d r32, java.util.Map<java.lang.String, java.lang.String> r33, java.util.Map<java.lang.String, java.lang.reflect.Field> r34, boolean r35, com.alibaba.fastjson.PropertyNamingStrategy r36) {
        /*
            r12 = r31
            r13 = r33
            r14 = r34
            r15 = r36
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            r11.<init>()
            java.lang.reflect.Method[] r10 = r31.getMethods()
            int r9 = r10.length
            r16 = 0
            r8 = r16
        L_0x0016:
            if (r8 >= r9) goto L_0x03d5
            r7 = r10[r8]
            java.lang.String r6 = r7.getName()
            r17 = 0
            int r0 = r7.getModifiers()
            boolean r0 = java.lang.reflect.Modifier.isStatic(r0)
            if (r0 == 0) goto L_0x0033
        L_0x002a:
            r22 = r8
            r26 = r9
            r27 = r10
        L_0x0030:
            r12 = r11
            goto L_0x03c8
        L_0x0033:
            java.lang.Class r0 = r7.getReturnType()
            java.lang.Class r1 = java.lang.Void.TYPE
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            goto L_0x002a
        L_0x0040:
            java.lang.Class[] r0 = r7.getParameterTypes()
            int r0 = r0.length
            if (r0 == 0) goto L_0x0048
            goto L_0x002a
        L_0x0048:
            java.lang.Class r0 = r7.getReturnType()
            java.lang.Class<java.lang.ClassLoader> r1 = java.lang.ClassLoader.class
            if (r0 != r1) goto L_0x0051
            goto L_0x002a
        L_0x0051:
            java.lang.String r0 = r7.getName()
            java.lang.String r1 = "getMetaClass"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006e
            java.lang.Class r0 = r7.getReturnType()
            java.lang.String r0 = r0.getName()
            java.lang.String r1 = "groovy.lang.MetaClass"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006e
            goto L_0x002a
        L_0x006e:
            java.lang.Class<d2.b> r0 = d2.b.class
            java.lang.annotation.Annotation r0 = r7.getAnnotation(r0)
            d2.b r0 = (d2.b) r0
            if (r0 != 0) goto L_0x007c
            d2.b r0 = N(r12, r7)
        L_0x007c:
            r18 = r0
            if (r18 == 0) goto L_0x00fd
            boolean r0 = r18.serialize()
            if (r0 != 0) goto L_0x0087
            goto L_0x002a
        L_0x0087:
            int r19 = r18.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r0 = r18.serialzeFeatures()
            int r20 = com.alibaba.fastjson.serializer.SerializerFeature.of(r0)
            com.alibaba.fastjson.parser.Feature[] r0 = r18.parseFeatures()
            int r21 = com.alibaba.fastjson.parser.Feature.of(r0)
            java.lang.String r0 = r18.name()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x00e7
            java.lang.String r0 = r18.name()
            if (r13 == 0) goto L_0x00b5
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x00b5
            goto L_0x002a
        L_0x00b5:
            r6 = r0
            i2.a r5 = new i2.a
            r3 = 0
            r22 = 0
            r23 = 0
            r0 = r5
            r1 = r6
            r2 = r7
            r4 = r31
            r7 = r5
            r5 = r22
            r24 = r6
            r6 = r19
            r25 = r7
            r7 = r20
            r22 = r8
            r8 = r21
            r26 = r9
            r9 = r18
            r27 = r10
            r10 = r23
            r15 = r11
            r11 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r1 = r24
            r0 = r25
            r15.put(r1, r0)
            goto L_0x0120
        L_0x00e7:
            r22 = r8
            r26 = r9
            r27 = r10
            r15 = r11
            java.lang.String r0 = r18.label()
            int r0 = r0.length()
            if (r0 == 0) goto L_0x010a
            java.lang.String r17 = r18.label()
            goto L_0x010a
        L_0x00fd:
            r22 = r8
            r26 = r9
            r27 = r10
            r15 = r11
            r19 = r16
            r20 = r19
            r21 = r20
        L_0x010a:
            java.lang.String r0 = "get"
            boolean r0 = r6.startsWith(r0)
            r23 = 0
            r11 = 102(0x66, float:1.43E-43)
            r10 = 95
            r9 = 3
            if (r0 == 0) goto L_0x028c
            int r0 = r6.length()
            r1 = 4
            if (r0 >= r1) goto L_0x0125
        L_0x0120:
            r12 = r15
            r15 = r36
            goto L_0x03c8
        L_0x0125:
            java.lang.String r0 = "getClass"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x012e
            goto L_0x0120
        L_0x012e:
            java.lang.String r0 = "getDeclaringClass"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x013d
            boolean r0 = r31.isEnum()
            if (r0 == 0) goto L_0x013d
        L_0x013c:
            goto L_0x0120
        L_0x013d:
            char r0 = r6.charAt(r9)
            boolean r2 = java.lang.Character.isUpperCase(r0)
            if (r2 != 0) goto L_0x0174
            r2 = 512(0x200, float:7.175E-43)
            if (r0 <= r2) goto L_0x014c
            goto L_0x0174
        L_0x014c:
            if (r0 != r10) goto L_0x0153
            java.lang.String r0 = r6.substring(r1)
            goto L_0x01a0
        L_0x0153:
            if (r0 != r11) goto L_0x015a
            java.lang.String r0 = r6.substring(r9)
            goto L_0x01a0
        L_0x015a:
            int r0 = r6.length()
            r2 = 5
            if (r0 < r2) goto L_0x0120
            char r0 = r6.charAt(r1)
            boolean r0 = java.lang.Character.isUpperCase(r0)
            if (r0 == 0) goto L_0x0120
            java.lang.String r0 = r6.substring(r9)
            java.lang.String r0 = C(r0)
            goto L_0x01a0
        L_0x0174:
            boolean r0 = f14428a
            if (r0 == 0) goto L_0x0181
            java.lang.String r0 = r6.substring(r9)
            java.lang.String r0 = C(r0)
            goto L_0x019c
        L_0x0181:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r2 = r6.charAt(r9)
            char r2 = java.lang.Character.toLowerCase(r2)
            r0.append(r2)
            java.lang.String r1 = r6.substring(r1)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L_0x019c:
            java.lang.String r0 = L(r14, r6, r0, r9)
        L_0x01a0:
            boolean r1 = R(r12, r0)
            if (r1 == 0) goto L_0x01a8
            goto L_0x0120
        L_0x01a8:
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.l(r0, r14)
            if (r1 != 0) goto L_0x01cd
            int r2 = r0.length()
            r3 = 1
            if (r2 <= r3) goto L_0x01cd
            char r2 = r0.charAt(r3)
            r3 = 65
            if (r2 < r3) goto L_0x01cd
            r3 = 90
            if (r2 > r3) goto L_0x01cd
            java.lang.String r1 = r6.substring(r9)
            java.lang.String r1 = C(r1)
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.l(r1, r14)
        L_0x01cd:
            r3 = r1
            if (r3 == 0) goto L_0x023b
            java.lang.Class<d2.b> r1 = d2.b.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            d2.b r1 = (d2.b) r1
            if (r1 == 0) goto L_0x0230
            boolean r2 = r1.serialize()
            if (r2 != 0) goto L_0x01e2
            goto L_0x0120
        L_0x01e2:
            int r2 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r1.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            com.alibaba.fastjson.parser.Feature[] r5 = r1.parseFeatures()
            int r5 = com.alibaba.fastjson.parser.Feature.of(r5)
            java.lang.String r8 = r1.name()
            int r8 = r8.length()
            if (r8 == 0) goto L_0x0210
            java.lang.String r0 = r1.name()
            if (r13 == 0) goto L_0x0210
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0210
            goto L_0x013c
        L_0x0210:
            java.lang.String r8 = r1.label()
            int r8 = r8.length()
            if (r8 == 0) goto L_0x0229
            java.lang.String r8 = r1.label()
            r17 = r1
            r20 = r2
            r21 = r4
            r24 = r5
            r19 = r8
            goto L_0x0245
        L_0x0229:
            r20 = r2
            r21 = r4
            r24 = r5
            goto L_0x0236
        L_0x0230:
            r24 = r21
            r21 = r20
            r20 = r19
        L_0x0236:
            r19 = r17
            r17 = r1
            goto L_0x0245
        L_0x023b:
            r24 = r21
            r21 = r20
            r20 = r19
            r19 = r17
            r17 = r23
        L_0x0245:
            if (r13 == 0) goto L_0x0251
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0251
            goto L_0x013c
        L_0x0251:
            r8 = r15
            r15 = r36
            if (r15 == 0) goto L_0x025a
            java.lang.String r0 = r15.translate(r0)
        L_0x025a:
            r5 = r0
            i2.a r4 = new i2.a
            r25 = 0
            r0 = r4
            r1 = r5
            r2 = r7
            r15 = r4
            r4 = r31
            r13 = r5
            r5 = r25
            r28 = r6
            r6 = r20
            r25 = r7
            r7 = r21
            r29 = r8
            r8 = r24
            r9 = r18
            r10 = r17
            r12 = r11
            r11 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r11 = r29
            r11.put(r13, r15)
            r17 = r19
            r19 = r20
            r20 = r21
            r21 = r24
            goto L_0x0292
        L_0x028c:
            r28 = r6
            r25 = r7
            r12 = r11
            r11 = r15
        L_0x0292:
            java.lang.String r0 = "is"
            r1 = r28
            boolean r0 = r1.startsWith(r0)
            if (r0 == 0) goto L_0x03c2
            int r0 = r1.length()
            r2 = 3
            if (r0 >= r2) goto L_0x02a5
            goto L_0x03c2
        L_0x02a5:
            java.lang.Class r0 = r25.getReturnType()
            java.lang.Class r3 = java.lang.Boolean.TYPE
            if (r0 == r3) goto L_0x02b7
            java.lang.Class r0 = r25.getReturnType()
            java.lang.Class<java.lang.Boolean> r3 = java.lang.Boolean.class
            if (r0 == r3) goto L_0x02b7
            goto L_0x03c2
        L_0x02b7:
            r0 = 2
            char r3 = r1.charAt(r0)
            boolean r4 = java.lang.Character.isUpperCase(r3)
            if (r4 == 0) goto L_0x02ef
            boolean r3 = f14428a
            if (r3 == 0) goto L_0x02cf
            java.lang.String r2 = r1.substring(r0)
            java.lang.String r2 = C(r2)
            goto L_0x02ea
        L_0x02cf:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            char r4 = r1.charAt(r0)
            char r4 = java.lang.Character.toLowerCase(r4)
            r3.append(r4)
            java.lang.String r2 = r1.substring(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
        L_0x02ea:
            java.lang.String r0 = L(r14, r1, r2, r0)
            goto L_0x02f7
        L_0x02ef:
            r4 = 95
            if (r3 != r4) goto L_0x02fa
            java.lang.String r0 = r1.substring(r2)
        L_0x02f7:
            r12 = r31
            goto L_0x0301
        L_0x02fa:
            if (r3 != r12) goto L_0x03c2
            java.lang.String r0 = r1.substring(r0)
            goto L_0x02f7
        L_0x0301:
            boolean r2 = R(r12, r0)
            if (r2 == 0) goto L_0x0309
            goto L_0x03c2
        L_0x0309:
            java.lang.reflect.Field r2 = com.alibaba.fastjson.parser.ParserConfig.l(r0, r14)
            if (r2 != 0) goto L_0x0315
            java.lang.reflect.Field r1 = com.alibaba.fastjson.parser.ParserConfig.l(r1, r14)
            r3 = r1
            goto L_0x0316
        L_0x0315:
            r3 = r2
        L_0x0316:
            if (r3 == 0) goto L_0x037f
            java.lang.Class<d2.b> r1 = d2.b.class
            java.lang.annotation.Annotation r1 = r3.getAnnotation(r1)
            d2.b r1 = (d2.b) r1
            if (r1 == 0) goto L_0x0375
            boolean r2 = r1.serialize()
            if (r2 != 0) goto L_0x032a
            goto L_0x03c2
        L_0x032a:
            int r2 = r1.ordinal()
            com.alibaba.fastjson.serializer.SerializerFeature[] r4 = r1.serialzeFeatures()
            int r4 = com.alibaba.fastjson.serializer.SerializerFeature.of(r4)
            com.alibaba.fastjson.parser.Feature[] r5 = r1.parseFeatures()
            int r5 = com.alibaba.fastjson.parser.Feature.of(r5)
            java.lang.String r6 = r1.name()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0359
            java.lang.String r0 = r1.name()
            r13 = r33
            if (r13 == 0) goto L_0x035b
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x035b
            goto L_0x0393
        L_0x0359:
            r13 = r33
        L_0x035b:
            java.lang.String r6 = r1.label()
            int r6 = r6.length()
            if (r6 == 0) goto L_0x0370
            java.lang.String r6 = r1.label()
            r10 = r1
            r7 = r4
            r8 = r5
            r17 = r6
            r6 = r2
            goto L_0x0389
        L_0x0370:
            r10 = r1
            r6 = r2
            r7 = r4
            r8 = r5
            goto L_0x0389
        L_0x0375:
            r13 = r33
            r10 = r1
            r6 = r19
            r7 = r20
            r8 = r21
            goto L_0x0389
        L_0x037f:
            r13 = r33
            r6 = r19
            r7 = r20
            r8 = r21
            r10 = r23
        L_0x0389:
            if (r13 == 0) goto L_0x0394
            java.lang.Object r0 = r13.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 != 0) goto L_0x0394
        L_0x0393:
            goto L_0x03c4
        L_0x0394:
            r15 = r36
            if (r15 == 0) goto L_0x039c
            java.lang.String r0 = r15.translate(r0)
        L_0x039c:
            r9 = r0
            boolean r0 = r11.containsKey(r9)
            if (r0 == 0) goto L_0x03a5
            goto L_0x0030
        L_0x03a5:
            i2.a r5 = new i2.a
            r19 = 0
            r0 = r5
            r1 = r9
            r2 = r25
            r4 = r31
            r14 = r5
            r5 = r19
            r30 = r9
            r9 = r18
            r12 = r11
            r11 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = r30
            r12.put(r0, r14)
            goto L_0x03c8
        L_0x03c2:
            r13 = r33
        L_0x03c4:
            r15 = r36
            goto L_0x0030
        L_0x03c8:
            int r8 = r22 + 1
            r14 = r34
            r11 = r12
            r9 = r26
            r10 = r27
            r12 = r31
            goto L_0x0016
        L_0x03d5:
            r12 = r11
            java.lang.reflect.Field[] r0 = r31.getFields()
            r1 = r31
            r2 = r12
            y(r1, r13, r15, r2, r0)
            r0 = r35
            java.util.List r0 = I(r1, r0, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.util.TypeUtils.z(java.lang.Class, d2.d, java.util.Map, java.util.Map, boolean, com.alibaba.fastjson.PropertyNamingStrategy):java.util.List");
    }
}
