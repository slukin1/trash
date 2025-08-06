package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.RSAKeyGenerationParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.math.Primes;
import org.bouncycastle.math.ec.WNafUtil;
import org.bouncycastle.util.BigIntegers;

public class RSAKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private RSAKeyGenerationParameters param;

    private static int getNumberOfIterations(int i11, int i12) {
        if (i11 >= 1536) {
            if (i12 <= 100) {
                return 3;
            }
            if (i12 <= 128) {
                return 4;
            }
            return 4 + (((i12 - 128) + 1) / 2);
        } else if (i11 >= 1024) {
            if (i12 <= 100) {
                return 4;
            }
            if (i12 <= 112) {
                return 5;
            }
            return (((i12 - 112) + 1) / 2) + 5;
        } else if (i11 >= 512) {
            if (i12 <= 80) {
                return 5;
            }
            if (i12 <= 100) {
                return 7;
            }
            return (((i12 - 100) + 1) / 2) + 7;
        } else if (i12 <= 80) {
            return 40;
        } else {
            return 40 + (((i12 - 80) + 1) / 2);
        }
    }

    public BigInteger chooseRandomPrime(int i11, BigInteger bigInteger, BigInteger bigInteger2) {
        for (int i12 = 0; i12 != i11 * 5; i12++) {
            BigInteger createRandomPrime = BigIntegers.createRandomPrime(i11, 1, this.param.getRandom());
            BigInteger mod = createRandomPrime.mod(bigInteger);
            BigInteger bigInteger3 = ONE;
            if (!mod.equals(bigInteger3) && createRandomPrime.multiply(createRandomPrime).compareTo(bigInteger2) >= 0 && isProbablePrime(createRandomPrime) && bigInteger.gcd(createRandomPrime.subtract(bigInteger3)).equals(bigInteger3)) {
                return createRandomPrime;
            }
        }
        throw new IllegalStateException("unable to generate prime number for RSA key");
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        BigInteger chooseRandomPrime;
        BigInteger chooseRandomPrime2;
        BigInteger multiply;
        BigInteger bigInteger;
        RSAKeyPairGenerator rSAKeyPairGenerator = this;
        int strength = rSAKeyPairGenerator.param.getStrength();
        int i11 = (strength + 1) / 2;
        int i12 = strength - i11;
        int i13 = strength / 2;
        int i14 = i13 - 100;
        int i15 = strength / 3;
        if (i14 < i15) {
            i14 = i15;
        }
        int i16 = strength >> 2;
        BigInteger pow = BigInteger.valueOf(2).pow(i13);
        BigInteger bigInteger2 = ONE;
        BigInteger shiftLeft = bigInteger2.shiftLeft(strength - 1);
        BigInteger shiftLeft2 = bigInteger2.shiftLeft(i14);
        AsymmetricCipherKeyPair asymmetricCipherKeyPair = null;
        boolean z11 = false;
        while (!z11) {
            BigInteger publicExponent = rSAKeyPairGenerator.param.getPublicExponent();
            do {
                chooseRandomPrime = rSAKeyPairGenerator.chooseRandomPrime(i11, publicExponent, shiftLeft);
                while (true) {
                    chooseRandomPrime2 = rSAKeyPairGenerator.chooseRandomPrime(i12, publicExponent, shiftLeft);
                    BigInteger abs = chooseRandomPrime2.subtract(chooseRandomPrime).abs();
                    if (abs.bitLength() >= i14 && abs.compareTo(shiftLeft2) > 0) {
                        multiply = chooseRandomPrime.multiply(chooseRandomPrime2);
                        if (multiply.bitLength() == strength) {
                            break;
                        }
                        chooseRandomPrime = chooseRandomPrime.max(chooseRandomPrime2);
                    } else {
                        rSAKeyPairGenerator = this;
                        strength = strength;
                    }
                }
            } while (WNafUtil.getNafWeight(multiply) < i16);
            if (chooseRandomPrime.compareTo(chooseRandomPrime2) < 0) {
                bigInteger = chooseRandomPrime2;
                chooseRandomPrime2 = chooseRandomPrime;
            } else {
                bigInteger = chooseRandomPrime;
            }
            BigInteger bigInteger3 = ONE;
            BigInteger subtract = bigInteger.subtract(bigInteger3);
            BigInteger subtract2 = chooseRandomPrime2.subtract(bigInteger3);
            int i17 = strength;
            BigInteger modInverse = publicExponent.modInverse(subtract.divide(subtract.gcd(subtract2)).multiply(subtract2));
            if (modInverse.compareTo(pow) <= 0) {
                rSAKeyPairGenerator = this;
            } else {
                asymmetricCipherKeyPair = new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new RSAKeyParameters(false, multiply, publicExponent, true), (AsymmetricKeyParameter) new RSAPrivateCrtKeyParameters(multiply, publicExponent, modInverse, bigInteger, chooseRandomPrime2, modInverse.remainder(subtract), modInverse.remainder(subtract2), BigIntegers.modOddInverse(bigInteger, chooseRandomPrime2), true));
                rSAKeyPairGenerator = this;
                z11 = true;
            }
            strength = i17;
        }
        return asymmetricCipherKeyPair;
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (RSAKeyGenerationParameters) keyGenerationParameters;
    }

    public boolean isProbablePrime(BigInteger bigInteger) {
        return !Primes.hasAnySmallFactors(bigInteger) && Primes.isMRProbablePrime(bigInteger, this.param.getRandom(), getNumberOfIterations(bigInteger.bitLength(), this.param.getCertainty()));
    }
}
