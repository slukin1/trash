package kotlinx.coroutines.debug.internal;

import d10.p;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.collections.e;
import kotlin.collections.f;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.bouncycastle.crypto.engines.SerpentEngineBase;

public final class ConcurrentWeakMap<K, V> extends e<K, V> {

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57065c = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size");

    /* renamed from: d  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57066d = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, ZendeskCoreSettingsStorage.CORE_KEY);
    private volatile int _size;

    /* renamed from: b  reason: collision with root package name */
    public final ReferenceQueue<K> f57067b;
    private volatile Object core;

    public final class a {

        /* renamed from: g  reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f57068g = AtomicIntegerFieldUpdater.newUpdater(a.class, "load");

        /* renamed from: a  reason: collision with root package name */
        public final int f57069a;

        /* renamed from: b  reason: collision with root package name */
        public final int f57070b;

        /* renamed from: c  reason: collision with root package name */
        public final int f57071c;

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReferenceArray f57072d;

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReferenceArray f57073e;
        private volatile int load;

        /* renamed from: kotlinx.coroutines.debug.internal.ConcurrentWeakMap$a$a  reason: collision with other inner class name */
        public final class C0666a<E> implements Iterator<E>, e10.a {

            /* renamed from: b  reason: collision with root package name */
            public final p<K, V, E> f57075b;

            /* renamed from: c  reason: collision with root package name */
            public int f57076c = -1;

            /* renamed from: d  reason: collision with root package name */
            public K f57077d;

            /* renamed from: e  reason: collision with root package name */
            public V f57078e;

            public C0666a(p<? super K, ? super V, ? extends E> pVar) {
                this.f57075b = pVar;
                a();
            }

