package k20;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import l20.b;
import org.greenrobot.eventbus.EventBusException;

public class k {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<Class<?>, List<j>> f68241d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    public static final a[] f68242e = new a[4];

    /* renamed from: a  reason: collision with root package name */
    public List<b> f68243a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f68244b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f68245c;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<j> f68246a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final Map<Class, Object> f68247b = new HashMap();

        /* renamed from: c  reason: collision with root package name */
        public final Map<String, Class> f68248c = new HashMap();

        /* renamed from: d  reason: collision with root package name */
        public final StringBuilder f68249d = new StringBuilder(128);

        /* renamed from: e  reason: collision with root package name */
        public Class<?> f68250e;

        /* renamed from: f  reason: collision with root package name */
        public Class<?> f68251f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f68252g;

        /* renamed from: h  reason: collision with root package name */
        public l20.a f68253h;

        public boolean a(Method method, Class<?> cls) {
            Object put = this.f68247b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (b((Method) put, cls)) {
                    this.f68247b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        public final boolean b(Method method, Class<?> cls) {
            this.f68249d.setLength(0);
            this.f68249d.append(method.getName());
            StringBuilder sb2 = this.f68249d;
            sb2.append('>');
            sb2.append(cls.getName());
            String sb3 = this.f68249d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f68248c.put(sb3, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f68248c.put(sb3, put);
            return false;
        }

        public void c(Class<?> cls) {
            this.f68251f = cls;
            this.f68250e = cls;
            this.f68252g = false;
            this.f68253h = null;
        }

        public void d() {
            if (this.f68252g) {
                this.f68251f = null;
                return;
            }
            Class<? super Object> superclass = this.f68251f.getSuperclass();
            this.f68251f = superclass;
            String name = superclass.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f68251f = null;
            }
        }

        public void e() {
            this.f68246a.clear();
            this.f68247b.clear();
            this.f68248c.clear();
            this.f68249d.setLength(0);
            this.f68250e = null;
            this.f68251f = null;
            this.f68252g = false;
            this.f68253h = null;
        }
    }

    public k(List<b> list, boolean z11, boolean z12) {
        this.f68243a = list;
        this.f68244b = z11;
        this.f68245c = z12;
    }

    public List<j> a(Class<?> cls) {
        List<j> list;
        Map<Class<?>, List<j>> map = f68241d;
        List<j> list2 = map.get(cls);
        if (list2 != null) {
            return list2;
        }
        if (this.f68245c) {
            list = c(cls);
        } else {
            list = b(cls);
        }
        if (!list.isEmpty()) {
            map.put(cls, list);
            return list;
        }
        throw new EventBusException("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    public final List<j> b(Class<?> cls) {
        a g11 = g();
        g11.c(cls);
        while (g11.f68251f != null) {
            l20.a f11 = f(g11);
            g11.f68253h = f11;
            if (f11 != null) {
                for (j jVar : f11.a()) {
                    if (g11.a(jVar.f68235a, jVar.f68237c)) {
                        g11.f68246a.add(jVar);
                    }
                }
            } else {
                d(g11);
            }
            g11.d();
        }
        return e(g11);
    }

    public final List<j> c(Class<?> cls) {
        a g11 = g();
        g11.c(cls);
        while (g11.f68251f != null) {
            d(g11);
            g11.d();
        }
        return e(g11);
    }

    public final void d(a aVar) {
        Method[] methodArr;
        try {
            methodArr = aVar.f68251f.getDeclaredMethods();
        } catch (Throwable unused) {
            methodArr = aVar.f68251f.getMethods();
            aVar.f68252g = true;
        }
        for (Method method : methodArr) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & 5192) == 0) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    h hVar = (h) method.getAnnotation(h.class);
                    if (hVar != null) {
                        Class cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.f68246a.add(new j(method, cls, hVar.threadMode(), hVar.priority(), hVar.sticky()));
                        }
                    }
                } else if (this.f68244b && method.isAnnotationPresent(h.class)) {
                    throw new EventBusException("@Subscribe method " + (method.getDeclaringClass().getName() + InstructionFileId.DOT + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f68244b && method.isAnnotationPresent(h.class)) {
                throw new EventBusException((method.getDeclaringClass().getName() + InstructionFileId.DOT + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    public final List<j> e(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f68246a);
        aVar.e();
        synchronized (f68242e) {
            int i11 = 0;
            while (true) {
                if (i11 >= 4) {
                    break;
                }
                a[] aVarArr = f68242e;
                if (aVarArr[i11] == null) {
                    aVarArr[i11] = aVar;
                    break;
                }
                i11++;
            }
        }
        return arrayList;
    }

    public final l20.a f(a aVar) {
        l20.a aVar2 = aVar.f68253h;
        if (!(aVar2 == null || aVar2.c() == null)) {
            l20.a c11 = aVar.f68253h.c();
            if (aVar.f68251f == c11.b()) {
                return c11;
            }
        }
        List<b> list = this.f68243a;
        if (list == null) {
            return null;
        }
        for (b a11 : list) {
            l20.a a12 = a11.a(aVar.f68251f);
            if (a12 != null) {
                return a12;
            }
        }
        return null;
    }

    public final a g() {
        synchronized (f68242e) {
            for (int i11 = 0; i11 < 4; i11++) {
                a[] aVarArr = f68242e;
                a aVar = aVarArr[i11];
                if (aVar != null) {
                    aVarArr[i11] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }
}
