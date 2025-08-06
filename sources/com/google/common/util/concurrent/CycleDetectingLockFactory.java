package com.google.common.util.concurrent;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.MapMaker;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@CanIgnoreReturnValue
@Beta
public class CycleDetectingLockFactory {
    private static final ThreadLocal<ArrayList<LockGraphNode>> acquiredLocks = new ThreadLocal<ArrayList<LockGraphNode>>() {
        public ArrayList<LockGraphNode> initialValue() {
            return Lists.newArrayListWithCapacity(3);
        }
    };
    private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, LockGraphNode>> lockGraphNodesPerType = new MapMaker().weakKeys().makeMap();
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(CycleDetectingLockFactory.class.getName());
    public final Policy policy;

    public interface CycleDetectingLock {
        LockGraphNode getLockGraphNode();

        boolean isAcquiredByCurrentThread();
    }

    public final class CycleDetectingReentrantLock extends ReentrantLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;

        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        public boolean isAcquiredByCurrentThread() {
            return isHeldByCurrentThread();
        }

        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }

        private CycleDetectingReentrantLock(LockGraphNode lockGraphNode2, boolean z11) {
            super(z11);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(lockGraphNode2);
        }

        public boolean tryLock(long j11, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this);
            try {
                return super.tryLock(j11, timeUnit);
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this);
            }
        }
    }

    public final class CycleDetectingReentrantReadWriteLock extends ReentrantReadWriteLock implements CycleDetectingLock {
        private final LockGraphNode lockGraphNode;
        private final CycleDetectingReentrantReadLock readLock;
        private final CycleDetectingReentrantWriteLock writeLock;

        public LockGraphNode getLockGraphNode() {
            return this.lockGraphNode;
        }

        public boolean isAcquiredByCurrentThread() {
            return isWriteLockedByCurrentThread() || getReadHoldCount() > 0;
        }

        private CycleDetectingReentrantReadWriteLock(LockGraphNode lockGraphNode2, boolean z11) {
            super(z11);
            this.readLock = new CycleDetectingReentrantReadLock(this);
            this.writeLock = new CycleDetectingReentrantWriteLock(this);
            this.lockGraphNode = (LockGraphNode) Preconditions.checkNotNull(lockGraphNode2);
        }

        public ReentrantReadWriteLock.ReadLock readLock() {
            return this.readLock;
        }

        public ReentrantReadWriteLock.WriteLock writeLock() {
            return this.writeLock;
        }
    }

    public static class ExampleStackTrace extends IllegalStateException {
        public static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
        public static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), ExampleStackTrace.class.getName(), LockGraphNode.class.getName());

        public ExampleStackTrace(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2) {
            super(lockGraphNode.getLockName() + " -> " + lockGraphNode2.getLockName());
            StackTraceElement[] stackTrace = getStackTrace();
            int length = stackTrace.length;
            int i11 = 0;
            while (i11 < length) {
                if (WithExplicitOrdering.class.getName().equals(stackTrace[i11].getClassName())) {
                    setStackTrace(EMPTY_STACK_TRACE);
                    return;
                } else if (!EXCLUDED_CLASS_NAMES.contains(stackTrace[i11].getClassName())) {
                    setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i11, length));
                    return;
                } else {
                    i11++;
                }
            }
        }
    }

    public static class LockGraphNode {
        public final Map<LockGraphNode, ExampleStackTrace> allowedPriorLocks = new MapMaker().weakKeys().makeMap();
        public final Map<LockGraphNode, PotentialDeadlockException> disallowedPriorLocks = new MapMaker().weakKeys().makeMap();
        public final String lockName;

        public LockGraphNode(String str) {
            this.lockName = (String) Preconditions.checkNotNull(str);
        }

        private ExampleStackTrace findPathTo(LockGraphNode lockGraphNode, Set<LockGraphNode> set) {
            if (!set.add(this)) {
                return null;
            }
            ExampleStackTrace exampleStackTrace = this.allowedPriorLocks.get(lockGraphNode);
            if (exampleStackTrace != null) {
                return exampleStackTrace;
            }
            for (Map.Entry next : this.allowedPriorLocks.entrySet()) {
                LockGraphNode lockGraphNode2 = (LockGraphNode) next.getKey();
                ExampleStackTrace findPathTo = lockGraphNode2.findPathTo(lockGraphNode, set);
                if (findPathTo != null) {
                    ExampleStackTrace exampleStackTrace2 = new ExampleStackTrace(lockGraphNode2, this);
                    exampleStackTrace2.setStackTrace(((ExampleStackTrace) next.getValue()).getStackTrace());
                    exampleStackTrace2.initCause(findPathTo);
                    return exampleStackTrace2;
                }
            }
            return null;
        }

        public void checkAcquiredLock(Policy policy, LockGraphNode lockGraphNode) {
            Preconditions.checkState(this != lockGraphNode, "Attempted to acquire multiple locks with the same rank %s", (Object) lockGraphNode.getLockName());
            if (!this.allowedPriorLocks.containsKey(lockGraphNode)) {
                PotentialDeadlockException potentialDeadlockException = this.disallowedPriorLocks.get(lockGraphNode);
                if (potentialDeadlockException != null) {
                    policy.handlePotentialDeadlock(new PotentialDeadlockException(lockGraphNode, this, potentialDeadlockException.getConflictingStackTrace()));
                    return;
                }
                ExampleStackTrace findPathTo = lockGraphNode.findPathTo(this, Sets.newIdentityHashSet());
                if (findPathTo == null) {
                    this.allowedPriorLocks.put(lockGraphNode, new ExampleStackTrace(lockGraphNode, this));
                    return;
                }
                PotentialDeadlockException potentialDeadlockException2 = new PotentialDeadlockException(lockGraphNode, this, findPathTo);
                this.disallowedPriorLocks.put(lockGraphNode, potentialDeadlockException2);
                policy.handlePotentialDeadlock(potentialDeadlockException2);
            }
        }

        public void checkAcquiredLocks(Policy policy, List<LockGraphNode> list) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                checkAcquiredLock(policy, list.get(i11));
            }
        }

        public String getLockName() {
            return this.lockName;
        }
    }

    @Beta
    public enum Policies implements Policy {
        THROW {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                throw potentialDeadlockException;
            }
        },
        WARN {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
                CycleDetectingLockFactory.logger.log(Level.SEVERE, "Detected potential deadlock", potentialDeadlockException);
            }
        },
        DISABLED {
            public void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException) {
            }
        }
    }

    @Beta
    public interface Policy {
        void handlePotentialDeadlock(PotentialDeadlockException potentialDeadlockException);
    }

    @Beta
    public static final class PotentialDeadlockException extends ExampleStackTrace {
        private final ExampleStackTrace conflictingStackTrace;

        public ExampleStackTrace getConflictingStackTrace() {
            return this.conflictingStackTrace;
        }

        public String getMessage() {
            StringBuilder sb2 = new StringBuilder(super.getMessage());
            for (Throwable th2 = this.conflictingStackTrace; th2 != null; th2 = th2.getCause()) {
                sb2.append(", ");
                sb2.append(th2.getMessage());
            }
            return sb2.toString();
        }

        private PotentialDeadlockException(LockGraphNode lockGraphNode, LockGraphNode lockGraphNode2, ExampleStackTrace exampleStackTrace) {
            super(lockGraphNode, lockGraphNode2);
            this.conflictingStackTrace = exampleStackTrace;
            initCause(exampleStackTrace);
        }
    }

    @Beta
    public static final class WithExplicitOrdering<E extends Enum<E>> extends CycleDetectingLockFactory {
        private final Map<E, LockGraphNode> lockGraphNodes;

        @VisibleForTesting
        public WithExplicitOrdering(Policy policy, Map<E, LockGraphNode> map) {
            super(policy);
            this.lockGraphNodes = map;
        }

        public ReentrantLock newReentrantLock(E e11) {
            return newReentrantLock(e11, false);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e11) {
            return newReentrantReadWriteLock(e11, false);
        }

        public ReentrantLock newReentrantLock(E e11, boolean z11) {
            if (this.policy == Policies.DISABLED) {
                return new ReentrantLock(z11);
            }
            return new CycleDetectingReentrantLock(this.lockGraphNodes.get(e11), z11);
        }

        public ReentrantReadWriteLock newReentrantReadWriteLock(E e11, boolean z11) {
            if (this.policy == Policies.DISABLED) {
                return new ReentrantReadWriteLock(z11);
            }
            return new CycleDetectingReentrantReadWriteLock(this.lockGraphNodes.get(e11), z11);
        }
    }

    /* access modifiers changed from: private */
    public void aboutToAcquire(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            ArrayList arrayList = acquiredLocks.get();
            LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            lockGraphNode.checkAcquiredLocks(this.policy, arrayList);
            arrayList.add(lockGraphNode);
        }
    }

    @VisibleForTesting
    public static <E extends Enum<E>> Map<E, LockGraphNode> createNodes(Class<E> cls) {
        EnumMap<K, V> newEnumMap = Maps.newEnumMap(cls);
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        int length = enumArr.length;
        ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(length);
        int i11 = 0;
        for (Enum enumR : enumArr) {
            LockGraphNode lockGraphNode = new LockGraphNode(getLockName(enumR));
            newArrayListWithCapacity.add(lockGraphNode);
            newEnumMap.put(enumR, lockGraphNode);
        }
        for (int i12 = 1; i12 < length; i12++) {
            ((LockGraphNode) newArrayListWithCapacity.get(i12)).checkAcquiredLocks(Policies.THROW, newArrayListWithCapacity.subList(0, i12));
        }
        while (i11 < length - 1) {
            i11++;
            ((LockGraphNode) newArrayListWithCapacity.get(i11)).checkAcquiredLocks(Policies.DISABLED, newArrayListWithCapacity.subList(i11, length));
        }
        return Collections.unmodifiableMap(newEnumMap);
    }

    private static String getLockName(Enum<?> enumR) {
        return enumR.getDeclaringClass().getSimpleName() + InstructionFileId.DOT + enumR.name();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<? extends java.lang.Enum>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map<? extends java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory.LockGraphNode> getOrCreateNodes(java.lang.Class<? extends java.lang.Enum> r2) {
        /*
            java.util.concurrent.ConcurrentMap<java.lang.Class<? extends java.lang.Enum>, java.util.Map<? extends java.lang.Enum, com.google.common.util.concurrent.CycleDetectingLockFactory$LockGraphNode>> r0 = lockGraphNodesPerType
            java.lang.Object r1 = r0.get(r2)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 == 0) goto L_0x000b
            return r1
        L_0x000b:
            java.util.Map r1 = createNodes(r2)
            java.lang.Object r2 = r0.putIfAbsent(r2, r1)
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r2 = com.google.common.base.MoreObjects.firstNonNull(r2, r1)
            java.util.Map r2 = (java.util.Map) r2
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.CycleDetectingLockFactory.getOrCreateNodes(java.lang.Class):java.util.Map");
    }

    /* access modifiers changed from: private */
    public static void lockStateChanged(CycleDetectingLock cycleDetectingLock) {
        if (!cycleDetectingLock.isAcquiredByCurrentThread()) {
            ArrayList arrayList = acquiredLocks.get();
            LockGraphNode lockGraphNode = cycleDetectingLock.getLockGraphNode();
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (arrayList.get(size) == lockGraphNode) {
                    arrayList.remove(size);
                    return;
                }
            }
        }
    }

    public static CycleDetectingLockFactory newInstance(Policy policy2) {
        return new CycleDetectingLockFactory(policy2);
    }

    public static <E extends Enum<E>> WithExplicitOrdering<E> newInstanceWithExplicitOrdering(Class<E> cls, Policy policy2) {
        Preconditions.checkNotNull(cls);
        Preconditions.checkNotNull(policy2);
        return new WithExplicitOrdering<>(policy2, getOrCreateNodes(cls));
    }

    public ReentrantLock newReentrantLock(String str) {
        return newReentrantLock(str, false);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str) {
        return newReentrantReadWriteLock(str, false);
    }

    private CycleDetectingLockFactory(Policy policy2) {
        this.policy = (Policy) Preconditions.checkNotNull(policy2);
    }

    public ReentrantLock newReentrantLock(String str, boolean z11) {
        return this.policy == Policies.DISABLED ? new ReentrantLock(z11) : new CycleDetectingReentrantLock(new LockGraphNode(str), z11);
    }

    public ReentrantReadWriteLock newReentrantReadWriteLock(String str, boolean z11) {
        return this.policy == Policies.DISABLED ? new ReentrantReadWriteLock(z11) : new CycleDetectingReentrantReadWriteLock(new LockGraphNode(str), z11);
    }

    public class CycleDetectingReentrantReadLock extends ReentrantReadWriteLock.ReadLock {
        @Weak
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantReadLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock(long j11, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock(j11, timeUnit);
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }
    }

    public class CycleDetectingReentrantWriteLock extends ReentrantReadWriteLock.WriteLock {
        @Weak
        public final CycleDetectingReentrantReadWriteLock readWriteLock;

        public CycleDetectingReentrantWriteLock(CycleDetectingReentrantReadWriteLock cycleDetectingReentrantReadWriteLock) {
            super(cycleDetectingReentrantReadWriteLock);
            this.readWriteLock = cycleDetectingReentrantReadWriteLock;
        }

        public void lock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void lockInterruptibly() throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                super.lockInterruptibly();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock() {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public void unlock() {
            try {
                super.unlock();
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }

        public boolean tryLock(long j11, TimeUnit timeUnit) throws InterruptedException {
            CycleDetectingLockFactory.this.aboutToAcquire(this.readWriteLock);
            try {
                return super.tryLock(j11, timeUnit);
            } finally {
                CycleDetectingLockFactory.lockStateChanged(this.readWriteLock);
            }
        }
    }
}
