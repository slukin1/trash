package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.hash.BloomFilterStrategies;
import com.google.common.math.DoubleMath;
import com.google.common.primitives.SignedBytes;
import com.google.common.primitives.UnsignedBytes;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.RoundingMode;

@Beta
public final class BloomFilter<T> implements Predicate<T>, Serializable {
    /* access modifiers changed from: private */
    public final BloomFilterStrategies.LockFreeBitArray bits;
    /* access modifiers changed from: private */
    public final Funnel<? super T> funnel;
    /* access modifiers changed from: private */
    public final int numHashFunctions;
    /* access modifiers changed from: private */
    public final Strategy strategy;

    public static class SerialForm<T> implements Serializable {
        private static final long serialVersionUID = 1;
        public final long[] data;
        public final Funnel<? super T> funnel;
        public final int numHashFunctions;
        public final Strategy strategy;

        public SerialForm(BloomFilter<T> bloomFilter) {
            this.data = BloomFilterStrategies.LockFreeBitArray.toPlainArray(bloomFilter.bits.data);
            this.numHashFunctions = bloomFilter.numHashFunctions;
            this.funnel = bloomFilter.funnel;
            this.strategy = bloomFilter.strategy;
        }

        public Object readResolve() {
            return new BloomFilter(new BloomFilterStrategies.LockFreeBitArray(this.data), this.numHashFunctions, this.funnel, this.strategy);
        }
    }

    public interface Strategy extends Serializable {
        <T> boolean mightContain(T t11, Funnel<? super T> funnel, int i11, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);

        int ordinal();

        <T> boolean put(T t11, Funnel<? super T> funnel, int i11, BloomFilterStrategies.LockFreeBitArray lockFreeBitArray);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i11, double d11) {
        return create(funnel2, (long) i11, d11);
    }

    @VisibleForTesting
    public static long optimalNumOfBits(long j11, double d11) {
        if (d11 == 0.0d) {
            d11 = Double.MIN_VALUE;
        }
        return (long) ((((double) (-j11)) * Math.log(d11)) / (Math.log(2.0d) * Math.log(2.0d)));
    }

    @VisibleForTesting
    public static int optimalNumOfHashFunctions(long j11, long j12) {
        return Math.max(1, (int) Math.round((((double) j12) / ((double) j11)) * Math.log(2.0d)));
    }

