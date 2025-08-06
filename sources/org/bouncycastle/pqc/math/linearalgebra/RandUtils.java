package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class RandUtils {
    public static int nextInt(SecureRandom secureRandom, int i11) {
        int nextInt;
        int i12;
        if (((-i11) & i11) == i11) {
            return (int) ((((long) i11) * ((long) (secureRandom.nextInt() >>> 1))) >> 31);
        }
        do {
            nextInt = secureRandom.nextInt() >>> 1;
            i12 = nextInt % i11;
        } while ((nextInt - i12) + (i11 - 1) < 0);
        return i12;
    }
}
