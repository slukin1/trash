package kotlin.random;

import java.util.Random;

public final class FallbackThreadLocalRandom extends AbstractPlatformRandom {

    /* renamed from: a  reason: collision with root package name */
    public final a f56818a = new a();

    public static final class a extends ThreadLocal<Random> {
        /* renamed from: a */
        public Random initialValue() {
            return new Random();
        }
    }

    public Random getImpl() {
        return (Random) this.f56818a.get();
    }
}
