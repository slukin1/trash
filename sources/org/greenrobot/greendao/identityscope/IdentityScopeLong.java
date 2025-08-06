package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.internal.LongHashMap;

public class IdentityScopeLong<T> implements IdentityScope<Long, T> {
    private final ReentrantLock lock = new ReentrantLock();
    private final LongHashMap<Reference<T>> map = new LongHashMap<>();

    public void clear() {
        this.lock.lock();
        try {
            this.map.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public T get2(long j11) {
        this.lock.lock();
        try {
            Reference reference = this.map.get(j11);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.lock.unlock();
        }
    }

    public T get2NoLock(long j11) {
        Reference reference = this.map.get(j11);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public void lock() {
        this.lock.lock();
    }

    public void put2(long j11, T t11) {
        this.lock.lock();
        try {
            this.map.put(j11, new WeakReference(t11));
        } finally {
            this.lock.unlock();
        }
    }

    public void put2NoLock(long j11, T t11) {
        this.map.put(j11, new WeakReference(t11));
    }

    public void reserveRoom(int i11) {
        this.map.reserveRoom(i11);
    }

    public void unlock() {
        this.lock.unlock();
    }

    public boolean detach(Long l11, T t11) {
        boolean z11;
        this.lock.lock();
        try {
            if (get(l11) != t11 || t11 == null) {
                z11 = false;
            } else {
                remove(l11);
                z11 = true;
            }
            return z11;
        } finally {
            this.lock.unlock();
        }
    }

    public T get(Long l11) {
        return get2(l11.longValue());
    }

    public T getNoLock(Long l11) {
        return get2NoLock(l11.longValue());
    }

    public void put(Long l11, T t11) {
        put2(l11.longValue(), t11);
    }

    public void putNoLock(Long l11, T t11) {
        put2NoLock(l11.longValue(), t11);
    }

    public void remove(Long l11) {
        this.lock.lock();
        try {
            this.map.remove(l11.longValue());
        } finally {
            this.lock.unlock();
        }
    }

    public void remove(Iterable<Long> iterable) {
        this.lock.lock();
        try {
            for (Long longValue : iterable) {
                this.map.remove(longValue.longValue());
            }
        } finally {
            this.lock.unlock();
        }
    }
}
