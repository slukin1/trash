package com.google.android.recaptcha.internal;

final class zzgc {
    public static void zza(boolean z11, String str, long j11, long j12) {
        if (!z11) {
            throw new ArithmeticException("overflow: " + str + "(" + j11 + ", " + j12 + ")");
        }
    }

    public static void zzb(boolean z11) {
        if (!z11) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
