package kotlin.random;

import java.util.Random;
import kotlin.jvm.internal.r;

final class KotlinRandom extends Random {
    private static final a Companion = new a((r) null);
    @Deprecated
    private static final long serialVersionUID = 0;
    private final Random impl;
    private boolean seedInitialized;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public KotlinRandom(Random random) {
        this.impl = random;
    }

    public final Random getImpl() {
        return this.impl;
    }

    public int next(int i11) {
        return this.impl.nextBits(i11);
    }

    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    public void nextBytes(byte[] bArr) {
        this.impl.nextBytes(bArr);
    }

    public double nextDouble() {
        return this.impl.nextDouble();
    }

    public float nextFloat() {
        return this.impl.nextFloat();
    }

    public int nextInt() {
        return this.impl.nextInt();
    }

    public long nextLong() {
        return this.impl.nextLong();
    }

    public void setSeed(long j11) {
        if (!this.seedInitialized) {
            this.seedInitialized = true;
            return;
        }
        throw new UnsupportedOperationException("Setting seed is not supported.");
    }

    public int nextInt(int i11) {
        return this.impl.nextInt(i11);
    }
}
