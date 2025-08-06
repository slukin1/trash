package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.params.CramerShoupParameters;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.util.BigIntegers;

public class CramerShoupParametersGenerator {
    /* access modifiers changed from: private */
    public static final BigInteger ONE = BigInteger.valueOf(1);
    private int certainty;
    private SecureRandom random;
    private int size;

    public static class ParametersHelper {
        private static final BigInteger TWO = BigInteger.valueOf(2);

        private ParametersHelper() {
        }

        public static BigInteger[] generateSafePrimes(int i11, int i12, SecureRandom secureRandom) {
            BigInteger createRandomPrime;
            BigInteger add;
            int i13 = i11 - 1;
            while (true) {
                createRandomPrime = BigIntegers.createRandomPrime(i13, 2, secureRandom);
                add = createRandomPrime.shiftLeft(1).add(CramerShoupParametersGenerator.ONE);
                if (!add.isProbablePrime(i12) || (i12 > 2 && !createRandomPrime.isProbablePrime(i12))) {
                }
            }
            return new BigInteger[]{add, createRandomPrime};
        }

        public static BigInteger selectGenerator(BigInteger bigInteger, SecureRandom secureRandom) {
            BigInteger modPow;
            BigInteger subtract = bigInteger.subtract(TWO);
            do {
                BigInteger bigInteger2 = TWO;
                modPow = BigIntegers.createRandomInRange(bigInteger2, subtract, secureRandom).modPow(bigInteger2, bigInteger);
            } while (modPow.equals(CramerShoupParametersGenerator.ONE));
            return modPow;
        }
    }

    public CramerShoupParameters generateParameters() {
        BigInteger selectGenerator;
        BigInteger bigInteger = ParametersHelper.generateSafePrimes(this.size, this.certainty, this.random)[1];
        BigInteger selectGenerator2 = ParametersHelper.selectGenerator(bigInteger, this.random);
        do {
            selectGenerator = ParametersHelper.selectGenerator(bigInteger, this.random);
        } while (selectGenerator2.equals(selectGenerator));
        return new CramerShoupParameters(bigInteger, selectGenerator2, selectGenerator, new SHA256Digest());
    }

    public CramerShoupParameters generateParameters(DHParameters dHParameters) {
        BigInteger selectGenerator;
        BigInteger p11 = dHParameters.getP();
        BigInteger g11 = dHParameters.getG();
        do {
            selectGenerator = ParametersHelper.selectGenerator(p11, this.random);
        } while (g11.equals(selectGenerator));
        return new CramerShoupParameters(p11, g11, selectGenerator, new SHA256Digest());
    }

    public void init(int i11, int i12, SecureRandom secureRandom) {
        this.size = i11;
        this.certainty = i12;
        this.random = secureRandom;
    }
}
