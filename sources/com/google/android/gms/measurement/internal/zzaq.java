package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzaq {
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final long zzf;
    public final long zzg;
    public final Long zzh;
    public final Long zzi;
    public final Long zzj;
    public final Boolean zzk;

    public zzaq(String str, String str2, long j11, long j12, long j13, long j14, long j15, Long l11, Long l12, Long l13, Boolean bool) {
        long j16 = j11;
        long j17 = j12;
        long j18 = j13;
        long j19 = j15;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        boolean z11 = true;
        Preconditions.checkArgument(j16 >= 0);
        Preconditions.checkArgument(j17 >= 0);
        Preconditions.checkArgument(j18 >= 0);
        Preconditions.checkArgument(j19 < 0 ? false : z11);
        this.zza = str;
        this.zzb = str2;
        this.zzc = j16;
        this.zzd = j17;
        this.zze = j18;
        this.zzf = j14;
        this.zzg = j19;
        this.zzh = l11;
        this.zzi = l12;
        this.zzj = l13;
        this.zzk = bool;
    }

    public final zzaq zza(Long l11, Long l12, Boolean bool) {
        if (bool != null) {
            bool.booleanValue();
        }
        return new zzaq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l11, l12, bool);
    }

    public final zzaq zzb(long j11, long j12) {
        return new zzaq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, j11, Long.valueOf(j12), this.zzi, this.zzj, this.zzk);
    }

    public final zzaq zzc(long j11) {
        return new zzaq(this.zza, this.zzb, this.zzc, this.zzd, this.zze, j11, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
    }
}
