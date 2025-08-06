package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.MapMaker;
import com.google.common.math.IntMath;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@GwtIncompatible
@Beta
public abstract class Striped<L> {
    private static final int ALL_SET = -1;
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier<ReadWriteLock> READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() {
        public ReadWriteLock get() {
            return new ReentrantReadWriteLock();
        }
    };
    private static final Supplier<ReadWriteLock> WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = new Supplier<ReadWriteLock>() {
        public ReadWriteLock get() {
            return new WeakSafeReadWriteLock();
        }
    };

    public static class CompactStriped<L> extends PowerOfTwoStriped<L> {
        private final Object[] array;

        public L getAt(int i11) {
            return this.array[i11];
        }

        public int size() {
            return this.array.length;
        }

        private CompactStriped(int i11, Supplier<L> supplier) {
            super(i11);
            int i12 = 0;
            Preconditions.checkArgument(i11 <= 1073741824, "Stripes must be <= 2^30)");
            this.array = new Object[(this.mask + 1)];
            while (true) {
                Object[] objArr = this.array;
                if (i12 < objArr.length) {
                    objArr[i12] = supplier.get();
                    i12++;
                } else {
                    return;
                }
            }
        }
    }

    @VisibleForTesting
    public static class LargeLazyStriped<L> extends PowerOfTwoStriped<L> {
        public final ConcurrentMap<Integer, L> locks;
        public final int size;
        public final Supplier<L> supplier;

        public LargeLazyStriped(int i11, Supplier<L> supplier2) {
            super(i11);
            int i12 = this.mask;
            this.size = i12 == -1 ? Integer.MAX_VALUE : i12 + 1;
            this.supplier = supplier2;
            this.locks = new MapMaker().weakValues().makeMap();
        }

