package kotlin.random;

import a10.a;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.ranges.h;

public abstract class Random {
    public static final Default Default = new Default((r) null);
    /* access modifiers changed from: private */
    public static final Random defaultRandom = a.f53446a.b();

    public static final class Default extends Random implements Serializable {

        public static final class Serialized implements Serializable {
            public static final Serialized INSTANCE = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.Default;
            }
        }

        private Default() {
        }

        public /* synthetic */ Default(r rVar) {
            this();
        }

        private final Object writeReplace() {
            return Serialized.INSTANCE;
        }

        public int nextBits(int i11) {
            return Random.defaultRandom.nextBits(i11);
        }

        public boolean nextBoolean() {
            return Random.defaultRandom.nextBoolean();
        }

        public byte[] nextBytes(byte[] bArr) {
            return Random.defaultRandom.nextBytes(bArr);
        }

        public double nextDouble() {
            return Random.defaultRandom.nextDouble();
        }

        public float nextFloat() {
            return Random.defaultRandom.nextFloat();
        }

        public int nextInt() {
            return Random.defaultRandom.nextInt();
        }

        public long nextLong() {
            return Random.defaultRandom.nextLong();
        }

        public byte[] nextBytes(int i11) {
            return Random.defaultRandom.nextBytes(i11);
        }

        public double nextDouble(double d11) {
            return Random.defaultRandom.nextDouble(d11);
        }

        public int nextInt(int i11) {
            return Random.defaultRandom.nextInt(i11);
        }

        public long nextLong(long j11) {
            return Random.defaultRandom.nextLong(j11);
        }

        public byte[] nextBytes(byte[] bArr, int i11, int i12) {
            return Random.defaultRandom.nextBytes(bArr, i11, i12);
        }

        public double nextDouble(double d11, double d12) {
            return Random.defaultRandom.nextDouble(d11, d12);
        }

        public int nextInt(int i11, int i12) {
            return Random.defaultRandom.nextInt(i11, i12);
        }

