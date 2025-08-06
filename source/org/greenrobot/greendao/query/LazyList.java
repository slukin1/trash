package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

public class LazyList<E> implements List<E>, Closeable {
    private final Cursor cursor;
    private final InternalQueryDaoAccess<E> daoAccess;
    private final List<E> entities;
    private volatile int loadedCount;
    private final ReentrantLock lock;
    /* access modifiers changed from: private */
    public final int size;

    public class LazyIterator implements CloseableListIterator<E> {
        private final boolean closeWhenDone;
        private int index;

        public LazyIterator(int i11, boolean z11) {
            this.index = i11;
            this.closeWhenDone = z11;
        }

        public void add(E e11) {
            throw new UnsupportedOperationException();
        }

        public void close() {
            LazyList.this.close();
        }

        public boolean hasNext() {
            return this.index < LazyList.this.size;
        }

        public boolean hasPrevious() {
            return this.index > 0;
        }

        public E next() {
            if (this.index < LazyList.this.size) {
                E e11 = LazyList.this.get(this.index);
                int i11 = this.index + 1;
                this.index = i11;
                if (i11 == LazyList.this.size && this.closeWhenDone) {
                    close();
                }
                return e11;
            }
            throw new NoSuchElementException();
        }

        public int nextIndex() {
            return this.index;
        }

        public E previous() {
            int i11 = this.index;
            if (i11 > 0) {
                int i12 = i11 - 1;
                this.index = i12;
                return LazyList.this.get(i12);
            }
            throw new NoSuchElementException();
        }

        public int previousIndex() {
            return this.index - 1;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(E e11) {
            throw new UnsupportedOperationException();
        }
    }

    public LazyList(InternalQueryDaoAccess<E> internalQueryDaoAccess, Cursor cursor2, boolean z11) {
        this.cursor = cursor2;
        this.daoAccess = internalQueryDaoAccess;
        int count = cursor2.getCount();
        this.size = count;
        if (z11) {
            this.entities = new ArrayList(count);
            for (int i11 = 0; i11 < this.size; i11++) {
                this.entities.add((Object) null);
            }
        } else {
            this.entities = null;
        }
        if (this.size == 0) {
            cursor2.close();
        }
        this.lock = new ReentrantLock();
    }

    public boolean add(E e11) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void checkCached() {
        if (this.entities == null) {
            throw new DaoException("This operation only works with cached lazy lists");
        }
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void close() {
        this.cursor.close();
    }

    public boolean contains(Object obj) {
        loadRemaining();
        return this.entities.contains(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        loadRemaining();
        return this.entities.containsAll(collection);
    }

    public E get(int i11) {
        List<E> list = this.entities;
        if (list != null) {
            E e11 = list.get(i11);
            if (e11 == null) {
                this.lock.lock();
                try {
                    e11 = this.entities.get(i11);
                    if (e11 == null) {
                        e11 = loadEntity(i11);
                        this.entities.set(i11, e11);
                        this.loadedCount++;
                        if (this.loadedCount == this.size) {
                            this.cursor.close();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
            return e11;
        }
        this.lock.lock();
        try {
            return loadEntity(i11);
        } finally {
            this.lock.unlock();
        }
    }

    public int getLoadedCount() {
        return this.loadedCount;
    }

    public int indexOf(Object obj) {
        loadRemaining();
        return this.entities.indexOf(obj);
    }

    public boolean isClosed() {
        return this.cursor.isClosed();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isLoadedCompletely() {
        return this.loadedCount == this.size;
    }

    public Iterator<E> iterator() {
        return new LazyIterator(0, false);
    }

    public int lastIndexOf(Object obj) {
        loadRemaining();
        return this.entities.lastIndexOf(obj);
    }

    public CloseableListIterator<E> listIteratorAutoClose() {
        return new LazyIterator(0, true);
    }

    public E loadEntity(int i11) {
        if (this.cursor.moveToPosition(i11)) {
            E loadCurrent = this.daoAccess.loadCurrent(this.cursor, 0, true);
            if (loadCurrent != null) {
                return loadCurrent;
            }
            throw new DaoException("Loading of entity failed (null) at position " + i11);
        }
        throw new DaoException("Could not move to cursor location " + i11);
    }

    public void loadRemaining() {
        checkCached();
        int size2 = this.entities.size();
        for (int i11 = 0; i11 < size2; i11++) {
            get(i11);
        }
    }

    public E peek(int i11) {
        List<E> list = this.entities;
        if (list != null) {
            return list.get(i11);
        }
        return null;
    }

    public E remove(int i11) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public E set(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.size;
    }

    public List<E> subList(int i11, int i12) {
        checkCached();
        for (int i13 = i11; i13 < i12; i13++) {
            get(i13);
        }
        return this.entities.subList(i11, i12);
    }

    public Object[] toArray() {
        loadRemaining();
        return this.entities.toArray();
    }

    public void add(int i11, E e11) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(int i11, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public CloseableListIterator<E> listIterator() {
        return new LazyIterator(0, false);
    }

    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator(int i11) {
        return new LazyIterator(i11, false);
    }

    public <T> T[] toArray(T[] tArr) {
        loadRemaining();
        return this.entities.toArray(tArr);
    }
}
