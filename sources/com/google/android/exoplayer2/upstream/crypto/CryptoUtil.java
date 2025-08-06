package com.google.android.exoplayer2.upstream.crypto;

final class CryptoUtil {
    private CryptoUtil() {
    }

    public static long getFNV64Hash(String str) {
        long j11 = 0;
        if (str == null) {
            return 0;
        }
        for (int i11 = 0; i11 < str.length(); i11++) {
            long charAt = j11 ^ ((long) str.charAt(i11));
            j11 = charAt + (charAt << 1) + (charAt << 4) + (charAt << 5) + (charAt << 7) + (charAt << 8) + (charAt << 40);
        }
        return j11;
    }
}
