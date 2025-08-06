package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

final class zzaf<T> implements zzae<T> {
    private final Object zza = new Object();
    private final int zzb;
    private final zzw zzc;
    private int zzd;
    private int zze;
    private int zzf;
    private Exception zzg;
    private boolean zzh;

    public zzaf(int i11, zzw zzw) {
        this.zzb = i11;
        this.zzc = zzw;
    }

    private final void zza() {
        if (this.zzd + this.zze + this.zzf != this.zzb) {
            return;
        }
        if (this.zzg != null) {
            zzw zzw = this.zzc;
            int i11 = this.zze;
            int i12 = this.zzb;
            zzw.zza(new ExecutionException(i11 + " out of " + i12 + " underlying tasks failed", this.zzg));
        } else if (this.zzh) {
            this.zzc.zzc();
        } else {
            this.zzc.zzb((Object) null);
        }
    }

    public final void onCanceled() {
        synchronized (this.zza) {
            this.zzf++;
            this.zzh = true;
            zza();
        }
    }

    public final void onFailure(Exception exc) {
        synchronized (this.zza) {
            this.zze++;
            this.zzg = exc;
            zza();
        }
    }

    public final void onSuccess(T t11) {
        synchronized (this.zza) {
            this.zzd++;
            zza();
        }
    }
}
