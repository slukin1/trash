package com.google.android.recaptcha.internal;

public final class zzme {
    public static final zzib zza;
    public static final zzib zzb;
    public static final zzib zzc;

    static {
        zzia zzi = zzib.zzi();
        zzi.zze(-315576000000L);
        zzi.zzd(-999999999);
        zza = (zzib) zzi.zzj();
        zzia zzi2 = zzib.zzi();
        zzi2.zze(315576000000L);
        zzi2.zzd(999999999);
        zzb = (zzib) zzi2.zzj();
        zzia zzi3 = zzib.zzi();
        zzi3.zze(0);
        zzi3.zzd(0);
        zzc = (zzib) zzi3.zzj();
    }

    public static zzib zza(long j11) {
        int i11;
        int i12 = (int) (j11 % 1000000000);
        long j12 = j11 / 1000000000;
        if (i12 <= -1000000000 || i12 >= 1000000000) {
            j12 = zzgb.zza(j12, (long) (i12 / 1000000000));
            i12 %= 1000000000;
        }
        if (j12 > 0 && i12 < 0) {
            i12 += 1000000000;
            j12--;
        }
        if (j12 < 0 && i12 > 0) {
            i12 -= 1000000000;
            j12++;
        }
        zzia zzi = zzib.zzi();
        zzi.zze(j12);
        zzi.zzd(i12);
        zzib zzib = (zzib) zzi.zzj();
        long zzg = zzib.zzg();
        int zzf = zzib.zzf();
        if (zzg >= -315576000000L && zzg <= 315576000000L && ((long) zzf) >= -999999999 && zzf < 1000000000 && ((zzg >= 0 && zzf >= 0) || (i11 <= 0 && zzf <= 0))) {
            return zzib;
        }
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[]{Long.valueOf(zzg), Integer.valueOf(zzf)}));
    }
}
