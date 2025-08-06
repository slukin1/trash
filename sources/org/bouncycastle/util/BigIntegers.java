package org.bouncycastle.util;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;

public final class BigIntegers {
    private static final int MAX_ITERATIONS = 1000;
    private static final int MAX_SMALL = BigInteger.valueOf(743).bitLength();
    public static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
    private static final BigInteger THREE = BigInteger.valueOf(3);
    public static final BigInteger TWO = BigInteger.valueOf(2);
    public static final BigInteger ZERO = BigInteger.valueOf(0);

    public static class Cache {
        private final BigInteger[] preserve = new BigInteger[8];
        private int preserveCounter = 0;
        private final Map<BigInteger, Boolean> values = new WeakHashMap();

        public synchronized void add(BigInteger bigInteger) {
            this.values.put(bigInteger, Boolean.TRUE);
            BigInteger[] bigIntegerArr = this.preserve;
            int i11 = this.preserveCounter;
            bigIntegerArr[i11] = bigInteger;
            this.preserveCounter = (i11 + 1) % bigIntegerArr.length;
        }

        public synchronized void clear() {
            this.values.clear();
            int i11 = 0;
            while (true) {
                BigInteger[] bigIntegerArr = this.preserve;
                if (i11 != bigIntegerArr.length) {
                    bigIntegerArr[i11] = null;
                    i11++;
                }
            }
        }

        public synchronized boolean contains(BigInteger bigInteger) {
            return this.values.containsKey(bigInteger);
        }

        public synchronized int size() {
            return this.values.size();
        }
    }

