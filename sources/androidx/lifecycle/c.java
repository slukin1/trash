package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f9977c = new c();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, a> f9978a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<?>, Boolean> f9979b = new HashMap();

    @Deprecated
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Lifecycle.Event, List<b>> f9980a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        public final Map<b, Lifecycle.Event> f9981b;

        public a(Map<b, Lifecycle.Event> map) {
            this.f9981b = map;
            for (Map.Entry next : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) next.getValue();
                List list = this.f9980a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f9980a.put(event, list);
                }
                list.add((b) next.getKey());
            }
        }

        public static void b(List<b> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lifecycleOwner, event, obj);
                }
            }
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            b(this.f9980a.get(event), lifecycleOwner, event, obj);
            b(this.f9980a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    @Deprecated
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f9982a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f9983b;

        public b(int i11, Method method) {
            this.f9982a = i11;
            this.f9983b = method;
            method.setAccessible(true);
        }

        public void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i11 = this.f9982a;
                if (i11 == 0) {
                    this.f9983b.invoke(obj, new Object[0]);
                } else if (i11 == 1) {
                    this.f9983b.invoke(obj, new Object[]{lifecycleOwner});
                } else if (i11 == 2) {
                    this.f9983b.invoke(obj, new Object[]{lifecycleOwner, event});
                }
            } catch (InvocationTargetException e11) {
                throw new RuntimeException("Failed to call observer method", e11.getCause());
            } catch (IllegalAccessException e12) {
                throw new RuntimeException(e12);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f9982a != bVar.f9982a || !this.f9983b.getName().equals(bVar.f9983b.getName())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f9982a * 31) + this.f9983b.getName().hashCode();
        }
    }

    public final a a(Class<?> cls, Method[] methodArr) {
        int i11;
        a c11;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (!(superclass == null || (c11 = c(superclass)) == null)) {
            hashMap.putAll(c11.f9981b);
        }
        for (Class c12 : cls.getInterfaces()) {
            for (Map.Entry next : c(c12).f9981b.entrySet()) {
                e(hashMap, (b) next.getKey(), (Lifecycle.Event) next.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z11 = false;
        for (Method method : methodArr) {
            a0 a0Var = (a0) method.getAnnotation(a0.class);
            if (a0Var != null) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i11 = 0;
                } else if (LifecycleOwner.class.isAssignableFrom(parameterTypes[0])) {
                    i11 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Lifecycle.Event value = a0Var.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value == Lifecycle.Event.ON_ANY) {
                        i11 = 2;
                    } else {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                }
                if (parameterTypes.length <= 2) {
                    e(hashMap, new b(i11, method), value, cls);
                    z11 = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(hashMap);
        this.f9978a.put(cls, aVar);
        this.f9979b.put(cls, Boolean.valueOf(z11));
        return aVar;
    }

    public final Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e11) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e11);
        }
    }

    public a c(Class<?> cls) {
        a aVar = this.f9978a.get(cls);
        if (aVar != null) {
            return aVar;
        }
        return a(cls, (Method[]) null);
    }

    public boolean d(Class<?> cls) {
        Boolean bool = this.f9979b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b11 = b(cls);
        for (Method annotation : b11) {
            if (((a0) annotation.getAnnotation(a0.class)) != null) {
                a(cls, b11);
                return true;
            }
        }
        this.f9979b.put(cls, Boolean.FALSE);
        return false;
    }

    public final void e(Map<b, Lifecycle.Event> map, b bVar, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(bVar);
        if (event2 != null && event != event2) {
            Method method = bVar.f9983b;
            throw new IllegalArgumentException("Method " + method.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(bVar, event);
        }
    }
}
