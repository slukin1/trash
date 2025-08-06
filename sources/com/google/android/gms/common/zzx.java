package com.google.android.gms.common;

import android.util.Log;
import com.google.errorprone.annotations.CheckReturnValue;

@CheckReturnValue
class zzx {
    private static final zzx zze = new zzx(true, 3, 1, (String) null, (Throwable) null);
    public final boolean zza;
    public final String zzb;
    public final Throwable zzc;
    public final int zzd;

    private zzx(boolean z11, int i11, int i12, String str, Throwable th2) {
        this.zza = z11;
        this.zzd = i11;
        this.zzb = str;
        this.zzc = th2;
    }

    public /* synthetic */ zzx(boolean z11, int i11, int i12, String str, Throwable th2, zzw zzw) {
        this(false, 1, 5, (String) null, (Throwable) null);
    }

    @Deprecated
    public static zzx zzb() {
        return zze;
    }

    public static zzx zzc(String str) {
        return new zzx(false, 1, 5, str, (Throwable) null);
    }

    public static zzx zzd(String str, Throwable th2) {
        return new zzx(false, 1, 5, str, th2);
    }

    public static zzx zzf(int i11) {
        return new zzx(true, i11, 1, (String) null, (Throwable) null);
    }

    public static zzx zzg(int i11, int i12, String str, Throwable th2) {
        return new zzx(false, i11, i12, str, th2);
    }

    public String zza() {
        return this.zzb;
    }

    public final void zze() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzc != null) {
                Log.d("GoogleCertificatesRslt", zza(), this.zzc);
            } else {
                Log.d("GoogleCertificatesRslt", zza());
            }
        }
    }
}
