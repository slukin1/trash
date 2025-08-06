package org.greenrobot.greendao.identityscope;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class IdentityScopeObject<K, T> implements IdentityScope<K, T> {
    private final ReentrantLock lock = new ReentrantLock();
    private final HashMap<K, Reference<T>> map = new HashMap<>();

    public void clear() {
        this.lock.lock();
        try {
            this.map.clear();
        } finally {
            this.lock.unlock();
        }
    }

    public boolean detach(K k11, T t11) {
        boolean z11;
        this.lock.lock();
        try {
            if (get(k11) != t11 || t11 == null) {
                z11 = false;
            } else {
                remove(k11);
                z11 = true;
            }
            return z11;
        } finally {
            this.lock.unlock();
        }
    }

    public T get(K k11) {
        this.lock.lock();
        try {
            Reference reference = this.map.get(k11);
            if (reference != null) {
                return reference.get();
            }
            return null;
        } finally {
            this.lock.unlock();
        }
    }

    public T getNoLock(K k11) {
        Reference reference = this.map.get(k11);
        if (reference != null) {
            return reference.get();
        }
        return null;
    }

    public void lock() {
        this.lock.lock();
    }

    public void put(K k11, T t11) {
        this.lock.lock();
        try {
            this.map.put(k11, new WeakReference(t11));
        } finally {
            this.lock.unlock();
        }
    }

    public void putNoLock(K k11, T t11) {
        this.map.put(k11, new WeakReference(t11));
    }

    public void remove(K k11) {
        this.lock.lock();
        try {
            this.map.remove(k11);
        } finally {
            this.lock.unlock();
        }
    }

    public void reserveRoom(int i11) {
    }

    public void unlock() {
        this.lock.unlock();
    }

    public void remove(Iterable<K> iterable) {
        this.lock.lock();
        try {
            for (K remove : iterable) {
                this.map.remove(remove);
            }
        } finally {
            this.lock.unlock();
        }
    }
}
