package kotlin.random;

import java.util.Random;

public abstract class AbstractPlatformRandom extends Random {
    public abstract Random getImpl();

    public int nextBits(int i11) {
        return b.f(getImpl().nextInt(), i11);
    }

    public boolean nextBoolean() {
        return getImpl().nextBoolean();
    }

    public byte[] nextBytes(byte[] bArr) {
        getImpl().nextBytes(bArr);
        return bArr;
    }

    public double nextDouble() {
        return getImpl().nextDouble();
    }

    public float nextFloat() {
        return getImpl().nextFloat();
    }

    public int nextInt() {
        return getImpl().nextInt();
    }

    public long nextLong() {
        return getImpl().nextLong();
    }

    public int nextInt(int i11) {
        return getImpl().nextInt(i11);
    }
}
