package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Equivalence;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Stopwatch;
import androidx.test.espresso.core.internal.deps.guava.base.Ticker;
import androidx.test.espresso.core.internal.deps.guava.cache.CacheBuilder;
import androidx.test.espresso.core.internal.deps.guava.collect.AbstractSequentialIterator;
import androidx.test.espresso.core.internal.deps.guava.collect.ImmutableSet;
import androidx.test.espresso.core.internal.deps.guava.collect.Iterators;
import androidx.test.espresso.core.internal.deps.guava.primitives.Ints;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Futures;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.MoreExecutors;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.SettableFuture;
import androidx.test.espresso.core.internal.deps.guava.util.concurrent.Uninterruptibles;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* renamed from: x  reason: collision with root package name */
    public static final Logger f11204x = Logger.getLogger(LocalCache.class.getName());

    /* renamed from: y  reason: collision with root package name */
    public static final ValueReference<Object, Object> f11205y = new ValueReference<Object, Object>() {
        public ValueReference<Object, Object> a(ReferenceQueue<Object> referenceQueue, Object obj, ReferenceEntry<Object, Object> referenceEntry) {
            return this;
        }

        public Object get() {
            return null;
        }

        public ReferenceEntry<Object, Object> getEntry() {
            return null;
        }

        public int getWeight() {
            return 0;
        }

        public boolean isActive() {
            return false;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(Object obj) {
        }
    };

    /* renamed from: z  reason: collision with root package name */
    public static final Queue<?> f11206z = new AbstractQueue<Object>() {
        public Iterator<Object> iterator() {
            return ImmutableSet.of().iterator();
        }

        public boolean offer(Object obj) {
            return true;
        }

        public Object peek() {
            return null;
        }

        public Object poll() {
            return null;
        }

        public int size() {
            return 0;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    public final int f11207b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11208c;

    /* renamed from: d  reason: collision with root package name */
    public final Segment<K, V>[] f11209d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11210e;

    /* renamed from: f  reason: collision with root package name */
    public final Equivalence<Object> f11211f;

    /* renamed from: g  reason: collision with root package name */
    public final Equivalence<Object> f11212g;

    /* renamed from: h  reason: collision with root package name */
    public final Strength f11213h;

    /* renamed from: i  reason: collision with root package name */
    public final Strength f11214i;

    /* renamed from: j  reason: collision with root package name */
    public final long f11215j;

    /* renamed from: k  reason: collision with root package name */
    public final Weigher<K, V> f11216k;

    /* renamed from: l  reason: collision with root package name */
    public final long f11217l;

    /* renamed from: m  reason: collision with root package name */
    public final long f11218m;

    /* renamed from: n  reason: collision with root package name */
    public final long f11219n;

    /* renamed from: o  reason: collision with root package name */
    public final Queue<RemovalNotification<K, V>> f11220o;

    /* renamed from: p  reason: collision with root package name */
    public final RemovalListener<K, V> f11221p;

    /* renamed from: q  reason: collision with root package name */
    public final Ticker f11222q;

    /* renamed from: r  reason: collision with root package name */
    public final EntryFactory f11223r;

    /* renamed from: s  reason: collision with root package name */
    public final AbstractCache$StatsCounter f11224s;

    /* renamed from: t  reason: collision with root package name */
    public final CacheLoader<? super K, V> f11225t;

    /* renamed from: u  reason: collision with root package name */
    public Set<K> f11226u;

    /* renamed from: v  reason: collision with root package name */
    public Collection<V> f11227v;

    /* renamed from: w  reason: collision with root package name */
    public Set<Map.Entry<K, V>> f11228w;

    public abstract class AbstractCacheSet<T> extends AbstractSet<T> {

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentMap<?, ?> f11229b;

        public AbstractCacheSet(LocalCache localCache, ConcurrentMap<?, ?> concurrentMap) {
            this.f11229b = concurrentMap;
        }

        public void clear() {
            this.f11229b.clear();
        }

        public boolean isEmpty() {
            return this.f11229b.isEmpty();
        }

        public int size() {
            return this.f11229b.size();
        }

        public Object[] toArray() {
            return LocalCache.E(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.E(this).toArray(eArr);
        }
    }

    public static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            throw new UnsupportedOperationException();
        }

        public K getKey() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNext() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            throw new UnsupportedOperationException();
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j11) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            throw new UnsupportedOperationException();
        }

        public void setWriteTime(long j11) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public final ReferenceEntry<K, V> f11230b = new AbstractReferenceEntry<K, V>(this) {

            /* renamed from: b  reason: collision with root package name */
            public ReferenceEntry<K, V> f11231b = this;

            /* renamed from: c  reason: collision with root package name */
            public ReferenceEntry<K, V> f11232c = this;

            public long getAccessTime() {
                return Long.MAX_VALUE;
            }

            public ReferenceEntry<K, V> getNextInAccessQueue() {
                return this.f11231b;
            }

            public ReferenceEntry<K, V> getPreviousInAccessQueue() {
                return this.f11232c;
            }

            public void setAccessTime(long j11) {
            }

            public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f11231b = referenceEntry;
            }

            public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f11232c = referenceEntry;
            }
        };

        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.c(referenceEntry.getPreviousInAccessQueue(), referenceEntry.getNextInAccessQueue());
            LocalCache.c(this.f11230b.getPreviousInAccessQueue(), referenceEntry);
            LocalCache.c(referenceEntry, this.f11230b);
            return true;
        }

        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInAccessQueue = this.f11230b.getNextInAccessQueue();
            if (nextInAccessQueue == this.f11230b) {
                return null;
            }
            return nextInAccessQueue;
        }

        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInAccessQueue = this.f11230b.getNextInAccessQueue();
            if (nextInAccessQueue == this.f11230b) {
                return null;
            }
            remove(nextInAccessQueue);
            return nextInAccessQueue;
        }

        public void clear() {
            ReferenceEntry<K, V> nextInAccessQueue = this.f11230b.getNextInAccessQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.f11230b;
                if (nextInAccessQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue2 = nextInAccessQueue.getNextInAccessQueue();
                    LocalCache.t(nextInAccessQueue);
                    nextInAccessQueue = nextInAccessQueue2;
                } else {
                    referenceEntry.setNextInAccessQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.f11230b;
                    referenceEntry2.setPreviousInAccessQueue(referenceEntry2);
                    return;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInAccessQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.f11230b.getNextInAccessQueue() == this.f11230b;
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* renamed from: b */
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInAccessQueue = referenceEntry.getNextInAccessQueue();
                    if (nextInAccessQueue == AccessQueue.this.f11230b) {
                        return null;
                    }
                    return nextInAccessQueue;
                }
            };
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInAccessQueue = referenceEntry.getPreviousInAccessQueue();
            ReferenceEntry nextInAccessQueue = referenceEntry.getNextInAccessQueue();
            LocalCache.c(previousInAccessQueue, nextInAccessQueue);
            LocalCache.t(referenceEntry);
            return nextInAccessQueue != NullEntry.INSTANCE;
        }

        public int size() {
            int i11 = 0;
            for (ReferenceEntry<K, V> nextInAccessQueue = this.f11230b.getNextInAccessQueue(); nextInAccessQueue != this.f11230b; nextInAccessQueue = nextInAccessQueue.getNextInAccessQueue()) {
                i11++;
            }
            return i11;
        }
    }

    public enum EntryFactory {
        STRONG {
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new StrongEntry(k11, i11, referenceEntry);
            }
        },
        STRONG_ACCESS {
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessEntry(k11, i11, referenceEntry);
            }
        },
        STRONG_WRITE {
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new StrongWriteEntry(k11, i11, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE {
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new StrongAccessWriteEntry(k11, i11, referenceEntry);
            }
        },
        WEAK {
            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new WeakEntry(segment.keyReferenceQueue, k11, i11, referenceEntry);
            }
        },
        WEAK_ACCESS {
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessEntry(segment.keyReferenceQueue, k11, i11, referenceEntry);
            }
        },
        WEAK_WRITE {
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new WeakWriteEntry(segment.keyReferenceQueue, k11, i11, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE {
            public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = super.copyEntry(segment, referenceEntry, referenceEntry2);
                copyAccessEntry(referenceEntry, copyEntry);
                copyWriteEntry(referenceEntry, copyEntry);
                return copyEntry;
            }

            public <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
                return new WeakAccessWriteEntry(segment.keyReferenceQueue, k11, i11, referenceEntry);
            }
        };
        
        public static final EntryFactory[] factories = null;

        /* access modifiers changed from: public */
        static {
            AnonymousClass1 r02;
            AnonymousClass2 r12;
            AnonymousClass3 r32;
            AnonymousClass4 r52;
            AnonymousClass5 r72;
            AnonymousClass6 r92;
            AnonymousClass7 r11;
            AnonymousClass8 r13;
            factories = new EntryFactory[]{r02, r12, r32, r52, r72, r92, r11, r13};
        }

        public static EntryFactory getFactory(Strength strength, boolean z11, boolean z12) {
            char c11 = 0;
            boolean z13 = (strength == Strength.WEAK ? (char) 4 : 0) | z11;
            if (z12) {
                c11 = 2;
            }
            return factories[z13 | c11];
        }

        public <K, V> void copyAccessEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setAccessTime(referenceEntry.getAccessTime());
            LocalCache.c(referenceEntry.getPreviousInAccessQueue(), referenceEntry2);
            LocalCache.c(referenceEntry2, referenceEntry.getNextInAccessQueue());
            LocalCache.t(referenceEntry);
        }

        public <K, V> ReferenceEntry<K, V> copyEntry(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            return newEntry(segment, referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry2);
        }

        public <K, V> void copyWriteEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            referenceEntry2.setWriteTime(referenceEntry.getWriteTime());
            LocalCache.d(referenceEntry.getPreviousInWriteQueue(), referenceEntry2);
            LocalCache.d(referenceEntry2, referenceEntry.getNextInWriteQueue());
            LocalCache.u(referenceEntry);
        }

        public abstract <K, V> ReferenceEntry<K, V> newEntry(Segment<K, V> segment, K k11, int i11, ReferenceEntry<K, V> referenceEntry);
    }

    public final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
        public EntryIterator(LocalCache localCache) {
            super();
        }

        /* renamed from: f */
        public Map.Entry<K, V> next() {
            return c();
        }
    }

    public final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        public EntrySet(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (java.util.Map.Entry) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean contains(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 != 0) goto L_0x000f
                return r1
            L_0x000f:
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r2 = androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.this
                java.lang.Object r0 = r2.get(r0)
                if (r0 == 0) goto L_0x0026
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r2 = androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.this
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r2 = r2.f11212g
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.equivalent(r4, r0)
                if (r4 == 0) goto L_0x0026
                r1 = 1
            L_0x0026:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntrySet.contains(java.lang.Object):boolean");
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new EntryIterator(LocalCache.this);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
            r4 = (java.util.Map.Entry) r4;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(java.lang.Object r4) {
            /*
                r3 = this;
                boolean r0 = r4 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 != 0) goto L_0x0006
                return r1
            L_0x0006:
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                java.lang.Object r0 = r4.getKey()
                if (r0 == 0) goto L_0x001b
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache r2 = androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.this
                java.lang.Object r4 = r4.getValue()
                boolean r4 = r2.remove(r0, r4)
                if (r4 == 0) goto L_0x001b
                r1 = 1
            L_0x001b:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.EntrySet.remove(java.lang.Object):boolean");
        }
    }

    public abstract class HashIterator<T> implements Iterator<T> {

        /* renamed from: b  reason: collision with root package name */
        public int f11235b;

        /* renamed from: c  reason: collision with root package name */
        public int f11236c = -1;

        /* renamed from: d  reason: collision with root package name */
        public Segment<K, V> f11237d;

        /* renamed from: e  reason: collision with root package name */
        public AtomicReferenceArray<ReferenceEntry<K, V>> f11238e;

        /* renamed from: f  reason: collision with root package name */
        public ReferenceEntry<K, V> f11239f;

        /* renamed from: g  reason: collision with root package name */
        public LocalCache<K, V>.WriteThroughEntry f11240g;

        /* renamed from: h  reason: collision with root package name */
        public LocalCache<K, V>.WriteThroughEntry f11241h;

        public HashIterator() {
            this.f11235b = LocalCache.this.f11209d.length - 1;
            a();
        }

        public final void a() {
            this.f11240g = null;
            if (!d() && !e()) {
                while (true) {
                    int i11 = this.f11235b;
                    if (i11 >= 0) {
                        Segment<K, V>[] segmentArr = LocalCache.this.f11209d;
                        this.f11235b = i11 - 1;
                        Segment<K, V> segment = segmentArr[i11];
                        this.f11237d = segment;
                        if (segment.count != 0) {
                            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f11237d.table;
                            this.f11238e = atomicReferenceArray;
                            this.f11236c = atomicReferenceArray.length() - 1;
                            if (e()) {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        public boolean b(ReferenceEntry<K, V> referenceEntry) {
            boolean z11;
            try {
                long a11 = LocalCache.this.f11222q.a();
                K key = referenceEntry.getKey();
                V n11 = LocalCache.this.n(referenceEntry, a11);
                if (n11 != null) {
                    this.f11240g = new WriteThroughEntry(key, n11);
                    z11 = true;
                } else {
                    z11 = false;
                }
                return z11;
            } finally {
                this.f11237d.postReadCleanup();
            }
        }

        public LocalCache<K, V>.WriteThroughEntry c() {
            LocalCache<K, V>.WriteThroughEntry writeThroughEntry = this.f11240g;
            if (writeThroughEntry != null) {
                this.f11241h = writeThroughEntry;
                a();
                return this.f11241h;
            }
            throw new NoSuchElementException();
        }

        public boolean d() {
            ReferenceEntry<K, V> referenceEntry = this.f11239f;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.f11239f = referenceEntry.getNext();
                ReferenceEntry<K, V> referenceEntry2 = this.f11239f;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.f11239f;
            }
        }

        public boolean e() {
            while (true) {
                int i11 = this.f11236c;
                if (i11 < 0) {
                    return false;
                }
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.f11238e;
                this.f11236c = i11 - 1;
                ReferenceEntry<K, V> referenceEntry = atomicReferenceArray.get(i11);
                this.f11239f = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
                    return true;
                }
            }
        }

        public boolean hasNext() {
            return this.f11240g != null;
        }

        public void remove() {
            Preconditions.o(this.f11241h != null);
            LocalCache.this.remove(this.f11241h.getKey());
            this.f11241h = null;
        }
    }

    public final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        public KeyIterator(LocalCache localCache) {
            super();
        }

        public K next() {
            return c().getKey();
        }
    }

    public final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        public KeySet(ConcurrentMap<?, ?> concurrentMap) {
            super(LocalCache.this, concurrentMap);
        }

        public boolean contains(Object obj) {
            return this.f11229b.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new KeyIterator(LocalCache.this);
        }

        public boolean remove(Object obj) {
            return this.f11229b.remove(obj) != null;
        }
    }

    public static class LoadingValueReference<K, V> implements ValueReference<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public volatile ValueReference<K, V> f11244b;

        /* renamed from: c  reason: collision with root package name */
        public final SettableFuture<V> f11245c;

        /* renamed from: d  reason: collision with root package name */
        public final Stopwatch f11246d;

        public LoadingValueReference() {
            this(LocalCache.F());
        }

        public ValueReference<K, V> a(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public long b() {
            return this.f11246d.d(TimeUnit.NANOSECONDS);
        }

        public final ListenableFuture<V> c(Throwable th2) {
            return Futures.a(th2);
        }

        public ValueReference<K, V> d() {
            return this.f11244b;
        }

        public ListenableFuture<V> e(K k11, CacheLoader<? super K, V> cacheLoader) {
            try {
                this.f11246d.f();
                Objects.requireNonNull(this.f11244b.get());
                throw null;
            } catch (Throwable th2) {
                ListenableFuture<V> c11 = g(th2) ? this.f11245c : c(th2);
                if (th2 instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return c11;
            }
        }

        public boolean f(V v11) {
            return this.f11245c.y(v11);
        }

        public boolean g(Throwable th2) {
            return this.f11245c.z(th2);
        }

        public V get() {
            return this.f11244b.get();
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public int getWeight() {
            return this.f11244b.getWeight();
        }

        public boolean isActive() {
            return this.f11244b.isActive();
        }

        public boolean isLoading() {
            return true;
        }

        public void notifyNewValue(V v11) {
            if (v11 != null) {
                f(v11);
            } else {
                this.f11244b = LocalCache.F();
            }
        }

        public LoadingValueReference(ValueReference<K, V> valueReference) {
            this.f11245c = SettableFuture.C();
            this.f11246d = Stopwatch.c();
            this.f11244b = valueReference;
        }
    }

    public static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;
        public final LocalCache<K, V> localCache;

        public LocalManualCache(CacheBuilder<? super K, ? super V> cacheBuilder) {
            this(new LocalCache(cacheBuilder, (CacheLoader) null));
        }

        public V getIfPresent(Object obj) {
            return this.localCache.m(obj);
        }

        public void invalidateAll() {
            this.localCache.clear();
        }

        public void put(K k11, V v11) {
            this.localCache.put(k11, v11);
        }

        public Object writeReplace() {
            return new ManualSerializationProxy(this.localCache);
        }

        private LocalManualCache(LocalCache<K, V> localCache2) {
            this.localCache = localCache2;
        }
    }

    public static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;
        public final int concurrencyLevel;
        public transient Cache<K, V> delegate;
        public final long expireAfterAccessNanos;
        public final long expireAfterWriteNanos;
        public final Equivalence<Object> keyEquivalence;
        public final Strength keyStrength;
        public final CacheLoader<? super K, V> loader;
        public final long maxWeight;
        public final RemovalListener<? super K, ? super V> removalListener;
        public final Ticker ticker;
        public final Equivalence<Object> valueEquivalence;
        public final Strength valueStrength;
        public final Weigher<K, V> weigher;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public ManualSerializationProxy(androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r17) {
            /*
                r16 = this;
                r0 = r17
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$Strength r1 = r0.f11213h
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$Strength r2 = r0.f11214i
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r3 = r0.f11211f
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r4 = r0.f11212g
                long r5 = r0.f11218m
                long r7 = r0.f11217l
                long r9 = r0.f11215j
                androidx.test.espresso.core.internal.deps.guava.cache.Weigher<K, V> r11 = r0.f11216k
                int r12 = r0.f11210e
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalListener<K, V> r13 = r0.f11221p
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r14 = r0.f11222q
                androidx.test.espresso.core.internal.deps.guava.cache.CacheLoader<? super K, V> r15 = r0.f11225t
                r0 = r16
                r0.<init>(r1, r2, r3, r4, r5, r7, r9, r11, r12, r13, r14, r15)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.ManualSerializationProxy.<init>(androidx.test.espresso.core.internal.deps.guava.cache.LocalCache):void");
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.delegate = recreateCacheBuilder().a();
        }

        private Object readResolve() {
            return this.delegate;
        }

        public CacheBuilder<K, V> recreateCacheBuilder() {
            CacheBuilder<K1, V1> y11 = CacheBuilder.x().z(this.keyStrength).A(this.valueStrength).u(this.keyEquivalence).C(this.valueEquivalence).d(this.concurrencyLevel).y(this.removalListener);
            y11.f11182a = false;
            long j11 = this.expireAfterWriteNanos;
            if (j11 > 0) {
                y11.f(j11, TimeUnit.NANOSECONDS);
            }
            long j12 = this.expireAfterAccessNanos;
            if (j12 > 0) {
                y11.e(j12, TimeUnit.NANOSECONDS);
            }
            Weigher<K, V> weigher2 = this.weigher;
            if (weigher2 != CacheBuilder.OneWeigher.INSTANCE) {
                y11.D(weigher2);
                long j13 = this.maxWeight;
                if (j13 != -1) {
                    y11.w(j13);
                }
            } else {
                long j14 = this.maxWeight;
                if (j14 != -1) {
                    y11.v(j14);
                }
            }
            Ticker ticker2 = this.ticker;
            if (ticker2 != null) {
                y11.B(ticker2);
            }
            return y11;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence<Object> equivalence, Equivalence<Object> equivalence2, long j11, long j12, long j13, Weigher<K, V> weigher2, int i11, RemovalListener<? super K, ? super V> removalListener2, Ticker ticker2, CacheLoader<? super K, V> cacheLoader) {
            this.keyStrength = strength;
            this.valueStrength = strength2;
            this.keyEquivalence = equivalence;
            this.valueEquivalence = equivalence2;
            this.expireAfterWriteNanos = j11;
            this.expireAfterAccessNanos = j12;
            this.maxWeight = j13;
            this.weigher = weigher2;
            this.concurrencyLevel = i11;
            this.removalListener = removalListener2;
            this.ticker = (ticker2 == Ticker.b() || ticker2 == CacheBuilder.f11180t) ? null : ticker2;
        }

        public Cache<K, V> delegate() {
            return this.delegate;
        }
    }

    public enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        public long getAccessTime() {
            return 0;
        }

        public int getHash() {
            return 0;
        }

        public Object getKey() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNext() {
            return null;
        }

        public ReferenceEntry<Object, Object> getNextInAccessQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getNextInWriteQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousInAccessQueue() {
            return this;
        }

        public ReferenceEntry<Object, Object> getPreviousInWriteQueue() {
            return this;
        }

        public ValueReference<Object, Object> getValueReference() {
            return null;
        }

        public long getWriteTime() {
            return 0;
        }

        public void setAccessTime(long j11) {
        }

        public void setNextInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setNextInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousInAccessQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setPreviousInWriteQueue(ReferenceEntry<Object, Object> referenceEntry) {
        }

        public void setValueReference(ValueReference<Object, Object> valueReference) {
        }

        public void setWriteTime(long j11) {
        }
    }

    public static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final ReferenceEntry<K, V> f11252b;

        public SoftValueReference(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            super(v11, referenceQueue);
            this.f11252b = referenceEntry;
        }

        public ValueReference<K, V> a(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(referenceQueue, v11, referenceEntry);
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.f11252b;
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v11) {
        }
    }

    public enum Strength {
        STRONG {
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.equals();
            }

            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v11, int i11) {
                if (i11 == 1) {
                    return new StrongValueReference(v11);
                }
                return new WeightedStrongValueReference(v11, i11);
            }
        },
        SOFT {
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v11, int i11) {
                if (i11 == 1) {
                    return new SoftValueReference(segment.valueReferenceQueue, v11, referenceEntry);
                }
                return new WeightedSoftValueReference(segment.valueReferenceQueue, v11, referenceEntry, i11);
            }
        },
        WEAK {
            public Equivalence<Object> defaultEquivalence() {
                return Equivalence.identity();
            }

            public <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v11, int i11) {
                if (i11 == 1) {
                    return new WeakValueReference(segment.valueReferenceQueue, v11, referenceEntry);
                }
                return new WeightedWeakValueReference(segment.valueReferenceQueue, v11, referenceEntry, i11);
            }
        };

        public abstract Equivalence<Object> defaultEquivalence();

        public abstract <K, V> ValueReference<K, V> referenceValue(Segment<K, V> segment, ReferenceEntry<K, V> referenceEntry, V v11, int i11);
    }

    public static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: f  reason: collision with root package name */
        public volatile long f11253f = Long.MAX_VALUE;

        /* renamed from: g  reason: collision with root package name */
        public ReferenceEntry<K, V> f11254g = LocalCache.s();

        /* renamed from: h  reason: collision with root package name */
        public ReferenceEntry<K, V> f11255h = LocalCache.s();

        public StrongAccessEntry(K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            super(k11, i11, referenceEntry);
        }

        public long getAccessTime() {
            return this.f11253f;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f11254g;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f11255h;
        }

        public void setAccessTime(long j11) {
            this.f11253f = j11;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11254g = referenceEntry;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11255h = referenceEntry;
        }
    }

    public static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: f  reason: collision with root package name */
        public volatile long f11256f = Long.MAX_VALUE;

        /* renamed from: g  reason: collision with root package name */
        public ReferenceEntry<K, V> f11257g = LocalCache.s();

        /* renamed from: h  reason: collision with root package name */
        public ReferenceEntry<K, V> f11258h = LocalCache.s();

        /* renamed from: i  reason: collision with root package name */
        public volatile long f11259i = Long.MAX_VALUE;

        /* renamed from: j  reason: collision with root package name */
        public ReferenceEntry<K, V> f11260j = LocalCache.s();

        /* renamed from: k  reason: collision with root package name */
        public ReferenceEntry<K, V> f11261k = LocalCache.s();

        public StrongAccessWriteEntry(K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            super(k11, i11, referenceEntry);
        }

        public long getAccessTime() {
            return this.f11256f;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f11257g;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f11260j;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f11258h;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f11261k;
        }

        public long getWriteTime() {
            return this.f11259i;
        }

        public void setAccessTime(long j11) {
            this.f11256f = j11;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11257g = referenceEntry;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11260j = referenceEntry;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11258h = referenceEntry;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11261k = referenceEntry;
        }

        public void setWriteTime(long j11) {
            this.f11259i = j11;
        }
    }

    public static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final K f11262b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11263c;

        /* renamed from: d  reason: collision with root package name */
        public final ReferenceEntry<K, V> f11264d;

        /* renamed from: e  reason: collision with root package name */
        public volatile ValueReference<K, V> f11265e = LocalCache.F();

        public StrongEntry(K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            this.f11262b = k11;
            this.f11263c = i11;
            this.f11264d = referenceEntry;
        }

        public int getHash() {
            return this.f11263c;
        }

        public K getKey() {
            return this.f11262b;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.f11264d;
        }

        public ValueReference<K, V> getValueReference() {
            return this.f11265e;
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            this.f11265e = valueReference;
        }
    }

    public static class StrongValueReference<K, V> implements ValueReference<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final V f11266b;

        public StrongValueReference(V v11) {
            this.f11266b = v11;
        }

        public ValueReference<K, V> a(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public V get() {
            return this.f11266b;
        }

        public ReferenceEntry<K, V> getEntry() {
            return null;
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v11) {
        }
    }

    public static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {

        /* renamed from: f  reason: collision with root package name */
        public volatile long f11267f = Long.MAX_VALUE;

        /* renamed from: g  reason: collision with root package name */
        public ReferenceEntry<K, V> f11268g = LocalCache.s();

        /* renamed from: h  reason: collision with root package name */
        public ReferenceEntry<K, V> f11269h = LocalCache.s();

        public StrongWriteEntry(K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            super(k11, i11, referenceEntry);
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f11268g;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f11269h;
        }

        public long getWriteTime() {
            return this.f11267f;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11268g = referenceEntry;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11269h = referenceEntry;
        }

        public void setWriteTime(long j11) {
            this.f11267f = j11;
        }
    }

    public final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        public ValueIterator(LocalCache localCache) {
            super();
        }

        public V next() {
            return c().getValue();
        }
    }

    public interface ValueReference<K, V> {
        ValueReference<K, V> a(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry);

        V get();

        ReferenceEntry<K, V> getEntry();

        int getWeight();

        boolean isActive();

        boolean isLoading();

        void notifyNewValue(V v11);
    }

    public final class Values extends AbstractCollection<V> {

        /* renamed from: b  reason: collision with root package name */
        public final ConcurrentMap<?, ?> f11270b;

        public Values(ConcurrentMap<?, ?> concurrentMap) {
            this.f11270b = concurrentMap;
        }

        public void clear() {
            this.f11270b.clear();
        }

        public boolean contains(Object obj) {
            return this.f11270b.containsValue(obj);
        }

        public boolean isEmpty() {
            return this.f11270b.isEmpty();
        }

        public Iterator<V> iterator() {
            return new ValueIterator(LocalCache.this);
        }

        public int size() {
            return this.f11270b.size();
        }

        public Object[] toArray() {
            return LocalCache.E(this).toArray();
        }

        public <E> E[] toArray(E[] eArr) {
            return LocalCache.E(this).toArray(eArr);
        }
    }

    public static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public volatile long f11272e = Long.MAX_VALUE;

        /* renamed from: f  reason: collision with root package name */
        public ReferenceEntry<K, V> f11273f = LocalCache.s();

        /* renamed from: g  reason: collision with root package name */
        public ReferenceEntry<K, V> f11274g = LocalCache.s();

        public WeakAccessEntry(ReferenceQueue<K> referenceQueue, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k11, i11, referenceEntry);
        }

        public long getAccessTime() {
            return this.f11272e;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f11273f;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f11274g;
        }

        public void setAccessTime(long j11) {
            this.f11272e = j11;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11273f = referenceEntry;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11274g = referenceEntry;
        }
    }

    public static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public volatile long f11275e = Long.MAX_VALUE;

        /* renamed from: f  reason: collision with root package name */
        public ReferenceEntry<K, V> f11276f = LocalCache.s();

        /* renamed from: g  reason: collision with root package name */
        public ReferenceEntry<K, V> f11277g = LocalCache.s();

        /* renamed from: h  reason: collision with root package name */
        public volatile long f11278h = Long.MAX_VALUE;

        /* renamed from: i  reason: collision with root package name */
        public ReferenceEntry<K, V> f11279i = LocalCache.s();

        /* renamed from: j  reason: collision with root package name */
        public ReferenceEntry<K, V> f11280j = LocalCache.s();

        public WeakAccessWriteEntry(ReferenceQueue<K> referenceQueue, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k11, i11, referenceEntry);
        }

        public long getAccessTime() {
            return this.f11275e;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            return this.f11276f;
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f11279i;
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            return this.f11277g;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f11280j;
        }

        public long getWriteTime() {
            return this.f11278h;
        }

        public void setAccessTime(long j11) {
            this.f11275e = j11;
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11276f = referenceEntry;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11279i = referenceEntry;
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11277g = referenceEntry;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11280j = referenceEntry;
        }

        public void setWriteTime(long j11) {
            this.f11278h = j11;
        }
    }

    public static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final int f11281b;

        /* renamed from: c  reason: collision with root package name */
        public final ReferenceEntry<K, V> f11282c;

        /* renamed from: d  reason: collision with root package name */
        public volatile ValueReference<K, V> f11283d = LocalCache.F();

        public WeakEntry(ReferenceQueue<K> referenceQueue, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            super(k11, referenceQueue);
            this.f11281b = i11;
            this.f11282c = referenceEntry;
        }

        public long getAccessTime() {
            throw new UnsupportedOperationException();
        }

        public int getHash() {
            return this.f11281b;
        }

        public K getKey() {
            return get();
        }

        public ReferenceEntry<K, V> getNext() {
            return this.f11282c;
        }

        public ReferenceEntry<K, V> getNextInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInAccessQueue() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            throw new UnsupportedOperationException();
        }

        public ValueReference<K, V> getValueReference() {
            return this.f11283d;
        }

        public long getWriteTime() {
            throw new UnsupportedOperationException();
        }

        public void setAccessTime(long j11) {
            throw new UnsupportedOperationException();
        }

        public void setNextInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInAccessQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void setValueReference(ValueReference<K, V> valueReference) {
            this.f11283d = valueReference;
        }

        public void setWriteTime(long j11) {
            throw new UnsupportedOperationException();
        }
    }

    public static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final ReferenceEntry<K, V> f11284b;

        public WeakValueReference(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            super(v11, referenceQueue);
            this.f11284b = referenceEntry;
        }

        public ValueReference<K, V> a(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(referenceQueue, v11, referenceEntry);
        }

        public ReferenceEntry<K, V> getEntry() {
            return this.f11284b;
        }

        public int getWeight() {
            return 1;
        }

        public boolean isActive() {
            return true;
        }

        public boolean isLoading() {
            return false;
        }

        public void notifyNewValue(V v11) {
        }
    }

    public static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {

        /* renamed from: e  reason: collision with root package name */
        public volatile long f11285e = Long.MAX_VALUE;

        /* renamed from: f  reason: collision with root package name */
        public ReferenceEntry<K, V> f11286f = LocalCache.s();

        /* renamed from: g  reason: collision with root package name */
        public ReferenceEntry<K, V> f11287g = LocalCache.s();

        public WeakWriteEntry(ReferenceQueue<K> referenceQueue, K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            super(referenceQueue, k11, i11, referenceEntry);
        }

        public ReferenceEntry<K, V> getNextInWriteQueue() {
            return this.f11286f;
        }

        public ReferenceEntry<K, V> getPreviousInWriteQueue() {
            return this.f11287g;
        }

        public long getWriteTime() {
            return this.f11285e;
        }

        public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11286f = referenceEntry;
        }

        public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
            this.f11287g = referenceEntry;
        }

        public void setWriteTime(long j11) {
            this.f11285e = j11;
        }
    }

    public static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {

        /* renamed from: c  reason: collision with root package name */
        public final int f11288c;

        public WeightedSoftValueReference(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry, int i11) {
            super(referenceQueue, v11, referenceEntry);
            this.f11288c = i11;
        }

        public ValueReference<K, V> a(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, v11, referenceEntry, this.f11288c);
        }

        public int getWeight() {
            return this.f11288c;
        }
    }

    public static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {

        /* renamed from: c  reason: collision with root package name */
        public final int f11289c;

        public WeightedStrongValueReference(V v11, int i11) {
            super(v11);
            this.f11289c = i11;
        }

        public int getWeight() {
            return this.f11289c;
        }
    }

    public static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {

        /* renamed from: c  reason: collision with root package name */
        public final int f11290c;

        public WeightedWeakValueReference(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry, int i11) {
            super(referenceQueue, v11, referenceEntry);
            this.f11290c = i11;
        }

        public ValueReference<K, V> a(ReferenceQueue<V> referenceQueue, V v11, ReferenceEntry<K, V> referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, v11, referenceEntry, this.f11290c);
        }

        public int getWeight() {
            return this.f11290c;
        }
    }

    public static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* renamed from: b  reason: collision with root package name */
        public final ReferenceEntry<K, V> f11291b = new AbstractReferenceEntry<K, V>(this) {

            /* renamed from: b  reason: collision with root package name */
            public ReferenceEntry<K, V> f11292b = this;

            /* renamed from: c  reason: collision with root package name */
            public ReferenceEntry<K, V> f11293c = this;

            public ReferenceEntry<K, V> getNextInWriteQueue() {
                return this.f11292b;
            }

            public ReferenceEntry<K, V> getPreviousInWriteQueue() {
                return this.f11293c;
            }

            public long getWriteTime() {
                return Long.MAX_VALUE;
            }

            public void setNextInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f11292b = referenceEntry;
            }

            public void setPreviousInWriteQueue(ReferenceEntry<K, V> referenceEntry) {
                this.f11293c = referenceEntry;
            }

            public void setWriteTime(long j11) {
            }
        };

        /* renamed from: a */
        public boolean offer(ReferenceEntry<K, V> referenceEntry) {
            LocalCache.d(referenceEntry.getPreviousInWriteQueue(), referenceEntry.getNextInWriteQueue());
            LocalCache.d(this.f11291b.getPreviousInWriteQueue(), referenceEntry);
            LocalCache.d(referenceEntry, this.f11291b);
            return true;
        }

        /* renamed from: b */
        public ReferenceEntry<K, V> peek() {
            ReferenceEntry<K, V> nextInWriteQueue = this.f11291b.getNextInWriteQueue();
            if (nextInWriteQueue == this.f11291b) {
                return null;
            }
            return nextInWriteQueue;
        }

        /* renamed from: c */
        public ReferenceEntry<K, V> poll() {
            ReferenceEntry<K, V> nextInWriteQueue = this.f11291b.getNextInWriteQueue();
            if (nextInWriteQueue == this.f11291b) {
                return null;
            }
            remove(nextInWriteQueue);
            return nextInWriteQueue;
        }

        public void clear() {
            ReferenceEntry<K, V> nextInWriteQueue = this.f11291b.getNextInWriteQueue();
            while (true) {
                ReferenceEntry<K, V> referenceEntry = this.f11291b;
                if (nextInWriteQueue != referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue2 = nextInWriteQueue.getNextInWriteQueue();
                    LocalCache.u(nextInWriteQueue);
                    nextInWriteQueue = nextInWriteQueue2;
                } else {
                    referenceEntry.setNextInWriteQueue(referenceEntry);
                    ReferenceEntry<K, V> referenceEntry2 = this.f11291b;
                    referenceEntry2.setPreviousInWriteQueue(referenceEntry2);
                    return;
                }
            }
        }

        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).getNextInWriteQueue() != NullEntry.INSTANCE;
        }

        public boolean isEmpty() {
            return this.f11291b.getNextInWriteQueue() == this.f11291b;
        }

        public Iterator<ReferenceEntry<K, V>> iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) {
                /* renamed from: b */
                public ReferenceEntry<K, V> a(ReferenceEntry<K, V> referenceEntry) {
                    ReferenceEntry<K, V> nextInWriteQueue = referenceEntry.getNextInWriteQueue();
                    if (nextInWriteQueue == WriteQueue.this.f11291b) {
                        return null;
                    }
                    return nextInWriteQueue;
                }
            };
        }

        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry previousInWriteQueue = referenceEntry.getPreviousInWriteQueue();
            ReferenceEntry nextInWriteQueue = referenceEntry.getNextInWriteQueue();
            LocalCache.d(previousInWriteQueue, nextInWriteQueue);
            LocalCache.u(referenceEntry);
            return nextInWriteQueue != NullEntry.INSTANCE;
        }

        public int size() {
            int i11 = 0;
            for (ReferenceEntry<K, V> nextInWriteQueue = this.f11291b.getNextInWriteQueue(); nextInWriteQueue != this.f11291b; nextInWriteQueue = nextInWriteQueue.getNextInWriteQueue()) {
                i11++;
            }
            return i11;
        }
    }

    public final class WriteThroughEntry implements Map.Entry<K, V> {

        /* renamed from: b  reason: collision with root package name */
        public final K f11295b;

        /* renamed from: c  reason: collision with root package name */
        public V f11296c;

        public WriteThroughEntry(K k11, V v11) {
            this.f11295b = k11;
            this.f11296c = v11;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!this.f11295b.equals(entry.getKey()) || !this.f11296c.equals(entry.getValue())) {
                return false;
            }
            return true;
        }

        public K getKey() {
            return this.f11295b;
        }

        public V getValue() {
            return this.f11296c;
        }

        public int hashCode() {
            return this.f11295b.hashCode() ^ this.f11296c.hashCode();
        }

        public V setValue(V v11) {
            V put = LocalCache.this.put(this.f11295b, v11);
            this.f11296c = v11;
            return put;
        }

        public String toString() {
            String valueOf = String.valueOf(getKey());
            String valueOf2 = String.valueOf(getValue());
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(valueOf2);
            return sb2.toString();
        }
    }

    public LocalCache(CacheBuilder<? super K, ? super V> cacheBuilder, CacheLoader<? super K, V> cacheLoader) {
        Queue<RemovalNotification<K, V>> queue;
        this.f11210e = Math.min(cacheBuilder.g(), 65536);
        Strength l11 = cacheBuilder.l();
        this.f11213h = l11;
        this.f11214i = cacheBuilder.s();
        this.f11211f = cacheBuilder.k();
        this.f11212g = cacheBuilder.r();
        long m11 = cacheBuilder.m();
        this.f11215j = m11;
        this.f11216k = cacheBuilder.t();
        this.f11217l = cacheBuilder.h();
        this.f11218m = cacheBuilder.i();
        this.f11219n = cacheBuilder.n();
        RemovalListener<K1, V1> o11 = cacheBuilder.o();
        this.f11221p = o11;
        if (o11 == CacheBuilder.NullListener.INSTANCE) {
            queue = i();
        } else {
            queue = new ConcurrentLinkedQueue<>();
        }
        this.f11220o = queue;
        this.f11222q = cacheBuilder.q(z());
        this.f11223r = EntryFactory.getFactory(l11, G(), K());
        this.f11224s = (AbstractCache$StatsCounter) cacheBuilder.p().get();
        int min = Math.min(cacheBuilder.j(), 1073741824);
        if (j() && !h()) {
            min = (int) Math.min((long) min, m11);
        }
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        int i14 = 1;
        while (i14 < this.f11210e && (!j() || ((long) (i14 * 20)) <= this.f11215j)) {
            i13++;
            i14 <<= 1;
        }
        this.f11208c = 32 - i13;
        this.f11207b = i14 - 1;
        this.f11209d = r(i14);
        int i15 = min / i14;
        while (i12 < (i15 * i14 < min ? i15 + 1 : i15)) {
            i12 <<= 1;
        }
        if (j()) {
            long j11 = this.f11215j;
            long j12 = (long) i14;
            long j13 = (j11 / j12) + 1;
            long j14 = j11 % j12;
            while (true) {
                Segment<K, V>[] segmentArr = this.f11209d;
                if (i11 < segmentArr.length) {
                    if (((long) i11) == j14) {
                        j13--;
                    }
                    segmentArr[i11] = f(i12, j13, (AbstractCache$StatsCounter) cacheBuilder.p().get());
                    i11++;
                } else {
                    return;
                }
            }
        } else {
            while (true) {
                Segment<K, V>[] segmentArr2 = this.f11209d;
                if (i11 < segmentArr2.length) {
                    segmentArr2[i11] = f(i12, -1, (AbstractCache$StatsCounter) cacheBuilder.p().get());
                    i11++;
                } else {
                    return;
                }
            }
        }
    }

    public static int C(int i11) {
        int i12 = i11 + ((i11 << 15) ^ -12931);
        int i13 = i12 ^ (i12 >>> 10);
        int i14 = i13 + (i13 << 3);
        int i15 = i14 ^ (i14 >>> 6);
        int i16 = i15 + (i15 << 2) + (i15 << 14);
        return i16 ^ (i16 >>> 16);
    }

    public static <E> ArrayList<E> E(Collection<E> collection) {
        ArrayList<E> arrayList = new ArrayList<>(collection.size());
        Iterators.a(arrayList, collection.iterator());
        return arrayList;
    }

    public static <K, V> ValueReference<K, V> F() {
        return f11205y;
    }

    public static <K, V> void c(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInAccessQueue(referenceEntry2);
        referenceEntry2.setPreviousInAccessQueue(referenceEntry);
    }

    public static <K, V> void d(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
        referenceEntry.setNextInWriteQueue(referenceEntry2);
        referenceEntry2.setPreviousInWriteQueue(referenceEntry);
    }

    public static <E> Queue<E> i() {
        return f11206z;
    }

    public static <K, V> ReferenceEntry<K, V> s() {
        return NullEntry.INSTANCE;
    }

    public static <K, V> void t(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry s11 = s();
        referenceEntry.setNextInAccessQueue(s11);
        referenceEntry.setPreviousInAccessQueue(s11);
    }

    public static <K, V> void u(ReferenceEntry<K, V> referenceEntry) {
        ReferenceEntry s11 = s();
        referenceEntry.setNextInWriteQueue(s11);
        referenceEntry.setPreviousInWriteQueue(s11);
    }

    public boolean A() {
        return l() || B();
    }

    public boolean B() {
        return this.f11219n > 0;
    }

    public Segment<K, V> D(int i11) {
        return this.f11209d[(i11 >>> this.f11208c) & this.f11207b];
    }

    public boolean G() {
        return H() || y();
    }

    public boolean H() {
        return k() || j();
    }

    public boolean I() {
        return this.f11213h != Strength.STRONG;
    }

    public boolean J() {
        return this.f11214i != Strength.STRONG;
    }

    public boolean K() {
        return L() || A();
    }

    public boolean L() {
        return l();
    }

    public void clear() {
        for (Segment<K, V> clear : this.f11209d) {
            clear.clear();
        }
    }

    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int o11 = o(obj);
        return D(o11).containsKey(obj, o11);
    }

    public boolean containsValue(Object obj) {
        Object obj2 = obj;
        boolean z11 = false;
        if (obj2 == null) {
            return false;
        }
        long a11 = this.f11222q.a();
        Segment<K, V>[] segmentArr = this.f11209d;
        long j11 = -1;
        int i11 = 0;
        while (i11 < 3) {
            long j12 = 0;
            int length = segmentArr.length;
            int i12 = z11;
            while (i12 < length) {
                Segment<K, V> segment = segmentArr[i12];
                int i13 = segment.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = segment.table;
                for (int i14 = z11; i14 < atomicReferenceArray.length(); i14++) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i14);
                    while (referenceEntry != null) {
                        Segment<K, V>[] segmentArr2 = segmentArr;
                        V liveValue = segment.getLiveValue(referenceEntry, a11);
                        long j13 = a11;
                        if (liveValue != null && this.f11212g.equivalent(obj2, liveValue)) {
                            return true;
                        }
                        referenceEntry = referenceEntry.getNext();
                        segmentArr = segmentArr2;
                        a11 = j13;
                    }
                    long j14 = a11;
                    Segment<K, V>[] segmentArr3 = segmentArr;
                }
                Segment<K, V>[] segmentArr4 = segmentArr;
                j12 += (long) segment.modCount;
                i12++;
                a11 = a11;
                z11 = false;
            }
            long j15 = a11;
            Segment<K, V>[] segmentArr5 = segmentArr;
            if (j12 == j11) {
                return false;
            }
            i11++;
            j11 = j12;
            segmentArr = segmentArr5;
            a11 = j15;
            z11 = false;
        }
        return z11;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f11228w;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet(this);
        this.f11228w = entrySet;
        return entrySet;
    }

    public Segment<K, V> f(int i11, long j11, AbstractCache$StatsCounter abstractCache$StatsCounter) {
        return new Segment(this, i11, j11, abstractCache$StatsCounter);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        int o11 = o(obj);
        return D(o11).get(obj, o11);
    }

    public V getOrDefault(Object obj, V v11) {
        V v12 = get(obj);
        return v12 != null ? v12 : v11;
    }

    public boolean h() {
        return this.f11216k != CacheBuilder.OneWeigher.INSTANCE;
    }

    public boolean isEmpty() {
        Segment<K, V>[] segmentArr = this.f11209d;
        long j11 = 0;
        for (int i11 = 0; i11 < segmentArr.length; i11++) {
            if (segmentArr[i11].count != 0) {
                return false;
            }
            j11 += (long) segmentArr[i11].modCount;
        }
        if (j11 == 0) {
            return true;
        }
        for (int i12 = 0; i12 < segmentArr.length; i12++) {
            if (segmentArr[i12].count != 0) {
                return false;
            }
            j11 -= (long) segmentArr[i12].modCount;
        }
        if (j11 != 0) {
            return false;
        }
        return true;
    }

    public boolean j() {
        return this.f11215j >= 0;
    }

    public boolean k() {
        return this.f11217l > 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.f11226u;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet(this);
        this.f11226u = keySet;
        return keySet;
    }

    public boolean l() {
        return this.f11218m > 0;
    }

    public V m(Object obj) {
        int o11 = o(Preconditions.i(obj));
        V v11 = D(o11).get(obj, o11);
        if (v11 == null) {
            this.f11224s.recordMisses(1);
        } else {
            this.f11224s.recordHits(1);
        }
        return v11;
    }

    public V n(ReferenceEntry<K, V> referenceEntry, long j11) {
        V v11;
        if (referenceEntry.getKey() == null || (v11 = referenceEntry.getValueReference().get()) == null || p(referenceEntry, j11)) {
            return null;
        }
        return v11;
    }

    public int o(Object obj) {
        return C(this.f11211f.hash(obj));
    }

    public boolean p(ReferenceEntry<K, V> referenceEntry, long j11) {
        Preconditions.i(referenceEntry);
        if (k() && j11 - referenceEntry.getAccessTime() >= this.f11217l) {
            return true;
        }
        if (!l() || j11 - referenceEntry.getWriteTime() < this.f11218m) {
            return false;
        }
        return true;
    }

    public V put(K k11, V v11) {
        Preconditions.i(k11);
        Preconditions.i(v11);
        int o11 = o(k11);
        return D(o11).put(k11, o11, v11, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public V putIfAbsent(K k11, V v11) {
        Preconditions.i(k11);
        Preconditions.i(v11);
        int o11 = o(k11);
        return D(o11).put(k11, o11, v11, true);
    }

    public long q() {
        Segment<K, V>[] segmentArr = this.f11209d;
        long j11 = 0;
        for (Segment<K, V> segment : segmentArr) {
            j11 += (long) Math.max(0, segment.count);
        }
        return j11;
    }

    public final Segment<K, V>[] r(int i11) {
        return new Segment[i11];
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int o11 = o(obj);
        return D(o11).remove(obj, o11);
    }

    public boolean replace(K k11, V v11, V v12) {
        Preconditions.i(k11);
        Preconditions.i(v12);
        if (v11 == null) {
            return false;
        }
        int o11 = o(k11);
        return D(o11).replace(k11, o11, v11, v12);
    }

    public int size() {
        return Ints.a(q());
    }

    public void v() {
        while (true) {
            RemovalNotification poll = this.f11220o.poll();
            if (poll != null) {
                try {
                    this.f11221p.onRemoval(poll);
                } catch (Throwable th2) {
                    f11204x.logp(Level.WARNING, "androidx.test.espresso.core.internal.deps.guava.cache.LocalCache", "processPendingNotifications", "Exception thrown by removal listener", th2);
                }
            } else {
                return;
            }
        }
    }

    public Collection<V> values() {
        Collection<V> collection = this.f11227v;
        if (collection != null) {
            return collection;
        }
        Values values = new Values(this);
        this.f11227v = values;
        return values;
    }

    public void w(ReferenceEntry<K, V> referenceEntry) {
        int hash = referenceEntry.getHash();
        D(hash).reclaimKey(referenceEntry, hash);
    }

    public void x(ValueReference<K, V> valueReference) {
        ReferenceEntry<K, V> entry = valueReference.getEntry();
        int hash = entry.getHash();
        D(hash).reclaimValue(entry.getKey(), hash, valueReference);
    }

    public boolean y() {
        return k();
    }

    public boolean z() {
        return A() || y();
    }

    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int o11 = o(obj);
        return D(o11).remove(obj, o11, obj2);
    }

    public V replace(K k11, V v11) {
        Preconditions.i(k11);
        Preconditions.i(v11);
        int o11 = o(k11);
        return D(o11).replace(k11, o11, v11);
    }

    public static class Segment<K, V> extends ReentrantLock {
        public final Queue<ReferenceEntry<K, V>> accessQueue;
        public volatile int count;
        public final ReferenceQueue<K> keyReferenceQueue;
        public final LocalCache<K, V> map;
        public final long maxSegmentWeight;
        public int modCount;
        public final AtomicInteger readCount = new AtomicInteger();
        public final Queue<ReferenceEntry<K, V>> recencyQueue;
        public final AbstractCache$StatsCounter statsCounter;
        public volatile AtomicReferenceArray<ReferenceEntry<K, V>> table;
        public int threshold;
        public long totalWeight;
        public final ReferenceQueue<V> valueReferenceQueue;
        public final Queue<ReferenceEntry<K, V>> writeQueue;

        public Segment(LocalCache<K, V> localCache, int i11, long j11, AbstractCache$StatsCounter abstractCache$StatsCounter) {
            Queue<ReferenceEntry<K, V>> queue;
            Queue<ReferenceEntry<K, V>> queue2;
            Queue<ReferenceEntry<K, V>> queue3;
            this.map = localCache;
            this.maxSegmentWeight = j11;
            this.statsCounter = (AbstractCache$StatsCounter) Preconditions.i(abstractCache$StatsCounter);
            initTable(newEntryArray(i11));
            ReferenceQueue<V> referenceQueue = null;
            this.keyReferenceQueue = localCache.I() ? new ReferenceQueue<>() : null;
            this.valueReferenceQueue = localCache.J() ? new ReferenceQueue<>() : referenceQueue;
            if (localCache.H()) {
                queue = new ConcurrentLinkedQueue<>();
            } else {
                queue = LocalCache.i();
            }
            this.recencyQueue = queue;
            if (localCache.L()) {
                queue2 = new WriteQueue<>();
            } else {
                queue2 = LocalCache.i();
            }
            this.writeQueue = queue2;
            if (localCache.H()) {
                queue3 = new AccessQueue<>();
            } else {
                queue3 = LocalCache.i();
            }
            this.accessQueue = queue3;
        }

        public void cleanUp() {
            runLockedCleanup(this.map.f11222q.a());
            runUnlockedCleanup();
        }

        public void clear() {
            RemovalCause removalCause;
            if (this.count != 0) {
                lock();
                try {
                    preWriteCleanup(this.map.f11222q.a());
                    AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                    for (int i11 = 0; i11 < atomicReferenceArray.length(); i11++) {
                        for (ReferenceEntry referenceEntry = atomicReferenceArray.get(i11); referenceEntry != null; referenceEntry = referenceEntry.getNext()) {
                            if (referenceEntry.getValueReference().isActive()) {
                                Object key = referenceEntry.getKey();
                                Object obj = referenceEntry.getValueReference().get();
                                if (key != null) {
                                    if (obj != null) {
                                        removalCause = RemovalCause.EXPLICIT;
                                        enqueueNotification(key, referenceEntry.getHash(), obj, referenceEntry.getValueReference().getWeight(), removalCause);
                                    }
                                }
                                removalCause = RemovalCause.COLLECTED;
                                enqueueNotification(key, referenceEntry.getHash(), obj, referenceEntry.getValueReference().getWeight(), removalCause);
                            }
                        }
                    }
                    for (int i12 = 0; i12 < atomicReferenceArray.length(); i12++) {
                        atomicReferenceArray.set(i12, (Object) null);
                    }
                    clearReferenceQueues();
                    this.writeQueue.clear();
                    this.accessQueue.clear();
                    this.readCount.set(0);
                    this.modCount++;
                    this.count = 0;
                } finally {
                    unlock();
                    postWriteCleanup();
                }
            }
        }

        public void clearKeyReferenceQueue() {
            do {
            } while (this.keyReferenceQueue.poll() != null);
        }

        public void clearReferenceQueues() {
            if (this.map.I()) {
                clearKeyReferenceQueue();
            }
            if (this.map.J()) {
                clearValueReferenceQueue();
            }
        }

        public void clearValueReferenceQueue() {
            do {
            } while (this.valueReferenceQueue.poll() != null);
        }

        public boolean containsKey(Object obj, int i11) {
            try {
                boolean z11 = false;
                if (this.count != 0) {
                    ReferenceEntry liveEntry = getLiveEntry(obj, i11, this.map.f11222q.a());
                    if (liveEntry == null) {
                        return false;
                    }
                    if (liveEntry.getValueReference().get() != null) {
                        z11 = true;
                    }
                    postReadCleanup();
                    return z11;
                }
                postReadCleanup();
                return false;
            } finally {
                postReadCleanup();
            }
        }

        public ReferenceEntry<K, V> copyEntry(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            if (referenceEntry.getKey() == null) {
                return null;
            }
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            V v11 = valueReference.get();
            if (v11 == null && valueReference.isActive()) {
                return null;
            }
            ReferenceEntry<K, V> copyEntry = this.map.f11223r.copyEntry(this, referenceEntry, referenceEntry2);
            copyEntry.setValueReference(valueReference.a(this.valueReferenceQueue, v11, copyEntry));
            return copyEntry;
        }

        public void drainKeyReferenceQueue() {
            int i11 = 0;
            do {
                Reference<? extends K> poll = this.keyReferenceQueue.poll();
                if (poll != null) {
                    this.map.w((ReferenceEntry) poll);
                    i11++;
                } else {
                    return;
                }
            } while (i11 != 16);
        }

        public void drainRecencyQueue() {
            while (true) {
                ReferenceEntry poll = this.recencyQueue.poll();
                if (poll == null) {
                    return;
                }
                if (this.accessQueue.contains(poll)) {
                    this.accessQueue.add(poll);
                }
            }
        }

        public void drainReferenceQueues() {
            if (this.map.I()) {
                drainKeyReferenceQueue();
            }
            if (this.map.J()) {
                drainValueReferenceQueue();
            }
        }

        public void drainValueReferenceQueue() {
            int i11 = 0;
            do {
                Reference<? extends V> poll = this.valueReferenceQueue.poll();
                if (poll != null) {
                    this.map.x((ValueReference) poll);
                    i11++;
                } else {
                    return;
                }
            } while (i11 != 16);
        }

        public void enqueueNotification(K k11, int i11, V v11, int i12, RemovalCause removalCause) {
            this.totalWeight -= (long) i12;
            if (removalCause.wasEvicted()) {
                this.statsCounter.recordEviction();
            }
            if (this.map.f11220o != LocalCache.f11206z) {
                this.map.f11220o.offer(RemovalNotification.create(k11, v11, removalCause));
            }
        }

        public void evictEntries(ReferenceEntry<K, V> referenceEntry) {
            if (this.map.j()) {
                drainRecencyQueue();
                if (((long) referenceEntry.getValueReference().getWeight()) <= this.maxSegmentWeight || removeEntry(referenceEntry, referenceEntry.getHash(), RemovalCause.SIZE)) {
                    while (this.totalWeight > this.maxSegmentWeight) {
                        ReferenceEntry nextEvictable = getNextEvictable();
                        if (!removeEntry(nextEvictable, nextEvictable.getHash(), RemovalCause.SIZE)) {
                            throw new AssertionError();
                        }
                    }
                    return;
                }
                throw new AssertionError();
            }
        }

        public void expand() {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = atomicReferenceArray.length();
            if (length < 1073741824) {
                int i11 = this.count;
                AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray = newEntryArray(length << 1);
                this.threshold = (newEntryArray.length() * 3) / 4;
                int length2 = newEntryArray.length() - 1;
                for (int i12 = 0; i12 < length; i12++) {
                    ReferenceEntry referenceEntry = atomicReferenceArray.get(i12);
                    if (referenceEntry != null) {
                        ReferenceEntry next = referenceEntry.getNext();
                        int hash = referenceEntry.getHash() & length2;
                        if (next == null) {
                            newEntryArray.set(hash, referenceEntry);
                        } else {
                            ReferenceEntry referenceEntry2 = referenceEntry;
                            while (next != null) {
                                int hash2 = next.getHash() & length2;
                                if (hash2 != hash) {
                                    referenceEntry2 = next;
                                    hash = hash2;
                                }
                                next = next.getNext();
                            }
                            newEntryArray.set(hash, referenceEntry2);
                            while (referenceEntry != referenceEntry2) {
                                int hash3 = referenceEntry.getHash() & length2;
                                ReferenceEntry copyEntry = copyEntry(referenceEntry, newEntryArray.get(hash3));
                                if (copyEntry != null) {
                                    newEntryArray.set(hash3, copyEntry);
                                } else {
                                    removeCollectedEntry(referenceEntry);
                                    i11--;
                                }
                                referenceEntry = referenceEntry.getNext();
                            }
                        }
                    }
                }
                this.table = newEntryArray;
                this.count = i11;
            }
        }

        public void expireEntries(long j11) {
            ReferenceEntry peek;
            ReferenceEntry peek2;
            drainRecencyQueue();
            do {
                peek = this.writeQueue.peek();
                if (peek == null || !this.map.p(peek, j11)) {
                    do {
                        peek2 = this.accessQueue.peek();
                        if (peek2 == null || !this.map.p(peek2, j11)) {
                            return;
                        }
                    } while (removeEntry(peek2, peek2.getHash(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (removeEntry(peek, peek.getHash(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        public V get(Object obj, int i11) {
            try {
                if (this.count != 0) {
                    long a11 = this.map.f11222q.a();
                    ReferenceEntry liveEntry = getLiveEntry(obj, i11, a11);
                    if (liveEntry == null) {
                        return null;
                    }
                    Object obj2 = liveEntry.getValueReference().get();
                    if (obj2 != null) {
                        recordRead(liveEntry, a11);
                        V scheduleRefresh = scheduleRefresh(liveEntry, liveEntry.getKey(), i11, obj2, a11, this.map.f11225t);
                        postReadCleanup();
                        return scheduleRefresh;
                    }
                    tryDrainReferenceQueues();
                }
                postReadCleanup();
                return null;
            } finally {
                postReadCleanup();
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:13:0x003f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V getAndRecordStats(K r5, int r6, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.LoadingValueReference<K, V> r7, androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture<V> r8) throws java.util.concurrent.ExecutionException {
            /*
                r4 = this;
                java.lang.Object r8 = androidx.test.espresso.core.internal.deps.guava.util.concurrent.Uninterruptibles.a(r8)     // Catch:{ all -> 0x003b }
                if (r8 == 0) goto L_0x0015
                androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache$StatsCounter r0 = r4.statsCounter     // Catch:{ all -> 0x0013 }
                long r1 = r7.b()     // Catch:{ all -> 0x0013 }
                r0.recordLoadSuccess(r1)     // Catch:{ all -> 0x0013 }
                r4.storeLoadedValue(r5, r6, r7, r8)     // Catch:{ all -> 0x0013 }
                return r8
            L_0x0013:
                r0 = move-exception
                goto L_0x003d
            L_0x0015:
                androidx.test.espresso.core.internal.deps.guava.cache.CacheLoader$InvalidCacheLoadException r0 = new androidx.test.espresso.core.internal.deps.guava.cache.CacheLoader$InvalidCacheLoadException     // Catch:{ all -> 0x0013 }
                java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0013 }
                int r2 = r1.length()     // Catch:{ all -> 0x0013 }
                int r2 = r2 + 35
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0013 }
                r3.<init>(r2)     // Catch:{ all -> 0x0013 }
                java.lang.String r2 = "CacheLoader returned null for key "
                r3.append(r2)     // Catch:{ all -> 0x0013 }
                r3.append(r1)     // Catch:{ all -> 0x0013 }
                java.lang.String r1 = "."
                r3.append(r1)     // Catch:{ all -> 0x0013 }
                java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x0013 }
                r0.<init>(r1)     // Catch:{ all -> 0x0013 }
                throw r0     // Catch:{ all -> 0x0013 }
            L_0x003b:
                r0 = move-exception
                r8 = 0
            L_0x003d:
                if (r8 != 0) goto L_0x004b
                androidx.test.espresso.core.internal.deps.guava.cache.AbstractCache$StatsCounter r8 = r4.statsCounter
                long r1 = r7.b()
                r8.recordLoadException(r1)
                r4.removeLoadingValue(r5, r6, r7)
            L_0x004b:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.getAndRecordStats(java.lang.Object, int, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$LoadingValueReference, androidx.test.espresso.core.internal.deps.guava.util.concurrent.ListenableFuture):java.lang.Object");
        }

        public ReferenceEntry<K, V> getEntry(Object obj, int i11) {
            for (ReferenceEntry<K, V> first = getFirst(i11); first != null; first = first.getNext()) {
                if (first.getHash() == i11) {
                    K key = first.getKey();
                    if (key == null) {
                        tryDrainReferenceQueues();
                    } else if (this.map.f11211f.equivalent(obj, key)) {
                        return first;
                    }
                }
            }
            return null;
        }

        public ReferenceEntry<K, V> getFirst(int i11) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            return atomicReferenceArray.get(i11 & (atomicReferenceArray.length() - 1));
        }

        public ReferenceEntry<K, V> getLiveEntry(Object obj, int i11, long j11) {
            ReferenceEntry<K, V> entry = getEntry(obj, i11);
            if (entry == null) {
                return null;
            }
            if (!this.map.p(entry, j11)) {
                return entry;
            }
            tryExpireEntries(j11);
            return null;
        }

        public V getLiveValue(ReferenceEntry<K, V> referenceEntry, long j11) {
            if (referenceEntry.getKey() == null) {
                tryDrainReferenceQueues();
                return null;
            }
            V v11 = referenceEntry.getValueReference().get();
            if (v11 == null) {
                tryDrainReferenceQueues();
                return null;
            } else if (!this.map.p(referenceEntry, j11)) {
                return v11;
            } else {
                tryExpireEntries(j11);
                return null;
            }
        }

        public ReferenceEntry<K, V> getNextEvictable() {
            for (ReferenceEntry<K, V> referenceEntry : this.accessQueue) {
                if (referenceEntry.getValueReference().getWeight() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        public void initTable(AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray) {
            this.threshold = (atomicReferenceArray.length() * 3) / 4;
            if (!this.map.h()) {
                int i11 = this.threshold;
                if (((long) i11) == this.maxSegmentWeight) {
                    this.threshold = i11 + 1;
                }
            }
            this.table = atomicReferenceArray;
        }

        public LoadingValueReference<K, V> insertLoadingValueReference(K k11, int i11, boolean z11) {
            lock();
            try {
                long a11 = this.map.f11222q.a();
                preWriteCleanup(a11);
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i11 || key == null || !this.map.f11211f.equivalent(k11, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        if (!valueReference.isLoading()) {
                            if (!z11 || a11 - referenceEntry2.getWriteTime() >= this.map.f11219n) {
                                this.modCount++;
                                LoadingValueReference<K, V> loadingValueReference = new LoadingValueReference<>(valueReference);
                                referenceEntry2.setValueReference(loadingValueReference);
                                unlock();
                                postWriteCleanup();
                                return loadingValueReference;
                            }
                        }
                        return null;
                    }
                }
                this.modCount++;
                LoadingValueReference<K, V> loadingValueReference2 = new LoadingValueReference<>();
                ReferenceEntry newEntry = newEntry(k11, i11, referenceEntry);
                newEntry.setValueReference(loadingValueReference2);
                atomicReferenceArray.set(length, newEntry);
                unlock();
                postWriteCleanup();
                return loadingValueReference2;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public ListenableFuture<V> loadAsync(K k11, int i11, LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> cacheLoader) {
            ListenableFuture<V> e11 = loadingValueReference.e(k11, cacheLoader);
            final K k12 = k11;
            final int i12 = i11;
            final LoadingValueReference<K, V> loadingValueReference2 = loadingValueReference;
            final ListenableFuture<V> listenableFuture = e11;
            e11.addListener(new Runnable() {
                public void run() {
                    try {
                        Segment.this.getAndRecordStats(k12, i12, loadingValueReference2, listenableFuture);
                    } catch (Throwable th2) {
                        LocalCache.f11204x.logp(Level.WARNING, "androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$Segment$1", "run", "Exception thrown during refresh", th2);
                        loadingValueReference2.g(th2);
                    }
                }
            }, MoreExecutors.a());
            return e11;
        }

        public ReferenceEntry<K, V> newEntry(K k11, int i11, ReferenceEntry<K, V> referenceEntry) {
            return this.map.f11223r.newEntry(this, Preconditions.i(k11), i11, referenceEntry);
        }

        public AtomicReferenceArray<ReferenceEntry<K, V>> newEntryArray(int i11) {
            return new AtomicReferenceArray<>(i11);
        }

        public void postReadCleanup() {
            if ((this.readCount.incrementAndGet() & 63) == 0) {
                cleanUp();
            }
        }

        public void postWriteCleanup() {
            runUnlockedCleanup();
        }

        public void preWriteCleanup(long j11) {
            runLockedCleanup(j11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0047, code lost:
            r1 = r12.getValueReference();
            r10 = r1.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            if (r10 != null) goto L_0x0090;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0051, code lost:
            r7.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005b, code lost:
            if (r1.isActive() == false) goto L_0x0077;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
            enqueueNotification(r15, r16, r10, r1.getWeight(), androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED);
            setValue(r12, r15, r17, r8);
            r0 = r7.count;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0077, code lost:
            setValue(r12, r15, r17, r8);
            r0 = r7.count + 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0084, code lost:
            r7.count = r0;
            evictEntries(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
            if (r18 == false) goto L_0x009c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            recordLockedRead(r12, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0095, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x009b, code lost:
            return r10;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            r7.modCount++;
            enqueueNotification(r15, r16, r10, r1.getWeight(), androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED);
            setValue(r12, r15, r17, r8);
            evictEntries(r12);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V put(K r15, int r16, V r17, boolean r18) {
            /*
                r14 = this;
                r7 = r14
                r0 = r15
                r3 = r16
                r14.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r1 = r7.map     // Catch:{ all -> 0x00e3 }
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r1 = r1.f11222q     // Catch:{ all -> 0x00e3 }
                long r8 = r1.a()     // Catch:{ all -> 0x00e3 }
                r14.preWriteCleanup(r8)     // Catch:{ all -> 0x00e3 }
                int r1 = r7.count     // Catch:{ all -> 0x00e3 }
                int r1 = r1 + 1
                int r2 = r7.threshold     // Catch:{ all -> 0x00e3 }
                if (r1 <= r2) goto L_0x001d
                r14.expand()     // Catch:{ all -> 0x00e3 }
            L_0x001d:
                java.util.concurrent.atomic.AtomicReferenceArray<androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry<K, V>> r10 = r7.table     // Catch:{ all -> 0x00e3 }
                int r1 = r10.length()     // Catch:{ all -> 0x00e3 }
                int r1 = r1 + -1
                r11 = r3 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch:{ all -> 0x00e3 }
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r1 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r1     // Catch:{ all -> 0x00e3 }
                r12 = r1
            L_0x002e:
                r13 = 0
                if (r12 == 0) goto L_0x00c3
                java.lang.Object r2 = r12.getKey()     // Catch:{ all -> 0x00e3 }
                int r4 = r12.getHash()     // Catch:{ all -> 0x00e3 }
                if (r4 != r3) goto L_0x00bd
                if (r2 == 0) goto L_0x00bd
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r4 = r7.map     // Catch:{ all -> 0x00e3 }
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r4 = r4.f11211f     // Catch:{ all -> 0x00e3 }
                boolean r2 = r4.equivalent(r15, r2)     // Catch:{ all -> 0x00e3 }
                if (r2 == 0) goto L_0x00bd
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r1 = r12.getValueReference()     // Catch:{ all -> 0x00e3 }
                java.lang.Object r10 = r1.get()     // Catch:{ all -> 0x00e3 }
                if (r10 != 0) goto L_0x0090
                int r2 = r7.modCount     // Catch:{ all -> 0x00e3 }
                int r2 = r2 + 1
                r7.modCount = r2     // Catch:{ all -> 0x00e3 }
                boolean r2 = r1.isActive()     // Catch:{ all -> 0x00e3 }
                if (r2 == 0) goto L_0x0077
                int r5 = r1.getWeight()     // Catch:{ all -> 0x00e3 }
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r6 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00e3 }
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00e3 }
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e3 }
                int r0 = r7.count     // Catch:{ all -> 0x00e3 }
                goto L_0x0084
            L_0x0077:
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e3 }
                int r0 = r7.count     // Catch:{ all -> 0x00e3 }
                int r0 = r0 + 1
            L_0x0084:
                r7.count = r0     // Catch:{ all -> 0x00e3 }
                r14.evictEntries(r12)     // Catch:{ all -> 0x00e3 }
            L_0x0089:
                r14.unlock()
                r14.postWriteCleanup()
                return r13
            L_0x0090:
                if (r18 == 0) goto L_0x009c
                r14.recordLockedRead(r12, r8)     // Catch:{ all -> 0x00e3 }
            L_0x0095:
                r14.unlock()
                r14.postWriteCleanup()
                return r10
            L_0x009c:
                int r2 = r7.modCount     // Catch:{ all -> 0x00e3 }
                int r2 = r2 + 1
                r7.modCount = r2     // Catch:{ all -> 0x00e3 }
                int r5 = r1.getWeight()     // Catch:{ all -> 0x00e3 }
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r6 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00e3 }
                r1 = r14
                r2 = r15
                r3 = r16
                r4 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00e3 }
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e3 }
                r14.evictEntries(r12)     // Catch:{ all -> 0x00e3 }
                goto L_0x0095
            L_0x00bd:
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r12 = r12.getNext()     // Catch:{ all -> 0x00e3 }
                goto L_0x002e
            L_0x00c3:
                int r2 = r7.modCount     // Catch:{ all -> 0x00e3 }
                int r2 = r2 + 1
                r7.modCount = r2     // Catch:{ all -> 0x00e3 }
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r12 = r14.newEntry(r15, r3, r1)     // Catch:{ all -> 0x00e3 }
                r1 = r14
                r2 = r12
                r3 = r15
                r4 = r17
                r5 = r8
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00e3 }
                r10.set(r11, r12)     // Catch:{ all -> 0x00e3 }
                int r0 = r7.count     // Catch:{ all -> 0x00e3 }
                int r0 = r0 + 1
                r7.count = r0     // Catch:{ all -> 0x00e3 }
                r14.evictEntries(r12)     // Catch:{ all -> 0x00e3 }
                goto L_0x0089
            L_0x00e3:
                r0 = move-exception
                r14.unlock()
                r14.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.put(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        public boolean reclaimKey(ReferenceEntry<K, V> referenceEntry, int i11) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
                for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                    if (referenceEntry3 == referenceEntry) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i11, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public boolean reclaimValue(K k11, int i11, ValueReference<K, V> valueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (referenceEntry2 != null) {
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i11 || key == null || !this.map.f11211f.equivalent(k11, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == valueReference) {
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i11, valueReference.get(), valueReference, RemovalCause.COLLECTED));
                        this.count--;
                        return true;
                    } else {
                        unlock();
                        if (!isHeldByCurrentThread()) {
                            postWriteCleanup();
                        }
                        return false;
                    }
                }
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
                return false;
            } finally {
                unlock();
                if (!isHeldByCurrentThread()) {
                    postWriteCleanup();
                }
            }
        }

        public void recordLockedRead(ReferenceEntry<K, V> referenceEntry, long j11) {
            if (this.map.y()) {
                referenceEntry.setAccessTime(j11);
            }
            this.accessQueue.add(referenceEntry);
        }

        public void recordRead(ReferenceEntry<K, V> referenceEntry, long j11) {
            if (this.map.y()) {
                referenceEntry.setAccessTime(j11);
            }
            this.recencyQueue.add(referenceEntry);
        }

        public void recordWrite(ReferenceEntry<K, V> referenceEntry, int i11, long j11) {
            drainRecencyQueue();
            this.totalWeight += (long) i11;
            if (this.map.y()) {
                referenceEntry.setAccessTime(j11);
            }
            if (this.map.A()) {
                referenceEntry.setWriteTime(j11);
            }
            this.accessQueue.add(referenceEntry);
            this.writeQueue.add(referenceEntry);
        }

        public V refresh(K k11, int i11, CacheLoader<? super K, V> cacheLoader, boolean z11) {
            LoadingValueReference insertLoadingValueReference = insertLoadingValueReference(k11, i11, z11);
            if (insertLoadingValueReference == null) {
                return null;
            }
            ListenableFuture<V> loadAsync = loadAsync(k11, i11, insertLoadingValueReference, cacheLoader);
            if (loadAsync.isDone()) {
                try {
                    return Uninterruptibles.a(loadAsync);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        public V remove(Object obj, int i11) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.f11222q.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i11 || key == null || !this.map.f11211f.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        V v11 = valueReference.get();
                        if (v11 != null) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        RemovalCause removalCause2 = removalCause;
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i11, v11, valueReference, removalCause2));
                        this.count--;
                        return v11;
                    }
                }
                unlock();
                postWriteCleanup();
                return null;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public void removeCollectedEntry(ReferenceEntry<K, V> referenceEntry) {
            enqueueNotification(referenceEntry.getKey(), referenceEntry.getHash(), referenceEntry.getValueReference().get(), referenceEntry.getValueReference().getWeight(), RemovalCause.COLLECTED);
            this.writeQueue.remove(referenceEntry);
            this.accessQueue.remove(referenceEntry);
        }

        public boolean removeEntry(ReferenceEntry<K, V> referenceEntry, int i11, RemovalCause removalCause) {
            AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
            int length = (atomicReferenceArray.length() - 1) & i11;
            ReferenceEntry<K, V> referenceEntry2 = atomicReferenceArray.get(length);
            for (ReferenceEntry<K, V> referenceEntry3 = referenceEntry2; referenceEntry3 != null; referenceEntry3 = referenceEntry3.getNext()) {
                if (referenceEntry3 == referenceEntry) {
                    this.modCount++;
                    atomicReferenceArray.set(length, removeValueFromChain(referenceEntry2, referenceEntry3, referenceEntry3.getKey(), i11, referenceEntry3.getValueReference().get(), referenceEntry3.getValueReference(), removalCause));
                    this.count--;
                    return true;
                }
            }
            return false;
        }

        public ReferenceEntry<K, V> removeEntryFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            int i11 = this.count;
            ReferenceEntry<K, V> next = referenceEntry2.getNext();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry<K, V> copyEntry = copyEntry(referenceEntry, next);
                if (copyEntry != null) {
                    next = copyEntry;
                } else {
                    removeCollectedEntry(referenceEntry);
                    i11--;
                }
                referenceEntry = referenceEntry.getNext();
            }
            this.count = i11;
            return next;
        }

        public boolean removeLoadingValue(K k11, int i11, LoadingValueReference<K, V> loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i11;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i11 || key == null || !this.map.f11211f.equivalent(k11, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else if (referenceEntry2.getValueReference() == loadingValueReference) {
                        if (loadingValueReference.isActive()) {
                            referenceEntry2.setValueReference(loadingValueReference.d());
                        } else {
                            atomicReferenceArray.set(length, removeEntryFromChain(referenceEntry, referenceEntry2));
                        }
                        return true;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        public ReferenceEntry<K, V> removeValueFromChain(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2, K k11, int i11, V v11, ValueReference<K, V> valueReference, RemovalCause removalCause) {
            enqueueNotification(k11, i11, v11, valueReference.getWeight(), removalCause);
            this.writeQueue.remove(referenceEntry2);
            this.accessQueue.remove(referenceEntry2);
            if (!valueReference.isLoading()) {
                return removeEntryFromChain(referenceEntry, referenceEntry2);
            }
            valueReference.notifyNewValue(null);
            return referenceEntry;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
            r16 = r13.getValueReference();
            r6 = r16.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (r6 != null) goto L_0x0070;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
            if (r16.isActive() == false) goto L_0x0069;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            r9.modCount++;
            r10.set(r12, removeValueFromChain(r2, r13, r4, r19, r6, r16, androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED));
            r9.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
            if (r9.map.f11212g.equivalent(r20, r6) == false) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
            r9.modCount++;
            enqueueNotification(r18, r19, r6, r16.getWeight(), androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED);
            setValue(r13, r18, r21, r7);
            evictEntries(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a0, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00a6, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            recordLockedRead(r13, r7);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean replace(K r18, int r19, V r20, V r21) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r1 = r9.map     // Catch:{ all -> 0x00b5 }
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r1 = r1.f11222q     // Catch:{ all -> 0x00b5 }
                long r7 = r1.a()     // Catch:{ all -> 0x00b5 }
                r9.preWriteCleanup(r7)     // Catch:{ all -> 0x00b5 }
                java.util.concurrent.atomic.AtomicReferenceArray<androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry<K, V>> r10 = r9.table     // Catch:{ all -> 0x00b5 }
                int r1 = r10.length()     // Catch:{ all -> 0x00b5 }
                r11 = 1
                int r1 = r1 - r11
                r12 = r0 & r1
                java.lang.Object r1 = r10.get(r12)     // Catch:{ all -> 0x00b5 }
                r2 = r1
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r2 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r2     // Catch:{ all -> 0x00b5 }
                r13 = r2
            L_0x0024:
                r14 = 0
                if (r13 == 0) goto L_0x0069
                java.lang.Object r4 = r13.getKey()     // Catch:{ all -> 0x00b5 }
                int r1 = r13.getHash()     // Catch:{ all -> 0x00b5 }
                if (r1 != r0) goto L_0x00ab
                if (r4 == 0) goto L_0x00ab
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r1 = r9.map     // Catch:{ all -> 0x00b5 }
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r1 = r1.f11211f     // Catch:{ all -> 0x00b5 }
                r15 = r18
                boolean r1 = r1.equivalent(r15, r4)     // Catch:{ all -> 0x00b5 }
                if (r1 == 0) goto L_0x00ad
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r16 = r13.getValueReference()     // Catch:{ all -> 0x00b5 }
                java.lang.Object r6 = r16.get()     // Catch:{ all -> 0x00b5 }
                if (r6 != 0) goto L_0x0070
                boolean r1 = r16.isActive()     // Catch:{ all -> 0x00b5 }
                if (r1 == 0) goto L_0x0069
                int r1 = r9.modCount     // Catch:{ all -> 0x00b5 }
                int r1 = r1 + r11
                r9.modCount = r1     // Catch:{ all -> 0x00b5 }
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r8 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00b5 }
                r1 = r17
                r3 = r13
                r5 = r19
                r7 = r16
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00b5 }
                int r1 = r9.count     // Catch:{ all -> 0x00b5 }
                int r1 = r1 - r11
                r10.set(r12, r0)     // Catch:{ all -> 0x00b5 }
                r9.count = r1     // Catch:{ all -> 0x00b5 }
            L_0x0069:
                r17.unlock()
                r17.postWriteCleanup()
                return r14
            L_0x0070:
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r1 = r9.map     // Catch:{ all -> 0x00b5 }
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r1 = r1.f11212g     // Catch:{ all -> 0x00b5 }
                r3 = r20
                boolean r1 = r1.equivalent(r3, r6)     // Catch:{ all -> 0x00b5 }
                if (r1 == 0) goto L_0x00a7
                int r1 = r9.modCount     // Catch:{ all -> 0x00b5 }
                int r1 = r1 + r11
                r9.modCount = r1     // Catch:{ all -> 0x00b5 }
                int r5 = r16.getWeight()     // Catch:{ all -> 0x00b5 }
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r10 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00b5 }
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r6
                r6 = r10
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00b5 }
                r1 = r17
                r2 = r13
                r3 = r18
                r4 = r21
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00b5 }
                r9.evictEntries(r13)     // Catch:{ all -> 0x00b5 }
                r17.unlock()
                r17.postWriteCleanup()
                return r11
            L_0x00a7:
                r9.recordLockedRead(r13, r7)     // Catch:{ all -> 0x00b5 }
                goto L_0x0069
            L_0x00ab:
                r15 = r18
            L_0x00ad:
                r3 = r20
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r13 = r13.getNext()     // Catch:{ all -> 0x00b5 }
                goto L_0x0024
            L_0x00b5:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        public void runLockedCleanup(long j11) {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                    expireEntries(j11);
                    this.readCount.set(0);
                } finally {
                    unlock();
                }
            }
        }

        public void runUnlockedCleanup() {
            if (!isHeldByCurrentThread()) {
                this.map.v();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001f, code lost:
            r3 = refresh(r4, r5, r9, true);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V scheduleRefresh(androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry<K, V> r3, K r4, int r5, V r6, long r7, androidx.test.espresso.core.internal.deps.guava.cache.CacheLoader<? super K, V> r9) {
            /*
                r2 = this;
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r0 = r2.map
                boolean r0 = r0.B()
                if (r0 == 0) goto L_0x0027
                long r0 = r3.getWriteTime()
                long r7 = r7 - r0
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r0 = r2.map
                long r0 = r0.f11219n
                int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
                if (r7 <= 0) goto L_0x0027
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r3 = r3.getValueReference()
                boolean r3 = r3.isLoading()
                if (r3 != 0) goto L_0x0027
                r3 = 1
                java.lang.Object r3 = r2.refresh(r4, r5, r9, r3)
                if (r3 == 0) goto L_0x0027
                return r3
            L_0x0027:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.scheduleRefresh(androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry, java.lang.Object, int, java.lang.Object, long, androidx.test.espresso.core.internal.deps.guava.cache.CacheLoader):java.lang.Object");
        }

        public void setValue(ReferenceEntry<K, V> referenceEntry, K k11, V v11, long j11) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            int weigh = this.map.f11216k.weigh(k11, v11);
            Preconditions.p(weigh >= 0, "Weights must be non-negative");
            referenceEntry.setValueReference(this.map.f11214i.referenceValue(this, referenceEntry, v11, weigh));
            recordWrite(referenceEntry, weigh, j11);
            valueReference.notifyNewValue(v11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x004a, code lost:
            r1 = r14.getValueReference();
            r4 = r1.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0054, code lost:
            if (r18 == r1) goto L_0x0072;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
            if (r4 != null) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x005a, code lost:
            if (r1 == androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.f11205y) goto L_0x005d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x005d, code lost:
            enqueueNotification(r16, r17, r19, 0, androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x006a, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
            r7.modCount++;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x007b, code lost:
            if (r18.isActive() == false) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x007d, code lost:
            if (r4 != null) goto L_0x0082;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
            r1 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0082, code lost:
            r1 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0084, code lost:
            enqueueNotification(r16, r17, r4, r18.getWeight(), r1);
            r11 = r11 - 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
            setValue(r14, r16, r19, r8);
            r7.count = r11;
            evictEntries(r14);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean storeLoadedValue(K r16, int r17, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.LoadingValueReference<K, V> r18, V r19) {
            /*
                r15 = this;
                r7 = r15
                r0 = r16
                r3 = r17
                r15.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r1 = r7.map     // Catch:{ all -> 0x00cc }
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r1 = r1.f11222q     // Catch:{ all -> 0x00cc }
                long r8 = r1.a()     // Catch:{ all -> 0x00cc }
                r15.preWriteCleanup(r8)     // Catch:{ all -> 0x00cc }
                int r1 = r7.count     // Catch:{ all -> 0x00cc }
                r10 = 1
                int r1 = r1 + r10
                int r2 = r7.threshold     // Catch:{ all -> 0x00cc }
                if (r1 <= r2) goto L_0x0021
                r15.expand()     // Catch:{ all -> 0x00cc }
                int r1 = r7.count     // Catch:{ all -> 0x00cc }
                int r1 = r1 + r10
            L_0x0021:
                r11 = r1
                java.util.concurrent.atomic.AtomicReferenceArray<androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry<K, V>> r12 = r7.table     // Catch:{ all -> 0x00cc }
                int r1 = r12.length()     // Catch:{ all -> 0x00cc }
                int r1 = r1 - r10
                r13 = r3 & r1
                java.lang.Object r1 = r12.get(r13)     // Catch:{ all -> 0x00cc }
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r1 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r1     // Catch:{ all -> 0x00cc }
                r14 = r1
            L_0x0032:
                if (r14 == 0) goto L_0x00b0
                java.lang.Object r2 = r14.getKey()     // Catch:{ all -> 0x00cc }
                int r4 = r14.getHash()     // Catch:{ all -> 0x00cc }
                if (r4 != r3) goto L_0x00a9
                if (r2 == 0) goto L_0x00a9
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r4 = r7.map     // Catch:{ all -> 0x00cc }
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r4 = r4.f11211f     // Catch:{ all -> 0x00cc }
                boolean r2 = r4.equivalent(r0, r2)     // Catch:{ all -> 0x00cc }
                if (r2 == 0) goto L_0x00a9
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r1 = r14.getValueReference()     // Catch:{ all -> 0x00cc }
                java.lang.Object r4 = r1.get()     // Catch:{ all -> 0x00cc }
                r2 = r18
                if (r2 == r1) goto L_0x0072
                if (r4 != 0) goto L_0x005d
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference<java.lang.Object, java.lang.Object> r5 = androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.f11205y     // Catch:{ all -> 0x00cc }
                if (r1 == r5) goto L_0x005d
                goto L_0x0072
            L_0x005d:
                r5 = 0
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r6 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00cc }
                r1 = r15
                r2 = r16
                r3 = r17
                r4 = r19
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00cc }
                r0 = 0
                r15.unlock()
                r15.postWriteCleanup()
                return r0
            L_0x0072:
                int r1 = r7.modCount     // Catch:{ all -> 0x00cc }
                int r1 = r1 + r10
                r7.modCount = r1     // Catch:{ all -> 0x00cc }
                boolean r1 = r18.isActive()     // Catch:{ all -> 0x00cc }
                if (r1 == 0) goto L_0x0093
                if (r4 != 0) goto L_0x0082
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r1 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00cc }
                goto L_0x0084
            L_0x0082:
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r1 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00cc }
            L_0x0084:
                r6 = r1
                int r5 = r18.getWeight()     // Catch:{ all -> 0x00cc }
                r1 = r15
                r2 = r16
                r3 = r17
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00cc }
                int r11 = r11 + -1
            L_0x0093:
                r1 = r15
                r2 = r14
                r3 = r16
                r4 = r19
                r5 = r8
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00cc }
                r7.count = r11     // Catch:{ all -> 0x00cc }
                r15.evictEntries(r14)     // Catch:{ all -> 0x00cc }
            L_0x00a2:
                r15.unlock()
                r15.postWriteCleanup()
                return r10
            L_0x00a9:
                r2 = r18
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r14 = r14.getNext()     // Catch:{ all -> 0x00cc }
                goto L_0x0032
            L_0x00b0:
                int r2 = r7.modCount     // Catch:{ all -> 0x00cc }
                int r2 = r2 + r10
                r7.modCount = r2     // Catch:{ all -> 0x00cc }
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r14 = r15.newEntry(r0, r3, r1)     // Catch:{ all -> 0x00cc }
                r1 = r15
                r2 = r14
                r3 = r16
                r4 = r19
                r5 = r8
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00cc }
                r12.set(r13, r14)     // Catch:{ all -> 0x00cc }
                r7.count = r11     // Catch:{ all -> 0x00cc }
                r15.evictEntries(r14)     // Catch:{ all -> 0x00cc }
                goto L_0x00a2
            L_0x00cc:
                r0 = move-exception
                r15.unlock()
                r15.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.storeLoadedValue(java.lang.Object, int, androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$LoadingValueReference, java.lang.Object):boolean");
        }

        public void tryDrainReferenceQueues() {
            if (tryLock()) {
                try {
                    drainReferenceQueues();
                } finally {
                    unlock();
                }
            }
        }

        public void tryExpireEntries(long j11) {
            if (tryLock()) {
                try {
                    expireEntries(j11);
                } finally {
                    unlock();
                }
            }
        }

        public boolean remove(Object obj, int i11, Object obj2) {
            RemovalCause removalCause;
            lock();
            try {
                preWriteCleanup(this.map.f11222q.a());
                AtomicReferenceArray<ReferenceEntry<K, V>> atomicReferenceArray = this.table;
                boolean z11 = true;
                int length = (atomicReferenceArray.length() - 1) & i11;
                ReferenceEntry referenceEntry = atomicReferenceArray.get(length);
                ReferenceEntry referenceEntry2 = referenceEntry;
                while (true) {
                    if (referenceEntry2 == null) {
                        break;
                    }
                    Object key = referenceEntry2.getKey();
                    if (referenceEntry2.getHash() != i11 || key == null || !this.map.f11211f.equivalent(obj, key)) {
                        referenceEntry2 = referenceEntry2.getNext();
                    } else {
                        ValueReference valueReference = referenceEntry2.getValueReference();
                        Object obj3 = valueReference.get();
                        if (this.map.f11212g.equivalent(obj2, obj3)) {
                            removalCause = RemovalCause.EXPLICIT;
                        } else if (obj3 == null && valueReference.isActive()) {
                            removalCause = RemovalCause.COLLECTED;
                        }
                        this.modCount++;
                        atomicReferenceArray.set(length, removeValueFromChain(referenceEntry, referenceEntry2, key, i11, obj3, valueReference, removalCause));
                        this.count--;
                        if (removalCause != RemovalCause.EXPLICIT) {
                            z11 = false;
                        }
                        return z11;
                    }
                }
                unlock();
                postWriteCleanup();
                return false;
            } finally {
                unlock();
                postWriteCleanup();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x003f, code lost:
            r15 = r12.getValueReference();
            r16 = r15.get();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0047, code lost:
            if (r16 != null) goto L_0x0073;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x004d, code lost:
            if (r15.isActive() == false) goto L_0x006c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
            r9.modCount++;
            r10.set(r11, removeValueFromChain(r2, r12, r4, r19, r16, r15, androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED));
            r9.count--;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            r9.modCount++;
            enqueueNotification(r18, r19, r16, r15.getWeight(), androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED);
            setValue(r12, r18, r20, r7);
            evictEntries(r12);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0098, code lost:
            unlock();
            postWriteCleanup();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x009e, code lost:
            return r16;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public V replace(K r18, int r19, V r20) {
            /*
                r17 = this;
                r9 = r17
                r0 = r19
                r17.lock()
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r1 = r9.map     // Catch:{ all -> 0x00a7 }
                androidx.test.espresso.core.internal.deps.guava.base.Ticker r1 = r1.f11222q     // Catch:{ all -> 0x00a7 }
                long r7 = r1.a()     // Catch:{ all -> 0x00a7 }
                r9.preWriteCleanup(r7)     // Catch:{ all -> 0x00a7 }
                java.util.concurrent.atomic.AtomicReferenceArray<androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry<K, V>> r10 = r9.table     // Catch:{ all -> 0x00a7 }
                int r1 = r10.length()     // Catch:{ all -> 0x00a7 }
                int r1 = r1 + -1
                r11 = r0 & r1
                java.lang.Object r1 = r10.get(r11)     // Catch:{ all -> 0x00a7 }
                r2 = r1
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r2 = (androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry) r2     // Catch:{ all -> 0x00a7 }
                r12 = r2
            L_0x0024:
                r13 = 0
                if (r12 == 0) goto L_0x006c
                java.lang.Object r4 = r12.getKey()     // Catch:{ all -> 0x00a7 }
                int r1 = r12.getHash()     // Catch:{ all -> 0x00a7 }
                if (r1 != r0) goto L_0x009f
                if (r4 == 0) goto L_0x009f
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache<K, V> r1 = r9.map     // Catch:{ all -> 0x00a7 }
                androidx.test.espresso.core.internal.deps.guava.base.Equivalence<java.lang.Object> r1 = r1.f11211f     // Catch:{ all -> 0x00a7 }
                r14 = r18
                boolean r1 = r1.equivalent(r14, r4)     // Catch:{ all -> 0x00a7 }
                if (r1 == 0) goto L_0x00a1
                androidx.test.espresso.core.internal.deps.guava.cache.LocalCache$ValueReference r15 = r12.getValueReference()     // Catch:{ all -> 0x00a7 }
                java.lang.Object r16 = r15.get()     // Catch:{ all -> 0x00a7 }
                if (r16 != 0) goto L_0x0073
                boolean r1 = r15.isActive()     // Catch:{ all -> 0x00a7 }
                if (r1 == 0) goto L_0x006c
                int r1 = r9.modCount     // Catch:{ all -> 0x00a7 }
                int r1 = r1 + 1
                r9.modCount = r1     // Catch:{ all -> 0x00a7 }
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r8 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.COLLECTED     // Catch:{ all -> 0x00a7 }
                r1 = r17
                r3 = r12
                r5 = r19
                r6 = r16
                r7 = r15
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r0 = r1.removeValueFromChain(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00a7 }
                int r1 = r9.count     // Catch:{ all -> 0x00a7 }
                int r1 = r1 + -1
                r10.set(r11, r0)     // Catch:{ all -> 0x00a7 }
                r9.count = r1     // Catch:{ all -> 0x00a7 }
            L_0x006c:
                r17.unlock()
                r17.postWriteCleanup()
                return r13
            L_0x0073:
                int r1 = r9.modCount     // Catch:{ all -> 0x00a7 }
                int r1 = r1 + 1
                r9.modCount = r1     // Catch:{ all -> 0x00a7 }
                int r5 = r15.getWeight()     // Catch:{ all -> 0x00a7 }
                androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause r6 = androidx.test.espresso.core.internal.deps.guava.cache.RemovalCause.REPLACED     // Catch:{ all -> 0x00a7 }
                r1 = r17
                r2 = r18
                r3 = r19
                r4 = r16
                r1.enqueueNotification(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00a7 }
                r1 = r17
                r2 = r12
                r3 = r18
                r4 = r20
                r5 = r7
                r1.setValue(r2, r3, r4, r5)     // Catch:{ all -> 0x00a7 }
                r9.evictEntries(r12)     // Catch:{ all -> 0x00a7 }
                r17.unlock()
                r17.postWriteCleanup()
                return r16
            L_0x009f:
                r14 = r18
            L_0x00a1:
                androidx.test.espresso.core.internal.deps.guava.cache.ReferenceEntry r12 = r12.getNext()     // Catch:{ all -> 0x00a7 }
                goto L_0x0024
            L_0x00a7:
                r0 = move-exception
                r17.unlock()
                r17.postWriteCleanup()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.test.espresso.core.internal.deps.guava.cache.LocalCache.Segment.replace(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }
    }
}
