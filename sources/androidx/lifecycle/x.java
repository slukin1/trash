package androidx.lifecycle;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public static final x f10042a = new x();

    /* renamed from: b  reason: collision with root package name */
    public static final Map<Class<?>, Integer> f10043b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Class<?>, List<Constructor<? extends n>>> f10044c = new HashMap();

    public static final String c(String str) {
        return StringsKt__StringsJVMKt.G(str, InstructionFileId.DOT, "_", false, 4, (Object) null) + "_LifecycleAdapter";
    }

    public static final r f(Object obj) {
        boolean z11 = obj instanceof r;
        boolean z12 = obj instanceof DefaultLifecycleObserver;
        if (z11 && z12) {
            return new k((DefaultLifecycleObserver) obj, (r) obj);
        }
        if (z12) {
            return new k((DefaultLifecycleObserver) obj, (r) null);
        }
        if (z11) {
            return (r) obj;
        }
        Class<?> cls = obj.getClass();
        x xVar = f10042a;
        if (xVar.d(cls) != 2) {
            return new d0(obj);
        }
        List list = f10044c.get(cls);
        if (list.size() == 1) {
            return new k0(xVar.a((Constructor) list.get(0), obj));
        }
        int size = list.size();
        n[] nVarArr = new n[size];
        for (int i11 = 0; i11 < size; i11++) {
            nVarArr[i11] = f10042a.a((Constructor) list.get(i11), obj);
        }
        return new e(nVarArr);
    }

    public final n a(Constructor<? extends n> constructor, Object obj) {
        try {
            return (n) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e11) {
            throw new RuntimeException(e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException(e12);
        } catch (InvocationTargetException e13) {
            throw new RuntimeException(e13);
        }
    }

    public final Constructor<? extends n> b(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!(name.length() == 0)) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            String c11 = c(canonicalName);
            if (!(name.length() == 0)) {
                c11 = name + '.' + c11;
            }
            Constructor<?> declaredConstructor = Class.forName(c11).getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e11) {
            throw new RuntimeException(e11);
        }
    }

    public final int d(Class<?> cls) {
        Map<Class<?>, Integer> map = f10043b;
        Integer num = map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int g11 = g(cls);
        map.put(cls, Integer.valueOf(g11));
        return g11;
    }

    public final boolean e(Class<?> cls) {
        return cls != null && u.class.isAssignableFrom(cls);
    }

    public final int g(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor<? extends n> b11 = b(cls);
        if (b11 != null) {
            f10044c.put(cls, CollectionsKt__CollectionsJVMKt.e(b11));
            return 2;
        } else if (c.f9977c.d(cls)) {
            return 1;
        } else {
            Class<? super Object> superclass = cls.getSuperclass();
            ArrayList arrayList = null;
            if (e(superclass)) {
                if (d(superclass) == 1) {
                    return 1;
                }
                arrayList = new ArrayList(f10044c.get(superclass));
            }
            for (Class cls2 : cls.getInterfaces()) {
                if (e(cls2)) {
                    if (d(cls2) == 1) {
                        return 1;
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.addAll(f10044c.get(cls2));
                }
            }
            if (arrayList == null) {
                return 1;
            }
            f10044c.put(cls, arrayList);
            return 2;
        }
    }
}
