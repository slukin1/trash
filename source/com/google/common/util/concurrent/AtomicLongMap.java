package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@GwtCompatible
public final class AtomicLongMap<K> implements Serializable {
    private transient Map<K, Long> asMap;
    private final ConcurrentHashMap<K, AtomicLong> map;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.map = (ConcurrentHashMap) Preconditions.checkNotNull(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> create() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    private Map<K, Long> createAsMap() {
        return Collections.unmodifiableMap(Maps.transformValues(this.map, new Function<AtomicLong, Long>() {
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    @CanIgnoreReturnValue
    public long addAndGet(K k11, long j11) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k11);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k11, new AtomicLong(j11))) == null) {
                return j11;
            }
            while (true) {
                long j12 = atomicLong.get();
                if (j12 != 0) {
                    long j13 = j12 + j11;
                    if (atomicLong.compareAndSet(j12, j13)) {
                        return j13;
                    }
                }
            }
        } while (!this.map.replace(k11, atomicLong, new AtomicLong(j11)));
        return j11;
    }

    public Map<K, Long> asMap() {
        Map<K, Long> map2 = this.asMap;
        if (map2 != null) {
            return map2;
        }
        Map<K, Long> createAsMap = createAsMap();
        this.asMap = createAsMap;
        return createAsMap;
    }

    public void clear() {
        this.map.clear();
    }

    public boolean containsKey(Object obj) {
        return this.map.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long decrementAndGet(K k11) {
        return addAndGet(k11, -1);
    }

    public long get(K k11) {
        AtomicLong atomicLong = this.map.get(k11);
        if (atomicLong == null) {
            return 0;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long getAndAdd(K k11, long j11) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k11);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k11, new AtomicLong(j11))) == null) {
                return 0;
            }
            while (true) {
                long j12 = atomicLong.get();
                if (j12 != 0) {
                    if (atomicLong.compareAndSet(j12, j12 + j11)) {
                        return j12;
                    }
                }
            }
        } while (!this.map.replace(k11, atomicLong, new AtomicLong(j11)));
        return 0;
    }

    @CanIgnoreReturnValue
    public long getAndDecrement(K k11) {
        return getAndAdd(k11, -1);
    }

    @CanIgnoreReturnValue
    public long getAndIncrement(K k11) {
        return getAndAdd(k11, 1);
    }

    @CanIgnoreReturnValue
    public long incrementAndGet(K k11) {
        return addAndGet(k11, 1);
    }

    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @CanIgnoreReturnValue
    public long put(K k11, long j11) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k11);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k11, new AtomicLong(j11))) == null) {
                return 0;
            }
            while (true) {
                long j12 = atomicLong.get();
                if (j12 != 0) {
                    if (atomicLong.compareAndSet(j12, j11)) {
                        return j12;
                    }
                }
            }
        } while (!this.map.replace(k11, atomicLong, new AtomicLong(j11)));
        return 0;
    }

    public void putAll(Map<? extends K, ? extends Long> map2) {
        for (Map.Entry next : map2.entrySet()) {
            put(next.getKey(), ((Long) next.getValue()).longValue());
        }
    }

    public long putIfAbsent(K k11, long j11) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.map.get(k11);
            if (atomicLong == null && (atomicLong = this.map.putIfAbsent(k11, new AtomicLong(j11))) == null) {
                return 0;
            }
            long j12 = atomicLong.get();
            if (j12 != 0) {
                return j12;
            }
        } while (!this.map.replace(k11, atomicLong, new AtomicLong(j11)));
        return 0;
    }

    @CanIgnoreReturnValue
    public long remove(K k11) {
        long j11;
        AtomicLong atomicLong = this.map.get(k11);
        if (atomicLong == null) {
            return 0;
        }
        do {
            j11 = atomicLong.get();
            if (j11 == 0 || atomicLong.compareAndSet(j11, 0)) {
                this.map.remove(k11, atomicLong);
            }
            j11 = atomicLong.get();
            break;
        } while (atomicLong.compareAndSet(j11, 0));
        this.map.remove(k11, atomicLong);
        return j11;
    }

    public void removeAllZeros() {
        Iterator<Map.Entry<K, AtomicLong>> it2 = this.map.entrySet().iterator();
        while (it2.hasNext()) {
            AtomicLong atomicLong = (AtomicLong) it2.next().getValue();
            if (atomicLong != null && atomicLong.get() == 0) {
                it2.remove();
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public boolean removeIfZero(K k11) {
        return remove(k11, 0);
    }

    public boolean replace(K k11, long j11, long j12) {
        if (j11 == 0) {
            return putIfAbsent(k11, j12) == 0;
        }
        AtomicLong atomicLong = this.map.get(k11);
        if (atomicLong == null) {
            return false;
        }
        return atomicLong.compareAndSet(j11, j12);
    }

    public int size() {
        return this.map.size();
    }

    public long sum() {
        long j11 = 0;
        for (AtomicLong atomicLong : this.map.values()) {
            j11 += atomicLong.get();
        }
        return j11;
    }

    public String toString() {
        return this.map.toString();
    }

    public static <K> AtomicLongMap<K> create(Map<? extends K, ? extends Long> map2) {
        AtomicLongMap<K> create = create();
        create.putAll(map2);
        return create;
    }

    public boolean remove(K k11, long j11) {
        AtomicLong atomicLong = this.map.get(k11);
        if (atomicLong == null) {
            return false;
        }
        long j12 = atomicLong.get();
        if (j12 != j11) {
            return false;
        }
        if (j12 != 0 && !atomicLong.compareAndSet(j12, 0)) {
            return false;
        }
        this.map.remove(k11, atomicLong);
        return true;
    }
}
