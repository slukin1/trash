package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Ascii;
import androidx.test.espresso.core.internal.deps.guava.base.Equivalence;
import androidx.test.espresso.core.internal.deps.guava.base.MoreObjects;
import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.espresso.core.internal.deps.guava.base.Supplier;
import androidx.test.espresso.core.internal.deps.guava.base.Suppliers;
import androidx.test.espresso.core.internal.deps.guava.base.Ticker;
import androidx.test.espresso.core.internal.deps.guava.cache.LocalCache;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class CacheBuilder<K, V> {

    /* renamed from: q  reason: collision with root package name */
    public static final Supplier<? extends AbstractCache$StatsCounter> f11177q = Suppliers.a(new AbstractCache$StatsCounter() {
        public void recordEviction() {
        }

        public void recordHits(int i11) {
        }

        public void recordLoadException(long j11) {
        }

        public void recordLoadSuccess(long j11) {
        }

        public void recordMisses(int i11) {
        }
    });

    /* renamed from: r  reason: collision with root package name */
    public static final CacheStats f11178r = new CacheStats(0, 0, 0, 0, 0, 0);

    /* renamed from: s  reason: collision with root package name */
    public static final Supplier<AbstractCache$StatsCounter> f11179s = new Supplier<AbstractCache$StatsCounter>() {
        /* renamed from: a */
        public AbstractCache$StatsCounter get() {
            return new AbstractCache$SimpleStatsCounter();
        }
    };

    /* renamed from: t  reason: collision with root package name */
    public static final Ticker f11180t = new Ticker() {
        public long a() {
            return 0;
        }
    };

    /* renamed from: u  reason: collision with root package name */
    public static final Logger f11181u = Logger.getLogger(CacheBuilder.class.getName());

    /* renamed from: a  reason: collision with root package name */
    public boolean f11182a = true;

    /* renamed from: b  reason: collision with root package name */
    public int f11183b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f11184c = -1;

    /* renamed from: d  reason: collision with root package name */
    public long f11185d = -1;

    /* renamed from: e  reason: collision with root package name */
    public long f11186e = -1;

    /* renamed from: f  reason: collision with root package name */
    public Weigher<? super K, ? super V> f11187f;

    /* renamed from: g  reason: collision with root package name */
    public LocalCache.Strength f11188g;

    /* renamed from: h  reason: collision with root package name */
    public LocalCache.Strength f11189h;

    /* renamed from: i  reason: collision with root package name */
    public long f11190i = -1;

    /* renamed from: j  reason: collision with root package name */
    public long f11191j = -1;

    /* renamed from: k  reason: collision with root package name */
    public long f11192k = -1;

    /* renamed from: l  reason: collision with root package name */
    public Equivalence<Object> f11193l;

    /* renamed from: m  reason: collision with root package name */
    public Equivalence<Object> f11194m;

    /* renamed from: n  reason: collision with root package name */
    public RemovalListener<? super K, ? super V> f11195n;

    /* renamed from: o  reason: collision with root package name */
    public Ticker f11196o;

    /* renamed from: p  reason: collision with root package name */
    public Supplier<? extends AbstractCache$StatsCounter> f11197p = f11177q;

    public enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    public enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> x() {
        return new CacheBuilder<>();
    }

    public CacheBuilder<K, V> A(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f11189h;
        Preconditions.s(strength2 == null, "Value strength was already set to %s", strength2);
        this.f11189h = (LocalCache.Strength) Preconditions.i(strength);
        return this;
    }

    public CacheBuilder<K, V> B(Ticker ticker) {
        Preconditions.o(this.f11196o == null);
        this.f11196o = (Ticker) Preconditions.i(ticker);
        return this;
    }

    public CacheBuilder<K, V> C(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f11194m;
        Preconditions.s(equivalence2 == null, "value equivalence was already set to %s", equivalence2);
        this.f11194m = (Equivalence) Preconditions.i(equivalence);
        return this;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> D(Weigher<? super K1, ? super V1> weigher) {
        boolean z11 = true;
        Preconditions.o(this.f11187f == null);
        if (this.f11182a) {
            long j11 = this.f11185d;
            if (j11 != -1) {
                z11 = false;
            }
            Preconditions.r(z11, "weigher can not be combined with maximum size", j11);
        }
        this.f11187f = (Weigher) Preconditions.i(weigher);
        return this;
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> a() {
        c();
        b();
        return new LocalCache.LocalManualCache(this);
    }

    public final void b() {
        Preconditions.p(this.f11192k == -1, "refreshAfterWrite requires a LoadingCache");
    }

    public final void c() {
        boolean z11 = true;
        if (this.f11187f == null) {
            if (this.f11186e != -1) {
                z11 = false;
            }
            Preconditions.p(z11, "maximumWeight requires weigher");
        } else if (this.f11182a) {
            if (this.f11186e == -1) {
                z11 = false;
            }
            Preconditions.p(z11, "weigher requires maximumWeight");
        } else if (this.f11186e == -1) {
            f11181u.logp(Level.WARNING, "androidx.test.espresso.core.internal.deps.guava.cache.CacheBuilder", "checkWeightWithWeigher", "ignoring weigher specified without maximumWeight");
        }
    }

    public CacheBuilder<K, V> d(int i11) {
        int i12 = this.f11184c;
        boolean z11 = true;
        Preconditions.q(i12 == -1, "concurrency level was already set to %s", i12);
        if (i11 <= 0) {
            z11 = false;
        }
        Preconditions.d(z11);
        this.f11184c = i11;
        return this;
    }

    public CacheBuilder<K, V> e(long j11, TimeUnit timeUnit) {
        long j12 = this.f11191j;
        boolean z11 = true;
        Preconditions.r(j12 == -1, "expireAfterAccess was already set to %s ns", j12);
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.f(z11, "duration cannot be negative: %s %s", j11, timeUnit);
        this.f11191j = timeUnit.toNanos(j11);
        return this;
    }

    public CacheBuilder<K, V> f(long j11, TimeUnit timeUnit) {
        long j12 = this.f11190i;
        boolean z11 = true;
        Preconditions.r(j12 == -1, "expireAfterWrite was already set to %s ns", j12);
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.f(z11, "duration cannot be negative: %s %s", j11, timeUnit);
        this.f11190i = timeUnit.toNanos(j11);
        return this;
    }

    public int g() {
        int i11 = this.f11184c;
        if (i11 == -1) {
            return 4;
        }
        return i11;
    }

    public long h() {
        long j11 = this.f11191j;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public long i() {
        long j11 = this.f11190i;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public int j() {
        int i11 = this.f11183b;
        if (i11 == -1) {
            return 16;
        }
        return i11;
    }

    public Equivalence<Object> k() {
        return (Equivalence) MoreObjects.a(this.f11193l, l().defaultEquivalence());
    }

    public LocalCache.Strength l() {
        return (LocalCache.Strength) MoreObjects.a(this.f11188g, LocalCache.Strength.STRONG);
    }

    public long m() {
        if (this.f11190i == 0 || this.f11191j == 0) {
            return 0;
        }
        return this.f11187f == null ? this.f11185d : this.f11186e;
    }

    public long n() {
        long j11 = this.f11192k;
        if (j11 == -1) {
            return 0;
        }
        return j11;
    }

    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> o() {
        return (RemovalListener) MoreObjects.a(this.f11195n, NullListener.INSTANCE);
    }

    public Supplier<? extends AbstractCache$StatsCounter> p() {
        return this.f11197p;
    }

    public Ticker q(boolean z11) {
        Ticker ticker = this.f11196o;
        if (ticker != null) {
            return ticker;
        }
        return z11 ? Ticker.b() : f11180t;
    }

    public Equivalence<Object> r() {
        return (Equivalence) MoreObjects.a(this.f11194m, s().defaultEquivalence());
    }

    public LocalCache.Strength s() {
        return (LocalCache.Strength) MoreObjects.a(this.f11189h, LocalCache.Strength.STRONG);
    }

    public <K1 extends K, V1 extends V> Weigher<K1, V1> t() {
        return (Weigher) MoreObjects.a(this.f11187f, OneWeigher.INSTANCE);
    }

    public String toString() {
        MoreObjects.ToStringHelper b11 = MoreObjects.b(this);
        int i11 = this.f11183b;
        if (i11 != -1) {
            b11.b("initialCapacity", i11);
        }
        int i12 = this.f11184c;
        if (i12 != -1) {
            b11.b("concurrencyLevel", i12);
        }
        long j11 = this.f11185d;
        if (j11 != -1) {
            b11.c("maximumSize", j11);
        }
        long j12 = this.f11186e;
        if (j12 != -1) {
            b11.c("maximumWeight", j12);
        }
        long j13 = this.f11190i;
        if (j13 != -1) {
            StringBuilder sb2 = new StringBuilder(22);
            sb2.append(j13);
            sb2.append("ns");
            b11.d("expireAfterWrite", sb2.toString());
        }
        long j14 = this.f11191j;
        if (j14 != -1) {
            StringBuilder sb3 = new StringBuilder(22);
            sb3.append(j14);
            sb3.append("ns");
            b11.d("expireAfterAccess", sb3.toString());
        }
        LocalCache.Strength strength = this.f11188g;
        if (strength != null) {
            b11.d("keyStrength", Ascii.b(strength.toString()));
        }
        LocalCache.Strength strength2 = this.f11189h;
        if (strength2 != null) {
            b11.d("valueStrength", Ascii.b(strength2.toString()));
        }
        if (this.f11193l != null) {
            b11.i("keyEquivalence");
        }
        if (this.f11194m != null) {
            b11.i("valueEquivalence");
        }
        if (this.f11195n != null) {
            b11.i("removalListener");
        }
        return b11.toString();
    }

    public CacheBuilder<K, V> u(Equivalence<Object> equivalence) {
        Equivalence<Object> equivalence2 = this.f11193l;
        Preconditions.s(equivalence2 == null, "key equivalence was already set to %s", equivalence2);
        this.f11193l = (Equivalence) Preconditions.i(equivalence);
        return this;
    }

    public CacheBuilder<K, V> v(long j11) {
        long j12 = this.f11185d;
        boolean z11 = true;
        Preconditions.r(j12 == -1, "maximum size was already set to %s", j12);
        long j13 = this.f11186e;
        Preconditions.r(j13 == -1, "maximum weight was already set to %s", j13);
        Preconditions.p(this.f11187f == null, "maximum size can not be combined with weigher");
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.e(z11, "maximum size must not be negative");
        this.f11185d = j11;
        return this;
    }

    public CacheBuilder<K, V> w(long j11) {
        long j12 = this.f11186e;
        boolean z11 = true;
        Preconditions.r(j12 == -1, "maximum weight was already set to %s", j12);
        long j13 = this.f11185d;
        Preconditions.r(j13 == -1, "maximum size was already set to %s", j13);
        this.f11186e = j11;
        if (j11 < 0) {
            z11 = false;
        }
        Preconditions.e(z11, "maximum weight must not be negative");
        return this;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> y(RemovalListener<? super K1, ? super V1> removalListener) {
        Preconditions.o(this.f11195n == null);
        this.f11195n = (RemovalListener) Preconditions.i(removalListener);
        return this;
    }

    public CacheBuilder<K, V> z(LocalCache.Strength strength) {
        LocalCache.Strength strength2 = this.f11188g;
        Preconditions.s(strength2 == null, "Key strength was already set to %s", strength2);
        this.f11188g = (LocalCache.Strength) Preconditions.i(strength);
        return this;
    }
}
