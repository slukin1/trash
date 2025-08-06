package org.bouncycastle.jcajce.provider.asymmetric.util;

public class PrimeCertaintyCalculator {
    private PrimeCertaintyCalculator() {
    }

    public static int getDefaultCertainty(int i11) {
        if (i11 <= 1024) {
            return 80;
        }
        return (((i11 - 1) / 1024) * 16) + 96;
    }
}
