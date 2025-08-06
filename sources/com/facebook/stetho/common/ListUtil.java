package com.facebook.stetho.common;

import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class ListUtil {

    public static final class FiveItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;
        private final E mItem4;

        public FiveItemImmutableList(E e11, E e12, E e13, E e14, E e15) {
            this.mItem0 = e11;
            this.mItem1 = e12;
            this.mItem2 = e13;
            this.mItem3 = e14;
            this.mItem4 = e15;
        }

        public E get(int i11) {
            if (i11 == 0) {
                return this.mItem0;
            }
            if (i11 == 1) {
                return this.mItem1;
            }
            if (i11 == 2) {
                return this.mItem2;
            }
            if (i11 == 3) {
                return this.mItem3;
            }
            if (i11 == 4) {
                return this.mItem4;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 5;
        }
    }

    public static final class FourItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;
        private final E mItem3;

        public FourItemImmutableList(E e11, E e12, E e13, E e14) {
            this.mItem0 = e11;
            this.mItem1 = e12;
            this.mItem2 = e13;
            this.mItem3 = e14;
        }

        public E get(int i11) {
            if (i11 == 0) {
                return this.mItem0;
            }
            if (i11 == 1) {
                return this.mItem1;
            }
            if (i11 == 2) {
                return this.mItem2;
            }
            if (i11 == 3) {
                return this.mItem3;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 4;
        }
    }

    public static final class ImmutableArrayList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final Object[] mArray;

        public ImmutableArrayList(Object[] objArr) {
            this.mArray = objArr;
        }

        public E get(int i11) {
            return this.mArray[i11];
        }

        public int size() {
            return this.mArray.length;
        }
    }

    public interface ImmutableList<E> extends List<E>, RandomAccess {
    }

    public static final class OneItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem;

        public OneItemImmutableList(E e11) {
            this.mItem = e11;
        }

        public E get(int i11) {
            if (i11 == 0) {
                return this.mItem;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 1;
        }
    }

    public static final class ThreeItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;
        private final E mItem2;

        public ThreeItemImmutableList(E e11, E e12, E e13) {
            this.mItem0 = e11;
            this.mItem1 = e12;
            this.mItem2 = e13;
        }

        public E get(int i11) {
            if (i11 == 0) {
                return this.mItem0;
            }
            if (i11 == 1) {
                return this.mItem1;
            }
            if (i11 == 2) {
                return this.mItem2;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 3;
        }
    }

    public static final class TwoItemImmutableList<E> extends AbstractList<E> implements ImmutableList<E> {
        private final E mItem0;
        private final E mItem1;

        public TwoItemImmutableList(E e11, E e12) {
            this.mItem0 = e11;
            this.mItem1 = e12;
        }

        public E get(int i11) {
            if (i11 == 0) {
                return this.mItem0;
            }
            if (i11 == 1) {
                return this.mItem1;
            }
            throw new IndexOutOfBoundsException();
        }

        public int size() {
            return 2;
        }
    }

    private ListUtil() {
    }

    public static <T> List<T> copyToImmutableList(List<T> list) {
        if (list instanceof ImmutableList) {
            return list;
        }
        int size = list.size();
        if (size == 0) {
            return Collections.emptyList();
        }
        if (size == 1) {
            return new OneItemImmutableList(list.get(0));
        }
        if (size == 2) {
            return new TwoItemImmutableList(list.get(0), list.get(1));
        }
        if (size == 3) {
            return new ThreeItemImmutableList(list.get(0), list.get(1), list.get(2));
        }
        if (size == 4) {
            return new FourItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3));
        }
        if (size != 5) {
            return new ImmutableArrayList(list.toArray());
        }
        return new FiveItemImmutableList(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4));
    }

    public static <T> boolean identityEquals(List<? extends T> list, List<? extends T> list2) {
        if (list == list2) {
            return true;
        }
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        for (int i11 = 0; i11 < size; i11++) {
            if (list.get(i11) != list2.get(i11)) {
                return false;
            }
        }
        return true;
    }

    public static <T> List<T> newImmutableList(T t11) {
        return new OneItemImmutableList(t11);
    }

    public static <T> List<T> newImmutableList(T t11, T t12) {
        return new TwoItemImmutableList(t11, t12);
    }
}
