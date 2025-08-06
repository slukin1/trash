package com.google.android.gms.measurement.internal;

import java.util.Map;

public final /* synthetic */ class zzim implements Runnable {
    public final /* synthetic */ zzin zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ Exception zzc;
    public final /* synthetic */ byte[] zzd;
    public final /* synthetic */ Map zze;

    public /* synthetic */ zzim(zzin zzin, int i11, Exception exc, byte[] bArr, Map map) {
        this.zza = zzin;
        this.zzb = i11;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
