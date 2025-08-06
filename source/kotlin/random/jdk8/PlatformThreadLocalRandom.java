package kotlin.random.jdk8;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.random.AbstractPlatformRandom;

public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    public Random getImpl() {
        return ThreadLocalRandom.current();
    }

    public double nextDouble(double d11) {
        return ThreadLocalRandom.current().nextDouble(d11);
    }

    public int nextInt(int i11, int i12) {
        return ThreadLocalRandom.current().nextInt(i11, i12);
    }

    public long nextLong(long j11) {
        return ThreadLocalRandom.current().nextLong(j11);
    }

    public long nextLong(long j11, long j12) {
        return ThreadLocalRandom.current().nextLong(j11, j12);
    }
}
