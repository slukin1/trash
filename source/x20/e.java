package x20;

import com.iproov.sdk.bridge.OptionsBridge;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import o20.d;
import org.junit.runners.model.FrameworkMember;

public class e implements a {

    /* renamed from: d  reason: collision with root package name */
    public static final b f26328d = new b();

    /* renamed from: e  reason: collision with root package name */
    public static final c f26329e = new c();

    /* renamed from: a  reason: collision with root package name */
    public final Class<?> f26330a;

    /* renamed from: b  reason: collision with root package name */
    public final Map<Class<? extends Annotation>, List<c>> f26331b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<Class<? extends Annotation>, List<b>> f26332c;

    public static class b implements Comparator<Field> {
        public b() {
        }

        /* renamed from: a */
        public int compare(Field field, Field field2) {
            return field.getName().compareTo(field2.getName());
        }
    }

    public static class c implements Comparator<c> {
        public c() {
        }

        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            return q20.a.f25599b.compare(cVar.j(), cVar2.j());
        }
    }

    public e(Class<?> cls) {
        this.f26330a = cls;
        if (cls == null || cls.getConstructors().length <= 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            s(linkedHashMap, linkedHashMap2);
            this.f26331b = q(linkedHashMap);
            this.f26332c = q(linkedHashMap2);
            return;
        }
        throw new IllegalArgumentException("Test class can only have one constructor");
    }

    public static <T extends FrameworkMember<T>> void a(T t11, Map<Class<? extends Annotation>, List<T>> map) {
        Annotation[] annotations = t11.getAnnotations();
        int length = annotations.length;
        int i11 = 0;
        while (i11 < length) {
            Class<? extends Annotation> annotationType = annotations[i11].annotationType();
            List<? extends Annotation> f11 = f(map, annotationType, true);
            if (!t11.f(f11)) {
                if (r(annotationType)) {
                    f11.add(0, t11);
                } else {
                    f11.add(t11);
                }
                i11++;
            } else {
                return;
            }
        }
    }

    public static <T> List<T> f(Map<Class<? extends Annotation>, List<T>> map, Class<? extends Annotation> cls, boolean z11) {
        if (!map.containsKey(cls) && z11) {
            map.put(cls, new ArrayList());
        }
        List<T> list = map.get(cls);
        return list == null ? Collections.emptyList() : list;
    }

    public static Field[] m(Class<?> cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        Arrays.sort(declaredFields, f26328d);
        return declaredFields;
    }

    public static List<Class<?>> n(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        for (Class<? super Object> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
            arrayList.add(cls2);
        }
        return arrayList;
    }

    public static <T extends FrameworkMember<T>> Map<Class<? extends Annotation>, List<T>> q(Map<Class<? extends Annotation>, List<T>> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            linkedHashMap.put(next.getKey(), Collections.unmodifiableList((List) next.getValue()));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    public static boolean r(Class<? extends Annotation> cls) {
        return cls.equals(d.class) || cls.equals(o20.e.class);
    }

    public final <T> List<T> b(Map<?, List<T>> map) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (List<T> addAll : map.values()) {
            linkedHashSet.addAll(addAll);
        }
        return new ArrayList(linkedHashSet);
    }

    public <T> List<T> c(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (b i11 : e(cls)) {
            try {
                Object i12 = i11.i(obj);
                if (cls2.isInstance(i12)) {
                    arrayList.add(cls2.cast(i12));
                }
            } catch (IllegalAccessException e11) {
                throw new RuntimeException("How did getFields return a field we couldn't access?", e11);
            }
        }
        return arrayList;
    }

    public List<b> d() {
        return b(this.f26332c);
    }

    public List<b> e(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(f(this.f26332c, cls, false));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.f26330a == ((e) obj).f26330a) {
            return true;
        }
        return false;
    }

    public <T> List<T> g(Object obj, Class<? extends Annotation> cls, Class<T> cls2) {
        ArrayList arrayList = new ArrayList();
        for (c next : i(cls)) {
            try {
                if (cls2.isAssignableFrom(next.l())) {
                    arrayList.add(cls2.cast(next.m(obj, new Object[0])));
                }
            } catch (Throwable th2) {
                throw new RuntimeException("Exception in " + next.c(), th2);
            }
        }
        return arrayList;
    }

    public Annotation[] getAnnotations() {
        Class<?> cls = this.f26330a;
        if (cls == null) {
            return new Annotation[0];
        }
        return cls.getAnnotations();
    }

    public List<c> h() {
        List<c> b11 = b(this.f26331b);
        Collections.sort(b11, f26329e);
        return b11;
    }

    public int hashCode() {
        Class<?> cls = this.f26330a;
        if (cls == null) {
            return 0;
        }
        return cls.hashCode();
    }

    public List<c> i(Class<? extends Annotation> cls) {
        return Collections.unmodifiableList(f(this.f26331b, cls, false));
    }

    public Class<?> j() {
        return this.f26330a;
    }

    public String k() {
        Class<?> cls = this.f26330a;
        if (cls == null) {
            return OptionsBridge.NULL_VALUE;
        }
        return cls.getName();
    }

    public Constructor<?> l() {
        Constructor<?>[] constructors = this.f26330a.getConstructors();
        o20.c.a(1, (long) constructors.length);
        return constructors[0];
    }

    public boolean o() {
        return this.f26330a.isMemberClass() && !Modifier.isStatic(this.f26330a.getModifiers());
    }

    public boolean p() {
        return Modifier.isPublic(this.f26330a.getModifiers());
    }

    public void s(Map<Class<? extends Annotation>, List<c>> map, Map<Class<? extends Annotation>, List<b>> map2) {
        for (Class next : n(this.f26330a)) {
            for (Method cVar : q20.a.a(next)) {
                a(new c(cVar), map);
            }
            for (Field bVar : m(next)) {
                a(new b(bVar), map2);
            }
        }
    }
}