        public L getAt(int i11) {
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i11, size());
            }
            L l11 = this.locks.get(Integer.valueOf(i11));
            if (l11 != null) {
                return l11;
            }
            L l12 = this.supplier.get();
            return MoreObjects.firstNonNull(this.locks.putIfAbsent(Integer.valueOf(i11), l12), l12);
        }

        public int size() {
            return this.size;
        }
    }

    public static class PaddedLock extends ReentrantLock {
        public long unused1;
        public long unused2;
        public long unused3;

        public PaddedLock() {
            super(false);
        }
    }

    public static class PaddedSemaphore extends Semaphore {
        public long unused1;
        public long unused2;
        public long unused3;

        public PaddedSemaphore(int i11) {
            super(i11, false);
        }
    }

    public static abstract class PowerOfTwoStriped<L> extends Striped<L> {
        public final int mask;

        public PowerOfTwoStriped(int i11) {
            super();
            int i12;
            Preconditions.checkArgument(i11 > 0, "Stripes must be positive");
            if (i11 > 1073741824) {
                i12 = -1;
            } else {
                i12 = Striped.ceilToPowerOfTwo(i11) - 1;
            }
            this.mask = i12;
        }

        public final L get(Object obj) {
            return getAt(indexFor(obj));
        }

        public final int indexFor(Object obj) {
            return Striped.smear(obj.hashCode()) & this.mask;
        }
    }

    @VisibleForTesting
    public static class SmallLazyStriped<L> extends PowerOfTwoStriped<L> {
        public final AtomicReferenceArray<ArrayReference<? extends L>> locks;
        public final ReferenceQueue<L> queue = new ReferenceQueue<>();
        public final int size;
        public final Supplier<L> supplier;

        public static final class ArrayReference<L> extends WeakReference<L> {
            public final int index;

            public ArrayReference(L l11, int i11, ReferenceQueue<L> referenceQueue) {
                super(l11, referenceQueue);
                this.index = i11;
            }
        }

        public SmallLazyStriped(int i11, Supplier<L> supplier2) {
            super(i11);
            int i12 = this.mask;
            int i13 = i12 == -1 ? Integer.MAX_VALUE : i12 + 1;
            this.size = i13;
            this.locks = new AtomicReferenceArray<>(i13);
            this.supplier = supplier2;
        }

        private void drainQueue() {
            while (true) {
                Reference<? extends L> poll = this.queue.poll();
                if (poll != null) {
                    ArrayReference arrayReference = (ArrayReference) poll;
                    this.locks.compareAndSet(arrayReference.index, arrayReference, (Object) null);
                } else {
                    return;
                }
            }
        }

        public L getAt(int i11) {
            L l11;
            L l12;
            if (this.size != Integer.MAX_VALUE) {
                Preconditions.checkElementIndex(i11, size());
            }
            ArrayReference arrayReference = this.locks.get(i11);
            if (arrayReference == null) {
                l11 = null;
            } else {
                l11 = arrayReference.get();
            }
            if (l11 != null) {
                return l11;
            }
            L l13 = this.supplier.get();
            ArrayReference arrayReference2 = new ArrayReference(l13, i11, this.queue);
            while (!this.locks.compareAndSet(i11, arrayReference, arrayReference2)) {
                arrayReference = this.locks.get(i11);
                if (arrayReference == null) {
                    l12 = null;
                    continue;
                } else {
                    l12 = arrayReference.get();
                    continue;
                }
                if (l12 != null) {
                    return l12;
                }
            }
            drainQueue();
            return l13;
        }

        public int size() {
            return this.size;
        }
    }

    public static final class WeakSafeCondition extends ForwardingCondition {
        private final Condition delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeCondition(Condition condition, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = condition;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Condition delegate() {
            return this.delegate;
        }
    }

    public static final class WeakSafeLock extends ForwardingLock {
        private final Lock delegate;
        private final WeakSafeReadWriteLock strongReference;

        public WeakSafeLock(Lock lock, WeakSafeReadWriteLock weakSafeReadWriteLock) {
            this.delegate = lock;
            this.strongReference = weakSafeReadWriteLock;
        }

        public Lock delegate() {
            return this.delegate;
        }

        public Condition newCondition() {
            return new WeakSafeCondition(this.delegate.newCondition(), this.strongReference);
        }
    }

    public static final class WeakSafeReadWriteLock implements ReadWriteLock {
        private final ReadWriteLock delegate = new ReentrantReadWriteLock();

        public Lock readLock() {
            return new WeakSafeLock(this.delegate.readLock(), this);
        }

        public Lock writeLock() {
            return new WeakSafeLock(this.delegate.writeLock(), this);
        }
    }

    /* access modifiers changed from: private */
    public static int ceilToPowerOfTwo(int i11) {
        return 1 << IntMath.log2(i11, RoundingMode.CEILING);
    }

    public static <L> Striped<L> custom(int i11, Supplier<L> supplier) {
        return new CompactStriped(i11, supplier);
    }

    private static <L> Striped<L> lazy(int i11, Supplier<L> supplier) {
        return i11 < 1024 ? new SmallLazyStriped(i11, supplier) : new LargeLazyStriped(i11, supplier);
    }

    public static Striped<Lock> lazyWeakLock(int i11) {
        return lazy(i11, new Supplier<Lock>() {
            public Lock get() {
                return new ReentrantLock(false);
            }
        });
    }

    public static Striped<ReadWriteLock> lazyWeakReadWriteLock(int i11) {
        return lazy(i11, WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> lazyWeakSemaphore(int i11, final int i12) {
        return lazy(i11, new Supplier<Semaphore>() {
            public Semaphore get() {
                return new Semaphore(i12, false);
            }
        });
    }

    public static Striped<Lock> lock(int i11) {
        return custom(i11, new Supplier<Lock>() {
            public Lock get() {
                return new PaddedLock();
            }
        });
    }

    public static Striped<ReadWriteLock> readWriteLock(int i11) {
        return custom(i11, READ_WRITE_LOCK_SUPPLIER);
    }

    public static Striped<Semaphore> semaphore(int i11, final int i12) {
        return custom(i11, new Supplier<Semaphore>() {
            public Semaphore get() {
                return new PaddedSemaphore(i12);
            }
        });
    }

    /* access modifiers changed from: private */
    public static int smear(int i11) {
        int i12 = i11 ^ ((i11 >>> 20) ^ (i11 >>> 12));
        return (i12 >>> 4) ^ ((i12 >>> 7) ^ i12);
    }

    public Iterable<L> bulkGet(Iterable<?> iterable) {
        Object[] array = Iterables.toArray(iterable, Object.class);
        if (array.length == 0) {
            return ImmutableList.of();
        }
        int[] iArr = new int[array.length];
        for (int i11 = 0; i11 < array.length; i11++) {
            iArr[i11] = indexFor(array[i11]);
        }
        Arrays.sort(iArr);
        int i12 = iArr[0];
        array[0] = getAt(i12);
        for (int i13 = 1; i13 < array.length; i13++) {
            int i14 = iArr[i13];
            if (i14 == i12) {
                array[i13] = array[i13 - 1];
            } else {
                array[i13] = getAt(i14);
                i12 = i14;
            }
        }
        return Collections.unmodifiableList(Arrays.asList(array));
    }

    public abstract L get(Object obj);

    public abstract L getAt(int i11);

    public abstract int indexFor(Object obj);

    public abstract int size();

    private Striped() {
    }
}
