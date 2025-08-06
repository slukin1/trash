package org.bouncycastle.pqc.crypto.qtesla;

public class QTESLASecurityCategory {
    public static final int PROVABLY_SECURE_I = 5;
    public static final int PROVABLY_SECURE_III = 6;

    private QTESLASecurityCategory() {
    }

    public static String getName(int i11) {
        if (i11 == 5) {
            return "qTESLA-p-I";
        }
        if (i11 == 6) {
            return "qTESLA-p-III";
        }
        throw new IllegalArgumentException("unknown security category: " + i11);
    }

    public static int getPrivateSize(int i11) {
        if (i11 == 5) {
            return QTesla1p.CRYPTO_SECRETKEYBYTES;
        }
        if (i11 == 6) {
            return QTesla3p.CRYPTO_SECRETKEYBYTES;
        }
        throw new IllegalArgumentException("unknown security category: " + i11);
    }

    public static int getPublicSize(int i11) {
        if (i11 == 5) {
            return QTesla1p.CRYPTO_PUBLICKEYBYTES;
        }
        if (i11 == 6) {
            return QTesla3p.CRYPTO_PUBLICKEYBYTES;
        }
        throw new IllegalArgumentException("unknown security category: " + i11);
    }

    public static int getSignatureSize(int i11) {
        if (i11 == 5) {
            return QTesla1p.CRYPTO_BYTES;
        }
        if (i11 == 6) {
            return QTesla3p.CRYPTO_BYTES;
        }
        throw new IllegalArgumentException("unknown security category: " + i11);
    }

    public static void validate(int i11) {
        if (i11 != 5 && i11 != 6) {
            throw new IllegalArgumentException("unknown security category: " + i11);
        }
    }
}
