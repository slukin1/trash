package kotlinx.serialization.json.internal;

import kotlin.text.n;

public final /* synthetic */ class q {
    public static /* synthetic */ String a(long j11, int i11) {
        int i12 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i12 == 0) {
            return "0";
        }
        if (i12 > 0) {
            return Long.toString(j11, i11);
        }
        if (i11 < 2 || i11 > 36) {
            i11 = 10;
        }
        int i13 = 64;
        char[] cArr = new char[64];
        int i14 = i11 - 1;
        if ((i11 & i14) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i11);
            do {
                i13--;
                cArr[i13] = Character.forDigit(((int) j11) & i14, i11);
                j11 >>>= numberOfTrailingZeros;
            } while (j11 != 0);
        } else {
            long a11 = (i11 & 1) == 0 ? (j11 >>> 1) / ((long) (i11 >>> 1)) : n.a(j11, (long) i11);
            long j12 = (long) i11;
            i13 = 63;
            cArr[63] = Character.forDigit((int) (j11 - (a11 * j12)), i11);
            while (a11 > 0) {
                i13--;
                cArr[i13] = Character.forDigit((int) (a11 % j12), i11);
                a11 /= j12;
            }
        }
        return new String(cArr, i13, 64 - i13);
    }
}
