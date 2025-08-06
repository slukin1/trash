package androidx.test.espresso.core.internal.deps.guava.collect;

import java.util.Iterator;
import java.util.Set;

public final class Sets {
    public static boolean a(Set<?> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int b(Set<?> set) {
        Iterator<?> it2 = set.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            i11 = ~(~(i11 + (next != null ? next.hashCode() : 0)));
        }
        return i11;
    }
}
