package com.google.android.recaptcha.internal;

public final class zzgb {
    private static final long[][] zza = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public static long zza(long j11, long j12) {
        boolean z11 = true;
        boolean z12 = (j11 ^ j12) < 0;
        long j13 = j11 + j12;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        zzgc.zza(z12 | z11, "checkedAdd", j11, j12);
        return j13;
    }

    public static long zzb(long j11, long j12) {
        boolean z11 = true;
        boolean z12 = (1 ^ j11) >= 0;
        long j13 = -1 + j11;
        if ((j11 ^ j13) < 0) {
            z11 = false;
        }
        zzgc.zza(z12 | z11, "checkedSubtract", j11, 1);
        return j13;
    }
}
