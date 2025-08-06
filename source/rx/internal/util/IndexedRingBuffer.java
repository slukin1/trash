package rx.internal.util;

import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

public final class IndexedRingBuffer<E> implements Subscription {
    public static final int SIZE;
    private final ElementSection<E> elements = new ElementSection<>();
    public final AtomicInteger index = new AtomicInteger();
    private final IndexSection removed = new IndexSection();
    public final AtomicInteger removedIndex = new AtomicInteger();

    public static final class ElementSection<E> {
        public final AtomicReferenceArray<E> array = new AtomicReferenceArray<>(IndexedRingBuffer.SIZE);
        public final AtomicReference<ElementSection<E>> next = new AtomicReference<>();

        public ElementSection<E> getNext() {
            if (this.next.get() != null) {
                return this.next.get();
            }
            ElementSection<E> elementSection = new ElementSection<>();
            if (this.next.compareAndSet((Object) null, elementSection)) {
                return elementSection;
            }
            return this.next.get();
        }
    }

    public static class IndexSection {
        private final AtomicReference<IndexSection> _next = new AtomicReference<>();
        private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);

        public int getAndSet(int i11, int i12) {
            return this.unsafeArray.getAndSet(i11, i12);
        }

        public IndexSection getNext() {
            if (this._next.get() != null) {
                return this._next.get();
            }
            IndexSection indexSection = new IndexSection();
            if (this._next.compareAndSet((Object) null, indexSection)) {
                return indexSection;
            }
            return this._next.get();
        }

        public void set(int i11, int i12) {
            this.unsafeArray.set(i11, i12);
        }
    }

    static {
        int i11 = PlatformDependent.isAndroid() ? 8 : 128;
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                i11 = Integer.parseInt(property);
            } catch (NumberFormatException e11) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e11.getMessage());
            }
        }
        SIZE = i11;
    }

    private ElementSection<E> getElementSection(int i11) {
        int i12 = SIZE;
        if (i11 < i12) {
            return this.elements;
        }
        int i13 = i11 / i12;
        ElementSection<E> elementSection = this.elements;
        for (int i14 = 0; i14 < i13; i14++) {
            elementSection = elementSection.getNext();
        }
        return elementSection;
    }

    private synchronized int getIndexForAdd() {
        int i11;
        int indexFromPreviouslyRemoved = getIndexFromPreviouslyRemoved();
        if (indexFromPreviouslyRemoved >= 0) {
            int i12 = SIZE;
            if (indexFromPreviouslyRemoved < i12) {
                i11 = this.removed.getAndSet(indexFromPreviouslyRemoved, -1);
            } else {
                i11 = getIndexSection(indexFromPreviouslyRemoved).getAndSet(indexFromPreviouslyRemoved % i12, -1);
            }
            if (i11 == this.index.get()) {
                this.index.getAndIncrement();
            }
        } else {
            i11 = this.index.getAndIncrement();
        }
        return i11;
    }

    private synchronized int getIndexFromPreviouslyRemoved() {
        int i11;
        int i12;
        do {
            i11 = this.removedIndex.get();
            if (i11 <= 0) {
                return -1;
            }
            i12 = i11 - 1;
        } while (!this.removedIndex.compareAndSet(i11, i12));
        return i12;
    }

    private IndexSection getIndexSection(int i11) {
        int i12 = SIZE;
        if (i11 < i12) {
            return this.removed;
        }
        int i13 = i11 / i12;
        IndexSection indexSection = this.removed;
        for (int i14 = 0; i14 < i13; i14++) {
            indexSection = indexSection.getNext();
        }
        return indexSection;
    }

    public static <T> IndexedRingBuffer<T> getInstance() {
        return new IndexedRingBuffer<>();
    }

    private synchronized void pushRemovedIndex(int i11) {
        int andIncrement = this.removedIndex.getAndIncrement();
        int i12 = SIZE;
        if (andIncrement < i12) {
            this.removed.set(andIncrement, i11);
        } else {
            getIndexSection(andIncrement).set(andIncrement % i12, i11);
        }
    }

    public int add(E e11) {
        int indexForAdd = getIndexForAdd();
        int i11 = SIZE;
        if (indexForAdd < i11) {
            this.elements.array.set(indexForAdd, e11);
            return indexForAdd;
        }
        getElementSection(indexForAdd).array.set(indexForAdd % i11, e11);
        return indexForAdd;
    }

    public int forEach(Func1<? super E, Boolean> func1) {
        return forEach(func1, 0);
    }

    public boolean isUnsubscribed() {
        return false;
    }

    public void releaseToPool() {
        int i11 = this.index.get();
        int i12 = 0;
        loop0:
        for (ElementSection<E> elementSection = this.elements; elementSection != null; elementSection = elementSection.next.get()) {
            int i13 = 0;
            while (i13 < SIZE) {
                if (i12 >= i11) {
                    break loop0;
                }
                elementSection.array.set(i13, (Object) null);
                i13++;
                i12++;
            }
        }
        this.index.set(0);
        this.removedIndex.set(0);
    }

    public E remove(int i11) {
        E e11;
        int i12 = SIZE;
        if (i11 < i12) {
            e11 = this.elements.array.getAndSet(i11, (Object) null);
        } else {
            e11 = getElementSection(i11).array.getAndSet(i11 % i12, (Object) null);
        }
        pushRemovedIndex(i11);
        return e11;
    }

    public void unsubscribe() {
        releaseToPool();
    }

    public int forEach(Func1<? super E, Boolean> func1, int i11) {
        int forEach = forEach(func1, i11, this.index.get());
        if (i11 > 0 && forEach == this.index.get()) {
            return forEach(func1, 0, i11);
        }
        if (forEach == this.index.get()) {
            return 0;
        }
        return forEach;
    }

    private int forEach(Func1<? super E, Boolean> func1, int i11, int i12) {
        ElementSection<E> elementSection;
        int i13;
        int i14 = this.index.get();
        ElementSection<E> elementSection2 = this.elements;
        int i15 = SIZE;
        if (i11 >= i15) {
            ElementSection<E> elementSection3 = getElementSection(i11);
            i13 = i11;
            i11 %= i15;
            elementSection = elementSection3;
        } else {
            elementSection = elementSection2;
            i13 = i11;
        }
        loop0:
        while (elementSection != null) {
            while (i11 < SIZE) {
                if (i13 >= i14 || i13 >= i12) {
                    break loop0;
                }
                E e11 = elementSection.array.get(i11);
                if (e11 != null && !func1.call(e11).booleanValue()) {
                    return i13;
                }
                i11++;
                i13++;
            }
            elementSection = elementSection.next.get();
            i11 = 0;
        }
        return i13;
    }
}
