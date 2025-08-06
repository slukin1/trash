package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

class DHParametersHelper {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static final BigInteger TWO = BigInteger.valueOf(2);

    public static BigInteger[] generateSafePrimes(int i11, int i12, SecureRandom secureRandom) {
        int i13 = i11 - 1;
        int i14 = i11 >>> 2;
        while (true) {
            BigInteger createRandomPrime = BigIntegers.createRandomPrime(i13, 2, secureRandom);
            BigInteger add = createRandomPrime.shiftLeft(1).add(ONE);
            if (add.isProbablePrime(i12) && ((i12 <= 2 || createRandomPrime.isProbablePrime(i12 - 2)) && WNafUtil.getNafWeight(add) >= i14)) {
                return new BigInteger[]{add, createRandomPrime};
            }
        }
    }

    public static BigInteger selectGenerator(BigInteger bigInteger, BigInteger bigInteger2, SecureRandom secureRandom) {
        BigInteger modPow;
        BigInteger subtract = bigInteger.subtract(TWO);
        do {
            BigInteger bigInteger3 = TWO;
            modPow = BigIntegers.createRandomInRange(bigInteger3, subtract, secureRandom).modPow(bigInteger3, bigInteger);
        } while (modPow.equals(ONE));
        return modPow;
    }
}
