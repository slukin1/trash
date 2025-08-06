package org.greenrobot.greendao.identityscope;

public interface IdentityScope<K, T> {
    void clear();

    boolean detach(K k11, T t11);

    T get(K k11);

    T getNoLock(K k11);

    void lock();

    void put(K k11, T t11);

    void putNoLock(K k11, T t11);

    void remove(Iterable<K> iterable);

    void remove(K k11);

    void reserveRoom(int i11);

    void unlock();
}