    public static void asUnsignedByteArray(BigInteger bigInteger, byte[] bArr, int i11, int i12) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i12) {
            System.arraycopy(byteArray, 0, bArr, i11, i12);
            return;
        }
        int i13 = 1;
        if (byteArray[0] != 0 || byteArray.length == 1) {
            i13 = 0;
        }
        int length = byteArray.length - i13;
        if (length <= i12) {
            int i14 = (i12 - length) + i11;
            Arrays.fill(bArr, i11, i14, (byte) 0);
            System.arraycopy(byteArray, i13, bArr, i14, length);
            return;
        }
        throw new IllegalArgumentException("standard length exceeded for value");
    }

    public static byte[] asUnsignedByteArray(int i11, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length == i11) {
            return byteArray;
        }
        int i12 = 0;
        if (byteArray[0] == 0 && byteArray.length != 1) {
            i12 = 1;
        }
        int length = byteArray.length - i12;
        if (length <= i11) {
            byte[] bArr = new byte[i11];
            System.arraycopy(byteArray, i12, bArr, i11 - length, length);
            return bArr;
        }
        throw new IllegalArgumentException("standard length exceeded for value");
    }

    public static byte[] asUnsignedByteArray(BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray[0] != 0 || byteArray.length == 1) {
            return byteArray;
        }
        int length = byteArray.length - 1;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 1, bArr, 0, length);
        return bArr;
    }

    public static byte byteValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 7) {
            return bigInteger.byteValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }

    private static byte[] createRandom(int i11, SecureRandom secureRandom) throws IllegalArgumentException {
        if (i11 >= 1) {
            int i12 = (i11 + 7) / 8;
            byte[] bArr = new byte[i12];
            secureRandom.nextBytes(bArr);
            bArr[0] = (byte) (bArr[0] & ((byte) (255 >>> ((i12 * 8) - i11))));
            return bArr;
        }
        throw new IllegalArgumentException("bitLength must be at least 1");
    }

    public static BigInteger createRandomBigInteger(int i11, SecureRandom secureRandom) {
        return new BigInteger(1, createRandom(i11, secureRandom));
    }

    public static BigInteger createRandomInRange(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger createRandomBigInteger;
        int compareTo = bigInteger.compareTo(bigInteger2);
        if (compareTo < 0) {
            if (bigInteger.bitLength() > bigInteger2.bitLength() / 2) {
                createRandomBigInteger = createRandomInRange(ZERO, bigInteger2.subtract(bigInteger), secureRandom);
            } else {
                for (int i11 = 0; i11 < 1000; i11++) {
                    BigInteger createRandomBigInteger2 = createRandomBigInteger(bigInteger2.bitLength(), secureRandom);
                    if (createRandomBigInteger2.compareTo(bigInteger) >= 0 && createRandomBigInteger2.compareTo(bigInteger2) <= 0) {
                        return createRandomBigInteger2;
                    }
                }
                createRandomBigInteger = createRandomBigInteger(bigInteger2.subtract(bigInteger).bitLength() - 1, secureRandom);
            }
            return createRandomBigInteger.add(bigInteger);
        } else if (compareTo <= 0) {
            return bigInteger;
        } else {
            throw new IllegalArgumentException("'min' may not be greater than 'max'");
        }
    }

    public static BigInteger createRandomPrime(int i11, int i12, SecureRandom secureRandom) {
        BigInteger bigInteger;
        if (i11 < 2) {
            throw new IllegalArgumentException("bitLength < 2");
        } else if (i11 == 2) {
            return secureRandom.nextInt() < 0 ? TWO : THREE;
        } else {
            do {
                byte[] createRandom = createRandom(i11, secureRandom);
                createRandom[0] = (byte) (((byte) (1 << (7 - ((createRandom.length * 8) - i11)))) | createRandom[0]);
                int length = createRandom.length - 1;
                createRandom[length] = (byte) (createRandom[length] | 1);
                bigInteger = new BigInteger(1, createRandom);
                if (i11 > MAX_SMALL) {
                    while (!bigInteger.gcd(SMALL_PRIMES_PRODUCT).equals(ONE)) {
                        bigInteger = bigInteger.add(TWO);
                    }
                }
            } while (!bigInteger.isProbablePrime(i12));
            return bigInteger;
        }
    }

    public static BigInteger fromUnsignedByteArray(byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public static BigInteger fromUnsignedByteArray(byte[] bArr, int i11, int i12) {
        if (!(i11 == 0 && i12 == bArr.length)) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            bArr = bArr2;
        }
        return new BigInteger(1, bArr);
    }

    public static int getUnsignedByteLength(BigInteger bigInteger) {
        if (bigInteger.equals(ZERO)) {
            return 1;
        }
        return (bigInteger.bitLength() + 7) / 8;
    }

    public static int intValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 31) {
            return bigInteger.intValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }

    public static long longValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return bigInteger.longValue();
        }
        throw new ArithmeticException("BigInteger out of long range");
    }

    public static BigInteger modOddInverse(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger.testBit(0)) {
            throw new IllegalArgumentException("'M' must be odd");
        } else if (bigInteger.signum() == 1) {
            if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
                bigInteger2 = bigInteger2.mod(bigInteger);
            }
            int bitLength = bigInteger.bitLength();
            int[] fromBigInteger = Nat.fromBigInteger(bitLength, bigInteger);
            int[] fromBigInteger2 = Nat.fromBigInteger(bitLength, bigInteger2);
            int length = fromBigInteger.length;
            int[] create = Nat.create(length);
            if (Mod.modOddInverse(fromBigInteger, fromBigInteger2, create) != 0) {
                return Nat.toBigInteger(length, create);
            }
            throw new ArithmeticException("BigInteger not invertible.");
        } else {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
    }

    public static BigInteger modOddInverseVar(BigInteger bigInteger, BigInteger bigInteger2) {
        if (!bigInteger.testBit(0)) {
            throw new IllegalArgumentException("'M' must be odd");
        } else if (bigInteger.signum() == 1) {
            BigInteger bigInteger3 = ONE;
            if (bigInteger.equals(bigInteger3)) {
                return ZERO;
            }
            if (bigInteger2.signum() < 0 || bigInteger2.compareTo(bigInteger) >= 0) {
                bigInteger2 = bigInteger2.mod(bigInteger);
            }
            if (bigInteger2.equals(bigInteger3)) {
                return bigInteger3;
            }
            int bitLength = bigInteger.bitLength();
            int[] fromBigInteger = Nat.fromBigInteger(bitLength, bigInteger);
            int[] fromBigInteger2 = Nat.fromBigInteger(bitLength, bigInteger2);
            int length = fromBigInteger.length;
            int[] create = Nat.create(length);
            if (Mod.modOddInverseVar(fromBigInteger, fromBigInteger2, create)) {
                return Nat.toBigInteger(length, create);
            }
            throw new ArithmeticException("BigInteger not invertible.");
        } else {
            throw new ArithmeticException("BigInteger: modulus not positive");
        }
    }

    public static short shortValueExact(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 15) {
            return bigInteger.shortValue();
        }
        throw new ArithmeticException("BigInteger out of int range");
    }
}
