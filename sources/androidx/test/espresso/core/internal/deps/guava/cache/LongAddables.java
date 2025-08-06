package androidx.test.espresso.core.internal.deps.guava.cache;

import androidx.test.espresso.core.internal.deps.guava.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

final class LongAddables {

    /* renamed from: a  reason: collision with root package name */
    public static final Supplier<LongAddable> f11298a;

    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        public void add(long j11) {
            getAndAdd(j11);
        }

        public void increment() {
            getAndIncrement();
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() {
                /* renamed from: a */
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() {
                /* renamed from: a */
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        f11298a = supplier;
    }

    public static LongAddable a() {
        return f11298a.get();
    }
}
