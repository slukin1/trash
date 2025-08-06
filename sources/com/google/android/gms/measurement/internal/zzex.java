package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Map;

final class zzex implements Runnable {
    private final zzev zza;
    private final int zzb;
    private final Throwable zzc;
    private final byte[] zzd;
    private final String zze;
    private final Map zzf;

    public /* synthetic */ zzex(String str, zzev zzev, int i11, Throwable th2, byte[] bArr, Map map, zzew zzew) {
        Preconditions.checkNotNull(zzev);
        this.zza = zzev;
        this.zzb = i11;
        this.zzc = th2;
        this.zzd = bArr;
        this.zze = str;
        this.zzf = map;
    }

    public final void run() {
        this.zza.zza(this.zze, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
