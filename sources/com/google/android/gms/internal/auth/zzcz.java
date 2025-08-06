package com.google.android.gms.internal.auth;

import android.net.Uri;

public final class zzcz {
    public final String zza;
    public final Uri zzb;
    public final String zzc;
    public final String zzd;
    public final boolean zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final zzdg zzi;

    public zzcz(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzdg) null);
    }

    private zzcz(String str, Uri uri, String str2, String str3, boolean z11, boolean z12, boolean z13, boolean z14, zzdg zzdg) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = "";
        this.zzd = "";
        this.zze = z11;
        this.zzf = false;
        this.zzg = z13;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzcz zza() {
        return new zzcz((String) null, this.zzb, this.zzc, this.zzd, this.zze, false, true, false, (zzdg) null);
    }

    public final zzcz zzb() {
        if (this.zzc.isEmpty()) {
            return new zzcz((String) null, this.zzb, this.zzc, this.zzd, true, false, this.zzg, false, (zzdg) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final zzdc zzc(String str, double d11) {
        return new zzcx(this, str, Double.valueOf(0.0d), true);
    }

    public final zzdc zzd(String str, long j11) {
        return new zzcv(this, str, Long.valueOf(j11), true);
    }

    public final zzdc zze(String str, boolean z11) {
        return new zzcw(this, str, Boolean.valueOf(z11), true);
    }

    public final zzdc zzf(String str, Object obj, zzhu zzhu) {
        return new zzcy(this, "getTokenRefactor__blocked_packages", obj, true, zzhu, (byte[]) null);
    }
}
