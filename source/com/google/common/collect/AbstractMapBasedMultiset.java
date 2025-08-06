package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient ObjectCountHashMap<E> backingMap;
    public transient long size;

    public abstract class Itr<T> implements Iterator<T> {
        public int entryIndex;
        public int expectedModCount;
        public int toRemove = -1;

        public Itr() {
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.firstIndex();
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        private void checkForConcurrentModification() {
            if (AbstractMapBasedMultiset.this.backingMap.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public boolean hasNext() {
            checkForConcurrentModification();
            return this.entryIndex >= 0;
        }

        public T next() {
            if (hasNext()) {
                T result = result(this.entryIndex);
                int i11 = this.entryIndex;
                this.toRemove = i11;
                this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndex(i11);
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            checkForConcurrentModification();
            CollectPreconditions.checkRemove(this.toRemove != -1);
            AbstractMapBasedMultiset abstractMapBasedMultiset = AbstractMapBasedMultiset.this;
            abstractMapBasedMultiset.size -= (long) abstractMapBasedMultiset.backingMap.removeEntry(this.toRemove);
            this.entryIndex = AbstractMapBasedMultiset.this.backingMap.nextIndexAfterRemove(this.entryIndex, this.toRemove);
            this.toRemove = -1;
            this.expectedModCount = AbstractMapBasedMultiset.this.backingMap.modCount;
        }

        public abstract T result(int i11);
    }

    public AbstractMapBasedMultiset(int i11) {
        init(i11);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        init(3);
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @CanIgnoreReturnValue
    public final int add(E e11, int i11) {
        if (i11 == 0) {
            return count(e11);
        }
        boolean z11 = true;
        Preconditions.checkArgument(i11 > 0, "occurrences cannot be negative: %s", i11);
        int indexOf = this.backingMap.indexOf(e11);
        if (indexOf == -1) {
            this.backingMap.put(e11, i11);
            this.size += (long) i11;
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        long j11 = (long) i11;
        long j12 = ((long) value) + j11;
        if (j12 > 2147483647L) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "too many occurrences: %s", j12);
        this.backingMap.setValue(indexOf, (int) j12);
        this.size += j11;
        return value;
    }

    public void addTo(Multiset<? super E> multiset) {
        Preconditions.checkNotNull(multiset);
        int firstIndex = this.backingMap.firstIndex();
        while (firstIndex >= 0) {
            multiset.add(this.backingMap.getKey(firstIndex), this.backingMap.getValue(firstIndex));
            firstIndex = this.backingMap.nextIndex(firstIndex);
        }
    }

    public final void clear() {
        this.backingMap.clear();
        this.size = 0;
    }

    public final int count(Object obj) {
        return this.backingMap.get(obj);
    }

    public final int distinctElements() {
        return this.backingMap.size();
    }

    public final Iterator<E> elementIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<E>() {
            public E result(int i11) {
                return AbstractMapBasedMultiset.this.backingMap.getKey(i11);
            }
        };
    }

    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new AbstractMapBasedMultiset<E>.Itr<Multiset.Entry<E>>() {
            public Multiset.Entry<E> result(int i11) {
                return AbstractMapBasedMultiset.this.backingMap.getEntry(i11);
            }
        };
    }

    public abstract void init(int i11);

    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @CanIgnoreReturnValue
    public final int remove(Object obj, int i11) {
        if (i11 == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i11 > 0, "occurrences cannot be negative: %s", i11);
        int indexOf = this.backingMap.indexOf(obj);
        if (indexOf == -1) {
            return 0;
        }
        int value = this.backingMap.getValue(indexOf);
        if (value > i11) {
            this.backingMap.setValue(indexOf, value - i11);
        } else {
            this.backingMap.removeEntry(indexOf);
            i11 = value;
        }
        this.size -= (long) i11;
        return value;
    }

    @CanIgnoreReturnValue
    public final int setCount(E e11, int i11) {
        CollectPreconditions.checkNonnegative(i11, "count");
        ObjectCountHashMap<E> objectCountHashMap = this.backingMap;
        int remove = i11 == 0 ? objectCountHashMap.remove(e11) : objectCountHashMap.put(e11, i11);
        this.size += (long) (i11 - remove);
        return remove;
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    public final boolean setCount(E e11, int i11, int i12) {
        CollectPreconditions.checkNonnegative(i11, "oldCount");
        CollectPreconditions.checkNonnegative(i12, "newCount");
        int indexOf = this.backingMap.indexOf(e11);
        if (indexOf == -1) {
            if (i11 != 0) {
                return false;
            }
            if (i12 > 0) {
                this.backingMap.put(e11, i12);
                this.size += (long) i12;
            }
            return true;
        } else if (this.backingMap.getValue(indexOf) != i11) {
            return false;
        } else {
            if (i12 == 0) {
                this.backingMap.removeEntry(indexOf);
                this.size -= (long) i11;
            } else {
                this.backingMap.setValue(indexOf, i12);
                this.size += (long) (i12 - i11);
            }
            return true;
        }
    }
}
