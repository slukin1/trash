package org.bouncycastle.crypto.generators;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.jumio.analytics.MobileEvents;
import com.tencent.thumbplayer.tcmedia.api.TPOptionalID;
import com.tencent.thumbplayer.tcmedia.core.common.TPPixelFormat;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Vector;
import okhttp3.internal.http.StatusLine;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.NaccacheSternKeyGenerationParameters;
import org.bouncycastle.crypto.params.NaccacheSternKeyParameters;
import org.bouncycastle.crypto.params.NaccacheSternPrivateKeyParameters;
import org.bouncycastle.util.BigIntegers;

public class NaccacheSternKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private static final BigInteger ONE = BigInteger.valueOf(1);
    private static int[] smallPrimes = {3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, TPPixelFormat.TP_PIX_FMT_MEDIACODEC, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311, 313, MobileEvents.EVENTTYPE_MISC, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, StatusLine.HTTP_MISDIRECTED_REQUEST, 431, 433, 439, PsExtractor.SYSTEM_HEADER_START_CODE, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, TPOptionalID.OPTION_ID_GLOBAL_BOOL_ENABLE_MULTI_NETWORK_CARD, 521, 523, 541, 547, 557};
    private NaccacheSternKeyGenerationParameters param;

    private static Vector findFirstPrimes(int i11) {
        Vector vector = new Vector(i11);
        for (int i12 = 0; i12 != i11; i12++) {
            vector.addElement(BigInteger.valueOf((long) smallPrimes[i12]));
        }
        return vector;
    }

    private static BigInteger generatePrime(int i11, int i12, SecureRandom secureRandom) {
        BigInteger createRandomPrime;
        do {
            createRandomPrime = BigIntegers.createRandomPrime(i11, i12, secureRandom);
        } while (createRandomPrime.bitLength() != i11);
        return createRandomPrime;
    }

    private static int getInt(SecureRandom secureRandom, int i11) {
        int nextInt;
        int i12;
        if (((-i11) & i11) == i11) {
            return (int) ((((long) i11) * ((long) (secureRandom.nextInt() & Integer.MAX_VALUE))) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() & Integer.MAX_VALUE;
            i12 = nextInt % i11;
        } while ((nextInt - i12) + (i11 - 1) < 0);
        return i12;
    }

    private static Vector permuteList(Vector vector, SecureRandom secureRandom) {
        Vector vector2 = new Vector();
        Vector vector3 = new Vector();
        for (int i11 = 0; i11 < vector.size(); i11++) {
            vector3.addElement(vector.elementAt(i11));
        }
        vector2.addElement(vector3.elementAt(0));
        while (true) {
            vector3.removeElementAt(0);
            if (vector3.size() == 0) {
                return vector2;
            }
            vector2.insertElementAt(vector3.elementAt(0), getInt(secureRandom, vector2.size() + 1));
        }
    }

    public AsymmetricCipherKeyPair generateKeyPair() {
        long j11;
        BigInteger generatePrime;
        BigInteger add;
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger generatePrime2;
        BigInteger bigInteger3;
        BigInteger add2;
        BigInteger bigInteger4;
        BigInteger bigInteger5;
        BigInteger bigInteger6;
        BigInteger bigInteger7;
        boolean z11;
        int i11;
        BigInteger bigInteger8;
        BigInteger bigInteger9;
        PrintStream printStream;
        StringBuilder sb2;
        String str;
        long j12;
        BigInteger createRandomPrime;
        int i12;
        int strength = this.param.getStrength();
        SecureRandom random = this.param.getRandom();
        int certainty = this.param.getCertainty();
        boolean isDebug = this.param.isDebug();
        if (isDebug) {
            PrintStream printStream2 = System.out;
            printStream2.println("Fetching first " + this.param.getCntSmallPrimes() + " primes.");
        }
        Vector permuteList = permuteList(findFirstPrimes(this.param.getCntSmallPrimes()), random);
        BigInteger bigInteger10 = ONE;
        BigInteger bigInteger11 = bigInteger10;
        for (int i13 = 0; i13 < permuteList.size() / 2; i13++) {
            bigInteger11 = bigInteger11.multiply((BigInteger) permuteList.elementAt(i13));
        }
        for (int size = permuteList.size() / 2; size < permuteList.size(); size++) {
            bigInteger10 = bigInteger10.multiply((BigInteger) permuteList.elementAt(size));
        }
        BigInteger multiply = bigInteger11.multiply(bigInteger10);
        int bitLength = (((strength - multiply.bitLength()) - 48) / 2) + 1;
        BigInteger generatePrime3 = generatePrime(bitLength, certainty, random);
        BigInteger generatePrime4 = generatePrime(bitLength, certainty, random);
        if (isDebug) {
            System.out.println("generating p and q");
        }
        BigInteger shiftLeft = generatePrime3.multiply(bigInteger11).shiftLeft(1);
        BigInteger shiftLeft2 = generatePrime4.multiply(bigInteger10).shiftLeft(1);
        long j13 = 0;
        while (true) {
            j11 = j13 + 1;
            generatePrime = generatePrime(24, certainty, random);
            add = generatePrime.multiply(shiftLeft).add(ONE);
            if (!add.isProbablePrime(certainty)) {
                bigInteger2 = shiftLeft2;
                bigInteger = shiftLeft;
            } else {
                while (true) {
                    do {
                        generatePrime2 = generatePrime(24, certainty, random);
                    } while (generatePrime.equals(generatePrime2));
                    BigInteger multiply2 = generatePrime2.multiply(shiftLeft2);
                    bigInteger2 = shiftLeft2;
                    bigInteger3 = ONE;
                    add2 = multiply2.add(bigInteger3);
                    if (add2.isProbablePrime(certainty)) {
                        break;
                    }
                    shiftLeft2 = bigInteger2;
                }
                bigInteger = shiftLeft;
                if (multiply.gcd(generatePrime.multiply(generatePrime2)).equals(bigInteger3)) {
                    if (add.multiply(add2).bitLength() >= strength) {
                        break;
                    } else if (isDebug) {
                        PrintStream printStream3 = System.out;
                        printStream3.println("key size too small. Should be " + strength + " but is actually " + add.multiply(add2).bitLength());
                    }
                } else {
                    continue;
                }
            }
            j13 = j11;
            shiftLeft2 = bigInteger2;
            shiftLeft = bigInteger;
        }
        BigInteger bigInteger12 = generatePrime4;
        if (isDebug) {
            PrintStream printStream4 = System.out;
            bigInteger4 = generatePrime3;
            printStream4.println("needed " + j11 + " tries to generate p and q.");
        } else {
            bigInteger4 = generatePrime3;
        }
        BigInteger multiply3 = add.multiply(add2);
        BigInteger multiply4 = add.subtract(bigInteger3).multiply(add2.subtract(bigInteger3));
        if (isDebug) {
            System.out.println("generating g");
        }
        long j14 = 0;
        while (true) {
            Vector vector = new Vector();
            bigInteger5 = add;
            bigInteger6 = add2;
            int i14 = 0;
            while (i14 != permuteList.size()) {
                BigInteger divide = multiply4.divide((BigInteger) permuteList.elementAt(i14));
                while (true) {
                    j12 = j14 + 1;
                    createRandomPrime = BigIntegers.createRandomPrime(strength, certainty, random);
                    i12 = strength;
                    if (!createRandomPrime.modPow(divide, multiply3).equals(ONE)) {
                        break;
                    }
                    j14 = j12;
                    strength = i12;
                }
                vector.addElement(createRandomPrime);
                i14++;
                j14 = j12;
                strength = i12;
            }
            int i15 = strength;
            bigInteger7 = ONE;
            int i16 = 0;
            while (i16 < permuteList.size()) {
                bigInteger7 = bigInteger7.multiply(((BigInteger) vector.elementAt(i16)).modPow(multiply.divide((BigInteger) permuteList.elementAt(i16)), multiply3)).mod(multiply3);
                i16++;
                random = random;
            }
            SecureRandom secureRandom = random;
            int i17 = 0;
            while (true) {
                if (i17 >= permuteList.size()) {
                    z11 = false;
                    break;
                } else if (bigInteger7.modPow(multiply4.divide((BigInteger) permuteList.elementAt(i17)), multiply3).equals(ONE)) {
                    if (isDebug) {
                        PrintStream printStream5 = System.out;
                        printStream5.println("g has order phi(n)/" + permuteList.elementAt(i17) + "\n g: " + bigInteger7);
                    }
                    z11 = true;
                } else {
                    i17++;
                }
            }
            if (!z11) {
                BigInteger modPow = bigInteger7.modPow(multiply4.divide(BigInteger.valueOf(4)), multiply3);
                BigInteger bigInteger13 = ONE;
                if (modPow.equals(bigInteger13)) {
                    if (isDebug) {
                        printStream = System.out;
                        sb2 = new StringBuilder();
                        str = "g has order phi(n)/4\n g:";
                    }
                } else if (bigInteger7.modPow(multiply4.divide(generatePrime), multiply3).equals(bigInteger13)) {
                    if (isDebug) {
                        printStream = System.out;
                        sb2 = new StringBuilder();
                        str = "g has order phi(n)/p'\n g: ";
                    }
                } else if (!bigInteger7.modPow(multiply4.divide(generatePrime2), multiply3).equals(bigInteger13)) {
                    bigInteger9 = bigInteger4;
                    if (!bigInteger7.modPow(multiply4.divide(bigInteger9), multiply3).equals(bigInteger13)) {
                        bigInteger8 = bigInteger12;
                        if (!bigInteger7.modPow(multiply4.divide(bigInteger8), multiply3).equals(bigInteger13)) {
                            break;
                        } else if (isDebug) {
                            PrintStream printStream6 = System.out;
                            StringBuilder sb3 = new StringBuilder();
                            i11 = certainty;
                            sb3.append("g has order phi(n)/b\n g: ");
                            sb3.append(bigInteger7);
                            printStream6.println(sb3.toString());
                            bigInteger4 = bigInteger9;
                            certainty = i11;
                            add2 = bigInteger6;
                            add = bigInteger5;
                            strength = i15;
                            random = secureRandom;
                            bigInteger12 = bigInteger8;
                        }
                    } else {
                        if (isDebug) {
                            PrintStream printStream7 = System.out;
                            printStream7.println("g has order phi(n)/a\n g: " + bigInteger7);
                        }
                        bigInteger8 = bigInteger12;
                    }
                    i11 = certainty;
                    bigInteger4 = bigInteger9;
                    certainty = i11;
                    add2 = bigInteger6;
                    add = bigInteger5;
                    strength = i15;
                    random = secureRandom;
                    bigInteger12 = bigInteger8;
                } else if (isDebug) {
                    printStream = System.out;
                    sb2 = new StringBuilder();
                    str = "g has order phi(n)/q'\n g: ";
                }
                sb2.append(str);
                sb2.append(bigInteger7);
                printStream.println(sb2.toString());
            }
            bigInteger8 = bigInteger12;
            bigInteger9 = bigInteger4;
            i11 = certainty;
            bigInteger4 = bigInteger9;
            certainty = i11;
            add2 = bigInteger6;
            add = bigInteger5;
            strength = i15;
            random = secureRandom;
            bigInteger12 = bigInteger8;
        }
        if (isDebug) {
            PrintStream printStream8 = System.out;
            printStream8.println("needed " + j14 + " tries to generate g");
            System.out.println();
            System.out.println("found new NaccacheStern cipher variables:");
            PrintStream printStream9 = System.out;
            printStream9.println("smallPrimes: " + permuteList);
            PrintStream printStream10 = System.out;
            printStream10.println("sigma:...... " + multiply + " (" + multiply.bitLength() + " bits)");
            PrintStream printStream11 = System.out;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("a:.......... ");
            sb4.append(bigInteger9);
            printStream11.println(sb4.toString());
            PrintStream printStream12 = System.out;
            printStream12.println("b:.......... " + bigInteger8);
            PrintStream printStream13 = System.out;
            printStream13.println("p':......... " + generatePrime);
            PrintStream printStream14 = System.out;
            printStream14.println("q':......... " + generatePrime2);
            PrintStream printStream15 = System.out;
            printStream15.println("p:.......... " + bigInteger5);
            PrintStream printStream16 = System.out;
            printStream16.println("q:.......... " + bigInteger6);
            PrintStream printStream17 = System.out;
            printStream17.println("n:.......... " + multiply3);
            PrintStream printStream18 = System.out;
            printStream18.println("phi(n):..... " + multiply4);
            PrintStream printStream19 = System.out;
            printStream19.println("g:.......... " + bigInteger7);
            System.out.println();
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NaccacheSternKeyParameters(false, bigInteger7, multiply3, multiply.bitLength()), (AsymmetricKeyParameter) new NaccacheSternPrivateKeyParameters(bigInteger7, multiply3, multiply.bitLength(), permuteList, multiply4));
    }

    public void init(KeyGenerationParameters keyGenerationParameters) {
        this.param = (NaccacheSternKeyGenerationParameters) keyGenerationParameters;
    }
}
