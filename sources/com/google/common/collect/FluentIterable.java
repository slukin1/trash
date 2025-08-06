package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional<Iterable<E>> iterableDelegate;

    public static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        public FluentIterable<E> apply(Iterable<E> iterable) {
            return FluentIterable.from(iterable);
        }
    }

    public FluentIterable() {
        this.iterableDelegate = Optional.absent();
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return concatNoDefensiveCopy(iterable, iterable2);
    }

    private static <T> FluentIterable<T> concatNoDefensiveCopy(final Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> checkNotNull : iterableArr) {
            Preconditions.checkNotNull(checkNotNull);
        }
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.concat(new AbstractIndexedListIterator<Iterator<? extends T>>(iterableArr.length) {
                    public Iterator<? extends T> get(int i11) {
                        return iterableArr[i11].iterator();
                    }
                });
            }
        };
    }

    public static <E> FluentIterable<E> from(final Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new FluentIterable<E>(iterable) {
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    private Iterable<E> getDelegate() {
        return this.iterableDelegate.or(this);
    }

    @Beta
    public static <E> FluentIterable<E> of() {
        return from(ImmutableList.of());
    }

    public final boolean allMatch(Predicate<? super E> predicate) {
        return Iterables.all(getDelegate(), predicate);
    }

    public final boolean anyMatch(Predicate<? super E> predicate) {
        return Iterables.any(getDelegate(), predicate);
    }

    @Beta
    public final FluentIterable<E> append(Iterable<? extends E> iterable) {
        return concat(getDelegate(), iterable);
    }

    public final boolean contains(Object obj) {
        return Iterables.contains(getDelegate(), obj);
    }

    @CanIgnoreReturnValue
    public final <C extends Collection<? super E>> C copyInto(C c11) {
        Preconditions.checkNotNull(c11);
        Iterable<Object> delegate = getDelegate();
        if (delegate instanceof Collection) {
            c11.addAll(Collections2.cast(delegate));
        } else {
            for (Object add : delegate) {
                c11.add(add);
            }
        }
        return c11;
    }

    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(getDelegate()));
    }

    public final FluentIterable<E> filter(Predicate<? super E> predicate) {
        return from(Iterables.filter(getDelegate(), predicate));
    }

    public final Optional<E> first() {
        Iterator it2 = getDelegate().iterator();
        return it2.hasNext() ? Optional.of(it2.next()) : Optional.absent();
    }

    public final Optional<E> firstMatch(Predicate<? super E> predicate) {
        return Iterables.tryFind(getDelegate(), predicate);
    }

    public final E get(int i11) {
        return Iterables.get(getDelegate(), i11);
    }

    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> function) {
        return Multimaps.index(getDelegate(), function);
    }

    public final boolean isEmpty() {
        return !getDelegate().iterator().hasNext();
    }

    @Beta
    public final String join(Joiner joiner) {
        return joiner.join((Iterable<?>) this);
    }

    public final Optional<E> last() {
        Object next;
        Iterable delegate = getDelegate();
        if (delegate instanceof List) {
            List list = (List) delegate;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.of(list.get(list.size() - 1));
        }
        Iterator it2 = delegate.iterator();
        if (!it2.hasNext()) {
            return Optional.absent();
        }
        if (delegate instanceof SortedSet) {
            return Optional.of(((SortedSet) delegate).last());
        }
        do {
            next = it2.next();
        } while (it2.hasNext());
        return Optional.of(next);
    }

    public final FluentIterable<E> limit(int i11) {
        return from(Iterables.limit(getDelegate(), i11));
    }

    public final int size() {
        return Iterables.size(getDelegate());
    }

    public final FluentIterable<E> skip(int i11) {
        return from(Iterables.skip(getDelegate(), i11));
    }

    @GwtIncompatible
    public final E[] toArray(Class<E> cls) {
        return Iterables.toArray(getDelegate(), cls);
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(getDelegate());
    }

    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> function) {
        return Maps.toMap(getDelegate(), function);
    }

    public final ImmutableMultiset<E> toMultiset() {
        return ImmutableMultiset.copyOf(getDelegate());
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(getDelegate());
    }

    public final ImmutableList<E> toSortedList(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(getDelegate());
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, getDelegate());
    }

    public String toString() {
        return Iterables.toString(getDelegate());
    }

    public final <T> FluentIterable<T> transform(Function<? super E, T> function) {
        return from(Iterables.transform(getDelegate(), function));
    }

    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> function) {
        return concat(transform(function));
    }

    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> function) {
        return Maps.uniqueIndex(getDelegate(), function);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return concatNoDefensiveCopy(iterable, iterable2, iterable3);
    }

    @Beta
    public static <E> FluentIterable<E> from(E[] eArr) {
        return from(Arrays.asList(eArr));
    }

    @Beta
    public static <E> FluentIterable<E> of(E e11, E... eArr) {
        return from(Lists.asList(e11, eArr));
    }

    @Beta
    public final FluentIterable<E> append(E... eArr) {
        return concat(getDelegate(), Arrays.asList(eArr));
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> filter(Class<T> cls) {
        return from(Iterables.filter((Iterable<?>) getDelegate(), cls));
    }

    public FluentIterable(Iterable<E> iterable) {
        Preconditions.checkNotNull(iterable);
        this.iterableDelegate = Optional.fromNullable(this == iterable ? null : iterable);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return concatNoDefensiveCopy(iterable, iterable2, iterable3, iterable4);
    }

    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> fluentIterable) {
        return (FluentIterable) Preconditions.checkNotNull(fluentIterable);
    }

    @Beta
    public static <T> FluentIterable<T> concat(Iterable<? extends T>... iterableArr) {
        return concatNoDefensiveCopy((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    @Beta
    public static <T> FluentIterable<T> concat(final Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.concat(Iterators.transform(iterable.iterator(), Iterables.toIterator()));
            }
        };
    }
}
