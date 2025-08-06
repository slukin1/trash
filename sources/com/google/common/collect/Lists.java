package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;

@GwtCompatible(emulated = true)
public final class Lists {

    public static class AbstractListWrapper<E> extends AbstractList<E> {
        public final List<E> backingList;

        public AbstractListWrapper(List<E> list) {
            this.backingList = (List) Preconditions.checkNotNull(list);
        }

        public void add(int i11, E e11) {
            this.backingList.add(i11, e11);
        }

        public boolean addAll(int i11, Collection<? extends E> collection) {
            return this.backingList.addAll(i11, collection);
        }

        public boolean contains(Object obj) {
            return this.backingList.contains(obj);
        }

        public E get(int i11) {
            return this.backingList.get(i11);
        }

        public E remove(int i11) {
            return this.backingList.remove(i11);
        }

        public E set(int i11, E e11) {
            return this.backingList.set(i11, e11);
        }

        public int size() {
            return this.backingList.size();
        }
    }

    public static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence sequence;

        public CharSequenceAsList(CharSequence charSequence) {
            this.sequence = charSequence;
        }

        public int size() {
            return this.sequence.length();
        }

        public Character get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Character.valueOf(this.sequence.charAt(i11));
        }
    }

    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        public final E first;
        public final E[] rest;

        public OnePlusArrayList(E e11, E[] eArr) {
            this.first = e11;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        public E get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return i11 == 0 ? this.first : this.rest[i11 - 1];
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }
    }

    public static class Partition<T> extends AbstractList<List<T>> {
        public final List<T> list;
        public final int size;

        public Partition(List<T> list2, int i11) {
            this.list = list2;
            this.size = i11;
        }

        public boolean isEmpty() {
            return this.list.isEmpty();
        }

        public int size() {
            return IntMath.divide(this.list.size(), this.size, RoundingMode.CEILING);
        }

        public List<T> get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            int i12 = this.size;
            int i13 = i11 * i12;
            return this.list.subList(i13, Math.min(i12 + i13, this.list.size()));
        }
    }

    public static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        public RandomAccessListWrapper(List<E> list) {
            super(list);
        }
    }

    public static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        public RandomAccessPartition(List<T> list, int i11) {
            super(list, i11);
        }
    }

    public static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        public RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    public static class ReverseList<T> extends AbstractList<T> {
        private final List<T> forwardList;

        public ReverseList(List<T> list) {
            this.forwardList = (List) Preconditions.checkNotNull(list);
        }

        private int reverseIndex(int i11) {
            int size = size();
            Preconditions.checkElementIndex(i11, size);
            return (size - 1) - i11;
        }

        /* access modifiers changed from: private */
        public int reversePosition(int i11) {
            int size = size();
            Preconditions.checkPositionIndex(i11, size);
            return size - i11;
        }

        public void add(int i11, T t11) {
            this.forwardList.add(reversePosition(i11), t11);
        }

        public void clear() {
            this.forwardList.clear();
        }

        public T get(int i11) {
            return this.forwardList.get(reverseIndex(i11));
        }

        public List<T> getForwardList() {
            return this.forwardList;
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i11) {
            final ListIterator<T> listIterator = this.forwardList.listIterator(reversePosition(i11));
            return new ListIterator<T>() {
                public boolean canRemoveOrSet;

                public void add(T t11) {
                    listIterator.add(t11);
                    listIterator.previous();
                    this.canRemoveOrSet = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                public T next() {
                    if (hasNext()) {
                        this.canRemoveOrSet = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return ReverseList.this.reversePosition(listIterator.nextIndex());
                }

                public T previous() {
                    if (hasPrevious()) {
                        this.canRemoveOrSet = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    CollectPreconditions.checkRemove(this.canRemoveOrSet);
                    listIterator.remove();
                    this.canRemoveOrSet = false;
                }

                public void set(T t11) {
                    Preconditions.checkState(this.canRemoveOrSet);
                    listIterator.set(t11);
                }
            };
        }

        public T remove(int i11) {
            return this.forwardList.remove(reverseIndex(i11));
        }

        public void removeRange(int i11, int i12) {
            subList(i11, i12).clear();
        }

        public T set(int i11, T t11) {
            return this.forwardList.set(reverseIndex(i11), t11);
        }

        public int size() {
            return this.forwardList.size();
        }

        public List<T> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            return Lists.reverse(this.forwardList.subList(reversePosition(i12), reversePosition(i11)));
        }
    }

    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        public StringAsImmutableList(String str) {
            this.string = str;
        }

        public int indexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public boolean isPartialView() {
            return false;
        }

        public int lastIndexOf(Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public int size() {
            return this.string.length();
        }

        public Character get(int i11) {
            Preconditions.checkElementIndex(i11, size());
            return Character.valueOf(this.string.charAt(i11));
        }

        public ImmutableList<Character> subList(int i11, int i12) {
            Preconditions.checkPositionIndexes(i11, i12, size());
            return Lists.charactersOf(this.string.substring(i11, i12));
        }
    }

    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final Function<? super F, ? extends T> function;

        public TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        public T get(int i11) {
            return this.function.apply(this.fromList.get(i11));
        }

        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i11) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i11)) {
                public T transform(F f11) {
                    return TransformingRandomAccessList.this.function.apply(f11);
                }
            };
        }

        public T remove(int i11) {
            return this.function.apply(this.fromList.remove(i11));
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        public final List<F> fromList;
        public final Function<? super F, ? extends T> function;

        public TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function2) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function2);
        }

        public void clear() {
            this.fromList.clear();
        }

        public ListIterator<T> listIterator(int i11) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i11)) {
                public T transform(F f11) {
                    return TransformingSequentialList.this.function.apply(f11);
                }
            };
        }

        public int size() {
            return this.fromList.size();
        }
    }

    public static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        public final E first;
        public final E[] rest;
        public final E second;

        public TwoPlusArrayList(E e11, E e12, E[] eArr) {
            this.first = e11;
            this.second = e12;
            this.rest = (Object[]) Preconditions.checkNotNull(eArr);
        }

        public E get(int i11) {
            if (i11 == 0) {
                return this.first;
            }
            if (i11 == 1) {
                return this.second;
            }
            Preconditions.checkElementIndex(i11, size());
            return this.rest[i11 - 2];
        }

        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }
    }

    private Lists() {
    }

    public static <E> boolean addAllImpl(List<E> list, int i11, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i11);
        boolean z11 = false;
        for (Object add : iterable) {
            listIterator.add(add);
            z11 = true;
        }
        return z11;
    }

    public static <E> List<E> asList(E e11, E[] eArr) {
        return new OnePlusArrayList(e11, eArr);
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        return CartesianList.create(list);
    }

    public static <T> List<T> cast(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(str));
    }

    @VisibleForTesting
    public static int computeArrayListCapacity(int i11) {
        CollectPreconditions.checkNonnegative(i11, "arraySize");
        return Ints.saturatedCast(((long) i11) + 5 + ((long) (i11 / 10)));
    }

    public static boolean equalsImpl(List<?> list, Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.elementsEqual(list.iterator(), list2.iterator());
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (!Objects.equal(list.get(i11), list2.get(i11))) {
                return false;
            }
        }
        return true;
    }

    public static int hashCodeImpl(List<?> list) {
        int i11;
        int i12 = 1;
        for (Object next : list) {
            int i13 = i12 * 31;
            if (next == null) {
                i11 = 0;
            } else {
                i11 = next.hashCode();
            }
            i12 = ~(~(i13 + i11));
        }
        return i12;
    }

    public static int indexOfImpl(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return indexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int indexOfRandomAccess(List<?> list, Object obj) {
        int size = list.size();
        int i11 = 0;
        if (obj == null) {
            while (i11 < size) {
                if (list.get(i11) == null) {
                    return i11;
                }
                i11++;
            }
            return -1;
        }
        while (i11 < size) {
            if (obj.equals(list.get(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public static int lastIndexOfImpl(List<?> list, Object obj) {
        if (list instanceof RandomAccess) {
            return lastIndexOfRandomAccess(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int lastIndexOfRandomAccess(List<?> list, Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    public static <E> ListIterator<E> listIteratorImpl(List<E> list, int i11) {
        return new AbstractListWrapper(list).listIterator(i11);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i11) {
        CollectPreconditions.checkNonnegative(i11, "initialArraySize");
        return new ArrayList<>(i11);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i11) {
        return new ArrayList<>(computeArrayListCapacity(i11));
    }

    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <T> List<List<T>> partition(List<T> list, int i11) {
        Preconditions.checkNotNull(list);
        Preconditions.checkArgument(i11 > 0);
        return list instanceof RandomAccess ? new RandomAccessPartition(list, i11) : new Partition(list, i11);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).getForwardList();
        }
        if (list instanceof RandomAccess) {
            return new RandomAccessReverseList(list);
        }
        return new ReverseList(list);
    }

    public static <E> List<E> subListImpl(List<E> list, int i11, int i12) {
        List list2;
        if (list instanceof RandomAccess) {
            list2 = new RandomAccessListWrapper<E>(list) {
                private static final long serialVersionUID = 0;

                public ListIterator<E> listIterator(int i11) {
                    return this.backingList.listIterator(i11);
                }
            };
        } else {
            list2 = new AbstractListWrapper<E>(list) {
                private static final long serialVersionUID = 0;

                public ListIterator<E> listIterator(int i11) {
                    return this.backingList.listIterator(i11);
                }
            };
        }
        return list2.subList(i11, i12);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    public static <E> List<E> asList(E e11, E e12, E[] eArr) {
        return new TwoPlusArrayList(e11, e12, eArr);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    @Beta
    public static List<Character> charactersOf(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    @GwtCompatible(serializable = true)
    @SafeVarargs
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        ArrayList<E> arrayList = new ArrayList<>(computeArrayListCapacity(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> java.util.concurrent.CopyOnWriteArrayList<E> newCopyOnWriteArrayList(java.lang.Iterable<? extends E> r1) {
        /*
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0009
            java.util.Collection r1 = com.google.common.collect.Collections2.cast(r1)
            goto L_0x000d
        L_0x0009:
            java.util.ArrayList r1 = newArrayList(r1)
        L_0x000d:
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Lists.newCopyOnWriteArrayList(java.lang.Iterable):java.util.concurrent.CopyOnWriteArrayList");
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(Collections2.cast(iterable));
        }
        return newArrayList(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it2) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it2);
        return newArrayList;
    }
}
