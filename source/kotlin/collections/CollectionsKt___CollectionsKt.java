package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.x;
import kotlin.l;
import kotlin.random.Random;
import kotlin.sequences.g;

class CollectionsKt___CollectionsKt extends CollectionsKt___CollectionsJvmKt {

    public static final class a implements g<T> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Iterable f56633a;

        public a(Iterable iterable) {
            this.f56633a = iterable;
        }

        public Iterator<T> iterator() {
            return this.f56633a.iterator();
        }
    }

    public static int A0(Iterable<Integer> iterable) {
        int i11 = 0;
        for (Integer intValue : iterable) {
            i11 += intValue.intValue();
        }
        return i11;
    }

    public static <T> List<T> B0(Iterable<? extends T> iterable, int i11) {
        int i12 = 0;
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        } else if (i11 == 0) {
            return CollectionsKt__CollectionsKt.k();
        } else {
            if (iterable instanceof Collection) {
                if (i11 >= ((Collection) iterable).size()) {
                    return I0(iterable);
                }
                if (i11 == 1) {
                    return CollectionsKt__CollectionsJVMKt.e(Z(iterable));
                }
            }
            ArrayList arrayList = new ArrayList(i11);
            for (Object add : iterable) {
                arrayList.add(add);
                i12++;
                if (i12 == i11) {
                    break;
                }
            }
            return CollectionsKt__CollectionsKt.q(arrayList);
        }
    }

    public static <T> List<T> C0(List<? extends T> list, int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        } else if (i11 == 0) {
            return CollectionsKt__CollectionsKt.k();
        } else {
            int size = list.size();
            if (i11 >= size) {
                return I0(list);
            }
            if (i11 == 1) {
                return CollectionsKt__CollectionsJVMKt.e(m0(list));
            }
            ArrayList arrayList = new ArrayList(i11);
            if (list instanceof RandomAccess) {
                for (int i12 = size - i11; i12 < size; i12++) {
                    arrayList.add(list.get(i12));
                }
            } else {
                ListIterator<? extends T> listIterator = list.listIterator(size - i11);
                while (listIterator.hasNext()) {
                    arrayList.add(listIterator.next());
                }
            }
            return arrayList;
        }
    }

    public static boolean[] D0(Collection<Boolean> collection) {
        boolean[] zArr = new boolean[collection.size()];
        int i11 = 0;
        for (Boolean booleanValue : collection) {
            zArr[i11] = booleanValue.booleanValue();
            i11++;
        }
        return zArr;
    }

    public static byte[] E0(Collection<Byte> collection) {
        byte[] bArr = new byte[collection.size()];
        int i11 = 0;
        for (Byte byteValue : collection) {
            bArr[i11] = byteValue.byteValue();
            i11++;
        }
        return bArr;
    }

    public static final <T, C extends Collection<? super T>> C F0(Iterable<? extends T> iterable, C c11) {
        for (Object add : iterable) {
            c11.add(add);
        }
        return c11;
    }

    public static <T> HashSet<T> G0(Iterable<? extends T> iterable) {
        return (HashSet) F0(iterable, new HashSet(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.u(iterable, 12))));
    }

    public static int[] H0(Collection<Integer> collection) {
        int[] iArr = new int[collection.size()];
        int i11 = 0;
        for (Integer intValue : collection) {
            iArr[i11] = intValue.intValue();
            i11++;
        }
        return iArr;
    }

    public static <T> List<T> I0(Iterable<? extends T> iterable) {
        if (!(iterable instanceof Collection)) {
            return CollectionsKt__CollectionsKt.q(K0(iterable));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return CollectionsKt__CollectionsKt.k();
        }
        if (size != 1) {
            return L0(collection);
        }
        return CollectionsKt__CollectionsJVMKt.e(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static long[] J0(Collection<Long> collection) {
        long[] jArr = new long[collection.size()];
        int i11 = 0;
        for (Long longValue : collection) {
            jArr[i11] = longValue.longValue();
            i11++;
        }
        return jArr;
    }

    public static final <T> List<T> K0(Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return L0((Collection) iterable);
        }
        return (List) F0(iterable, new ArrayList());
    }

    public static <T> List<T> L0(Collection<? extends T> collection) {
        return new ArrayList(collection);
    }

    public static <T> Set<T> M0(Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet((Collection) iterable);
        }
        return (Set) F0(iterable, new LinkedHashSet());
    }

    public static <T> Set<T> N0(Iterable<? extends T> iterable) {
        if (!(iterable instanceof Collection)) {
            return SetsKt__SetsKt.e((Set) F0(iterable, new LinkedHashSet()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return SetsKt__SetsKt.d();
        }
        if (size != 1) {
            return (Set) F0(iterable, new LinkedHashSet(MapsKt__MapsJVMKt.d(collection.size())));
        }
        return SetsKt__SetsJVMKt.c(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
    }

    public static <T> List<List<T>> O0(Iterable<? extends T> iterable, int i11, int i12, boolean z11) {
        int g11;
        SlidingWindowKt.a(i11, i12);
        if (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) {
            ArrayList arrayList = new ArrayList();
            Iterator<List<T>> b11 = SlidingWindowKt.b(iterable.iterator(), i11, i12, z11, false);
            while (b11.hasNext()) {
                arrayList.add(b11.next());
            }
            return arrayList;
        }
        List list = (List) iterable;
        int size = list.size();
        ArrayList arrayList2 = new ArrayList((size / i12) + (size % i12 == 0 ? 0 : 1));
        int i13 = 0;
        while (true) {
            if (!(i13 >= 0 && i13 < size) || ((g11 = RangesKt___RangesKt.g(i11, size - i13)) < i11 && !z11)) {
                return arrayList2;
            }
            ArrayList arrayList3 = new ArrayList(g11);
            for (int i14 = 0; i14 < g11; i14++) {
                arrayList3.add(list.get(i14 + i13));
            }
            arrayList2.add(arrayList3);
            i13 += i12;
        }
        return arrayList2;
    }

    public static <T> g<T> P(Iterable<? extends T> iterable) {
        return new a(iterable);
    }

    public static /* synthetic */ List P0(Iterable iterable, int i11, int i12, boolean z11, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 1;
        }
        if ((i13 & 4) != 0) {
            z11 = false;
        }
        return O0(iterable, i11, i12, z11);
    }

    public static double Q(Iterable<Long> iterable) {
        double d11 = 0.0d;
        int i11 = 0;
        for (Long longValue : iterable) {
            d11 += (double) longValue.longValue();
            i11++;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.s();
            }
        }
        if (i11 == 0) {
            return Double.NaN;
        }
        return d11 / ((double) i11);
    }

    public static <T, R> List<Pair<T, R>> Q0(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        Iterator<? extends T> it2 = iterable.iterator();
        Iterator<? extends R> it3 = iterable2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt__IterablesKt.u(iterable, 10), CollectionsKt__IterablesKt.u(iterable2, 10)));
        while (it2.hasNext() && it3.hasNext()) {
            arrayList.add(l.a(it2.next(), it3.next()));
        }
        return arrayList;
    }

    public static <T> boolean R(Iterable<? extends T> iterable, T t11) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).contains(t11);
        }
        return e0(iterable, t11) >= 0;
    }

    public static <T> List<Pair<T, T>> R0(Iterable<? extends T> iterable) {
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return CollectionsKt__CollectionsKt.k();
        }
        ArrayList arrayList = new ArrayList();
        Object next = it2.next();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            arrayList.add(l.a(next, next2));
            next = next2;
        }
        return arrayList;
    }

    public static <T> List<T> S(Iterable<? extends T> iterable) {
        return I0(M0(iterable));
    }

    public static <T> List<T> T(Iterable<? extends T> iterable, int i11) {
        ArrayList arrayList;
        int i12 = 0;
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        } else if (i11 == 0) {
            return I0(iterable);
        } else {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                int size = collection.size() - i11;
                if (size <= 0) {
                    return CollectionsKt__CollectionsKt.k();
                }
                if (size == 1) {
                    return CollectionsKt__CollectionsJVMKt.e(l0(iterable));
                }
                arrayList = new ArrayList(size);
                if (iterable instanceof List) {
                    if (iterable instanceof RandomAccess) {
                        int size2 = collection.size();
                        while (i11 < size2) {
                            arrayList.add(((List) iterable).get(i11));
                            i11++;
                        }
                    } else {
                        ListIterator listIterator = ((List) iterable).listIterator(i11);
                        while (listIterator.hasNext()) {
                            arrayList.add(listIterator.next());
                        }
                    }
                    return arrayList;
                }
            } else {
                arrayList = new ArrayList();
            }
            for (Object next : iterable) {
                if (i12 >= i11) {
                    arrayList.add(next);
                } else {
                    i12++;
                }
            }
            return CollectionsKt__CollectionsKt.q(arrayList);
        }
    }

    public static <T> List<T> U(List<? extends T> list, int i11) {
        if (i11 >= 0) {
            return B0(list, RangesKt___RangesKt.d(list.size() - i11, 0));
        }
        throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
    }

    public static final <T> T V(Iterable<? extends T> iterable, int i11) {
        if (iterable instanceof List) {
            return ((List) iterable).get(i11);
        }
        return W(iterable, i11, new CollectionsKt___CollectionsKt$elementAt$1(i11));
    }

    public static final <T> T W(Iterable<? extends T> iterable, int i11, d10.l<? super Integer, ? extends T> lVar) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            return (i11 < 0 || i11 > CollectionsKt__CollectionsKt.m(list)) ? lVar.invoke(Integer.valueOf(i11)) : list.get(i11);
        } else if (i11 < 0) {
            return lVar.invoke(Integer.valueOf(i11));
        } else {
            int i12 = 0;
            for (T next : iterable) {
                int i13 = i12 + 1;
                if (i11 == i12) {
                    return next;
                }
                i12 = i13;
            }
            return lVar.invoke(Integer.valueOf(i11));
        }
    }

    public static <T> List<T> X(Iterable<? extends T> iterable) {
        return (List) Y(iterable, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C Y(Iterable<? extends T> iterable, C c11) {
        for (Object next : iterable) {
            if (next != null) {
                c11.add(next);
            }
        }
        return c11;
    }

    public static <T> T Z(Iterable<? extends T> iterable) {
        if (iterable instanceof List) {
            return a0((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T a0(List<? extends T> list) {
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T b0(Iterable<? extends T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (list.isEmpty()) {
                return null;
            }
            return list.get(0);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        return it2.next();
    }

    public static <T> T c0(List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static <T> T d0(List<? extends T> list, int i11) {
        if (i11 < 0 || i11 > CollectionsKt__CollectionsKt.m(list)) {
            return null;
        }
        return list.get(i11);
    }

    public static final <T> int e0(Iterable<? extends T> iterable, T t11) {
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t11);
        }
        int i11 = 0;
        for (Object next : iterable) {
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            if (x.b(t11, next)) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static <T> int f0(List<? extends T> list, T t11) {
        return list.indexOf(t11);
    }

    public static <T> Set<T> g0(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        Set<T> M0 = M0(iterable);
        CollectionsKt__MutableCollectionsKt.K(M0, iterable2);
        return M0;
    }

    public static final <T, A extends Appendable> A h0(Iterable<? extends T> iterable, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super T, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (Object next : iterable) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            StringsKt__AppendableKt.a(a11, next, lVar);
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static /* synthetic */ Appendable i0(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        String str = (i12 & 2) != 0 ? ", " : charSequence;
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 4) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 8) == 0) {
            charSequence5 = charSequence3;
        }
        return h0(iterable, appendable, str, charSequence6, charSequence5, (i12 & 16) != 0 ? -1 : i11, (i12 & 32) != 0 ? "..." : charSequence4, (i12 & 64) != 0 ? null : lVar);
    }

    public static final <T> String j0(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l<? super T, ? extends CharSequence> lVar) {
        return ((StringBuilder) h0(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String k0(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, d10.l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return j0(iterable, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static final <T> T l0(Iterable<? extends T> iterable) {
        if (iterable instanceof List) {
            return m0((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            while (it2.hasNext()) {
                next = it2.next();
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> T m0(List<? extends T> list) {
        if (!list.isEmpty()) {
            return list.get(CollectionsKt__CollectionsKt.m(list));
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> T n0(List<? extends T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(list.size() - 1);
    }

    public static <T extends Comparable<? super T>> T o0(Iterable<? extends T> iterable) {
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t11 = (Comparable) it2.next();
        while (it2.hasNext()) {
            T t12 = (Comparable) it2.next();
            if (t11.compareTo(t12) < 0) {
                t11 = t12;
            }
        }
        return t11;
    }

    public static <T extends Comparable<? super T>> T p0(Iterable<? extends T> iterable) {
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        T t11 = (Comparable) it2.next();
        while (it2.hasNext()) {
            T t12 = (Comparable) it2.next();
            if (t11.compareTo(t12) > 0) {
                t11 = t12;
            }
        }
        return t11;
    }

    public static <T> List<T> q0(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            Collection collection2 = (Collection) iterable;
            ArrayList arrayList = new ArrayList(collection.size() + collection2.size());
            arrayList.addAll(collection);
            arrayList.addAll(collection2);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList(collection);
        boolean unused = CollectionsKt__MutableCollectionsKt.A(arrayList2, iterable);
        return arrayList2;
    }

    public static <T> List<T> r0(Collection<? extends T> collection, T t11) {
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t11);
        return arrayList;
    }

    public static <T> List<T> s0(Collection<? extends T> collection, T[] tArr) {
        ArrayList arrayList = new ArrayList(collection.size() + tArr.length);
        arrayList.addAll(collection);
        boolean unused = CollectionsKt__MutableCollectionsKt.B(arrayList, tArr);
        return arrayList;
    }

    public static <T> T t0(Collection<? extends T> collection, Random random) {
        if (!collection.isEmpty()) {
            return V(collection, random.nextInt(collection.size()));
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static <T> List<T> u0(Iterable<? extends T> iterable) {
        if ((iterable instanceof Collection) && ((Collection) iterable).size() <= 1) {
            return I0(iterable);
        }
        List<T> K0 = K0(iterable);
        CollectionsKt___CollectionsJvmKt.O(K0);
        return K0;
    }

    public static <T> T v0(Iterable<? extends T> iterable) {
        if (iterable instanceof List) {
            return w0((List) iterable);
        }
        Iterator<? extends T> it2 = iterable.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            if (!it2.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T w0(List<? extends T> list) {
        int size = list.size();
        if (size == 0) {
            throw new NoSuchElementException("List is empty.");
        } else if (size == 1) {
            return list.get(0);
        } else {
            throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static <T> T x0(List<? extends T> list) {
        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    public static <T extends Comparable<? super T>> List<T> y0(Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return I0(iterable);
            }
            Object[] array = collection.toArray(new Comparable[0]);
            ArraysKt___ArraysJvmKt.w((Comparable[]) array);
            return ArraysKt___ArraysJvmKt.d(array);
        }
        List<T> K0 = K0(iterable);
        CollectionsKt__MutableCollectionsJVMKt.y(K0);
        return K0;
    }

    public static <T> List<T> z0(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= 1) {
                return I0(iterable);
            }
            Object[] array = collection.toArray(new Object[0]);
            ArraysKt___ArraysJvmKt.x(array, comparator);
            return ArraysKt___ArraysJvmKt.d(array);
        }
        List<T> K0 = K0(iterable);
        CollectionsKt__MutableCollectionsJVMKt.z(K0, comparator);
        return K0;
    }
}