        public long nextLong(long j11, long j12) {
            return Random.defaultRandom.nextLong(j11, j12);
        }
    }

    public static /* synthetic */ byte[] nextBytes$default(Random random, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if (obj == null) {
            if ((i13 & 2) != 0) {
                i11 = 0;
            }
            if ((i13 & 4) != 0) {
                i12 = bArr.length;
            }
            return random.nextBytes(bArr, i11, i12);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
    }

    public abstract int nextBits(int i11);

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    public byte[] nextBytes(byte[] bArr, int i11, int i12) {
        boolean z11 = true;
        if (new h(0, bArr.length).h(i11) && new h(0, bArr.length).h(i12)) {
            if (i11 > i12) {
                z11 = false;
            }
            if (z11) {
                int i13 = (i12 - i11) / 4;
                for (int i14 = 0; i14 < i13; i14++) {
                    int nextInt = nextInt();
                    bArr[i11] = (byte) nextInt;
                    bArr[i11 + 1] = (byte) (nextInt >>> 8);
                    bArr[i11 + 2] = (byte) (nextInt >>> 16);
                    bArr[i11 + 3] = (byte) (nextInt >>> 24);
                    i11 += 4;
                }
                int i15 = i12 - i11;
                int nextBits = nextBits(i15 * 8);
                for (int i16 = 0; i16 < i15; i16++) {
                    bArr[i11 + i16] = (byte) (nextBits >>> (i16 * 8));
                }
                return bArr;
            }
            throw new IllegalArgumentException(("fromIndex (" + i11 + ") must be not greater than toIndex (" + i12 + ").").toString());
        }
        throw new IllegalArgumentException(("fromIndex (" + i11 + ") or toIndex (" + i12 + ") are out of range: 0.." + bArr.length + '.').toString());
    }

    public double nextDouble() {
        return a.a(nextBits(26), nextBits(27));
    }

    public float nextFloat() {
        return ((float) nextBits(24)) / 1.6777216E7f;
    }

    public int nextInt() {
        return nextBits(32);
    }

    public long nextLong() {
        return (((long) nextInt()) << 32) + ((long) nextInt());
    }

    public double nextDouble(double d11) {
        return nextDouble(0.0d, d11);
    }

    public int nextInt(int i11) {
        return nextInt(0, i11);
    }

    public long nextLong(long j11) {
        return nextLong(0, j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public double nextDouble(double r7, double r9) {
        /*
            r6 = this;
            kotlin.random.b.b(r7, r9)
            double r0 = r9 - r7
            boolean r2 = java.lang.Double.isInfinite(r0)
            if (r2 == 0) goto L_0x003d
            boolean r2 = java.lang.Double.isInfinite(r7)
            r3 = 1
            r4 = 0
            if (r2 != 0) goto L_0x001b
            boolean r2 = java.lang.Double.isNaN(r7)
            if (r2 != 0) goto L_0x001b
            r2 = r3
            goto L_0x001c
        L_0x001b:
            r2 = r4
        L_0x001c:
            if (r2 == 0) goto L_0x003d
            boolean r2 = java.lang.Double.isInfinite(r9)
            if (r2 != 0) goto L_0x002b
            boolean r2 = java.lang.Double.isNaN(r9)
            if (r2 != 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r3 = r4
        L_0x002c:
            if (r3 == 0) goto L_0x003d
            double r0 = r6.nextDouble()
            r2 = 2
            double r2 = (double) r2
            double r4 = r9 / r2
            double r2 = r7 / r2
            double r4 = r4 - r2
            double r0 = r0 * r4
            double r7 = r7 + r0
            double r7 = r7 + r0
            goto L_0x0043
        L_0x003d:
            double r2 = r6.nextDouble()
            double r2 = r2 * r0
            double r7 = r7 + r2
        L_0x0043:
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 < 0) goto L_0x004d
            r7 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            double r7 = java.lang.Math.nextAfter(r9, r7)
        L_0x004d:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.random.Random.nextDouble(double, double):double");
    }

    public int nextInt(int i11, int i12) {
        int i13;
        int nextInt;
        int i14;
        int nextInt2;
        boolean z11;
        b.c(i11, i12);
        int i15 = i12 - i11;
        if (i15 > 0 || i15 == Integer.MIN_VALUE) {
            if (((-i15) & i15) == i15) {
                i13 = nextBits(b.e(i15));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i14 = nextInt % i15;
                } while ((nextInt - i14) + (i15 - 1) < 0);
                i13 = i14;
            }
            return i11 + i13;
        }
        do {
            nextInt2 = nextInt();
            z11 = false;
            if (i11 <= nextInt2 && nextInt2 < i12) {
                z11 = true;
                continue;
            }
        } while (!z11);
        return nextInt2;
    }

    public long nextLong(long j11, long j12) {
        long nextLong;
        boolean z11;
        long j13;
        long nextLong2;
        long j14;
        int nextInt;
        b.d(j11, j12);
        long j15 = j12 - j11;
        if (j15 > 0) {
            if (((-j15) & j15) == j15) {
                int i11 = (int) j15;
                int i12 = (int) (j15 >>> 32);
                if (i11 != 0) {
                    nextInt = nextBits(b.e(i11));
                } else if (i12 == 1) {
                    nextInt = nextInt();
                } else {
                    j13 = (((long) nextBits(b.e(i12))) << 32) + (((long) nextInt()) & 4294967295L);
                }
                j13 = ((long) nextInt) & 4294967295L;
            } else {
                do {
                    nextLong2 = nextLong() >>> 1;
                    j14 = nextLong2 % j15;
                } while ((nextLong2 - j14) + (j15 - 1) < 0);
                j13 = j14;
            }
            return j11 + j13;
        }
        do {
            nextLong = nextLong();
            z11 = false;
            if (j11 <= nextLong && nextLong < j12) {
                z11 = true;
                continue;
            }
        } while (!z11);
        return nextLong;
    }

    public byte[] nextBytes(byte[] bArr) {
        return nextBytes(bArr, 0, bArr.length);
    }

    public byte[] nextBytes(int i11) {
        return nextBytes(new byte[i11]);
    }
}
