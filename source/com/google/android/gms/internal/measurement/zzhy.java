package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class zzhy {
    public final Uri zza;
    public final String zzb;
    public final String zzc;
    public final boolean zzd;
    public final boolean zze;

    public zzhy(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzig) null);
    }

    private zzhy(String str, Uri uri, String str2, String str3, boolean z11, boolean z12, boolean z13, boolean z14, zzig zzig) {
        this.zza = uri;
        this.zzb = "";
        this.zzc = "";
        this.zzd = z11;
        this.zze = z13;
    }

    public final zzhy zza() {
        return new zzhy((String) null, this.zza, this.zzb, this.zzc, this.zzd, false, true, false, (zzig) null);
    }

    public final zzhy zzb() {
        if (this.zzb.isEmpty()) {
            return new zzhy((String) null, this.zza, this.zzb, this.zzc, true, false, this.zze, false, (zzig) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzib zzc(String str, double d11) {
        return new zzhw(this, "measurement.test.double_flag", Double.valueOf(-3.0d), true);
    }

    public final zzib zzd(String str, long j11) {
        return new zzhu(this, str, Long.valueOf(j11), true);
    }

    public final zzib zze(String str, String str2) {
        return new zzhx(this, str, str2, true);
    }

    public final zzib zzf(String str, boolean z11) {
        return new zzhv(this, str, Boolean.valueOf(z11), true);
    }
}
