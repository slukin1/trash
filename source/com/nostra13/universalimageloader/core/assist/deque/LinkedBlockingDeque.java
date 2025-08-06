package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingQueue, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    public transient e<E> first;
    public transient e<E> last;
    public final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    public abstract class b implements Iterator<E> {

        /* renamed from: b  reason: collision with root package name */
        public e<E> f28366b;

        /* renamed from: c  reason: collision with root package name */
        public E f28367c;

        /* renamed from: d  reason: collision with root package name */
        public e<E> f28368d;

        public b() {
            E e11;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> b11 = b();
                this.f28366b = b11;
                if (b11 == null) {
                    e11 = null;
                } else {
                    e11 = b11.f28372a;
                }
                this.f28367c = e11;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void a() {
            E e11;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                e<E> d11 = d(this.f28366b);
                this.f28366b = d11;
                if (d11 == null) {
                    e11 = null;
                } else {
                    e11 = d11.f28372a;
                }
                this.f28367c = e11;
            } finally {
                reentrantLock.unlock();
            }
        }

        public abstract e<E> b();

        public abstract e<E> c(e<E> eVar);

        public final e<E> d(e<E> eVar) {
            while (true) {
                e<E> c11 = c(eVar);
                if (c11 == null) {
                    return null;
                }
                if (c11.f28372a != null) {
                    return c11;
                }
                if (c11 == eVar) {
                    return b();
                }
                eVar = c11;
            }
        }

        public boolean hasNext() {
            return this.f28366b != null;
        }

        public E next() {
            e<E> eVar = this.f28366b;
            if (eVar != null) {
                this.f28368d = eVar;
                E e11 = this.f28367c;
                a();
                return e11;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            e<E> eVar = this.f28368d;
            if (eVar != null) {
                this.f28368d = null;
                ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
                reentrantLock.lock();
                try {
                    if (eVar.f28372a != null) {
                        LinkedBlockingDeque.this.unlink(eVar);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public class c extends LinkedBlockingDeque<E>.b {
        public c() {
            super();
        }

        public e<E> b() {
            return LinkedBlockingDeque.this.last;
        }

        public e<E> c(e<E> eVar) {
            return eVar.f28373b;
        }
    }

    public class d extends LinkedBlockingDeque<E>.b {
        public d() {
            super();
        }

        public e<E> b() {
            return LinkedBlockingDeque.this.first;
        }

        public e<E> c(e<E> eVar) {
            return eVar.f28374c;
        }
    }

    public static final class e<E> {

        /* renamed from: a  reason: collision with root package name */
        public E f28372a;

        /* renamed from: b  reason: collision with root package name */
        public e<E> f28373b;

        /* renamed from: c  reason: collision with root package name */
        public e<E> f28374c;

        public e(E e11) {
            this.f28372a = e11;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    private boolean linkFirst(e<E> eVar) {
        int i11 = this.count;
        if (i11 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.first;
        eVar.f28374c = eVar2;
        this.first = eVar;
        if (this.last == null) {
            this.last = eVar;
        } else {
            eVar2.f28373b = eVar;
        }
        this.count = i11 + 1;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(e<E> eVar) {
        int i11 = this.count;
        if (i11 >= this.capacity) {
            return false;
        }
        e<E> eVar2 = this.last;
        eVar.f28373b = eVar2;
        this.last = eVar;
        if (this.first == null) {
            this.first = eVar;
        } else {
            eVar2.f28374c = eVar;
        }
        this.count = i11 + 1;
        this.notEmpty.signal();
        return true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }

    private E unlinkFirst() {
        e<E> eVar = this.first;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f28374c;
        E e11 = eVar.f28372a;
        eVar.f28372a = null;
        eVar.f28374c = eVar;
        this.first = eVar2;
        if (eVar2 == null) {
            this.last = null;
        } else {
            eVar2.f28373b = null;
        }
        this.count--;
        this.notFull.signal();
        return e11;
    }

    private E unlinkLast() {
        e<E> eVar = this.last;
        if (eVar == null) {
            return null;
        }
        e<E> eVar2 = eVar.f28373b;
        E e11 = eVar.f28372a;
        eVar.f28372a = null;
        eVar.f28373b = eVar;
        this.last = eVar2;
        if (eVar2 == null) {
            this.first = null;
        } else {
            eVar2.f28374c = null;
        }
        this.count--;
        this.notFull.signal();
        return e11;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f28374c) {
                objectOutputStream.writeObject(eVar.f28372a);
            }
            objectOutputStream.writeObject((Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean add(E e11) {
        addLast(e11);
        return true;
    }

    public void addFirst(E e11) {
        if (!offerFirst(e11)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e11) {
        if (!offerLast(e11)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            while (eVar != null) {
                eVar.f28372a = null;
                e<E> eVar2 = eVar.f28374c;
                eVar.f28373b = null;
                eVar.f28374c = null;
                eVar = eVar2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f28374c) {
                if (obj.equals(eVar.f28372a)) {
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> descendingIterator() {
        return new c();
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public E element() {
        return getFirst();
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    public Iterator<E> iterator() {
        return new d();
    }

    public boolean offer(E e11) {
        return offerLast(e11);
    }

    public boolean offerFirst(E e11) {
        Objects.requireNonNull(e11);
        e eVar = new e(e11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkFirst(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public boolean offerLast(E e11) {
        Objects.requireNonNull(e11);
        e eVar = new e(e11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return linkLast(eVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peek() {
        return peekFirst();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            return eVar == null ? null : eVar.f28372a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.last;
            return eVar == null ? null : eVar.f28372a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E poll() {
        return pollFirst();
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pop() {
        return removeFirst();
    }

    public void push(E e11) {
        addFirst(e11);
    }

    public void put(E e11) throws InterruptedException {
        putLast(e11);
    }

    public void putFirst(E e11) throws InterruptedException {
        Objects.requireNonNull(e11);
        e eVar = new e(e11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkFirst(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public void putLast(E e11) throws InterruptedException {
        Objects.requireNonNull(e11);
        e eVar = new e(e11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (!linkLast(eVar)) {
            try {
                this.notFull.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E remove() {
        return removeFirst();
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.first; eVar != null; eVar = eVar.f28374c) {
                if (obj.equals(eVar.f28372a)) {
                    unlink(eVar);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (e<E> eVar = this.last; eVar != null; eVar = eVar.f28373b) {
                if (obj.equals(eVar.f28372a)) {
                    unlink(eVar);
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i11 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                int i12 = i11 + 1;
                objArr[i11] = eVar.f28372a;
                eVar = eVar.f28374c;
                i11 = i12;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            e<E> eVar = this.first;
            if (eVar == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            while (true) {
                E e11 = eVar.f28372a;
                if (e11 == this) {
                    e11 = "(this Collection)";
                }
                sb2.append(e11);
                eVar = eVar.f28374c;
                if (eVar == null) {
                    sb2.append(']');
                    String sb3 = sb2.toString();
                    reentrantLock.unlock();
                    return sb3;
                }
                sb2.append(',');
                sb2.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void unlink(e<E> eVar) {
        e<E> eVar2 = eVar.f28373b;
        e<E> eVar3 = eVar.f28374c;
        if (eVar2 == null) {
            unlinkFirst();
        } else if (eVar3 == null) {
            unlinkLast();
        } else {
            eVar2.f28374c = eVar3;
            eVar3.f28373b = eVar2;
            eVar.f28372a = null;
            this.count--;
            this.notFull.signal();
        }
    }

    public LinkedBlockingDeque(int i11) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.notEmpty = reentrantLock.newCondition();
        this.notFull = reentrantLock.newCondition();
        if (i11 > 0) {
            this.capacity = i11;
            return;
        }
        throw new IllegalArgumentException();
    }

    public int drainTo(Collection<? super E> collection, int i11) {
        Objects.requireNonNull(collection);
        if (collection != this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int min = Math.min(i11, this.count);
                for (int i12 = 0; i12 < min; i12++) {
                    collection.add(this.first.f28372a);
                    unlinkFirst();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean offer(E e11, long j11, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e11, j11, timeUnit);
    }

    public E poll(long j11, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j11, timeUnit);
    }

    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public E pollFirst(long j11, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    reentrantLock.unlock();
                    return unlinkFirst;
                } else if (nanos <= 0) {
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E pollLast(long j11, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    reentrantLock.unlock();
                    return unlinkLast;
                } else if (nanos <= 0) {
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public boolean offerFirst(E e11, long j11, TimeUnit timeUnit) throws InterruptedException {
        boolean z11;
        Objects.requireNonNull(e11);
        e eVar = new e(e11);
        long nanos = timeUnit.toNanos(j11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkFirst(eVar)) {
                    z11 = true;
                    break;
                } else if (nanos <= 0) {
                    z11 = false;
                    break;
                } else {
                    nanos = this.notFull.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z11;
    }

    public boolean offerLast(E e11, long j11, TimeUnit timeUnit) throws InterruptedException {
        boolean z11;
        Objects.requireNonNull(e11);
        e eVar = new e(e11);
        long nanos = timeUnit.toNanos(j11);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                if (linkLast(eVar)) {
                    z11 = true;
                    break;
                } else if (nanos <= 0) {
                    z11 = false;
                    break;
                } else {
                    nanos = this.notFull.awaitNanos(nanos);
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        return z11;
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (!linkLast(new e(next))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int length = tArr.length;
            T[] tArr2 = tArr;
            if (length < this.count) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count);
            }
            int i11 = 0;
            e<E> eVar = this.first;
            while (eVar != null) {
                tArr2[i11] = eVar.f28372a;
                eVar = eVar.f28374c;
                i11++;
            }
            if (tArr2.length > i11) {
                tArr2[i11] = null;
            }
            return tArr2;
        } finally {
            reentrantLock.unlock();
        }
    }
}
