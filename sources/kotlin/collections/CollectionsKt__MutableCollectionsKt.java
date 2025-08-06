package kotlin.collections;

import d10.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.h;

class CollectionsKt__MutableCollectionsKt extends CollectionsKt__MutableCollectionsJVMKt {
    public static <T> boolean A(Collection<? super T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll((Collection) iterable);
        }
        boolean z11 = false;
        for (Object add : iterable) {
            if (collection.add(add)) {
                z11 = true;
            }
        }
        return z11;
    }

    public static <T> boolean B(Collection<? super T> collection, T[] tArr) {
        return collection.addAll(ArraysKt___ArraysJvmKt.d(tArr));
    }

    public static final <T> Collection<T> C(Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : CollectionsKt___CollectionsKt.I0(iterable);
    }

    public static final <T> boolean D(Iterable<? extends T> iterable, l<? super T, Boolean> lVar, boolean z11) {
        Iterator<? extends T> it2 = iterable.iterator();
        boolean z12 = false;
        while (it2.hasNext()) {
            if (lVar.invoke(it2.next()).booleanValue() == z11) {
                it2.remove();
                z12 = true;
            }
        }
        return z12;
    }

    public static final <T> boolean E(List<T> list, l<? super T, Boolean> lVar, boolean z11) {
        if (!(list instanceof RandomAccess)) {
            return D(TypeIntrinsics.b(list), lVar, z11);
        }
        IntIterator d11 = new h(0, CollectionsKt__CollectionsKt.m(list)).iterator();
        int i11 = 0;
        while (d11.hasNext()) {
            int a11 = d11.a();
            T t11 = list.get(a11);
            if (lVar.invoke(t11).booleanValue() != z11) {
                if (i11 != a11) {
                    list.set(i11, t11);
                }
                i11++;
            }
        }
        if (i11 >= list.size()) {
            return false;
        }
        int m11 = CollectionsKt__CollectionsKt.m(list);
        if (i11 > m11) {
            return true;
        }
        while (true) {
            list.remove(m11);
            if (m11 == i11) {
                return true;
            }
            m11--;
        }
    }

    public static <T> boolean F(Iterable<? extends T> iterable, l<? super T, Boolean> lVar) {
        return D(iterable, lVar, true);
    }

    public static <T> boolean G(List<T> list, l<? super T, Boolean> lVar) {
        return E(list, lVar, true);
    }

    public static <T> T H(List<T> list) {
        if (!list.isEmpty()) {
            return list.remove(CollectionsKt__CollectionsKt.m(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T I(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.remove(CollectionsKt__CollectionsKt.m(list));
    }

    public static <T> boolean J(Iterable<? extends T> iterable, l<? super T, Boolean> lVar) {
        return D(iterable, lVar, false);
    }

    public static final <T> boolean K(Collection<? super T> collection, Iterable<? extends T> iterable) {
        return collection.retainAll(C(iterable));
    }
}