            public final void a() {
                K k11;
                while (true) {
                    int i11 = this.f57076c + 1;
                    this.f57076c = i11;
                    if (i11 < a.this.f57069a) {
                        d dVar = (d) a.this.f57072d.get(this.f57076c);
                        if (!(dVar == null || (k11 = dVar.get()) == null)) {
                            this.f57077d = k11;
                            V v11 = a.this.f57073e.get(this.f57076c);
                            if (v11 instanceof e) {
                                v11 = ((e) v11).f57114a;
                            }
                            if (v11 != null) {
                                this.f57078e = v11;
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            }

            /* renamed from: b */
            public Void remove() {
                Void unused = a.e();
                throw new KotlinNothingValueException();
            }

            public boolean hasNext() {
                return this.f57076c < a.this.f57069a;
            }

            public E next() {
                if (this.f57076c < a.this.f57069a) {
                    p<K, V, E> pVar = this.f57075b;
                    K k11 = this.f57077d;
                    if (k11 == null) {
                        k11 = Unit.f56620a;
                    }
                    V v11 = this.f57078e;
                    if (v11 == null) {
                        v11 = Unit.f56620a;
                    }
                    E invoke = pVar.invoke(k11, v11);
                    a();
                    return invoke;
                }
                throw new NoSuchElementException();
            }
        }

        public a(int i11) {
            this.f57069a = i11;
            this.f57070b = Integer.numberOfLeadingZeros(i11) + 1;
            this.f57071c = (i11 * 2) / 3;
            this.f57072d = new AtomicReferenceArray(i11);
            this.f57073e = new AtomicReferenceArray(i11);
        }

        public static /* synthetic */ Object i(a aVar, Object obj, Object obj2, d dVar, int i11, Object obj3) {
            if ((i11 & 4) != 0) {
                dVar = null;
            }
            return aVar.h(obj, obj2, dVar);
        }

        public final void d(d<?> dVar) {
            int f11 = f(dVar.f57113a);
            while (true) {
                d<?> dVar2 = (d) this.f57072d.get(f11);
                if (dVar2 != null) {
                    if (dVar2 == dVar) {
                        k(f11);
                        return;
                    }
                    if (f11 == 0) {
                        f11 = this.f57069a;
                    }
                    f11--;
                } else {
                    return;
                }
            }
        }

        public final V e(K k11) {
            int f11 = f(k11.hashCode());
            while (true) {
                d dVar = (d) this.f57072d.get(f11);
                if (dVar == null) {
                    return null;
                }
                Object obj = dVar.get();
                if (x.b(k11, obj)) {
                    V v11 = this.f57073e.get(f11);
                    return v11 instanceof e ? ((e) v11).f57114a : v11;
                }
                if (obj == null) {
                    k(f11);
                }
                if (f11 == 0) {
                    f11 = this.f57069a;
                }
                f11--;
            }
        }

        public final int f(int i11) {
            return (i11 * SerpentEngineBase.PHI) >>> this.f57070b;
        }

        public final <E> Iterator<E> g(p<? super K, ? super V, ? extends E> pVar) {
            return new C0666a(pVar);
        }

        public final Object h(K k11, V v11, d<K> dVar) {
            Object obj;
            int i11;
            int f11 = f(k11.hashCode());
            boolean z11 = false;
            while (true) {
                d dVar2 = (d) this.f57072d.get(f11);
                if (dVar2 == null) {
                    if (v11 != null) {
                        if (!z11) {
                            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f57068g;
                            do {
                                i11 = atomicIntegerFieldUpdater.get(this);
                                if (i11 >= this.f57071c) {
                                    return a.f57087a;
                                }
                            } while (!atomicIntegerFieldUpdater.compareAndSet(this, i11, i11 + 1));
                            z11 = true;
                        }
                        if (dVar == null) {
                            dVar = new d<>(k11, ConcurrentWeakMap.this.f57067b);
                        }
                        if (this.f57072d.compareAndSet(f11, (Object) null, dVar)) {
                            break;
                        }
                    } else {
                        return null;
                    }
                } else {
                    Object obj2 = dVar2.get();
                    if (!x.b(k11, obj2)) {
                        if (obj2 == null) {
                            k(f11);
                        }
                        if (f11 == 0) {
                            f11 = this.f57069a;
                        }
                        f11--;
                    } else if (z11) {
                        f57068g.decrementAndGet(this);
                    }
                }
            }
            do {
                obj = this.f57073e.get(f11);
                if (obj instanceof e) {
                    return a.f57087a;
                }
            } while (!this.f57073e.compareAndSet(f11, obj, v11));
            return obj;
        }

        public final ConcurrentWeakMap<K, V>.a j() {
            Object obj;
            while (true) {
                ConcurrentWeakMap<K, V>.a aVar = new a(Integer.highestOneBit(RangesKt___RangesKt.d(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i11 = 0;
                int i12 = this.f57069a;
                while (true) {
                    if (i11 >= i12) {
                        return aVar;
                    }
                    d dVar = (d) this.f57072d.get(i11);
                    Object obj2 = dVar != null ? dVar.get() : null;
                    if (dVar != null && obj2 == null) {
                        k(i11);
                    }
                    while (true) {
                        obj = this.f57073e.get(i11);
                        if (!(obj instanceof e)) {
                            if (this.f57073e.compareAndSet(i11, obj, a.d(obj))) {
                                break;
                            }
                        } else {
                            obj = ((e) obj).f57114a;
                            break;
                        }
                    }
                    if (obj2 == null || obj == null || aVar.h(obj2, obj, dVar) != a.f57087a) {
                        i11++;
                    }
                }
            }
        }

        public final void k(int i11) {
            Object obj;
            do {
                obj = this.f57073e.get(i11);
                if (obj == null || (obj instanceof e)) {
                    return;
                }
            } while (!this.f57073e.compareAndSet(i11, obj, (Object) null));
            ConcurrentWeakMap.this.l();
        }
    }

    public static final class b<K, V> implements Map.Entry<K, V>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final K f57080b;

        /* renamed from: c  reason: collision with root package name */
        public final V f57081c;

        public b(K k11, V v11) {
            this.f57080b = k11;
            this.f57081c = v11;
        }

        public K getKey() {
            return this.f57080b;
        }

        public V getValue() {
            return this.f57081c;
        }

        public V setValue(V v11) {
            Void unused = a.e();
            throw new KotlinNothingValueException();
        }
    }

    public final class c<E> extends f<E> {

        /* renamed from: b  reason: collision with root package name */
        public final p<K, V, E> f57082b;

        public c(p<? super K, ? super V, ? extends E> pVar) {
            this.f57082b = pVar;
        }

        public boolean add(E e11) {
            Void unused = a.e();
            throw new KotlinNothingValueException();
        }

        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        public Iterator<E> iterator() {
            return ((a) ConcurrentWeakMap.f57066d.get(ConcurrentWeakMap.this)).g(this.f57082b);
        }
    }

    public ConcurrentWeakMap() {
        this(false, 1, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConcurrentWeakMap(boolean z11, int i11, r rVar) {
        this((i11 & 1) != 0 ? false : z11);
    }

    public Set<Map.Entry<K, V>> a() {
        return new c(ConcurrentWeakMap$entries$1.INSTANCE);
    }

    public Set<K> c() {
        return new c(ConcurrentWeakMap$keys$1.INSTANCE);
    }

    public void clear() {
        for (Object remove : keySet()) {
            remove(remove);
        }
    }

    public int d() {
        return f57065c.get(this);
    }

    public V get(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((a) f57066d.get(this)).e(obj);
    }

    public final void k(d<?> dVar) {
        ((a) f57066d.get(this)).d(dVar);
    }

    public final void l() {
        f57065c.decrementAndGet(this);
    }

    public final synchronized V m(K k11, V v11) {
        V i11;
        ConcurrentWeakMap<K, V>.a aVar = (a) f57066d.get(this);
        while (true) {
            i11 = a.i(aVar, k11, v11, (d) null, 4, (Object) null);
            if (i11 == a.f57087a) {
                aVar = aVar.j();
                f57066d.set(this, aVar);
            }
        }
        return i11;
    }

    public final void n() {
        if (this.f57067b != null) {
            while (true) {
                try {
                    k((d) this.f57067b.remove());
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        } else {
            throw new IllegalStateException("Must be created with weakRefQueue = true".toString());
        }
    }

    public V put(K k11, V v11) {
        V i11 = a.i((a) f57066d.get(this), k11, v11, (d) null, 4, (Object) null);
        if (i11 == a.f57087a) {
            i11 = m(k11, v11);
        }
        if (i11 == null) {
            f57065c.incrementAndGet(this);
        }
        return i11;
    }

    public V remove(Object obj) {
        if (obj == null) {
            return null;
        }
        V i11 = a.i((a) f57066d.get(this), obj, (Object) null, (d) null, 4, (Object) null);
        if (i11 == a.f57087a) {
            i11 = m(obj, (Object) null);
        }
        if (i11 != null) {
            f57065c.decrementAndGet(this);
        }
        return i11;
    }

    public ConcurrentWeakMap(boolean z11) {
        this.core = new a(16);
        this.f57067b = z11 ? new ReferenceQueue<>() : null;
    }
}
