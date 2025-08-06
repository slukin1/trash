package com.google.common.util.concurrent;

import androidx.concurrent.futures.a;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Sets;
import com.google.j2objc.annotations.ReflectionSupport;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtCompatible(emulated = true)
@ReflectionSupport(ReflectionSupport.Level.FULL)
abstract class AggregateFutureState {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log;
    /* access modifiers changed from: private */
    public volatile int remaining;
    /* access modifiers changed from: private */
    public volatile Set<Throwable> seenExceptions = null;

    public static abstract class AtomicHelper {
        private AtomicHelper() {
        }

        public abstract void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2);

        public abstract int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState);
    }

    public static final class SafeAtomicHelper extends AtomicHelper {
        public final AtomicIntegerFieldUpdater<AggregateFutureState> remainingCountUpdater;
        public final AtomicReferenceFieldUpdater<AggregateFutureState, Set<Throwable>> seenExceptionsUpdater;

        public SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            a.a(this.seenExceptionsUpdater, aggregateFutureState, set, set2);
        }

        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    public static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        public void compareAndSetSeenExceptions(AggregateFutureState aggregateFutureState, Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.seenExceptions == set) {
                    Set unused = aggregateFutureState.seenExceptions = set2;
                }
            }
        }

        public int decrementAndGetRemainingCount(AggregateFutureState aggregateFutureState) {
            int access$300;
            synchronized (aggregateFutureState) {
                AggregateFutureState.access$310(aggregateFutureState);
                access$300 = aggregateFutureState.remaining;
            }
            return access$300;
        }
    }

    static {
        AtomicHelper atomicHelper;
        Class<AggregateFutureState> cls = AggregateFutureState.class;
        log = Logger.getLogger(cls.getName());
        Throwable th2 = null;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
        } catch (Throwable th3) {
            atomicHelper = new SynchronizedAtomicHelper();
            th2 = th3;
        }
        ATOMIC_HELPER = atomicHelper;
        if (th2 != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
        }
    }

    public AggregateFutureState(int i11) {
        this.remaining = i11;
    }

    public static /* synthetic */ int access$310(AggregateFutureState aggregateFutureState) {
        int i11 = aggregateFutureState.remaining;
        aggregateFutureState.remaining = i11 - 1;
        return i11;
    }

    public abstract void addInitialException(Set<Throwable> set);

    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newConcurrentHashSet = Sets.newConcurrentHashSet();
        addInitialException(newConcurrentHashSet);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, (Set<Throwable>) null, newConcurrentHashSet);
        return this.seenExceptions;
    }
}