    public static <T> BloomFilter<T> readFrom(InputStream inputStream, Funnel<? super T> funnel2) throws IOException {
        int i11;
        int i12;
        Preconditions.checkNotNull(inputStream, "InputStream");
        Preconditions.checkNotNull(funnel2, "Funnel");
        byte b11 = -1;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            byte readByte = dataInputStream.readByte();
            try {
                i12 = UnsignedBytes.toInt(dataInputStream.readByte());
                try {
                    int readInt = dataInputStream.readInt();
                    BloomFilterStrategies bloomFilterStrategies = BloomFilterStrategies.values()[readByte];
                    long[] jArr = new long[readInt];
                    for (int i13 = 0; i13 < readInt; i13++) {
                        jArr[i13] = dataInputStream.readLong();
                    }
                    return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(jArr), i12, funnel2, bloomFilterStrategies);
                } catch (RuntimeException e11) {
                    e = e11;
                    b11 = readByte;
                    i11 = -1;
                    throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + b11 + " numHashFunctions: " + i12 + " dataLength: " + i11, e);
                }
            } catch (RuntimeException e12) {
                e = e12;
                i12 = -1;
                b11 = readByte;
                i11 = -1;
                throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + b11 + " numHashFunctions: " + i12 + " dataLength: " + i11, e);
            }
        } catch (RuntimeException e13) {
            e = e13;
            i11 = -1;
            i12 = -1;
            throw new IOException("Unable to deserialize BloomFilter from InputStream. strategyOrdinal: " + b11 + " numHashFunctions: " + i12 + " dataLength: " + i11, e);
        }
    }

    private Object writeReplace() {
        return new SerialForm(this);
    }

    @Deprecated
    public boolean apply(T t11) {
        return mightContain(t11);
    }

    public long approximateElementCount() {
        double bitSize = (double) this.bits.bitSize();
        return DoubleMath.roundToLong(((-Math.log1p(-(((double) this.bits.bitCount()) / bitSize))) * bitSize) / ((double) this.numHashFunctions), RoundingMode.HALF_UP);
    }

    @VisibleForTesting
    public long bitSize() {
        return this.bits.bitSize();
    }

    public BloomFilter<T> copy() {
        return new BloomFilter<>(this.bits.copy(), this.numHashFunctions, this.funnel, this.strategy);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BloomFilter)) {
            return false;
        }
        BloomFilter bloomFilter = (BloomFilter) obj;
        if (this.numHashFunctions != bloomFilter.numHashFunctions || !this.funnel.equals(bloomFilter.funnel) || !this.bits.equals(bloomFilter.bits) || !this.strategy.equals(bloomFilter.strategy)) {
            return false;
        }
        return true;
    }

    public double expectedFpp() {
        return Math.pow(((double) this.bits.bitCount()) / ((double) bitSize()), (double) this.numHashFunctions);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.numHashFunctions), this.funnel, this.strategy, this.bits);
    }

    public boolean isCompatible(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        return this != bloomFilter && this.numHashFunctions == bloomFilter.numHashFunctions && bitSize() == bloomFilter.bitSize() && this.strategy.equals(bloomFilter.strategy) && this.funnel.equals(bloomFilter.funnel);
    }

    public boolean mightContain(T t11) {
        return this.strategy.mightContain(t11, this.funnel, this.numHashFunctions, this.bits);
    }

    @CanIgnoreReturnValue
    public boolean put(T t11) {
        return this.strategy.put(t11, this.funnel, this.numHashFunctions, this.bits);
    }

    public void putAll(BloomFilter<T> bloomFilter) {
        Preconditions.checkNotNull(bloomFilter);
        Preconditions.checkArgument(this != bloomFilter, "Cannot combine a BloomFilter with itself.");
        int i11 = this.numHashFunctions;
        int i12 = bloomFilter.numHashFunctions;
        Preconditions.checkArgument(i11 == i12, "BloomFilters must have the same number of hash functions (%s != %s)", i11, i12);
        Preconditions.checkArgument(bitSize() == bloomFilter.bitSize(), "BloomFilters must have the same size underlying bit arrays (%s != %s)", bitSize(), bloomFilter.bitSize());
        Preconditions.checkArgument(this.strategy.equals(bloomFilter.strategy), "BloomFilters must have equal strategies (%s != %s)", (Object) this.strategy, (Object) bloomFilter.strategy);
        Preconditions.checkArgument(this.funnel.equals(bloomFilter.funnel), "BloomFilters must have equal funnels (%s != %s)", (Object) this.funnel, (Object) bloomFilter.funnel);
        this.bits.putAll(bloomFilter.bits);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeByte(SignedBytes.checkedCast((long) this.strategy.ordinal()));
        dataOutputStream.writeByte(UnsignedBytes.checkedCast((long) this.numHashFunctions));
        dataOutputStream.writeInt(this.bits.data.length());
        for (int i11 = 0; i11 < this.bits.data.length(); i11++) {
            dataOutputStream.writeLong(this.bits.data.get(i11));
        }
    }

    private BloomFilter(BloomFilterStrategies.LockFreeBitArray lockFreeBitArray, int i11, Funnel<? super T> funnel2, Strategy strategy2) {
        boolean z11 = true;
        Preconditions.checkArgument(i11 > 0, "numHashFunctions (%s) must be > 0", i11);
        Preconditions.checkArgument(i11 > 255 ? false : z11, "numHashFunctions (%s) must be <= 255", i11);
        this.bits = (BloomFilterStrategies.LockFreeBitArray) Preconditions.checkNotNull(lockFreeBitArray);
        this.numHashFunctions = i11;
        this.funnel = (Funnel) Preconditions.checkNotNull(funnel2);
        this.strategy = (Strategy) Preconditions.checkNotNull(strategy2);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j11, double d11) {
        return create(funnel2, j11, d11, BloomFilterStrategies.MURMUR128_MITZ_64);
    }

    @VisibleForTesting
    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j11, double d11, Strategy strategy2) {
        Preconditions.checkNotNull(funnel2);
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        boolean z11 = true;
        Preconditions.checkArgument(i11 >= 0, "Expected insertions (%s) must be >= 0", j11);
        Preconditions.checkArgument(d11 > 0.0d, "False positive probability (%s) must be > 0.0", (Object) Double.valueOf(d11));
        if (d11 >= 1.0d) {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "False positive probability (%s) must be < 1.0", (Object) Double.valueOf(d11));
        Preconditions.checkNotNull(strategy2);
        if (i11 == 0) {
            j11 = 1;
        }
        long optimalNumOfBits = optimalNumOfBits(j11, d11);
        try {
            return new BloomFilter<>(new BloomFilterStrategies.LockFreeBitArray(optimalNumOfBits), optimalNumOfHashFunctions(j11, optimalNumOfBits), funnel2, strategy2);
        } catch (IllegalArgumentException e11) {
            throw new IllegalArgumentException("Could not create BloomFilter of " + optimalNumOfBits + " bits", e11);
        }
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, int i11) {
        return create(funnel2, (long) i11);
    }

    public static <T> BloomFilter<T> create(Funnel<? super T> funnel2, long j11) {
        return create(funnel2, j11, 0.03d);
    }
}
