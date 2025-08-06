package com.sumsub.sns.prooface.network;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.collections.IntIterator;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f40274a = new d();

    /* renamed from: b  reason: collision with root package name */
    public static AtomicLong f40275b = new AtomicLong(0);

    /* renamed from: c  reason: collision with root package name */
    public static final long f40276c = 25214903917L;

    /* renamed from: d  reason: collision with root package name */
    public static final long f40277d = 11;

    /* renamed from: e  reason: collision with root package name */
    public static final long f40278e = 281474976710655L;

    public final int a(long j11, long j12) {
        long j13 = j11 * j12;
        long j14 = (j13 * j13) + j13;
        long j15 = (j14 << 32) | (j14 >>> 32);
        long j16 = (j15 * j15) + j12 + j13;
        long j17 = (j16 >>> 32) | (j16 << 32);
        return (int) (((j17 * j17) + j13) >>> 32);
    }

    public final byte[] a(byte[] bArr, int i11, int i12, byte b11, long j11) {
        int i13 = i12 - 1;
        for (int i14 = 0; i14 <= i13; i14++) {
            int abs = Math.abs(a((long) i14, j11));
            if (i14 < i13) {
                int i15 = i11 + i14;
                byte b12 = bArr[i15];
                int i16 = (abs % (i12 - i14)) + i14 + i11;
                bArr[i15] = bArr[i16];
                bArr[i16] = b12;
            }
            int i17 = i11 + i14;
            bArr[i17] = (byte) (bArr[i17] ^ (((b11 + i14) + abs) + 1));
        }
        return bArr;
    }

    public final byte[] a(long j11) {
        f40275b = new AtomicLong(j11);
        Integer[] numArr = new Integer[15];
        int i11 = 0;
        for (int i12 = 0; i12 < 15; i12++) {
            numArr[i12] = Integer.valueOf(f40274a.a());
        }
        int intValue = numArr[0].intValue();
        Iterator it2 = RangesKt___RangesKt.o(1, 5).iterator();
        while (it2.hasNext()) {
            int a11 = ((IntIterator) it2).a() * 3;
            if (numArr[a11].intValue() > intValue) {
                intValue = numArr[a11].intValue();
                i11 = a11;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(12);
        allocate.putInt(numArr[i11].intValue());
        allocate.putInt(numArr[i11 + 1].intValue());
        allocate.putInt(numArr[i11 + 2].intValue());
        return allocate.array();
    }

    public final int a(int i11) {
        long j11;
        long j12;
        AtomicLong atomicLong = f40275b;
        do {
            j11 = atomicLong.get();
            j12 = ((f40276c * j11) + 11) & f40278e;
        } while (!atomicLong.compareAndSet(j11, j12));
        return (int) (j12 >>> (48 - i11));
    }

    public final int a() {
        return a(32);
    }
}
