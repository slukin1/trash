package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

@GwtCompatible
@Beta
final class SortedLists {

    public enum KeyAbsentBehavior {
        NEXT_LOWER {
            public int resultIndex(int i11) {
                return i11 - 1;
            }
        },
        NEXT_HIGHER {
            public int resultIndex(int i11) {
                return i11;
            }
        },
        INVERTED_INSERTION_INDEX {
            public int resultIndex(int i11) {
                return ~i11;
            }
        };

        public abstract int resultIndex(int i11);
    }

    public enum KeyPresentBehavior {
        ANY_PRESENT {
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return i11;
            }
        },
        LAST_PRESENT {
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                int size = list.size() - 1;
                while (i11 < size) {
                    int i12 = ((i11 + size) + 1) >>> 1;
                    if (comparator.compare(list.get(i12), e11) > 0) {
                        size = i12 - 1;
                    } else {
                        i11 = i12;
                    }
                }
                return i11;
            }
        },
        FIRST_PRESENT {
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                int i12 = 0;
                while (i12 < i11) {
                    int i13 = (i12 + i11) >>> 1;
                    if (comparator.compare(list.get(i13), e11) < 0) {
                        i12 = i13 + 1;
                    } else {
                        i11 = i13;
                    }
                }
                return i12;
            }
        },
        FIRST_AFTER {
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return KeyPresentBehavior.LAST_PRESENT.resultIndex(comparator, e11, list, i11) + 1;
            }
        },
        LAST_BEFORE {
            public <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11) {
                return KeyPresentBehavior.FIRST_PRESENT.resultIndex(comparator, e11, list, i11) - 1;
            }
        };

        public abstract <E> int resultIndex(Comparator<? super E> comparator, E e11, List<? extends E> list, int i11);
    }

    private SortedLists() {
    }

    public static <E extends Comparable> int binarySearch(List<? extends E> list, E e11, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(e11);
        return binarySearch(list, e11, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K extends Comparable> int binarySearch(List<E> list, Function<? super E, K> function, K k11, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch(list, function, k11, Ordering.natural(), keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E, K> int binarySearch(List<E> list, Function<? super E, K> function, K k11, Comparator<? super K> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        return binarySearch(Lists.transform(list, function), k11, comparator, keyPresentBehavior, keyAbsentBehavior);
    }

    public static <E> int binarySearch(List<? extends E> list, E e11, Comparator<? super E> comparator, KeyPresentBehavior keyPresentBehavior, KeyAbsentBehavior keyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull(keyPresentBehavior);
        Preconditions.checkNotNull(keyAbsentBehavior);
        boolean z11 = list instanceof RandomAccess;
        ArrayList<? extends E> arrayList = list;
        if (!z11) {
            arrayList = Lists.newArrayList(list);
        }
        int i11 = 0;
        int size = arrayList.size() - 1;
        while (i11 <= size) {
            int i12 = (i11 + size) >>> 1;
            int compare = comparator.compare(e11, arrayList.get(i12));
            if (compare < 0) {
                size = i12 - 1;
            } else if (compare <= 0) {
                return i11 + keyPresentBehavior.resultIndex(comparator, e11, arrayList.subList(i11, size + 1), i12 - i11);
            } else {
                i11 = i12 + 1;
            }
        }
        return keyAbsentBehavior.resultIndex(i11);
    }
}
