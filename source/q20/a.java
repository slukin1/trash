package q20;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import o20.g;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final Comparator<Method> f25598a = new C0223a();

    /* renamed from: b  reason: collision with root package name */
    public static final Comparator<Method> f25599b = new b();

    /* renamed from: q20.a$a  reason: collision with other inner class name */
    public static class C0223a implements Comparator<Method> {
        /* renamed from: a */
        public int compare(Method method, Method method2) {
            int hashCode = method.getName().hashCode();
            int hashCode2 = method2.getName().hashCode();
            if (hashCode != hashCode2) {
                return hashCode < hashCode2 ? -1 : 1;
            }
            return a.f25599b.compare(method, method2);
        }
    }

    public static class b implements Comparator<Method> {
        /* renamed from: a */
        public int compare(Method method, Method method2) {
            int compareTo = method.getName().compareTo(method2.getName());
            if (compareTo != 0) {
                return compareTo;
            }
            return method.toString().compareTo(method2.toString());
        }
    }

    public static Method[] a(Class<?> cls) {
        Comparator<Method> b11 = b((g) cls.getAnnotation(g.class));
        Method[] declaredMethods = cls.getDeclaredMethods();
        if (b11 != null) {
            Arrays.sort(declaredMethods, b11);
        }
        return declaredMethods;
    }

    public static Comparator<Method> b(g gVar) {
        if (gVar == null) {
            return f25598a;
        }
        return gVar.value().getComparator();
    }
}
