package com.mob.tools.utils;

import com.mob.commons.m;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ReflectHelper implements PublicMemberKeeper {

    /* renamed from: a  reason: collision with root package name */
    private static HashSet<String> f28131a;

    /* renamed from: b  reason: collision with root package name */
    private static HashMap<String, Class<?>> f28132b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<Class<?>, String> f28133c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static LinkedHashMap<String, Method> f28134d = new LinkedHashMap<String, Method>() {
        public boolean removeEldestEntry(Map.Entry<String, Method> entry) {
            return size() > 10;
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private static LinkedHashMap<String, Constructor<?>> f28135e = new LinkedHashMap<String, Constructor<?>>() {
        public boolean removeEldestEntry(Map.Entry<String, Constructor<?>> entry) {
            return size() > 10;
        }
    };

    public interface a<ArgType, RetType> {
        RetType a(ArgType argtype);
    }

    static {
        HashSet<String> hashSet = new HashSet<>();
        f28131a = hashSet;
        hashSet.add(m.a("009ZfeUb)bb1b2bjQebcJch"));
        f28131a.add(m.a("007Wfe7b(bb+b$bjbgbi"));
        f28131a.add(m.a("0084feEbZbbSb3bjUc*bgbi"));
        f28131a.add("java.net");
        f28131a.add(m.a("009Bfe5b!bbSb=bjbe+gXbg^e"));
        HashMap<String, Class<?>> hashMap = new HashMap<>();
        f28132b = hashMap;
        hashMap.put(m.a("006Mbabibedd=ed"), Double.TYPE);
        f28132b.put(m.a("005]cd8eObi.bg"), Float.TYPE);
        f28132b.put("long", Long.TYPE);
        f28132b.put(m.a("003Lbg_cg"), Integer.TYPE);
        f28132b.put("short", Short.TYPE);
        f28132b.put("byte", Byte.TYPE);
        f28132b.put(m.a("004afbEbh"), Character.TYPE);
        f28132b.put("boolean", Boolean.TYPE);
        f28132b.put("Object", Object.class);
        f28132b.put("String", String.class);
        f28132b.put("Thread", Thread.class);
        f28132b.put(m.a("0081ehbeRccb0dd:ed"), Runnable.class);
        f28132b.put(m.a("006*cjcadg,gd$bd"), System.class);
        f28132b.put(m.a("006ObabibeddKed"), Double.class);
        f28132b.put("Float", Float.class);
        f28132b.put("Long", Long.class);
        f28132b.put("Integer", Integer.class);
        f28132b.put(m.a("005+cj0fAbibh,g"), Short.class);
        f28132b.put("Byte", Byte.class);
        f28132b.put(m.a("009Wcb>fb3bh5bagdYbh"), Character.class);
        f28132b.put("Boolean", Boolean.class);
        for (Map.Entry next : f28132b.entrySet()) {
            f28133c.put(next.getValue(), next.getKey());
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|9|10|11|12|(1:20)|6) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0036 */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0040 A[EDGE_INSN: B:20:0x0040->B:14:0x0040 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.Class<?> a(java.lang.String r4) {
        /*
            java.lang.Class<com.mob.tools.utils.ReflectHelper> r0 = com.mob.tools.utils.ReflectHelper.class
            monitor-enter(r0)
            java.util.HashMap<java.lang.String, java.lang.Class<?>> r1 = f28132b     // Catch:{ all -> 0x0042 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0042 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x0042 }
            if (r1 != 0) goto L_0x0040
            java.util.HashSet<java.lang.String> r2 = f28131a     // Catch:{ all -> 0x0042 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0042 }
        L_0x0013:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x0040
            java.lang.Object r1 = r2.next()     // Catch:{ all -> 0x0042 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x0042 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r3.<init>()     // Catch:{ all -> 0x0036 }
            r3.append(r1)     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = "."
            r3.append(r1)     // Catch:{ all -> 0x0036 }
            r3.append(r4)     // Catch:{ all -> 0x0036 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0036 }
            importClass(r1)     // Catch:{ all -> 0x0036 }
        L_0x0036:
            java.util.HashMap<java.lang.String, java.lang.Class<?>> r1 = f28132b     // Catch:{ all -> 0x0042 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0042 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0013
        L_0x0040:
            monitor-exit(r0)
            return r1
        L_0x0042:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ReflectHelper.a(java.lang.String):java.lang.Class");
    }

    private static boolean b(Class<?>[] clsArr, Class<?>[] clsArr2) {
        boolean z11;
        if (clsArr.length - clsArr2.length != 1) {
            return false;
        }
        int i11 = 0;
        while (true) {
            if (i11 < clsArr2.length) {
                if (clsArr2[i11] != null && !a(clsArr[i11], clsArr2[i11]) && !clsArr[i11].isAssignableFrom(clsArr2[i11])) {
                    z11 = false;
                    break;
                }
                i11++;
            } else {
                z11 = true;
                break;
            }
        }
        if (!z11 || !clsArr[clsArr.length - 1].isArray()) {
            return false;
        }
        return true;
    }

    public static Object createProxy(HashMap<String, a<Object, Object[]>> hashMap, Class<?>... clsArr) throws Throwable {
        HashMap hashMap2 = new HashMap();
        for (final Map.Entry next : hashMap.entrySet()) {
            hashMap2.put(next.getKey(), new a<Object[], Object>() {
                public Object a(Object[] objArr) {
                    return ((Object[]) ((a) next.getValue()).a(objArr))[0];
                }
            });
        }
        return createProxy((Map<String, a<Object[], Object>>) hashMap2, clsArr);
    }

    public static Class<?> getClass(String str) throws Throwable {
        Class<?> a11 = a(str);
        if (a11 != null) {
            return a11;
        }
        try {
            a11 = Class.forName(str);
            f28132b.put(str, a11);
            return a11;
        } catch (Throwable unused) {
            return a11;
        }
    }

    public static <T> T getInstanceField(Object obj, String str, T t11) {
        try {
            return getInstanceField(obj, str);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return t11;
        }
    }

    public static String getName(Class<?> cls) throws Throwable {
        String str = f28133c.get(cls);
        if (str == null) {
            str = cls.getSimpleName();
            if (f28132b.containsKey(str)) {
                f28133c.remove(f28132b.get(str));
            }
            f28132b.put(str, cls);
            f28133c.put(cls, str);
        }
        return str;
    }

    public static <T> T getStaticField(String str, String str2, T t11) {
        try {
            getStaticField(str, str2);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        return t11;
    }

    public static String importClass(String str) throws Throwable {
        return importClass((String) null, str);
    }

    public static String importClassNoThrow(String str, String str2) {
        try {
            return importClass(str);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return str2;
        }
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr, T t11) {
        try {
            return invokeInstanceMethod(obj, str, objArr, clsArr);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return t11;
        }
    }

    public static <T> T invokeInstanceMethodNoThrow(Object obj, String str, T t11, Object... objArr) {
        try {
            return invokeInstanceMethod(obj, str, objArr);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return t11;
        }
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr, T t11) {
        try {
            invokeStaticMethod(str, str2, objArr, clsArr);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
        }
        return t11;
    }

    public static <T> T invokeStaticMethodNoThrow(String str, String str2, T t11, Object... objArr) {
        try {
            return invokeStaticMethod(str, str2, objArr);
        } catch (Throwable th2) {
            MobLog.getInstance().d(th2);
            return t11;
        }
    }

    public static Object newInstance(String str, Object... objArr) throws Throwable {
        try {
            return a(str, objArr);
        } catch (Throwable th2) {
            if (th2 instanceof NoSuchMethodException) {
                throw th2;
            }
            throw new Throwable("className: " + str + ", methodName: <init>", th2);
        }
    }

    public static void setInstanceField(Object obj, String str, Object obj2) throws Throwable {
        try {
            a(obj, str, obj2);
        } catch (Throwable th2) {
            if (th2 instanceof NoSuchFieldException) {
                throw th2;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2), th2);
        }
    }

    public static void setStaticField(String str, String str2, Object obj) throws Throwable {
        try {
            a(str, str2, obj);
        } catch (Throwable th2) {
            if (th2 instanceof NoSuchFieldException) {
                throw th2;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj), th2);
        }
    }

    public static synchronized String importClass(String str, String str2) throws Throwable {
        synchronized (ReflectHelper.class) {
            if (str2.endsWith(".*")) {
                f28131a.add(str2.substring(0, str2.length() - 2));
                return "*";
            }
            Class<?> cls = Class.forName(str2);
            if (str == null) {
                str = cls.getSimpleName();
            }
            if (f28132b.containsKey(str)) {
                f28133c.remove(f28132b.get(str));
            }
            f28132b.put(str, cls);
            f28133c.put(cls, str);
            return str;
        }
    }

    public static <T> T getInstanceField(Object obj, String str) throws Throwable {
        try {
            return a(obj, str);
        } catch (Throwable th2) {
            if (th2 instanceof NoSuchFieldException) {
                throw th2;
            }
            throw new Throwable("className: " + obj.getClass() + ", fieldName: " + str, th2);
        }
    }

    public static <T> T getStaticField(String str, String str2) throws Throwable {
        try {
            return a(str, str2);
        } catch (Throwable th2) {
            if (th2 instanceof NoSuchFieldException) {
                throw th2;
            }
            throw new Throwable("className: " + str + ", fieldName: " + str2, th2);
        }
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return a((String) null, obj, str, objArr, clsArr);
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        return a(str, (Object) null, str2, objArr, clsArr);
    }

    public static <T> T invokeInstanceMethod(Object obj, String str, Object... objArr) throws Throwable {
        try {
            return a((String) null, obj, str, objArr);
        } catch (Throwable th2) {
            if (th2 instanceof NoSuchMethodException) {
                throw th2;
            }
            throw new Throwable("className: " + obj.getClass() + ", methodName: " + str, th2);
        }
    }

    public static <T> T invokeStaticMethod(String str, String str2, Object... objArr) throws Throwable {
        try {
            return a(str, (Object) null, str2, objArr);
        } catch (Throwable th2) {
            if (th2 instanceof NoSuchMethodException) {
                throw th2;
            }
            throw new Throwable("className: " + str + ", methodName: " + str2, th2);
        }
    }

    public static Object createProxy(final Map<String, a<Object[], Object>> map, Class<?>... clsArr) throws Throwable {
        if (clsArr.length == 0) {
            return null;
        }
        return Proxy.newProxyInstance(clsArr[0].getClassLoader(), clsArr, new InvocationHandler() {
            public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
                a aVar = (a) map.get(method.getName());
                if (aVar != null) {
                    return aVar.a(objArr);
                }
                return null;
            }
        });
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Class<?>[] a(java.lang.Object[] r3) {
        /*
            int r0 = r3.length
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
        L_0x0004:
            int r2 = r3.length
            if (r1 >= r2) goto L_0x0023
            r2 = r3[r1]
            boolean r2 = r2 instanceof android.content.BroadcastReceiver
            if (r2 == 0) goto L_0x0012
            java.lang.Class<android.content.BroadcastReceiver> r2 = android.content.BroadcastReceiver.class
            r0[r1] = r2
            goto L_0x0020
        L_0x0012:
            r2 = r3[r1]
            if (r2 != 0) goto L_0x0018
            r2 = 0
            goto L_0x001e
        L_0x0018:
            r2 = r3[r1]
            java.lang.Class r2 = r2.getClass()
        L_0x001e:
            r0[r1] = r2
        L_0x0020:
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0023:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ReflectHelper.a(java.lang.Object[]):java.lang.Class[]");
    }

    private static Object b(String str, Object... objArr) throws Throwable {
        Class<?> cls;
        int i11 = 0;
        String str2 = str;
        int i12 = 0;
        while (str2.startsWith("[")) {
            i12++;
            str2 = str2.substring(1);
        }
        int[] iArr = null;
        if (i12 == objArr.length) {
            int[] iArr2 = new int[i12];
            while (i11 < i12) {
                try {
                    iArr2[i11] = Integer.parseInt(String.valueOf(objArr[i11]));
                    i11++;
                } catch (Throwable unused) {
                }
            }
            iArr = iArr2;
        }
        if (iArr != null) {
            if ("B".equals(str2)) {
                cls = Byte.TYPE;
            } else if ("S".equals(str2)) {
                cls = Short.TYPE;
            } else if ("I".equals(str2)) {
                cls = Integer.TYPE;
            } else if ("J".equals(str2)) {
                cls = Long.TYPE;
            } else if ("F".equals(str2)) {
                cls = Float.TYPE;
            } else if ("D".equals(str2)) {
                cls = Double.TYPE;
            } else if ("Z".equals(str2)) {
                cls = Boolean.TYPE;
            } else if ("C".equals(str2)) {
                cls = Character.TYPE;
            } else {
                cls = a(str2);
            }
            if (cls != null) {
                return Array.newInstance(cls, iArr);
            }
        }
        throw new NoSuchMethodException("className: [" + str + ", methodName: <init>");
    }

    private static boolean a(Class<?> cls, Class<?> cls2) {
        Class<Float> cls3 = Float.class;
        Class<Long> cls4 = Long.class;
        Class<Integer> cls5 = Integer.class;
        Class<Character> cls6 = Character.class;
        Class<Short> cls7 = Short.class;
        Class<Byte> cls8 = Byte.class;
        return (cls == Byte.TYPE && cls2 == cls8) || (cls == Short.TYPE && (cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Character.TYPE && (cls2 == cls6 || cls2 == cls7 || cls2 == cls8)) || ((cls == Integer.TYPE && (cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Long.TYPE && (cls2 == cls4 || cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Float.TYPE && (cls2 == cls3 || cls2 == cls4 || cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || ((cls == Double.TYPE && (cls2 == Double.class || cls2 == cls3 || cls2 == cls4 || cls2 == cls5 || cls2 == cls7 || cls2 == cls8 || cls2 == cls6)) || (cls == Boolean.TYPE && cls2 == Boolean.class))))));
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < clsArr2.length; i11++) {
            if (clsArr2[i11] != null && !a(clsArr[i11], clsArr2[i11]) && !clsArr[i11].isAssignableFrom(clsArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    private static Object a(String str, Object... objArr) throws Throwable {
        boolean z11;
        if (str.startsWith("[")) {
            return b(str, objArr);
        }
        Class<?> a11 = a(str);
        String str2 = a11.getName() + "#" + objArr.length;
        Constructor constructor = f28135e.get(str2);
        Class[] a12 = a(objArr);
        if (constructor == null || !a((Class<?>[]) constructor.getParameterTypes(), (Class<?>[]) a12)) {
            Constructor[] declaredConstructors = a11.getDeclaredConstructors();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Constructor constructor2 : declaredConstructors) {
                Class[] parameterTypes = constructor2.getParameterTypes();
                if (a((Class<?>[]) parameterTypes, (Class<?>[]) a12)) {
                    f28135e.put(str2, constructor2);
                    constructor2.setAccessible(true);
                    return constructor2.newInstance(objArr);
                }
                if (parameterTypes.length > 0 && parameterTypes[parameterTypes.length - 1].isArray() && a12.length >= parameterTypes.length - 1) {
                    arrayList.add(constructor2);
                    arrayList2.add(parameterTypes);
                }
            }
            for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                Class[] clsArr = (Class[]) arrayList2.get(i11);
                Class<?> componentType = clsArr[clsArr.length - 1].getComponentType();
                if (b((Class<?>[]) clsArr, (Class<?>[]) a12)) {
                    Object[] objArr2 = new Object[(objArr.length + 1)];
                    System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                    objArr2[objArr.length] = Array.newInstance(componentType, 0);
                    Constructor constructor3 = (Constructor) arrayList.get(i11);
                    constructor3.setAccessible(true);
                    return constructor3.newInstance(objArr);
                }
                int length = clsArr.length - 1;
                while (true) {
                    if (length >= a12.length) {
                        z11 = true;
                        break;
                    } else if (!a12[length].equals(componentType)) {
                        z11 = false;
                        break;
                    } else {
                        length++;
                    }
                }
                if (z11) {
                    int length2 = (a12.length - clsArr.length) + 1;
                    Object newInstance = Array.newInstance(componentType, length2);
                    for (int i12 = 0; i12 < length2; i12++) {
                        Array.set(newInstance, i12, objArr[(clsArr.length - 1) + i12]);
                    }
                    Object[] objArr3 = new Object[(objArr.length + 1)];
                    System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
                    objArr3[objArr.length] = newInstance;
                    Constructor constructor4 = (Constructor) arrayList.get(i11);
                    constructor4.setAccessible(true);
                    return constructor4.newInstance(objArr);
                }
            }
            throw new NoSuchMethodException("className: " + str + ", methodName: <init>");
        }
        constructor.setAccessible(true);
        return constructor.newInstance(objArr);
    }

    private static Object b(Object obj, String str) throws Throwable {
        int i11;
        int i12;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i12 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i12 = -1;
                }
                if (i12 != -1) {
                    return ((List) obj).get(i12);
                }
            }
        } else if (m.a("006edc-chAgf").equals(str)) {
            return Integer.valueOf(Array.getLength(obj));
        } else {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i11 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused2) {
                    i11 = -1;
                }
                if (i11 != -1) {
                    return Array.get(obj, i11);
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static void b(Object obj, String str, Object obj2) throws Throwable {
        int i11;
        int i12;
        Class<Float> cls = Float.class;
        Class<Long> cls2 = Long.class;
        Class<Integer> cls3 = Integer.class;
        Class<Short> cls4 = Short.class;
        Class<Byte> cls5 = Byte.class;
        if (obj instanceof List) {
            if (str.startsWith("[") && str.endsWith("]")) {
                try {
                    i12 = Integer.parseInt(str.substring(1, str.length() - 1));
                } catch (Throwable unused) {
                    i12 = -1;
                }
                if (i12 != -1) {
                    ((List) obj).set(i12, obj2);
                    return;
                }
            }
        } else if (str.startsWith("[") && str.endsWith("]")) {
            try {
                i11 = Integer.parseInt(str.substring(1, str.length() - 1));
            } catch (Throwable unused2) {
                i11 = -1;
            }
            if (i11 != -1) {
                String name = obj.getClass().getName();
                while (name.startsWith("[")) {
                    name = name.substring(1);
                }
                Class<?> cls6 = obj2.getClass();
                if (!"B".equals(name)) {
                    Object obj3 = null;
                    if ("S".equals(name)) {
                        if (cls6 == cls4) {
                            obj3 = obj2;
                        } else if (cls6 == cls5) {
                            obj3 = Short.valueOf((short) ((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i11, obj3);
                            return;
                        }
                    } else if ("I".equals(name)) {
                        if (cls6 == cls3) {
                            obj3 = obj2;
                        } else if (cls6 == cls4) {
                            obj3 = Integer.valueOf(((Short) obj2).shortValue());
                        } else if (cls6 == cls5) {
                            obj3 = Integer.valueOf(((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i11, obj3);
                            return;
                        }
                    } else if ("J".equals(name)) {
                        if (cls6 == cls2) {
                            obj3 = obj2;
                        } else if (cls6 == cls3) {
                            obj3 = Long.valueOf((long) ((Integer) obj2).intValue());
                        } else if (cls6 == cls4) {
                            obj3 = Long.valueOf((long) ((Short) obj2).shortValue());
                        } else if (cls6 == cls5) {
                            obj3 = Long.valueOf((long) ((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i11, obj3);
                            return;
                        }
                    } else if ("F".equals(name)) {
                        if (cls6 == cls) {
                            obj3 = obj2;
                        } else if (cls6 == cls2) {
                            obj3 = Float.valueOf((float) ((Long) obj2).longValue());
                        } else if (cls6 == cls3) {
                            obj3 = Float.valueOf((float) ((Integer) obj2).intValue());
                        } else if (cls6 == cls4) {
                            obj3 = Float.valueOf((float) ((Short) obj2).shortValue());
                        } else if (cls6 == cls5) {
                            obj3 = Float.valueOf((float) ((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i11, obj3);
                            return;
                        }
                    } else if ("D".equals(name)) {
                        if (cls6 == Double.class) {
                            obj3 = obj2;
                        } else if (cls6 == cls) {
                            obj3 = Double.valueOf((double) ((Float) obj2).floatValue());
                        } else if (cls6 == cls2) {
                            obj3 = Double.valueOf((double) ((Long) obj2).longValue());
                        } else if (cls6 == cls3) {
                            obj3 = Double.valueOf((double) ((Integer) obj2).intValue());
                        } else if (cls6 == cls4) {
                            obj3 = Double.valueOf((double) ((Short) obj2).shortValue());
                        } else if (cls6 == cls5) {
                            obj3 = Double.valueOf((double) ((Byte) obj2).byteValue());
                        }
                        if (obj3 != null) {
                            Array.set(obj, i11, obj3);
                            return;
                        }
                    } else if ("Z".equals(name)) {
                        if (cls6 == Boolean.class) {
                            Array.set(obj, i11, obj2);
                            return;
                        }
                    } else if ("C".equals(name)) {
                        if (cls6 == Character.class) {
                            Array.set(obj, i11, obj2);
                            return;
                        }
                    } else if (name.equals(cls6.getName())) {
                        Array.set(obj, i11, obj2);
                        return;
                    }
                } else if (cls6 == cls5) {
                    Array.set(obj, i11, obj2);
                    return;
                }
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
    }

    private static <T> T a(String str, Object obj, String str2, Object[] objArr, Class<?>[] clsArr) throws Throwable {
        Class<?> cls;
        if (objArr == null) {
            objArr = new Object[0];
        }
        if (clsArr == null) {
            clsArr = new Class[0];
        }
        if (obj == null) {
            cls = a(str);
        } else {
            cls = obj.getClass();
        }
        String str3 = cls.getName() + "#" + str2 + "#" + objArr.length;
        Method method = f28134d.get(str3);
        if (method != null) {
            method.setAccessible(true);
            try {
                if (method.getReturnType() != Void.TYPE) {
                    return method.invoke(obj, objArr);
                }
                method.invoke(obj, objArr);
                return null;
            } catch (InvocationTargetException e11) {
                throw e11;
            }
        } else {
            while (cls != null) {
                try {
                    Method declaredMethod = cls.getDeclaredMethod(str2, clsArr);
                    f28134d.put(str3, declaredMethod);
                    declaredMethod.setAccessible(true);
                    if (declaredMethod.getReturnType() != Void.TYPE) {
                        return declaredMethod.invoke(obj, objArr);
                    }
                    declaredMethod.invoke(obj, objArr);
                    return null;
                } catch (InvocationTargetException e12) {
                    throw e12;
                } catch (Throwable unused) {
                    cls = cls.getSuperclass();
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("className: ");
            Object obj2 = str;
            if (obj != null) {
                obj2 = obj.getClass();
            }
            sb2.append(obj2);
            sb2.append(", methodName: ");
            sb2.append(str2);
            throw new NoSuchMethodException(sb2.toString());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Class<?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Class<?>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <T> T a(java.lang.String r8, java.lang.Object r9, java.lang.String r10, java.lang.Object... r11) throws java.lang.Throwable {
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            if (r9 != 0) goto L_0x0009
            java.lang.Class r1 = a((java.lang.String) r8)
            goto L_0x000d
        L_0x0009:
            java.lang.Class r1 = r9.getClass()
        L_0x000d:
            java.lang.String r2 = "009Dch%dgVfa;dgf9biba"
            java.lang.String r2 = com.mob.commons.m.a(r2)
            boolean r2 = r10.equals(r2)
            r3 = 2
            r4 = 0
            r5 = 1
            if (r2 == 0) goto L_0x0034
            if (r11 == 0) goto L_0x0034
            int r2 = r11.length
            if (r2 != r3) goto L_0x0034
            java.lang.Class[] r2 = new java.lang.Class[r3]
            r2[r4] = r0
            java.lang.Class<java.lang.Class[]> r3 = java.lang.Class[].class
            r2[r5] = r3
            r3 = r11[r5]
            if (r3 != r0) goto L_0x0080
            java.lang.Class[] r3 = new java.lang.Class[r5]
            r3[r4] = r0
            r11[r5] = r3
            goto L_0x0080
        L_0x0034:
            java.lang.String r0 = "getDeviceId"
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0048
            if (r11 == 0) goto L_0x0048
            int r0 = r11.length
            if (r0 != r5) goto L_0x0048
            java.lang.Class[] r2 = new java.lang.Class[r5]
            java.lang.Class r0 = java.lang.Integer.TYPE
            r2[r4] = r0
            goto L_0x0080
        L_0x0048:
            java.lang.String r0 = "006ZbgAcYbbbicf6d"
            java.lang.String r0 = com.mob.commons.m.a(r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x0064
            if (r11 == 0) goto L_0x0064
            int r0 = r11.length
            if (r0 != r3) goto L_0x0064
            java.lang.Class[] r2 = new java.lang.Class[r3]
            java.lang.Class<java.lang.Object> r0 = java.lang.Object.class
            r2[r4] = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            r2[r5] = r0
            goto L_0x0080
        L_0x0064:
            java.lang.String r0 = "013 dg)dgPdb8aad.dgdgbgddDed"
            java.lang.String r0 = com.mob.commons.m.a(r0)
            boolean r0 = r10.equals(r0)
            if (r0 == 0) goto L_0x007c
            if (r11 == 0) goto L_0x007c
            int r0 = r11.length
            if (r0 != r5) goto L_0x007c
            java.lang.Class[] r2 = new java.lang.Class[r5]
            java.lang.Class r0 = java.lang.Boolean.TYPE
            r2[r4] = r0
            goto L_0x0080
        L_0x007c:
            java.lang.Class[] r2 = a((java.lang.Object[]) r11)
        L_0x0080:
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            int r3 = r2.length
            r6 = r4
        L_0x0087:
            if (r6 >= r3) goto L_0x009a
            r7 = r2[r6]
            if (r7 != 0) goto L_0x0090
            java.lang.String r7 = ""
            goto L_0x0094
        L_0x0090:
            java.lang.String r7 = r7.getName()
        L_0x0094:
            r0.append(r7)
            int r6 = r6 + 1
            goto L_0x0087
        L_0x009a:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r6 = r1.getName()
            r3.append(r6)
            java.lang.String r6 = "#"
            r3.append(r6)
            r3.append(r10)
            r3.append(r6)
            int r6 = r11.length
            r3.append(r6)
            java.lang.String r0 = r0.toString()
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.util.LinkedHashMap<java.lang.String, java.lang.reflect.Method> r3 = f28134d
            java.lang.Object r3 = r3.get(r0)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            r6 = 0
            if (r3 == 0) goto L_0x00fc
            int r7 = r3.getModifiers()
            boolean r7 = java.lang.reflect.Modifier.isStatic(r7)
            if (r9 != 0) goto L_0x00d7
            r4 = r7
            goto L_0x00da
        L_0x00d7:
            if (r7 != 0) goto L_0x00da
            r4 = r5
        L_0x00da:
            if (r4 == 0) goto L_0x00fc
            java.lang.Class[] r4 = r3.getParameterTypes()
            boolean r4 = a((java.lang.Class<?>[]) r4, (java.lang.Class<?>[]) r2)
            if (r4 == 0) goto L_0x00fc
            r3.setAccessible(r5)
            java.lang.Class r8 = r3.getReturnType()     // Catch:{ InvocationTargetException -> 0x00fa }
            java.lang.Class r10 = java.lang.Void.TYPE     // Catch:{ InvocationTargetException -> 0x00fa }
            if (r8 != r10) goto L_0x00f5
            r3.invoke(r9, r11)     // Catch:{ InvocationTargetException -> 0x00fa }
            return r6
        L_0x00f5:
            java.lang.Object r8 = r3.invoke(r9, r11)     // Catch:{ InvocationTargetException -> 0x00fa }
            return r8
        L_0x00fa:
            r8 = move-exception
            throw r8
        L_0x00fc:
            if (r1 == 0) goto L_0x0122
            java.lang.reflect.Method r3 = r1.getDeclaredMethod(r10, r2)     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            java.util.LinkedHashMap<java.lang.String, java.lang.reflect.Method> r4 = f28134d     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            r4.put(r0, r3)     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            r3.setAccessible(r5)     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            java.lang.Class r4 = r3.getReturnType()     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            java.lang.Class r7 = java.lang.Void.TYPE     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            if (r4 != r7) goto L_0x0116
            r3.invoke(r9, r11)     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            return r6
        L_0x0116:
            java.lang.Object r8 = r3.invoke(r9, r11)     // Catch:{ InvocationTargetException -> 0x0120, all -> 0x011b }
            return r8
        L_0x011b:
            java.lang.Class r1 = r1.getSuperclass()
            goto L_0x00fc
        L_0x0120:
            r8 = move-exception
            throw r8
        L_0x0122:
            java.lang.NoSuchMethodException r11 = new java.lang.NoSuchMethodException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "className: "
            r0.append(r1)
            if (r9 != 0) goto L_0x0131
            goto L_0x0135
        L_0x0131:
            java.lang.Class r8 = r9.getClass()
        L_0x0135:
            r0.append(r8)
            java.lang.String r8 = ", methodName: "
            r0.append(r8)
            r0.append(r10)
            java.lang.String r8 = r0.toString()
            r11.<init>(r8)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ReflectHelper.a(java.lang.String, java.lang.Object, java.lang.String, java.lang.Object[]):java.lang.Object");
    }

    private static <T> T a(String str, String str2) throws Throwable {
        Field field;
        ArrayList arrayList = new ArrayList();
        for (Class a11 = a(str); a11 != null; a11 = a11.getSuperclass()) {
            arrayList.add(a11);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                field = ((Class) it2.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                field = null;
            }
            if (field != null && Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                return field.get((Object) null);
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2);
    }

    private static void a(String str, String str2, Object obj) throws Throwable {
        Field field;
        ArrayList arrayList = new ArrayList();
        for (Class a11 = a(str); a11 != null; a11 = a11.getSuperclass()) {
            arrayList.add(a11);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            try {
                field = ((Class) it2.next()).getDeclaredField(str2);
            } catch (Throwable unused) {
                field = null;
            }
            if (field != null && Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                field.set((Object) null, obj);
                return;
            }
        }
        throw new NoSuchFieldException("className: " + str + ", fieldName: " + str2 + ", value: " + String.valueOf(obj));
    }

    private static <T> T a(Object obj, String str) throws Throwable {
        if ((obj instanceof List) || obj.getClass().isArray()) {
            return b(obj, str);
        }
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        ArrayList arrayList = new ArrayList();
        for (Class cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
            arrayList.add(cls);
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Field field = null;
            try {
                field = ((Class) it2.next()).getDeclaredField(str);
            } catch (Throwable unused) {
            }
            if (field != null && !Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                return field.get(obj);
            }
        }
        throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str);
    }

    private static void a(Object obj, String str, Object obj2) throws Throwable {
        if ((obj instanceof List) || obj.getClass().isArray()) {
            b(obj, str, obj2);
        } else if (obj instanceof Map) {
            ((Map) obj).put(str, obj2);
        } else {
            ArrayList arrayList = new ArrayList();
            for (Class cls = obj.getClass(); cls != null; cls = cls.getSuperclass()) {
                arrayList.add(cls);
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Field field = null;
                try {
                    field = ((Class) it2.next()).getDeclaredField(str);
                } catch (Throwable unused) {
                }
                if (field != null && !Modifier.isStatic(field.getModifiers())) {
                    field.setAccessible(true);
                    field.set(obj, obj2);
                    return;
                }
            }
            throw new NoSuchFieldException("className: " + obj.getClass() + ", fieldName: " + str + ", value: " + String.valueOf(obj2));
        }
    }
}
